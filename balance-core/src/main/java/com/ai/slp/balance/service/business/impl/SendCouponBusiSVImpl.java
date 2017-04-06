package com.ai.slp.balance.service.business.impl;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.FreezeCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.FunDiscountCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouCountRequest;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.SendCouponRequest;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.FunActivity;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCouponRel;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCouponRelCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplateCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCoupon;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunActivityCouponRelMapper;
import com.ai.slp.balance.dao.mapper.interfaces.FunActivityMapper;
import com.ai.slp.balance.dao.mapper.interfaces.FunCouponTemplateMapper;
import com.ai.slp.balance.dao.mapper.interfaces.FunDiscountCouponMapper;
import com.ai.slp.balance.service.atom.interfaces.IDiscountCouponAtomSV;
import com.ai.slp.balance.service.business.interfaces.ISendCouponBusiSV;
@Service
@Transactional
public class SendCouponBusiSVImpl implements ISendCouponBusiSV {
	private static final Logger LOG = LogManager.getLogger(SendCouponBusiSVImpl.class);
	
	@Autowired
	private IDiscountCouponAtomSV discountCouponAtomSV;
	
	/**
	 * 新用户注册发送/领取优惠券
	 */
	@Override
	public void registerSendCoupon(SendCouponRequest param) throws BusinessException, SystemException {
		 LOG.debug("注册发送优惠券"); 
		//从serial中取出需要的字段
		FunActivityCriteria funActivityCriteria = new FunActivityCriteria();
		FunActivityCriteria.Criteria faCriteria = funActivityCriteria.createCriteria();
		faCriteria.andActivityNameEqualTo(param.getActivityName());
		FunActivityMapper fcMapper = MapperFactory.getFunActivityMapper();
        List<FunActivity> funActivitys = fcMapper.selectByExample(funActivityCriteria);
        if (!CollectionUtil.isEmpty(funActivitys)){
        	for (int i=0;i<funActivitys.size();i++){
        		FunActivity funActivity = new FunActivity();
                BeanUtils.copyProperties(funActivity,funActivitys.get(i));
                
                FunActivityCouponRelCriteria funActivityCouponRelCriteria = new FunActivityCouponRelCriteria();
                FunActivityCouponRelCriteria.Criteria facCriteria = funActivityCouponRelCriteria.createCriteria();
                facCriteria.andActivityIdEqualTo(funActivity.getActivityId());
                FunActivityCouponRelMapper facrMapper = MapperFactory.getFunActivityCouponRelMapper();
                List<FunActivityCouponRel> funActivityCouponRels = facrMapper.selectByExample(funActivityCouponRelCriteria);
                FunActivityCouponRel funActivityCouponRel=new FunActivityCouponRel();
                BeanUtils.copyProperties(funActivityCouponRel,funActivityCouponRels.get(0));
                
                FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
                FunCouponTemplateCriteria.Criteria fatCriteria = funCouponTemplateCriteria.createCriteria();
                fatCriteria.andTemplateIdEqualTo(funActivityCouponRel.getTemplateId());
                FunCouponTemplateMapper fctMapper = MapperFactory.getFunCouponTemplateMapper();
                List<FunCouponTemplate> funCouponTemplates = fctMapper.selectByExample(funCouponTemplateCriteria);
                FunCouponTemplate funCouponTemplate=new FunCouponTemplate();
                BeanUtils.copyProperties(funCouponTemplate,funCouponTemplates.get(0));
                
                FunDiscountCoupon funDiscountCoupon = new FunDiscountCoupon();
                //funActivity;funCouponTemplate
                
                String couponId = SeqUtil.getNewId(SeqConstants.FUN_DISCOUNT_COUPON$COUPON_ID).toString();
                funDiscountCoupon.setCouponId(couponId);
                funDiscountCoupon.setAccountId(funActivity.getActivityId());
                funDiscountCoupon.setCouponName(funCouponTemplate.getCouponName());
                funDiscountCoupon.setCouponDesc(funCouponTemplate.getCouponDesc());
                funDiscountCoupon.setTemplateId(funCouponTemplate.getTemplateId());
                funDiscountCoupon.setFaceValue(funCouponTemplate.getFaceValue());
                funDiscountCoupon.setCurrencyUnit(funCouponTemplate.getCurrencyUnit());
                funDiscountCoupon.setCouponUserId(funCouponTemplate.getCouponUserId());
                funDiscountCoupon.setUsedScene(funCouponTemplate.getUsedScene());
                funDiscountCoupon.setStatus("1");
                funDiscountCoupon.setUseLimits(funCouponTemplate.getUseLimits());
                funDiscountCoupon.setMaxCountIssue(funCouponTemplate.getMaxCountIssue());
                funDiscountCoupon.setEffectiveTime(funCouponTemplate.getEffectiveTime());
                
                //有效期开始时间=领取时的系统时间＋获得时间
                Calendar c = Calendar.getInstance();
	             c.add(Calendar.SATURDAY, funActivityCouponRel.getAcquireDays());
	             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 			String format = sdf.format(c.getTime());
                funDiscountCoupon.setEffectiveStartTime(Timestamp.valueOf(format));
                
                if(funCouponTemplate.getEffectiveEndTime() != null){
                	//有效期结束时间＝领取时的系统时间＋获得时间＋优惠券模版表中的有效期
                	Calendar e = Calendar.getInstance();
	   	             c.add(Calendar.SATURDAY, funActivityCouponRel.getAcquireDays());
	   	             c.add(Calendar.SATURDAY, funCouponTemplate.getEffectiveTime());
	   	             SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   	 			String sDate = sdf1.format(e.getTime());
                	funDiscountCoupon.setEffectiveEndTime(Timestamp.valueOf(sDate));
                }else{
                	//有效期结束时间＝优惠券模版表中的有效期结束时间；
                    funDiscountCoupon.setEffectiveEndTime(funCouponTemplate.getEffectiveEndTime());
                }
                
                funDiscountCoupon.setUserId(param.getUserId());
                /*funDiscountCoupon.setAccountId();
                funDiscountCoupon.setOrderId();
                funDiscountCoupon.setUseTime();*/
                Date date=new Date();
                DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                funDiscountCoupon.setCreateTime(Timestamp.valueOf(format1.format(date)));
                
                FunDiscountCouponMapper fudMapper = MapperFactory.getFunDiscountCouponMapper();
                fudMapper.insert(funDiscountCoupon);
        	}
        }
	}

	@Override
	public List<DeductionCouponResponse> deducionCouponCheck(String couponId) throws BusinessException, SystemException {
		return discountCouponAtomSV.deducionCouponCheck(couponId);
	}
	/**
	 * 优惠码验证
	 */
	@Override
	public List<DeductionCouponResponse> queryDisCountCoupon(DeductionCouponRequest param) throws BusinessException, SystemException {
		return discountCouponAtomSV.queryDisCountCoupon(param);
	}
	/**
	 * 更改优惠券状态（解冻）
	 */
	@Override
	public void updateStateThaw(FreezeCouponRequest param) throws BusinessException, SystemException {
		discountCouponAtomSV.updateStateThaw(param);
	}
	/**
	 * 更改优惠券状态（冻结）
	 */
	@Override
	public void updateStateFreeze(FreezeCouponRequest param) throws BusinessException, SystemException {
		discountCouponAtomSV.updateStateFreeze(param);
	}
	/**
	 * 根据用户ID查询优惠券
	 */
	@Override
	public List<FunDiscountCouponResponse> queryCouponByUserId(SendCouponRequest param) throws BusinessException, SystemException {
		return discountCouponAtomSV.queryCouponByUserId(param);
	}
	/**
	 * 抵扣优惠券查询
	 */
	@Override
	public List<DeductionCouponResponse> queryDisCountCouponOnly(DeductionCouponRequest param) throws BusinessException, SystemException {
		return discountCouponAtomSV.queryDisCountCouponOnly(param);
	}

	/**
	 * 抵扣优惠券
	 */
	@Override
	public void deducionCoupon(DeductionCouponRequest param) throws BusinessException, SystemException {
		 discountCouponAtomSV.queryDeducionCoupon(param);
	}
	/**
	 * 根据状态查询数量
	 */
	@Override
	public Integer findCouponCount(QueryCouCountRequest request) throws BusinessException, SystemException {
		return discountCouponAtomSV.findCouponCount(request);
	}

	@Override
	public PageInfo<DeductionCouponResponse> queryCouponPage(QueryCouponRequest queryCouponRequest) throws BusinessException, SystemException {
		PageInfo<DeductionCouponResponse> deductionCouponResponse = discountCouponAtomSV.queryCouponPage(queryCouponRequest);
		return deductionCouponResponse;
	}
	/**
	 * 根据过期时间查询数量
	 */
	@Override
	public Integer queryCouponOveCount(QueryCouCountRequest request) throws BusinessException, SystemException {
		return discountCouponAtomSV.queryCouponOveCount(request);
	}
	/**
	 * 线下发送/领取优惠券
	 *//*
	@Override
	public void offLineSendCoupon(int maxCount, String couponName, String userId)
			throws BusinessException, SystemException {
		for (int i=0;i<maxCount;i++){
			
			 FunActivityCouponRelCriteria funActivityCouponRelCriteria = new FunActivityCouponRelCriteria();
             FunActivityCouponRelMapper facrMapper = MapperFactory.getFunActivityCouponRelMapper();
             List<FunActivityCouponRel> funActivityCouponRels = facrMapper.selectByExample(funActivityCouponRelCriteria);
             FunActivityCouponRel funActivityCouponRel=new FunActivityCouponRel();
             BeanUtils.copyProperties(funActivityCouponRel,funActivityCouponRels.get(0));
			
			 FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
             FunCouponTemplateCriteria.Criteria fatCriteria = funCouponTemplateCriteria.createCriteria();
             fatCriteria.andCouponNameNotLike(couponName);
             FunCouponTemplateMapper fctMapper = MapperFactory.getFunCouponTemplateMapper();
             List<FunCouponTemplate> FunCouponTemplates = fctMapper.selectByExample(funCouponTemplateCriteria);
             FunCouponTemplate funCouponTemplate=new FunCouponTemplate();
             BeanUtils.copyProperties(funCouponTemplate,FunCouponTemplates.get(0));
             
             FunDiscountCoupon funDiscountCoupon = new FunDiscountCoupon();
             //funActivity;funCouponTemplate
             //funDiscountCoupon.setCouponId(1);
             funDiscountCoupon.setCouponName(funCouponTemplate.getCouponName());
             funDiscountCoupon.setCouponDesc(funCouponTemplate.getCouponDesc());
             funDiscountCoupon.setTemplateId(1);
             funDiscountCoupon.setFaceValue(funCouponTemplate.getFaceValue());
             funDiscountCoupon.setCurrencyUnit(funCouponTemplate.getCurrencyUnit());
             funDiscountCoupon.setCouponUserId(funCouponTemplate.getCouponUserId());
             funDiscountCoupon.setUsedScene(funCouponTemplate.getUsedScene());
             funDiscountCoupon.setStatus("1");
             funDiscountCoupon.setEffectiveTime(funCouponTemplate.getEffectiveTime());
             
             //有效期开始时间=领取时的系统时间＋获得时间
             Calendar c = Calendar.getInstance();
	             c.add(Calendar.SATURDAY, funActivityCouponRel.getAcquireDays());
	             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 			String format = sdf.format(c.getTime());
             funDiscountCoupon.setEffectiveStartTime(Timestamp.valueOf(format));
             funDiscountCoupon.setEffectiveStartTime(funCouponTemplate.getEffectiveStartTime());
             
             if(funCouponTemplate.getEffectiveEndTime() != null){
             	//有效期结束时间＝领取时的系统时间＋获得时间＋优惠券模版表中的有效期
             	Calendar e = Calendar.getInstance();
	   	             c.add(Calendar.SATURDAY, funActivityCouponRel.getAcquireDays());
	   	             c.add(Calendar.SATURDAY, funCouponTemplate.getEffectiveTime());
	   	             SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   	 			String sDate = sdf1.format(e.getTime());
             	funDiscountCoupon.setEffectiveEndTime(Timestamp.valueOf(sDate));
             }else{
             	//有效期结束时间＝优惠券模版表中的有效期结束时间；
                 funDiscountCoupon.setEffectiveEndTime(funCouponTemplate.getEffectiveEndTime());
             }
             funDiscountCoupon.setUserId(userId);
             //funDiscountCoupon.setAccountId();
             //funDiscountCoupon.setOrderId();
             //funDiscountCoupon.setUseTime();
             //funDiscountCoupon.setCreateTime());
             
             FunDiscountCouponMapper fudMapper = MapperFactory.getFunDiscountCouponMapper();
             fudMapper.insertSelective(funDiscountCoupon);
		}
	}*/
}

package com.ai.slp.balance.service.business.impl;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
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
import com.ai.slp.balance.service.business.interfaces.ISendCouponSV;
@Service
@Transactional
public class SendCouponSVImpl implements ISendCouponSV {
	private static final Logger LOG = LogManager.getLogger(SendCouponSVImpl.class);
	
	/**
	 * 新用户注册发送/领取优惠券
	 */
	@Override
	public void registerSendCoupon(String activityName, String userId) throws BusinessException, SystemException {
		 LOG.debug("注册发送优惠券"); 
		//从serial中取出需要的字段
		FunActivityCriteria funActivityCriteria = new FunActivityCriteria();
		FunActivityCriteria.Criteria faCriteria = funActivityCriteria.createCriteria();
		faCriteria.andActivityNameLike(activityName);
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
                List<FunCouponTemplate> FunCouponTemplates = fctMapper.selectByExample(funCouponTemplateCriteria);
                FunCouponTemplate funCouponTemplate=new FunCouponTemplate();
                BeanUtils.copyProperties(funCouponTemplate,FunCouponTemplates.get(0));
                
                FunDiscountCoupon funDiscountCoupon = new FunDiscountCoupon();
                //funActivity;funCouponTemplate
                funDiscountCoupon.setAccountId(funActivity.getActivityId());
                funDiscountCoupon.setCouponName(funCouponTemplate.getCouponName());
                funDiscountCoupon.setCouponDesc(funCouponTemplate.getCouponDesc());
                funDiscountCoupon.setTemplateId(funCouponTemplate.getTemplateId());
                funDiscountCoupon.setFaceValue(funCouponTemplate.getFaceValue());
                funDiscountCoupon.setCurrencyUnit(funCouponTemplate.getCurrencyUnit());
                funDiscountCoupon.setCouponUserId(funCouponTemplate.getCouponUserId());
                funDiscountCoupon.setUsedScene(funCouponTemplate.getUsedScene());
                funDiscountCoupon.setStatus("1");
                funDiscountCoupon.setEffectiveTime(funCouponTemplate.getEffectiveTime());
                funDiscountCoupon.setEffectiveStartTime(funCouponTemplate.getEffectiveStartTime());
                funDiscountCoupon.setEffectiveEndTime(funCouponTemplate.getEffectiveEndTime());
                funDiscountCoupon.setUserId(userId);
                //funDiscountCoupon.setAccountId();
                //funDiscountCoupon.setOrderId();
                //funDiscountCoupon.setUseTime();
                //funDiscountCoupon.setCreateTime());
                
                FunDiscountCouponMapper fudMapper = MapperFactory.getFunDiscountCouponMapper();
                fudMapper.insert(funDiscountCoupon);
                
        	}
        }
	}
	
	
	/**
	 * 线下发送/领取优惠券
	 */
	@Override
	public void offLineSendCoupon(int maxCount, String couponName, String userId)
			throws BusinessException, SystemException {
		for (int i=0;i<maxCount;i++){
			 FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
             FunCouponTemplateCriteria.Criteria fatCriteria = funCouponTemplateCriteria.createCriteria();
             fatCriteria.andCouponNameNotLike(couponName);
             FunCouponTemplateMapper fctMapper = MapperFactory.getFunCouponTemplateMapper();
             List<FunCouponTemplate> FunCouponTemplates = fctMapper.selectByExample(funCouponTemplateCriteria);
             FunCouponTemplate funCouponTemplate=new FunCouponTemplate();
             BeanUtils.copyProperties(funCouponTemplate,FunCouponTemplates.get(0));
             
             FunDiscountCoupon funDiscountCoupon = new FunDiscountCoupon();
             //funActivity;funCouponTemplate
             funDiscountCoupon.setCouponId(1);
             //funDiscountCoupon.setCouponName(funCouponTemplate.getCouponName());
             //funDiscountCoupon.setCouponDesc(funCouponTemplate.getCouponDesc());
             funDiscountCoupon.setTemplateId(1);
             //funDiscountCoupon.setFaceValue(funCouponTemplate.getFaceValue());
             funDiscountCoupon.setCurrencyUnit("RMB");
             //funDiscountCoupon.setCouponUserId(funCouponTemplate.getCouponUserId());
             //funDiscountCoupon.setUsedScene("1");
             funDiscountCoupon.setStatus("1");
             //funDiscountCoupon.setEffectiveTime(funCouponTemplate.getEffectiveTime());
             //funDiscountCoupon.setEffectiveStartTime(funCouponTemplate.getEffectiveStartTime());
             //funDiscountCoupon.setEffectiveEndTime(funCouponTemplate.getEffectiveEndTime());
             funDiscountCoupon.setUserId(userId);
             //funDiscountCoupon.setAccountId();
             //funDiscountCoupon.setOrderId();
             //funDiscountCoupon.setUseTime();
             //funDiscountCoupon.setCreateTime());
             
             FunDiscountCouponMapper fudMapper = MapperFactory.getFunDiscountCouponMapper();
             fudMapper.insertSelective(funDiscountCoupon);
		}
	}
	
	
	
	
	
	
	
	
	
}

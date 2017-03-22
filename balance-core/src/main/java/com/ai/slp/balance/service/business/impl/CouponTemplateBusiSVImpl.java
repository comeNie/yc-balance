package com.ai.slp.balance.service.business.impl;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.api.coupontemplate.param.SaveFunCouponTemplate;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplateCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunCouponTemplateMapper;
import com.ai.slp.balance.service.atom.interfaces.ICouponTemplateAtomSV;
import com.ai.slp.balance.service.atom.interfaces.ICouponUseRuleAtomSV;
import com.ai.slp.balance.service.business.interfaces.ICouponTemplateBusiSV;
@Service
@Transactional
public class CouponTemplateBusiSVImpl implements ICouponTemplateBusiSV {
	
	@Autowired
	private ICouponTemplateAtomSV couponTemplateAtomSV;
	
	@Autowired
	private ICouponUseRuleAtomSV couponUseRuleAtomSV;
	
	/*@Autowired
	private IDiscountCouponAtomSV discountCouponAtomSV;*/
	
	/**
	 * 生成优惠券模板
	 */
	@Override
	public void BuildCouponTemplet(FunCouponTemplate couponTemplate,Integer requiredMoneyAmount,HttpSession session) throws BusinessException, SystemException {
		//判断用户名是否唯一
		FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
		FunCouponTemplateCriteria.Criteria faCriteria = funCouponTemplateCriteria.createCriteria();
		String couponTemplateName = couponTemplate.getCouponName();
		faCriteria.andCouponNameLike(couponTemplateName);
		FunCouponTemplateMapper funCouponTemplateMapper = MapperFactory.getFunCouponTemplateMapper();
        List<FunCouponTemplate> funCouponTemplate = funCouponTemplateMapper.selectByExample(funCouponTemplateCriteria);
        if (!CollectionUtil.isEmpty(funCouponTemplate)){
        	String createOperator = (String) session.getAttribute("userName");
    		couponTemplate.setCreateOperator(createOperator);
    		Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            couponTemplate.setCreateTime(Timestamp.valueOf(format.format(date)));
            if(requiredMoneyAmount!=null){
            	FunCouponUseRule funCouponUseRule = new FunCouponUseRule();
            	funCouponUseRule.setCouponUserId("a1b2");
            	funCouponUseRule.setFaceValue(null);
            	funCouponUseRule.setRequiredMoneyAmount(requiredMoneyAmount);
            	funCouponUseRule.setCurrencyUnit(couponTemplate.getCurrencyUnit());
            	Date date1=new Date();
                DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                funCouponUseRule.setCreateTime(Timestamp.valueOf(format1.format(date1)));
                couponUseRuleAtomSV.insertBuildCouponUseRule(funCouponUseRule);
            	couponTemplateAtomSV.insertBuildCouponTemplet(couponTemplate);
            }else{
            	couponTemplateAtomSV.insertBuildCouponTemplet(couponTemplate);
            }
    		
        }else {
        	throw new BusinessException("","该优惠券模板名称已存在！");
		}
		
		
	}
	/**
	 * 模糊查询优惠券模板列表
	 */
	@Override
	public PageInfo<FunCouponTemplateResponse> queryCouponTemplet(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest) {
        PageInfo<FunCouponTemplateResponse> funCouponTemplateResponsePageInfo = couponTemplateAtomSV.funCouponTemplateQueryRequest(funCouponTemplateQueryRequest);
		return funCouponTemplateResponsePageInfo;
	}
	/**
	 * POI导出优惠券模板列表生成Excel
	 */
	@Override
	public List<FunCouponTemplateResponse> exportCouponTempletList(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest) {
		return couponTemplateAtomSV.exportCouponTempletList(funCouponTemplateQueryRequest);
	}
	/**
	 * 检测名称唯一
	 */
	@Override
	public Integer checkCouponTemplateName(String couponName) {
		return couponTemplateAtomSV.checkCouponTemplateName(couponName);
	}
	/**
	 * 添加优惠券模板
	 */
	@Override
	public Integer saveCouponTempletList(SaveFunCouponTemplate req) throws BusinessException, SystemException {
		
		FunCouponTemplate funCouponTemplate = new FunCouponTemplate();
		funCouponTemplate.setCouponName(req.getCouponName());
		funCouponTemplate.setCouponDesc(req.getCouponDesc());
		funCouponTemplate.setCreateOperator("admin");
		Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        funCouponTemplate.setCreateTime(Timestamp.valueOf(format.format(date)));
		funCouponTemplate.setCurrencyUnit(req.getCurrencyUnit());
		
		funCouponTemplate.setEffectiveEndTime(req.getEffectiveEndTime());
		funCouponTemplate.setEffectiveEndTime(req.getEffectiveStartTime());
		funCouponTemplate.setEffectiveTime(req.getEffectiveTime());
		funCouponTemplate.setFaceValue(req.getFaceValue());
		funCouponTemplate.setFaceValueDown(req.getFaceValueDown());
		funCouponTemplate.setFaceValueUp(req.getFaceValueUp());
		funCouponTemplate.setMaxCountIssue(req.getMaxCountIssue());
		funCouponTemplate.setReceiveEndTime(req.getReceiveEndTime());
		funCouponTemplate.setReceiveStartTime(req.getReceiveStartTime());
		funCouponTemplate.setStatus(req.getStatus());
		funCouponTemplate.setUsedScene(req.getUsedScene());
		funCouponTemplate.setUseLimits(req.getUseLimits());
		if(req.getCouponUserId() == "0"){
			funCouponTemplate.setCouponUserId(req.getCouponUserId());
		}else{
			FunCouponUseRule funCouponUseRule = new FunCouponUseRule();
	    	funCouponUseRule.setCouponUserId(SeqUtil.getNewId(SeqConstants.FUN_COUPON_USE_RULE$COUPON_USER_ID).toString());
	    	funCouponUseRule.setFaceValue(req.getFaceValue());
	    	funCouponUseRule.setRequiredMoneyAmount(null);
	    	funCouponUseRule.setCurrencyUnit(funCouponTemplate.getCurrencyUnit());
	    	Date date1=new Date();
	        DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        funCouponUseRule.setCreateTime(Timestamp.valueOf(format1.format(date1)));
	        couponUseRuleAtomSV.insertBuildCouponUseRule(funCouponUseRule);
	        funCouponTemplate.setCouponUserId(SeqUtil.getNewId(SeqConstants.FUN_COUPON_USE_RULE$COUPON_USER_ID).toString());
		}
		return couponTemplateAtomSV.saveCouponTempletList(funCouponTemplate);
	}
	/**
	 * 根据优惠券模板iD查询优惠券明细
	 */
	@Override
	public PageInfo<FunCouponDetailResponse> queryFunCouponDetail(FunCouponDetailQueryRequest param) throws BusinessException, SystemException  {
		return couponTemplateAtomSV.queryFunCouponDetail(param);
	}
	/**
	 * 删除优惠券模板
	 */
	@Override
	public Integer deleteCouponTemplate(Integer templateId) {
		return couponTemplateAtomSV.deleteCouponTemplate(templateId);
	}

	
}

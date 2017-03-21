package com.ai.slp.balance.api.couponuserule.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.couponuserule.param.SaveCouponUseRule;
import com.ai.slp.balance.service.business.interfaces.ICouponUseRuleBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class CouponUseRuleSVImpl implements ICouponUseRuleSV {
	
	@Autowired
    private ICouponUseRuleBusiSV iCouponUseRuleBusiSV;
	/**
	 * 查询使用规则
	 */
	@Override
	public List<FunCouponUseRuleQueryResponse> queryFunCouponUseRule(String couponUserId)throws BusinessException, SystemException {
		List<FunCouponUseRuleQueryResponse> queryCouponUseRule = iCouponUseRuleBusiSV.queryCouponUseRule(couponUserId);
		return queryCouponUseRule;
	}

	/**
	 * 添加使用规则
	 */
	@Override
	public Integer saveCouponUseRule(SaveCouponUseRule param) throws BusinessException, SystemException {
		return iCouponUseRuleBusiSV.saveCouponUseRule(param);
	}
   
}

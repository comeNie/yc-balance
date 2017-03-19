package com.ai.slp.balance.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.service.atom.interfaces.ICouponUseRuleAtomSV;
import com.ai.slp.balance.service.business.interfaces.ICouponUseRuleBusiSV;
@Service
@Transactional
public class CouponUseRuleBusiSVImpl implements ICouponUseRuleBusiSV {
	
	@Autowired
	private ICouponUseRuleAtomSV couponUseRuleAtomSV;

	@Override
	public List<FunCouponUseRuleQueryResponse> queryCouponUseRule(String couponUserId) {
		List<FunCouponUseRuleQueryResponse> queryCouponUseRule = couponUseRuleAtomSV.queryCouponUseRule(couponUserId);
		return queryCouponUseRule;
	}
	
}

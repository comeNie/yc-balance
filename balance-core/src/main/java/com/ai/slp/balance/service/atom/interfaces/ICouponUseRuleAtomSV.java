package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;

public interface ICouponUseRuleAtomSV {
	//生成优惠券使用规则
	public void insertBuildCouponUseRule(FunCouponUseRule funCouponUseRule);
	
}

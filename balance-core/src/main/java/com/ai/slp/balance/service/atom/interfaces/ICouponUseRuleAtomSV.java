package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;

public interface ICouponUseRuleAtomSV {
	//生成优惠券使用规则
	public Integer insertBuildCouponUseRule(FunCouponUseRule funCouponUseRule);

	/**
	 * 查询使用规则
	 * @param couponUserId
	 * @return
	 */
	public List<FunCouponUseRuleQueryResponse> queryCouponUseRule(String couponUserId);
}

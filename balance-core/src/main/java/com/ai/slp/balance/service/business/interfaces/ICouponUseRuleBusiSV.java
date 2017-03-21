package com.ai.slp.balance.service.business.interfaces;

import java.util.List;

import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.couponuserule.param.SaveCouponUseRule;

public interface ICouponUseRuleBusiSV {

	List<FunCouponUseRuleQueryResponse> queryCouponUseRule(String couponUserId);

	public Integer saveCouponUseRule(SaveCouponUseRule param);

}

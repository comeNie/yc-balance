package com.ai.slp.balance.service.atom.interfaces;



import java.util.List;

import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.FreezeCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.FunDiscountCouponResponse;

public interface IDiscountCouponAtomSV {

	List<DeductionCouponResponse> deducionCoupon(String couponId);
	//查询优惠券明细
	/*public PageInfo<FunCouponDetailResponse> queryFunCouponDetail(FunCouponDetailQueryRequest param);*/

	List<DeductionCouponResponse> queryDeducionCoupon(DeductionCouponRequest param, String orderType);

	List<FunDiscountCouponResponse> queryCouponByUserId(String userId);

	void updateStateThaw(FreezeCouponRequest param);

	void updateStateFreeze(FreezeCouponRequest param);

	List<DeductionCouponResponse> queryDeducionCoupon(DeductionCouponRequest param);
	
}

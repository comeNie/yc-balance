package com.ai.slp.balance.service.atom.interfaces;



import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailResponse;

public interface IDiscountCouponAtomSV {
	//查询优惠券明细
	public PageInfo<FunCouponDetailResponse> getAccountInfoByCustId(FunCouponDetailQueryRequest param);
	
}

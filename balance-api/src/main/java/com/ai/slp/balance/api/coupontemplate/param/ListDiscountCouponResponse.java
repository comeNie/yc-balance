package com.ai.slp.balance.api.coupontemplate.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class ListDiscountCouponResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1L;
	private List<FunDiscountCouponInfoVo> funDiscountCouponInfoVoList = null;
	public List<FunDiscountCouponInfoVo> getFunDiscountCouponInfoVoList() {
		return funDiscountCouponInfoVoList;
	}
	public void setFunDiscountCouponInfoVoList(List<FunDiscountCouponInfoVo> funDiscountCouponInfoVoList) {
		this.funDiscountCouponInfoVoList = funDiscountCouponInfoVoList;
	}

	

}

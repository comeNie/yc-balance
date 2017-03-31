package com.ai.slp.balance.api.sendcoupon.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class QueryCouponRsponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	/**
     * 分页必填
     */
	private PageInfo<DeductionCouponResponse> pageInfo;

	public PageInfo<DeductionCouponResponse> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<DeductionCouponResponse> pageInfo) {
		this.pageInfo = pageInfo;
	}

}

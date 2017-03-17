package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;


public class FunCouponDetailPageResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;


    PageInfo<FunCouponDetailResponse> pageInfo;

    public PageInfo<FunCouponDetailResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunCouponDetailResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
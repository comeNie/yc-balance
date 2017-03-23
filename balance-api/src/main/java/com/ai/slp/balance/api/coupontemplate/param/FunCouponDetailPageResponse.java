package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 根据优惠券模板ID查询优惠券明细
 */
public class FunCouponDetailPageResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;

    /**
     * 分页时必填
     */
    PageInfo<FunCouponDetailResponse> pageInfo;

    public PageInfo<FunCouponDetailResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunCouponDetailResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
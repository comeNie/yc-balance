package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 优惠券模板查询.<br>
 */
public class FunCouponTemplateQueryResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;

    /**
     * 分页时必填
     */
    PageInfo<FunCouponTemplateResponse> pageInfo;

    public PageInfo<FunCouponTemplateResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunCouponTemplateResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

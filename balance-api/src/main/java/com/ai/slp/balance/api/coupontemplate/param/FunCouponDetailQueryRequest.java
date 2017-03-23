package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.PageInfo;

import java.io.Serializable;

/**
 * 根据优惠券模板ID查询优惠券明细入参
 */
public class FunCouponDetailQueryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 优惠前模板ID
     */
    Integer templateId;

    /**
     * 分页时必填
     */
    PageInfo<FunCouponDetailResponse> pageInfo;

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public PageInfo<FunCouponDetailResponse> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<FunCouponDetailResponse> pageInfo) {
		this.pageInfo = pageInfo;
	}
}

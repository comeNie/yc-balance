package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.PageInfo;

import java.io.Serializable;

/**
 * 账号查询请求参数
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FunCouponDetailQueryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账单ID
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

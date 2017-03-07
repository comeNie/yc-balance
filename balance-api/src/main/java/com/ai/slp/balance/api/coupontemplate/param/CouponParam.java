package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 优惠券查询请求参数 <br>
 * Date: 2017年3月7日 <br>
 * 
 * @author shancc
 */
public class CouponParam extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠券模板ID，必填
     */
    private Integer templateId;

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
}

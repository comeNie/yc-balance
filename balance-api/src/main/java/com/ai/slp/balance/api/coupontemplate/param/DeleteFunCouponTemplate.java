package com.ai.slp.balance.api.coupontemplate.param;

import java.io.Serializable;

/**
 * 添加优惠券模板入参
 */
public class DeleteFunCouponTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
		/**
	 	 * 模板ID
	 	 */
		private Integer templateId;
	    public Integer getTemplateId() {
	        return templateId;
	    }

	    public void setTemplateId(Integer templateId) {
	        this.templateId = templateId;
	    }
}

package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 检测名称唯一入参
 */
public class CouponTemplateParam extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠券模板名称
     */
    private String couponName;

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

}

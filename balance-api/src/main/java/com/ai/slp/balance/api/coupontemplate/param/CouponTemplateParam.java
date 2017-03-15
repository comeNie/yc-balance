package com.ai.slp.balance.api.coupontemplate.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * Date: 2017年3月7日 <br>
 * 
 * @author shancc
 */
public class CouponTemplateParam extends BaseInfo {

    private static final long serialVersionUID = 1L;

    private String couponName;

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

}

package com.ai.slp.balance.api.sendcoupon.param;

import java.io.Serializable;

/**
 * 解冻/冻结入参
 *
 */
public class FreezeCouponRequest implements Serializable {
	private static final long serialVersionUID = -3795050733122224474L;

	/**
	 * 优惠券ID
	 */
	private String couponId;
	
	private long orderId;
	
	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
}

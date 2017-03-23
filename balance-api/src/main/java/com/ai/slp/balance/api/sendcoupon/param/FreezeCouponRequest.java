package com.ai.slp.balance.api.sendcoupon.param;
/**
 * 解冻/冻结入参
 *
 */
public class FreezeCouponRequest {
	/**
	 * 优惠券ID
	 */
	private String couponId;
	
	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

}

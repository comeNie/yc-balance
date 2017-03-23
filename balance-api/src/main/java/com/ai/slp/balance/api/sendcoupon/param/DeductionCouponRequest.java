package com.ai.slp.balance.api.sendcoupon.param;

/**
 * 查询可用优惠券/抵扣优惠券入参
 */
public class DeductionCouponRequest {
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 优惠券ID
	 */
	private String couponId;
	/**
	 * 订单ID
	 */
	private long orderId;
	/**
	 * 优惠券使用场景
	 */
	private String usedScene;
	/**
	 * 订单消费总金额
	 */
	private long totalFee;
	
	public long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(long totalFee) {
		this.totalFee = totalFee;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUsedScene() {
		return usedScene;
	}

	public void setUsedScene(String usedScene) {
		this.usedScene = usedScene;
	}
}

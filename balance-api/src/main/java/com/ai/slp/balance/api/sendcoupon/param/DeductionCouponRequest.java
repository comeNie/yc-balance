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
	 *	1译云-中文站
	 *	2译云-英文站
	 *	3百度
	 *	4金山
	 *	5wap-中文
	 *	6wap-英文
	 *	7找翻译
	 *	8微信助手
	 */
	private String usedScene;
	/**
	 * 订单消费总金额
	 */
	private long totalFee;
	/**
	 * 币种
	 */
	private String currencyUnit;
	
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
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getUsedScene() {
		return usedScene;
	}

	public void setUsedScene(String usedScene) {
		this.usedScene = usedScene;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}
}

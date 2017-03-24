package com.ai.slp.balance.api.sendcoupon.param;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 查询可用优惠券出参
 */
public class DeductionCouponResponse  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 优惠券ID
	 */
    private String couponId;
    /**
	 * 优惠券名称
	 */
    private String couponName;
    /**
	 * 优惠券描述
	 */
    private String couponDesc;
    /**
	 * 面值
	 */
    private Integer faceValue;
    /**
	 * 币种
	 */
    private String currencyUnit;
    /**
	 * 使用规则ID
	 */
    private String couponUserId;
    /**
	 * 使用场景
	 */
    private String usedScene;
    /**
	 * 使用限制
	 */
    private String useLimits;
    /**
	 * 状态
	 */
    private String status;
    /**
	 * 有效期
	 */
    private Integer effectiveTime;
    /**
	 * 有效期开始时间
	 */
    private Timestamp effectiveStartTime;
    /**
	 * 有效期结束时间
	 */
    private Timestamp effectiveEndTime;
    /**
	 * 用户ID
	 */
    private String userId;
    /**
	 * 使用订单
	 */
    private long orderId;
    /**
	 * 使用时间
	 */
    private Timestamp useTime;
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCouponDesc() {
		return couponDesc;
	}
	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}
	public Integer getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(Integer faceValue) {
		this.faceValue = faceValue;
	}
	public String getCurrencyUnit() {
		return currencyUnit;
	}
	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}
	public String getCouponUserId() {
		return couponUserId;
	}
	public void setCouponUserId(String couponUserId) {
		this.couponUserId = couponUserId;
	}
	public String getUsedScene() {
		return usedScene;
	}
	public void setUsedScene(String usedScene) {
		this.usedScene = usedScene;
	}
	public String getUseLimits() {
		return useLimits;
	}
	public void setUseLimits(String useLimits) {
		this.useLimits = useLimits;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(Integer effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public Timestamp getEffectiveStartTime() {
		return effectiveStartTime;
	}
	public void setEffectiveStartTime(Timestamp effectiveStartTime) {
		this.effectiveStartTime = effectiveStartTime;
	}
	public Timestamp getEffectiveEndTime() {
		return effectiveEndTime;
	}
	public void setEffectiveEndTime(Timestamp effectiveEndTime) {
		this.effectiveEndTime = effectiveEndTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Timestamp getUseTime() {
		return useTime;
	}
	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}
}

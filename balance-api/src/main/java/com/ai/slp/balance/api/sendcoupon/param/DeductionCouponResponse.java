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
	 * 活动ID
	 */
    private Integer activityId;
    /**
	 * 优惠券模板ID
	 */
    private Integer templateId;
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
	 * 账户ID
	 */
    private Integer accountId;
    /**
	 * 使用订单
	 */
    private Integer orderId;
    /**
	 * 使用时间
	 */
    private Timestamp useTime;
    /**
	 * 创建时间
	 */
    private Timestamp createTime;
    /**
	 * 类型\备注
	 */
    private String remark;
    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc == null ? null : couponDesc.trim();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
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
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public String getCouponUserId() {
        return couponUserId;
    }

    public void setCouponUserId(String couponUserId) {
        this.couponUserId = couponUserId == null ? null : couponUserId.trim();
    }

    public String getUsedScene() {
        return usedScene;
    }

    public void setUsedScene(String usedScene) {
        this.usedScene = usedScene == null ? null : usedScene.trim();
    }

    public String getUseLimits() {
        return useLimits;
    }

    public void setUseLimits(String useLimits) {
        this.useLimits = useLimits == null ? null : useLimits.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getUseTime() {
        return useTime;
    }

    public void setUseTime(Timestamp useTime) {
        this.useTime = useTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}

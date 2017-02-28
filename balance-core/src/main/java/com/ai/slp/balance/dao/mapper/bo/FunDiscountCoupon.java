package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;


public class FunDiscountCoupon {
    private Integer couponId;

    private String couponName;

    private String couponDesc;

    private Integer activityId;

    private Integer templateId;

    private Integer faceValue;

    private String currencyUnit;

    private String couponUserId;

    private String usedScene;

    private String useLimits;

    private String status;

    private Integer effectiveTime;

    private Timestamp effectiveStartTime;

    private Timestamp effectiveEndTime;

    private String userId;

    private Integer accountId;

    private Integer orderId;

    private Timestamp useTime;

    private Timestamp createTime;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunCouponTemplate {
    private Integer templateId;

    private String couponName;

    private String couponDesc;

    private Integer faceValue;

    private Integer faceValueUp;

    private Integer faceValueDown;

    private String currencyUnit;

    private Integer maxCountIssue;

    private String couponUserId;

    private String usedScene;

    private String useLimits;

    private String status;

    private Integer effectiveTime;

    private Timestamp effectiveStartTime;

    private Timestamp effectiveEndTime;

    private Timestamp receiveStartTime;

    private Timestamp receiveEndTime;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
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

    public Integer getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Integer faceValue) {
        this.faceValue = faceValue;
    }

    public Integer getFaceValueUp() {
        return faceValueUp;
    }

    public void setFaceValueUp(Integer faceValueUp) {
        this.faceValueUp = faceValueUp;
    }

    public Integer getFaceValueDown() {
        return faceValueDown;
    }

    public void setFaceValueDown(Integer faceValueDown) {
        this.faceValueDown = faceValueDown;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public Integer getMaxCountIssue() {
        return maxCountIssue;
    }

    public void setMaxCountIssue(Integer maxCountIssue) {
        this.maxCountIssue = maxCountIssue;
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

    public Timestamp getReceiveStartTime() {
        return receiveStartTime;
    }

    public void setReceiveStartTime(Timestamp receiveStartTime) {
        this.receiveStartTime = receiveStartTime;
    }

    public Timestamp getReceiveEndTime() {
        return receiveEndTime;
    }

    public void setReceiveEndTime(Timestamp receiveEndTime) {
        this.receiveEndTime = receiveEndTime;
    }
}
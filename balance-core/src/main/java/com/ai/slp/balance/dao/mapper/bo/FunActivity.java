package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunActivity {
    private Integer activityId;

    private String activityName;

    private String activityDesc;

    private String usedScene;

    private String currencyUnit;

    private Integer totalMoneyAmount;

    private Integer remainingMoneyAmount;

    private Timestamp startTime;

    private Timestamp endTime;

    private String status;

    private String createStaff;

    private Timestamp createTime;

    private Timestamp updateTime;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc == null ? null : activityDesc.trim();
    }

    public String getUsedScene() {
        return usedScene;
    }

    public void setUsedScene(String usedScene) {
        this.usedScene = usedScene == null ? null : usedScene.trim();
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public Integer getTotalMoneyAmount() {
        return totalMoneyAmount;
    }

    public void setTotalMoneyAmount(Integer totalMoneyAmount) {
        this.totalMoneyAmount = totalMoneyAmount;
    }

    public Integer getRemainingMoneyAmount() {
        return remainingMoneyAmount;
    }

    public void setRemainingMoneyAmount(Integer remainingMoneyAmount) {
        this.remainingMoneyAmount = remainingMoneyAmount;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff == null ? null : createStaff.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
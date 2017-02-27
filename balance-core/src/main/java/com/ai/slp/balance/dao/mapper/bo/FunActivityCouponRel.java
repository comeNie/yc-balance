package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunActivityCouponRel {
    private Integer id;

    private Integer activityId;

    private Integer templateId;

    private Integer couponAccount;

    private Integer acquireDays;

    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCouponAccount() {
        return couponAccount;
    }

    public void setCouponAccount(Integer couponAccount) {
        this.couponAccount = couponAccount;
    }

    public Integer getAcquireDays() {
        return acquireDays;
    }

    public void setAcquireDays(Integer acquireDays) {
        this.acquireDays = acquireDays;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class Integrals {
    private String id;

    private String userId;

    private Integer nowIntegral;

    private Timestamp createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getNowIntegral() {
        return nowIntegral;
    }

    public void setNowIntegral(Integer nowIntegral) {
        this.nowIntegral = nowIntegral;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
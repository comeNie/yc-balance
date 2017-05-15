package com.ai.slp.balance.api.integrals.param;

import com.ai.opt.base.vo.BaseResponse;

import java.sql.Timestamp;

/**
 * Created by liquid on 17/5/15.
 */
public class IntegralsResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;
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

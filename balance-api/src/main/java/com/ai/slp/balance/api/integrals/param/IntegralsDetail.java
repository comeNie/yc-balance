package com.ai.slp.balance.api.integrals.param;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;

import java.sql.Timestamp;

/**
 * Created by liquid on 17/5/15.
 */
public class IntegralsDetail extends BaseInfo {
    private static final long serialVersionUID = 1L;
    private String integralLogId;

    private String id;

    private String userId;

    private String integralSource;

    private String systemSource;

    private Integer integralValue;

    private Timestamp logTime;

    public String getIntegralLogId() {
        return integralLogId;
    }

    public void setIntegralLogId(String integralLogId) {
        this.integralLogId = integralLogId == null ? null : integralLogId.trim();
    }

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

    public String getIntegralSource() {
        return integralSource;
    }

    public void setIntegralSource(String integralSource) {
        this.integralSource = integralSource == null ? null : integralSource.trim();
    }

    public String getSystemSource() {
        return systemSource;
    }

    public void setSystemSource(String systemSource) {
        this.systemSource = systemSource == null ? null : systemSource.trim();
    }

    public Integer getIntegralValue() {
        return integralValue;
    }

    public void setIntegralValue(Integer integralValue) {
        this.integralValue = integralValue;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }
}

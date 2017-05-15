package com.ai.slp.balance.api.integrals.param;

import com.ai.opt.base.vo.BaseInfo;


/**
 * 账户设置入参.<br>
 * Date: 2015年7月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public class UpdateIntegralsParam extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id (必填)
     */
    private String userId;
    /**
     * 变更积分(必填)  送积分传入正值,消费积分传入负值,加上负号
     */
    private Integer integrals;
    /**
     * 积分来源
     */
    private String integralsResource;
    /**
     * 积分系统来源
     */
    private String systemResource;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIntegrals() {
        return integrals;
    }

    public void setIntegrals(Integer integrals) {
        this.integrals = integrals;
    }

    public String getIntegralsResource() {
        return integralsResource;
    }

    public void setIntegralsResource(String integralsResource) {
        this.integralsResource = integralsResource;
    }

    public String getSystemResource() {
        return systemResource;
    }

    public void setSystemResource(String systemResource) {
        this.systemResource = systemResource;
    }
}

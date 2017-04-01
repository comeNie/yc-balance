package com.ai.slp.balance.api.accountparam.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 创建账户 <br>
 * Date: 2015年7月30日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author limy6
 */
public class AccParamReq extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 目标ID  必填
     */
    private String targetID;

    public String getTargetID() {
        return targetID;
    }

    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }
}

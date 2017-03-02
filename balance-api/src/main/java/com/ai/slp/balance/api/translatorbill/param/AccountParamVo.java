package com.ai.slp.balance.api.translatorbill.param;
import java.io.Serializable;


import java.sql.Timestamp;

/**
 * 账号查询请求参数 <br>
 * Date: 2017年2月17日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author liquid
 */
public class AccountParamVo implements Serializable{

    private static final long serialVersionUID = 1L;
    //账单的开始时间
    private Timestamp beginTime;
    //账单的结束时间
    private Timestamp endTime;
    //结算目标ID
    private String target_Id;

    public String getTarget_Id() {
        return target_Id;
    }

    public void setTarget_Id(String target_Id) {
        this.target_Id = target_Id;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}

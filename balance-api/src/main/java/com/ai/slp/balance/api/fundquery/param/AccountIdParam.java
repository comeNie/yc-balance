package com.ai.slp.balance.api.fundquery.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 账号查询请求参数
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class AccountIdParam extends BaseInfo{
    
    /**
     * 账户ID，必填
     */
    private long accountId;

    /**
     * 用户id或者企业ID
     */
    private String userID;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}

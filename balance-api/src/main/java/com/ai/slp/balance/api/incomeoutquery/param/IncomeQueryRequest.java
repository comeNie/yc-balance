package com.ai.slp.balance.api.incomeoutquery.param;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;

import java.util.Date;

/**
 * 账号查询请求参数
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class IncomeQueryRequest extends BaseInfo{
    
    /**
     * 账户ID，必填
     */
    private long accountId;

    /**
     * 开始时间，必填
     */
    private String beginDate;

    /**
     * 结束时间，必填
     */
    private String endDate;

    /**
     *收支类型，必填
     */
    private String incomeFlag;

    /**
     *类型，必填
     */
    private String optType;


    /**
     * 分页时必填
     */
    PageInfo<IncomeDetail> pageInfo;

    public PageInfo<IncomeDetail> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IncomeDetail> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIncomeFlag() {
        return incomeFlag;
    }

    public void setIncomeFlag(String incomeFlag) {
        this.incomeFlag = incomeFlag;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

}

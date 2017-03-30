package com.ai.slp.balance.api.incomeoutquery.param;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;

/**
 * 账号查询请求参数
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class IncomeQueryRequestAll extends BaseInfo{
    
    /**
     * 交易号
     */
    private String serialCode;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 开始时间
     */
    private String beginDate;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 支付方式 智联在线;支付宝;微信;线下充值
     */
    private String channel;

    /**
     *状态:0 交易未完成 1 交易成功 2 交易失败
     */
    private String state;

    /**
     * 币种  1:RMB   2:$
     */
    private String currencyUnit;

    /**
     * 金额区间
     */
    private Long beginAmount;
    /**
     * 金额区间
     */
    private Long endAmount;

    /**
     *收支类型
     */
    private String incomeFlag;

    /**
     *类型
     */
    private String optType;
    /**
     * 分页时必填
     */
    PageInfo<IncomeDetailAll> pageInfo;

    public PageInfo<IncomeDetailAll> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IncomeDetailAll> pageInfo) {
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

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public Long getBeginAmount() {
        return beginAmount;
    }

    public void setBeginAmount(Long beginAmount) {
        this.beginAmount = beginAmount;
    }

    public Long getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(Long endAmount) {
        this.endAmount = endAmount;
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
}

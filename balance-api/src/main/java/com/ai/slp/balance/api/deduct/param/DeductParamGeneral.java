package com.ai.slp.balance.api.deduct.param;

import com.ai.opt.base.vo.BaseInfo;

import java.util.List;

/**
 * 普通扣款参数<br>
 *
 * Date: 2015年8月31日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class DeductParamGeneral extends BaseInfo {

    /**
     * 系统ID，必填
     */
    private String systemId;

    /**
     * 外部单号，必填
     */
    private String externalId;

    /**
     * 业务操作类型，必填
     */
    private String businessCode;

    /**
     * 账户ID，必填
     */
    private long accountId;

    /**
     * 业务操作类型，必填 类型  1:充值;2:下单;3:提现;4: 退款;5:接单;6:译员佣金;7:平台佣金
     */
    private String optType;

    /**
     * 是否校验支付密码
     */
    private int checkPwd;
    /**
     * 支付密码
     */
    private String password;
    /**
     * 扣款总金额，必填
     */
    private long totalAmount;
    
    /**
     * 专款用户ID，默认0非专款，可选 <br>
     * 1.指定用户ID－本次扣款只从专款中扣减 <br>
     * 2.未指定－本次扣款只从非专款中扣减 <br>
     */
    private long subsId;

    /**
     * 交易摘要，可空 <br>
     * 交易摘要指定科目账本的扣款优先处理，剩下的扣款金额使用系统默认规则处理 <br>
     */
    private List<TransSummary> transSummary;

    /**
     * 币种
     * @return
     */
    private String currencyUnit;

    /**
     * 业务渠道  业务订单产生的渠道，对端系统标识，例如支付宝、银联、光大银行、中译语通科技有限公司
     * @return
     */
    private String channel;

    /**
     * 业务描述 请求方业务描述，例如﻿﻿翻译下单，订单号：312321
     * @return
     */
    private String busiDesc;

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBusiDesc() {
        return busiDesc;
    }

    public void setBusiDesc(String busiDesc) {
        this.busiDesc = busiDesc;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public int getCheckPwd() {
        return checkPwd;
    }

    public void setCheckPwd(int checkPwd) {
        this.checkPwd = checkPwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<TransSummary> getTransSummary() {
        return transSummary;
    }

    public void setTransSummary(List<TransSummary> transSummary) {
        this.transSummary = transSummary;
    }

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }
}

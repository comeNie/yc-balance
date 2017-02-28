package com.ai.slp.balance.api.deposit.param;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 现金存入请求参数 <br>
 * Date: 2015年8月14日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author lilg
 */
public class DepositParam extends BaseInfo {

    private static final long serialVersionUID = 787806499466278335L;

    /**
     * 系统ID，必填
     */
    private String systemId;

    /**
     * 账户ID,必填
     */
    private long accountId;

    /**
     * 业务订单流水号，必填
     */
    private String busiSerialNo;

    /**
     * 交易摘要，至少1个
     */
    private List<TransSummary> transSummary;

    /**
     * 专款用户ID，默认0非专款，可选
     */
    private long subsId;

    /**
     * 业务描述   对应serial表中的remark字段
     */
    private String busiDesc;

    /**
     * 币种,RMB:人民币  USD：美元
     */
    private String currencyUnit;

    /**
     * 业务渠道,0：余额 1：支付宝 2：网银 3：pay pal 5：后付 6：积分 7：优惠劵 对应serial表中的CHANNEL字段
     */
    private String payStyle;

    /**
     * 业务操作类型  内部系统必填。300000：余额充值
     */
    private String busiOperCode;

    public String getBusiOperCode() {
        return busiOperCode;
    }

    public void setBusiOperCode(String busiOperCode) {
        this.busiOperCode = busiOperCode;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public String getPayStyle() { return payStyle; }

    public void setPayStyle(String payStyle) { this.payStyle = payStyle; }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getBusiSerialNo() {
        return busiSerialNo;
    }

    public void setBusiSerialNo(String busiSerialNo) {
        this.busiSerialNo = busiSerialNo;
    }

    public List<TransSummary> getTransSummary() {
        return transSummary;
    }

    public void setTransSummary(List<TransSummary> transSummary) {
        this.transSummary = transSummary;
    }

    public String getBusiDesc() {
        return busiDesc;
    }

    public void setBusiDesc(String busiDesc) {
        this.busiDesc = busiDesc;
    }

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }

}

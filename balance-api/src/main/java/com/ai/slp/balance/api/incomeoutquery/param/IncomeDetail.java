package com.ai.slp.balance.api.incomeoutquery.param;

import com.ai.opt.base.vo.BaseInfo;

import java.util.Date;

/**
 * Created by liquid on 16/11/8.
 */
public class IncomeDetail extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     */
//    private Long acctId;
//
    /**
     *时间
     */
    private Date payTime;

    /**
     * 交易金额
     */
    private Long totalAmount;
    //收支标记
    private String incomeFlag;

    public String getIncomeFlag() {
        return incomeFlag;
    }

    public void setIncomeFlag(String incomeFlag) {
        this.incomeFlag = incomeFlag;
    }
    /**
     *收入
     */
    private Long incomeBalance;

    public Long getOutBalance() {
        return outBalance;
    }

    public void setOutBalance(Long outBalance) {
        this.outBalance = outBalance;
    }

    public Long getIncomeBalance() {
        return incomeBalance;
    }

    public void setIncomeBalance(Long incomeBalance) {
        this.incomeBalance = incomeBalance;
    }

    /**
     *支出

     */
    private Long outBalance;

    /**
     *当前余额
     */
//    private Long presentAmoun;

    /**
     *币种：人民币,美元
     */
    private String currencyUnit;

    /**
     *类型1:充值；2:下单；3:提现；4: 退款
     */
    private String optType;

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getBalancePre() {
        return balancePre;
    }

    public void setBalancePre(Long balancePre) {
        this.balancePre = balancePre;
    }

    /**
     *对方

     */
    private String channel;

    /**
     *详细说明 例如：充值；翻译下单，订单号：312321；
     */
    private String remark;

    /**
     *异动前余额
     *
     */
    private Long balancePre;

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }



    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }


}

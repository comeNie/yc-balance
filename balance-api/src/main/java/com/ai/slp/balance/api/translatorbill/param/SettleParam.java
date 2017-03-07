package com.ai.slp.balance.api.translatorbill.param;


import java.io.Serializable;

/**
 * Created by liquid on 17/2/27.
 */
public class SettleParam implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 应结金额(必填)
     */
    private Long accountAmount;
    /**
     *结算方式(必填)
     */
    private String accountType;
    /**
     * 结算账户(必填)
     */
    private String settleAccount;
    /**
     * 账单状态
     */
    private String state;
    /**
     * 账单ID(必填)
     */
    private String billID;

    public Long getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Long accountAmount) {
        this.accountAmount = accountAmount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getSettleAccount() {
        return settleAccount;
    }

    public void setSettleAccount(String settleAccount) {
        this.settleAccount = settleAccount;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

package com.ai.slp.balance.api.translatorbill.param;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liquid on 17/2/27.
 */
public class AccountParam implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID(必填)
     */
    private String targetID;
    /**
     *用户名(必填) 如果用户不是企业用户,传入用户ID,如果用户是企业用户,需要传入企业ID
     */
    private String targetName;
    /**
     * 结算日,例如每月5号,传"5"
     */
    private String accountDay;
    /**
     * 结算周期,例如以月为周期,即传"1"
     */
    private String accountPeriod;
    /**
     * 结算方式  1：预付费2：后付费
     */
    private String accountType;
    /**
     * 折扣,传小数,例如88折,传入0.88
     */
    private BigDecimal discount;
    /**
     * 结算类型,1，企业客户；2，个人客户；3，译员；4，LSP；
     */
    private String targetType;

    public String getTargetID() {
        return targetID;
    }

    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getAccountDay() {
        return accountDay;
    }

    public void setAccountDay(String accountDay) {
        this.accountDay = accountDay;
    }

    public String getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }
}

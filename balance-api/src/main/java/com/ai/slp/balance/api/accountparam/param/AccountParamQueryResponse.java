package com.ai.slp.balance.api.accountparam.param;

import com.ai.opt.base.vo.BaseResponse;

import java.math.BigDecimal;

/**
 * 帐户查询返回参数
 */
public class AccountParamQueryResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
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

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
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
}
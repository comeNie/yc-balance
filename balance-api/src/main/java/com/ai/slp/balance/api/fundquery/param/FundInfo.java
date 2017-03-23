package com.ai.slp.balance.api.fundquery.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 余额查询结果对象
 *
 * Date: 2015年10月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FundInfo extends BaseResponse implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 租户ID
     */
    private String tenantId;

    /**
     * 折扣,传小数,例如88折,返回0.88
     */
    private BigDecimal discount;

    /**
     * 结算方式  1：预付费2：后付费
     */
    private String accountType;

    /**
     * 账户ID
     */
    private long accountId;

    /**
     * 账户余额
     */
    private long balance;

    /**
     * 币种 1:人民币   2：美元
     */

    private String currencyUnit;

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    /**
     * 账本列表
     */
    private List<FundBook> fundBooks;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<FundBook> getFundBooks() {
        return fundBooks;
    }

    public void setFundBooks(List<FundBook> fundBooks) {
        this.fundBooks = fundBooks;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}

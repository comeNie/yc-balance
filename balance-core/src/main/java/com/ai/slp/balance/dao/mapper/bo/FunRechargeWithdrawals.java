package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunRechargeWithdrawals {
    private String wid;

    private String username;

    private String mobilephone;

    private String fullname;

    private String email;

    private String type;

    private String pattem;

    private String accountNumber;

    private String money;

    private String currency;

    private String applyRemark;

    private String state;

    private String applyPeople;

    private Timestamp applyTime;

    private String bruisesPeople;

    private Timestamp bruisesTime;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPattem() {
        return pattem;
    }

    public void setPattem(String pattem) {
        this.pattem = pattem == null ? null : pattem.trim();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark == null ? null : applyRemark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getApplyPeople() {
        return applyPeople;
    }

    public void setApplyPeople(String applyPeople) {
        this.applyPeople = applyPeople == null ? null : applyPeople.trim();
    }

    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    public String getBruisesPeople() {
        return bruisesPeople;
    }

    public void setBruisesPeople(String bruisesPeople) {
        this.bruisesPeople = bruisesPeople == null ? null : bruisesPeople.trim();
    }

    public Timestamp getBruisesTime() {
        return bruisesTime;
    }

    public void setBruisesTime(Timestamp bruisesTime) {
        this.bruisesTime = bruisesTime;
    }
}
package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunAccount {
    private String billId;

    private String targetType;

    private String targetId;

    private String targetName;

    private String accountCls;

    private String accountPeriod;

    private String accountPeriodDay;

    private Timestamp planAccountTime;

    private Timestamp actAccountTime;

    private Timestamp payTime;

    private String nickname;

    private String lspAdmin;

    private Long billFee;

    private Long platFee;

    private Long accountAmout;

    private Timestamp createTime;

    private Timestamp startAccountTime;

    private Timestamp endAccountTime;

    private Integer state;

    private String accountType;

    private String settleAccount;

    private String content;

    private String flag;

    private Long translatorFee;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType == null ? null : targetType.trim();
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName == null ? null : targetName.trim();
    }

    public String getAccountCls() {
        return accountCls;
    }

    public void setAccountCls(String accountCls) {
        this.accountCls = accountCls == null ? null : accountCls.trim();
    }

    public String getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod == null ? null : accountPeriod.trim();
    }

    public String getAccountPeriodDay() {
        return accountPeriodDay;
    }

    public void setAccountPeriodDay(String accountPeriodDay) {
        this.accountPeriodDay = accountPeriodDay == null ? null : accountPeriodDay.trim();
    }

    public Timestamp getPlanAccountTime() {
        return planAccountTime;
    }

    public void setPlanAccountTime(Timestamp planAccountTime) {
        this.planAccountTime = planAccountTime;
    }

    public Timestamp getActAccountTime() {
        return actAccountTime;
    }

    public void setActAccountTime(Timestamp actAccountTime) {
        this.actAccountTime = actAccountTime;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getLspAdmin() {
        return lspAdmin;
    }

    public void setLspAdmin(String lspAdmin) {
        this.lspAdmin = lspAdmin == null ? null : lspAdmin.trim();
    }

    public Long getBillFee() {
        return billFee;
    }

    public void setBillFee(Long billFee) {
        this.billFee = billFee;
    }

    public Long getPlatFee() {
        return platFee;
    }

    public void setPlatFee(Long platFee) {
        this.platFee = platFee;
    }

    public Long getAccountAmout() {
        return accountAmout;
    }

    public void setAccountAmout(Long accountAmout) {
        this.accountAmout = accountAmout;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getStartAccountTime() {
        return startAccountTime;
    }

    public void setStartAccountTime(Timestamp startAccountTime) {
        this.startAccountTime = startAccountTime;
    }

    public Timestamp getEndAccountTime() {
        return endAccountTime;
    }

    public void setEndAccountTime(Timestamp endAccountTime) {
        this.endAccountTime = endAccountTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public String getSettleAccount() {
        return settleAccount;
    }

    public void setSettleAccount(String settleAccount) {
        this.settleAccount = settleAccount == null ? null : settleAccount.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Long getTranslatorFee() {
        return translatorFee;
    }

    public void setTranslatorFee(Long translatorFee) {
        this.translatorFee = translatorFee;
    }
}
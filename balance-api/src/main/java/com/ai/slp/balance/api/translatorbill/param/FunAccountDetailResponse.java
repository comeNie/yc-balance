package com.ai.slp.balance.api.translatorbill.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class FunAccountDetailResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String detailId;

    private String billId;

    private String orderId;

    private Timestamp orderTime;

    private String langungePairName;

    private String nickname;

    private String currencyUnit;

    private Long totalFee;

    private Long platFee;

    private Long interperFee;

    private String nickname2;

    private String lspId;

    private String state;

    private Long translatorFee;

    private Long lspFee;
    private Long discountFee;

    public Long getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Long discountFee) {
        this.discountFee = discountFee;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public String getLangungePairName() {
        return langungePairName;
    }

    public void setLangungePairName(String langungePairName) {
        this.langungePairName = langungePairName == null ? null : langungePairName.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getPlatFee() {
        return platFee;
    }

    public void setPlatFee(Long platFee) {
        this.platFee = platFee;
    }

    public Long getInterperFee() {
        return interperFee;
    }

    public void setInterperFee(Long interperFee) {
        this.interperFee = interperFee;
    }

    public String getNickname2() {
        return nickname2;
    }

    public void setNickname2(String nickname2) {
        this.nickname2 = nickname2 == null ? null : nickname2.trim();
    }

    public String getLspId() {
        return lspId;
    }

    public void setLspId(String lspId) {
        this.lspId = lspId == null ? null : lspId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getTranslatorFee() {
        return translatorFee;
    }

    public void setTranslatorFee(Long translatorFee) {
        this.translatorFee = translatorFee;
    }

    public Long getLspFee() {
        return lspFee;
    }

    public void setLspFee(Long lspFee) {
        this.lspFee = lspFee;
    }
}
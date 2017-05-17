package com.ai.slp.balance.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 余额中心扣款参数 <br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class DeductVo extends BaseVo {

    /**
     * 外部流水号
     */
    private String externalId;

    /**
     * 业务描述
     */
    private String busiDesc;

    /**
     * 本次交易总额，循环摘要累加计算后赋值
     */
    private long totalAmount;

    /**
     * 订单流水，在订单交易记录后赋值
     */
    private String paySerialCode;

    /**
     * 本次交易所含资金类型,由业务接口调用时赋值
     */
    private List<String> fundTypes;

    /**
     * 返回资金类型
     */
    public List<String> getFundTypes() {
        return fundTypes;
    }

    /**
     * 交易摘要
     */
    private List<TransSummaryVo> transSummary;

    /**
     * 用户ID
     */
    private long subsId;

    /**
     * 业务操作类型，必填 类型  1:充值;2:下单;3:提现;4: 退款;5:接单;6:译员佣金;7:平台佣金
     */
    private String optType;

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
     * 业务操作类型  300001
     * @return
     */
    private String businessCode;

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    /**
     * 业务类型 1：支付 2：充值
     */
    private String busiType;

    public String getBusiType() {
		return busiType;
	}

    public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

    /**
     * 增加资金类型
     */
    public void addFundType(String fundType) {
        if (fundTypes == null) {
            fundTypes = new ArrayList<String>();
        }
        fundTypes.add(fundType);
    }

    public TransSummaryVo createTransSummary() {
        if (transSummary == null) {
            transSummary = new ArrayList<TransSummaryVo>();
        }
        TransSummaryVo vo = new TransSummaryVo();
        transSummary.add(vo);
        return vo;
    }

    public void addTransSummary(long bookId, long subjectId, long amount) {
        TransSummaryVo obj = this.createTransSummary();
        obj.setBookId(bookId);
        obj.setSubjectId(subjectId);
        obj.setAmount(amount);
    }

    /**
     * 扣款交易摘要内部类 <br>
     *
     * Date: 2015年8月27日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     * 
     * @author lilg
     */
    public static final class TransSummaryVo {

        private TransSummaryVo() {

        }

        /**
         * 账本ID
         */
        private long bookId;

        /**
         * 资金科目ID
         */
        private long subjectId;

        /**
         * 金额
         */
        private long amount;

        /**
         * 销账科目ID
         */
        private long feeSubjectId;

        public long getBookId() {
            return bookId;
        }

        public void setBookId(long bookId) {
            this.bookId = bookId;
        }

        public long getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(long subjectId) {
            this.subjectId = subjectId;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        public long getFeeSubjectId() {
            return feeSubjectId;
        }

        public void setFeeSubjectId(long feeSubjectId) {
            this.feeSubjectId = feeSubjectId;
        }

    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<TransSummaryVo> getTransSummary() {
        return transSummary;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaySerialCode() {
        return paySerialCode;
    }

    public void setPaySerialCode(String paySerialCode) {
        this.paySerialCode = paySerialCode;
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

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }
}

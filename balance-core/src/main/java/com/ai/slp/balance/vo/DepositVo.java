package com.ai.slp.balance.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 余额中心存款参数 <br>
 * Date: 2015年8月20日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author lilg
 */
public class DepositVo extends BaseVo {

    /**
     * 业务订单号
     */
    private String busiSerialNo;

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
     * 交易摘要
     */
    private List<TransSummaryVo> transSummary;

    /**
     * 用户ID
     */
    private long subsId;

    /**
     * 业务渠道,0：余额 1：支付宝 2：网银 3：pay pal 5：后付 6：积分 7：优惠劵 对应serial表中的CHANNEL字段
     */
    private String payStyle;

    /**
     * 币种,RMB:人民币  USD：美元
     */
    private String currencyUnit;

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

    /**
     * 创建一个交易摘要
     *
     * @return
     * @author lilg
     */
    public TransSummaryVo createTransSummary() {
        if (transSummary == null) {
            transSummary = new ArrayList<TransSummaryVo>();
        }
        TransSummaryVo vo = new TransSummaryVo();
        transSummary.add(vo);
        return vo;
    }

    /**
     * 返回资金类型
     */
    public List<String> getFundTypes() {
        return fundTypes;
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

    /**
     * 交易摘要内部类 <br>
     * Date: 2015年8月21日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     *
     * @author lilg
     */
    public static final class TransSummaryVo {

        private TransSummaryVo() {

        }

        /**
         * 科目ID，必填
         */
        private long subjectId;

        /**
         * 金额，单位(厘)，必填
         */
        private long amount;

        /**
         * 生效时间 格式：yyyy-MM-dd HH:mm:ss </br> 可选，默认[2015-01-01 00:00:00]
         */
        private String fundeffDate;

        /**
         * 失效时间 </br> 格式：yyyy-MM-dd HH:mm:ss </br> 可选，默认[2099-12-31 23:59:59]
         */
        private String fundexpDate;

        /**
         * 特征码，可选
         */
        private String featureCode;

        /**
         * 摘要对应的账本，账本确认时赋值
         */
        private long bookId;




        /**
         * 账本状态 状态取值如下：  0：无效  1：有效 2：冻结  如果不传，默认账本状态为1:有效；如果资金科目为100001：译员收入，请调用方传2:冻结
         */

        private String bookStatus;

        public String getBookStatus() {
            return bookStatus;
        }

        public void setBookStatus(String bookStatus) {
            this.bookStatus = bookStatus;
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

        public String getFundeffDate() {
            return fundeffDate;
        }

        public void setFundeffDate(String fundeffDate) {
            this.fundeffDate = fundeffDate;
        }

        public String getFundexpDate() {
            return fundexpDate;
        }

        public void setFundexpDate(String fundexpDate) {
            this.fundexpDate = fundexpDate;
        }

        public String getFeatureCode() {
            return featureCode;
        }

        public void setFeatureCode(String featureCode) {
            this.featureCode = featureCode;
        }

        public long getBookId() {
            return bookId;
        }

        public void setBookId(long bookId) {
            this.bookId = bookId;
        }
    }


    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public String getPayStyle() { return payStyle; }

    public void setPayStyle(String payStyle) { this.payStyle = payStyle; }

    public String getBusiSerialNo() {
        return busiSerialNo;
    }

    public void setBusiSerialNo(String busiSerialNo) {
        this.busiSerialNo = busiSerialNo;
    }

    public String getBusiDesc() {
        return busiDesc;
    }

    public void setBusiDesc(String busiDesc) {
        this.busiDesc = busiDesc;
    }

    public String getPaySerialCode() {
        return paySerialCode;
    }

    public void setPaySerialCode(String paySerialCode) {
        this.paySerialCode = paySerialCode;
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

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }
}

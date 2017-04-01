package com.ai.slp.balance.api.incomeoutquery.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * Created by liquid on 16/11/8.
 *
 * 收入支出查询结果对象
 */
public class FundBookQueryResponseAll extends BaseResponse {


    private static final long serialVersionUID = 1L;

    /**
     * 美元收入
     */
    private Long incomeAmountUSD;
    /**
     * 美元支出
     */
    private Long outAmountUSD;
    /**
     * 人民币收入
     */
    private Long incomeAmountRMB;
    /**
     * 人民币支出
     */
    private Long outAmountRMB;

    PageInfo<IncomeDetailAll> pageInfo;

    public PageInfo<IncomeDetailAll> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IncomeDetailAll> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Long getIncomeAmountUSD() {
        return incomeAmountUSD;
    }

    public void setIncomeAmountUSD(Long incomeAmountUSD) {
        this.incomeAmountUSD = incomeAmountUSD;
    }

    public Long getOutAmountUSD() {
        return outAmountUSD;
    }

    public void setOutAmountUSD(Long outAmountUSD) {
        this.outAmountUSD = outAmountUSD;
    }

    public Long getIncomeAmountRMB() {
        return incomeAmountRMB;
    }

    public void setIncomeAmountRMB(Long incomeAmountRMB) {
        this.incomeAmountRMB = incomeAmountRMB;
    }

    public Long getOutAmountRMB() {
        return outAmountRMB;
    }

    public void setOutAmountRMB(Long outAmountRMB) {
        this.outAmountRMB = outAmountRMB;
    }
}

package com.ai.slp.balance.api.incomeoutquery.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

import java.util.List;

/**
 * Created by liquid on 16/11/8.
 *
 * 收入支出查询结果对象
 */
public class FundBookQueryResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;


    PageInfo<IncomeDetail> pageInfo;

    public PageInfo<IncomeDetail> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IncomeDetail> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

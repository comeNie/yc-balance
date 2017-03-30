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


    PageInfo<IncomeDetailAll> pageInfo;

    public PageInfo<IncomeDetailAll> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IncomeDetailAll> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

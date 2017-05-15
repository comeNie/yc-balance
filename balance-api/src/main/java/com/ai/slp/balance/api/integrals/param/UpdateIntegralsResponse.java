package com.ai.slp.balance.api.integrals.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetail;

/**
 * Created by liquid on 16/11/8.
 *
 * 收入支出查询结果对象
 */
public class UpdateIntegralsResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;


    PageInfo<IncomeDetail> pageInfo;

    public PageInfo<IncomeDetail> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IncomeDetail> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

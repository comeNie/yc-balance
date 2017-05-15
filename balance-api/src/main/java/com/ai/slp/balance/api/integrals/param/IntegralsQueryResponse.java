package com.ai.slp.balance.api.integrals.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * Created by liquid on 16/11/8.
 *
 * 收入支出查询结果对象
 */
public class IntegralsQueryResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;


    PageInfo<IntegralsDetail> pageInfo;

    public PageInfo<IntegralsDetail> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IntegralsDetail> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

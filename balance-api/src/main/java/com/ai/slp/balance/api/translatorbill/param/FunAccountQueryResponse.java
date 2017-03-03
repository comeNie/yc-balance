package com.ai.slp.balance.api.translatorbill.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

import java.io.Serializable;

/**
 * Created by liquid on 17/2/27.
 *
 * 收入支出查询结果对象
 */
public class FunAccountQueryResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;


    PageInfo<FunAccountResponse> pageInfo;

    public PageInfo<FunAccountResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunAccountResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

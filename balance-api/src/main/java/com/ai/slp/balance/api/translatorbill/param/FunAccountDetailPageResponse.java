package com.ai.slp.balance.api.translatorbill.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;


public class FunAccountDetailPageResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;


    PageInfo<FunAccountDetailResponse> pageInfo;

    public PageInfo<FunAccountDetailResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunAccountDetailResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
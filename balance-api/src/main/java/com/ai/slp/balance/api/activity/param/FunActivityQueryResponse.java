package com.ai.slp.balance.api.activity.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 活动策略查询.<br>
 */
public class FunActivityQueryResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;

    /**
     * 分页时必填
     */
    PageInfo<FunActivityResponse> pageInfo;

    public PageInfo<FunActivityResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunActivityResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

package com.ai.slp.balance.api.integrals.param;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetail;

/**
 * 账号查询请求参数
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class IncomeQueryIntegralsRequest extends BaseInfo{

    /**
     *用户id，必填
     */
    private String userId;
    /**
     * 积分收支标记 0:收入  1:支出
     */
    private String flag;
    /**
     * 分页时必填
     */
    PageInfo<IntegralsDetail> pageInfo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PageInfo<IntegralsDetail> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<IntegralsDetail> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}

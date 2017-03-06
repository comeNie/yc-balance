package com.ai.slp.balance.api.translatorbill.param;

import com.ai.opt.base.vo.PageInfo;

import java.io.Serializable;

/**
 * 账号查询请求参数
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FunAccountDetailQueryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账单ID
     */
    String billID;

    /**
     * 分页时必填
     */
    PageInfo<FunAccountDetailResponse> pageInfo;

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public PageInfo<FunAccountDetailResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunAccountDetailResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

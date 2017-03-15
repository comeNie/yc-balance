package com.ai.slp.balance.api.translatorbill.param;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;

import java.io.Serializable;

/**
 * 账号查询请求参数
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FunAccountQueryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账单类型
     */
    String targetType;
    /**
     * lsp名称
     */
    String lspName;
    /**
     * lsp管理员
     */
    String lspAdmin;
    /**
     * 昵称
     */
    String nickName;

    /**
     * 结算方式
     */
    String acountType;

    /**
     * 账单生成开始时间，必填
     */
    private String beginDate;

    /**
     * 账单生成结束时间，必填
     */
    private String endDate;
    /**
     * 国际业务标识
     */
    String flag;

    /**
     * 结算状态
     */

    Integer state;


    /**
     * 分页时必填
     */
    PageInfo<FunAccountResponse> pageInfo;

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getLspName() {
        return lspName;
    }

    public void setLspName(String lspName) {
        this.lspName = lspName;
    }

    public String getLspAdmin() {
        return lspAdmin;
    }

    public void setLspAdmin(String lspAdmin) {
        this.lspAdmin = lspAdmin;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAcountType() {
        return acountType;
    }

    public void setAcountType(String acountType) {
        this.acountType = acountType;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public PageInfo<FunAccountResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<FunAccountResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }
}

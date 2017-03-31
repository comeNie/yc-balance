package com.ai.slp.balance.api.incomeoutquery.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.incomeoutquery.param.FundBookQueryResponse;
import com.ai.slp.balance.api.incomeoutquery.param.FundBookQueryResponseAll;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeQueryRequest;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeQueryRequestAll;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 收支查询接口
 *
 * Date: 2015年8月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author lilg
 */
@Path("/incomeOutQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IncomeOutQuerySV {
    /**
     *为用户提供查询账户余额及指定时间段内全部账户收入和支付的记录。
     * @param accountId
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @ApiDocMethod
     * @RestRelativeURL incomeOutQueryService/incomeOutQuery
     */
    @POST
    @Path("/incomeOutQuery")
    public FundBookQueryResponse incomeOutQuery(IncomeQueryRequest accountId) throws BusinessException,SystemException;

    /**
     *为运营后台提供查询账户余额及指定时间段内全部账户收入和支付的记录。
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @ApiDocMethod
     * @RestRelativeURL incomeOutQueryService/incomeOutQueryAll
     */
    @POST
    @Path("/incomeOutQueryAll")
    public FundBookQueryResponseAll incomeOutQueryAll(IncomeQueryRequestAll param) throws BusinessException,SystemException;
}

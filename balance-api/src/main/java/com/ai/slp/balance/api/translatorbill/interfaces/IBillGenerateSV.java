package com.ai.slp.balance.api.translatorbill.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.incomeoutquery.param.FundBookQueryResponse;
import com.ai.slp.balance.api.resquery.param.*;
import com.ai.slp.balance.api.translatorbill.param.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 译员账单接口
 *
 * Date: 2017年2月17日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 *
 * @author liquid
 */
@Path("/billQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IBillGenerateSV {

    /**
     * 译员账单生成服务.<br>
     * 生成译员账单,用于运营人员查询账单<br>
     * 
     * @param param 结算账单类型
     * @return 账单生成是否成功
     * @throws BusinessException,SystemException
     * @author liquid
     * @ApiDocMethod
     * @ApiCode ABM_0245
     * @RestRelativeURL billQueryService/generateBill
     */
	@POST
	@Path("/generateBill")
    public boolean generateBill(String param) throws BusinessException,SystemException;

   /**
     * 账单查询.<br>
     * 根据国内业务和结算状态查询业务记录<br>
     * 
     * @param param
     * @return 套餐列表
     * @throws BusinessException,SystemException
     * @author liquid
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL billQueryService/queryFunAccount
     */
	@POST
	@Path("/queryFunAccount")
    public FunAccountQueryResponse queryFunAccount(FunAccountQueryRequest param) throws BusinessException,SystemException;

    /**
     * 账单明细查询
     * 
     * @param param
     * @return 账单明细查询
     * @throws BusinessException,SystemException
     * @author liquid
     * @RestRelativeURL billQueryService/queryFunAccountDetail
     */
	@POST
	@Path("/queryFunAccountDetail")
    public FunAccountDetailPageResponse queryFunAccountDetail(FunAccountDetailQueryRequest param) throws BusinessException,SystemException;

    /**
     * 账单结算
     *
     * @param param
     * @return 账单明细查询
     * @throws BusinessException,SystemException
     * @author liquid
     * @RestRelativeURL billQueryService/settleBill
     */
    @POST
    @Path("/settleBill")
    public String settleBill(SettleParam param) throws BusinessException,SystemException;

    /**
     * 创建用户信息
     *
     * @param accountParam
     * @return 创建用户信息
     * @throws BusinessException,SystemException
     * @author liquid
     * @RestRelativeURL billQueryService/insertParam
     */
    @POST
    @Path("/insertParam")
    public String insertParam(AccountParam accountParam) throws BusinessException,SystemException;


}


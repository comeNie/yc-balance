package com.ai.slp.balance.api.accountparam.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.accountparam.param.AccParamReq;
import com.ai.slp.balance.api.accountparam.param.AccountParamQueryResponse;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateParam;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 帐户配置表查询<br>
 *
 * Date: 2017年4月1日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author liquid
 */
@Path("/accountParamService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IAccountParamSV {

    /**
     * 查询帐户配置.<br>
     * @param paramReq
     * @return 目标ID
     * @author liquid
     * @ApiDocMethod
     * @ApiCode ABM_0011
     * @RestRelativeURL accountParamService/queryAccountParamById
     */
	@POST
	@Path("/queryAccountParamById")
    public AccountParamQueryResponse queryAccountParam(AccParamReq paramReq) throws BusinessException,SystemException;

    /**
     * 账户资料修改.<br>
     * 对账户资料进行修改<br>
     * 
     * @param param
     * @throws BusinessException,SystemException
     * @author liquid
     * @ApiDocMethod
     * @ApiCode ABM_0015
     * @RestRelativeURL accountParamService/updateAccountParam
     */
	@POST
	@Path("/updateAccountParam")
    public AccountParamUpdateResponse updateAccountParam(AccountParamUpdateParam param) throws BusinessException,SystemException;

}

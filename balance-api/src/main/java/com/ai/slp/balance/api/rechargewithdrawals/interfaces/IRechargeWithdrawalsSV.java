package com.ai.slp.balance.api.rechargewithdrawals.interfaces;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageQueryResponse;
import com.ai.slp.balance.api.rechargewithdrawals.param.ChangeStateRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.QueryByIdRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.QueryInfoResponse;


/**
 * 充值提现管理接口
 */
@Path("/rechargewithdrawals")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IRechargeWithdrawalsSV {

	/**
     * 充值提现列表查询分页
     * @return 充值提现列表
     * @throws BusinessException,SystemException
     * @author shancc
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL rechargewithdrawals/rechargewithdrawalsPage
	 */
	@POST
	@Path("/rechargewithdrawalsPage")
	public ReWiehPageQueryResponse rechargewithdrawalsPage(ReWiehPagePageQueryRequest param)throws BusinessException,SystemException;
	
	/**
	 * 更改状态为确认
	 * @throws BusinessException,SystemException
	 * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL rechargewithdrawals/updateStateConfirm
     */
	@POST
	@Path("/updateStateConfirm")
    public BaseResponse updateStateConfirm(ChangeStateRequest param) throws BusinessException,SystemException;
	/**
	 * 更改状态为锁定
	 * @throws BusinessException,SystemException
	 * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL rechargewithdrawals/updateStateLock
     */
	@POST
	@Path("/updateStateLock")
    public BaseResponse updateStateLock(ChangeStateRequest param) throws BusinessException,SystemException;
	
	/**
	 * 根据ID查询
	 * @throws BusinessException,SystemException
	 * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL rechargewithdrawals/queryRechWith
     */
	@POST
	@Path("/queryRechWith")
    public QueryInfoResponse queryRechWith(QueryByIdRequest param) throws BusinessException,SystemException;
}


package com.ai.slp.balance.api.rechargewithdrawals.interfaces;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageQueryResponse;


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
	
}


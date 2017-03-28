package com.ai.slp.balance.api.activity.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityQueryResponse;

/**
 * 活动策略接口
 */
@Path("/activityQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IActivitySV {


	/**
     * 活动策略查询.<br>
     * @param param
     * @return 活动策略列表
     * @throws BusinessException,SystemException
     * @author shancc
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL activityQueryService/queryFunActivity
     */
	@POST
	@Path("/queryFunActivity")
    public FunActivityQueryResponse queryFunActivity(FunActivityQueryRequest param) throws BusinessException,SystemException;
	
	/**
	 * 删除活动策略
	 * @param couponName
	 * @throws BusinessException,SystemException
	 * @author shancc
	 * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL activityQueryService/deleteActivity
     */
	@POST
	@Path("/deleteActivity")
	public BaseResponse deleteActivity(Integer activityId)throws BusinessException,SystemException;
}


package com.ai.slp.balance.api.activityrule.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityQueryRuleResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleActivityRequest;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleRequest;
import com.ai.slp.balance.api.activityrule.param.UpdateFunActivityRuleResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 活动规则接口
 */
@Path("/activityRuleQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IActivityRuleSV {


	/**
     * 活动策略下的规则查询.<br>
     * @param activityID
     * @return 活动规则列表
     * @throws BusinessException,SystemException
     * @author lxk
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL activityRuleQueryService/queryFunActivityRule
     */
	@POST
	@Path("/queryFunActivityRule")
    public FunActivityQueryRuleResponse queryFunActivityRule(String activityID) throws BusinessException,SystemException;


	/**
	 * 积分变更.<br>
	 *
	 * @param activityRuleIds
	 * @return 成功,失败
	 * @author lxk
	 * @ApiDocMethod
	 * @ApiCode ABM_0030
	 * @RestRelativeURL activityRuleQueryService/updateFunActivityRule
	 */
	@POST
	@Path("/updateFunActivityRule")
	public UpdateFunActivityRuleResponse updateFunActivityRule(FunActivityRuleActivityRequest activityRuleIds) throws BusinessException,SystemException;

	
	/**
	 * 删除活动策略
	 * @param activityRuleId
	 * @throws BusinessException,SystemException
	 * @author lxk
	 * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL activityRuleQueryService/deleteActivityRule
     */
	@POST
	@Path("/deleteActivityRule")
	public BaseResponse deleteActivityRule(String activityRuleId)throws BusinessException,SystemException;
}


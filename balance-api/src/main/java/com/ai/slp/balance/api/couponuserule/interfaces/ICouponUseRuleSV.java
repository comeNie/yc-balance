package com.ai.slp.balance.api.couponuserule.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.couponuserule.param.SaveCouponUseRule;

/**
 * 优惠券模板接口
 */
@Path("/couponUseRuleQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ICouponUseRuleSV {


	/**
     * 使用规则查询.<br>
     * @param couponUserId
     * @return 模板列表
     * @throws BusinessException,SystemException
     * @author shancc
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL couponUseRuleQueryService/queryFunCouponUseRule
     */
	@POST
	@Path("/queryFunCouponUseRule")
    public List<FunCouponUseRuleQueryResponse> queryFunCouponUseRule(String couponUserId) throws BusinessException,SystemException;
	
	/**
	 * 添加使用规则
	 * @param couponName
	 * @throws BusinessException,SystemException
	 * @author shancc
	 * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL couponTemplateQueryService/saveCouponUseRule
     */
	@POST
	@Path("/saveCouponUseRule")
	public Integer saveCouponUseRule(SaveCouponUseRule param)throws BusinessException,SystemException;
}


package com.ai.slp.balance.api.coupontemplate.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 优惠券模板接口
 */
@Path("/couponTemplateQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ICouponTemplateSV {


   /**
     * 优惠券模板查询.<br>
     */
	@POST
	@Path("/queryFunCouponTemplate")
    public FunCouponTemplateQueryResponse queryFunCouponTemplate(FunCouponTemplateQueryRequest param) throws BusinessException,SystemException;


}


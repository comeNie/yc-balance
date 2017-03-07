package com.ai.slp.balance.api.coupontemplate.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.coupontemplate.param.CouponParam;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryResponse;
import com.ai.slp.balance.api.coupontemplate.param.ListDiscountCouponResponse;

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
	/**
	 * 根据优惠券模板ID查询优惠券明细
     */
	@POST
	@Path("/queryCouponByTemplateId")
    public ListDiscountCouponResponse queryCouponByTemplateId(CouponParam templateId) throws BusinessException,SystemException;

}


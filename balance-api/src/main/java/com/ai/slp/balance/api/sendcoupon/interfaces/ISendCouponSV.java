package com.ai.slp.balance.api.sendcoupon.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 优惠券发放接口类 <br>
 *
 */
@Path("/sendCouponService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ISendCouponSV {

    /**
     * 注册领取优惠券.<br>
     */
	@POST
	@Path("/registerSendCoupon")
    public void registerSendCoupon(String activityName, String userId) throws BusinessException,SystemException;
	
	/**
     * 线下发送/领取优惠券.<br>
     *//*
	@POST
	@Path("/offLineSendCoupon")
    public void offLineSendCoupon(int maxCount, String couponName, String userId) throws BusinessException,SystemException;*/

}

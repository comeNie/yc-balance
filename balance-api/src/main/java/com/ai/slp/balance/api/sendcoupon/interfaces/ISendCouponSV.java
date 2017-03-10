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
     * @param activityName,userId
	 * @return 优惠券生成是否成功
	 * @throws BusinessException,SystemException
	 * @author shancc
	 * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sendCouponService/registerSendCoupon
     */
	@POST
	@Path("/registerSendCoupon")
    public void registerSendCoupon(String activityName, String userId) throws BusinessException,SystemException;
	
	/**
     * 线下发送/领取优惠券.<br>
     * @throws BusinessException,SystemException
     * @RestRelativeURL sendCouponService/offLineSendCoupon
     */
     /*
	@POST
	@Path("/offLineSendCoupon")
    public void offLineSendCoupon(int maxCount, String couponName, String userId) throws BusinessException,SystemException;*/

}

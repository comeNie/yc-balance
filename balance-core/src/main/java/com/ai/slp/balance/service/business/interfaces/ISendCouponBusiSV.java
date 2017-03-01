package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

public interface ISendCouponBusiSV {
	public void registerSendCoupon(String activityName,String userId) throws BusinessException,SystemException;
	public void offLineSendCoupon(int maxCount,String couponName,String userId) throws BusinessException,SystemException;
}

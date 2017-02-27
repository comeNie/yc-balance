package com.ai.slp.balance.api.sendcoupon.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 注册领取优惠券入参.<br>
 * Date: 2015年7月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public class RegisterSendCouponReq extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 活动名称（必填）
     */
    private String activityName;
    /**
     * 用户ID（必填）
     */
    private String userId;
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}

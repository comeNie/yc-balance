package com.ai.slp.balance.api.sendcoupon.param;

import java.io.Serializable;
public class SendCouponRequest  implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *活动名称
	 */
	private String activityName;
	/**
	 * 用户ID
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

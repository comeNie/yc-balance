package com.ai.slp.balance.api.sendcoupon.param;
/**
 * 下线发放优惠券入参.<br>
 * Date: 2015年7月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public class OffLineSendCoupon {
	 private static final long serialVersionUID = 1L;

	 	private int maxCount;
	 
	    /**
	     * 优惠券模板名称
	     */
	    private String couponName;
	    /**
	     * 用户ID（必填）
	     */
	    private String userId;
		public int getMaxCount() {
			return maxCount;
		}
		public void setMaxCount(int maxCount) {
			this.maxCount = maxCount;
		}
		public String getCouponName() {
			return couponName;
		}
		public void setCouponName(String couponName) {
			this.couponName = couponName;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
	    
	    
}

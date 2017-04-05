package com.ai.slp.balance.api.sendcoupon.param;


import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class QueryCouCountRequest extends BaseInfo  {
	private static final long serialVersionUID = 1L;
    /**
	 * 状态
	 * 4 未使用
	 * 5 已使用
	 * 6 已过期
	 */
    private String status;
    /**
	 * 用户ID
	 */
    private String userId;
    /**
   	 * 有效期结束时间
   	 */
    private Timestamp effectiveEndTime;
    
    
	public Timestamp getEffectiveEndTime() {
		return effectiveEndTime;
	}
	public void setEffectiveEndTime(Timestamp effectiveEndTime) {
		this.effectiveEndTime = effectiveEndTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}

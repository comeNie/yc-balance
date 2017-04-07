package com.ai.slp.balance.api.sendcoupon.param;


import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;

public class QueryCouponRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	 /**
	 * 状态
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
    /**
     * 分页必填
     */
    private PageInfo<DeductionCouponResponse> pageInfo;

	public PageInfo<DeductionCouponResponse> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<DeductionCouponResponse> pageInfo) {
		this.pageInfo = pageInfo;
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

	public Timestamp getEffectiveEndTime() {
		return effectiveEndTime;
	}

	public void setEffectiveEndTime(Timestamp effectiveEndTime) {
		this.effectiveEndTime = effectiveEndTime;
	}
}

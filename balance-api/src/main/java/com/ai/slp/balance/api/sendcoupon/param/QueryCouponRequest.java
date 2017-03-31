package com.ai.slp.balance.api.sendcoupon.param;


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
    
}

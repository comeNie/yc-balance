package com.ai.slp.balance.api.rechargewithdrawals.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
/**
 *	查询返回结果分页 
 * @author lenovo
 */
public class ReWiehPageQueryResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;
	
	/**
     * 分页时必填
     */
    PageInfo<ReWiehPageVo> pageInfo;

	public PageInfo<ReWiehPageVo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<ReWiehPageVo> pageInfo) {
		this.pageInfo = pageInfo;
	}
}

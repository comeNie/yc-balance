package com.ai.slp.balance.service.atom.interfaces;


import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.dao.mapper.bo.FunActivity;

public interface IActivityAtomSV {
     
	/**
	 * 模糊查询活动策略列表
	 * @param funCouponTemplateQueryRequest
	 * @return
	 */
	public PageInfo<FunActivityResponse> funActivityQueryRequest(FunActivityQueryRequest funActivityQueryRequest);

	public Integer deleteActivity(Integer activityId);

	public void updateFunActivity(FunActivity funActivity);
}

package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;

public interface IActivityBusiSV {
	/**
	 * 模糊查询活动策略列表
	 */
	public PageInfo<FunActivityResponse> queryActivity(FunActivityQueryRequest funActivityQueryRequest);
	/**
	 * 删除活动策略
	 */
	public Integer deleteActivity(Integer activityId);
	
}

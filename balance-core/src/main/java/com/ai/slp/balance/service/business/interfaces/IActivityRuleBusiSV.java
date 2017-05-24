package com.ai.slp.balance.service.business.interfaces;

import com.ai.slp.balance.api.activityrule.param.FunActivityRuleResponse;

import java.util.List;

public interface IActivityRuleBusiSV {
	/**
	 * 查询活动规则列表
	 */
	public List<FunActivityRuleResponse> queryFunActivityRule(String activityID);
	/**
	 * 批量更新活动规则
	 */
	public void updateFunActivityRule(List<String> activityRuleIds);
	/**
	 * 删除活动规则
	 */
	public void deleteActivityRule(String activityRuleId);
	
}

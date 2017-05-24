package com.ai.slp.balance.service.atom.interfaces;


import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleResponse;

import java.util.List;

public interface IActivityRuleAtomSV {

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

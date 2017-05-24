package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleActivityRequest;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleRequest;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleResponse;
import com.ai.slp.balance.dao.mapper.bo.FunActivity;
import com.ai.slp.balance.service.atom.interfaces.IActivityAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IActivityRuleAtomSV;
import com.ai.slp.balance.service.business.interfaces.IActivityBusiSV;
import com.ai.slp.balance.service.business.interfaces.IActivityRuleBusiSV;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActivityRuleBusiSVImpl implements IActivityRuleBusiSV {

	@Autowired
	private IActivityRuleAtomSV iActivityRuleAtomSV;
	@Autowired
	private IActivityAtomSV iActivityAtomSV;
	@Override
	public List<FunActivityRuleResponse> queryFunActivityRule(String activityID) {
		return iActivityRuleAtomSV.queryFunActivityRule(activityID);
	}

	@Override
	public void updateFunActivityRule(FunActivityRuleActivityRequest activityRuleIds) {
		//更新活动策略
		FunActivity funActivity = new FunActivity();
		funActivity.setActivityId(activityRuleIds.getActivityId());
		funActivity.setUsedScene(activityRuleIds.getUsedScene());
		funActivity.setActivityDesc(activityRuleIds.getActivityDesc());
		funActivity.setStartTime(activityRuleIds.getStartTime());
		funActivity.setEndTime(activityRuleIds.getEndTime());
		funActivity.setStatus(activityRuleIds.getStatus());
		funActivity.setActivityTime(activityRuleIds.getActivityTime());
		iActivityAtomSV.updateFunActivity(funActivity);
		//更新活动规则
		ArrayList<FunActivityRuleRequest> funActivityRuleRequestList = activityRuleIds.getFunActivityRuleRequestList();
		iActivityRuleAtomSV.updateFunActivityRule(funActivityRuleRequestList);
	}

	@Override
	public void deleteActivityRule(String activityRuleId) {
		iActivityRuleAtomSV.deleteActivityRule(activityRuleId);
	}
}

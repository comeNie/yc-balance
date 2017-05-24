package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleResponse;
import com.ai.slp.balance.service.atom.interfaces.IActivityAtomSV;
import com.ai.slp.balance.service.business.interfaces.IActivityBusiSV;
import com.ai.slp.balance.service.business.interfaces.IActivityRuleBusiSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityRuleBusiSVImpl implements IActivityRuleBusiSV {

	@Override
	public List<FunActivityRuleResponse> queryFunActivityRule(String activityID) {
		return null;
	}

	@Override
	public void updateFunActivityRule(List<String> activityRuleIds) {

	}

	@Override
	public void deleteActivityRule(String activityRuleId) {

	}
}

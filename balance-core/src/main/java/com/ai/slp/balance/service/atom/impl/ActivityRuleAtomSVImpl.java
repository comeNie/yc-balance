package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleResponse;
import com.ai.slp.balance.dao.mapper.bo.FunActivity;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunActivityMapper;
import com.ai.slp.balance.service.atom.interfaces.IActivityAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IActivityRuleAtomSV;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityRuleAtomSVImpl implements IActivityRuleAtomSV {

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

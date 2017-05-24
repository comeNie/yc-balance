package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleRequest;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleResponse;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.FunActivity;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunActivityRule;
import com.ai.slp.balance.dao.mapper.bo.FunActivityRuleCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunActivityMapper;
import com.ai.slp.balance.service.atom.interfaces.IActivityAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IActivityRuleAtomSV;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityRuleAtomSVImpl implements IActivityRuleAtomSV {

	@Override
	public List<FunActivityRuleResponse> queryFunActivityRule(String activityID) {
		List<FunActivityRuleResponse> funActivityRuleResponseList= new ArrayList<FunActivityRuleResponse>();
		FunActivityRuleCriteria criteria = new FunActivityRuleCriteria();
		criteria.createCriteria().andActivityIdEqualTo(Long.parseLong(activityID));
		List<FunActivityRule> funActivityRules = MapperFactory.getFunActivityRuleMapper().selectByExample(criteria);
		if (!CollectionUtil.isEmpty(funActivityRules)){
			FunActivityRuleResponse funActivityRuleResponse = new FunActivityRuleResponse();
			for (FunActivityRule funActivityRule:funActivityRules){
				BeanUtils.copyProperties(funActivityRuleResponse,funActivityRule);
				funActivityRuleResponseList.add(funActivityRuleResponse);
			}
		}else {
			return null;
		}
		return funActivityRuleResponseList;
	}

	@Override
	public void updateFunActivityRule(List<FunActivityRuleRequest> activityRules) {
		for (FunActivityRuleRequest activityRule:activityRules){
			//如果记录不存在,传入的参数不含规则id则插入记录,
			if (StringUtil.isBlank(activityRule.getId())){
				FunActivityRule funActivityRuleNew = new FunActivityRule();
				funActivityRuleNew.setId(SeqUtil.getNewId(
						SeqConstants.INTEGRALS_LOG$ID).toString());
				funActivityRuleNew.setActivityId(activityRule.getActivityId());
				funActivityRuleNew.setTotalMoneyAmount(activityRule.getTotalMoneyAmount());
				funActivityRuleNew.setFrequency(activityRule.getFrequency());
				funActivityRuleNew.setCurrencyUnit(activityRule.getCurrencyUnit());
				funActivityRuleNew.setRemainingMoneyAmount(activityRule.getRemainingMoneyAmount());
				MapperFactory.getFunActivityRuleMapper().insert(funActivityRuleNew);
			}else {
				FunActivityRule funActivityRule = MapperFactory.getFunActivityRuleMapper().selectByPrimaryKey(activityRule.getId());
				funActivityRule.setTotalMoneyAmount(activityRule.getTotalMoneyAmount());
				funActivityRule.setFrequency(activityRule.getFrequency());
				funActivityRule.setCurrencyUnit(activityRule.getCurrencyUnit());
				funActivityRule.setRemainingMoneyAmount(activityRule.getRemainingMoneyAmount());
				MapperFactory.getFunActivityRuleMapper().updateByPrimaryKeySelective(funActivityRule);
			}

		}
	}

	@Override
	public void deleteActivityRule(String activityRuleId) {
		MapperFactory.getFunActivityRuleMapper().deleteByPrimaryKey(activityRuleId);
	}
}

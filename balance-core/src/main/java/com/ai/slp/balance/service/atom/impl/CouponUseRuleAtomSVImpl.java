package com.ai.slp.balance.service.atom.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.couponuserule.param.SaveCouponUseRule;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRuleCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunCouponUseRuleMapper;
import com.ai.slp.balance.service.atom.interfaces.ICouponUseRuleAtomSV;

@Component
public class CouponUseRuleAtomSVImpl implements ICouponUseRuleAtomSV {
	/**
	 * 优惠券使用规则表添加数据
	 */
	@Override
	public Integer insertBuildCouponUseRule(FunCouponUseRule funCouponUseRule) {
		FunCouponUseRuleMapper funCouponUseRuleMapper = MapperFactory.getFunCouponUseRuleMapper();
		return funCouponUseRuleMapper.insert(funCouponUseRule);
	}

	@Override
	public List<FunCouponUseRuleQueryResponse> queryCouponUseRule(String couponUserId) {
		List<FunCouponUseRuleQueryResponse> funCouponUseRuleQueryResponses =  new ArrayList<FunCouponUseRuleQueryResponse>();
		 FunCouponUseRuleCriteria funCouponUseRuleCriteria = new FunCouponUseRuleCriteria();
		 FunCouponUseRuleCriteria.Criteria criteria= funCouponUseRuleCriteria.createCriteria();
		 criteria.andCouponUserIdEqualTo(couponUserId);
		 FunCouponUseRuleMapper funCouponUseRuleMapper = MapperFactory.getFunCouponUseRuleMapper();
		 List<FunCouponUseRule> selectByExample = funCouponUseRuleMapper.selectByExample(funCouponUseRuleCriteria);
	        if (!CollectionUtil.isEmpty(selectByExample)){

	            for (int i=0;i<selectByExample.size();i++){
	            	FunCouponUseRuleQueryResponse funCouponUseRuleQueryResponse = new FunCouponUseRuleQueryResponse();
	                BeanUtils.copyProperties(funCouponUseRuleQueryResponse,selectByExample.get(i));
	                funCouponUseRuleQueryResponses.add(funCouponUseRuleQueryResponse);
	            }
	        }
		
		return funCouponUseRuleQueryResponses;
	}


	
}

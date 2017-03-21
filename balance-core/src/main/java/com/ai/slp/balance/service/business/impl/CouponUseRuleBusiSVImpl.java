package com.ai.slp.balance.service.business.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.couponuserule.param.SaveCouponUseRule;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;
import com.ai.slp.balance.service.atom.interfaces.ICouponUseRuleAtomSV;
import com.ai.slp.balance.service.business.interfaces.ICouponUseRuleBusiSV;
@Service
@Transactional
public class CouponUseRuleBusiSVImpl implements ICouponUseRuleBusiSV {
	
	@Autowired
	private ICouponUseRuleAtomSV couponUseRuleAtomSV;

	/**
	 * 查询使用规则
	 */
	@Override
	public List<FunCouponUseRuleQueryResponse> queryCouponUseRule(String couponUserId) {
		List<FunCouponUseRuleQueryResponse> queryCouponUseRule = couponUseRuleAtomSV.queryCouponUseRule(couponUserId);
		return queryCouponUseRule;
	}
	/**
	 * 添加使用规则
	 */
	@Override
	public Integer saveCouponUseRule(SaveCouponUseRule param) {
		FunCouponUseRule funCouponUseRule = new FunCouponUseRule();
    	funCouponUseRule.setCouponUserId(param.getCouponUserId());
    	funCouponUseRule.setFaceValue(param.getFaceValue());
    	funCouponUseRule.setRequiredMoneyAmount(param.getRequiredMoneyAmount());
    	funCouponUseRule.setCurrencyUnit(param.getCurrencyUnit());
    	Date date1=new Date();
        DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        funCouponUseRule.setCreateTime(Timestamp.valueOf(format1.format(date1)));
		return couponUseRuleAtomSV.insertBuildCouponUseRule(funCouponUseRule);
	}
	
}

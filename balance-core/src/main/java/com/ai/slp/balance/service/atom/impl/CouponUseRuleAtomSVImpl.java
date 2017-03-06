package com.ai.slp.balance.service.atom.impl;
import org.springframework.stereotype.Component;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.ICouponUseRuleAtomSV;

@Component
public class CouponUseRuleAtomSVImpl implements ICouponUseRuleAtomSV {
	/**
	 * 优惠券使用规则表添加数据
	 */
	@Override
	public void insertBuildCouponUseRule(FunCouponUseRule funCouponUseRule) {
		MapperFactory.getFunCouponUseRuleMapper().insert(funCouponUseRule);
	}

	
}

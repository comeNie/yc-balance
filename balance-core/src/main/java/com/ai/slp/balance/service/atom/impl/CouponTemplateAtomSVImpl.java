package com.ai.slp.balance.service.atom.impl;
import org.springframework.stereotype.Component;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.ICouponTemplateAtomSV;

@Component
public class CouponTemplateAtomSVImpl implements ICouponTemplateAtomSV {

	/**
	 * 优惠券模板表添加数据
	 */
	@Override
	public void insertBuildCouponTemplet(FunCouponTemplate couponTemplate) {
		MapperFactory.getFunCouponTemplateMapper().insert(couponTemplate);
	}
}

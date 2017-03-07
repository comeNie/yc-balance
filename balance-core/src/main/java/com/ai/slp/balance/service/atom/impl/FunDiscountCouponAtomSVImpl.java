package com.ai.slp.balance.service.atom.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCoupon;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCouponCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IDiscountCouponAtomSV;

@Component
public class FunDiscountCouponAtomSVImpl implements IDiscountCouponAtomSV {

	@Override
	public List<FunDiscountCoupon> getAccountInfoByCustId(Integer templateId) {
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		funDiscountCouponCriteria.createCriteria().andTemplateIdEqualTo(templateId);
		return MapperFactory.getFunDiscountCouponMapper().selectByExample(funDiscountCouponCriteria);
	}
}

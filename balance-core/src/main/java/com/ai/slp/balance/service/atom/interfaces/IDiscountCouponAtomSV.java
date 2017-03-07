package com.ai.slp.balance.service.atom.interfaces;


import java.util.List;

import com.ai.slp.balance.dao.mapper.bo.FunDiscountCoupon;

public interface IDiscountCouponAtomSV {
	//查询优惠券明细
	public List<FunDiscountCoupon> getAccountInfoByCustId(Integer templateId);
	
}

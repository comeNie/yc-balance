package com.ai.slp.balance.service.atom.interfaces;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;

public interface ICouponTemplateAtomSV {
     //生成优惠券模板
	public void insertBuildCouponTemplet(FunCouponTemplate couponTemplate);
}

package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;

public interface ICouponTemplateBusiSV {
	//生成优惠券模板接口
	public void BuildCouponTemplet(FunCouponTemplate couponTemplate) throws BusinessException,SystemException;
	
}

package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;

public interface ICouponTemplateAtomSV {
     //生成优惠券模板
	public void insertBuildCouponTemplet(FunCouponTemplate couponTemplate);
	 //模糊查询优惠券模板列表
	public PageInfo<FunCouponTemplateResponse> funCouponTemplateQueryRequest(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest);
}

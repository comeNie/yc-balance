package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;

public interface ICouponTemplateAtomSV {
     //生成优惠券模板
	public void insertBuildCouponTemplet(FunCouponTemplate couponTemplate);
	 //模糊查询优惠券模板列表
	public PageInfo<FunCouponTemplateResponse> funCouponTemplateQueryRequest(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest);
	//POI导出优惠券模板列表生成Excel
	public List<FunCouponTemplateResponse> exportCouponTempletList(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest);
	public Integer checkCouponTemplateName(String couponName);
}

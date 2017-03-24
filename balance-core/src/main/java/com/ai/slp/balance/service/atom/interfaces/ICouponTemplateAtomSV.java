package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;

public interface ICouponTemplateAtomSV {
     
	/**
	 * 模糊查询优惠券模板列表
	 * @param funCouponTemplateQueryRequest
	 * @return
	 */
	public PageInfo<FunCouponTemplateResponse> funCouponTemplateQueryRequest(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest);
	/***
	 * POI导出优惠券模板列表生成Excel
	 * @param funCouponTemplateQueryRequest
	 * @return
	 */
	public List<FunCouponTemplateResponse> exportCouponTempletList(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest);
	/**
	 * 检测名称唯一
	 * @param couponName
	 * @return
	 */
	public Integer checkCouponTemplateName(String couponName);
	/**
	 * 添加优惠券模板
	 * @param req
	 * @return
	 */
	public Integer saveCouponTempletList(FunCouponTemplate req);
	/**
	 * 删除优惠券模板
	 * @param templateId
	 * @return
	 */
	public Integer deleteCouponTemplate(Integer templateId);
	/**
	 * 根据优惠券模板ID查询明细
	 * @param param
	 * @return
	 */
	public PageInfo<FunCouponDetailResponse> queryFunCouponDetail(FunCouponDetailQueryRequest param);
}

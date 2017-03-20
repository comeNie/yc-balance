package com.ai.slp.balance.service.business.interfaces;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.api.coupontemplate.param.SaveFunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;

public interface ICouponTemplateBusiSV {
	public void BuildCouponTemplet(FunCouponTemplate couponTemplate,Integer requiredMoneyAmount,HttpSession session)throws BusinessException, SystemException;
	/**
	 * 模糊查询优惠券模板列表
	 * @param funCouponTemplateQueryRequest
	 * @return
	 */
	public PageInfo<FunCouponTemplateResponse> queryCouponTemplet(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest);
	/**
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
	 * 生成优惠券模板接口
	 */
	public Integer saveCouponTempletList(SaveFunCouponTemplate req);
	/**
	 * 根据优惠券模板iD查询优惠券明细
	 * @param param
	 * @return
	 */
	public PageInfo<FunCouponDetailResponse> queryFunCouponDetail(FunCouponDetailQueryRequest param) throws BusinessException, SystemException;
	/**
	 * 删除优惠券模板
	 * @param templateId
	 * @return
	 */
	public Integer deleteCouponTemplate(Integer templateId);
}

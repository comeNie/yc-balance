package com.ai.slp.balance.service.atom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.FreezeCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.FunDiscountCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouCountRequest;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.SendCouponRequest;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCoupon;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCouponCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunDiscountCouponMapper;
import com.ai.slp.balance.service.atom.interfaces.IDiscountCouponAtomSV;

@Component
public class FunDiscountCouponAtomSVImpl implements IDiscountCouponAtomSV {

	/**
	 * 根据优惠券iD查询优惠券
	 */
	@Override
	public List<DeductionCouponResponse> deducionCouponCheck(String couponId) throws BusinessException, SystemException {

		List<DeductionCouponResponse> deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andCouponIdEqualTo(couponId);
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();

		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);

		if (!CollectionUtil.isEmpty(funDiscountCoupons)) {
			deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
			for (int i = 0; i < funDiscountCoupons.size(); i++) {
				DeductionCouponResponse deductionCouponResponse = new DeductionCouponResponse();
				BeanUtils.copyProperties(deductionCouponResponse, funDiscountCoupons.get(i));
				deductionCouponResponses.add(deductionCouponResponse);
			}
		}
		return deductionCouponResponses;
	}

	/**
	 * 用户、订单、优惠券关联查询
	 */
	@Override
	public List<DeductionCouponResponse> queryDisCountCoupon(DeductionCouponRequest param) throws BusinessException, SystemException {
		List<DeductionCouponResponse> deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andUserIdEqualTo(param.getUserId());
		critreia.andUsedSceneEqualTo(param.getUsedScene());
		critreia.andCurrencyUnitEqualTo(param.getCurrencyUnit());
		List<String> list = new ArrayList<String>();
		list.add(param.getOrderType());
		list.add("0");
		critreia.andUseLimitsIn(list);
		critreia.andStatusEqualTo("1");
		critreia.andEffectiveEndTimeGreaterThanOrEqualTo(DateUtil.getSysDate());

		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		if (!CollectionUtil.isEmpty(funDiscountCoupons)) {
			deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
			for (int i = 0; i < funDiscountCoupons.size(); i++) {
				DeductionCouponResponse deductionCouponResponse = new DeductionCouponResponse();
				BeanUtils.copyProperties(deductionCouponResponse, funDiscountCoupons.get(i));
				deductionCouponResponses.add(deductionCouponResponse);
			}
		}
		return deductionCouponResponses;
	}

	/**
	 * 更改优惠券状态（解冻）
	 */
	@Override
	public void updateStateThaw(FreezeCouponRequest param) throws BusinessException, SystemException {
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andCouponIdEqualTo(param.getCouponId());
		/* critreia.andOrderIdEqualTo(param.getOrderId()); */
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		FunDiscountCoupon coupon = new FunDiscountCoupon();
		coupon.setStatus("1");
		mapper.updateByExampleSelective(coupon, funDiscountCouponCriteria);
	}
	/**
	 * 更改优惠券状态（冻结）
	 */
	@Override
	public void updateStateFreeze(FreezeCouponRequest param) throws BusinessException, SystemException {
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andCouponIdEqualTo(param.getCouponId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		FunDiscountCoupon coupon = new FunDiscountCoupon();
		coupon.setStatus("3");
		mapper.updateByExampleSelective(coupon, funDiscountCouponCriteria);
	}

	/**
	 * 根据用户ID查询优惠券
	 */
	@Override
	public List<FunDiscountCouponResponse> queryCouponByUserId(SendCouponRequest param) throws BusinessException, SystemException {
		List<FunDiscountCouponResponse> funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andUserIdEqualTo(param.getUserId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		if (!CollectionUtil.isEmpty(funDiscountCoupons)) {
			funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
			for (int i = 0; i < funDiscountCoupons.size(); i++) {
				FunDiscountCouponResponse funDiscountCouponResponse = new FunDiscountCouponResponse();
				BeanUtils.copyProperties(funDiscountCouponResponse, funDiscountCoupons.get(i));
				funDiscountCouponResponses.add(funDiscountCouponResponse);
			}
		}
		return funDiscountCouponResponses;
	}
	/**
	 * 抵扣优惠券
	 */
	@Override
	public void queryDeducionCoupon(DeductionCouponRequest param) throws BusinessException, SystemException {
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andCouponIdEqualTo(param.getCouponId());
		critreia.andUserIdEqualTo(param.getUserId());
		critreia.andOrderIdEqualTo(param.getOrderId());
		critreia.andEffectiveEndTimeGreaterThanOrEqualTo(DateUtil.getSysDate());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		FunDiscountCoupon coupon = new FunDiscountCoupon();
		coupon.setStatus("2");
		coupon.setCreateTime(DateUtil.getSysDate());
		mapper.updateByExampleSelective(coupon, funDiscountCouponCriteria);
	}
	/**
	 * 更改订单下所有优惠券状态
	 */
	@Override
	public void updateStateByOrderId(DeductionCouponRequest param) throws BusinessException, SystemException {
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andUserIdEqualTo(param.getUserId());
		critreia.andOrderIdEqualTo(param.getOrderId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		FunDiscountCoupon coupon = new FunDiscountCoupon();
		coupon.setStatus("1");
		mapper.updateByExampleSelective(coupon, funDiscountCouponCriteria);
	}
	
	
	/**
	 * 根据状态查询数量
	 */
	@Override
	public Integer findCouponCount(QueryCouCountRequest request) throws BusinessException, SystemException {
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andStatusEqualTo(request.getStatus());
		critreia.andUserIdEqualTo(request.getUserId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		int countByExample = mapper.countByExample(funDiscountCouponCriteria);
		return countByExample;
	}

	@Override
	public PageInfo<DeductionCouponResponse> queryCouponPage(QueryCouponRequest queryCouponRequest) throws BusinessException, SystemException {
		List<DeductionCouponResponse> deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria criteria = funDiscountCouponCriteria.createCriteria();
		if (!StringUtil.isBlank(queryCouponRequest.getStatus())) {
			criteria.andStatusEqualTo(queryCouponRequest.getStatus());
		}
		if (!StringUtil.isBlank(queryCouponRequest.getUserId())) {
			criteria.andUserIdEqualTo(queryCouponRequest.getUserId());
		}
		PageInfo<DeductionCouponResponse> pageInfo = new PageInfo<DeductionCouponResponse>();
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();

		pageInfo.setCount(mapper.countByExample(funDiscountCouponCriteria));

		if (queryCouponRequest.getPageInfo() == null) {
			pageInfo.setPageNo(1);
			pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
		} else {
			pageInfo.setPageNo(queryCouponRequest.getPageInfo().getPageNo());
			pageInfo.setPageSize(queryCouponRequest.getPageInfo().getPageSize() == null ? 20
					: queryCouponRequest.getPageInfo().getPageSize());
			funDiscountCouponCriteria.setLimitStart(queryCouponRequest.getPageInfo().getStartRowIndex());
			funDiscountCouponCriteria.setLimitEnd(queryCouponRequest.getPageInfo().getPageSize());
		}
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);

		if (!CollectionUtil.isEmpty(funDiscountCoupons)) {

			for (int i = 0; i < funDiscountCoupons.size(); i++) {
				DeductionCouponResponse deductionCouponResponse = new DeductionCouponResponse();
				BeanUtils.copyProperties(deductionCouponResponse, funDiscountCoupons.get(i));
				deductionCouponResponses.add(deductionCouponResponse);
			}
		}
		pageInfo.setPageNo(pageInfo.getPageNo() == null ? 1 : pageInfo.getPageNo());
		pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
		pageInfo.setPageCount((pageInfo.getCount() + pageInfo.getPageSize() - 1) / pageInfo.getPageSize());
		pageInfo.setResult(deductionCouponResponses);
		return pageInfo;
	}

	/**
	 * 根据过期时间查询数量
	 */
	@Override
	public Integer queryCouponOveCount(QueryCouCountRequest request) throws BusinessException, SystemException {
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andEffectiveEndTimeGreaterThanOrEqualTo(DateUtil.getSysDate());
		critreia.andUserIdEqualTo(request.getUserId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		int countByExample = mapper.countByExample(funDiscountCouponCriteria);
		return countByExample;
	}

	/*
	 * @Override public PageInfo<FunCouponDetailResponse>
	 * queryFunCouponDetail(FunCouponDetailQueryRequest param) {
	 * List<FunCouponDetailResponse> funCouponDetailResponses = new
	 * ArrayList<FunCouponDetailResponse>();
	 * 
	 * FunDiscountCouponCriteria funDiscountCouponCriteria = new
	 * FunDiscountCouponCriteria(); FunDiscountCouponCriteria.Criteria critreia
	 * = funDiscountCouponCriteria.createCriteria(); String orderByClause =
	 * "ORDER_TIME desc";
	 * funDiscountCouponCriteria.setOrderByClause(orderByClause);
	 * critreia.andTemplateIdEqualTo(param.getTemplateId());
	 * PageInfo<FunCouponDetailResponse> pageInfo = new
	 * PageInfo<FunCouponDetailResponse>(); FunDiscountCouponMapper mapper =
	 * MapperFactory.getFunDiscountCouponMapper();
	 * pageInfo.setCount(mapper.countByExample(funDiscountCouponCriteria));
	 * 
	 * List<FunDiscountCoupon> funDiscountCoupon =
	 * mapper.selectByExample(funDiscountCouponCriteria); if
	 * (param.getPageInfo() == null) { pageInfo.setPageNo(1);
	 * pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 :
	 * pageInfo.getPageSize()); }else {
	 * pageInfo.setPageNo(param.getPageInfo().getPageNo());
	 * pageInfo.setPageSize(param.getPageInfo().getPageSize() == null ? 10 :
	 * param.getPageInfo().getPageSize());
	 * funDiscountCouponCriteria.setLimitStart(param.getPageInfo()
	 * .getStartRowIndex());
	 * funDiscountCouponCriteria.setLimitEnd(param.getPageInfo().getPageSize());
	 * } if (!CollectionUtil.isEmpty(funDiscountCoupon)){
	 * funCouponDetailResponses = new ArrayList<FunCouponDetailResponse>(); for
	 * (int i=0;i<funDiscountCoupon.size();i++){ FunCouponDetailResponse
	 * funCouponDetailResponse = new FunCouponDetailResponse();
	 * BeanUtils.copyProperties(funCouponDetailResponse,funDiscountCoupon.get(i)
	 * ); funCouponDetailResponses.add(funCouponDetailResponse); } }
	 * pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
	 * pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 :
	 * pageInfo.getPageSize());
	 * pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/
	 * pageInfo.getPageSize()); pageInfo.setResult(funCouponDetailResponses);
	 * return pageInfo; }
	 */
}

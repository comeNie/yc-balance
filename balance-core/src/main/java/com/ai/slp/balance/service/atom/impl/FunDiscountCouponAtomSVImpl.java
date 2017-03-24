package com.ai.slp.balance.service.atom.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.FreezeCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.FunDiscountCouponResponse;
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
	public List<DeductionCouponResponse> deducionCoupon(String couponId) {
		
		List<DeductionCouponResponse> deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andCouponIdEqualTo(couponId);
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		
		if (!CollectionUtil.isEmpty(funDiscountCoupons)){
			deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
            for (int i=0;i<funDiscountCoupons.size();i++){
            	DeductionCouponResponse deductionCouponResponse = new DeductionCouponResponse();
                BeanUtils.copyProperties(deductionCouponResponse,funDiscountCoupons.get(i));
                deductionCouponResponses.add(deductionCouponResponse);
            }
        }
		return deductionCouponResponses;
	}

	/**
	 * 用户、订单、优惠券关联查询
	 */
	@Override
	public List<DeductionCouponResponse> queryDeducionCoupon(DeductionCouponRequest param,String orderType) {
		List<DeductionCouponResponse> deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andUserIdEqualTo(param.getUserId());
		critreia.andOrderIdEqualTo(param.getOrderId());
		critreia.andUsedSceneEqualTo(param.getUsedScene());
		critreia.andCurrencyUnitEqualTo(param.getCurrencyUnit());
		critreia.andUseLimitsEqualTo(orderType);
		critreia.andStatusEqualTo("2");
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		if (!CollectionUtil.isEmpty(funDiscountCoupons)){
			deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
            for (int i=0;i<funDiscountCoupons.size();i++){
            	DeductionCouponResponse deductionCouponResponse = new DeductionCouponResponse();
                BeanUtils.copyProperties(deductionCouponResponse,funDiscountCoupons.get(i));
                deductionCouponResponses.add(deductionCouponResponse);
            }
        }
		return deductionCouponResponses;
	}
	/**
	 * 更改优惠券状态（解冻）
	 */
	@Override
	public void updateStateThaw(FreezeCouponRequest param) {
		List<FunDiscountCouponResponse> funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andCouponIdEqualTo(param.getCouponId());
		critreia.andOrderIdEqualTo(param.getOrderId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		if (!CollectionUtil.isEmpty(funDiscountCoupons)){
			funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
            for (int i=0;i<funDiscountCoupons.size();i++){
            	FunDiscountCouponResponse funDiscountCouponResponse = new FunDiscountCouponResponse();
                BeanUtils.copyProperties(funDiscountCouponResponse,funDiscountCoupons.get(i));
                funDiscountCouponResponse.setStatus("3");
                funDiscountCouponResponses.add(funDiscountCouponResponse);
            }
        }
	}
	/**
	 * 更改优惠券状态（冻结）
	 */
	@Override
	public void updateStateFreeze(FreezeCouponRequest param) {
		List<FunDiscountCouponResponse> funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andCouponIdEqualTo(param.getCouponId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		if (!CollectionUtil.isEmpty(funDiscountCoupons)){
			funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
            for (int i=0;i<funDiscountCoupons.size();i++){
            	FunDiscountCouponResponse funDiscountCouponResponse = new FunDiscountCouponResponse();
                BeanUtils.copyProperties(funDiscountCouponResponse,funDiscountCoupons.get(i));
                funDiscountCouponResponse.setStatus("1");
                funDiscountCouponResponses.add(funDiscountCouponResponse);
            }
        }
	}
	/**
	 * 根据用户ID查询优惠券
	 */
	@Override
	public List<FunDiscountCouponResponse> queryCouponByUserId(String userId) {
		List<FunDiscountCouponResponse> funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andUserIdEqualTo(userId);
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		
		if (!CollectionUtil.isEmpty(funDiscountCoupons)){
			funDiscountCouponResponses = new ArrayList<FunDiscountCouponResponse>();
            for (int i=0;i<funDiscountCoupons.size();i++){
            	FunDiscountCouponResponse funDiscountCouponResponse = new FunDiscountCouponResponse();
                BeanUtils.copyProperties(funDiscountCouponResponse,funDiscountCoupons.get(i));
                funDiscountCouponResponses.add(funDiscountCouponResponse);
            }
        }
		return funDiscountCouponResponses;
	}

	/**
	 * 抵扣优惠券
	 */
	@Override
	public List<DeductionCouponResponse> queryDeducionCoupon(DeductionCouponRequest param) {
		List<DeductionCouponResponse> deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
		FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
		critreia.andUserIdEqualTo(param.getUserId());
		critreia.andOrderIdEqualTo(param.getOrderId());
		FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
		List<FunDiscountCoupon> funDiscountCoupons = mapper.selectByExample(funDiscountCouponCriteria);
		if (!CollectionUtil.isEmpty(funDiscountCoupons)){
			deductionCouponResponses = new ArrayList<DeductionCouponResponse>();
            for (int i=0;i<funDiscountCoupons.size();i++){
            	DeductionCouponResponse deductionCouponResponse = new DeductionCouponResponse();
                BeanUtils.copyProperties(deductionCouponResponse,funDiscountCoupons.get(i));
                deductionCouponResponse.setStatus("3");
                Date date=new Date();
                DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                deductionCouponResponse.setUseTime(Timestamp.valueOf(format.format(date)));
                deductionCouponResponses.add(deductionCouponResponse);
            }
        }
		return deductionCouponResponses;
	}

	


	/*@Override
	public PageInfo<FunCouponDetailResponse> queryFunCouponDetail(FunCouponDetailQueryRequest param) {
		 List<FunCouponDetailResponse> funCouponDetailResponses = new ArrayList<FunCouponDetailResponse>();
		 
		 	FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		 	FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
	        String orderByClause = "ORDER_TIME desc";
	        funDiscountCouponCriteria.setOrderByClause(orderByClause);
	        critreia.andTemplateIdEqualTo(param.getTemplateId());
	        PageInfo<FunCouponDetailResponse> pageInfo = new PageInfo<FunCouponDetailResponse>();
	        FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
	        pageInfo.setCount(mapper.countByExample(funDiscountCouponCriteria));
	        
	        List<FunDiscountCoupon> funDiscountCoupon = mapper.selectByExample(funDiscountCouponCriteria);
	        if (param.getPageInfo() == null) {
	            pageInfo.setPageNo(1);
	            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
	        }else {
	            pageInfo.setPageNo(param.getPageInfo().getPageNo());
	            pageInfo.setPageSize(param.getPageInfo().getPageSize() == null ? 10
	                    : param.getPageInfo().getPageSize());
	            funDiscountCouponCriteria.setLimitStart(param.getPageInfo()
	                    .getStartRowIndex());
	            funDiscountCouponCriteria.setLimitEnd(param.getPageInfo().getPageSize());
	        }
	        if (!CollectionUtil.isEmpty(funDiscountCoupon)){
	        	funCouponDetailResponses = new ArrayList<FunCouponDetailResponse>();
	            for (int i=0;i<funDiscountCoupon.size();i++){
	            	FunCouponDetailResponse funCouponDetailResponse = new FunCouponDetailResponse();
	                BeanUtils.copyProperties(funCouponDetailResponse,funDiscountCoupon.get(i));
	                funCouponDetailResponses.add(funCouponDetailResponse);
	            }
	        }
	        pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
	        pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
	        pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
	        pageInfo.setResult(funCouponDetailResponses);
	        return pageInfo;
	}*/
}

package com.ai.slp.balance.service.atom.interfaces;



import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.FreezeCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.FunDiscountCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouCountRequest;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.SendCouponRequest;

public interface IDiscountCouponAtomSV {

	//查询优惠券明细
	/*public PageInfo<FunCouponDetailResponse> queryFunCouponDetail(FunCouponDetailQueryRequest param) throws BusinessException, SystemException ;*/

	List<DeductionCouponResponse> queryDisCountCoupon(DeductionCouponRequest param) throws BusinessException, SystemException ;

	List<FunDiscountCouponResponse> queryCouponByUserId(SendCouponRequest param) throws BusinessException, SystemException ;

	void updateStateThaw(FreezeCouponRequest param) throws BusinessException, SystemException ;

	void updateStateFreeze(FreezeCouponRequest param) throws BusinessException, SystemException ;

	Integer findCouponCount(QueryCouCountRequest request) throws BusinessException, SystemException ;

	PageInfo<DeductionCouponResponse> queryCouponPage(QueryCouponRequest queryCouponRequest) throws BusinessException, SystemException ;

	Integer queryCouponOveCount(QueryCouCountRequest request) throws BusinessException, SystemException ;

	void updateStateByOrderId(DeductionCouponRequest param) throws BusinessException, SystemException ;

	void toDeducionCoupon(DeductionCouponRequest param) throws BusinessException, SystemException ;

	List<DeductionCouponResponse> checkCouponExist(String couponId) throws BusinessException, SystemException ;
	
}

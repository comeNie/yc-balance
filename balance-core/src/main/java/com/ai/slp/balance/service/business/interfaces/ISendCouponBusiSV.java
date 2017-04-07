package com.ai.slp.balance.service.business.interfaces;

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

public interface ISendCouponBusiSV {
	public void registerSendCoupon(SendCouponRequest param)throws BusinessException,SystemException;
	/*public void offLineSendCoupon(int maxCount,String couponName,String userId) throws BusinessException,SystemException;*/
	/**
	 * 查询可使用的优惠券
	 * @param orderType 
	 */
	public List<DeductionCouponResponse> queryDisCountCoupon(DeductionCouponRequest param)throws BusinessException,SystemException;
	/**
	 * 根据用户ID查询优惠券
	 */
	public List<FunDiscountCouponResponse> queryCouponByUserId(SendCouponRequest param)throws BusinessException,SystemException;
	/**
	 * 查询优惠券状态变为解冻
	 */
	public void updateStateThaw(FreezeCouponRequest param)throws BusinessException,SystemException;
	/**
	 * 查询优惠券状态变为冻结
	 */
	public void updateStateFreeze(FreezeCouponRequest param)throws BusinessException,SystemException;
	/**
	 * 抵扣优惠券
	 */
	public void deducionCoupon(DeductionCouponRequest param)throws BusinessException,SystemException;
	/**
	 * 查询优惠券数量
	 */
	public Integer findCouponCount(QueryCouCountRequest request)throws BusinessException,SystemException;
	/**
	 * 根据用户ID、状态查询优惠券
	 */
	public PageInfo<DeductionCouponResponse> queryCouponPage(QueryCouponRequest queryCouponRequest)throws BusinessException,SystemException;
	/**
	 * 查询过期的优惠券数量
	 */
	public Integer queryCouponOveCount(QueryCouCountRequest request)throws BusinessException,SystemException;
}

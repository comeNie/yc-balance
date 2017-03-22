package com.ai.slp.balance.api.sendcoupon.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.FunDiscountCouponResponse;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.ICouponUseRuleBusiSV;
import com.ai.slp.balance.service.business.interfaces.ISendCouponBusiSV;
import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class SendCouponSVImpl implements ISendCouponSV {
    
    
    @Autowired
    private ISendCouponBusiSV sendCouponBusiSV;
    
    @Autowired
    private IOrderQuerySV orderQuerySV;
    
    @Autowired
    private ICouponUseRuleBusiSV couponUseRuleBusiSV;
    /**
     * 注册领取优惠券.<br>
     */
	@Override
	public void registerSendCoupon(String activityName, String userId) throws BusinessException, SystemException {
		sendCouponBusiSV.registerSendCoupon(activityName, userId);
	}

	/**
	 * 查询可使用的优惠券
	 */
	@Override
	public List<DeductionCouponResponse> queryDisCountCoupon(DeductionCouponRequest param)throws BusinessException, SystemException {
		String couponId = param.getCouponId();
		List<DeductionCouponResponse> deducionCoupon = sendCouponBusiSV.deducionCoupon(couponId);
		if(deducionCoupon == null){
			throw new BusinessException(ExceptCodeConstants.Special.NO_FIND_DISCOUNTCOUPON, "优惠券抵扣失败，优惠券不存在");
		}else{
			List<DeductionCouponResponse> queryDeducionCoupon = sendCouponBusiSV.queryDeducionCoupon(param);
			QueryOrderRequest queryOrderRequest = new QueryOrderRequest();
			queryOrderRequest.setOrderId(param.getOrderId());
			QueryOrderRsponse queryOrder = orderQuerySV.queryOrder(queryOrderRequest);
			String couponUserId = queryDeducionCoupon.get(0).getCouponUserId();
			List<FunCouponUseRuleQueryResponse> queryCouponUseRule = couponUseRuleBusiSV.queryCouponUseRule(couponUserId);
			
			for (int i = 0; i < queryDeducionCoupon.size();) {
				Date date1=new Date();
				SimpleDateFormat f = new SimpleDateFormat("hhmmss"); 
				int d1Number = Integer.parseInt(f.format(date1).toString());
				int d2Number = Integer.parseInt(f.format(queryDeducionCoupon.get(i).getEffectiveEndTime()).toString());
				if (param.getUsedScene() != queryDeducionCoupon.get(i).getUsedScene()) {
					throw new BusinessException(ExceptCodeConstants.Special.NO_DISCOUNTCOUPON_USEDSCENE, "优惠券抵扣失败，此优惠券不符合使用场景限制");
				}else if (param.getTotalFee() != queryCouponUseRule.get(0).getRequiredMoneyAmount()) {
					throw new BusinessException(ExceptCodeConstants.Special.NO_REQYUIREDMONEYAMOUNT, "优惠券抵扣失败，此优惠券不符合所消费面额限制");
				}else if (queryOrder.getPageInfo().getResult().get(0).getOrderType() != queryDeducionCoupon.get(i).getUseLimits()) {
					throw new BusinessException(ExceptCodeConstants.Special.NO_DISCOUNTCOUPON_USELIMITS, "优惠券抵扣失败，此优惠券不符合订单类型的使用规则限制");
				}else if (queryDeducionCoupon.get(i).getStatus()=="3") {
					throw new BusinessException(ExceptCodeConstants.Special.DISCOUNTCOUPON_EFFECT, "优惠券抵扣失败，优惠券已失效");
				}else if (d1Number >= d2Number) {
					throw new BusinessException(ExceptCodeConstants.Special.DISCOUNTCOUPON_EFFECT, "优惠券抵扣失败，优惠券已失效");
				}
			}
			return queryDeducionCoupon;
		}
	}

	/**
	 * 查询优惠券状态变为解冻
	 */
	@Override
	public void updateStateThaw(String couponId) throws BusinessException, SystemException {
		sendCouponBusiSV.updateStateThaw(couponId);
	}
	/**
	 * 查询优惠券状态变为冻结
	 */
	@Override
	public void updateStateFreeze(String couponId)throws BusinessException, SystemException {
		sendCouponBusiSV.updateStateFreeze(couponId);
	}
	
	/**
	 * 根据用户ID查询优惠券
	 */
	@Override
	public List<FunDiscountCouponResponse> queryCouponByUserId(String userId) throws BusinessException, SystemException {
		return sendCouponBusiSV.queryCouponByUserId(userId);
	}

	/**
	 * 抵扣优惠券
	 */
	@Override
	public void deducionCoupon(DeductionCouponRequest param) throws BusinessException, SystemException {
		String couponId = param.getCouponId();
		List<DeductionCouponResponse> deducionCoupon = sendCouponBusiSV.deducionCoupon(couponId);
		if(deducionCoupon == null){
			throw new BusinessException(ExceptCodeConstants.Special.NO_FIND_DISCOUNTCOUPON, "优惠券抵扣失败，优惠券不存在");
		}else{
			List<DeductionCouponResponse> queryDeducionCoupon = sendCouponBusiSV.queryDeducionCoupon(param);
			QueryOrderRequest queryOrderRequest = new QueryOrderRequest();
			queryOrderRequest.setOrderId(param.getOrderId());
			QueryOrderRsponse queryOrder = orderQuerySV.queryOrder(queryOrderRequest);
			String couponUserId = queryDeducionCoupon.get(0).getCouponUserId();
			List<FunCouponUseRuleQueryResponse> queryCouponUseRule = couponUseRuleBusiSV.queryCouponUseRule(couponUserId);
			
			for (int i = 0; i < queryDeducionCoupon.size();) {
				Date date1=new Date();
				SimpleDateFormat f = new SimpleDateFormat("hhmmss"); 
				int d1Number = Integer.parseInt(f.format(date1).toString());
				int d2Number = Integer.parseInt(f.format(queryDeducionCoupon.get(i).getEffectiveEndTime()).toString());
				if (param.getUsedScene() != queryDeducionCoupon.get(i).getUsedScene()) {
					throw new BusinessException(ExceptCodeConstants.Special.NO_DISCOUNTCOUPON_USEDSCENE, "优惠券抵扣失败，此优惠券不符合使用场景限制");
				}else if (param.getTotalFee() != queryCouponUseRule.get(0).getRequiredMoneyAmount()) {
					throw new BusinessException(ExceptCodeConstants.Special.NO_REQYUIREDMONEYAMOUNT, "优惠券抵扣失败，此优惠券不符合所消费面额限制");
				}else if (queryOrder.getPageInfo().getResult().get(0).getOrderType() != queryDeducionCoupon.get(i).getUseLimits()) {
					throw new BusinessException(ExceptCodeConstants.Special.NO_DISCOUNTCOUPON_USELIMITS, "优惠券抵扣失败，此优惠券不符合订单类型的使用规则限制");
				}else if (queryDeducionCoupon.get(i).getStatus()=="3") {
					throw new BusinessException(ExceptCodeConstants.Special.DISCOUNTCOUPON_EFFECT, "优惠券抵扣失败，优惠券已失效");
				}else if (d1Number >= d2Number) {
					throw new BusinessException(ExceptCodeConstants.Special.DISCOUNTCOUPON_EFFECT, "优惠券抵扣失败，优惠券已失效");
				}
			}
		}
	}

	/*@Override
	public void offLineSendCoupon(int maxCount, String couponName, String userId)
			throws BusinessException, SystemException {
		sendCouponBusiSV.offLineSendCoupon(maxCount, couponName, userId);
	}*/


}

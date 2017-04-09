package com.ai.slp.balance.dao.mapper.attach;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
public interface CouponQueryAttachMapper {

   
	@Select("SELECT * FROM fun_discount_coupon WHERE `STATUS` = '1' AND USER_ID = #{userId} AND CURRENCY_UNIT = #{currencyUnit} AND EFFECTIVE_END_TIME > NOW() or (ORDER_ID=#{orderId} AND `STATUS` = '3') AND used_scene = #{usedScene} AND USE_LIMITS IN('0',#{orderType})")
	@ResultMap("com.ai.slp.balance.dao.mapper.interfaces.FunDiscountCouponMapper.BaseResultMap")
	public List<DeductionCouponResponse> getCoupon(@Param("orderType") String orderType,@Param("orderId") Long orderId,
		@Param("currencyUnit") String currencyUnit,@Param("couponId") String couponId,@Param("usedScene") String usedScene,@Param("userId") String userId);
}

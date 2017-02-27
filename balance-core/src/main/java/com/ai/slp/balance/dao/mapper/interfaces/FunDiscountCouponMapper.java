package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunDiscountCoupon;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCouponCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunDiscountCouponMapper {
    int countByExample(FunDiscountCouponCriteria example);

    int deleteByExample(FunDiscountCouponCriteria example);

    int deleteByPrimaryKey(Integer couponId);

    int insert(FunDiscountCoupon record);

    int insertSelective(FunDiscountCoupon record);

    List<FunDiscountCoupon> selectByExample(FunDiscountCouponCriteria example);

    FunDiscountCoupon selectByPrimaryKey(Integer couponId);

    int updateByExampleSelective(@Param("record") FunDiscountCoupon record, @Param("example") FunDiscountCouponCriteria example);

    int updateByExample(@Param("record") FunDiscountCoupon record, @Param("example") FunDiscountCouponCriteria example);

    int updateByPrimaryKeySelective(FunDiscountCoupon record);

    int updateByPrimaryKey(FunDiscountCoupon record);
}
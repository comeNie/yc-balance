package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunCouponUseRuleMapper {
    int countByExample(FunCouponUseRuleCriteria example);

    int deleteByExample(FunCouponUseRuleCriteria example);

    int deleteByPrimaryKey(String couponUserId);

    int insert(FunCouponUseRule record);

    int insertSelective(FunCouponUseRule record);

    List<FunCouponUseRule> selectByExample(FunCouponUseRuleCriteria example);

    FunCouponUseRule selectByPrimaryKey(String couponUserId);

    int updateByExampleSelective(@Param("record") FunCouponUseRule record, @Param("example") FunCouponUseRuleCriteria example);

    int updateByExample(@Param("record") FunCouponUseRule record, @Param("example") FunCouponUseRuleCriteria example);

    int updateByPrimaryKeySelective(FunCouponUseRule record);

    int updateByPrimaryKey(FunCouponUseRule record);
}
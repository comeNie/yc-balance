package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunActivityCouponRel;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCouponRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunActivityCouponRelMapper {
    int countByExample(FunActivityCouponRelCriteria example);

    int deleteByExample(FunActivityCouponRelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(FunActivityCouponRel record);

    int insertSelective(FunActivityCouponRel record);

    List<FunActivityCouponRel> selectByExample(FunActivityCouponRelCriteria example);

    FunActivityCouponRel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FunActivityCouponRel record, @Param("example") FunActivityCouponRelCriteria example);

    int updateByExample(@Param("record") FunActivityCouponRel record, @Param("example") FunActivityCouponRelCriteria example);

    int updateByPrimaryKeySelective(FunActivityCouponRel record);

    int updateByPrimaryKey(FunActivityCouponRel record);
}
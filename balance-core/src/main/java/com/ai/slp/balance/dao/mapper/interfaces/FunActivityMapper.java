package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunActivity;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunActivityMapper {
    int countByExample(FunActivityCriteria example);

    int deleteByExample(FunActivityCriteria example);

    int deleteByPrimaryKey(Integer activityId);

    int insert(FunActivity record);

    int insertSelective(FunActivity record);

    List<FunActivity> selectByExample(FunActivityCriteria example);

    FunActivity selectByPrimaryKey(Integer activityId);

    int updateByExampleSelective(@Param("record") FunActivity record, @Param("example") FunActivityCriteria example);

    int updateByExample(@Param("record") FunActivity record, @Param("example") FunActivityCriteria example);

    int updateByPrimaryKeySelective(FunActivity record);

    int updateByPrimaryKey(FunActivity record);
}
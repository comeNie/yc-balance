package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunActivityRule;
import com.ai.slp.balance.dao.mapper.bo.FunActivityRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunActivityRuleMapper {
    int countByExample(FunActivityRuleCriteria example);

    int deleteByExample(FunActivityRuleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(FunActivityRule record);

    int insertSelective(FunActivityRule record);

    List<FunActivityRule> selectByExample(FunActivityRuleCriteria example);

    FunActivityRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FunActivityRule record, @Param("example") FunActivityRuleCriteria example);

    int updateByExample(@Param("record") FunActivityRule record, @Param("example") FunActivityRuleCriteria example);

    int updateByPrimaryKeySelective(FunActivityRule record);

    int updateByPrimaryKey(FunActivityRule record);
}
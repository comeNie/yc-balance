package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.IntegralsLog;
import com.ai.slp.balance.dao.mapper.bo.IntegralsLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralsLogMapper {
    int countByExample(IntegralsLogCriteria example);

    int deleteByExample(IntegralsLogCriteria example);

    int deleteByPrimaryKey(String integralLogId);

    int insert(IntegralsLog record);

    int insertSelective(IntegralsLog record);

    List<IntegralsLog> selectByExample(IntegralsLogCriteria example);

    IntegralsLog selectByPrimaryKey(String integralLogId);

    int updateByExampleSelective(@Param("record") IntegralsLog record, @Param("example") IntegralsLogCriteria example);

    int updateByExample(@Param("record") IntegralsLog record, @Param("example") IntegralsLogCriteria example);

    int updateByPrimaryKeySelective(IntegralsLog record);

    int updateByPrimaryKey(IntegralsLog record);
}
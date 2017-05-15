package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.Integrals;
import com.ai.slp.balance.dao.mapper.bo.IntegralsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralsMapper {
    int countByExample(IntegralsCriteria example);

    int deleteByExample(IntegralsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Integrals record);

    int insertSelective(Integrals record);

    List<Integrals> selectByExample(IntegralsCriteria example);

    Integrals selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Integrals record, @Param("example") IntegralsCriteria example);

    int updateByExample(@Param("record") Integrals record, @Param("example") IntegralsCriteria example);

    int updateByPrimaryKeySelective(Integrals record);

    int updateByPrimaryKey(Integrals record);
}
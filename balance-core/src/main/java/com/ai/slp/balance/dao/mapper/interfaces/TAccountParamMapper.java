package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.slp.balance.dao.mapper.bo.TAccountParamCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAccountParamMapper {
    int countByExample(TAccountParamCriteria example);

    int deleteByExample(TAccountParamCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TAccountParam record);

    int insertSelective(TAccountParam record);

    List<TAccountParam> selectByExample(TAccountParamCriteria example);

    TAccountParam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAccountParam record, @Param("example") TAccountParamCriteria example);

    int updateByExample(@Param("record") TAccountParam record, @Param("example") TAccountParamCriteria example);

    int updateByPrimaryKeySelective(TAccountParam record);

    int updateByPrimaryKey(TAccountParam record);
}
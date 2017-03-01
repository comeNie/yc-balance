package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountDetail;
import com.ai.slp.balance.dao.mapper.bo.FunAccountDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunAccountDetailMapper {
    int countByExample(FunAccountDetailCriteria example);

    int deleteByExample(FunAccountDetailCriteria example);

    int deleteByPrimaryKey(String detailId);

    int insert(FunAccountDetail record);

    int insertSelective(FunAccountDetail record);

    List<FunAccountDetail> selectByExample(FunAccountDetailCriteria example);

    FunAccountDetail selectByPrimaryKey(String detailId);

    int updateByExampleSelective(@Param("record") FunAccountDetail record, @Param("example") FunAccountDetailCriteria example);

    int updateByExample(@Param("record") FunAccountDetail record, @Param("example") FunAccountDetailCriteria example);

    int updateByPrimaryKeySelective(FunAccountDetail record);

    int updateByPrimaryKey(FunAccountDetail record);
}
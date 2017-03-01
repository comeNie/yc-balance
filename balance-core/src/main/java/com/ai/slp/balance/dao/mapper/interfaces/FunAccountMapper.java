package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccount;
import com.ai.slp.balance.dao.mapper.bo.FunAccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunAccountMapper {
    int countByExample(FunAccountCriteria example);

    int deleteByExample(FunAccountCriteria example);

    int deleteByPrimaryKey(String billId);

    int insert(FunAccount record);

    int insertSelective(FunAccount record);

    List<FunAccount> selectByExample(FunAccountCriteria example);

    FunAccount selectByPrimaryKey(String billId);

    int updateByExampleSelective(@Param("record") FunAccount record, @Param("example") FunAccountCriteria example);

    int updateByExample(@Param("record") FunAccount record, @Param("example") FunAccountCriteria example);

    int updateByPrimaryKeySelective(FunAccount record);

    int updateByPrimaryKey(FunAccount record);
}
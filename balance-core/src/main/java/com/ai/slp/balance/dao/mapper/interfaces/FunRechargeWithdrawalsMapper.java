package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunRechargeWithdrawals;
import com.ai.slp.balance.dao.mapper.bo.FunRechargeWithdrawalsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunRechargeWithdrawalsMapper {
    int countByExample(FunRechargeWithdrawalsCriteria example);

    int deleteByExample(FunRechargeWithdrawalsCriteria example);

    int deleteByPrimaryKey(String wid);

    int insert(FunRechargeWithdrawals record);

    int insertSelective(FunRechargeWithdrawals record);

    List<FunRechargeWithdrawals> selectByExample(FunRechargeWithdrawalsCriteria example);

    FunRechargeWithdrawals selectByPrimaryKey(String wid);

    int updateByExampleSelective(@Param("record") FunRechargeWithdrawals record, @Param("example") FunRechargeWithdrawalsCriteria example);

    int updateByExample(@Param("record") FunRechargeWithdrawals record, @Param("example") FunRechargeWithdrawalsCriteria example);

    int updateByPrimaryKeySelective(FunRechargeWithdrawals record);

    int updateByPrimaryKey(FunRechargeWithdrawals record);
}
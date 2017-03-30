package com.ai.slp.balance.dao.mapper.attach;

import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetailAll;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
public interface IncomeOutQueryAttachMapper {

    @Results({@Result(property = "serialCode", column = "pay_serial_code"),
            @Result(property = "payTime", column = "pay_time"),
            @Result(property = "optType", column = "opt_type"),
            @Result(property = "incomeFlag", column = "INCOME_FLAG"),
            @Result(property = "accountName", column = "acct_name1"),
            @Result(property = "totalAmount", column = "total_amount"),
            @Result(property = "balancePre", column = "balance_pre"),
            @Result(property = "channel", column = "channel"),
            @Result(property = "payStatus", column = "pay_status"),
            @Result(property = "remark", column = "receive_state"),
            @Result(property = "currencyUnit", column = "CURRENCY_UNIT")})
    @SelectProvider(type = IncomeOutQueryAttachSqlProvider.class, method = "incomeOutQueryAttachSqlProvider")
    public List<IncomeDetailAll> getAllIncomeOut(@Param("serialCode") String serialCode,
                                                @Param("nickName") String nickName,
                                                 @Param("beginDate") String beginDate,
                                                 @Param("endDate") String endDate,
                                                 @Param("channel") String channel,
                                                 @Param("state") String state,
                                                 @Param("currencyUnit") String currencyUnit,
                                                 @Param("beginAmount") Long beginAmount,
                                                 @Param("endAmount") Long endAmount,
                                                 @Param("incomeFlag") String incomeFlag,
                                                 @Param("optType") String optType,
                                                 @Param("pageNo") Integer pageNo,
                                                 @Param("pageSize") Integer pageSize);
}

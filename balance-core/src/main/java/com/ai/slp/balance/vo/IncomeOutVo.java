package com.ai.slp.balance.vo;

import java.util.Date;

/**
 *  收支查询结果
 * Created by liquid on 16/11/9.
 */
public class IncomeOutVo {
    /**
     * 交易时间
     */
    private Date paytime;

    /**
     * 收支标识
     */
    private String incomeFlag;

    /**
     * 当前余额,"异动前余额"＋“交易金额”
     */
    private Long balance;

}

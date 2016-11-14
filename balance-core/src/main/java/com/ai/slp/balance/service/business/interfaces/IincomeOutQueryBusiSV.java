package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetail;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeQueryRequest;


/**
 * Created by liquid on 16/11/9.
 */
public interface IincomeOutQueryBusiSV {

    /**
     *为用户提供查询账户余额及指定时间段内全部账户收入和支付的记录。
     * @param accountId
     * @return
     * @throws BusinessException
     * @throws SystemException
     */

    public PageInfo<IncomeDetail> incomeOutQuery(IncomeQueryRequest accountId) throws BusinessException,SystemException;

}

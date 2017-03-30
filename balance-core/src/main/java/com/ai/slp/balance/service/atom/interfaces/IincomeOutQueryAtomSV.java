package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetailAll;

import java.util.List;

/**
 * Created by liquid on 16/11/9.
 */
public interface IincomeOutQueryAtomSV {

    public List<IncomeDetailAll> getAllIncomeOut(String serialCode,
                                                String nickName,
                                                 String beginDate,
                                                 String endDate,
                                                 String channel,
                                                 String state,
                                                 String currencyUnit,
                                                 Long beginAmount,
                                                 Long endAmount,
                                                 String incomeFlag,
                                                 String optType,
                                                 Integer pageNo,
                                                 Integer pageSize) throws BusinessException,SystemException;

}

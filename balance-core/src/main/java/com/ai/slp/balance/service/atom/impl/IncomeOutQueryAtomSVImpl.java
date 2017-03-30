package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetailAll;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeQueryRequestAll;
import com.ai.slp.balance.dao.mapper.attach.IncomeOutQueryAttachMapper;
import com.ai.slp.balance.service.atom.interfaces.IincomeOutQueryAtomSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liquid on 16/11/9.
 */
@Component
public class IncomeOutQueryAtomSVImpl implements IincomeOutQueryAtomSV{
    @Autowired
    private IncomeOutQueryAttachMapper incomeOutQueryAttachMapper;

    @Override
    public List<IncomeDetailAll> getAllIncomeOut(String serialCode,String nickName, String beginDate, String endDate, String channel, String state, String currencyUnit, Long beginAmount, Long endAmount, String incomeFlag, String optType,Integer pageNo,Integer pageSize) throws BusinessException, SystemException {
        List<IncomeDetailAll> allIncomeOut = incomeOutQueryAttachMapper.getAllIncomeOut(serialCode, nickName, beginDate, endDate, channel, state, currencyUnit, beginAmount, endAmount, incomeFlag, optType, pageNo, pageSize);
        return allIncomeOut;
    }
}

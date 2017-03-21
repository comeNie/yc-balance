package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.translatorbill.param.SettleParam;
import com.ai.slp.balance.dao.mapper.bo.FunAccount;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountAtomSV;
import org.springframework.stereotype.Component;

/**
 * Created by liquid on 17/2/22.
 */

@Component
public class FunAccountAtomSVImpl implements IFunAccountAtomSV{
    @Override
    public int insertFunAccountFund(FunAccount funAccount) {
        int i = MapperFactory.getFunAccountMapper().insert(funAccount);
        return i;
    }

    @Override
    public void settleBill(FunAccount param) throws BusinessException, SystemException {
       MapperFactory.getFunAccountMapper().updateByPrimaryKey(param);
    }

    @Override
    public void insertParam(TAccountParam accountParam) throws BusinessException, SystemException {
        MapperFactory.getTAccountParamMapper().insert(accountParam);
    }

}

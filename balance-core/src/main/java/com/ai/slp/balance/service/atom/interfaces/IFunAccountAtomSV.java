package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.dao.mapper.bo.FunAccount;

/**
 * 译员账单入账服务,对应表 fun_account
 * Created by liquid on 17/2/22.
 */
public interface IFunAccountAtomSV {
    /**
     * 插入表中信息
     * @param funAccount
     */
    public int insertFunAccountFund(FunAccount funAccount);

    /**
     * 结算账户
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public void settleBill(FunAccount param) throws BusinessException, SystemException;
}

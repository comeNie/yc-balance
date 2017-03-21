package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.dao.mapper.bo.FunAccount;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;

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

    /**
     * 配置账户信息表
     * @param accountParam
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public void insertParam(TAccountParam accountParam) throws BusinessException, SystemException;

    /**
     * 查询账单配置表
     * @param paramId
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public TAccountParam queryTaccount(String paramId) throws BusinessException, SystemException;
}

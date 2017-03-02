package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.dao.mapper.bo.FunAccountDetail;

import java.util.List;

/**
 * 译员账单入账服务,对应表 fun_account_detail
 * Created by liquid on 17/2/22.
 */
public interface IFunAccountDetailAtomSV {
    /**
     * 插入表中信息
     * @param funAccountDetail
     */
    public void insertFunAccountFundDetail(FunAccountDetail funAccountDetail);


    /***
     * 账单明细查询
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public List<FunAccountDetail> queryFunAccountDetail(String param) throws BusinessException, SystemException;
}

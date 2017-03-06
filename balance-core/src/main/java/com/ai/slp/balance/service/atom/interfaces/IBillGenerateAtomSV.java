package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.translatorbill.param.*;

import java.util.List;

/**
 * Created by liquid on 17/2/17.
 */
public interface IBillGenerateAtomSV {

    /**
     * 账单生成
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */

    public Boolean queryAccountParamByACCOUNT_CLS(String param) throws BusinessException, SystemException;

    /**
     * 查询账单表
     * @param funAccountQueryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public PageInfo<FunAccountResponse> funAccountQuery(FunAccountQueryRequest funAccountQueryRequest)throws BusinessException, SystemException;

    /***
     * 账单明细查询
     * @param param 账单ID
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public PageInfo<FunAccountDetailResponse> queryFunAccountDetail(FunAccountDetailQueryRequest param) throws BusinessException, SystemException ;

    /**
     * 结算账户
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public String settleBill(SettleParam param) throws BusinessException, SystemException;


}

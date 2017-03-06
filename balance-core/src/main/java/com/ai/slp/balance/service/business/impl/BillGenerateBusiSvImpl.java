package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.translatorbill.param.*;
import com.ai.slp.balance.service.atom.interfaces.IBillGenerateAtomSV;
import com.ai.slp.balance.service.business.interfaces.IBillGenerateBusiSV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liquid on 17/2/17.
 */
@Service
@Transactional
public class BillGenerateBusiSvImpl implements IBillGenerateBusiSV {
    private static final Logger LOG = LogManager.getLogger(BillGenerateBusiSvImpl.class);

    @Autowired
    private IBillGenerateAtomSV billGenerateAtomSV;
    @Override
    public Boolean BillGenerate(String param) throws BusinessException, SystemException {
        Boolean flag = billGenerateAtomSV.queryAccountParamByACCOUNT_CLS(param);
        return flag;
    }

    @Override
    public PageInfo<FunAccountResponse> funAccountQuery(FunAccountQueryRequest funAccountQueryRequest) {

        PageInfo<FunAccountResponse> funAccountResponsePageInfo = billGenerateAtomSV.funAccountQuery(funAccountQueryRequest);

        return funAccountResponsePageInfo;
    }

    @Override
    public PageInfo<FunAccountDetailResponse> queryFunAccountDetail(FunAccountDetailQueryRequest param) throws BusinessException, SystemException {
        return billGenerateAtomSV.queryFunAccountDetail(param);
    }

    @Override
    public String settleBill(SettleParam param) throws BusinessException, SystemException {

        return billGenerateAtomSV.settleBill(param);
    }
}

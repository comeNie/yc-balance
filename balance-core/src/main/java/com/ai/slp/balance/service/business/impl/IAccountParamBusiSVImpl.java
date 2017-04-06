package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.paas.ipaas.mds.IMessageSender;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateParam;
import com.ai.slp.balance.api.accountparam.param.AccountParamVo;
import com.ai.slp.balance.api.deduct.param.*;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.slp.balance.service.atom.interfaces.IAccountParamAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IDeductAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundBookAtomSV;
import com.ai.slp.balance.service.business.interfaces.IAccountParamBusiSV;
import com.ai.slp.balance.service.business.interfaces.IDeductBusiSV;
import com.ai.slp.balance.util.FunSubjectUtil;
import com.ai.slp.balance.vo.DeductVo;
import com.ai.slp.balance.vo.DeductVo.TransSummaryVo;
import com.ai.slp.balance.vo.SubjectFundVo;
import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class IAccountParamBusiSVImpl implements IAccountParamBusiSV {

    @Autowired
    private IAccountParamAtomSV accountParamAtomSV;
    @Override
    public List<AccountParamVo> queryAccountParam(String targetID) throws BusinessException {
        List<AccountParamVo> accountParamVos = new ArrayList<>();

        List<TAccountParam> tAccountParams = accountParamAtomSV.queryAccountParam(targetID);
        if (!CollectionUtil.isEmpty(tAccountParams)){
            for (int i=0;i<tAccountParams.size();i++){
                AccountParamVo accountParamVo = new AccountParamVo();
                BeanUtils.copyProperties(accountParamVo,tAccountParams.get(i));
                accountParamVos.add(accountParamVo);
            }
        }else {
            return null;
        }
        return accountParamVos;

    }

    @Override
    public void updateAccountParam(AccountParamUpdateParam param) throws BusinessException {
        try {
            accountParamAtomSV.updateAccountParam(param);
        }catch (BusinessException e){
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "更新帐户配置信息失败");
        }
    }
}

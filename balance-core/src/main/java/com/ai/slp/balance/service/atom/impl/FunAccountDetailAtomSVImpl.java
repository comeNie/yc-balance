package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunAccountDetail;
import com.ai.slp.balance.dao.mapper.bo.FunAccountDetailCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunAccountDetailMapper;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountDetailAtomSV;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liquid on 17/2/22.
 */

@Component
public class FunAccountDetailAtomSVImpl implements IFunAccountDetailAtomSV{
    @Override
    public void insertFunAccountFundDetail(FunAccountDetail funAccountDetail) {
        MapperFactory.getFunAccountDetailMapper().insert(funAccountDetail);
    }

    @Override
    public List<FunAccountDetail> queryFunAccountDetail(String param) throws BusinessException, SystemException {
        FunAccountDetailCriteria funAccountDetailCriteria = new FunAccountDetailCriteria();
        FunAccountDetailCriteria.Criteria criteria = funAccountDetailCriteria.createCriteria();
        criteria.andBillIdEqualTo(param);
        List<FunAccountDetail> funAccountDetails = MapperFactory.getFunAccountDetailMapper().selectByExample(funAccountDetailCriteria);
        if (funAccountDetails.size()<0){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "查询错误");
        }
        return funAccountDetails;
    }
}

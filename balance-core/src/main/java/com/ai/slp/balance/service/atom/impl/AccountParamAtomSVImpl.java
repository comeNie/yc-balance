package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateParam;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.slp.balance.dao.mapper.bo.TAccountParamCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IAccountParamAtomSV;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountParamAtomSVImpl implements IAccountParamAtomSV {

	@Override
	public List<TAccountParam> queryAccountParam(String targetID) throws BusinessException {
		TAccountParamCriteria example = new TAccountParamCriteria();
		TAccountParamCriteria.Criteria criteria = example.createCriteria();
		criteria.andTargetIdEqualTo(targetID);
		List<TAccountParam> tAccountParams = MapperFactory.getTAccountParamMapper().selectByExample(example);
		return tAccountParams;
	}

	@Override
	public void updateAccountParam(AccountParamUpdateParam param) throws BusinessException {
		TAccountParamCriteria example = new TAccountParamCriteria();
		TAccountParamCriteria.Criteria criteria = example.createCriteria();
		criteria.andTargetIdEqualTo(param.getTargetID());
		List<TAccountParam> tAccountParams = MapperFactory.getTAccountParamMapper().selectByExample(example);
		for (TAccountParam accountParam : tAccountParams){
			accountParam.setTargetId(param.getTargetID());
			accountParam.setTargetName(param.getTargetName());
			if (null!=param.getDiscount()){
				accountParam.setDiscount(param.getDiscount());
			}
			if (!StringUtil.isBlank(param.getAccountPeriod())){
				accountParam.setAccountPeriod(param.getAccountPeriod());
			}
			if (!StringUtil.isBlank(param.getAccountDay())){
				accountParam.setAccountDay(param.getAccountDay());
			}
			if (!StringUtil.isBlank(param.getTargetType())){
				accountParam.setTargetType(param.getTargetType());
			}
			if (!StringUtil.isBlank(param.getAccountType())){
				accountParam.setAccountType(param.getAccountType());
			}
			MapperFactory.getTAccountParamMapper().updateByPrimaryKeySelective(accountParam);
		}

	}
}

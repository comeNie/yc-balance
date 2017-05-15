package com.ai.slp.balance.service.atom.impl;

import com.ai.slp.balance.api.integrals.param.UpdateIntegralsParam;
import com.ai.slp.balance.dao.mapper.bo.BillAccount;

import com.ai.slp.balance.dao.mapper.bo.Integrals;
import com.ai.slp.balance.dao.mapper.bo.IntegralsCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IIntegralsAtomSV;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntegralsAtomSVImpl implements IIntegralsAtomSV {

	@Override
	public void updateIntegrals(Integrals integrals) {
		MapperFactory.getIntegralsMapper().updateByPrimaryKey(integrals);
	}

	@Override
	public List<Integrals> queryIntegrals(String userId) {
		IntegralsCriteria example = new IntegralsCriteria();
		example.createCriteria().andUserIdEqualTo(userId);
		List<Integrals> integralses = MapperFactory.getIntegralsMapper().selectByExample(example);
		return integralses;
	}

	@Override
	public void createIntegrals(Integrals integrals) {
		MapperFactory.getIntegralsMapper().insert(integrals);
	}

	@Override
	public void delIntegrals(String userId) {
		IntegralsCriteria example = new IntegralsCriteria();
		example.createCriteria().andUserIdEqualTo(userId);
		MapperFactory.getIntegralsMapper().deleteByExample(example);
	}
}

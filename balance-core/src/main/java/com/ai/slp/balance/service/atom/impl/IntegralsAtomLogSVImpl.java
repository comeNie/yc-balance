package com.ai.slp.balance.service.atom.impl;

import com.ai.slp.balance.dao.mapper.bo.Integrals;
import com.ai.slp.balance.dao.mapper.bo.IntegralsCriteria;
import com.ai.slp.balance.dao.mapper.bo.IntegralsLog;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IIntegralsAtomLogSV;
import com.ai.slp.balance.service.atom.interfaces.IIntegralsAtomSV;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntegralsAtomLogSVImpl implements IIntegralsAtomLogSV {

	@Override
	public void createIntegralsLog(IntegralsLog integralsLog) {
		MapperFactory.getIntegralsLogMapper().insert(integralsLog);
	}
}

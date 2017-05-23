package com.ai.slp.balance.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageVo;
import com.ai.slp.balance.service.atom.interfaces.IQueryRechWeithAtomSV;
import com.ai.slp.balance.service.business.interfaces.IQueryRechWeithBusiSV;
@Service
@Transactional
public class RechWeithBusiSVImpl implements IQueryRechWeithBusiSV {
	
	@Autowired
	private IQueryRechWeithAtomSV queryRechWeithAtomSV;

	@Override
	public PageInfo<ReWiehPageVo> queryRechWeithPage(ReWiehPagePageQueryRequest param) {
		return queryRechWeithAtomSV.queryRechWeithPage(param);
	}
	
	
	
}

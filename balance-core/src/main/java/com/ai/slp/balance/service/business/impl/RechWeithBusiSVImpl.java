package com.ai.slp.balance.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.slp.balance.api.rechargewithdrawals.param.ChangeStateRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.QueryByIdRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.QueryInfoResponse;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageVo;
import com.ai.slp.balance.dao.mapper.bo.FunRechargeWithdrawals;
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

	@Override
	public void updateStateLock(ChangeStateRequest param) {
		queryRechWeithAtomSV.updateStateLock(param);
	}

	@Override
	public void updateStateConfirm(ChangeStateRequest param) {
		queryRechWeithAtomSV.updateStateConfirm(param);
	}

	@Override
	public QueryInfoResponse queryRechWith(QueryByIdRequest param) {
		QueryInfoResponse queryInfoResponse = new QueryInfoResponse();
		List<FunRechargeWithdrawals> queryRechWith = queryRechWeithAtomSV.queryRechWith(param);
		for (FunRechargeWithdrawals funRechargeWithdrawals : queryRechWith) {
			BeanUtils.copyProperties(queryInfoResponse, funRechargeWithdrawals);
		}
		return queryInfoResponse;
	}
	
	
	
}

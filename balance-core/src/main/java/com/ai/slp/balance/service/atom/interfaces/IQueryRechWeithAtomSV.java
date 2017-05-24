package com.ai.slp.balance.service.atom.interfaces;



import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.rechargewithdrawals.param.ChangeStateRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.QueryByIdRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageVo;
import com.ai.slp.balance.dao.mapper.bo.FunRechargeWithdrawals;

public interface IQueryRechWeithAtomSV {

	PageInfo<ReWiehPageVo> queryRechWeithPage(ReWiehPagePageQueryRequest param);

	void updateStateLock(ChangeStateRequest param);

	void updateStateConfirm(ChangeStateRequest param);

	FunRechargeWithdrawals queryRechWith(QueryByIdRequest param);
     
}

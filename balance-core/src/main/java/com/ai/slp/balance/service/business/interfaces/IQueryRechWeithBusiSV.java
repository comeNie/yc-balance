package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.rechargewithdrawals.param.ChangeStateRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.QueryByIdRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.QueryInfoResponse;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageVo;

public interface IQueryRechWeithBusiSV {

	PageInfo<ReWiehPageVo> queryRechWeithPage(ReWiehPagePageQueryRequest param);

	void updateStateLock(ChangeStateRequest param);

	void updateStateConfirm(ChangeStateRequest param);

	QueryInfoResponse queryRechWith(QueryByIdRequest param);
}

package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.integrals.param.IncomeQueryIntegralsRequest;
import com.ai.slp.balance.api.integrals.param.IntegralsDetail;
import com.ai.slp.balance.dao.mapper.bo.Integrals;
import com.ai.slp.balance.dao.mapper.bo.IntegralsLog;

import java.util.List;

public interface IIntegralsAtomLogSV {

	/**
	 * 创建积分信息变更记录
	 * @param integralsLog
	 * @author lxk
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void createIntegralsLog(IntegralsLog integralsLog);
	/**
	 * 创建积分信息变更记录
	 * @param userID
	 * @author lxk
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void delIntegralsLog(String userID);

	/**
	 * 根据用户id查询积分
	 * @param param
	 * @return
	 * @author lxk
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public PageInfo<IntegralsDetail> queryIntegralsLog(IncomeQueryIntegralsRequest param);

}

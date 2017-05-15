package com.ai.slp.balance.service.atom.interfaces;

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

}

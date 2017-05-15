package com.ai.slp.balance.service.business.interfaces;


import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.integrals.param.DelIntegralsResponse;
import com.ai.slp.balance.api.integrals.param.IncomeQueryIntegralsRequest;
import com.ai.slp.balance.api.integrals.param.IntegralsQueryResponse;
import com.ai.slp.balance.api.integrals.param.UpdateIntegralsParam;
import com.ai.slp.balance.dao.mapper.bo.Integrals;

import java.util.List;

public interface IIntegralsBusiSV {

	/**
	 * 变更积分
	 * @param updateIntegralsParam
	 * @return
	 * @throws BusinessException
     */
	public void updateIntegrals(UpdateIntegralsParam updateIntegralsParam) throws BusinessException;

	/**
	 * 查询积分
	 * @param userID
	 * @throws BusinessException
     */
	public List<Integrals> queryIntegrals(String userID) throws BusinessException;

	/**
	 * 删除积分
	 * @param userID
	 * @return
	 * @throws BusinessException
	 */
	public void delIntegrals(String userID) throws BusinessException;
	/**
	 * 积分收支查询
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	public IntegralsQueryResponse incomeOutQueryIntegrals(IncomeQueryIntegralsRequest param) throws BusinessException,SystemException;

}

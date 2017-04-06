package com.ai.slp.balance.service.business.interfaces;


import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateParam;
import com.ai.slp.balance.api.accountparam.param.AccountParamVo;

import java.util.List;

public interface IAccountParamBusiSV {

	/**
	 * 根据用户ID查询帐户配置信息
	 * @param targetID
	 * @return
	 * @throws BusinessException
     */
	public List<AccountParamVo> queryAccountParam(String targetID) throws BusinessException;

	/**
	 * 更新帐户配置信息
	 * @param param
	 * @throws BusinessException
     */
	public void updateAccountParam(AccountParamUpdateParam param) throws BusinessException;

}

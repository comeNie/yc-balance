package com.ai.slp.balance.service.atom.interfaces;


import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateParam;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;

import java.util.List;

public interface IAccountParamAtomSV {

	/**
	 * 根据用户ID查询帐户配置信息
	 * @param targetID
	 * @return
	 * @throws BusinessException
	 */
	public List<TAccountParam> queryAccountParam(String targetID) throws BusinessException;

	/**
	 * 更新帐户配置信息
	 * @param param
	 * @throws BusinessException
	 */
	public void updateAccountParam(AccountParamUpdateParam param) throws BusinessException;
}

package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.Integrals;

import java.util.List;

public interface IIntegralsAtomSV {
	/**
	 * 通过用户id修改信息
	 * @param integrals
	 * @author lxk
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateIntegrals(Integrals integrals);
	/**
	 * 创建积分信息
	 * @param integrals
	 * @author lxk
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void createIntegrals(Integrals integrals);
	/**
	 * 根据用户id查询积分
	 * @param userId
	 * @return
	 * @author lxk
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public List<Integrals> queryIntegrals(String userId);

}

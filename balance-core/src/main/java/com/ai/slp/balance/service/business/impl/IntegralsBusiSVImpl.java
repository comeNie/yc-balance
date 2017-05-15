package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.api.integrals.param.DelIntegralsResponse;
import com.ai.slp.balance.api.integrals.param.UpdateIntegralsParam;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.Integrals;
import com.ai.slp.balance.dao.mapper.bo.IntegralsLog;
import com.ai.slp.balance.service.atom.interfaces.IIntegralsAtomLogSV;
import com.ai.slp.balance.service.atom.interfaces.IIntegralsAtomSV;
import com.ai.slp.balance.service.business.interfaces.IIntegralsBusiSV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IntegralsBusiSVImpl implements IIntegralsBusiSV {
	private static final Logger LOG = LogManager.getLogger(IntegralsBusiSVImpl.class);
	@Autowired
	private IIntegralsAtomSV integralsAtomSV;
	@Autowired
	private IIntegralsAtomLogSV integralsAtomLogSV;

	@Override
	public void updateIntegrals(UpdateIntegralsParam updateIntegralsParam) throws BusinessException {
		//判断是否已有积分记录

		List<Integrals> integralses = integralsAtomSV.queryIntegrals(updateIntegralsParam.getUserId());
		if (!CollectionUtil.isEmpty(integralses)){
			//更新已有的记录
			Integrals integrals = integralses.get(0);
			integrals.setNowIntegral(integrals.getNowIntegral()+updateIntegralsParam.getIntegrals());
			integralsAtomSV.updateIntegrals(integrals);
			//更新积分变更记录表
			IntegralsLog integralsLog = new IntegralsLog();
			integralsLog.setIntegralLogId(SeqUtil.getNewId(SeqConstants.INTEGRALS_LOG$INTEGRAL_LOG_ID).toString());
			integralsLog.setId(integrals.getId());
			integralsLog.setIntegralSource(updateIntegralsParam.getIntegralsResource());
			integralsLog.setSystemSource(updateIntegralsParam.getSystemResource());
			integralsLog.setIntegralValue(updateIntegralsParam.getIntegrals());
			integralsLog.setLogTime(DateUtil.getSysDate());
			integralsLog.setUserId(integrals.getUserId());
			integralsAtomLogSV.createIntegralsLog(integralsLog);
		}else {
			//插入新的记录
			Integrals integrals = new Integrals();
			integrals.setId(SeqUtil.getNewId(SeqConstants.INTEGRALS$ID).toString());
			integrals.setCreateTime(DateUtil.getSysDate());
			integrals.setNowIntegral(updateIntegralsParam.getIntegrals());
			integrals.setUserId(updateIntegralsParam.getUserId());
			integralsAtomSV.createIntegrals(integrals);
			//积分变更记录
			IntegralsLog integralsLog = new IntegralsLog();
			integralsLog.setIntegralLogId(SeqUtil.getNewId(SeqConstants.INTEGRALS_LOG$INTEGRAL_LOG_ID).toString());
			integralsLog.setId(integrals.getId());
			integralsLog.setIntegralSource(updateIntegralsParam.getIntegralsResource());
			integralsLog.setSystemSource(updateIntegralsParam.getSystemResource());
			integralsLog.setLogTime(DateUtil.getSysDate());
			integralsLog.setUserId(updateIntegralsParam.getUserId());
			integralsLog.setIntegralValue(updateIntegralsParam.getIntegrals());
			integralsAtomLogSV.createIntegralsLog(integralsLog);
		}
	}


	@Override
	public List<Integrals> queryIntegrals(String userID) throws BusinessException {
		List<Integrals> integralses = integralsAtomSV.queryIntegrals(userID);
		return integralses;
	}

	@Override
	public void delIntegrals(String userID) throws BusinessException {
		List<Integrals> integralses = integralsAtomSV.queryIntegrals(userID);
		if (!CollectionUtil.isEmpty(integralses)){
			//删除已有的记录
			try {
				integralsAtomSV.delIntegrals(userID);
				integralsAtomLogSV.delIntegralsLog(userID);
			}catch (BusinessException e){
				throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "删除积分信息失败");
			}
		}
	}
}

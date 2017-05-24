package com.ai.slp.balance.api.activityrule.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.activity.interfaces.IActivitySV;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityQueryResponse;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.api.activityrule.interfaces.IActivityRuleSV;
import com.ai.slp.balance.api.activityrule.param.*;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IActivityBusiSV;
import com.ai.slp.balance.service.business.interfaces.IActivityRuleBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class ActivityRuleSVImpl implements IActivityRuleSV {
	private static final Logger log = LogManager.getLogger(ActivityRuleSVImpl.class);
	@Autowired
	private IActivityRuleBusiSV iActivityRuleBusiSV;
	@Override
	public FunActivityQueryRuleResponse queryFunActivityRule(String activityID) throws BusinessException, SystemException {
		log.info("活动规则列表查询开始");
		FunActivityQueryRuleResponse funActivityRuleQueryResponse = new FunActivityQueryRuleResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			List<FunActivityRuleResponse> funActivityResponses = iActivityRuleBusiSV.queryFunActivityRule(activityID);
			funActivityRuleQueryResponse.setFunActivityRuleResponseList(funActivityResponses);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("活动规则查询成功");
			funActivityRuleQueryResponse.setResponseHeader(responseHeader);
		}catch (BusinessException businessException){
			responseHeader.setResultCode(businessException.getErrorCode());
			responseHeader.setResultMessage(businessException.getErrorMessage());
			funActivityRuleQueryResponse.setResponseHeader(responseHeader);
		}catch (Exception e){
			log.info("活动规则列表查询异常====="+ JSON.toJSONString(funActivityRuleQueryResponse));
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("活动规则查询成功");
			funActivityRuleQueryResponse.setResponseHeader(responseHeader);
		}
		log.info("活动规则列表查询结束====="+ JSON.toJSONString(funActivityRuleQueryResponse));
		return funActivityRuleQueryResponse;
	}

	@Override
	public UpdateFunActivityRuleResponse updateFunActivityRule(FunActivityRuleActivityRequest activityRules) throws BusinessException, SystemException {
		log.info("传过来的参数============"+ JSON.toJSONString(activityRules));
		log.debug("活动规则变更---开始");
		UpdateFunActivityRuleResponse updateFunActivityRuleResponse = new UpdateFunActivityRuleResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			if (activityRules == null) {
				responseHeader.setIsSuccess(true);
				responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
				responseHeader.setResultMessage("无活动规则可变!");
				updateFunActivityRuleResponse.setResponseHeader(responseHeader);
				return updateFunActivityRuleResponse;
			}
			//规则变更
			iActivityRuleBusiSV.updateFunActivityRule(activityRules);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("活动规则变更变更成功!");
			updateFunActivityRuleResponse.setResponseHeader(responseHeader);
		}catch (BusinessException businessException){
			responseHeader.setResultCode(businessException.getErrorCode());
			responseHeader.setResultMessage(businessException.getErrorMessage());
			updateFunActivityRuleResponse.setResponseHeader(responseHeader);
		}catch (Exception e){
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("活动规则变更失败");
			updateFunActivityRuleResponse.setResponseHeader(responseHeader);
		}
		return updateFunActivityRuleResponse;
	}

	@Override
	public BaseResponse deleteActivityRule(String activityRuleId) throws BusinessException, SystemException {
		log.debug("规则删除---开始");
		BaseResponse baseResponse = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			//积分删除
			iActivityRuleBusiSV.deleteActivityRule(activityRuleId);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("规则删除成功!");
			baseResponse.setResponseHeader(responseHeader);
		}catch (BusinessException businessException){
			responseHeader.setResultCode(businessException.getErrorCode());
			responseHeader.setResultMessage(businessException.getErrorMessage());
			baseResponse.setResponseHeader(responseHeader);
		}catch (Exception e){
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("规则删除失败");
			baseResponse.setResponseHeader(responseHeader);
		}
		return baseResponse;
	}
}

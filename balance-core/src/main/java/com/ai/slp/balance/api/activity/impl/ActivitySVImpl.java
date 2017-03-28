package com.ai.slp.balance.api.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.balance.api.activity.interfaces.IActivitySV;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityQueryResponse;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IActivityBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class ActivitySVImpl implements IActivitySV {
	
	@Autowired
    private IActivityBusiSV iActivityBusiSV;

	/**
	 * 查询活动策略
	 */
	@Override
	public FunActivityQueryResponse queryFunActivity(FunActivityQueryRequest param)throws BusinessException, SystemException {
		FunActivityQueryResponse funActivityQueryResponse = new FunActivityQueryResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
            PageInfo<FunActivityResponse> pageInfo = iActivityBusiSV.queryActivity(param);
            funActivityQueryResponse.setPageInfo(pageInfo);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("活动策略查询成功");
            funActivityQueryResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            funActivityQueryResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("活动策略查询失败");
            funActivityQueryResponse.setResponseHeader(responseHeader);
        }
		return funActivityQueryResponse;
	}
	/**
	 * 删除活动策略
	 */
	@Override
	public BaseResponse deleteActivity(Integer activityId) throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			iActivityBusiSV.deleteActivity(activityId);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("删除活动策略成功");
			response.setResponseHeader(responseHeader);
		}catch (Exception e) {
			throw new SystemException(ExceptCodeConstants.Special.SYSTEM_ERROR,"删除活动策略失败");
		}
		return response;
	}
	
}

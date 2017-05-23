package com.ai.slp.balance.api.rechargewithdrawals.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.slp.balance.api.rechargewithdrawals.interfaces.IRechargeWithdrawalsSV;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageQueryResponse;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageVo;
import com.ai.slp.balance.service.business.interfaces.IQueryRechWeithBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 用途查询服务
 * @author hougang@asiainfo.com
 * @date 2016年11月1日 下午6:28:30 
 * @version V1.0
 */
@Service
@Component
public class QueryRechWeithSVImpl implements IRechargeWithdrawalsSV {
	
	@Autowired
	private IQueryRechWeithBusiSV iQueryRechWeithBusiSV;



	@Override
	public ReWiehPageQueryResponse rechargewithdrawalsPage(ReWiehPagePageQueryRequest param)
			throws BusinessException, SystemException {
		
		ReWiehPageQueryResponse purposePageQueryResponse = new ReWiehPageQueryResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
            PageInfo<ReWiehPageVo> pageInfo = iQueryRechWeithBusiSV.queryRechWeithPage(param);
            purposePageQueryResponse.setPageInfo(pageInfo);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
            responseHeader.setResultMessage("充值提现查询成功");
            purposePageQueryResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            purposePageQueryResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("充值提现查询失败");
            purposePageQueryResponse.setResponseHeader(responseHeader);
        }
		return purposePageQueryResponse;
	}
}

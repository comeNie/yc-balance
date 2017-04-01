package com.ai.slp.balance.api.incomeoutquery.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.fundquery.impl.FundQuerySVImpl;
import com.ai.slp.balance.api.incomeoutquery.interfaces.IncomeOutQuerySV;
import com.ai.slp.balance.api.incomeoutquery.param.*;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IincomeOutQueryBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liquid on 16/11/9.
 */
@Service
@Component
public class IncomeOutQuerySVImpl implements IncomeOutQuerySV{
    private static final Logger LOG = LogManager.getLogger(FundQuerySVImpl.class);

    @Autowired
    private IincomeOutQueryBusiSV iincomeOutQueryBusiSV;
    @Override
    public FundBookQueryResponse incomeOutQuery(IncomeQueryRequest accountId) throws BusinessException, SystemException {
        LOG.debug("账户收支查询");
        if (accountId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(accountId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (accountId.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        if (accountId.getBeginDate() == null){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "开始时间不能为空");
        }
        if (accountId.getEndDate() == null){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "结束时间不能为空");
        }
      /*  if (StringUtil.isBlank(accountId.getIncomeFlag())){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "收支标记不能为空");
        }
        if (StringUtil.isBlank(accountId.getOptType())){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "类型不能为空");
        }*/
        PageInfo<IncomeDetail> pageInfo = iincomeOutQueryBusiSV.incomeOutQuery(accountId);
        FundBookQueryResponse fundBookQueryResponse = new FundBookQueryResponse();
        fundBookQueryResponse.setPageInfo(pageInfo);
        return fundBookQueryResponse;
    }

    @Override
    public FundBookQueryResponseAll incomeOutQueryAll(IncomeQueryRequestAll param) throws BusinessException, SystemException {
        FundBookQueryResponseAll fundBookQueryResponseAll = new FundBookQueryResponseAll();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            fundBookQueryResponseAll = iincomeOutQueryBusiSV.incomeOutQueryAll(param);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("收支查询成功!");
            fundBookQueryResponseAll.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            fundBookQueryResponseAll.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("收支查询失败");
            fundBookQueryResponseAll.setResponseHeader(responseHeader);
        }

        return fundBookQueryResponseAll;
    }
}

package com.ai.slp.balance.api.acocuntparam.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.accountmaintain.interfaces.IAccountMaintainSV;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.balance.api.accountparam.interfaces.IAccountParamSV;
import com.ai.slp.balance.api.accountparam.param.*;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.slp.balance.service.business.interfaces.IAccountManagerSV;
import com.ai.slp.balance.service.business.interfaces.IAccountParamBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class AccountParamSVImpl implements IAccountParamSV {

    private static final Logger log = LogManager.getLogger(AccountParamSVImpl.class);
    @Autowired
    private IAccountParamBusiSV accountParamBusiSV;
    @Override
    public AccountParamQueryResponse queryAccountParam(AccParamReq paramReq) throws BusinessException, SystemException {
        log.debug("按用户ID查询账户配置开始");
        AccountParamQueryResponse accountParamQueryResponse = new AccountParamQueryResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if (paramReq==null){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(paramReq.getTargetID())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用户ID不能为空");
        }
        try {
            List<AccountParamVo> tAccountParams = accountParamBusiSV.queryAccountParam(paramReq.getTargetID());
            accountParamQueryResponse.setAccountParamVos(tAccountParams);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("账单配置信息查询成功!");
            accountParamQueryResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            accountParamQueryResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("账单配置信息查询失败");
            accountParamQueryResponse.setResponseHeader(responseHeader);
        }
        return accountParamQueryResponse;
    }

    @Override
    public AccountParamUpdateResponse updateAccountParam(AccountParamUpdateParam param) throws BusinessException, SystemException {
        log.debug("更新账户配置信息开始");
        log.info("传过来的参数============"+ JSON.toJSONString(param));
        AccountParamUpdateResponse accountParamUpdateResponse = new AccountParamUpdateResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            if (param == null) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:参数不能为空");
            }
            if (StringUtil.isBlank(param.getTargetID())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:用户ID不能为空");
            }
            if (StringUtil.isBlank(param.getTargetName())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:用户名不能为空");
            }
            accountParamBusiSV.updateAccountParam(param);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("账单配置信息更新成功!");
            accountParamUpdateResponse.setResponseHeader(responseHeader);
            log.debug("更新账户配置信息---结束");
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            accountParamUpdateResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("账单配置信息更新失败");
            accountParamUpdateResponse.setResponseHeader(responseHeader);
        }
        return accountParamUpdateResponse;
    }
}

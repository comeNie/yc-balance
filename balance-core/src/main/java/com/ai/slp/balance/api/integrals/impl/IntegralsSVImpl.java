package com.ai.slp.balance.api.integrals.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.integrals.interfaces.IIntegralsSV;
import com.ai.slp.balance.api.integrals.param.DelIntegralsResponse;
import com.ai.slp.balance.api.integrals.param.UpdateIntegralsResponse;
import com.ai.slp.balance.api.integrals.param.UpdateIntegralsParam;
import com.ai.slp.balance.api.integrals.param.IntegralsResponse;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.Integrals;
import com.ai.slp.balance.service.business.interfaces.IIntegralsBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liquid on 17/5/15.
 */
@Service
@Component
public class IntegralsSVImpl implements IIntegralsSV{
    private static final Logger log = LogManager.getLogger(IntegralsSVImpl.class);
    @Autowired
    private IIntegralsBusiSV integralsBusiSV;
    @Override
    public UpdateIntegralsResponse updateIntegrals(UpdateIntegralsParam updateIntegralsParam) throws BusinessException, SystemException {
        log.info("传过来的参数============"+ JSON.toJSONString(updateIntegralsParam));
        log.debug("积分变更---开始");
        UpdateIntegralsResponse updateIntegralsResponse = new UpdateIntegralsResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            if (updateIntegralsParam == null) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:参数不能为空");
            }
            if (StringUtil.isBlank(updateIntegralsParam.getUserId())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:用户ID不能为空");
            }
            if (updateIntegralsParam.getIntegrals()==null) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:变更积分不能为空");
            }
            //积分变更
            integralsBusiSV.updateIntegrals(updateIntegralsParam);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("积分变更成功!");
            updateIntegralsResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            updateIntegralsResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("积分变更失败");
            updateIntegralsResponse.setResponseHeader(responseHeader);
        }
        return updateIntegralsResponse;
    }

    @Override
    public IntegralsResponse queryIntegrals(String userID) throws BusinessException, SystemException {
        log.debug("按用户id查询积分开始");
        IntegralsResponse integralsResponse = new IntegralsResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try{
            List<Integrals> integralses = integralsBusiSV.queryIntegrals(userID);
            log.debug("积分查询结束");
            if(CollectionUtil.isEmpty(integralses)){
                responseHeader.setResultCode("0001");
                responseHeader.setResultMessage("积分信息不存在!");
                integralsResponse.setResponseHeader(responseHeader);
            }else{
                BeanUtils.copyProperties(integralsResponse,integralses.get(0));
                responseHeader.setResultCode("0000");
                responseHeader.setResultMessage("成功");
                responseHeader.setIsSuccess(true);
                integralsResponse.setResponseHeader(responseHeader);
            }
            return integralsResponse;
        }catch(Exception e){
            responseHeader.setResultCode("0002");
            responseHeader.setResultMessage("查询资料失败");
            integralsResponse.setResponseHeader(responseHeader);
            return integralsResponse;
        }
    }

    @Override
    public DelIntegralsResponse delIntegrals(String userID) throws BusinessException, SystemException {
        log.debug("积分删除---开始");
        DelIntegralsResponse delIntegralsResponse = new DelIntegralsResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            //积分删除
            integralsBusiSV.delIntegrals(userID);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("积分删除成功!");
            delIntegralsResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            delIntegralsResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("积分删除失败");
            delIntegralsResponse.setResponseHeader(responseHeader);
        }
        return delIntegralsResponse;
    }
}


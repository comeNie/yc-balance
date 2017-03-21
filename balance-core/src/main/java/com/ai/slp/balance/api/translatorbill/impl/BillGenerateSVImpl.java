package com.ai.slp.balance.api.translatorbill.impl;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.resquery.param.ResUsableDetail;
import com.ai.slp.balance.api.translatorbill.interfaces.IBillGenerateSV;
import com.ai.slp.balance.api.translatorbill.param.*;
import com.ai.slp.balance.constants.ExceptCodeConstants;

import com.ai.slp.balance.dao.mapper.bo.FunAccount;
import com.ai.slp.balance.service.business.interfaces.IBillGenerateBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liquid on 17/2/17.
 */
@Service
@Component
public class BillGenerateSVImpl implements IBillGenerateSV {
    private static final Logger log = LogManager.getLogger(BillGenerateSVImpl.class);
    @Autowired
    private IBillGenerateBusiSV iBillQuerySV;

    /**
     *账单查询
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    @Override
    public FunAccountQueryResponse queryFunAccount(FunAccountQueryRequest param) throws BusinessException, SystemException {
        log.info("账单查询");
        FunAccountQueryResponse funAccountQueryResponse = new FunAccountQueryResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        try {
            PageInfo<FunAccountResponse> pageInfo = iBillQuerySV.funAccountQuery(param);
            funAccountQueryResponse.setPageInfo(pageInfo);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("账单查询成功");
            funAccountQueryResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            funAccountQueryResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("账单查询失败");
            funAccountQueryResponse.setResponseHeader(responseHeader);
        }

        return funAccountQueryResponse;
    }

    /**
     * 账单生成
     * @param param 结算账单类型
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    @Override
    public boolean generateBill(String param) throws BusinessException, SystemException {
        log.debug("账单生成");
        return iBillQuerySV.BillGenerate(param);
    }

    /**
     * 账单明细查询
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    @Override
    public FunAccountDetailPageResponse queryFunAccountDetail(FunAccountDetailQueryRequest param) throws BusinessException, SystemException {
        log.debug("账单明细查询");
        if (param==null){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getBillID())){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数账户iD不能为空");
        }

        FunAccountDetailPageResponse funAccountDetailPageResponse = new FunAccountDetailPageResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            PageInfo<FunAccountDetailResponse> pageInfo = iBillQuerySV.queryFunAccountDetail(param);
            funAccountDetailPageResponse.setPageInfo(pageInfo);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("账单查询成功");
            funAccountDetailPageResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            funAccountDetailPageResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("账单查询失败");
            funAccountDetailPageResponse.setResponseHeader(responseHeader);
        }
        return funAccountDetailPageResponse;
    }

    /***
     * 结算账单
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    @Override
    public String settleBill(SettleParam param) throws BusinessException, SystemException {
        log.debug("开始结算账单");

        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getAccountType())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "结算方式不能为空");
        }
        if (StringUtil.isBlank(param.getBillID())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账单ID不能为空");
        }
        if (StringUtil.isBlank(param.getAccountAmount().toString())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "结算金额不能为空");
        }
        if (StringUtil.isBlank(param.getSettleAccount().toString())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "结算账户不能为空");
        }
        String billID = iBillQuerySV.settleBill(param);
        return billID;
    }

    @Override
    public String insertParam(AccountParam accountParam) throws BusinessException, SystemException {

        log.info("传过来的参数============"+ JSON.toJSONString(accountParam));
        log.debug("创建用户信息---开始");
        String id = null;
        try {
            if (accountParam == null) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:参数不能为空");
            }
            if (StringUtil.isBlank(accountParam.getTargetID())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:用户ID不能为空");
            }
            if (StringUtil.isBlank(accountParam.getTargetName())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:用户名不能为空");
            }

            id = iBillQuerySV.insertParam(accountParam);
            if (id == null) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "0004-配置信息失败");
            }
            log.debug("创建账户---结束");
        }catch (Exception e){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "0004-存储失败");
        }
        return id;
    }
}

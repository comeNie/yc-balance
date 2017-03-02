package com.ai.slp.balance.api.translatorbill.impl;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.resquery.param.ResUsableDetail;
import com.ai.slp.balance.api.translatorbill.interfaces.IBillGenerateSV;
import com.ai.slp.balance.api.translatorbill.param.*;
import com.ai.slp.balance.constants.ExceptCodeConstants;

import com.ai.slp.balance.dao.mapper.bo.FunAccount;
import com.ai.slp.balance.service.business.interfaces.IBillGenerateBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
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
        log.debug("账单查询");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        PageInfo<FunAccountResponse> pageInfo = iBillQuerySV.funAccountQuery(param);
        FunAccountQueryResponse funAccountQueryResponse = new FunAccountQueryResponse();
        funAccountQueryResponse.setPageInfo(pageInfo);
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
    public List<FunAccountDetailResponse> queryFunAccountDetail(String param) throws BusinessException, SystemException {
        log.debug("账单明细查询");
        List<FunAccountDetailResponse> funAccountDetailResponse = iBillQuerySV.queryFunAccountDetail(param);
        return funAccountDetailResponse;
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
        log.debug("开始销账扣款服务");
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
}

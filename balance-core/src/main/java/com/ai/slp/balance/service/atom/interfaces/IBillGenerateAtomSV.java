package com.ai.slp.balance.service.atom.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.translatorbill.param.*;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.yc.order.api.orderquery.param.OrdOrderVo;

import java.util.List;

/**
 * Created by liquid on 17/2/17.
 */
public interface IBillGenerateAtomSV {


    /**
     * 插入账单信息表
     * @param ordOrderVo
     * @param tAccountParam
     * @param billFee
     * @param beginTime
     * @param endTime
     * @return
     */
    public  String insertAccount(OrdOrderVo ordOrderVo, TAccountParam tAccountParam, long billFee,long accountAmount,long platFee,
                                 String beginTime, String endTime);

    /**
     * 插入账单明细表lsp信息
     * @param ordOrderVo
     * @param billId
     */
    public  void insertAccountLspDetail(OrdOrderVo ordOrderVo,String billId,long translatorFeeDetail,long lspFee);
    /**
     * 插入账单信息表lsp信息
     * @param ordOrderVo
     * @param tAccountParam
     * @param billFee
     * @param accountAmount0
     * @param platFee0
     * @param beginTime
     * @param endTime
     * @return
     */
    public  String insertAccountLsp(OrdOrderVo ordOrderVo,TAccountParam tAccountParam,long accountAmount0,long billFee,long translator,long platFee0,
                                    String beginTime,String endTime);
    /**
     * 插入账单明细表
     * @param ordOrderVo
     * @param billId
     */
    public  void insertAccountDetail(OrdOrderVo ordOrderVo,String billId);
    /**
     * 查询账单表
     * @param funAccountQueryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public PageInfo<FunAccountResponse> funAccountQuery(FunAccountQueryRequest funAccountQueryRequest)throws BusinessException, SystemException;

    /***
     * 账单明细查询
     * @param param 账单ID
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public PageInfo<FunAccountDetailResponse> queryFunAccountDetail(FunAccountDetailQueryRequest param) throws BusinessException, SystemException ;

    /**
     * 结算账户
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    public String settleBill(SettleParam param) throws BusinessException, SystemException;


}

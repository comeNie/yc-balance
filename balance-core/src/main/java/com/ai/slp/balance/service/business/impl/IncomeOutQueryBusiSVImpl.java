package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.fundquery.param.AccountIdParam;
import com.ai.slp.balance.api.incomeoutquery.param.*;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunFundDetail;
import com.ai.slp.balance.dao.mapper.bo.FunFundDetailCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerial;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunFundDetailMapper;
import com.ai.slp.balance.dao.mapper.interfaces.FunFundSerialMapper;
import com.ai.slp.balance.service.atom.impl.IncomeOutQueryAtomSVImpl;
import com.ai.slp.balance.service.atom.interfaces.IFunFundSerialAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IincomeOutQueryAtomSV;
import com.ai.slp.balance.service.business.interfaces.IincomeOutQueryBusiSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liquid on 16/11/9.
 */
@Service
@Transactional
public class IncomeOutQueryBusiSVImpl implements IincomeOutQueryBusiSV{

    @Autowired
    private IincomeOutQueryAtomSV incomeOutQueryAtomSV;
    @Override
    public PageInfo<IncomeDetail> incomeOutQuery(IncomeQueryRequest accountId) throws BusinessException, SystemException {
        //从serial中取出需要的字段
        List<IncomeDetail> incomeDetails = null;
        FunFundSerialCriteria funFundSerialCriteria = new FunFundSerialCriteria();
        FunFundSerialCriteria.Criteria criteria = funFundSerialCriteria.createCriteria();
        String orderByClause = "pay_time desc";
        funFundSerialCriteria.setOrderByClause(orderByClause);
        criteria.andTenantIdEqualTo(accountId.getTenantId());
        criteria.andAcctId1EqualTo(accountId.getAccountId());
        if (!StringUtil.isBlank(accountId.getOptType())){
            criteria.andOptTypeEqualTo(accountId.getOptType());
        }
        criteria.andPayTimeGreaterThanOrEqualTo(Timestamp.valueOf(accountId.getBeginDate()));
        criteria.andPayTimeLessThanOrEqualTo(Timestamp.valueOf(accountId.getEndDate()));
        if (!StringUtil.isBlank(accountId.getIncomeFlag())){
            criteria.andIncomeFlagEqualTo(accountId.getIncomeFlag());
        }
        FunFundSerialMapper mapper = MapperFactory.getFunFundSerialMapper();
        PageInfo<IncomeDetail> pageInfo = new PageInfo<IncomeDetail>();
        pageInfo.setCount(mapper.countByExample(funFundSerialCriteria));
        if (accountId.getPageInfo() == null) {
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
        } else {
            pageInfo.setPageNo(accountId.getPageInfo().getPageNo());
            pageInfo.setPageSize(accountId.getPageInfo().getPageSize() == null ? 10
                    : accountId.getPageInfo().getPageSize());
            funFundSerialCriteria.setLimitStart(accountId.getPageInfo()
                    .getStartRowIndex());
            funFundSerialCriteria.setLimitEnd(accountId.getPageInfo().getPageSize());
        }
        List<FunFundSerial> funFundSerials = mapper.selectByExample(funFundSerialCriteria);
        if (!CollectionUtil.isEmpty(funFundSerials)){
            incomeDetails = new ArrayList<IncomeDetail>();
            for (int i=0;i<funFundSerials.size();i++){
                IncomeDetail incomeDetail = new IncomeDetail();
                BeanUtils.copyProperties(incomeDetail,funFundSerials.get(i));
                //从detail中取出需要的字段,根据pay_serial_code获取数据
                FunFundDetailCriteria funFundDetailCriteria = new FunFundDetailCriteria();
                FunFundDetailCriteria.Criteria detailCriteria = funFundDetailCriteria.createCriteria();
                detailCriteria.andPaySerialCodeEqualTo(funFundSerials.get(i).getPaySerialCode());
                FunFundDetailMapper detailMapper = MapperFactory.getFunFundDetailMapper();
                List<FunFundDetail>  funFundDetails = detailMapper.selectByExample(funFundDetailCriteria);
                BeanUtils.copyProperties(incomeDetail,funFundDetails.get(0));
                incomeDetails.add(incomeDetail);
            }
        }else {
            return null;
        }
        if(!CollectionUtil.isEmpty(incomeDetails)){
            pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
            pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
            pageInfo.setResult(incomeDetails);
        }else {
            return null;
        }
        //将两张表中的字段放在IncomeDetail中
        return pageInfo;
    }

    @Override
    public FundBookQueryResponseAll incomeOutQueryAll(IncomeQueryRequestAll param) throws BusinessException, SystemException {
        FundBookQueryResponseAll fundBookQueryResponseAll = new FundBookQueryResponseAll();
        PageInfo<IncomeDetailAll> pageInfo = new PageInfo<IncomeDetailAll>();
        List<IncomeDetailAll> allIncomeOut = null;
        List<IncomeDetailAll> allIncomeOut1 = incomeOutQueryAtomSV.getAllIncomeOut(param.getSerialCode(), param.getNickName(),
                param.getBeginDate(), param.getEndDate(),
                param.getChannel(), param.getState(),
                param.getCurrencyUnit(), param.getBeginAmount(),
                param.getEndAmount(), param.getIncomeFlag(),
                param.getOptType(), null, null);
        pageInfo.setCount(allIncomeOut1.size());

        Integer incomeNum =0;
        Long incomeAmountUSD = 0l;
        Long incomeAmountRMB = 0l;
        Integer outNum =0;
        Long outAmountUSD = 0l;
        Long outAmountRMB = 0l;
        //充值记录 incomeFlag = "1";  optType  = "1";
        if (param.getIncomeFlag()!=null&&param.getOptType()!=null){
            if (param.getIncomeFlag().equals("1")&&param.getOptType().equals("1")) {
                fundBookQueryResponseAll.setIncomeNum(allIncomeOut1.size());
                fundBookQueryResponseAll.setOutNum(0);
                for (IncomeDetailAll incomeDetailAll : allIncomeOut1) {
                    if (incomeDetailAll.getCurrencyUnit().equals("1")){
                        incomeAmountRMB+=incomeDetailAll.getTotalAmount();
                    }
                    if (incomeDetailAll.getCurrencyUnit().equals("2")){
                        incomeAmountUSD+=incomeDetailAll.getTotalAmount();
                    }
                }
                fundBookQueryResponseAll.setIncomeAmountRMB(incomeAmountRMB);
                fundBookQueryResponseAll.setIncomeAmountUSD(incomeAmountUSD);
            }
        }
        //支出记录 incomeFlag = "0";
        if (param.getIncomeFlag()!=null) {
            if (param.getIncomeFlag().equals("0") && param.getOptType() == null) {
                fundBookQueryResponseAll.setOutNum(allIncomeOut1.size());
                fundBookQueryResponseAll.setIncomeNum(0);
                for (IncomeDetailAll incomeDetailAll : allIncomeOut1) {
                    //支出条数和支出金额计算
                    if (incomeDetailAll.getIncomeFlag().equals("0")) {
                        if (incomeDetailAll.getCurrencyUnit().equals("1")) {
                            outAmountRMB += incomeDetailAll.getTotalAmount();
                        }
                        if (incomeDetailAll.getCurrencyUnit().equals("2")) {
                            outAmountUSD += incomeDetailAll.getTotalAmount();
                        }
                    }
                }
                fundBookQueryResponseAll.setOutAmountRMB(outAmountRMB);
                fundBookQueryResponseAll.setOutAmountUSD(outAmountUSD);
            }
        }
        if (param.getIncomeFlag()==null&&param.getOptType()==null){
            for (IncomeDetailAll incomeDetailAll:allIncomeOut1){
                //充值条数和充值金额计算
                if (incomeDetailAll.getIncomeFlag().equals("1")&&incomeDetailAll.getOptType().equals("1")){
                    incomeNum+=1;
                    if (incomeDetailAll.getCurrencyUnit().equals("1")){
                        incomeAmountRMB+=incomeDetailAll.getTotalAmount();
                    }
                    if (incomeDetailAll.getCurrencyUnit().equals("2")){
                        incomeAmountUSD+=incomeDetailAll.getTotalAmount();
                    }
                }
                //支出条数和支出金额计算
                if (incomeDetailAll.getIncomeFlag().equals("0")){
                    outNum+=1;
                    if (incomeDetailAll.getCurrencyUnit().equals("1")){
                        outAmountRMB+=incomeDetailAll.getTotalAmount();
                    }
                    if (incomeDetailAll.getCurrencyUnit().equals("2")){
                        outAmountUSD+=incomeDetailAll.getTotalAmount();
                    }
                }
            }
            fundBookQueryResponseAll.setIncomeNum(incomeNum);
            fundBookQueryResponseAll.setIncomeAmountRMB(incomeAmountRMB);
            fundBookQueryResponseAll.setIncomeAmountUSD(incomeAmountUSD);
            fundBookQueryResponseAll.setOutNum(outNum);
            fundBookQueryResponseAll.setOutAmountRMB(outAmountRMB);
            fundBookQueryResponseAll.setOutAmountUSD(outAmountUSD);
        }
        if (param.getPageInfo() == null) {
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
            allIncomeOut = incomeOutQueryAtomSV.getAllIncomeOut(param.getSerialCode(), param.getNickName(),
                    param.getBeginDate(), param.getEndDate(),
                    param.getChannel(), param.getState(),
                    param.getCurrencyUnit(), param.getBeginAmount(),
                    param.getEndAmount(), param.getIncomeFlag(),
                    param.getOptType(),pageInfo.getPageNo(),pageInfo.getPageSize());
        }else {
            pageInfo.setPageNo(param.getPageInfo().getPageNo());
            pageInfo.setPageSize(param.getPageInfo().getPageSize() == null ? 10
                    : param.getPageInfo().getPageSize());
            allIncomeOut = incomeOutQueryAtomSV.getAllIncomeOut(param.getSerialCode(), param.getNickName(),
                    param.getBeginDate(), param.getEndDate(),
                    param.getChannel(), param.getState(),
                    param.getCurrencyUnit(), param.getBeginAmount(),
                    param.getEndAmount(), param.getIncomeFlag(),
                    param.getOptType(),pageInfo.getPageNo(),pageInfo.getPageSize());
        }
        if(!CollectionUtil.isEmpty(allIncomeOut)){
            pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
            pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
            pageInfo.setResult(allIncomeOut);
            fundBookQueryResponseAll.setPageInfo(pageInfo);
        }else {
            return null;
        }
        return fundBookQueryResponseAll;
    }
}

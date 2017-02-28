package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.fundquery.param.AccountIdParam;
import com.ai.slp.balance.api.incomeoutquery.param.FundBookQueryResponse;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetail;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeQueryRequest;
import com.ai.slp.balance.dao.mapper.bo.FunFundDetail;
import com.ai.slp.balance.dao.mapper.bo.FunFundDetailCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerial;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunFundDetailMapper;
import com.ai.slp.balance.dao.mapper.interfaces.FunFundSerialMapper;
import com.ai.slp.balance.service.atom.impl.IncomeOutQueryAtomSVImpl;
import com.ai.slp.balance.service.atom.interfaces.IFunFundSerialAtomSV;
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
}

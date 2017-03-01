package com.ai.slp.balance.dao.mapper.factory;

import javax.annotation.PostConstruct;

import com.ai.slp.balance.dao.mapper.interfaces.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.attach.FunAccountInfoAttachMapper;
import com.ai.slp.balance.dao.mapper.attach.FunFundBookAttachMapper;
import com.ai.slp.balance.dao.mapper.attach.FunResBookAttachMapper;
import com.ai.slp.balance.dao.mapper.attach.FunResBookRestAmountAttachMapper;
import com.ai.slp.balance.dao.mapper.attach.FunResOperaDetailAttachMapper;

@Component
public class MapperFactory {

    @Autowired
    private SqlSessionTemplate st;

    private static SqlSessionTemplate sqlSessionTemplate;

    @PostConstruct
    void init() {
        setSqlSessionTemplate(st);
    }

    public static void setSqlSessionTemplate(SqlSessionTemplate st) {
        MapperFactory.sqlSessionTemplate = st;
    }

    public static FunSubjectMapper getFunSubjectMapper() {
        return sqlSessionTemplate.getMapper(FunSubjectMapper.class);
    }
    public static TAccountParamMapper getTAccountParamMapper(){
        return sqlSessionTemplate.getMapper(TAccountParamMapper.class);
    }

    public static FunAccountDetailMapper getFunAccountDetailMapper(){
        return sqlSessionTemplate.getMapper(FunAccountDetailMapper.class);
    }

    public static FunAccountMapper getFunAccountMapper(){
        return sqlSessionTemplate.getMapper(FunAccountMapper.class);
    }
    public static FunSubjectFundMapper getFunSubjectFundMapper() {
        return sqlSessionTemplate.getMapper(FunSubjectFundMapper.class);
    }

    public static FunAccountInfoMapper getFunAccountInfoMapper() {
        return sqlSessionTemplate.getMapper(FunAccountInfoMapper.class);
    }

    public static FunAccountSetMapper getFunAccountSetMapper() {
        return sqlSessionTemplate.getMapper(FunAccountSetMapper.class);
    }

    public static FunAccountLogMapper getFunAccountLogMapper() {
        return sqlSessionTemplate.getMapper(FunAccountLogMapper.class);
    }

    public static FunAccountSetLogMapper getFunAccountSetLogMapper() {
        return sqlSessionTemplate.getMapper(FunAccountSetLogMapper.class);
    }

    public static FunFundBookMapper getFunFundBookMapper() {
        return sqlSessionTemplate.getMapper(FunFundBookMapper.class);
    }

    public static FunSubsFreezeMapper getFunSubsFreezeMapper() {
        return sqlSessionTemplate.getMapper(FunSubsFreezeMapper.class);
    }

    public static FunAccountInfoByCustIdIdxMapper getFunAccountInfoByCustIdIdxMapper() {
        return sqlSessionTemplate.getMapper(FunAccountInfoByCustIdIdxMapper.class);
    }

    public static FunAccountInfoByExternalIdIdxMapper getFunAccountInfoByExternalIdIdxMapper() {
        return sqlSessionTemplate.getMapper(FunAccountInfoByExternalIdIdxMapper.class);
    }

    public static FunFundDetailMapper getFunFundDetailMapper() {
        return sqlSessionTemplate.getMapper(FunFundDetailMapper.class);
    }

    public static FunFundSerialMapper getFunFundSerialMapper() {
        return sqlSessionTemplate.getMapper(FunFundSerialMapper.class);
    }

    public static FunFundSerialByAcctIdIdxMapper getFunFundSerialByAcctIdIdxMapper() {
        return sqlSessionTemplate.getMapper(FunFundSerialByAcctIdIdxMapper.class);
    }

    public static FunFundBookAttachMapper getFunFundBookAttachMapper() {
        return sqlSessionTemplate.getMapper(FunFundBookAttachMapper.class);
    }

    public static FunAccountInfoAttachMapper getFunAccountInfoAttachMapper() {
        return sqlSessionTemplate.getMapper(FunAccountInfoAttachMapper.class);
    }

    public static FunResBookMapper getFunResBookMapper() {
        return sqlSessionTemplate.getMapper(FunResBookMapper.class);
    }
    
    public static FunResBookAttachMapper getFunResBookAttachMapper() {
        return sqlSessionTemplate.getMapper(FunResBookAttachMapper.class);
    }

    public static FunResBookRestAmountMapper getFunResBookRestAmountMapper() {
        return sqlSessionTemplate.getMapper(FunResBookRestAmountMapper.class);
    }

    public static FunResBookRestAmountAttachMapper getFunResBookRestAmountAttachMapper() {
        return sqlSessionTemplate.getMapper(FunResBookRestAmountAttachMapper.class);
    }

    public static FunResOperaDetailMapper getFunResOperaDetailMapper() {
        return sqlSessionTemplate.getMapper(FunResOperaDetailMapper.class);
    }

    public static FunResOperaDetailAttachMapper getFunResOperaDetailAttachMapper() {
        return sqlSessionTemplate.getMapper(FunResOperaDetailAttachMapper.class);
    }
    
    public static BillAccountMapper getBillAccountMapper() {
        return sqlSessionTemplate.getMapper(BillAccountMapper.class);
    }
    
    public static BillCycleDefMapper getBillCycleDefMapper() {
        return sqlSessionTemplate.getMapper(BillCycleDefMapper.class);
    }
    
    public static BillPayDetailMapper getBillPayDetailMapper() {
        return sqlSessionTemplate.getMapper(BillPayDetailMapper.class);
    }
    
    public static BillPayLogMapper getBillPayLogMapper() {
        return sqlSessionTemplate.getMapper(BillPayLogMapper.class);
    }
    
    public static BillOrder2feeMapper getBillOrder2feeMapper() {
        return sqlSessionTemplate.getMapper(BillOrder2feeMapper.class);
    }
    
    public static FunActivityMapper getFunActivityMapper(){
    	return sqlSessionTemplate.getMapper(FunActivityMapper.class);
    }
    
    public static FunActivityCouponRelMapper getFunActivityCouponRelMapper(){
    	return sqlSessionTemplate.getMapper(FunActivityCouponRelMapper.class);
    }
    
    public static FunCouponTemplateMapper getFunCouponTemplateMapper(){
    	return sqlSessionTemplate.getMapper(FunCouponTemplateMapper.class);
    }
    
    public static FunDiscountCouponMapper getFunDiscountCouponMapper(){
    	return sqlSessionTemplate.getMapper(FunDiscountCouponMapper.class);
    }
    
}

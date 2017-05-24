package com.ai.slp.balance.test.api.incomeOutQuery.impl;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.fundquery.interfaces.IFundQuerySV;
import com.ai.slp.balance.api.fundquery.param.*;
import com.ai.slp.balance.api.incomeoutquery.interfaces.IncomeOutQuerySV;
import com.ai.slp.balance.api.incomeoutquery.param.*;
import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class IncomeOutQueryTest extends TestCase {

    private static final Logger log = LogManager.getLogger(IncomeOutQueryTest.class);

    @Autowired
    private IncomeOutQuerySV incomeOutQuerySV;

    @Test
    public void testIncomeOutQuery() throws Exception{
        IncomeQueryRequest incomeQueryRequest = new IncomeQueryRequest();
        incomeQueryRequest.setAccountId(12781);
//        incomeQueryRequest.setIncomeFlag("1");
        incomeQueryRequest.setTenantId("yeecloud");
        incomeQueryRequest.setOptType("5");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        Date myDate1 = dateFormat.parse("2009-06-01 22:36:01");
        incomeQueryRequest.setBeginDate("2016-08-17 00:00:00");
//        Date myDate2 = dateFormat.parse("2019-06-01 22:36:01");
        incomeQueryRequest.setEndDate("2017-11-17 23:59:59");

        PageInfo<IncomeDetail> pageInfo=new PageInfo<IncomeDetail>();
        pageInfo.setPageSize(10);
        pageInfo.setPageNo(1);
        incomeQueryRequest.setPageInfo(pageInfo);
        FundBookQueryResponse fundBookQueryResponse = incomeOutQuerySV.incomeOutQuery(incomeQueryRequest);
        System.out.print("1");
    }
    @Test
    public void testIncomeOutQueryAll() throws Exception{
        IncomeQueryRequestAll incomeQueryRequestAll = new IncomeQueryRequestAll();
//        incomeQueryRequestAll.setBeginAmount(null);
//        incomeQueryRequestAll.setEndAmount(null);
        incomeQueryRequestAll.setSerialCode("77");
//        incomeQueryRequestAll.setBeginDate("2017-1-4 23:59:59");
//        incomeQueryRequestAll.setEndDate("2017-1-16 23:59:59");
//        incomeQueryRequestAll.setBeginAmount(-1000l);
//        incomeQueryRequestAll.setEndAmount(1000l);
//        incomeQueryRequestAll.setCurrencyUnit("1");
//        incomeQueryRequestAll.setChannel("中译语通科技有限公司");
////        incomeQueryRequestAll.setNickName("t");
//        incomeQueryRequestAll.setIncomeFlag("1");
//        incomeQueryRequestAll.setOptType("2");
        PageInfo<IncomeDetailAll>  pageInfo= new PageInfo<>();
        pageInfo.setPageNo(2);
        pageInfo.setPageSize(10);
        incomeQueryRequestAll.setPageInfo(pageInfo);
        FundBookQueryResponseAll fundBookQueryResponse = incomeOutQuerySV.incomeOutQueryAll(incomeQueryRequestAll);
        System.out.print("1");
    }

}

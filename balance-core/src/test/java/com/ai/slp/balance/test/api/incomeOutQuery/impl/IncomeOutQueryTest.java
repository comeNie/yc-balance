package com.ai.slp.balance.test.api.incomeOutQuery.impl;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.fundquery.interfaces.IFundQuerySV;
import com.ai.slp.balance.api.fundquery.param.*;
import com.ai.slp.balance.api.incomeoutquery.interfaces.IncomeOutQuerySV;
import com.ai.slp.balance.api.incomeoutquery.param.FundBookQueryResponse;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeDetail;
import com.ai.slp.balance.api.incomeoutquery.param.IncomeQueryRequest;
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
        incomeQueryRequest.setAccountId(11531);
        incomeQueryRequest.setIncomeFlag("0");
        incomeQueryRequest.setTenantId("yeecloud");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        Date myDate1 = dateFormat.parse("2009-06-01 22:36:01");
        incomeQueryRequest.setBeginDate("2009-06-01 22:36:01");
//        Date myDate2 = dateFormat.parse("2019-06-01 22:36:01");
        incomeQueryRequest.setEndDate("2019-06-01 22:36:01");
        PageInfo<IncomeDetail> pageInfo=new PageInfo<IncomeDetail>();
        pageInfo.setPageSize(10);
        pageInfo.setPageNo(1);
        FundBookQueryResponse fundBookQueryResponse = incomeOutQuerySV.incomeOutQuery(incomeQueryRequest);
        System.out.print("1");
    }


}

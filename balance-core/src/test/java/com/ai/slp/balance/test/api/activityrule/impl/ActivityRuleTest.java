package com.ai.slp.balance.test.api.activityrule.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.UUIDUtil;
import com.ai.slp.balance.api.accountmaintain.interfaces.IAccountMaintainSV;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.balance.api.accountquery.interfaces.IAccountQuerySV;
import com.ai.slp.balance.api.accountquery.param.AccountIdParam;
import com.ai.slp.balance.api.accountquery.param.AccountInfoVo;
import com.ai.slp.balance.api.accountquery.param.AccountSetVo;
import com.ai.slp.balance.api.accountquery.param.CustIdParam;
import com.ai.slp.balance.api.activityrule.interfaces.IActivityRuleSV;
import com.ai.slp.balance.api.activityrule.param.FunActivityQueryRuleResponse;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleActivityRequest;
import com.ai.slp.balance.api.activityrule.param.FunActivityRuleRequest;
import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ActivityRuleTest extends TestCase {

    private static final Logger log = LogManager.getLogger(ActivityRuleTest.class);
    
    //活动规则
    @Autowired
    private IActivityRuleSV iActivityRuleSV;

    @Test
    public void testQueryActivityRule() throws Exception {
        FunActivityQueryRuleResponse funActivityQueryRuleResponse = iActivityRuleSV.queryFunActivityRule("2");
        System.out.print(1212);
    }
    @Test
    public void testdelActivityRule() throws Exception {
        BaseResponse baseResponse = iActivityRuleSV.deleteActivityRule("1");
        System.out.print(1212);
    }
    @Test
    public void testuodateActivityRule() throws Exception {
        FunActivityRuleActivityRequest funActivityRuleActivityRequest = new FunActivityRuleActivityRequest();
        funActivityRuleActivityRequest.setActivityId(1);
        funActivityRuleActivityRequest.setUsedScene("li");
        funActivityRuleActivityRequest.setStatus("0");
        ArrayList<FunActivityRuleRequest> list = new ArrayList<>();
        FunActivityRuleRequest funActivityRuleRequest = new FunActivityRuleRequest();
        funActivityRuleRequest.setId("22");
        funActivityRuleRequest.setActivityId(1L);
        funActivityRuleRequest.setCurrencyUnit("2");
        funActivityRuleRequest.setTotalMoneyAmount(200l);
        funActivityRuleRequest.setRemainingMoneyAmount(300l);
        list.add(funActivityRuleRequest);
        funActivityRuleActivityRequest.setFunActivityRuleRequestList(list);
        iActivityRuleSV.updateFunActivityRule(funActivityRuleActivityRequest);
        System.out.print(1212);
    }


}

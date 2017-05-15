package com.ai.slp.balance.test.api.impl;

import com.ai.slp.balance.api.accountparam.interfaces.IAccountParamSV;
import com.ai.slp.balance.api.accountparam.param.AccParamReq;
import com.ai.slp.balance.api.accountparam.param.AccountParamQueryResponse;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateParam;
import com.ai.slp.balance.api.accountparam.param.AccountParamUpdateResponse;
import com.ai.slp.balance.api.translatorbill.interfaces.IBillGenerateSV;
import com.ai.slp.balance.api.translatorbill.param.*;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.SyslogAppender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class taccountParamSVImplTest extends TestCase {

    private static final Logger log = LogManager.getLogger(taccountParamSVImplTest.class);


    //账单生成
    @Autowired
    private IAccountParamSV accountParamSV;



    @Test
    public void testQueryTaccountParam()throws Exception{
        AccParamReq  param = new AccParamReq();
        param.setTargetID("21");
        AccountParamQueryResponse accountParamQueryResponse = accountParamSV.queryAccountParam(param);
        System.out.print(1111);
    }

    @Test
    public void testupadteTaccountParam()throws Exception{
        AccountParamUpdateParam param = new AccountParamUpdateParam();
        param.setTargetID("00000025");
        param.setTargetName("liquid1111111");
        AccountParamUpdateResponse accountParamUpdateResponse = accountParamSV.updateAccountParam(param);
        System.out.print(1111);
    }


}

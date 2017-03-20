package com.ai.slp.balance.test.api.translatorbill.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.UUIDUtil;
import com.ai.slp.balance.api.accountmaintain.interfaces.IAccountMaintainSV;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.balance.api.accountquery.interfaces.IAccountQuerySV;
import com.ai.slp.balance.api.accountquery.param.AccountIdParam;
import com.ai.slp.balance.api.accountquery.param.AccountInfoVo;
import com.ai.slp.balance.api.accountquery.param.CustIdParam;
import com.ai.slp.balance.api.translatorbill.interfaces.IBillGenerateSV;
import com.ai.slp.balance.api.translatorbill.param.FunAccountDetailResponse;
import com.ai.slp.balance.service.business.interfaces.IBillGenerateBusiSV;
import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.SyslogAppender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class tranlatorBillSVImplTest extends TestCase {

    private static final Logger log = LogManager.getLogger(tranlatorBillSVImplTest.class);


    //账单生成
    @Autowired
    private IBillGenerateSV billGenerateSV;



    @Test
    public void testBillGenerate()throws Exception{
        try {

            boolean b = billGenerateSV.generateBill("2");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错：" + e.getMessage());
        }
    }


    @Test
    public void testqueryFunAccountDetail()throws Exception{
        List<FunAccountDetailResponse> funAccountDetailResponses = billGenerateSV.queryFunAccountDetail("21");

        System.out.print(funAccountDetailResponses.get(0));
    }


}

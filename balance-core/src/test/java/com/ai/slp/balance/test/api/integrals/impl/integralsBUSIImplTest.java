package com.ai.slp.balance.test.api.integrals.impl;

import com.ai.slp.balance.api.integrals.interfaces.IIntegralsSV;
import com.ai.slp.balance.api.integrals.param.*;
import com.ai.slp.balance.dao.mapper.bo.Integrals;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class integralsBUSIImplTest extends TestCase {

    private static final Logger log = LogManager.getLogger(integralsBUSIImplTest.class);


    //账单生成
    @Autowired
    private IIntegralsSV integralsSV;



    @Test
    public void testUpdateIntegrals()throws Exception{
        try {
            UpdateIntegralsParam updateParam = new UpdateIntegralsParam();
            updateParam.setUserId("525335");
            updateParam.setIntegrals(-10);
            updateParam.setIntegralsResource("注册");
            updateParam.setSystemResource("注册");
            integralsSV.updateIntegrals(updateParam);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错：" + e.getMessage());
        }
    }


    @Test
    public void testqueryIntegrals()throws Exception{

        IntegralsResponse updateIntegralsResponse = integralsSV.queryIntegrals("525628");

        System.out.print(updateIntegralsResponse);
    }
    @Test
    public void testdelIntegrals()throws Exception{

        DelIntegralsResponse delIntegralsResponse = integralsSV.delIntegrals("4444930");

        System.out.print(delIntegralsResponse);
    }

    @Test
    public void testincomeOutIntegrals()throws Exception{

        IncomeQueryIntegralsRequest incomeQueryIntegralsRequest = new IncomeQueryIntegralsRequest();
        incomeQueryIntegralsRequest.setUserId("525335");
//        incomeQueryIntegralsRequest.setFlag("2");
        IntegralsQueryResponse integralsQueryResponse = integralsSV.incomeOutIntegrals(incomeQueryIntegralsRequest);

        System.out.print(integralsQueryResponse);
    }

}

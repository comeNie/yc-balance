package com.ai.slp.balance.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.balance.service.business.interfaces.ISendCouponSV;

import junit.framework.TestCase;
//import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
//import net.sourceforge.groboutils.junit.v1.TestRunnable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class SendCouponTest extends TestCase {


    @Autowired
    private ISendCouponSV sendCouponSV;

   /* @Test
    public void testSendCouponTest() {
        sendCouponSV.registerSendCoupon("注册测", "1");
    }*/
    @Test
    public void testDepositForegift() {
        sendCouponSV.offLineSendCoupon(3, "注册", "1");
    }
    
}

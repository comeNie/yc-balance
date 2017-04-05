package com.ai.slp.balance.test.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;

import junit.framework.TestCase;
//import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
//import net.sourceforge.groboutils.junit.v1.TestRunnable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class SendCouponTest extends TestCase {


    @Autowired
    private ISendCouponSV sendCouponSV;
    @Autowired
    private ICouponUseRuleSV couponUseRuleSV;
   @Autowired
    private ICouponTemplateSV couponTemplateSV;
    

    @Test
    public void testSendCouponTest() {
    	
    	List<FunCouponUseRuleQueryResponse> queryFunCouponUseRule = couponUseRuleSV.queryFunCouponUseRule("1");
    	System.out.println(queryFunCouponUseRule);
    }
    
    /*@Test
    public void test() {
    	SendCouponRequest param = new SendCouponRequest();
    	param.setActivityName("注册测试");
    	param.setUserId("53355");
    	BaseResponse registerSendCoupon = sendCouponSV.registerSendCoupon(param);
    	System.out.println(registerSendCoupon);
    }*/
    //查询可用
    @Test
    public void test() {
    	DeductionCouponRequest param = new DeductionCouponRequest();
    	param.setUserId("4444914");
    	param.setCurrencyUnit("1");
    	//param.setOrderId(Long.parseLong("2000000024195005")); //Long.parseLong()
    	param.setOrderType("1");
    	param.setUsedScene("1");
    	param.setTotalFee(200000000);
    	BaseResponse registerSendCoupon = sendCouponSV.queryDisCountCoupon(param);
    	System.out.println(registerSendCoupon);
    }
    
}

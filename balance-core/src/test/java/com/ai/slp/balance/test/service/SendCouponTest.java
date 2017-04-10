package com.ai.slp.balance.test.service;


import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.FreezeCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouponRsponse;
import com.ai.slp.balance.api.sendcoupon.param.SendCouponRequest;

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
    public void queryCouponOveCount() {

    	QueryCouponRequest queryCouponRequest = new QueryCouponRequest();
    	queryCouponRequest.setUserId("525335");
		QueryCouponRsponse queryCouponPage = sendCouponSV.queryCouponPage(queryCouponRequest);
		System.out.println(queryCouponPage);
    }


    @Test
    public void test7() {
    	SendCouponRequest param = new SendCouponRequest();
    	param.setActivityName("注册测试");
    	param.setUserId("53355");
    	BaseResponse registerSendCoupon = sendCouponSV.registerSendCoupon(param);
    	System.out.println(registerSendCoupon);
    }
    //查询可用
    @Test
    public void test() {
    	DeductionCouponRequest param = new DeductionCouponRequest();
    	param.setUserId("525335");
    	param.setCurrencyUnit("1");
    	param.setOrderId(Long.parseLong("2000000024195005")); //Long.parseLong()
    	param.setOrderType("1");
    	param.setUsedScene("1");
    	param.setTotalFee(900000000l);
    	BaseListResponse<DeductionCouponResponse> queryDisCountCoupon = sendCouponSV.queryDisCountCoupon(param);
    	System.out.println(queryDisCountCoupon);
    }
    //冻结、解冻
    @Test
    public void test1() {
    	FreezeCouponRequest	param = new FreezeCouponRequest();
    	param.setCouponId("71");
    	param.setOrderId(Long.parseLong("2000000024195005"));
    	BaseResponse registerSendCoupon = sendCouponSV.updateStateFreeze(param);
    	System.out.println(registerSendCoupon);
    }
    
    //抵扣
    @Test
    public void test2() {
    	DeductionCouponRequest param = new DeductionCouponRequest();
    	param.setCouponId("a2");
    	param.setUserId("525335");
    	param.setCurrencyUnit("1");
    	param.setOrderId(Long.parseLong("2000000024195005")); //Long.parseLong()
    	param.setOrderType("1");
    	param.setUsedScene("1");
    	param.setTotalFee(900000000l);
    	BaseResponse registerSendCoupon = sendCouponSV.deducionCoupon(param);
    	System.out.println(registerSendCoupon);
    }
    @Test
    public void random2(){  
        String random = "";  
        /*随机数函数*/  
        java.util.Random r=new java.util.Random();  
        System.out.println(r);
        for(int i = 0;i<12;i++){  
            /*生成36以内的随机数，不含36，并转化为36位*/  
            random += Integer.toString(r.nextInt(36), 36);  
        }  
        System.out.println(random);
    }
    public static String random3(){  
        String random = "";  
        /*随机数函数*/  
        java.util.Random r=new java.util.Random();  
        for(int i = 0;i<12;i++){  
            /*生成36以内的随机数，不含36，并转化为36位*/  
            random += Integer.toString(r.nextInt(36), 36);  
        }  
        return random;  
    }
    @Test
    public void main(){  
        Set<String> set = new HashSet<String>();  
        int times = 10000000;  
        for(int i = 0 ;i<times;i++){  
            String random = random3();
            set.add(random);  
        }  
        System.out.println("重复了："+(times-set.size())+"次");  
    }  
    
    
}

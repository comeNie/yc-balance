package com.ai.slp.balance.test.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryResponse;
import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;
import com.ai.slp.balance.api.sendcoupon.param.QueryCouCountRequest;

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
    
    @Test
    public void test() {
    	FunCouponTemplateQueryRequest param = new FunCouponTemplateQueryRequest();
    	param.setCouponName("注册");
    	FunCouponTemplateQueryResponse queryFunCouponTemplate = couponTemplateSV.queryFunCouponTemplate(param);
    	System.out.println(queryFunCouponTemplate);
    }
    
    
    @Test
    public void testDepositForegift() {
    	QueryCouCountRequest param = new QueryCouCountRequest();
    	param.setStatus("3");
    	param.setUserId("1");
        BaseResponse deducionCoupon = sendCouponSV.queryCouponCount(param);
        System.out.println(deducionCoupon);
    }
    
    
    /*public static void main(String[] args) throws ParseException {
    	Calendar c = Calendar.getInstance();
	     c.add(Calendar.SATURDAY, 2);
	     c.add(Calendar.SATURDAY, 2);
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sDate=sdf.format(c.getTime());
			System.out.println(Timestamp.valueOf(sDate));
     }*/
}

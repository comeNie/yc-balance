package com.ai.slp.balance.test.service;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
import com.ai.slp.balance.api.couponuserule.param.SaveCouponUseRule;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;

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
 /*   @Autowired
    private ICouponTemplateSV couponTemplateSV;*/
    

    @Test
    public void testSendCouponTest() {
    	sendCouponSV.queryCouponByUserId("1");
    }
    
    @Test
    public void test() {
    	SaveCouponUseRule param = new SaveCouponUseRule();
    	param.setCouponUserId("10");
    	param.setCurrencyUnit("2");
    	param.setFaceValue(5);
    	param.setRequiredMoneyAmount(20);
    	Date date1=new Date();
        DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	param.setCreateTime(Timestamp.valueOf(format1.format(date1)));
    	Integer saveCouponUseRule = couponUseRuleSV.saveCouponUseRule(param);
    	System.out.println(saveCouponUseRule);
    }
    
    
    /*@Test
    public void testDepositForegift() {
        sendCouponSV.offLineSendCoupon(3, "注册", "1");
    }*/
    
    
    /*public static void main(String[] args) throws ParseException {
    	Calendar c = Calendar.getInstance();
	     c.add(Calendar.SATURDAY, 2);
	     c.add(Calendar.SATURDAY, 2);
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sDate=sdf.format(c.getTime());
			System.out.println(Timestamp.valueOf(sDate));
     }*/
}

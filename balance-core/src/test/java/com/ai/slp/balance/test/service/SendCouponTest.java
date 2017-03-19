package com.ai.slp.balance.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
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
    

    @Test
    public void testSendCouponTest() {
        sendCouponSV.registerSendCoupon("注册测", "1");
    }
    
    @Test
    public void test() {
    	couponUseRuleSV.queryFunCouponUseRule("1");
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

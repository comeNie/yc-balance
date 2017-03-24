package com.ai.slp.balance.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.coupontemplate.param.SaveFunCouponTemplate;
import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;

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
    	DeductionCouponRequest param = new DeductionCouponRequest();
    	param.setCurrencyUnit("1");
    	param.setOrderId(Long.parseLong("2000000024195005"));
    	param.setTotalFee(200);
    	param.setUsedScene("1");
    	param.setUserId("1");
    	BaseListResponse<DeductionCouponResponse> queryDisCountCoupon = sendCouponSV.queryDisCountCoupon(param);
    	System.out.println(queryDisCountCoupon);
    }
    
    @Test
    public void test() {
    	SaveFunCouponTemplate req = new SaveFunCouponTemplate();
    	req.setCouponDesc("Q币");
    	req.setCouponName("腾讯");
    	req.setCouponUserId("2");
    	req.setCurrencyUnit("1");
    	req.setEffectiveTime(4);
    	req.setFaceValue(10);
    	req.setMaxCountIssue("5");
    	req.setStatus("1");
    	req.setUsedScene("2");
    	req.setUseLimits("1");
    	Integer saveCouponUseRule = couponTemplateSV.savaCouponTemplate(req);
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

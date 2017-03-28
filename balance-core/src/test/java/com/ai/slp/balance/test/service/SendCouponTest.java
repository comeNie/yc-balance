package com.ai.slp.balance.test.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryResponse;
import com.ai.slp.balance.api.coupontemplate.param.SaveFunCouponTemplate;
import com.ai.slp.balance.api.couponuserule.interfaces.ICouponUseRuleSV;
import com.ai.slp.balance.api.couponuserule.param.FunCouponUseRuleQueryResponse;
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
    	SaveFunCouponTemplate req = new SaveFunCouponTemplate();
    	req.setCouponDesc("迅雷活动");
    	req.setCouponName("移动公");
    	req.setCouponUserId("0");
    	req.setCurrencyUnit("2");
    	req.setFaceValue(100);
    	req.setFaceValueDown(80);
    	req.setStatus("1");
    	req.setMaxCountIssue("20");
    	req.setUsedScene("2");
    	req.setUseLimits("1");
    	req.setEffectiveEndTime("2017-3-31 13:34:00");
    	req.setEffectiveStartTime("2017-3-29 13:34:00");
    	req.setReceiveEndTime("2017-3-31 13:34:00");
    	req.setReceiveStartTime("2017-3-29 13:34:00");
        couponTemplateSV.savaCouponTemplate(req);
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

package com.ai.slp.balance.test.api.couponTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailPageResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.SaveFunCouponTemplate;
import com.ai.yc.op.web.model.sso.client.GeneralSSOClientUser;
import com.ai.yc.op.web.utils.LoginUtil;

/**
 * Created by shancc on 2017/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CouponTemplateTest {
	@Autowired
	private ICouponTemplateSV couponTemplateSV;

	@Test
	public void queryCouponOveCount() {
		FunCouponDetailQueryRequest funCouponDetailQueryRequest = new FunCouponDetailQueryRequest();
		funCouponDetailQueryRequest.setTemplateId(1);
		FunCouponDetailPageResponse queryCouponDetail = couponTemplateSV.queryCouponDetail(funCouponDetailQueryRequest);
		System.out.println(queryCouponDetail);
	}
	
	@Test
	public void savaCouponTemplate() {
		SaveFunCouponTemplate saveFunCouponTemplate = new SaveFunCouponTemplate();
		saveFunCouponTemplate.setCouponDesc("大减价");
		saveFunCouponTemplate.setCouponName("大减价");
		saveFunCouponTemplate.setCouponUserId("2");
		saveFunCouponTemplate.setCurrencyUnit("1");
		/*saveFunCouponTemplate.setEffectiveEndTime(effectiveEndTime);
		saveFunCouponTemplate.setEffectiveStartTime(effectiveStartTime);*/
		saveFunCouponTemplate.setEffectiveTime(5);
		saveFunCouponTemplate.setFaceValue(10);
		saveFunCouponTemplate.setMaxCountIssue("100");
		/*saveFunCouponTemplate.setReceiveEndTime(receiveEndTime);
		saveFunCouponTemplate.setReceiveStartTime(receiveStartTime);*/
		/*saveFunCouponTemplate.setRequiredMoneyAmount(requiredMoneyAmount);*/
		saveFunCouponTemplate.setStatus("1");
		/*saveFunCouponTemplate.setTemplateId(templateId);*/
		saveFunCouponTemplate.setUsedScene("1");
		saveFunCouponTemplate.setUseLimits("1");
		BaseResponse savaCouponTemplate = couponTemplateSV.savaCouponTemplate(saveFunCouponTemplate);
		System.out.println(savaCouponTemplate);
	}
	
	
	
	
}

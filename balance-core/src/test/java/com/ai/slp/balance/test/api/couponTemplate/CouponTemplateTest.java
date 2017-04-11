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
		saveFunCouponTemplate.setCouponDesc("五一");
		saveFunCouponTemplate.setCouponName("迎五一");
		saveFunCouponTemplate.setCouponUserId("1");
		saveFunCouponTemplate.setCurrencyUnit("1");
		saveFunCouponTemplate.setEffectiveEndTime("2017-04-11 14:36:19");
		saveFunCouponTemplate.setEffectiveStartTime("2017-04-28 14:36:19");
		saveFunCouponTemplate.setFaceValue(12);
		saveFunCouponTemplate.setMaxCountIssue("10");
		saveFunCouponTemplate.setReceiveEndTime("2017-04-11 14:36:19");
		saveFunCouponTemplate.setReceiveStartTime("2017-04-28 14:36:19");
		saveFunCouponTemplate.setRequiredMoneyAmount(30);
		saveFunCouponTemplate.setStatus("1");
		saveFunCouponTemplate.setUsedScene("1");
		saveFunCouponTemplate.setUseLimits("4");
		BaseResponse savaCouponTemplate = couponTemplateSV.savaCouponTemplate(saveFunCouponTemplate);
		System.out.println(savaCouponTemplate);
	}
	
	
	
	
}

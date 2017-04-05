package com.ai.slp.balance.test.api.sendcoupon.impl;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.SendCouponRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liutong on 2017/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ISendCouponSVTest {
    @Autowired
    ISendCouponSV sendCouponSV;

    @Test
    public void registerSendCouponTest(){
        SendCouponRequest request = new SendCouponRequest();
        request.setActivityName("注册测试");
        request.setUserId("4444914");
        BaseResponse response = sendCouponSV.registerSendCoupon(request);
        System.out.println(response.getResponseHeader().getResultCode());
    }

    @Test
    public void queryDisCountCouponTest(){
        DeductionCouponRequest couponRequest = new DeductionCouponRequest();
        couponRequest.setCurrencyUnit("1");//币种:人民币
        couponRequest.setUserId("4444914");//用户
        couponRequest.setTotalFee(8740l);//金额
        couponRequest.setOrderType("1");
        //传递适用站点
        couponRequest.setUsedScene("1");
        BaseListResponse<DeductionCouponResponse> resList = sendCouponSV.queryDisCountCoupon(couponRequest);
        System.out.println(resList.getResult().size());
    }
}

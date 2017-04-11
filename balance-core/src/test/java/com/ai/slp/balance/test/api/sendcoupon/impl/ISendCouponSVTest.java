package com.ai.slp.balance.test.api.sendcoupon.impl;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.slp.balance.api.sendcoupon.interfaces.ISendCouponSV;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponRequest;
import com.ai.slp.balance.api.sendcoupon.param.DeductionCouponResponse;
import com.ai.slp.balance.api.sendcoupon.param.SendCouponRequest;
import com.alibaba.fastjson.JSON;
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
        couponRequest.setUserId("525335");//用户
        couponRequest.setTotalFee(208740l);//金额
        couponRequest.setOrderType("1");
        //传递适用站点
        couponRequest.setUsedScene("1");
        BaseListResponse<DeductionCouponResponse> resList = sendCouponSV.queryDisCountCoupon(couponRequest);
        System.out.println(resList.getResult().size());
    }

    @Test
    public void deducionCouponTest(){
        DeductionCouponRequest request = new DeductionCouponRequest();
        request.setUserId("4444914");
        request.setOrderId(2000000059033233l);
        request.setTotalFee(221560l);
        request.setCouponId("61");
        request.setCurrencyUnit("1");
        request.setUsedScene("1");
        BaseResponse response = sendCouponSV.deducionCoupon(request);
        //若操作不成功，则抛出异常
        if(response==null || !response.getResponseHeader().isSuccess()){
            System.out.println(JSON.toJSONString(response));
        }
    }


}

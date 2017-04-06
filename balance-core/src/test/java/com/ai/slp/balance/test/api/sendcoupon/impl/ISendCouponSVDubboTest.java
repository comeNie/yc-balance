package com.ai.slp.balance.test.api.sendcoupon.impl;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
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
public class ISendCouponSVDubboTest {

    @Test
    public void queryDisCountCouponDTest(){
        ISendCouponSV sendCouponSV = DubboConsumerFactory.getService(ISendCouponSV.class);
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
}

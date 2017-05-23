package com.ai.slp.balance.test.api.rewe.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.balance.api.rechargewithdrawals.interfaces.IRechargeWithdrawalsSV;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageQueryResponse;

/**
 * Created by shancc on 2017/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class IRechargeWithdrawalsSVTest {

	@Autowired
	IRechargeWithdrawalsSV rechargeWithdrawalsSV;
	
	@Test
    public void rechargewithdrawalsPage(){
		ReWiehPagePageQueryRequest reWiehPagePageQueryRequest = new ReWiehPagePageQueryRequest();
		ReWiehPageQueryResponse rechargewithdrawalsPage = rechargeWithdrawalsSV.rechargewithdrawalsPage(reWiehPagePageQueryRequest);
        System.out.println(rechargewithdrawalsPage);
    }
	
}

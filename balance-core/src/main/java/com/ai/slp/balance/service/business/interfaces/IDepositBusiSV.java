package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.deposit.param.DepositParam;
import com.ai.slp.balance.api.deposit.param.ForegiftDeposit;
import com.ai.slp.balance.vo.DepositVo;

/**
 * 存款服务
 * Date: 2015年7月30日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IDepositBusiSV {
    /**
     * 存款接口
     * @param balanceDepositVo
     * @return
     * @throws Exception
     * @author lilg
     * @ApiDocMethod
     */
    public String depositFundCheck(DepositVo depositVo) throws BusinessException;

    /**
     *
     * @param depositVo
     * @return
     * @throws BusinessException
     */
    public String depositFund(DepositVo depositVo)  throws BusinessException;
    
    /**
     * 押金存入
     * @param param
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public String depositForegift(ForegiftDeposit param) throws BusinessException;
}

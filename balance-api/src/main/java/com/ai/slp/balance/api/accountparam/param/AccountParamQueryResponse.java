package com.ai.slp.balance.api.accountparam.param;

import com.ai.opt.base.vo.BaseResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * 帐户查询返回参数
 */
public class AccountParamQueryResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
    private List<AccountParamVo> accountParamVos;

    public List<AccountParamVo> getAccountParamVos() {
        return accountParamVos;
    }

    public void setAccountParamVos(List<AccountParamVo> accountParamVos) {
        this.accountParamVos = accountParamVos;
    }
}
package com.ai.slp.balance.api.activityrule.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;

import java.util.List;

/**
 * 活动规则查询.<br>
 */
public class FunActivityQueryRuleResponse extends BaseResponse {


    private static final long serialVersionUID = 1L;

    /**
     *
     */
    List<FunActivityRuleResponse> funActivityRuleResponseList;

    public List<FunActivityRuleResponse> getFunActivityRuleResponseList() {
        return funActivityRuleResponseList;
    }

    public void setFunActivityRuleResponseList(List<FunActivityRuleResponse> funActivityRuleResponseList) {
        this.funActivityRuleResponseList = funActivityRuleResponseList;
    }
}

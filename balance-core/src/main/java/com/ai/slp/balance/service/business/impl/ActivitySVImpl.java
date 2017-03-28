package com.ai.slp.balance.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.service.atom.interfaces.IActivityAtomSV;
import com.ai.slp.balance.service.business.interfaces.IActivityBusiSV;
@Service
@Transactional
public class ActivitySVImpl implements IActivityBusiSV {
	
	@Autowired
	private IActivityAtomSV activityAtomSV;
	
	
	/**
	 * 模糊查询活动策略
	 */
	@Override
	public PageInfo<FunActivityResponse> queryActivity(FunActivityQueryRequest funActivityQueryRequest) {
		PageInfo<FunActivityResponse> funActivityResponsePageInfo = activityAtomSV.funActivityQueryRequest(funActivityQueryRequest);
		return funActivityResponsePageInfo;
	}

	/**
	 * 
	 * 删除活动策略
	 */
	@Override
	public Integer deleteActivity(Integer activityId) {
		return activityAtomSV.deleteActivity(activityId);
	}
}

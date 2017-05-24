package com.ai.slp.balance.service.atom.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.activity.param.FunActivityQueryRequest;
import com.ai.slp.balance.api.activity.param.FunActivityResponse;
import com.ai.slp.balance.dao.mapper.bo.FunActivity;
import com.ai.slp.balance.dao.mapper.bo.FunActivityCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunActivityMapper;
import com.ai.slp.balance.dao.mapper.interfaces.FunCouponTemplateMapper;
import com.ai.slp.balance.service.atom.interfaces.IActivityAtomSV;

@Component
public class ActivityAtomSVImpl implements IActivityAtomSV {

	/**
	 *模糊查询活动策略列表
	 */
	@Override
	public PageInfo<FunActivityResponse> funActivityQueryRequest(FunActivityQueryRequest funActivityQueryRequest) {
		 List<FunActivityResponse> funActivityResponses =  new ArrayList<FunActivityResponse>();
		 FunActivityCriteria funActivityCriteria = new FunActivityCriteria();
		 FunActivityCriteria.Criteria criteria= funActivityCriteria.createCriteria();
		 String orderByClause = "template_id desc";
		 funActivityCriteria.setOrderByClause(orderByClause);
		 	if (!StringUtil.isBlank(funActivityQueryRequest.getActivityName())){
	            criteria.andActivityNameLike("%"+funActivityQueryRequest.getActivityName().trim()+"%");
	        }
	        if (!StringUtil.isBlank(funActivityQueryRequest.getStartTime())){
	            criteria.andStartTimeEqualTo(Timestamp.valueOf(funActivityQueryRequest.getStartTime()));
	        }
	        if (!StringUtil.isBlank(funActivityQueryRequest.getEndTime())){
	            criteria.andStartTimeEqualTo(Timestamp.valueOf(funActivityQueryRequest.getEndTime()));
	        }
	        if (!StringUtil.isBlank(funActivityQueryRequest.getUsedScene())){
	            criteria.andUsedSceneEqualTo(funActivityQueryRequest.getUsedScene());
	        }
	        PageInfo<FunActivityResponse> pageInfo = new PageInfo<FunActivityResponse>();
	        FunActivityMapper mapper = MapperFactory.getFunActivityMapper();
	        pageInfo.setCount(mapper.countByExample(funActivityCriteria));
	        
	        if (funActivityQueryRequest.getPageInfo() == null) {
	            pageInfo.setPageNo(1);
	            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
	        }else {
	            pageInfo.setPageNo(funActivityQueryRequest.getPageInfo().getPageNo());
	            pageInfo.setPageSize(funActivityQueryRequest.getPageInfo().getPageSize() == null ? 20
	                    : funActivityQueryRequest.getPageInfo().getPageSize());
	            funActivityCriteria.setLimitStart(funActivityQueryRequest.getPageInfo()
	                    .getStartRowIndex());
	            funActivityCriteria.setLimitEnd(funActivityQueryRequest.getPageInfo().getPageSize());
	        }
	        List<FunActivity> funActivitys = mapper.selectByExample(funActivityCriteria);

	        if (!CollectionUtil.isEmpty(funActivitys)){

	            for (int i=0;i<funActivitys.size();i++){
	            	FunActivityResponse funActivityResponse = new FunActivityResponse();
	                BeanUtils.copyProperties(funActivityResponse,funActivitys.get(i));
	                funActivityResponses.add(funActivityResponse);
	            }
	        }
	        pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
	        pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
	        pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
	        pageInfo.setResult(funActivityResponses);
	        return pageInfo;
	}
	/**
	 * 删除优惠券模板
	 */
	@Override
	public Integer deleteActivity(Integer activityId) {
		FunActivityMapper mapper = MapperFactory.getFunActivityMapper();
		int deleteByPrimaryKey = mapper.deleteByPrimaryKey(activityId);
		return deleteByPrimaryKey;
	}

	@Override
	public void updateFunActivity(FunActivity funActivity) {
		FunActivityMapper mapper = MapperFactory.getFunActivityMapper();
		FunActivity funActivity1 = mapper.selectByPrimaryKey(funActivity.getActivityId());
		funActivity1.setActivityId(funActivity.getActivityId());
		funActivity1.setUsedScene(funActivity.getUsedScene());
		funActivity1.setActivityDesc(funActivity.getActivityDesc());
		funActivity1.setStartTime(funActivity.getStartTime());
		funActivity1.setEndTime(funActivity.getEndTime());
		funActivity1.setStatus(funActivity.getStatus());
		funActivity1.setActivityTime(funActivity.getActivityTime());
		mapper.updateByPrimaryKeySelective(funActivity1);
	}
}

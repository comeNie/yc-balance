package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.integrals.param.IncomeQueryIntegralsRequest;
import com.ai.slp.balance.api.integrals.param.IntegralsDetail;
import com.ai.slp.balance.dao.mapper.bo.Integrals;
import com.ai.slp.balance.dao.mapper.bo.IntegralsCriteria;
import com.ai.slp.balance.dao.mapper.bo.IntegralsLog;
import com.ai.slp.balance.dao.mapper.bo.IntegralsLogCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IIntegralsAtomLogSV;
import com.ai.slp.balance.service.atom.interfaces.IIntegralsAtomSV;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IntegralsAtomLogSVImpl implements IIntegralsAtomLogSV {

	@Override
	public void createIntegralsLog(IntegralsLog integralsLog) {
		MapperFactory.getIntegralsLogMapper().insert(integralsLog);
	}

	@Override
	public void delIntegralsLog(String userID) {
		IntegralsLogCriteria example = new IntegralsLogCriteria();
		example.createCriteria().andUserIdEqualTo(userID);
		MapperFactory.getIntegralsLogMapper().deleteByExample(example);
	}

	@Override
	public PageInfo<IntegralsDetail> queryIntegralsLog(IncomeQueryIntegralsRequest param) {
		List<IntegralsDetail> integralsDetails = null;
		PageInfo<IntegralsDetail> pageInfo = new PageInfo<IntegralsDetail>();
		IntegralsLogCriteria example = new IntegralsLogCriteria();
		IntegralsLogCriteria.Criteria criteria = example.createCriteria();
		example.setOrderByClause("log_time desc");
		criteria.andUserIdEqualTo(param.getUserId());
		//积分收支标记 0:收入  1:支出
		if ("0".equals(param.getFlag())){
			criteria.andIntegralValueGreaterThanOrEqualTo(0);
		}
		if ("1".equals(param.getFlag())){
			criteria.andIntegralValueLessThanOrEqualTo(0);
		}
		pageInfo.setCount(MapperFactory.getIntegralsLogMapper().countByExample(example));
		if (param.getPageInfo() == null) {
			pageInfo.setPageNo(1);
			pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
		} else {
			pageInfo.setPageNo(param.getPageInfo().getPageNo());
			pageInfo.setPageSize(param.getPageInfo().getPageSize() == null ? 10
					: param.getPageInfo().getPageSize());
			example.setLimitStart(param.getPageInfo()
					.getStartRowIndex());
			example.setLimitEnd(param.getPageInfo().getPageSize());
		}
		List<IntegralsLog> integralsLogs = MapperFactory.getIntegralsLogMapper().selectByExample(example);
		if (!CollectionUtil.isEmpty(integralsLogs)){
			integralsDetails = new ArrayList<IntegralsDetail>();
			for (int i=0;i<integralsLogs.size();i++){
				IntegralsDetail integralsDetail = new IntegralsDetail();
				BeanUtils.copyProperties(integralsDetail,integralsLogs.get(i));
				integralsDetails.add(integralsDetail);
			}
		}else {
			return null;
		}
		if(!CollectionUtil.isEmpty(integralsLogs)){
			pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
			pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
			pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
			pageInfo.setResult(integralsDetails);
		}else {
			return null;
		}
		return pageInfo;
	}


}

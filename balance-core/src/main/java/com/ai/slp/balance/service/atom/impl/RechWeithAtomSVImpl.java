package com.ai.slp.balance.service.atom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPagePageQueryRequest;
import com.ai.slp.balance.api.rechargewithdrawals.param.ReWiehPageVo;
import com.ai.slp.balance.dao.mapper.bo.FunRechargeWithdrawals;
import com.ai.slp.balance.dao.mapper.bo.FunRechargeWithdrawalsCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunRechargeWithdrawalsMapper;
import com.ai.slp.balance.service.atom.interfaces.IQueryRechWeithAtomSV;

@Component
public class RechWeithAtomSVImpl implements IQueryRechWeithAtomSV {

	@Override
	public PageInfo<ReWiehPageVo> queryRechWeithPage(ReWiehPagePageQueryRequest param) {
		List<ReWiehPageVo> reWiehPageVos = new ArrayList<ReWiehPageVo>();
		FunRechargeWithdrawalsCriteria sysRechWeithCriteria = new FunRechargeWithdrawalsCriteria();
		FunRechargeWithdrawalsCriteria.Criteria criteria = sysRechWeithCriteria.createCriteria();
		String orderByClause = "wid desc";
		sysRechWeithCriteria.setOrderByClause(orderByClause);
		if (!StringUtil.isBlank(param.getUsername())) {
			criteria.andUsernameLike("%" + param.getUsername().trim() + "%");
		}
		if (!StringUtil.isBlank(param.getFullname())) {
			criteria.andFullnameLike("%" + param.getFullname().trim() + "%");
		}
		if (!StringUtil.isBlank(param.getPattem())) {
			criteria.andPattemEqualTo(param.getPattem());
		}
		if (!StringUtil.isBlank(param.getState())) {
			criteria.andStateEqualTo(param.getState());
		}
		if (!StringUtil.isBlank(param.getType())) {
			criteria.andTypeEqualTo(param.getType());
		}
		if (!StringUtil.isBlank(param.getCurrency())) {
			criteria.andCurrencyEqualTo(param.getCurrency());
		}
		if (!StringUtil.isBlank(param.getApplyPeople())) {
			criteria.andApplyPeopleLike("%" + param.getApplyPeople().trim() + "%");
		}
		if (!StringUtil.isBlank(param.getBruisesPeople())) {
			criteria.andBruisesPeopleLike("%" + param.getBruisesPeople().trim() + "%");
		}
		PageInfo<ReWiehPageVo> pageInfo = new PageInfo<ReWiehPageVo>();
		FunRechargeWithdrawalsMapper mapper = MapperFactory.getFunRechargeWithdrawalsMapper();
		pageInfo.setCount(mapper.countByExample(sysRechWeithCriteria));

		if (param.getPageInfo() == null) {
			pageInfo.setPageNo(1);
			pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
		} else {
			pageInfo.setPageNo(param.getPageInfo().getPageNo());
			pageInfo.setPageSize(param.getPageInfo().getPageSize() == null ? 20
					: param.getPageInfo().getPageSize());
			sysRechWeithCriteria.setLimitStart(param.getPageInfo().getStartRowIndex());
			sysRechWeithCriteria.setLimitEnd(param.getPageInfo().getPageSize());
		}
		List<FunRechargeWithdrawals> rechWeithListPage = mapper.selectByExample(sysRechWeithCriteria);

		if (!CollectionUtil.isEmpty(rechWeithListPage)) {

			for (int i = 0; i < rechWeithListPage.size(); i++) {
				ReWiehPageVo reWiehPageVo = new ReWiehPageVo();
				BeanUtils.copyProperties(reWiehPageVo, rechWeithListPage.get(i));
				reWiehPageVos.add(reWiehPageVo);
			}
		}
		pageInfo.setPageNo(pageInfo.getPageNo() == null ? 1 : pageInfo.getPageNo());
		pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
		pageInfo.setPageCount((pageInfo.getCount() + pageInfo.getPageSize() - 1) / pageInfo.getPageSize());
		pageInfo.setResult(reWiehPageVos);
		return pageInfo;
	}

	
}

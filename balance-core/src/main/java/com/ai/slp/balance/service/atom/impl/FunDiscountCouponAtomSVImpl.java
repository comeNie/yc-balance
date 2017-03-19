package com.ai.slp.balance.service.atom.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailResponse;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCoupon;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCouponCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunDiscountCouponMapper;
import com.ai.slp.balance.service.atom.interfaces.IDiscountCouponAtomSV;

@Component
public class FunDiscountCouponAtomSVImpl implements IDiscountCouponAtomSV {


	@Override
	public PageInfo<FunCouponDetailResponse> queryFunCouponDetail(FunCouponDetailQueryRequest param) {
		 List<FunCouponDetailResponse> funCouponDetailResponses = new ArrayList<FunCouponDetailResponse>();
		 
		 	FunDiscountCouponCriteria funDiscountCouponCriteria = new FunDiscountCouponCriteria();
		 	FunDiscountCouponCriteria.Criteria critreia = funDiscountCouponCriteria.createCriteria();
	        String orderByClause = "ORDER_TIME desc";
	        funDiscountCouponCriteria.setOrderByClause(orderByClause);
	        critreia.andTemplateIdEqualTo(param.getTemplateId());
	        PageInfo<FunCouponDetailResponse> pageInfo = new PageInfo<FunCouponDetailResponse>();
	        FunDiscountCouponMapper mapper = MapperFactory.getFunDiscountCouponMapper();
	        pageInfo.setCount(mapper.countByExample(funDiscountCouponCriteria));
	        
	        List<FunDiscountCoupon> funDiscountCoupon = mapper.selectByExample(funDiscountCouponCriteria);
	        if (param.getPageInfo() == null) {
	            pageInfo.setPageNo(1);
	            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
	        }else {
	            pageInfo.setPageNo(param.getPageInfo().getPageNo());
	            pageInfo.setPageSize(param.getPageInfo().getPageSize() == null ? 10
	                    : param.getPageInfo().getPageSize());
	            funDiscountCouponCriteria.setLimitStart(param.getPageInfo()
	                    .getStartRowIndex());
	            funDiscountCouponCriteria.setLimitEnd(param.getPageInfo().getPageSize());
	        }
	        if (!CollectionUtil.isEmpty(funDiscountCoupon)){
	        	funCouponDetailResponses = new ArrayList<FunCouponDetailResponse>();
	            for (int i=0;i<funDiscountCoupon.size();i++){
	            	FunCouponDetailResponse funCouponDetailResponse = new FunCouponDetailResponse();
	                BeanUtils.copyProperties(funCouponDetailResponse,funDiscountCoupon.get(i));
	                funCouponDetailResponses.add(funCouponDetailResponse);
	            }
	        }
	        pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
	        pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
	        pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
	        pageInfo.setResult(funCouponDetailResponses);
	        return pageInfo;
	}
}

package com.ai.slp.balance.service.atom.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.api.coupontemplate.param.SaveFunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplateCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunCouponTemplateMapper;
import com.ai.slp.balance.service.atom.interfaces.ICouponTemplateAtomSV;

@Component
public class CouponTemplateAtomSVImpl implements ICouponTemplateAtomSV {

	/**
	 * 优惠券模板表添加数据
	 */
	@Override
	public void insertBuildCouponTemplet(FunCouponTemplate couponTemplate) {
		MapperFactory.getFunCouponTemplateMapper().insert(couponTemplate);
	}
	/**
	 *模糊查询优惠券模板列表
	 */
	@Override
	public PageInfo<FunCouponTemplateResponse> funCouponTemplateQueryRequest(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest) {
		 List<FunCouponTemplateResponse> funCouponTemplateResponses =  new ArrayList<FunCouponTemplateResponse>();
		 FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
		 FunCouponTemplateCriteria.Criteria criteria= funCouponTemplateCriteria.createCriteria();
		 String orderByClause = "CREATE_TIME desc";
		 funCouponTemplateCriteria.setOrderByClause(orderByClause);
		 	if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getCouponName())){
	            criteria.andCouponNameLike("%"+funCouponTemplateQueryRequest.getCouponName().trim()+"%");
	        }
	        if (funCouponTemplateQueryRequest.getFaceValue()!=null){
	            criteria.andFaceValueEqualTo(funCouponTemplateQueryRequest.getFaceValue());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getUsedScene())){
	            criteria.andUsedSceneEqualTo(funCouponTemplateQueryRequest.getUsedScene());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getStatus())){
	            criteria.andStatusEqualTo(funCouponTemplateQueryRequest.getStatus());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getCurrencyUnit())){
	            criteria.andCurrencyUnitEqualTo(funCouponTemplateQueryRequest.getCurrencyUnit());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getCreateOperator())){
	            criteria.andCreateOperatorLike("%"+funCouponTemplateQueryRequest.getCreateOperator().trim()+"%");
	        }
	        
	        PageInfo<FunCouponTemplateResponse> pageInfo = new PageInfo<FunCouponTemplateResponse>();
	        FunCouponTemplateMapper mapper = MapperFactory.getFunCouponTemplateMapper();
	        pageInfo.setCount(mapper.countByExample(funCouponTemplateCriteria));
	        
	        if (funCouponTemplateQueryRequest.getPageInfo() == null) {
	            pageInfo.setPageNo(1);
	            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
	        }else {
	            pageInfo.setPageNo(funCouponTemplateQueryRequest.getPageInfo().getPageNo());
	            pageInfo.setPageSize(funCouponTemplateQueryRequest.getPageInfo().getPageSize() == null ? 20
	                    : funCouponTemplateQueryRequest.getPageInfo().getPageSize());
	            funCouponTemplateCriteria.setLimitStart(funCouponTemplateQueryRequest.getPageInfo()
	                    .getStartRowIndex());
	            funCouponTemplateCriteria.setLimitEnd(funCouponTemplateQueryRequest.getPageInfo().getPageSize());
	        }
	        List<FunCouponTemplate> funCouponTemplates = mapper.selectByExample(funCouponTemplateCriteria);

	        if (!CollectionUtil.isEmpty(funCouponTemplates)){

	            for (int i=0;i<funCouponTemplates.size();i++){
	            	FunCouponTemplateResponse funCouponTemplateResponse = new FunCouponTemplateResponse();
	                BeanUtils.copyProperties(funCouponTemplateResponse,funCouponTemplates.get(i));
	                funCouponTemplateResponses.add(funCouponTemplateResponse);
	            }
	        }
	        pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
	        pageInfo.setPageSize(pageInfo.getPageSize() == null ? 20 : pageInfo.getPageSize());
	        pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
	        pageInfo.setResult(funCouponTemplateResponses);
	        return pageInfo;
	}
	/**
	 * POI导出优惠券模板列表生成Excel
	 */
	@Override
	public List<FunCouponTemplateResponse> exportCouponTempletList(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest) {
		List<FunCouponTemplateResponse> funCouponTemplateResponses =  new ArrayList<FunCouponTemplateResponse>();
		FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
		FunCouponTemplateCriteria.Criteria criteria= funCouponTemplateCriteria.createCriteria();
		String orderByClause = "CREATE_TIME desc";
		funCouponTemplateCriteria.setOrderByClause(orderByClause);
		 	if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getCouponName())){
	            criteria.andCouponNameLike("%"+funCouponTemplateQueryRequest.getCouponName().trim()+"%");
	        }
	        if (funCouponTemplateQueryRequest.getFaceValue()!=null){
	            criteria.andFaceValueEqualTo(funCouponTemplateQueryRequest.getFaceValue());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getUsedScene())){
	            criteria.andUsedSceneEqualTo(funCouponTemplateQueryRequest.getUsedScene());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getStatus())){
	            criteria.andStatusEqualTo(funCouponTemplateQueryRequest.getStatus());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getCurrencyUnit())){
	            criteria.andCurrencyUnitEqualTo(funCouponTemplateQueryRequest.getCurrencyUnit());
	        }
	        if (!StringUtil.isBlank(funCouponTemplateQueryRequest.getCreateOperator())){
	            criteria.andCreateOperatorLike("%"+funCouponTemplateQueryRequest.getCreateOperator().trim()+"%");
	        }
	        FunCouponTemplateMapper mapper = MapperFactory.getFunCouponTemplateMapper();
	        List<FunCouponTemplate> funCouponTemplates = mapper.selectByExample(funCouponTemplateCriteria);
	        if (!CollectionUtil.isEmpty(funCouponTemplates)){

	            for (int i=0;i<funCouponTemplates.size();i++){
	            	FunCouponTemplateResponse funCouponTemplateResponse = new FunCouponTemplateResponse();
	                BeanUtils.copyProperties(funCouponTemplateResponse,funCouponTemplates.get(i));
	                funCouponTemplateResponses.add(funCouponTemplateResponse);
	            }
	        }
		return funCouponTemplateResponses;
	}
	/**
	 * 检测名称唯一
	 */
	@Override
	public Integer checkCouponTemplateName(String couponName) {
		FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
		FunCouponTemplateCriteria.Criteria criteria= funCouponTemplateCriteria.createCriteria();
		if (!StringUtil.isBlank(couponName)){
            criteria.andCouponNameEqualTo(couponName);
        }
		FunCouponTemplateMapper mapper = MapperFactory.getFunCouponTemplateMapper();
		int countByExample = mapper.countByExample(funCouponTemplateCriteria);
		return countByExample;
	}
	@Override
	public Integer saveCouponTempletList(FunCouponTemplate req) {
		FunCouponTemplateMapper mapper = MapperFactory.getFunCouponTemplateMapper();
		int insert = mapper.insert(req);
		return insert;
	}
	@Override
	public Integer deleteCouponTemplate(Integer templateId) {
		FunCouponTemplateMapper mapper = MapperFactory.getFunCouponTemplateMapper();
		int deleteByPrimaryKey = mapper.deleteByPrimaryKey(templateId);
		return deleteByPrimaryKey;
	}
}

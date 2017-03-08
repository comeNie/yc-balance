package com.ai.slp.balance.service.business.impl;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunDiscountCouponInfoVo;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplateCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;
import com.ai.slp.balance.dao.mapper.bo.FunDiscountCoupon;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunCouponTemplateMapper;
import com.ai.slp.balance.service.atom.interfaces.ICouponTemplateAtomSV;
import com.ai.slp.balance.service.atom.interfaces.ICouponUseRuleAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IDiscountCouponAtomSV;
import com.ai.slp.balance.service.business.interfaces.ICouponTemplateBusiSV;
@Service
@Transactional
public class CouponTemplateBusiSVImpl implements ICouponTemplateBusiSV {
	
	@Autowired
	private ICouponTemplateAtomSV couponTemplateAtomSV;
	
	@Autowired
	private ICouponUseRuleAtomSV couponUseRuleAtomSV;
	
	@Autowired
	private IDiscountCouponAtomSV discountCouponAtomSV;
	
	/**
	 * 生成优惠券模板
	 */
	@Override
	public void BuildCouponTemplet(FunCouponTemplate couponTemplate,Integer requiredMoneyAmount,HttpSession session) throws BusinessException, SystemException {
		//判断用户名是否唯一
		FunCouponTemplateCriteria funCouponTemplateCriteria = new FunCouponTemplateCriteria();
		FunCouponTemplateCriteria.Criteria faCriteria = funCouponTemplateCriteria.createCriteria();
		String couponTemplateName = couponTemplate.getCouponName();
		faCriteria.andCouponNameLike(couponTemplateName);
		FunCouponTemplateMapper funCouponTemplateMapper = MapperFactory.getFunCouponTemplateMapper();
        List<FunCouponTemplate> funCouponTemplate = funCouponTemplateMapper.selectByExample(funCouponTemplateCriteria);
        if (!CollectionUtil.isEmpty(funCouponTemplate)){
        	String createOperator = (String) session.getAttribute("userName");
    		couponTemplate.setCreateOperator(createOperator);
    		Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            couponTemplate.setCreateTime(Timestamp.valueOf(format.format(date)));
            if(requiredMoneyAmount!=null){
            	FunCouponUseRule funCouponUseRule = new FunCouponUseRule();
            	funCouponUseRule.setCouponUserId("a1b2");
            	funCouponUseRule.setFaceValue(null);
            	funCouponUseRule.setRequiredMoneyAmount(requiredMoneyAmount);
            	funCouponUseRule.setCurrencyUnit(couponTemplate.getCurrencyUnit());
            	Date date1=new Date();
                DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                funCouponUseRule.setCreateTime(Timestamp.valueOf(format1.format(date1)));
                couponUseRuleAtomSV.insertBuildCouponUseRule(funCouponUseRule);
            	couponTemplateAtomSV.insertBuildCouponTemplet(couponTemplate);
            }else{
            	couponTemplateAtomSV.insertBuildCouponTemplet(couponTemplate);
            }
    		
        }else {
        	throw new BusinessException("","该优惠券模板名称已存在！");
		}
		
		
	}
	/**
	 * 模糊查询优惠券模板列表
	 */
	@Override
	public PageInfo<FunCouponTemplateResponse> queryCouponTemplet(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest) {
        PageInfo<FunCouponTemplateResponse> funCouponTemplateResponsePageInfo = couponTemplateAtomSV.funCouponTemplateQueryRequest(funCouponTemplateQueryRequest);
		return funCouponTemplateResponsePageInfo;
	}
	/**
	 * 根据优惠券模板iD查询优惠券明细
	 */
	@Override
	public List<FunDiscountCouponInfoVo> queryAccountInfoByCustId(Integer templateId) {
		
		 List<FunDiscountCouponInfoVo> funDiscountCouponInfoVoList = new ArrayList<FunDiscountCouponInfoVo>();
	     List<FunDiscountCoupon> discountCouponList = discountCouponAtomSV.getAccountInfoByCustId(templateId);
	     
	        for (FunDiscountCoupon discountCoupon : discountCouponList) {
	            // TODO 事务层不能互相调用；对象转换的convert方法是否也不能定义在事物层
	        	funDiscountCouponInfoVoList.add((FunDiscountCouponInfoVo) discountCouponList);
	        }
	        return funDiscountCouponInfoVoList;
	}
	/**
	 * POI导出优惠券模板列表生成Excel
	 */
	@Override
	public List<FunCouponTemplateResponse> exportCouponTempletList(FunCouponTemplateQueryRequest funCouponTemplateQueryRequest) {
		return couponTemplateAtomSV.exportCouponTempletList(funCouponTemplateQueryRequest);
	}

	

	
}

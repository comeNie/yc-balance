package com.ai.slp.balance.service.business.impl;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplateCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunCouponUseRule;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunCouponTemplateMapper;
import com.ai.slp.balance.service.atom.interfaces.ICouponTemplateAtomSV;
import com.ai.slp.balance.service.atom.interfaces.ICouponUseRuleAtomSV;
import com.ai.slp.balance.service.business.interfaces.ICouponTemplateBusiSV;
@Service
@Transactional
public class CouponTemplateBusiSVImpl implements ICouponTemplateBusiSV {
	
	@Autowired
	private ICouponTemplateAtomSV couponTemplateAtomSV;
	
	@Autowired
	private ICouponUseRuleAtomSV couponUseRuleAtomSV;
	
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

	
}

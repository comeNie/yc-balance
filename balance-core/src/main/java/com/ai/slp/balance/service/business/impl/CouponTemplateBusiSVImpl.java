package com.ai.slp.balance.service.business.impl;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.service.atom.interfaces.ICouponTemplateAtomSV;
import com.ai.slp.balance.service.business.interfaces.ICouponTemplateBusiSV;
@Service
@Transactional
public class CouponTemplateBusiSVImpl implements ICouponTemplateBusiSV {
	private static final Logger LOG = LogManager.getLogger(CouponTemplateBusiSVImpl.class);
	
	@Autowired
	private ICouponTemplateAtomSV couponTemplateAtomSV;
	
	/**
	 * 生成优惠券模板
	 */
	@Override
	public void BuildCouponTemplet(FunCouponTemplate couponTemplate) throws BusinessException, SystemException {
		
		couponTemplate.setCreateOperator("");
		Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        couponTemplate.setCreateTime(Timestamp.valueOf(format.format(date)));
		couponTemplateAtomSV.insertBuildCouponTemplet(couponTemplate);
	}
	
}

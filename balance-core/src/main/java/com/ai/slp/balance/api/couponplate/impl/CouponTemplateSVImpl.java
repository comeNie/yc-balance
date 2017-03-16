package com.ai.slp.balance.api.couponplate.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.coupontemplate.param.CouponParam;
import com.ai.slp.balance.api.coupontemplate.param.CouponTemplateParam;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplate;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunDiscountCouponInfoVo;
import com.ai.slp.balance.api.coupontemplate.param.ListDiscountCouponResponse;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.ICouponTemplateBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class CouponTemplateSVImpl implements ICouponTemplateSV {
	
	@Autowired
    private ICouponTemplateBusiSV iCouponTemplateBusiSV;

	@Override
	public FunCouponTemplateQueryResponse queryFunCouponTemplate(FunCouponTemplateQueryRequest param)
			throws BusinessException, SystemException {
		FunCouponTemplateQueryResponse funCouponTemplateQueryResponse = new FunCouponTemplateQueryResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
            PageInfo<FunCouponTemplateResponse> pageInfo = iCouponTemplateBusiSV.queryCouponTemplet(param);
            funCouponTemplateQueryResponse.setPageInfo(pageInfo);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("优惠券模板查询成功");
            funCouponTemplateQueryResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            funCouponTemplateQueryResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("优惠券模板查询失败");
            funCouponTemplateQueryResponse.setResponseHeader(responseHeader);
        }
		return funCouponTemplateQueryResponse;
	}
	
	/**
	 * 根据优惠券模板ID查询优惠券明细
	 */
	@Override
	public ListDiscountCouponResponse queryCouponByTemplateId(CouponParam templateId)
			throws BusinessException, SystemException {
		ListDiscountCouponResponse listDiscountCouponResponse = new ListDiscountCouponResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        List<FunDiscountCouponInfoVo> funDiscountCouponInfoVoList = iCouponTemplateBusiSV.queryCouponTempletByCustId(templateId.getTemplateId());
        listDiscountCouponResponse.setFunDiscountCouponInfoVoList(funDiscountCouponInfoVoList);
        if(!CollectionUtil.isEmpty(funDiscountCouponInfoVoList)){
        	responseHeader.setResultCode("0000");
        	responseHeader.setResultMessage("成功");
        	responseHeader.setIsSuccess(true);
        	listDiscountCouponResponse.setResponseHeader(responseHeader);
        }
		return listDiscountCouponResponse;
	}

	@Override
	public Integer checkCouponTemplateName(CouponTemplateParam couponName) throws BusinessException, SystemException {
		return iCouponTemplateBusiSV.checkCouponTemplateName(couponName.getCouponName());
	}

	@Override
	public Integer savaCouponTemplate(FunCouponTemplate req) throws BusinessException, SystemException {
		return null;
	}


   
}

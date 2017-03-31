package com.ai.slp.balance.api.couponplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.balance.api.coupontemplate.interfaces.ICouponTemplateSV;
import com.ai.slp.balance.api.coupontemplate.param.CouponTemplateParam;
import com.ai.slp.balance.api.coupontemplate.param.DeleteFunCouponTemplate;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailPageResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponDetailResponse;
import com.ai.slp.balance.api.coupontemplate.param.SaveFunCouponTemplate;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryRequest;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateQueryResponse;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
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
	
	@Override
	public Integer checkCouponTemplateName(CouponTemplateParam couponName) throws BusinessException, SystemException {
		return iCouponTemplateBusiSV.checkCouponTemplateName(couponName.getCouponName());
	}

	@Override
	public BaseResponse savaCouponTemplate(SaveFunCouponTemplate req) throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			iCouponTemplateBusiSV.saveCouponTempletList(req);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("添加优惠券模板成功");
			response.setResponseHeader(responseHeader);
		}catch (Exception e) {
			throw new SystemException(ExceptCodeConstants.Special.SYSTEM_ERROR,"添加优惠券模板失败");
		}
		return response;
	}
	/**
	 * 根据优惠券模板ID查询优惠券明细
	 */
	@Override
	public FunCouponDetailPageResponse queryCouponDetail(FunCouponDetailQueryRequest param)throws BusinessException, SystemException {
        if (param==null){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (param.getTemplateId()==null){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数优惠券模板iD不能为空");
        }
        FunCouponDetailPageResponse funCouponDetailPageResponse = new FunCouponDetailPageResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        
        try {
            PageInfo<FunCouponDetailResponse> pageInfo = iCouponTemplateBusiSV.queryFunCouponDetail(param);
            funCouponDetailPageResponse.setPageInfo(pageInfo);
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
            responseHeader.setResultMessage("优惠券明细查询成功");
            funCouponDetailPageResponse.setResponseHeader(responseHeader);
        }catch (BusinessException businessException){
            responseHeader.setResultCode(businessException.getErrorCode());
            responseHeader.setResultMessage(businessException.getErrorMessage());
            funCouponDetailPageResponse.setResponseHeader(responseHeader);
        }catch (Exception e){
            responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
            responseHeader.setResultMessage("优惠券明细查询失败");
            funCouponDetailPageResponse.setResponseHeader(responseHeader);
        }
        return funCouponDetailPageResponse;
	}
	/**
	 * 删除优惠券模板
	 */
	@Override
	public Integer deleteCouponTemplate(DeleteFunCouponTemplate param) throws BusinessException, SystemException {
		return iCouponTemplateBusiSV.deleteCouponTemplate(param.getTemplateId());
	}


   
}

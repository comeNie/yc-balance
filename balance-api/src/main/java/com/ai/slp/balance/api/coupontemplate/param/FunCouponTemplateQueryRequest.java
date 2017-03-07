package com.ai.slp.balance.api.coupontemplate.param;


import java.io.Serializable;

import com.ai.opt.base.vo.PageInfo;

/**
 * 模糊查询优惠券模板请求参数
 */
public class FunCouponTemplateQueryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 优惠券模板名称
     */
    private String couponName;

    /**
     * 面值
     */
    private Integer faceValue;

    /**
     * 使用场景
     */
    private String usedScene;

    /**
     * 状态
     */
    private String status;
    /**
     * 币种
     */
    private String currencyUnit;
    /**
     * 创建人
     */
    private String createOperator;
    
    /**
     * 分页时必填
     */
    PageInfo<FunCouponTemplateResponse> pageInfo;
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public Integer getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(Integer faceValue) {
		this.faceValue = faceValue;
	}
	public String getUsedScene() {
		return usedScene;
	}
	public void setUsedScene(String usedScene) {
		this.usedScene = usedScene;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrencyUnit() {
		return currencyUnit;
	}
	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}
	public String getCreateOperator() {
		return createOperator;
	}
	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}
	public PageInfo<FunCouponTemplateResponse> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo<FunCouponTemplateResponse> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}

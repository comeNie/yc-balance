package com.ai.slp.balance.api.coupontemplate.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 添加优惠券模板入参
 */
public class SaveFunCouponTemplate implements Serializable {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/**
	 	 * 模板ID
	 	 */
		private Integer templateId;
		/**
		 * 优惠券名称
	 	 */
	    private String couponName;
	    /**
	     * 优惠券描述
	 	 */
	    private String couponDesc;
	    /**
	     * 面值
	 	 */
	    private Integer faceValue;
	    /**
	     * 随机面值上限制
	 	 */
	    private Integer faceValueUp;
	    /**
	     * 随机面值下限
	 	 */
	    private Integer faceValueDown;
	    /**
	     * 币种
	 	 */
	    private String currencyUnit;
	    /**
	     * 发放数量
	 	 */
	    private String maxCountIssue;
	    /**
	     * 使用规则ID
	 	 */
	    private String couponUserId;
	    /**
	     * 使用场景
	 	 */
	    private String usedScene;
	    /**
	     * 使用限制
	 	 */
	    private String useLimits;
	    /**
	     * 状态
	 	 */
	    private String status;
	    /**
	     * 有效期
	 	 */
	    private Integer effectiveTime;
	    /**
	     * 有效期开始时间
	 	 */
	    private Timestamp effectiveStartTime;
	    /**
	     * 有效期结束时间
	 	 */
	    private Timestamp effectiveEndTime;
	    /**
	     * 领取开始时间
	 	 */
	    private Timestamp receiveStartTime;
	    /**
	     * 领取结束时间
	 	 */
	    private Timestamp receiveEndTime;
	    /**
	     * 创建人
	 	 */
	    private String createOperator;
	    /**
	     * 创建时间
	 	 */
	    private Timestamp createTime;

	    public Integer getTemplateId() {
	        return templateId;
	    }

	    public void setTemplateId(Integer templateId) {
	        this.templateId = templateId;
	    }

	    public String getCouponName() {
	        return couponName;
	    }

	    public void setCouponName(String couponName) {
	        this.couponName = couponName == null ? null : couponName.trim();
	    }

	    public String getCouponDesc() {
	        return couponDesc;
	    }

	    public void setCouponDesc(String couponDesc) {
	        this.couponDesc = couponDesc == null ? null : couponDesc.trim();
	    }

	    public Integer getFaceValue() {
	        return faceValue;
	    }

	    public void setFaceValue(Integer faceValue) {
	        this.faceValue = faceValue;
	    }

	    public Integer getFaceValueUp() {
	        return faceValueUp;
	    }

	    public void setFaceValueUp(Integer faceValueUp) {
	        this.faceValueUp = faceValueUp;
	    }

	    public Integer getFaceValueDown() {
	        return faceValueDown;
	    }

	    public void setFaceValueDown(Integer faceValueDown) {
	        this.faceValueDown = faceValueDown;
	    }

	    public String getCurrencyUnit() {
	        return currencyUnit;
	    }

	    public void setCurrencyUnit(String currencyUnit) {
	        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
	    }

	    public String getMaxCountIssue() {
	        return maxCountIssue;
	    }

	    public void setMaxCountIssue(String maxCountIssue) {
	        this.maxCountIssue = maxCountIssue == null ? null : maxCountIssue.trim();
	    }

	    public String getCouponUserId() {
	        return couponUserId;
	    }

	    public void setCouponUserId(String couponUserId) {
	        this.couponUserId = couponUserId == null ? null : couponUserId.trim();
	    }

	    public String getUsedScene() {
	        return usedScene;
	    }

	    public void setUsedScene(String usedScene) {
	        this.usedScene = usedScene == null ? null : usedScene.trim();
	    }

	    public String getUseLimits() {
	        return useLimits;
	    }

	    public void setUseLimits(String useLimits) {
	        this.useLimits = useLimits == null ? null : useLimits.trim();
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status == null ? null : status.trim();
	    }

	    public Integer getEffectiveTime() {
	        return effectiveTime;
	    }

	    public void setEffectiveTime(Integer effectiveTime) {
	        this.effectiveTime = effectiveTime;
	    }

	    public Timestamp getEffectiveStartTime() {
	        return effectiveStartTime;
	    }

	    public void setEffectiveStartTime(Timestamp effectiveStartTime) {
	        this.effectiveStartTime = effectiveStartTime;
	    }

	    public Timestamp getEffectiveEndTime() {
	        return effectiveEndTime;
	    }

	    public void setEffectiveEndTime(Timestamp effectiveEndTime) {
	        this.effectiveEndTime = effectiveEndTime;
	    }

	    public Timestamp getReceiveStartTime() {
	        return receiveStartTime;
	    }

	    public void setReceiveStartTime(Timestamp receiveStartTime) {
	        this.receiveStartTime = receiveStartTime;
	    }

	    public Timestamp getReceiveEndTime() {
	        return receiveEndTime;
	    }

	    public void setReceiveEndTime(Timestamp receiveEndTime) {
	        this.receiveEndTime = receiveEndTime;
	    }

	    public String getCreateOperator() {
	        return createOperator;
	    }

	    public void setCreateOperator(String createOperator) {
	        this.createOperator = createOperator == null ? null : createOperator.trim();
	    }

	    public Timestamp getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Timestamp createTime) {
	        this.createTime = createTime;
	    }
}

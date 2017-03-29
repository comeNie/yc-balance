package com.ai.slp.balance.api.coupontemplate.param;

import java.io.Serializable;

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
	    private String effectiveStartTime;
	    /**
	     * 有效期结束时间
	 	 */
	    private String effectiveEndTime;
	    /**
	     * 领取开始时间
	 	 */
	    private String receiveStartTime;
	    /**
	     * 领取结束时间
	 	 */
	    private String receiveEndTime;
	    /**
	     * 创建人
	 	 */
	    private String createOperator;
	    
	    /**
		 *满..可用
	     */
	    public Integer requiredMoneyAmount;
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
	    public String getEffectiveStartTime() {
			return effectiveStartTime;
		}

		public void setEffectiveStartTime(String effectiveStartTime) {
			this.effectiveStartTime = effectiveStartTime;
		}

		public String getEffectiveEndTime() {
			return effectiveEndTime;
		}

		public void setEffectiveEndTime(String effectiveEndTime) {
			this.effectiveEndTime = effectiveEndTime;
		}

		public String getReceiveStartTime() {
			return receiveStartTime;
		}

		public void setReceiveStartTime(String receiveStartTime) {
			this.receiveStartTime = receiveStartTime;
		}

		public String getReceiveEndTime() {
			return receiveEndTime;
		}

		public void setReceiveEndTime(String receiveEndTime) {
			this.receiveEndTime = receiveEndTime;
		}

		public String getCreateOperator() {
	        return createOperator;
	    }

	    public void setCreateOperator(String createOperator) {
	        this.createOperator = createOperator == null ? null : createOperator.trim();
	    }

		public Integer getRequiredMoneyAmount() {
			return requiredMoneyAmount;
		}

		public void setRequiredMoneyAmount(Integer requiredMoneyAmount) {
			this.requiredMoneyAmount = requiredMoneyAmount;
		}

}

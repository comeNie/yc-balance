package com.ai.slp.balance.api.activity.param;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 活动策略查询出参.<br>
 */
public class FunActivityResponse implements Serializable {
	private static final long serialVersionUID = 1L;
		/**
		 * 活动ID
		 */
		private Integer activityId;
		/**
		 * 活动名称
		 */
	    private String activityName;
	    /**
		 * 活动描述
		 */
	    private String activityDesc;
	    /**
		 * 使用场景
		 *  1译云-中文站
		 *	2译云-英文站
		 *	3百度
		 *	4金山
		 *	5wap-中文
		 *	6wap-英文
		 *	7找翻译
		 *	8微信助手
		 */
	    private String usedScene;
	    /**
		 * 币种
		 */
	    private String currencyUnit;
	    /**
		 * 总金额
		 */
	    private Integer totalMoneyAmount;
	    /**
		 * 活动时间
		 */
	    private String activityTime;
	    /**
		 * 剩余金额
		 */
	    private Integer remainingMoneyAmount;
	    /**
		 * 活动开始时间
		 */
	    private Timestamp startTime;
	    /**
		 * 活动结束时间
		 */
	    private Timestamp endTime;
	    /**
		 * 状态
		 */
	    private String status;
	    /**
		 * 创建人
		 */
	    private String createStaff;
	    /**
		 * 创建时间
		 */
	    private Timestamp createTime;
	    /**
		 * 修改时间
		 */
	    private Timestamp updateTime;

	    public Integer getActivityId() {
	        return activityId;
	    }

	    public void setActivityId(Integer activityId) {
	        this.activityId = activityId;
	    }

	    public String getActivityName() {
	        return activityName;
	    }

	    public void setActivityName(String activityName) {
	        this.activityName = activityName == null ? null : activityName.trim();
	    }

	    public String getActivityDesc() {
	        return activityDesc;
	    }

	    public void setActivityDesc(String activityDesc) {
	        this.activityDesc = activityDesc == null ? null : activityDesc.trim();
	    }

	    public String getUsedScene() {
	        return usedScene;
	    }

	    public void setUsedScene(String usedScene) {
	        this.usedScene = usedScene == null ? null : usedScene.trim();
	    }

	    public String getCurrencyUnit() {
	        return currencyUnit;
	    }

	    public void setCurrencyUnit(String currencyUnit) {
	        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
	    }

	    public Integer getTotalMoneyAmount() {
	        return totalMoneyAmount;
	    }

	    public void setTotalMoneyAmount(Integer totalMoneyAmount) {
	        this.totalMoneyAmount = totalMoneyAmount;
	    }

	    public String getActivityTime() {
	        return activityTime;
	    }

	    public void setActivityTime(String activityTime) {
	        this.activityTime = activityTime == null ? null : activityTime.trim();
	    }

	    public Integer getRemainingMoneyAmount() {
	        return remainingMoneyAmount;
	    }

	    public void setRemainingMoneyAmount(Integer remainingMoneyAmount) {
	        this.remainingMoneyAmount = remainingMoneyAmount;
	    }

	    public Timestamp getStartTime() {
	        return startTime;
	    }

	    public void setStartTime(Timestamp startTime) {
	        this.startTime = startTime;
	    }

	    public Timestamp getEndTime() {
	        return endTime;
	    }

	    public void setEndTime(Timestamp endTime) {
	        this.endTime = endTime;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status == null ? null : status.trim();
	    }

	    public String getCreateStaff() {
	        return createStaff;
	    }

	    public void setCreateStaff(String createStaff) {
	        this.createStaff = createStaff == null ? null : createStaff.trim();
	    }

	    public Timestamp getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Timestamp createTime) {
	        this.createTime = createTime;
	    }

	    public Timestamp getUpdateTime() {
	        return updateTime;
	    }

	    public void setUpdateTime(Timestamp updateTime) {
	        this.updateTime = updateTime;
	    }
}
package com.ai.slp.balance.api.activityrule.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 活动策略查询出参.<br>
 */
public class FunActivityRuleResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;

	private Long activityId;

	private String usedScene;

	private String currencyUnit;

	private Long totalMoneyAmount;

	private Integer frequency;

	private Long remainingMoneyAmount;

	private String activityTime;

	private String status;

	private String createStaff;

	private Timestamp startTime;

	private Timestamp endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
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

	public Long getTotalMoneyAmount() {
		return totalMoneyAmount;
	}

	public void setTotalMoneyAmount(Long totalMoneyAmount) {
		this.totalMoneyAmount = totalMoneyAmount;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Long getRemainingMoneyAmount() {
		return remainingMoneyAmount;
	}

	public void setRemainingMoneyAmount(Long remainingMoneyAmount) {
		this.remainingMoneyAmount = remainingMoneyAmount;
	}

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime == null ? null : activityTime.trim();
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
}
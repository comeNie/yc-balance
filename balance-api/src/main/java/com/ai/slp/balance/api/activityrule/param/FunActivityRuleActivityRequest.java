package com.ai.slp.balance.api.activityrule.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 活动规则变更.<br>
 */
public class FunActivityRuleActivityRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 活动策略信息
	 */
	//活动策略id
	private Integer activityId;
	//一句话描述
	private String activityDesc;
	//使用场景
	private String usedScene;
	//活动开始时间
	private Timestamp startTime;
	//活动结束时间
	private Timestamp endTime;
	//是否长期  *表示长期
	private String activityTime;
	//状态  1:启用  0:禁用
	private String status;

	//活动规则
	ArrayList<FunActivityRuleRequest> funActivityRuleRequestList;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getUsedScene() {
		return usedScene;
	}

	public void setUsedScene(String usedScene) {
		this.usedScene = usedScene;
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

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<FunActivityRuleRequest> getFunActivityRuleRequestList() {
		return funActivityRuleRequestList;
	}

	public void setFunActivityRuleRequestList(ArrayList<FunActivityRuleRequest> funActivityRuleRequestList) {
		this.funActivityRuleRequestList = funActivityRuleRequestList;
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}
}
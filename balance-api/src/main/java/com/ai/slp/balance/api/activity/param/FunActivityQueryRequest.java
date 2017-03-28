package com.ai.slp.balance.api.activity.param;
import java.io.Serializable;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.coupontemplate.param.FunCouponTemplateResponse;
/**
 * 模糊查询活动策略请求参数
 */
public class FunActivityQueryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 使用场景
     * 1译云-中文站
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
     * 分页时必填
     */
    PageInfo<FunCouponTemplateResponse> pageInfo;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUsedScene() {
		return usedScene;
	}

	public void setUsedScene(String usedScene) {
		this.usedScene = usedScene;
	}

	public PageInfo<FunCouponTemplateResponse> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<FunCouponTemplateResponse> pageInfo) {
		this.pageInfo = pageInfo;
	}
}

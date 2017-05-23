package com.ai.slp.balance.api.rechargewithdrawals.param;

import java.io.Serializable;

import com.ai.opt.base.vo.PageInfo;

public class ReWiehPagePageQueryRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * 用户名
     */
	 private String username;
	 /**
	  * 姓名
	  */
	 private String fullname;
	 /**
	  * 支付方式：1、支付宝；2、微信；3、银行汇款/转账；4、Paypal
	  */
	 private String pattem;
	 /**
	  * 类型
	  */
	 private String type;
	 /**
	  * 状态：1、待审核；2、已确认；3、锁定
	  */
	 private String state;
	 /**
	  * 币种：1、人民币；2、美元
	  */
	 private String currency;
	 /**
	  * 申请人
	  */
	 private String applyPeople;
	 /**
	  * 处理人
	  */
	 private String bruisesPeople;
	 /**
     * 分页时必填
     */
	 PageInfo<ReWiehPageVo> pageInfo;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPattem() {
		return pattem;
	}

	public void setPattem(String pattem) {
		this.pattem = pattem;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getApplyPeople() {
		return applyPeople;
	}

	public void setApplyPeople(String applyPeople) {
		this.applyPeople = applyPeople;
	}

	public String getBruisesPeople() {
		return bruisesPeople;
	}

	public void setBruisesPeople(String bruisesPeople) {
		this.bruisesPeople = bruisesPeople;
	}

	public PageInfo<ReWiehPageVo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<ReWiehPageVo> pageInfo) {
		this.pageInfo = pageInfo;
	}
}

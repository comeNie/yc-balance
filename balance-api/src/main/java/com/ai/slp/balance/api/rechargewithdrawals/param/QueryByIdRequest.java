package com.ai.slp.balance.api.rechargewithdrawals.param;

import java.io.Serializable;
public class QueryByIdRequest  implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * WID
	 */
	private String wid;
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
}

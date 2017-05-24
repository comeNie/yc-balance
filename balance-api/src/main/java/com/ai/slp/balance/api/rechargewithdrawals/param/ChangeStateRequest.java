package com.ai.slp.balance.api.rechargewithdrawals.param;

import java.io.Serializable;

/**
 * 更改状态入参
 *
 */
public class ChangeStateRequest implements Serializable {
	private static final long serialVersionUID = -3795050733122224474L;

	/**
	 * ID
	 */
	private String wid;

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}
}

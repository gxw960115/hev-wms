package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderMoveDoneOut {
	private String status; // S:成功 F:失败
	private String msg;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderIgpOut {
	private String status; // 是否成功 S 成功 F 失败
	private String msg; // 错误原因描述
	private String orId; // 返回单号数据

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

	public String getOrId() {
		return orId;
	}

	public void setOrId(String orId) {
		this.orId = orId;
	}

	@Override
	public String toString() {
		return "WmsOrderIgpOut [status=" + status + ", msg=" + msg + ", orId=" + orId + "]";
	}
	
}

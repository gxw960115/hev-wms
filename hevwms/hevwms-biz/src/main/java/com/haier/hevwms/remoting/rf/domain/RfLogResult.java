package com.haier.hevwms.remoting.rf.domain;

/**
 * <p>Description: [手持RF 日志pojo]</p>
 * Created on 2013-08-16
 * @version 1.0
 */
public class RfLogResult {
	private String status; // 接口调用状态
	private String msg; // 错误原因

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

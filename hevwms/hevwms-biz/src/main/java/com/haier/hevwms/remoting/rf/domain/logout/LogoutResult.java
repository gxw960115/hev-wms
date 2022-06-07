package com.haier.hevwms.remoting.rf.domain.logout;

/**
 * @ClassName: LogoutResult
 * @Description:
 * @author Song Yinglong // Nicholas
 * @date 2015-11-6 上午11:33:38
 * @param
 */
public class LogoutResult {
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

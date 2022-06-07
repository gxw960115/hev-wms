package com.haier.hevwms.remoting.rf.domain;

/**
 * <p>
 * Description: [手持RF 出参 pojo]
 * </p>
 * Created on 2013-07-26
 * 
 * @version 1.0
 */
public class RfResult {
	private String status;// S 成功 F 失败
	private String msg;// 错误原因
	private Object content;// 消息内容

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

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}

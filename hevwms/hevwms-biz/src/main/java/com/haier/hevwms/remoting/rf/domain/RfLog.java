package com.haier.hevwms.remoting.rf.domain;

/**
 * <p>Description: [手持RF 日志pojo]</p>
 * Created on 2013-08-16
 * @version 1.0
 */
public class RfLog {
	private String userId; // 用户ID
	private String type; // 服务名称
	private String sign; // 签名
	private String ip; // IP
	private String status;// 操作状态
	private String rcnr;// 入参内容
	private String ccnr;// 出参内容
	private String dydate;// 调用时间
	private String fhdate;// 返回时间

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRcnr() {
		return rcnr;
	}

	public void setRcnr(String rcnr) {
		this.rcnr = rcnr;
	}

	public String getCcnr() {
		return ccnr;
	}

	public void setCcnr(String ccnr) {
		this.ccnr = ccnr;
	}

	public String getDydate() {
		return dydate;
	}

	public void setDydate(String dydate) {
		this.dydate = dydate;
	}

	public String getFhdate() {
		return fhdate;
	}

	public void setFhdate(String fhdate) {
		this.fhdate = fhdate;
	}

}

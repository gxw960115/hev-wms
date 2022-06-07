package com.haier.hevwms.remoting.rf.domain;

/**
 * <p>Description: [手持RF 入参 pojo]</p>
 * Created on 2013-07-26
 * @version 1.0
 */
public class RfPara {
	private String user;// 用户ID
	private String sign;// 签名
	private String type;// 服务名称
	private Object content;// 消息内容

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}

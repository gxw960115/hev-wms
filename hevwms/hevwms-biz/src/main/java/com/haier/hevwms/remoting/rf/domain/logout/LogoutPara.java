package com.haier.hevwms.remoting.rf.domain.logout;

/**
 * @ClassName: LogoutPara
 * @Description:
 * @author Song Yinglong // Nicholas
 * @date 2015-11-6 上午11:36:18
 * @param
 */
public class LogoutPara {
	private String user; // 登陆账号
	private String sign; // 签名

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
}

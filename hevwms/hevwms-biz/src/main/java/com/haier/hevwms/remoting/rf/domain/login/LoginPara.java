package com.haier.hevwms.remoting.rf.domain.login;

/**
 * <p>Description: [手持RF 入参 pojo]</p>
 * Created on 2013-07-26
 * Create  by lichunhui
 * @version 1.0
 */
public class LoginPara {
	private String user;// 登陆账号
	private String pass;// 密码
	private String ip;// ip

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}

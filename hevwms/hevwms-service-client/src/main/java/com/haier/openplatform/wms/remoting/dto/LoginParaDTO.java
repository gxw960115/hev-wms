package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/** 
* @ClassName: LoginParaDTO 
* @Description: (登录输入参数) 
* @author Song Yinglong // Nicholas
* @date 2015-11-5 下午3:43:56 
* @param 
*/ 
public class LoginParaDTO implements Serializable{
	
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields user : (登陆账号) 
	*/ 
	private String user;
	/** 
	* @Fields pass : (密码) 
	*/ 
	private String pass;
	/** 
	* @Fields ip : (ip) 
	*/ 
	private String ip;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

}

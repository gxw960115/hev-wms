package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/** 
* @ClassName: LogoutParaDTO 
* @Description: (这里用一句话描述这个类的作用) 
* @author Song Yinglong // Nicholas
* @date 2015-11-6 上午11:34:09 
* @param 
*/ 
public class LogoutParaDTO implements Serializable{
	
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/** 
	* @Fields user : (登陆账号) 
	*/ 
	private String user;	
	/** 
	* @Fields sign : (签名) 
	*/ 
	private String sign;
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

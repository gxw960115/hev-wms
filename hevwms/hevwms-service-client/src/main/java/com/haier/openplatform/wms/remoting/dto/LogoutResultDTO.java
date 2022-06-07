package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/** 
* @ClassName: LogoutResultDTO 
* @Description: (这里用一句话描述这个类的作用) 
* @author Song Yinglong // Nicholas
* @date 2015-11-6 上午11:36:40 
* @param 
*/ 
public class LogoutResultDTO implements Serializable{
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields status : (接口调用状态) 
	*/ 
	private String status;
	/** 
	* @Fields msg : (错误原因) 
	*/ 
	private String msg;
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

package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

public class OrderGoodsTransOutDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1137755736960497579L;
	private String status;
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

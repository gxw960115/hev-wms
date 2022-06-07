package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;
import java.util.Set;

public class InterfaceOutDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6074502219348749773L;
	
	
	private String status;
	private String msg; 
	private String stoNo;
	private String isCome;
	private Set<String> dnNos;
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
	public Set<String> getDnNos() {
		return dnNos;
	}
	public void setDnNos(Set<String> dnNos) {
		this.dnNos = dnNos;
	}
	public String getStoNo() {
		return stoNo;
	}
	public void setStoNo(String stoNo) {
		this.stoNo = stoNo;
	}
	public String getIsCome() {
		return isCome;
	}
	public void setIsCome(String isCome) {
		this.isCome = isCome;
	}

	@Override
	public String toString() {
		return "InterfaceOutDTO{" +
				"status='" + status + '\'' +
				", msg='" + msg + '\'' +
				", stoNo='" + stoNo + '\'' +
				", isCome='" + isCome + '\'' +
				", dnNos=" + dnNos +
				'}';
	}

}

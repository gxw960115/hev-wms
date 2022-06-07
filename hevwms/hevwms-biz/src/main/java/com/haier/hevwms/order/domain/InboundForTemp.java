package com.haier.hevwms.order.domain;

import com.haier.openplatform.domain.BaseDomain;

public class InboundForTemp extends BaseDomain<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5283359968479519505L;
	private Long stno;
	private String inboundNo;
	private String status;
	private String msg;
	public Long getStno() {
		return stno;
	}
	public void setStno(Long seq) {
		this.stno = seq;
	}
	public String getInboundNo() {
		return inboundNo;
	}
	public void setInboundNo(String inboundNo) {
		this.inboundNo = inboundNo;
	}
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

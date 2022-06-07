package com.haier.hevwms.order.domain;

import com.haier.openplatform.domain.BaseDomain;

public class DnForTemp extends BaseDomain<Long> {

	private static final long serialVersionUID = -4709133133019309277L;
	private Long stno;
	private String pStatus;
	private String pMsg;

	public Long getStno() {
		return stno;
	}

	public void setStno(Long stno) {
		this.stno = stno;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public String getpMsg() {
		return pMsg;
	}

	public void setpMsg(String pMsg) {
		this.pMsg = pMsg;
	}

}

package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderMoveStoOut {
	private String status; // S:成功 F:失败
	private String msg;
	private String matno; // 物料号
	private String matdesc; // 物料描述
	private String qty; // 数量

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

	public String getMatno() {
		return matno;
	}

	public void setMatno(String matno) {
		this.matno = matno;
	}

	public String getMatdesc() {
		return matdesc;
	}

	public void setMatdesc(String matdesc) {
		this.matdesc = matdesc;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}
}

package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderDeleteOut {
	private String status; // 是否成功 S 成功 F 失败
	private String msg; // 错误原因描述
	private String location; // 库存地点
	private String matno; // 物料号
	private String matdesc; // 物料描述
	private Integer scanqty; // po订单物料累计扫描数量
	private Integer poqty; // po订单物料需求数量

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Integer getScanqty() {
		return scanqty;
	}

	public void setScanqty(Integer scanqty) {
		this.scanqty = scanqty;
	}

	public Integer getPoqty() {
		return poqty;
	}

	public void setPoqty(Integer poqty) {
		this.poqty = poqty;
	}

	@Override
	public String toString() {
		return "WmsOrderDeleteOut [status=" + status + ", msg=" + msg + ", location=" + location + ", matno=" + matno
				+ ", matdesc=" + matdesc + ", scanqty=" + scanqty + ", poqty=" + poqty + "]";
	}

}

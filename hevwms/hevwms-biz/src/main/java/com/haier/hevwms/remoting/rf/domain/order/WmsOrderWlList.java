package com.haier.hevwms.remoting.rf.domain.order;

import java.io.Serializable;

public class WmsOrderWlList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6206216451368962008L;
	private String mat; // 物料号
	private String matdesc;// 物料描述
	private String qty; // 数量
	private String scanqty;// 扫描数量
	private String location;
	private String custModel;
	private String plant;

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getScanqty() {
		return scanqty;
	}

	public void setScanqty(String scanqty) {
		this.scanqty = scanqty;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public String getMatdesc() {
		return matdesc;
	}

	public void setMatdesc(String matdesc) {
		this.matdesc = matdesc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCustModel() {
		return custModel;
	}

	public void setCustModel(String custModel) {
		this.custModel = custModel;
	}
}

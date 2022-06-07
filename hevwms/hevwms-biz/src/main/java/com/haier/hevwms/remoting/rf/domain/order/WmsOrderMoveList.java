package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderMoveList {
	private String barcode; // 条码
	private String materialno; // 物料号
	private String materialDesc;// 物料描述
	private String qty; // 数量
	private String unit; // 单位

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getMaterialno() {
		return materialno;
	}

	public void setMaterialno(String materialno) {
		this.materialno = materialno;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}

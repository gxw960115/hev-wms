package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * @ClassName: OtcwmsOrderWlListDTO
 * @Description: 手持下载后回显
 * @author Song Yinglong // Nicholas
 * @date 2015-11-6 下午2:34:11
 * @param
 */
public class OrderMatListDTO implements Serializable {

	private static final long serialVersionUID = -7033021173690123984L;
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

package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: WmsOrderDelDetialDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:52:57
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class OrderDelDetialDTO implements Serializable {

	private static final long serialVersionUID = 1118373945070587493L;
	
	private String rowId;
	/** SAP凭证单号 */
	private String sapOrderNo;
	/** 条码 */
	private java.lang.String barcode;
	/** 数量 */
	private String qty;
	/** location */
	private String location;

	private String bin;

	private String firstInDate;

	public String getFirstInDate() {
		return firstInDate;
	}

	public void setFirstInDate(String firstInDate) {
		this.firstInDate = firstInDate;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getSapOrderNo() {
		return sapOrderNo;
	}

	public void setSapOrderNo(String sapOrderNo) {
		this.sapOrderNo = sapOrderNo;
	}

	public java.lang.String getBarcode() {
		return barcode;
	}

	public void setBarcode(java.lang.String barcode) {
		this.barcode = barcode;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	@Override
	public String toString() {
		return "OrderDelDetialDTO [rowId=" + rowId + ", sapOrderNo=" + sapOrderNo + ", barcode=" + barcode + ", qty="
				+ qty + ", location=" + location + ", bin=" + bin + "]";
	}

}

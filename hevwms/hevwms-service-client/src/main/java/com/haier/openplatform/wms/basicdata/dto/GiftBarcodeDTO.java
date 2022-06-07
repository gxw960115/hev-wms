package com.haier.openplatform.wms.basicdata.dto;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class GiftBarcodeDTO implements Serializable{
	


	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1694925229076009096L;
	/** 主键 */
	private Long rowId;
	/** 物料号 */
	private java.lang.String materialNo;
	/** 物料描述 */
	private java.lang.String materialDesp;
	/** 条码 */
	private java.lang.String barcode;
	/** 流水号 */
	private java.lang.String stNo;
	/** 创建人 */
	private java.lang.String createBy;
	/** 创建日期 */
	private java.lang.String createDate;
	/** 创建条码数量 */
	private java.lang.String barCodeNum;

	private java.lang.String createDateB;
	private java.lang.String createDateE;

	private java.lang.String barFlag;
	private java.lang.String productLine;
	
	/** 
	* @Fields 把人codeNum : (条码数量) 
	*/ 
	private Long barcodeNum = 0L;
	
	

	public Long getBarcodeNum() {
		return barcodeNum;
	}

	public void setBarcodeNum(Long barcodeNum) {
		this.barcodeNum = barcodeNum;
	}

	public java.lang.String getProductLine() {
		return productLine;
	}

	public void setProductLine(java.lang.String productLine) {
		this.productLine = productLine;
	}

	public java.lang.String getBarFlag() {
		return barFlag;
	}

	public void setBarFlag(java.lang.String barFlag) {
		this.barFlag = barFlag;
	}

	public java.lang.String getCreateDateB() {
		return createDateB;
	}

	public void setCreateDateB(java.lang.String createDateB) {
		this.createDateB = createDateB;
	}

	public java.lang.String getCreateDateE() {
		return createDateE;
	}

	public void setCreateDateE(java.lang.String createDateE) {
		this.createDateE = createDateE;
	}

	public java.lang.String getBarCodeNum() {
		return barCodeNum;
	}

	public void setBarCodeNum(java.lang.String barCodeNum) {
		this.barCodeNum = barCodeNum;
	}

	public java.lang.String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}

	public Long getRowId() {
		return this.rowId;
	}

	public void setRowId(Long value) {
		this.rowId = value;
	}

	public java.lang.String getMaterialNo() {
		if (this.materialNo != null) {
			this.materialNo = this.materialNo.toUpperCase();
		}
		return this.materialNo;
	}

	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}

	public java.lang.String getMaterialDesp() {
		return this.materialDesp;
	}

	public void setMaterialDesp(java.lang.String value) {
		this.materialDesp = value;
	}

	public java.lang.String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(java.lang.String value) {
		this.barcode = value;
	}

	public java.lang.String getStNo() {
		return this.stNo;
	}

	public void setStNo(java.lang.String value) {
		this.stNo = value;
	}

	public java.lang.String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(java.lang.String value) {
		this.createBy = value;
	}


}

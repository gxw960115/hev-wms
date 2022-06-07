package com.haier.openplatform.wms.inventory.dto;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsMoveInventoryDTO extends BaseDomain<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8738418077157365444L;

	/** 主键 */
 
	private Long rowId;
 
	/** 工厂 */
 
	private String plant;
 
	/** 条码 */
 
	private java.lang.String barcode;
 
	/** 物料号 */
 
	private String materialNo;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 单位 */
 
	private String unit;
 
	/** 数量 */
 
	private Long qty;
 
	/** 源仓库 */
 
	private java.lang.String sourceLocation;
 
	/** 目标仓库 */
 
	private java.lang.String targeLocation;
 
	/** sap返回标志 默认0 成功1 失败2 锁定状态3 */
 
	private java.lang.String sapFlag;
 
	/** sap返回信息 */
 
	private String sapMsg;
 
	/** sap凭证号 */
 
	private java.lang.String sapDocNo;
 
	/** 创建人 */
 
	private String createBy;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改人 */
 
	private String modifyBy;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 有效标记 0-有效 1-失效 */
 
	private java.lang.String flag;
 
	/** 是否进入SAP标志 0-不进入 1-进入 */
 
	private java.lang.String inSapFlag;
 
	/** 手持传入流水号，确定一批数据 */
 
	private java.lang.String serialNo;
 
	/** 原库位 */
 
	private java.lang.String sourceSubLocation;
 
	/** 目的库位 */
 
	private java.lang.String targeSubLocation;
 
	/** 移库完成标志 0-默认 1-完成 */
 
	private java.lang.String finishFlag;
	
	private Long sapSendId;


	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public String getPlant() {
		return this.plant;
	}
	
	public void setPlant(String value) {
		this.plant = value;
	}
	

	public java.lang.String getBarcode() {
		return this.barcode;
	}
	
	public void setBarcode(java.lang.String value) {
		this.barcode = value;
	}
	

	public String getMaterialNo() {
		if (this.materialNo != null) {
			this.materialNo = this.materialNo.toUpperCase();
		}
		return this.materialNo;
	}
	
	public void setMaterialNo(String value) {
		this.materialNo = value;
	}
	

	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	

	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String value) {
		this.unit = value;
	}
	

	public Long getQty() {
		return this.qty;
	}
	
	public void setQty(Long value) {
		this.qty = value;
	}
	

	public java.lang.String getSourceLocation() {
		return this.sourceLocation;
	}
	
	public void setSourceLocation(java.lang.String value) {
		this.sourceLocation = value;
	}
	

	public java.lang.String getTargeLocation() {
		return this.targeLocation;
	}
	
	public void setTargeLocation(java.lang.String value) {
		this.targeLocation = value;
	}
	

	public java.lang.String getSapFlag() {
		return this.sapFlag;
	}
	
	public void setSapFlag(java.lang.String value) {
		this.sapFlag = value;
	}
	

	public String getSapMsg() {
		return this.sapMsg;
	}
	
	public void setSapMsg(String value) {
		this.sapMsg = value;
	}
	

	public java.lang.String getSapDocNo() {
		return this.sapDocNo;
	}
	
	public void setSapDocNo(java.lang.String value) {
		this.sapDocNo = value;
	}
	

	public String getCreateBy() {
		return this.createBy;
	}
	
	public void setCreateBy(String value) {
		this.createBy = value;
	}
	
	public String getModifyBy() {
		return this.modifyBy;
	}
	
	public void setModifyBy(String value) {
		this.modifyBy = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	

	public java.lang.String getInSapFlag() {
		return this.inSapFlag;
	}
	
	public void setInSapFlag(java.lang.String value) {
		this.inSapFlag = value;
	}
	

	public java.lang.String getSerialNo() {
		return this.serialNo;
	}
	
	public void setSerialNo(java.lang.String value) {
		this.serialNo = value;
	}
	

	public java.lang.String getSourceSubLocation() {
		return this.sourceSubLocation;
	}
	
	public void setSourceSubLocation(java.lang.String value) {
		this.sourceSubLocation = value;
	}
	

	public java.lang.String getTargeSubLocation() {
		return this.targeSubLocation;
	}
	
	public void setTargeSubLocation(java.lang.String value) {
		this.targeSubLocation = value;
	}
	

	public java.lang.String getFinishFlag() {
		return this.finishFlag;
	}
	
	public void setFinishFlag(java.lang.String value) {
		this.finishFlag = value;
	}

	public Long getSapSendId() {
		return sapSendId;
	}

	public void setSapSendId(Long sapSendId) {
		this.sapSendId = sapSendId;
	}
	
	public java.util.Date getCreateDate() {
		if (createDate == null){
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}
	public void setCreateDate(java.util.Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	public java.util.Date getModifyDate() {
		if (modifyDate == null){
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}
	public void setModifyDate(java.util.Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}

}

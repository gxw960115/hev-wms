package com.haier.openplatform.wms.report.dto;

import java.io.Serializable;
/**
* @Company: 青鸟软通
* @Title: ConsignmentReportDTO.java
* @Package com.haier.openplatform.wms.report.dto
* @author YanFengdan
* @date 2015-12-2 上午10:00:54
 */
public class ConsignmentReportDTO implements Serializable{

	private static final long serialVersionUID = -5391576476729077437L;
	
	/** 主键 */
	private Long rowId;
	private String customerNo;
	private String division;//大类
	private String materialNo;//物料号
	private String soldToParty;
	private String soldToName;
	private String shipToAddress;
	private String plt;
	private String loc;//库存地点
	private String customerModel;//客户描述
	private String materialDesp;//物料描述
	private Long fillupQty;
	private Long pickupQty;
	private Long issueQty;
	private Long stockQty;
	private String unit;
	
	/**
	 * getRowId
	 * @return Long
	 */
	public Long getRowId() {
		return rowId;
	}
	/**
	 * setRowId
	 * @param rowId
	 */
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	/**
	 * getCustomerNo
	 * @return String
	 */
	public String getCustomerNo() {
		return customerNo;
	}
	/**
	 * setCustomerNo
	 * @param customerNo
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	/**
	 * getDivision
	 * @return String
	 */
	public String getDivision() {
		return division;
	}
	/**
	 * setDivision
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	/**
	 * getMaterialNo
	 * @return String
	 */
	public String getMaterialNo() {
		return materialNo;
	}
	/**
	 * setMaterialNo
	 * @param materialNo
	 */
	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}
	/**
	 * getSoldToParty
	 * @return String
	 */
	public String getSoldToParty() {
		return soldToParty;
	}
	/**
	 * getSoldToParty
	 * @param soldToParty
	 */
	public void getSoldToParty(String soldToParty) {
		this.soldToParty = soldToParty;
	}
	/**
	 * getSoldToName
	 * @return String
	 */
	public String getSoldToName() {
		return soldToName;
	}
	/**
	 * setSoldToName
	 * @param soldToName
	 */
	public void setSoldToName(String soldToName) {
		this.soldToName = soldToName;
	}
	/**
	 * getShipToAddress
	 * @return String
	 */
	public String getShipToAddress() {
		return shipToAddress;
	}
	/**
	 * getShipToAddress
	 * @param shipToAddress
	 */
	public void getShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}
	/**
	 * getPlt
	 * @return 	 String
	 */
	public String getPlt() {
		return plt;
	}
	/**
	 * setPlt
	 * @param plt
	 */
	public void setPlt(String plt) {
		this.plt = plt;
	}
	/**
	 * getLoc
	 * @return String
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * setLoc
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	/**
	 * getCustomerModel
	 * @return String
	 */
	public String getCustomerModel() {
		return customerModel;
	}
	/**
	 * getCustomerModel
	 * @param customerModel
	 */
	public void getCustomerModel(String customerModel) {
		this.customerModel = customerModel;
	}
	/**
	 * getMaterialDesp
	 * @return String
	 */
	public String getMaterialDesp() {
		return materialDesp;
	}
	/**
	 * setMaterialDesp
	 * @param materialDesp
	 */
	public void setMaterialDesp(String materialDesp) {
		this.materialDesp = materialDesp;
	}
	/**
	 * getFillupQty
	 * @return Long
	 */
	public Long getFillupQty() {
		return fillupQty;
	}
	/**
	 * setFillupQty
	 * @param fillupQty
	 */
	public void setFillupQty(Long fillupQty) {
		this.fillupQty = fillupQty;
	}
	/**
	 * getPickupQty
	 * @return Long
	 */
	public Long getPickupQty() {
		return pickupQty;
	}
	/**
	 * setPickupQty
	 * @param pickupQty
	 */
	public void setPickupQty(Long pickupQty) {
		this.pickupQty = pickupQty;
	}
	/**
	 * getIssueQty
	 * @return Long
	 */
	public Long getIssueQty() {
		return issueQty;
	}
	/**
	 * setIssueQty
	 * @param issueQty
	 */
	public void setIssueQty(Long issueQty) {
		this.issueQty = issueQty;
	}
	/**
	 * getStockQty
	 * @return Long
	 */
	public Long getStockQty() {
		return stockQty;
	}
	/**
	 * setStockQty
	 * @param stockQty
	 */
	public void setStockQty(Long stockQty) {
		this.stockQty = stockQty;
	}
	/**
	 * getUnit
	 * @return String
	 */ 
	public String getUnit() {
		return unit;
	}
	/**
	 * setUnit
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
}

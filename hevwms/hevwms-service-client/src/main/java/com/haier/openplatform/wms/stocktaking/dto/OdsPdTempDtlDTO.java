package com.haier.openplatform.wms.stocktaking.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称otcwms-service-client
 * @类名称OdsPdTempDtlDTO
 * @类描述
 * @返回值类型
 */
public class OdsPdTempDtlDTO implements Serializable{
	
	/**
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -7832999186296854814L;

	private Long rowId;

	private String orderNo;

	private String plant;

	private String location;

	private String materialNo;
	
	private String barcode;
	
	private Long qty;
	
	private String moveToPlant;
	
	private String moveToLocation;
	
	private String status;
	
	private String sapDocNo;

	private String createBy;

	private Date createDate;

	private String modifyBy;

	private Date modifyDate;
	
	private String begin;
	
	private String end;

	/**
	 * getOrderNo
	 * @return String
	 */ 
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * setOrderNo
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * getPlant
	 * @return String
	 */
	public String getPlant() {
		return plant;
	}

	/**
	 * setPlant
	 * @param plant
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}

	/**
	 * getLocation
	 * @return String
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * getLocation
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * getBarcode
	 * @return String
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * setBarcode
	 * @param barcode
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

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
	 * getQty
	 * @return Long
	 */
	public Long getQty() {
		return qty;
	}

	/**
	 * setQty
	 * @param qty
	 */
	public void setQty(Long qty) {
		this.qty = qty;
	}

	/**
	 * getMoveToPlant
	 * @return String
	 */
	public String getMoveToPlant() {
		return moveToPlant;
	}

	/**
	 * setMoveToPlant
	 * @param moveToPlant
	 */
	public void setMoveToPlant(String moveToPlant) {
		this.moveToPlant = moveToPlant;
	}

	/**
	 * getMoveToLocation
	 * @return String
	 */
	public String getMoveToLocation() {
		return moveToLocation;
	}

	/**
	 * setMoveToLocation
	 * @param moveToLocation
	 */
	public void setMoveToLocation(String moveToLocation) {
		this.moveToLocation = moveToLocation;
	}

	/**
	 * getStatus
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * setStatus
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * getSapDocNo
	 * @return String
	 */
	public String getSapDocNo() {
		return sapDocNo;
	}

	/**
	 * setSapDocNo
	 * @param sapDocNo
	 */
	public void setSapDocNo(String sapDocNo) {
		this.sapDocNo = sapDocNo;
	}

	/**
	 * getCreateBy
	 * @return String
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * setCreateBy
	 * @param createBy
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * getCreateDate
	 * @return Date
	 */
	public java.util.Date getCreateDate() {
		if (createDate == null){
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}

	/**
	 * setCreateDate
	 * @param createDate
	 */
	public void setCreateDate(java.util.Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}

	/**
	 * getModifyBy
	 * @return String
	 */
	public String getModifyBy() {
		return modifyBy;
	}

	/**
	 * setModifyBy
	 * @param modifyBy
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * getModifyDate
	 * @return Date
	 */
	public java.util.Date getModifyDate() {
		if (modifyDate == null){
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}

	/**
	 * setModifyDate
	 * @param modifyDate
	 */
	public void setModifyDate(java.util.Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}

	/**
	 * getBegin
	 * @return String
	 */
	public String getBegin() {
		return begin;
	}

	/**
	 * setBegin
	 * @param begin
	 */
	public void setBegin(String begin) {
		this.begin = begin;
	}

	/**
	 * getEnd
	 * @return String
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * setEnd
	 * @param end
	 */
	public void setEnd(String end) {
		this.end = end;
	}

}

package com.haier.openplatform.wms.stocktaking.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsPdTempDTO implements Serializable{
	
	/**
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 7650463937042871861L;

	private Long rowId;
	
	private String orderNo;
	
	private String plant;
	
	private String location;
	
	private String status;
	
	private String createBy;
	
	private Date createDate;
	
	private String modifyBy;
	
	private Date modifyDate;
	
	private String begin;
	
	private String end;

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
	 * setLocation
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * getStatus
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * getStatus
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * getCreateDate
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

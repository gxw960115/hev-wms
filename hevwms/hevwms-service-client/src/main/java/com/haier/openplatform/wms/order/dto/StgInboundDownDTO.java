
package com.haier.openplatform.wms.order.dto;

import java.io.Serializable;
import java.util.Date;


public class StgInboundDownDTO implements Serializable {
    


	/** ID */
 
	private Long rowId;
 
	/** 采购订单号 */
 
	private java.lang.String poNo;
 
	/** 采购订单行项目 */
 
	private java.lang.String poItemNo;
 
	/** INBOUND 代码 */
 
	private java.lang.String inboundDeliveryNo;
 
	/** INBOUND创建日期 */
 
	private java.lang.String indCreateDate;
 
	/** INBOUND 最后修改日期 */
 
	private java.lang.String indLastModifyDate;
 
	/** INBOUND 行项目 */
 
	private java.lang.String inboundItemNo;
 
	/** 物料号 */
 
	private java.lang.String materialNo;
 
	/** 客户型号，将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号前 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 采购订单数量 */
 
	private Long qty;
 
	/** 库存地点 */
 
	private java.lang.String inboundLocation;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 版本号 */
 
	private java.lang.Long version;
	
	private String deliverDate;
	
	private String createBy;
	
	private String unit;
	private String begin;
	private String end;
	private Long finishQty;
	
	private String userType;
	private Long userId;
	private String finishFlag;
	//过账成功标记
	private String sapFlag;
	
	/**
	 * getFinishQty
	 * @return Long
	 */
	public Long getFinishQty() {
		return finishQty;
	}

	/**
	 * setFinishQty
	 * @param finishQty
	 */
	public void setFinishQty(Long finishQty) {
		this.finishQty = finishQty;
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

	/**
	 * getRowId
	 * @return Long
	 */
	public Long getRowId() {
		return this.rowId;
	}
	
	/**
	 * setRowId
	 * @param value
	 */
	public void setRowId(Long value) {
		this.rowId = value;
	}
	
	/**
	 * getPoNo
	 * @return String
	 */
	public java.lang.String getPoNo() {
		return this.poNo;
	}
	
	/**
	 * setPoNo
	 * @param value
	 */
	public void setPoNo(java.lang.String value) {
		this.poNo = value;
	}
	
	/**
	 * getPoItemNo
	 * @return String
	 */
	public java.lang.String getPoItemNo() {
		return this.poItemNo;
	}
	
	/**
	 * setPoItemNo
	 * @param value
	 */
	public void setPoItemNo(java.lang.String value) {
		this.poItemNo = value;
	}
	
	/**
	 * getInboundDeliveryNo
	 * @return String
	 */ 
	public java.lang.String getInboundDeliveryNo() {
		return this.inboundDeliveryNo;
	}
	
	/**
	 * setInboundDeliveryNo
	 * @param value
	 */
	public void setInboundDeliveryNo(java.lang.String value) {
		this.inboundDeliveryNo = value;
	}
	
	/**
	 * getIndCreateDate
	 * @return String
	 */
	public java.lang.String getIndCreateDate() {
		return this.indCreateDate;
	}
	
	/**
	 * setIndCreateDate
	 * @param value
	 */
	public void setIndCreateDate(java.lang.String value) {
		this.indCreateDate = value;
	}
	
	/**
	 * getIndLastModifyDate
	 * @return String
	 */
	public java.lang.String getIndLastModifyDate() {
		return this.indLastModifyDate;
	}
	
	/**
	 * setIndLastModifyDate
	 * @param value
	 */
	public void setIndLastModifyDate(java.lang.String value) {
		this.indLastModifyDate = value;
	}
	
	/**
	 * getInboundItemNo
	 * @return String
	 */
	public java.lang.String getInboundItemNo() {
		return this.inboundItemNo;
	}
	
	/**
	 * setInboundItemNo
	 * @param value
	 */
	public void setInboundItemNo(java.lang.String value) {
		this.inboundItemNo = value;
	}
	
	/**
	 * getMaterialNo
	 * @return String
	 */
	public java.lang.String getMaterialNo() {
		if(materialNo!=null){
			materialNo= materialNo.toUpperCase();
		}
		return materialNo;
	}
	
	/**
	 * setMaterialNo
	 * @param value
	 */
	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}
	
	/**
	 * getCustomerModel
	 * @return String
	 */
	public String getCustomerModel() {
		return this.customerModel;
	}
	
	/**
	 * setCustomerModel
	 * @param value
	 */
	public void setCustomerModel(String value) {
		this.customerModel = value;
	}
	
	/**
	 * getMaterialDesp
	 * @return String
	 */
	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	/**
	 * setMaterialDesp
	 * @param value
	 */
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	
	/**
	 * getQty
	 * @return Long
	 */
	public Long getQty() {
		return this.qty;
	}
	
	/**
	 * setQty
	 * @param value
	 */
	public void setQty(Long value) {
		this.qty = value;
	}
	
	/**
	 * getInboundLocation
	 * @return String
	 */ 
	public java.lang.String getInboundLocation() {
		if(inboundLocation!=null){
			inboundLocation = inboundLocation.toUpperCase();
		}
		return inboundLocation;
	}
	
	/**
	 * setInboundLocation
	 * @param value
	 */
	public void setInboundLocation(java.lang.String value) {
		this.inboundLocation = value;
	}
	
	/**
	 * getVersion
	 * @return Long
	 */
	public java.lang.Long getVersion() {
		return this.version;
	}
	
	/**
	 * setVersion
	 * @param value
	 */
	public void setVersion(java.lang.Long value) {
		this.version = value;
	}

	/**
	 * getDeliverDate
	 * @return String
	 */
	public String getDeliverDate() {
		return deliverDate;
	}

	/**
	 * setDeliverDate
	 * @param deliverDate
	 */
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
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

	/**
	 * getUserType
	 * @return String
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * setUserType
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * getUserId
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * setUserId
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * getFinishFlag
	 * @return String
	 */
	public String getFinishFlag() {
		return finishFlag;
	}

	/**
	 * setFinishFlag
	 * @param finishFlag
	 */
	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}

	/**
	 * getSapFlag
	 * @return String
	 */
    public String getSapFlag() {
        return sapFlag;
    }

    /**
     * setSapFlag
     * @param sapFlag
     */
    public void setSapFlag(String sapFlag) {
        this.sapFlag = sapFlag;
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


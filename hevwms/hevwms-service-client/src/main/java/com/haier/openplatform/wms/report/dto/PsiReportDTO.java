package com.haier.openplatform.wms.report.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PsiReportDTO implements Serializable{

	private static final long serialVersionUID = 7949145471386038427L;

	/** 主键 */
	private Long rowId;
	private java.lang.String flag;//有效标记 0-有效 1-失效
	private String warehouseCode;//仓库代码 
	private String warehouseName;//仓库名称
	private String location;//库存地点
	private String materialNo;//物料号
	private String division;//大类
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private java.util.Date createDate=new Date();//创建日期
	private String customerModel;//客户描述
	private String materialDesp;//物料描述
	private String color;//颜色
	private Long openingQty;
	private Long inWarehouseQty;//入库数量
	private Long outWarehouseQty;//出库数量
	private Long wmsQty;//库存数量
	private String begin;
	private String end;
	private String userName;
	private String url;
	private String passWord;
	private String driverClassName;
	
	/**
	 * getDriverClassName
	 * @return String
	 */
    public String getDriverClassName() {
        return driverClassName;
    }
    /**
     * setDriverClassName
     * @param driverClassName
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    /**
     * getUserName
     * @return String
     */
    public String getUserName() {
        return userName;
    }
    /**
     * setUserName
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * getUrl
     * @return String
     */
    public String getUrl() {
        return url;
    }
    /**
     * setUrl
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * getPassWord
     * @return String
     */
    public String getPassWord() {
        return passWord;
    }
    /**
     * setPassWord
     * @param passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
	 * getFlag
	 * @return String
	 */
	public java.lang.String getFlag() {
		return flag;
	}
	/**
	 * setFlag
	 * @param flag
	 */
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}
	/**
	 * getWarehouseCode
	 * @return String
	 */
	public String getWarehouseCode() {
		return warehouseCode;
	}
	/**
	 * setWarehouseCode
	 * @param warehouseCode
	 */
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	/**
	 * getWarehouseName
	 * @return String
	 */
	public String getWarehouseName() {
		return warehouseName;
	}
	/**
	 * 
	 * @param warehouseName
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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
	
	/**
	 * getCustomerModel
	 * @return String
	 */
	public String getCustomerModel() {
		return customerModel;
	}
	/**
	 * setCustomerModel
	 * @param customerModel
	 */
	public void setCustomerModel(String customerModel) {
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
	 * getColor
	 * @return String
	 */
	public String getColor() {
		return color;
	}
	/**
	 * setColor
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * getOpeningQty
	 * @return Long
	 */
	public Long getOpeningQty() {
		return openingQty;
	}
	/**
	 * setOpeningQty
	 * @param openingQty
	 */
	public void setOpeningQty(Long openingQty) {
		this.openingQty = openingQty;
	}
	/**
	 * getInWarehouseQty
	 * @return Long
	 */
	public Long getInWarehouseQty() {
		return inWarehouseQty;
	}
	/**
	 * setInWarehouseQty
	 * @param inWarehouseQty
	 */
	public void setInWarehouseQty(Long inWarehouseQty) {
		this.inWarehouseQty = inWarehouseQty;
	}
	/**
	 * getOutWarehouseQty
	 * @return Long
	 */
	public Long getOutWarehouseQty() {
		return outWarehouseQty;
	}
	/**
	 * setOutWarehouseQty
	 * @param outWarehouseQty
	 */
	public void setOutWarehouseQty(Long outWarehouseQty) {
		this.outWarehouseQty = outWarehouseQty;
	}
	/**
	 * getWmsQty
	 * @return Long
	 */
	public Long getWmsQty() {
		return wmsQty;
	}
	/**
	 * getWmsQty
	 * @param wmsQty
	 */
	public void getWmsQty(Long wmsQty) {
		this.wmsQty = wmsQty;
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

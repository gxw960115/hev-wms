package com.haier.openplatform.wms.stocktaking.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsPdDiffDtlDTO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3383260414064115017L;

	/** 主键 */
    
    private Long rowId;
 
    /** 盘点单号 */
 
    private String orderNo;
 
    /** 工厂 */
 
    private String plant;
 
    /** 客户描述 */
 
    private String customerModel;
 
    /** 库存地点 */
 
    private String location;
 
    /** 物料号 */
 
    private String materialNo;
 
    /** 物料描述 */
 
    private String materialDesp;
 
    /** 差异状态 0- 盘盈 1-盘亏 */
 
    private java.lang.String diffType;
 
    /** 单位 */
 
    private String unit;
 
    /** 条码 */
 
    private String barcode;
 
    /** 条码入库日期 */
 
    private java.util.Date inoutDate=new Date();
 
    /** 创建人 */
 
    private String createBy;
 
    /** 创建日期 */
 
    private java.util.Date createDate=new Date();
 
    /** 修改人 */
 
    private String modifyBy;
 
    /** 修改日期 */
 
    private java.util.Date modifyDate=new Date();
 
    /** 有效标记 0-有效 1-失效 */
 
    private java.lang.String flag;
 
    /** 版本号 */
 
    private Long version;
 
    /** 仓间，库位 */
 
    private String subLocation;
 
    /** 数量 */
 
    private Long qty;
    private String inveSubLocation;
    private String processFlag;
    private String begin;
    private String end;
    /**  */
	private String userType;
	
	/**  */
	private Long userId;
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
     * getDiffType
     * @return String
     */
    public java.lang.String getDiffType() {
        return diffType;
    }
    /**
     * setDiffType
     * @param diffType
     */
    public void setDiffType(java.lang.String diffType) {
        this.diffType = diffType;
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
     * getInoutDate
     * @return Date
     */
    public java.util.Date getInoutDate() {
    	if (inoutDate == null){
    		return null;
    	} else {
    		return (Date) inoutDate.clone();
    	}
    }
    /**
     * setInoutDate
     * @param inoutDate
     */
    public void setInoutDate(java.util.Date inoutDate) {
    	if (inoutDate == null){
    		this.inoutDate = null;
    	} else {
    		this.inoutDate = (Date) inoutDate.clone();
    	}
    }
    /**
     * getCreateBy
     * @return String
     */
    public String getCreateBy() {
        return createBy;
    }
    /**
     * getCreateBy
     * @param createBy
     */
    public void getCreateBy(String createBy) {
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
     * getFlag
     * @return String
     */
    public java.lang.String getFlag() {
        return flag;
    }
    /**
     * getFlag
     * @param flag
     */
    public void getFlag(java.lang.String flag) {
        this.flag = flag;
    }
    /**
     * getVersion
     * @return Long
     */
    public Long getVersion() {
        return version;
    }
    /**
     * setVersion
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }
    /**
     * getSubLocation
     * @return String
     */
    public String getSubLocation() {
        return subLocation;
    }
    /**
     * setSubLocation
     * @param subLocation
     */
    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
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
     * getInveSubLocation
     * @return String
     */
    public String getInveSubLocation() {
        return inveSubLocation;
    }
    /**
     * setInveSubLocation
     * @param inveSubLocation
     */
    public void setInveSubLocation(String inveSubLocation) {
        this.inveSubLocation = inveSubLocation;
    }
    /**
     * getProcessFlag
     * @return String
     */
    public String getProcessFlag() {
        return processFlag;
    }
    /**
     * setProcessFlag
     * @param processFlag
     */
    public void setProcessFlag(String processFlag) {
        this.processFlag = processFlag;
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
    
    
}

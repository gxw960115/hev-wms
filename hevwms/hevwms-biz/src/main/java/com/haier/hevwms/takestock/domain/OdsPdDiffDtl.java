package com.haier.hevwms.takestock.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsPdDiffDtl extends BaseDomain<Long> {

    /**
	 * 
	 */
    private static final long serialVersionUID = 6826292398006438952L;

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

    private java.util.Date inoutDate;

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
    private String processReason;
    /**  */
	private String userType;
	
	/**  */
	private Long userId;
    
    public String getBegin() {
	return begin;
    }

    public void setBegin(String begin) {
	this.begin = begin;
    }

    public String getEnd() {
	return end;
    }

    public void setEnd(String end) {
	this.end = end;
    }

    public Long getRowId() {
	return this.rowId;
    }

    public void setRowId(Long value) {
	this.rowId = value;
    }

    public String getOrderNo() {
	return this.orderNo;
    }

    public void setOrderNo(String value) {
	this.orderNo = value;
    }

    public String getPlant() {
	return this.plant;
    }

    public void setPlant(String value) {
	this.plant = value;
    }

    public String getCustomerModel() {
	return this.customerModel;
    }

    public void setCustomerModel(String value) {
	this.customerModel = value;
    }

    public String getLocation() {
	if (location != null) {
	    location = location.toUpperCase();
	}
	return location;
    }

    public void setLocation(String value) {
	this.location = value;
    }

    public String getMaterialNo() {
	if (materialNo != null) {
	    materialNo = materialNo.toUpperCase();
	}
	return materialNo;
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

    public java.lang.String getDiffType() {
	return this.diffType;
    }

    public void setDiffType(java.lang.String value) {
	this.diffType = value;
    }

    public String getUnit() {
	return this.unit;
    }

    public void setUnit(String value) {
	this.unit = value;
    }

    public String getBarcode() {
	return this.barcode;
    }

    public void setBarcode(String value) {
	this.barcode = value;
    }

    public java.util.Date getInoutDate() {
    	if (inoutDate == null){
    		return null;
    	} else {
    		return (Date) inoutDate.clone();
    	}
    }

    public void setInoutDate(java.util.Date value) {
    	if (value == null){
    		this.inoutDate = null;
    	} else {
    		this.inoutDate = (Date) value.clone();
    	}
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

    public Long getVersion() {
	return this.version;
    }

    public void setVersion(Long value) {
	this.version = value;
    }

    public String getSubLocation() {
	return this.subLocation;
    }

    public void setSubLocation(String value) {
	this.subLocation = value;
    }

    public Long getQty() {
	return this.qty;
    }

    public void setQty(Long value) {
	this.qty = value;
    }

    public String getInveSubLocation() {
	return inveSubLocation;
    }

    public void setInveSubLocation(String inveSubLocation) {
	this.inveSubLocation = inveSubLocation;
    }

    public String getProcessFlag() {
	return processFlag;
    }

    public void setProcessFlag(String processFlag) {
	this.processFlag = processFlag;
    }

    public String getProcessReason() {
        return processReason;
    }

    public void setProcessReason(String processReason) {
        this.processReason = processReason;
    }

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
	public java.util.Date getCreateDate() {
		if (this.createDate == null){
			return null;
		} else {
			return (Date) this.createDate.clone();
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
		if (this.modifyDate == null){
			return null;
		} else {
			return (Date) this.modifyDate.clone();
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

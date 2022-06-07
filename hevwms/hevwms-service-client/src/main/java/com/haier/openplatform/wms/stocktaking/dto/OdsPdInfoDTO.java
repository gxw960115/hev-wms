package com.haier.openplatform.wms.stocktaking.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsPdInfoDTO implements Serializable {

    /**
    * @Fields serialVersionUID : 
    */
    private static final long serialVersionUID = 10000L;

    /**
    * @Fields rowId : 主鍵
    */
    private Long rowId;
 
 
    /**
    * @Fields orderNo : 盘点单号
    */
    private String orderNo;

    /**
     * code: bin信息
     */
    private String code;

    /**
    * @Fields orderType : 盘点类型 0-库存地点 1-物料号
    */
    private java.lang.String orderType;
 
 
    /**
    * @Fields orderStatus : 盘点单状态 0-未盘 1-进行中 2-完成
    */
    private java.lang.String orderStatus;
 
 
    /**
    * @Fields plant : 工厂
    */
    private String plant;
 
 
    /**
    * @Fields warehouseCode : 仓库代码
    */
    private String warehouseCode;
 
 
    /**
    * @Fields warehouseName : 仓库名称
    */
    private String warehouseName;
 
 
    /**
    * @Fields customerModel : 客户描述
    */
    private String customerModel;
 
 
    /**
    * @Fields location :  库存地点
    */
    private String location;
 
 
    /**
    * @Fields materialNo : 物料号
    */
    private String materialNo;
 
 
    /**
    * @Fields materialDesp : 物料描述
    */
    private String materialDesp;
 
 
    /**
    * @Fields unit : 单位
    */
    private String unit;
    private String basicUnit;
 
 
    /**
    * @Fields actualQty : 实际盘点数量
    */
    private Long actualQty;
 
 
    /**
    * @Fields beginDate : 盘点开始时间
    */
    private java.util.Date beginDate=new Date();
 
 
    /**
    * @Fields endDate : 盘点结束时间
    */
    private java.util.Date endDate=new Date();
 
 
    /**
    * @Fields createBy : 创建人
    */
    private String createBy;
 
 
    /**
    * @Fields createDate : 创建日期
    */
    private java.util.Date createDate=new Date();
 
 
    /**
    * @Fields modifyBy : 修改人
    */
    private String modifyBy;
 
 
    /**
    * @Fields modifyDate : 修改日期
    */
    private java.util.Date modifyDate=new Date();
 
 
    /**
    * @Fields flag : 有效标记 0-有效 1-失效
    */
    private java.lang.String flag;
 
 
    /**
    * @Fields version : 版本号
    */
    private Long version;
    
    
    /**
    * @Fields begin : 接收页面传值用 ，  创建日期范围的 左侧
    */
    private String begin;
    
    /**
    * @Fields end : 接收页面传值用 ，  创建日期范围的 右侧
    */
    private String end;
    
    /**  */
	private String userType;
	
	/**  */
	private Long userId;

	 /** 仓位 */
	private String bin;
	
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
     * getOrderNo
     * @return String
     */
    public String getOrderNo() {
        return this.orderNo;
    }
    
    /**
     * setOrderNo
     * @param value
     */
    public void setOrderNo(String value) {
        this.orderNo = value;
    }
    
    /**
     * getOrderType
     * @return String
     */
    public java.lang.String getOrderType() {
        return this.orderType;
    }
    
    /**
     * setOrderType
     * @param value
     */
    public void setOrderType(java.lang.String value) {
        this.orderType = value;
    }
    
    /**
     * getOrderStatus
     * @return String
     */
    public java.lang.String getOrderStatus() {
        return this.orderStatus;
    }
    
    /**
     * setOrderStatus
     * @param value
     */
    public void setOrderStatus(java.lang.String value) {
        this.orderStatus = value;
    }
    
    /**
     * getPlant
     * @return String
     */
    public String getPlant() {
        return this.plant;
    }
    
    /**
     * setPlant
     * @param value
     */
    public void setPlant(String value) {
        this.plant = value;
    }
    
    /**
     * getWarehouseCode
     * @return String
     */
    public String getWarehouseCode() {
        return this.warehouseCode;
    }
    
    /**
     * getWarehouseCode
     * @param value
     */
    public void setWarehouseCode(String value) {
        this.warehouseCode = value;
    }
    
    /**
     * getWarehouseName
     * @return String
     */
    public String getWarehouseName() {
        return this.warehouseName;
    }
    
    /**
     * setWarehouseName
     * @param value
     */
    public void setWarehouseName(String value) {
        this.warehouseName = value;
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
     * getLocation
     * @return String
     */
    public String getLocation() {
        if(location!=null){
            location = location.toUpperCase();
        }
        return location;
    }
    
    /**
     * setLocation
     * @param value
     */
    public void setLocation(String value) {
        this.location = value;
    }
    
    /**
     * getMaterialNo
     * @return String
     */
    public String getMaterialNo() {
        if(materialNo!=null){
            materialNo= materialNo.toUpperCase();
        }
        return materialNo;
    }
    
    /**
     * setMaterialNo
     * @param value
     */
    public void setMaterialNo(String value) {
        this.materialNo = value;
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
     * getUnit
     * @return String
     */
    public String getUnit() {
        return this.unit;
    }
    
    /**
     * setUnit
     * @param value
     */
    public void setUnit(String value) {
        this.unit = value;
    }
    
    /**
     * getActualQty
     * @return Long
     */
    public Long getActualQty() {
        return this.actualQty;
    }
    
    /**
     * setActualQty
     * @param value
     */
    public void setActualQty(Long value) {
        this.actualQty = value;
    }
    
    /**
     * getBeginDate
     * @return Date
     */
    public java.util.Date getBeginDate() {
    	if (beginDate == null){
    		return null;
    	} else {
    		return (Date) this.beginDate.clone();
    	}
    }
    
    /**
     * setBeginDate
     * @param value
     */
    public void setBeginDate(java.util.Date value) {
    	if (value == null){
    		this.beginDate = null;
    	} else {
    		this.beginDate = (Date) value.clone();
    	}
    }
    
    /**
     * getEndDate
     * @return Date
     */
    public java.util.Date getEndDate() {
    	if (endDate == null){
    		return null;
    	} else {
    		return (Date) this.endDate.clone();
    	}
    }
    
    /**
     * setEndDate
     * @param value
     */
    public void setEndDate(java.util.Date value) {
    	if (value == null){
    		this.endDate = null;
    	} else {
    		this.endDate = (Date) value.clone();
    	}
    }
    
    /**
     * getCreateBy
     * @return String
     */
    public String getCreateBy() {
        return this.createBy;
    }
    
    /**
     * setCreateBy
     * @param value
     */
    public void setCreateBy(String value) {
        this.createBy = value;
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
     * @param value
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
        return this.modifyBy;
    }
    
    /**
     * setModifyBy
     * @param value
     */
    public void setModifyBy(String value) {
        this.modifyBy = value;
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
     * @param value
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
        return this.flag;
    }
    
    /**
     * setFlag
     * @param value
     */
    public void setFlag(java.lang.String value) {
        this.flag = value;
    }
    
    /**
     * getVersion
     * @return Long
     */
    public Long getVersion() {
        return this.version;
    }
    
    /**
     * setVersion
     * @param value
     */
    public void setVersion(Long value) {
        this.version = value;
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
	 * getUserId
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getBasicUnit() {
		return basicUnit;
	}

	public void setBasicUnit(String basicUnit) {
		this.basicUnit = basicUnit;
	}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

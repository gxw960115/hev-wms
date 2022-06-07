
package com.haier.openplatform.wms.sto.dto;

import com.haier.openplatform.domain.BaseDomain;

import java.util.Date;

/**
* @Company 青鸟软通
* @Title: StgStoDown
* @Package com.haier.hevwms.order.domain
* @author Liujian
* @date 2015-10-30
* @version V1.0
*/
public class StgStoDownDTO extends BaseDomain<Long> {
    
	private static final long serialVersionUID = 2528338477141826122L;

	/** ID */
 
	private Long rowId;
 
	/** 调拨单号 */
 
	private java.lang.String stoNo;
 
	/** 调拨单行项目 */
 
	private java.lang.String stoItemNo;
 
	/** 发货工厂 */
	
	private java.lang.String bin;
 
	private java.lang.String giPlant;
 
	/** 收货工厂 */
 
	private java.lang.String grPlant;
 
	/** 采购组织 */
 
	private java.lang.String purOrg;
 
	/** 调拨单创建日期 */
 
	private java.lang.String stoDocDate;
 
	/** 调拨单修改日期 */
 
	private java.lang.String stoLastModifyDate;
 
	/** 调拨单创建人 */
 
	private java.lang.String stoCreateBy;
 
	/** 物料号 */
 
	private java.lang.String materialNo;
 
	/** 客户型号：将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号前 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 调拨单数量 */
 
	private Long qty;
 
	/** 行项目删除标记 */
 
	private java.lang.String itemDeltet;
 
	/** STO关闭 */
 
	private java.lang.String stoClose;
 
	/** 收货仓库 */
 
	private java.lang.String grLocation;
 
	/** 收货日期 */
 
	private java.lang.String grDate;
 
	/** 发货仓库 */
 
	private java.lang.String giLocation;
 
	/** 发货日期 */
 
	private java.lang.String giDate;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 版本号 */
 
	private java.lang.Long version;
	
	private String unit;
	
	private String prescanFlag;
	
	private String createBy;
	
	private String modifyBy;
	
	private String begin;
	
	private String end;
    
	private String userType;
    
	private Long userId;
    
	private Long grFinishQty;
    
	private Long giFinishQty;

    private String giFinishFlag;
    
    private String grFinishFlag;
    
    private String flag;
    
    private String checkFlag;
    
    private String stoDnNo;
    
    private String stoType;

    private String comeFromTms;

    /**
     * getGrFinishQty
     * @return Long
     */
	public Long getGrFinishQty() {
		return grFinishQty;
	}

	/**
	 * setGrFinishQty
	 * @param grFinishQty
	 */
	public void setGrFinishQty(Long grFinishQty) {
		this.grFinishQty = grFinishQty;
	}
	
	/**
	 * getGiFinishQty
	 * @return Long
	 */
	public Long getGiFinishQty() {
		return giFinishQty;
	}

	/**
	 * setGiFinishQty
	 * @param giFinishQty
	 */
	public void setGiFinishQty(Long giFinishQty) {
		this.giFinishQty = giFinishQty;
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
	 * getCreateBy
	 * @return String
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * setCreateBy
	 * @param end
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
	 * @param end
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	/**
	 * @Description: 属性 RowId的get方法
	 * @return RowId
	 */
	public Long getRowId() {
		return this.rowId;
	}
	/**
	 * @Description: 属性RowId的set方法
	 * RowId
	 */
	public void setRowId(Long value) {
		this.rowId = value;
	}
	
	/**
	 * @Description: 属性StoNo的get方法
	 * @return StoNo
	 */
	public java.lang.String getStoNo() {
		return this.stoNo;
	}
	/**
	 * @Description: 属性 StoNo的set方法
	 * StoNo
	 */
	public void setStoNo(java.lang.String value) {
		this.stoNo = value;
	}
	
	/**
	 * @Description: 属性 StoItemNo的get方法
	 * @return StoItemNo
	 */
	public java.lang.String getStoItemNo() {
		return this.stoItemNo;
	}
	/**
	 * @Description: 属性StoItemNo的set方法
	 * StoItemNo
	 */
	public void setStoItemNo(java.lang.String value) {
		this.stoItemNo = value;
	}
	
	/**
	 * @Description: 属性 GiPlant的get方法
	 * @return GiPlant
	 */
	public java.lang.String getGiPlant() {
		return this.giPlant;
	}
	/**
	 * @Description: 属性GiPlant的set方法
	 * GiPlant
	 */
	public void setGiPlant(java.lang.String value) {
		this.giPlant = value;
	}
	
	/**
	 * @Description: 属性GrPlant的get方法
	 * @return GrPlant
	 */
	public java.lang.String getGrPlant() {
		return this.grPlant;
	}
	/**
	 * @Description: 属性 GrPlant的set方法
	 * GrPlant
	 */
	public void setGrPlant(java.lang.String value) {
		this.grPlant = value;
	}
	
	/**
	 * @Description: 属性 PurOrg的get方法
	 * @return PurOrg
	 */
	public java.lang.String getPurOrg() {
		return this.purOrg;
	}
	/**
	 * @Description: 属性 PurOrg 的set方法
	 * PurOrg
	 */
	public void setPurOrg(java.lang.String value) {
		this.purOrg = value;
	}
	
	/**
	 * @Description: 属性StoDocDate的get方法
	 * @return StoDocDate
	 */
	public java.lang.String getStoDocDate() {
		return this.stoDocDate;
	}
	/**
	 * @Description: 属性StoDocDate 的set方法
	 * StoDocDate
	 */
	public void setStoDocDate(java.lang.String value) {
		this.stoDocDate = value;
	}
	
	/**
	 * @Description: 属性StoLastModifyDate 的get方法
	 * @return StoLastModifyDate
	 */
	public java.lang.String getStoLastModifyDate() {
		return this.stoLastModifyDate;
	}
	/**
	 * @Description: 属性 StoLastModifyDate的set方法
	 * StoLastModifyDate
	 */
	public void setStoLastModifyDate(java.lang.String value) {
		this.stoLastModifyDate = value;
	}
	
	/**
	 * @Description: 属性StoCreateBy的get方法
	 * @return StoCreateBy
	 */
	public java.lang.String getStoCreateBy() {
		return this.stoCreateBy;
	}
	/**
	 * @Description: 属性 StoCreateBy 的set方法
	 * StoCreateBy
	 */
	public void setStoCreateBy(java.lang.String value) {
		this.stoCreateBy = value;
	}
	
	/**
	 * @Description: 属性 MaterialNo的get方法
	 * @return MaterialNo
	 */
	public java.lang.String getMaterialNo() {
		if(materialNo!=null){
			materialNo = materialNo.toUpperCase();
		}
		return materialNo;
	}
	/**
	 * @Description: 属性 MaterialNo的set方法
	 * MaterialNo
	 */
	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}
	
	/**
	 * @Description: 属性CustomerModel的get方法
	 * @return CustomerModel
	 */
	public String getCustomerModel() {
		return this.customerModel;
	}
	/**
	 * @Description: 属性CustomerModel的set方法
	 * CustomerModel
	 */
	public void setCustomerModel(String value) {
		this.customerModel = value;
	}
	
	/**
	 * @Description: 属性MaterialDesp的get方法
	 * @return MaterialDesp
	 */
	public String getMaterialDesp() {
		return this.materialDesp;
	}
	/**
	 * @Description: 属性MaterialDesp的set方法
	 * MaterialDesp
	 */
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	
	/**
	 * @Description: 属性 Qty的get方法
	 * @return Qty
	 */
	public Long getQty() {
		return this.qty;
	}
	/**
	 * @Description: 属性 Qty的set方法
	 * Qty
	 */
	public void setQty(Long value) {
		this.qty = value;
	}
	
	/**
	 * @Description: 属性 ItemDeltet的get方法
	 * @return ItemDeltet
	 */
	public java.lang.String getItemDeltet() {
		return this.itemDeltet;
	}
	/**
     * @Description: 属性 Qty的ItemDeltet方法
     * ItemDeltet
     */
	public void setItemDeltet(java.lang.String value) {
		this.itemDeltet = value;
	}
	
	/**
	 * @Description: 属性StoClose的get方法
	 * @return StoClose
	 */
	public java.lang.String getStoClose() {
		return this.stoClose;
	}
	/**
     * @Description: 属性StoClose的set方法
     * StoClose
     */
	public void setStoClose(java.lang.String value) {
		this.stoClose = value;
	}
	
	/**
	 * @Description: 属性 GrLocation的get方法
	 * @return GrLocation
	 */
	public java.lang.String getGrLocation() {
		if(grLocation!=null){
			grLocation = grLocation.toUpperCase();
		}
		return grLocation;
	}
	/**
	 * @Description: 属性 GrLocation的set方法
	 * GrLocation
	 */
	public void setGrLocation(java.lang.String value) {
		this.grLocation = value;
	}
	
	/**
	 * @Description: 属性 GrDate的get方法
	 * @return GrDate
	 */
	public java.lang.String getGrDate() {
		return this.grDate;
	}
	/**
	 * @Description: 属性GrDate的set方法
	 * GrDate
	 */
	public void setGrDate(java.lang.String value) {
		this.grDate = value;
	}
	
	/**
	 * @Description: 属性 GiLocation的get方法
	 * @return GiLocation
	 */
	public java.lang.String getGiLocation() {
		if(giLocation!=null){
			giLocation = giLocation.toUpperCase();
		}
		return giLocation;
	}
	/**
	 * @Description: 属性 GiLocation 的set方法
	 * GiLocation
	 */
	public void setGiLocation(java.lang.String value) {
		this.giLocation = value;
	}
	/**
	 * @Description: 属性 GiDate的get方法
	 * @return GiDate
	 */
	public java.lang.String getGiDate() {
		return this.giDate;
	}
	/**
	 * @Description: 属性GiDate的set方法
	 * GiDate
	 */
	public void setGiDate(java.lang.String value) {
		this.giDate = value;
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
	/**
	 * @Description: 属性 Version的get方法
	 * @return Version
	 */
	public java.lang.Long getVersion() {
		return this.version;
	}
	/**
	 * @Description: 属性 Version的set方法
	 * ${param}
	 */
	public void setVersion(java.lang.Long value) {
		this.version = value;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getPrescanFlag() {
		return prescanFlag;
	}

	public void setPrescanFlag(String prescanFlag) {
		this.prescanFlag = prescanFlag;
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
	
	public String getGiFinishFlag() {
		return giFinishFlag;
	}

	public void setGiFinishFlag(String giFinishFlag) {
		this.giFinishFlag = giFinishFlag;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getGrFinishFlag() {
	    return grFinishFlag;
	}

	public void setGrFinishFlag(String grFinishFlag) {
	    this.grFinishFlag = grFinishFlag;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getStoDnNo() {
		return stoDnNo;
	}

	public void setStoDnNo(String stoDnNo) {
		this.stoDnNo = stoDnNo;
	}

	/**
	 * @return the bin
	 */
	public java.lang.String getBin() {
		return bin;
	}

	/**
	 * @param bin the bin to set
	 */
	public void setBin(java.lang.String bin) {
		this.bin = bin;
	}

	public String getStoType() {
		return stoType;
	}

	public void setStoType(String stoType) {
		this.stoType = stoType;
	}

	public String getComeFromTms() {
		return comeFromTms;
	}

	public void setComeFromTms(String comeFromTms) {
		this.comeFromTms = comeFromTms;
	}
}



package com.haier.hevwms.order.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsWmsOrder extends BaseDomain<Long> {
    

	/**
	 * lujian
	 */
	private static final long serialVersionUID = 8603918539483980440L;

	/** 主键 */
 
	private Long rowId;
 
	/** 单据号 */
 
	private String wmsOrderNo;
 
	/** 行项目 */
 
	private java.lang.String wmsOrderItem;
 
	/** 出入库类型 1-入库 2-出库 */
 
	private java.lang.String orderType;
 
	/** 凭证类型 GIFT/SCRAP */
 
	private java.lang.String docTpye;
 
	/** 工厂 */
 
	private String plant;
 
	/** 仓库代码 */
 
	private String warehouseCode;
 
	/** 仓库名称 */
 
	private String warehouseName;
 
	/** 库存地点 */
 
	private String location;
 
	/** 物料号 */
 
	private String materialNo;
 
	/** 客户描述 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 单位 */
 
	private String unit;
 
	/** 供应商编号 */
 
	private String vendorCode;
 
	/** 供应商名称 */
 
	private String vendorName;
 
	/** 送达方编号 */
 
	private String deliveryCode;
 
	/** 送达方名称 */
 
	private String deliveryName;
 
	/** 发货日期 */
 
	private java.util.Date deliveryDate;
 
	/** 创建人 */
 
	private String createBy;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改人 */
 
	private String modifyBy;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate=new Date();
 
	/** 有效标记 0-有效 1-失效 */
 
	private java.lang.String flag;
 
	/** 版本号 */
 
	private Long version;
 
	/** 需求数量 */
 
	private Long requireQty;
 
	/** 关闭标志 0-默认 1-关闭 */
 
	private java.lang.String orderClose;
 
	/** 预扫描标记 0-默认 1-已扫描 */
 
	private java.lang.String presacnFlag;
 
	/** 审核标记 0-未审 1-审核成功 */
 
	private java.lang.String checkFlag;
 
	/** 累计完成数量 */
 
	private Long finishQty;
 
	/** 审核日期 */
 
	private java.util.Date checkDate=new Date();
 
	/** 审核人 */
 
	private java.lang.String checkBy;
 
	/** 完成标志 0-默认 1-完成 */
 
	private java.lang.String finishFlag;
 

    private String begin;
    private String end;
    private String userType;
    private Long userId;
    
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

	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public String getWmsOrderNo() {
		return this.wmsOrderNo;
	}
	
	public void setWmsOrderNo(String value) {
		this.wmsOrderNo = value;
	}
	

	public java.lang.String getWmsOrderItem() {
		return this.wmsOrderItem;
	}
	
	public void setWmsOrderItem(java.lang.String value) {
		this.wmsOrderItem = value;
	}
	

	public java.lang.String getOrderType() {
		return this.orderType;
	}
	
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}
	

	public java.lang.String getDocTpye() {
		return this.docTpye;
	}
	
	public void setDocTpye(java.lang.String value) {
		this.docTpye = value;
	}
	

	public String getPlant() {
		return this.plant;
	}
	
	public void setPlant(String value) {
		this.plant = value;
	}
	

	public String getWarehouseCode() {
		return this.warehouseCode;
	}
	
	public void setWarehouseCode(String value) {
		this.warehouseCode = value;
	}
	

	public String getWarehouseName() {
		return this.warehouseName;
	}
	
	public void setWarehouseName(String value) {
		this.warehouseName = value;
	}
	

	public String getLocation() {
		if(location!=null){
			location = location.toUpperCase();
		}
		return location;
	}
	
	public void setLocation(String value) {
		this.location = value;
	}
	

	public String getMaterialNo() {
		if(materialNo!=null){
			materialNo = materialNo.toUpperCase();
		}
		return materialNo;
	}
	
	public void setMaterialNo(String value) {
		this.materialNo = value;
	}
	

	public String getCustomerModel() {
		return this.customerModel;
	}
	
	public void setCustomerModel(String value) {
		this.customerModel = value;
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
	

	public String getVendorCode() {
		return this.vendorCode;
	}
	
	public void setVendorCode(String value) {
		this.vendorCode = value;
	}
	

	public String getVendorName() {
		return this.vendorName;
	}
	
	public void setVendorName(String value) {
		this.vendorName = value;
	}
	

	public String getDeliveryCode() {
		return this.deliveryCode;
	}
	
	public void setDeliveryCode(String value) {
		this.deliveryCode = value;
	}
	

	public String getDeliveryName() {
		return this.deliveryName;
	}
	
	public void setDeliveryName(String value) {
		this.deliveryName = value;
	}
	

	public java.util.Date getDeliveryDate() {
		if (this.deliveryDate == null){
			return null;
		} else {
			return (Date) this.deliveryDate.clone();
		}
	}
	
	public void setDeliveryDate(java.util.Date value) {
		if (value == null){
			this.deliveryDate = null;
		} else {
			this.deliveryDate = (Date) value.clone();
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
	

	public Long getRequireQty() {
		return this.requireQty;
	}
	
	public void setRequireQty(Long value) {
		this.requireQty = value;
	}
	

	public java.lang.String getOrderClose() {
		return this.orderClose;
	}
	
	public void setOrderClose(java.lang.String value) {
		this.orderClose = value;
	}
	

	public java.lang.String getPresacnFlag() {
		return this.presacnFlag;
	}
	
	public void setPresacnFlag(java.lang.String value) {
		this.presacnFlag = value;
	}
	

	public java.lang.String getCheckFlag() {
		return this.checkFlag;
	}
	
	public void setCheckFlag(java.lang.String value) {
		this.checkFlag = value;
	}
	

	public Long getFinishQty() {
		return this.finishQty;
	}
	
	public void setFinishQty(Long value) {
		this.finishQty = value;
	}
	
	public java.util.Date getCheckDate() {
		if (this.checkDate == null){
			return null;
		} else {
			return (Date) this.checkDate.clone();
		}
	}
	
	public void setCheckDate(java.util.Date value) {
		if (value == null){
			this.checkDate = null;
		} else {
			this.checkDate = (Date) value.clone();
		}
	}

	public java.lang.String getCheckBy() {
		return this.checkBy;
	}
	
	public void setCheckBy(java.lang.String value) {
		this.checkBy = value;
	}
	

	public java.lang.String getFinishFlag() {
		return this.finishFlag;
	}
	
	public void setFinishFlag(java.lang.String value) {
		this.finishFlag = value;
	}

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


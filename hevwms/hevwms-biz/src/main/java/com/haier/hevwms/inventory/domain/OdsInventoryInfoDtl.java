package com.haier.hevwms.inventory.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsInventoryInfoDtl extends BaseDomain<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -444046323561573533L;

	/** 主键 */

	private Long rowId;

	/** 工厂 */

	private String plant;

	/** 仓库代码 */

	private String warehouseCode;

	/** 仓库名称 */

	private String warehouseName;

	/** 客户描述 */

	private String customerModel;

	/** 库存地点 */

	private String location;

	/** 物料号 */

	private String materialNo;

	/** 物料描述 */

	private String materialDesp;

	/** 单位 */

	private String unit;

	/** 条码 */

	private java.lang.String barcode;

	/** 出入库单据号 */

	private String orderNo;

	/** 行项目 */

	private java.lang.String orderItem;

	/** 凭证类型 STO/PO/INB/DN/GIFT/SCRAP/TAKE */

	private java.lang.String docTpye;

	/** SAP凭证单号 */

	private String sapOrderNo;

	/** SAP行项目 */

	private java.lang.String sapOrderItem;

	/** 条码总库龄 */

	private Long totalStockDays;

	/** 条码当前库龄 */

	private Long currentStockDays;

	/** 批次号 */

	private java.lang.String batchNo;

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

	/** 数量 */

	private Long qty;

	/** 占用数量 */

	private Long useQty;

	/** 托盘 */

	private String pallet;

	/** 仓间，库位 */

	private String subLocation;

	private String begin;
	private String end;
	private String userType;
	private Long userId;
	private Long wmsQty;
	private Long sapQty;
	private Date firstInDate;
	
	private String division;
	private String remark;
	private String lockFlag;

	private String bin;
	private String customerFlag;

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(String lockFlag) {
		this.lockFlag = lockFlag;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
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

	public String getCustomerModel() {
		return this.customerModel;
	}

	public void setCustomerModel(String value) {
		this.customerModel = value;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String value) {
		this.location = value;
	}

	public String getMaterialNo() {
		if (this.materialNo != null) {
			this.materialNo = this.materialNo.toUpperCase();
		}
		return this.materialNo;
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

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String value) {
		this.unit = value;
	}

	public java.lang.String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(java.lang.String value) {
		this.barcode = value;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String value) {
		this.orderNo = value;
	}

	public java.lang.String getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(java.lang.String value) {
		this.orderItem = value;
	}

	public java.lang.String getDocTpye() {
		return this.docTpye;
	}

	public void setDocTpye(java.lang.String value) {
		this.docTpye = value;
	}

	public String getSapOrderNo() {
		return this.sapOrderNo;
	}

	public void setSapOrderNo(String value) {
		this.sapOrderNo = value;
	}

	public java.lang.String getSapOrderItem() {
		return this.sapOrderItem;
	}

	public void setSapOrderItem(java.lang.String value) {
		this.sapOrderItem = value;
	}

	public Long getTotalStockDays() {
		return this.totalStockDays;
	}

	public void setTotalStockDays(Long value) {
		this.totalStockDays = value;
	}

	public Long getCurrentStockDays() {
		return this.currentStockDays;
	}

	public void setCurrentStockDays(Long value) {
		this.currentStockDays = value;
	}

	public java.lang.String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(java.lang.String value) {
		this.batchNo = value;
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

	public Long getQty() {
		return this.qty;
	}

	public void setQty(Long value) {
		this.qty = value;
	}

	public Long getUseQty() {
		return this.useQty;
	}

	public void setUseQty(Long value) {
		this.useQty = value;
	}

	public String getPallet() {
		return this.pallet;
	}

	public void setPallet(String value) {
		this.pallet = value;
	}

	public String getSubLocation() {
		return this.subLocation;
	}

	public void setSubLocation(String value) {
		this.subLocation = value;
	}

	public Long getWmsQty() {
		return wmsQty;
	}

	public void setWmsQty(Long wmsQty) {
		this.wmsQty = wmsQty;
	}

	public Long getSapQty() {
		return sapQty;
	}

	public void setSapQty(Long sapQty) {
		this.sapQty = sapQty;
	}

	public Date getFirstInDate() {
		if (firstInDate == null){
			return null;
		} else {
			return (Date) firstInDate.clone();
		}
	}

	public void setFirstInDate(Date firstInDate) {
		if (firstInDate == null){
			this.firstInDate = null;
		} else {
			this.firstInDate = (Date) firstInDate.clone();
		}
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getCustomerFlag() {
		return customerFlag;
	}

	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}
	
	
}

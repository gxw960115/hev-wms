package com.haier.openplatform.wms.inventory.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class OdsInventoryInfoDtlDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	@DateTimeFormat
	private Date createDate;

	/** 修改人 */

	private String modifyBy;

	/** 修改日期 */
	@DateTimeFormat
	private Date modifyDate;

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
	@DateTimeFormat
	private Date firstInDate;

	private String division;
	private String remark;
	private String lockFlag;

	private String bin;
	private String customerFlag;
	//统计纬度
	private String statisticsFlag;

	private String status;
	private String msg;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

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

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(String customerModel) {
		this.customerModel = customerModel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getMaterialDesp() {
		return materialDesp;
	}

	public void setMaterialDesp(String materialDesp) {
		this.materialDesp = materialDesp;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public java.lang.String getBarcode() {
		return barcode;
	}

	public void setBarcode(java.lang.String barcode) {
		this.barcode = barcode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public java.lang.String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(java.lang.String orderItem) {
		this.orderItem = orderItem;
	}

	public java.lang.String getDocTpye() {
		return docTpye;
	}

	public void setDocTpye(java.lang.String docTpye) {
		this.docTpye = docTpye;
	}

	public String getSapOrderNo() {
		return sapOrderNo;
	}

	public void setSapOrderNo(String sapOrderNo) {
		this.sapOrderNo = sapOrderNo;
	}

	public java.lang.String getSapOrderItem() {
		return sapOrderItem;
	}

	public void setSapOrderItem(java.lang.String sapOrderItem) {
		this.sapOrderItem = sapOrderItem;
	}

	public Long getTotalStockDays() {
		return totalStockDays;
	}

	public void setTotalStockDays(Long totalStockDays) {
		this.totalStockDays = totalStockDays;
	}

	public Long getCurrentStockDays() {
		return currentStockDays;
	}

	public void setCurrentStockDays(Long currentStockDays) {
		this.currentStockDays = currentStockDays;
	}

	public java.lang.String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(java.lang.String batchNo) {
		this.batchNo = batchNo;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public java.lang.String getFlag() {
		return flag;
	}

	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getUseQty() {
		return useQty;
	}

	public void setUseQty(Long useQty) {
		this.useQty = useQty;
	}

	public String getPallet() {
		return pallet;
	}

	public void setPallet(String pallet) {
		this.pallet = pallet;
	}

	public String getSubLocation() {
		return subLocation;
	}

	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
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

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getCustomerFlag() {
		return customerFlag;
	}

	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}

	public String getStatisticsFlag() {
		return statisticsFlag;
	}

	public void setStatisticsFlag(String statisticsFlag) {
		this.statisticsFlag = statisticsFlag;
	}
}

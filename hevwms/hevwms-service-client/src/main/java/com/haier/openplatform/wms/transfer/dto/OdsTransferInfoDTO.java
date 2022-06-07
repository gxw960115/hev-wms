package com.haier.openplatform.wms.transfer.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: OdsTransferInfoDTO.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date: 2018年11月7日 下午4:47:32
 * @version V1.0
 */
public class OdsTransferInfoDTO implements Serializable {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	
	private Long rowId;
    private String transNo;
    private String transItemNo;
    private Long qty;
    private String materialNo;
    private String materialDesp;
    private String customerModel;
    private String itemDelete;
    private String unit;
    private String plant;
    private String giLocation;
    private String grLocation;
    private String transClose;
    private String flag;
    private Date createDate;
    private String createBy;
    private Date modifyDate;
    private String modifyBy;
    private String giDate;
    private String giFlag;
    private Long version;
    private Long finishQty;
    private String finishFlag;
    private String orderStatus;
    private String orderType;
    private String warehouseCode;
    private String warehouseName;
    private Date beginDate;
    private Date endDate;
    private String sapFlag;
    private String sapMsg;
    private String sapDocNo;
    private String remark;
    private String prescanFlag;
    private String checkFlag;
    private String checkBy;
    
    private String begin;
    private String end;
    
    private String postingDate;
    private String docNo;
    private String docYear;
    private String basicUnit;
    
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getTransNo() {
		return transNo;
	}
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	public String getTransItemNo() {
		return transItemNo;
	}
	public void setTransItemNo(String transItemNo) {
		this.transItemNo = transItemNo;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
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
	public String getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(String customerModel) {
		this.customerModel = customerModel;
	}
	public String getItemDelete() {
		return itemDelete;
	}
	public void setItemDelete(String itemDelete) {
		this.itemDelete = itemDelete;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getGiLocation() {
		return giLocation;
	}
	public void setGiLocation(String giLocation) {
		this.giLocation = giLocation;
	}
	public String getGrLocation() {
		return grLocation;
	}
	public void setGrLocation(String grLocation) {
		this.grLocation = grLocation;
	}
	public String getTransClose() {
		return transClose;
	}
	public void setTransClose(String transClose) {
		this.transClose = transClose;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		if (createDate == null) {
			this.createDate = null;
		} else {
			this.createDate = (Date) createDate.clone();
		}
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		if (modifyDate == null) {
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) modifyDate.clone();
		}
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public String getGiDate() {
		return giDate;
	}
	public void setGiDate(String giDate) {
		this.giDate = giDate;
	}
	public String getGiFlag() {
		return giFlag;
	}
	public void setGiFlag(String giFlag) {
		this.giFlag = giFlag;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Long getFinishQty() {
		return finishQty;
	}
	public void setFinishQty(Long finishQty) {
		this.finishQty = finishQty;
	}
	public String getFinishFlag() {
		return finishFlag;
	}
	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
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
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		if (beginDate == null) {
			this.beginDate = null;
		} else {
			this.beginDate = (Date) beginDate.clone();
		}
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		if (endDate == null) {
			this.endDate = null;
		} else {
			this.endDate = (Date) endDate.clone();
		}
	}
	public String getSapFlag() {
		return sapFlag;
	}
	public void setSapFlag(String sapFlag) {
		this.sapFlag = sapFlag;
	}
	public String getSapMsg() {
		return sapMsg;
	}
	public void setSapMsg(String sapMsg) {
		this.sapMsg = sapMsg;
	}
	public String getSapDocNo() {
		return sapDocNo;
	}
	public void setSapDocNo(String sapDocNo) {
		this.sapDocNo = sapDocNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPrescanFlag() {
		return prescanFlag;
	}
	public void setPrescanFlag(String prescanFlag) {
		this.prescanFlag = prescanFlag;
	}
	public String getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
	public String getCheckBy() {
		return checkBy;
	}
	public void setCheckBy(String checkBy) {
		this.checkBy = checkBy;
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
	
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	
	
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getDocYear() {
		return docYear;
	}
	public void setDocYear(String docYear) {
		this.docYear = docYear;
	}
	
	public String getBasicUnit() {
		return basicUnit;
	}
	public void setBasicUnit(String basicUnit) {
		this.basicUnit = basicUnit;
	}
	@Override
	public String toString() {
		return "OdsTransferInfoDTO [rowId=" + rowId + ", transNo=" + transNo + ", transItemNo=" + transItemNo + ", qty="
				+ qty + ", materialNo=" + materialNo + ", materialDesp=" + materialDesp + ", customerModel="
				+ customerModel + ", itemDelete=" + itemDelete + ", unit=" + unit + ", plant=" + plant + ", giLocation="
				+ giLocation + ", grLocation=" + grLocation + ", transClose=" + transClose + ", flag=" + flag
				+ ", createDate=" + createDate + ", createBy=" + createBy + ", modifyDate=" + modifyDate + ", modifyBy="
				+ modifyBy + ", giDate=" + giDate + ", giFlag=" + giFlag + ", version=" + version + ", finishQty="
				+ finishQty + ", finishFlag=" + finishFlag + ", orderStatus=" + orderStatus + ", orderType=" + orderType
				+ ", warehouseCode=" + warehouseCode + ", warehouseName=" + warehouseName + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", sapFlag=" + sapFlag + ", sapMsg=" + sapMsg + ", sapDocNo=" + sapDocNo
				+ ", remark=" + remark + ", prescanFlag=" + prescanFlag + ", checkFlag=" + checkFlag + ", checkBy="
				+ checkBy + ", begin=" + begin + ", end=" + end + ", postingDate=" + postingDate + ", docNo=" + docNo
				+ ", docYear=" + docYear + ", basicUnit=" + basicUnit + "]";
	}
	
}

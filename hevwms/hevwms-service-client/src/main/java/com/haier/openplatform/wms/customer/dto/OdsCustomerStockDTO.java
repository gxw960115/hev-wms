package com.haier.openplatform.wms.customer.dto;

import java.io.Serializable;
import java.util.Date;

/**  
 * @Title:  OdsCustomerStockDTO.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:41:56   
 * @version V1.0 
 */  
public class OdsCustomerStockDTO implements Serializable {
    
    /**  
    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
    */
    private static final long serialVersionUID = 1L;

	private Long rowId;
    private String plant;
    private String customerModel;
    private String location;
    private String materialNo;
    private String materialDesp;
    private String unit;
    private String barcode;
    private String orderNo;
    private String orderItem;
    private String docTpye;
    private String sapOrderNo;
    private String sapOrderItem;
    private Long totalStockDays;
    private Long currentStockDays;
    private String batchNo;
    private String createBy;
    private Date createDate;
    private String modifyBy;
    private Date modifyDate;
    private String flag;
    private Long version;
    private Long qty;
    private Long useQty;
    private String pallet;
    private String subLocation;
    private String subLocationFlag;
    private Long batchTime;
    private Date firstInDate;
    private String remark;
    private String lockFlag;
    private String bin;
    
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
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOrderItem() {
        return orderItem;
    }
    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }
    public String getDocTpye() {
        return docTpye;
    }
    public void setDocTpye(String docTpye) {
        this.docTpye = docTpye;
    }
    public String getSapOrderNo() {
        return sapOrderNo;
    }
    public void setSapOrderNo(String sapOrderNo) {
        this.sapOrderNo = sapOrderNo;
    }
    public String getSapOrderItem() {
        return sapOrderItem;
    }
    public void setSapOrderItem(String sapOrderItem) {
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
    public String getBatchNo() {
        return batchNo;
    }
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
    public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    public String getModifyBy() {
        return modifyBy;
    }
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
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
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
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
    public String getSubLocationFlag() {
        return subLocationFlag;
    }
    public void setSubLocationFlag(String subLocationFlag) {
        this.subLocationFlag = subLocationFlag;
    }
    public Long getBatchTime() {
        return batchTime;
    }
    public void setBatchTime(Long batchTime) {
        this.batchTime = batchTime;
    }
    public Date getFirstInDate() {
        return firstInDate;
    }
    public void setFirstInDate(Date firstInDate) {
    	if (firstInDate == null) {
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
    public String getLockFlag() {
        return lockFlag;
    }
    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }
    public String getBin() {
        return bin;
    }
    public void setBin(String bin) {
        this.bin = bin;
    }
    
}
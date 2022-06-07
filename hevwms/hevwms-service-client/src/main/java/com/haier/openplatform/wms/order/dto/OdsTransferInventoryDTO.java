
package com.haier.openplatform.wms.order.dto;

import java.io.Serializable;
import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

/**
 * 311库存转移
 * @author Yan Fengdan
 * @version 2017-11-10 下午2:27:53
 */
public class OdsTransferInventoryDTO extends BaseDomain<Long> implements Serializable {
    
	private static final long serialVersionUID = -7418555206961545312L;

	private Long rowId;//主键
	private String transOrderNo;//移库单号
	private String transItemNo;//移库单行项目号
	private Long qty;//数量
	private String materialNo;//物料号
	private String materialDesp;//物料描述
	private String customerModel;//客户型号
	private String itemDel;//删除标志
	private String unit;//单位
	private String basicUnit;
	private String plant;//工厂=仓库
	private String giLocation;//发货库位
	private String grLocation;//收货库位
	private String flag;//有效标记 0-无效 1-有效
//	private Date createDate;//移库单创建时间
	private java.util.Date createDate=new Date();
//	private String createBy;//移库单创建人
//	private Date modifyDate;//移库单修改时间
	private java.util.Date modifyDate=new Date();
	private String modifyBy;//移库单修改人
	private String giDate;//发货日期 =调用SAP接口的当前时间
	private String giFlag;//发货标志
	private Long version;//版本号
	private String finishQty;//完成数量
	private String finishFlag;//完成标志
	private String orderStatus;//移库单状态  0-未移库 1-进行中 2-完成 3-关闭 4-逻辑删除
	private String orderType;//盘点类型 0-库存地点 1-物料号
	private String warehouseCode;//仓库编码
	private String warehouseName;//仓库名称
	private java.util.Date beginDate=new Date();//开始时间
	private java.util.Date endDate=new Date();//结束时间
	private String transClose;
	
	private String userType;
	private Long userId;
	
	private String sapFlag;//SAP 发货过账标志 0-默认 1-成功 2-失败
	private String sapMsg;//SAP返回消息
	private String sapDocNo;//SAP返回凭证号
	
	private String remark;
	private String prescanFlag;//预扫描标志
	
	private String begin;
	private String end;
	
	/************************  getter/setter 方法  **********************/
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
	 * getTransOrderNo
	 * @return
	 */
	public String getTransOrderNo() {
		return transOrderNo;
	}
	/**
	 * setTransOrderNo
	 * @param transOrderNo
	 */
	public void setTransOrderNo(String transOrderNo) {
		this.transOrderNo = transOrderNo;
	}
	/**
	 * getTransItemNo
	 * @return String
	 */
	public String getTransItemNo() {
		return transItemNo;
	}
	/**
	 * setTransItemNo
	 * @param transItemNo
	 */
	public void setTransItemNo(String transItemNo) {
		this.transItemNo = transItemNo;
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
	 * getGiLocation
	 * @return String
	 */
	public String getGiLocation() {
		return giLocation;
	}
	/**
	 * setGiLocation
	 * @param giLocation
	 */
	public void setGiLocation(String giLocation) {
		this.giLocation = giLocation;
	}
	/**
	 * getGrLocation
	 * @return String
	 */
	public String getGrLocation() {
		return grLocation;
	}
	/**
	 * setGrLocation
	 * @param grLocation
	 */
	public void setGrLocation(String grLocation) {
		this.grLocation = grLocation;
	}
	/**
	 * getFlag
	 * @return String
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * setFlag
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

//	public String getCreateBy() {
//		return createBy;
//	}
//	public void setCreateBy(String createBy) {
//		this.createBy = createBy;
//	}
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
	 * getGiDate
	 * @return String
	 */
	public String getGiDate() {
		return giDate;
	}
	/**
	 * setGiDate
	 * @param giDate
	 */
	public void setGiDate(String giDate) {
		this.giDate = giDate;
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
	 * getOrderStatus
	 * @return String
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * setOrderStatus
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * getOrderType
	 * @return String
	 */
	public java.lang.String getOrderType() {
		return orderType;
	}
	/**
	 * setOrderType
	 * @param orderType
	 */
	public void setOrderType(java.lang.String orderType) {
		this.orderType = orderType;
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
	 * setWarehouseName
	 * @param warehouseName
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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
	 * getItemDel
	 * @return String
	 */
	public String getItemDel() {
		return itemDel;
	}
	/**
	 * setItemDel
	 * @param itemDel
	 */
	public void setItemDel(String itemDel) {
		this.itemDel = itemDel;
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
	/**
	 * getBeginDate
	 * @return Date
	 */
	public java.util.Date getBeginDate() {
		if (beginDate == null){
			return null;
		} else {
			return (Date) beginDate.clone();
		}
	}
	/**
	 * setBeginDate
	 * @param beginDate
	 */
	public void setBeginDate(java.util.Date beginDate) {
		if (beginDate == null){
			this.beginDate = null;
		} else {
			this.beginDate = (Date) beginDate.clone();
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
			return (Date) endDate.clone();
		}
	}
	/**
	 * setEndDate
	 * @param endDate
	 */
	public void setEndDate(java.util.Date endDate) {
		if (endDate == null){
			this.endDate = null;
		} else {
			this.endDate = (Date) endDate.clone();
		}
	}
	/**
	 * getGiFlag
	 * @return String
	 */
	public String getGiFlag() {
		return giFlag;
	}
	/**
	 * setGiFlag
	 * @param giFlag
	 */
	public void setGiFlag(String giFlag) {
		this.giFlag = giFlag;
	}
	/**
	 * getFinishQty
	 * @return String
	 */
	public String getFinishQty() {
		return finishQty;
	}
	/**
	 * setFinishQty
	 * @param finishQty
	 */
	public void setFinishQty(String finishQty) {
		this.finishQty = finishQty;
	}
	/**
	 * getFinishFlag
	 * @return String
	 */
	public String getFinishFlag() {
		return finishFlag;
	}
	/**
	 * setFinishFlag
	 * @param finishFlag
	 */
	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}
	/**
	 * getSapFlag
	 * @return String
	 */
	public String getSapFlag() {
		return sapFlag;
	}
	/**
	 * setSapFlag
	 * @param sapFlag
	 */
	public void setSapFlag(String sapFlag) {
		this.sapFlag = sapFlag;
	}
	/**
	 * getSapMsg
	 * @return String
	 */
	public String getSapMsg() {
		return sapMsg;
	}
	/**
	 * setSapMsg
	 * @param sapMsg
	 */
	public void setSapMsg(String sapMsg) {
		this.sapMsg = sapMsg;
	}
	/**
	 * getSapDocNo
	 * @return String
	 */
	public String getSapDocNo() {
		return sapDocNo;
	}
	/**
	 * setSapDocNo
	 * @param sapDocNo
	 */
	public void setSapDocNo(String sapDocNo) {
		this.sapDocNo = sapDocNo;
	}
	/**
	 * getRemark
	 * @return String
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * setRemark
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * getPrescanFlag
	 * @return String
	 */
	public String getPrescanFlag() {
		return prescanFlag;
	}
	/**
	 * setPrescanFlag
	 * @param prescanFlag
	 */
	public void setPrescanFlag(String prescanFlag) {
		this.prescanFlag = prescanFlag;
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
	 * getTransClose
	 * @return String
	 */
	public String getTransClose() {
		return transClose;
	}
	/**
	 * setTransClose
	 * @param transClose
	 */
	public void setTransClose(String transClose) {
		this.transClose = transClose;
	}
	/**
	 * getBasicUnit
	 * @return String
	 */
	public String getBasicUnit() {
		return basicUnit;
	}
	/**
	 * setBasicUnit
	 * @param basicUnit
	 */
	public void setBasicUnit(String basicUnit) {
		this.basicUnit = basicUnit;
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
}


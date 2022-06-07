package com.haier.openplatform.wms.order.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Company 青鸟软通
 * @Title: StgStoDnDownDTO
 * @Package com.haier.openplatform.wms.order.dto
 * @author 孙艳飞
 * @date 2015-11-24
 * @version V1.0
 */
public class StgStoDnDownDTO implements Serializable {

    /** ID */

    private Long rowId;

    /** 调拨单号 */

    private String stoNo;

    /** 调拨单行项目 */
    private String stoItemNo;

    /** 调拨单发货单 */
    private String stoDnNo;

    /** 调拨发货单行项目 */

    private String stoDnItemNo;

    /** 发货数量 */

    private Long qty;

    /** 物料号 */

    private String materialNo;

    /** 单位 */

    private String unit;

    /** 库存地点 */

    private String location;

    /** SAP消息 */

    private String message;

    /** 发货扫描完成数量 */

    private Long giFinishQty = 0L;

    /** 发货扫描完成状态 */

    private String giFinishFlag;

    /** 发货标志 0-默认 1-发货 */

    private String giFlag;

    /** 收货扫描完成数量 */

    private Long grFinishQty = 0L;

    /** 收货扫描完成状态 */

    private String grFinishFlag;

    /** 收货完成状态 0-默认 1-收货 */

    private String grFlag;

    /** 发货过账标志 0-默认 1-成功 2-失败 */

    private String giSapFlag;

    /** 收货过账标志 0-默认 1-成功 2-失败 */

    private String grSapFlag;

    /** 发货过账失败原因 */

    private String giSapMsg;

    /** 发货过账凭证号 */

    private String giDoc;

    /** 收货过账失败原因 */

    private String grSapMsg;

    /** 收货过账凭证 */

    private String grDoc;

    /** 备注 */

    private String remark;

    /** 有效标志 0-默认 1-有效 */

    private String flag;

    /** 创建人 */

    private String createBy;

    /** 创建日期 */

    private Date createDate;

    /** 更改人 */

    private String modifyBy;

    /** 更改日期 */

    private Date modifyDate;

    /** 开始时间 */

    private String begin;

    /** 结束日期 */

    private String end;

    /** 预扫描标记 0-默认 1-预扫描 */

    private String prescanFlag;

    /** sap返回标志 默认0 成功1 失败2 锁定状态3(stodn posting ) */

    private String sapFlag;

    /** 工厂编码 */
    private String plant;

    private String userType;

    private Long userId;
    
    private String grPlant;
    
    private String grLocation;

    /**
     * @Description: 属性 rowId 的get方法
     * @return Long
     */

    public Long getRowId() {
        return rowId;
    }

    /**
     * @Description: rowId 的set方法
     * @param Long
     *            rowId
     */

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    /**
     * @Description: 属性 stoNo 的get方法
     * @return String
     */

    public String getStoNo() {
        return stoNo;
    }

    /**
     * @Description: stoNo 的set方法
     * @param String
     *            stoNo
     */

    public void setStoNo(String stoNo) {
        this.stoNo = stoNo;
    }

    /**
     * @Description: 属性 stoItemNo 的get方法
     * @return String
     */

    public String getStoItemNo() {
        return stoItemNo;
    }

    /**
     * @Description: stoItemNo 的set方法
     * @param String
     *            stoItemNo
     */

    public void setStoItemNo(String stoItemNo) {
        this.stoItemNo = stoItemNo;
    }

    /**
     * @Description: 属性 stoDnNo 的get方法
     * @return String
     */

    public String getStoDnNo() {
        return stoDnNo;
    }

    /**
     * @Description: stoDnNo 的set方法
     * @param String
     *            stoDnNo
     */

    public void setStoDnNo(String stoDnNo) {
        this.stoDnNo = stoDnNo;
    }

    /**
     * @Description: 属性 stoDnItemNo 的get方法
     * @return String
     */

    public String getStoDnItemNo() {
        return stoDnItemNo;
    }

    /**
     * @Description: stoDnItemNo 的set方法
     * @param String
     *            stoDnItemNo
     */

    public void setStoDnItemNo(String stoDnItemNo) {
        this.stoDnItemNo = stoDnItemNo;
    }

    /**
     * @Description: 属性 qty 的get方法
     * @return Long
     */

    public Long getQty() {
        return qty;
    }

    /**
     * @Description: qty 的set方法
     * @param Long
     *            qty
     */

    public void setQty(Long qty) {
        this.qty = qty;
    }

    /**
     * @Description: 属性 materialNo 的get方法
     * @return String
     */

    public String getMaterialNo() {
        return materialNo;
    }

    /**
     * @Description: materialNo 的set方法
     * @param String
     *            materialNo
     */

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    /**
     * @Description: 属性 unit 的get方法
     * @return String
     */

    public String getUnit() {
        return unit;
    }

    /**
     * @Description: unit 的set方法
     * @param String
     *            unit
     */

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @Description: 属性 location 的get方法
     * @return String
     */

    public String getLocation() {
        return location;
    }

    /**
     * @Description: location 的set方法
     * @param String
     *            location
     */

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @Description: 属性 message 的get方法
     * @return String
     */

    public String getMessage() {
        return message;
    }

    /**
     * @Description: message 的set方法
     * @param String
     *            message
     */

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @Description: 属性 giFinishQty 的get方法
     * @return Long
     */

    public Long getGiFinishQty() {
        return giFinishQty;
    }

    /**
     * @Description: giFinishQty 的set方法
     * @param Long
     *            giFinishQty
     */

    public void setGiFinishQty(Long giFinishQty) {
        this.giFinishQty = giFinishQty;
    }

    /**
     * @Description: 属性 giFinishFlag 的get方法
     * @return String
     */

    public String getGiFinishFlag() {
        return giFinishFlag;
    }

    /**
     * @Description: giFinishFlag 的set方法
     * @param String
     *            giFinishFlag
     */

    public void setGiFinishFlag(String giFinishFlag) {
        this.giFinishFlag = giFinishFlag;
    }

    /**
     * @Description: 属性 giFlag 的get方法
     * @return String
     */

    public String getGiFlag() {
        return giFlag;
    }

    /**
     * @Description: giFlag 的set方法
     * @param String
     *            giFlag
     */

    public void setGiFlag(String giFlag) {
        this.giFlag = giFlag;
    }

    /**
     * @Description: 属性 giSapFlag 的get方法
     * @return String
     */

    public String getGiSapFlag() {
        return giSapFlag;
    }

    /**
     * @Description: giSapFlag 的set方法
     * @param String
     *            giSapFlag
     */

    public void setGiSapFlag(String giSapFlag) {
        this.giSapFlag = giSapFlag;
    }

    /**
     * @Description: 属性 grSapFlag 的get方法
     * @return String
     */

    public String getGrSapFlag() {
        return grSapFlag;
    }

    /**
     * @Description: grSapFlag 的set方法
     * @param String
     *            grSapFlag
     */

    public void setGrSapFlag(String grSapFlag) {
        this.grSapFlag = grSapFlag;
    }

    /**
     * @Description: 属性 giSapMsg 的get方法
     * @return String
     */

    public String getGiSapMsg() {
        return giSapMsg;
    }

    /**
     * @Description: giSapMsg 的set方法
     * @param String
     *            giSapMsg
     */

    public void setGiSapMsg(String giSapMsg) {
        this.giSapMsg = giSapMsg;
    }

    /**
     * @Description: 属性 giDoc 的get方法
     * @return String
     */

    public String getGiDoc() {
        return giDoc;
    }

    /**
     * @Description: giDoc 的set方法
     * @param String
     *            giDoc
     */

    public void setGiDoc(String giDoc) {
        this.giDoc = giDoc;
    }

    /**
     * @Description: 属性 grSapMsg 的get方法
     * @return String
     */

    public String getGrSapMsg() {
        return grSapMsg;
    }

    /**
     * @Description: grSapMsg 的set方法
     * @param String
     *            grSapMsg
     */

    public void setGrSapMsg(String grSapMsg) {
        this.grSapMsg = grSapMsg;
    }

    /**
     * @Description: 属性 grDoc 的get方法
     * @return String
     */

    public String getGrDoc() {
        return grDoc;
    }

    /**
     * @Description: grDoc 的set方法
     * @param String
     *            grDoc
     */

    public void setGrDoc(String grDoc) {
        this.grDoc = grDoc;
    }

    /**
     * @Description: 属性 remark 的get方法
     * @return String
     */

    public String getRemark() {
        return remark;
    }

    /**
     * @Description: remark 的set方法
     * @param String
     *            remark
     */

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @Description: 属性 flag 的get方法
     * @return String
     */

    public String getFlag() {
        return flag;
    }

    /**
     * @Description: flag 的set方法
     * @param String
     *            flag
     */

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @Description: 属性 grFinishQty 的get方法
     * @return Long
     */

    public Long getGrFinishQty() {
        return grFinishQty;
    }

    /**
     * @Description: grFinishQty 的set方法
     * @param Long
     *            grFinishQty
     */

    public void setGrFinishQty(Long grFinishQty) {
        this.grFinishQty = grFinishQty;
    }

    /**
     * @Description: 属性 grFinishFlag 的get方法
     * @return String
     */

    public String getGrFinishFlag() {
        return grFinishFlag;
    }

    /**
     * @Description: grFinishFlag 的set方法
     * @param String
     *            grFinishFlag
     */

    public void setGrFinishFlag(String grFinishFlag) {
        this.grFinishFlag = grFinishFlag;
    }

    /**
     * @Description: 属性 grFlag 的get方法
     * @return String
     */

    public String getGrFlag() {
        return grFlag;
    }

    /**
     * @Description: grFlag 的set方法
     * @param String
     *            grFlag
     */

    public void setGrFlag(String grFlag) {
        this.grFlag = grFlag;
    }

    /**
     * @Description: 属性 createBy 的get方法
     * @return String
     */

    public String getCreateBy() {
        return createBy;
    }

    /**
     * @Description: createBy 的set方法
     * @param String
     *            createBy
     */

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    /**
     * @Description: 属性 modifyBy 的get方法
     * @return String
     */

    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * @Description: modifyBy 的set方法
     * @param String
     *            createDate
     */

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }
    
    /**
     * @Description: 属性 begin 的get方法
     * @return String
     */

    public String getBegin() {
        return begin;
    }

    /**
     * @Description: begin 的set方法
     * @param String
     *            begin
     */

    public void setBegin(String begin) {
        this.begin = begin;
    }

    /**
     * @Description: 属性 end 的get方法
     * @return String
     */

    public String getEnd() {
        return end;
    }

    /**
     * @Description: end 的set方法
     * @param String
     *            end
     */

    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @Description: 属性 prescanFlag 的get方法
     * @return String
     */

    public String getPrescanFlag() {
        return prescanFlag;
    }

    /**
     * @Description: prescanFlag 的set方法
     * @param String
     *            prescanFlag
     */

    public void setPrescanFlag(String prescanFlag) {
        this.prescanFlag = prescanFlag;
    }

    /**
     * @Description: 属性 sapFlag 的get方法
     * @return String
     */

    public String getSapFlag() {
        return sapFlag;
    }

    /**
     * @Description: sapFlag 的set方法
     * @param String
     *            sapFlag
     */

    public void setSapFlag(String sapFlag) {
        this.sapFlag = sapFlag;
    }

    /**
     * @Description: 属性 plant 的get方法
     * @return String
     */

    public String getPlant() {
        return plant;
    }

    /**
     * @Description: plant 的set方法
     * @param String
     *            plant
     */

    public void setPlant(String plant) {
        this.plant = plant;
    }

    /**  
    * @Title: getUserType  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月5日 上午10:38:51 
    */ 
    public String getUserType() {
        return userType;
    }

    /**  
    * @Title: setUserType  
    * @Description: 
    * @param userType 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月5日 上午10:38:54 
    */ 
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**  
    * @Title: getUserId  
    * @Description: 
    * @return 
    * @return Long
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月5日 上午10:38:57 
    */ 
    public Long getUserId() {
        return userId;
    }

    /**  
    * @Title: setUserId  
    * @Description: 
    * @param userId 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月5日 上午10:38:59 
    */ 
    public void setUserId(Long userId) {
        this.userId = userId;
    }

	/**  
	* @Title: getGrPlant  
	* @Description: 
	* @return 
	* @return String
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:02 
	*/ 
	public String getGrPlant() {
		return grPlant;
	}

	/**  
	* @Title: setGrPlant  
	* @Description: 
	* @param grPlant 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:05 
	*/ 
	public void setGrPlant(String grPlant) {
		this.grPlant = grPlant;
	}

	/**  
	* @Title: getGrLocation  
	* @Description: 
	* @return 
	* @return String
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:08 
	*/ 
	public String getGrLocation() {
		return grLocation;
	}

	/**  
	* @Title: setGrLocation  
	* @Description: 
	* @param grLocation 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:10 
	*/ 
	public void setGrLocation(String grLocation) {
		this.grLocation = grLocation;
	}
	/**  
	* @Title: getCreateDate  
	* @Description: 
	* @return 
	* @return java.util.Date
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:14 
	*/ 
	public Date getCreateDate() {
		if (createDate == null){
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}
	/**  
	* @Title: setCreateDate  
	* @Description: 
	* @param value 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:18 
	*/ 
	public void setCreateDate(Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	/**  
	* @Title: getModifyDate  
	* @Description: 
	* @return 
	* @return java.util.Date
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:22 
	*/ 
	public Date getModifyDate() {
		if (modifyDate == null){
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}
	/**  
	* @Title: setModifyDate  
	* @Description: 
	* @param value 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月5日 上午10:39:24 
	*/ 
	public void setModifyDate(Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}
}

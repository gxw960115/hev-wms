package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StgOrdersWhenPDDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:55:15
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class StgOrdersWhenPDDTO implements Serializable {
	
	private static final long serialVersionUID = 6027066974850295130L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 单号
	 */
	private String orderNo;
	/**
	 * 行项目
	 */
	private String orderItem;
	/**
	 * 出入库类型1入库，2出库
	 */
	private String orderType;
	/**
	 * 订单类型PO STO。。。。
	 */
	private String docTpye;
	/**
	 * 物料
	 */
	private String materialNo;
	/**
	 * 工厂
	 */
	private String plant;
	/**
	 * 位置
	 */
	private String locaton;
	/**
	 * 数量
	 */
	private Long qty;
	/**
	 * 已完成量
	 */
	private Long finishQty;
	/**
	 * 完成标记，0未完成，1完成
	 */
	private String finishFlag;

	/**
     * 
     */
	private String createBy;
	/**
     * 
     */
	private Date createDate;
	/**
     * 
     */
	private String modifyBy;
	/**
     * 
     */
	private Date modifyDate;

	private String unit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getDocTpye() {
		return docTpye;
	}

	public void setDocTpye(String docTpye) {
		this.docTpye = docTpye;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getLocaton() {
		return locaton;
	}

	public void setLocaton(String locaton) {
		this.locaton = locaton;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public java.util.Date getCreateDate() {
		if (createDate == null) {
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}

	public void setCreateDate(java.util.Date value) {
		if (value == null) {
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}

	public java.util.Date getModifyDate() {
		if (modifyDate == null) {
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}

	public void setModifyDate(java.util.Date value) {
		if (value == null) {
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}
}

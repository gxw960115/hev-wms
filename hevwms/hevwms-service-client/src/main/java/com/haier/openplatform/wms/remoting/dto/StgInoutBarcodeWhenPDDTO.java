package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StgInoutBarcodeWhenPDDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:57:18
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class StgInoutBarcodeWhenPDDTO implements Serializable {

	private static final long serialVersionUID = -8983152737599490998L;
	
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
	 * 出入库类型 1入库，2出库
	 */
	private String orderType;
	/**
	 * 订单类型 STO DN。。。。
	 */
	private String docTpye;
	/**
	 * 物料号
	 */
	private String materialNo;
	/**
	 * 工厂
	 */
	private String plant;
	/**
	 * 位置
	 */
	private String location;
	/**
	 * 条码
	 */
	private String barcode;
	/**
	 * 扫描数量
	 */
	private Long scanQty;
	/**
	 * 单位
	 */
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Long getScanQty() {
		return scanQty;
	}

	public void setScanQty(Long scanQty) {
		this.scanQty = scanQty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}

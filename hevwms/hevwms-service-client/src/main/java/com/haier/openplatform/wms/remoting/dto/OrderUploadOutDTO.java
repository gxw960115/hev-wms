package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OrderUploadOutDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:58:37
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class OrderUploadOutDTO implements Serializable {

	private static final long serialVersionUID = 6101751903796191928L;
	
	/**
	 * @Fields status : (0:成功/1:失败/2:删除/3:确定location/4:条码带输入数量)
	 */
	private String status;
	/**
	 * @Fields msg : (信息)
	 */
	private String msg;
	/**
	 * @Fields location : (库存地点)
	 */
	private String location;
	/**
	 * @Fields matno : (物料号)
	 */
	private String matno;
	/**
	 * @Fields matdesc : (物料描述)
	 */
	private String matdesc;
	/**
	 * @Fields scanqty : (订单物料累计扫描数量)
	 */
	private String scanqty;
	/**
	 * @Fields poqty : (订单物料需)
	 */
	private String orderqty;

	private String giLocation;
	private String grLocation;
	private String msgPlant;
	private String msgLoc;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMatno() {
		return matno;
	}

	public void setMatno(String matno) {
		this.matno = matno;
	}

	public String getMatdesc() {
		return matdesc;
	}

	public void setMatdesc(String matdesc) {
		this.matdesc = matdesc;
	}

	public String getScanqty() {
		return scanqty;
	}

	public void setScanqty(String scanqty) {
		this.scanqty = scanqty;
	}

	public String getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(String orderqty) {
		this.orderqty = orderqty;
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

	public String getMsgPlant() {
		return msgPlant;
	}

	public void setMsgPlant(String msgPlant) {
		this.msgPlant = msgPlant;
	}

	public String getMsgLoc() {
		return msgLoc;
	}

	public void setMsgLoc(String msgLoc) {
		this.msgLoc = msgLoc;
	}

	@Override
	public String toString() {
		return "OrderUploadOutDTO{" +
				"status='" + status + '\'' +
				", msg='" + msg + '\'' +
				", location='" + location + '\'' +
				", matno='" + matno + '\'' +
				", matdesc='" + matdesc + '\'' +
				", scanqty='" + scanqty + '\'' +
				", orderqty='" + orderqty + '\'' +
				", giLocation='" + giLocation + '\'' +
				", grLocation='" + grLocation + '\'' +
				", msgPlant='" + msgPlant + '\'' +
				", msgLoc='" + msgLoc + '\'' +
				'}';
	}
}

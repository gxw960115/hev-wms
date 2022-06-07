package com.haier.hevwms.remoting.rf.domain.order;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: WmsOrderCarList.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午1:55:05
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class WmsOrderCarList {

	// 车号
	private String carno;

	// 车辆类型
	private String vehicleType;

	// 物流公司
	private String transporterName;

	// 公司代码
	private String transporterCode;

	public String getCarno() {
		return carno;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterCode() {
		return transporterCode;
	}

	public void setTransporterCode(String transporterCode) {
		this.transporterCode = transporterCode;
	}
}

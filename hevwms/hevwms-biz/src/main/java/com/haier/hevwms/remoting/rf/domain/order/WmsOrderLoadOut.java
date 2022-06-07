package com.haier.hevwms.remoting.rf.domain.order;

import java.util.List;

import com.haier.hevwms.remoting.rf.domain.login.Location;

/**
 * @ClassName: OtcwmsOrderLoadOut
 * @Description:
 * @author Song Yinglong // Nicholas
 * @date 2015-11-16 下午2:05:53
 * @param
 */
public class WmsOrderLoadOut {
	private String status; // 是否成功 S 成功 F 失败
	private String msg; // 错误原因描述
	private List<Location> location; // 盘点时返回location列表
	private List<WmsOrderCarList> carlist; // 车号列表*/
	private List<WmsOrderWlList> wlList; // 物料列表

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

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public List<WmsOrderCarList> getCarlist() {
		return carlist;
	}

	public void setCarlist(List<WmsOrderCarList> carlist) {
		this.carlist = carlist;
	}

	public List<WmsOrderWlList> getWlList() {
		return wlList;
	}

	public void setWlList(List<WmsOrderWlList> wlList) {
		this.wlList = wlList;
	}
}

package com.haier.hevwms.remoting.rf.domain.order;

import java.util.List;
import java.util.Map;

public class WmsOrderCheckOut {
	private String status; // 是否成功 S 成功 F 失败
	private String msg; // 错误原因描述
	private List<WmsOrderCarList> carlist; // 车号列表*/
	private List<WmsOrderWlList> wlList; // 物料列表
	private Map<String, String> wlMap;// 库位对应物料

	private String requiredQty;// 手持需要扫描的总数量

	public List<WmsOrderWlList> getWlList() {
		return wlList;
	}

	public void setWlList(List<WmsOrderWlList> wlList) {
		this.wlList = wlList;
	}

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

	public List<WmsOrderCarList> getCarlist() {
		return carlist;
	}

	public void setCarlist(List<WmsOrderCarList> carlist) {
		this.carlist = carlist;
	}

	public String getRequiredQty() {
		return requiredQty;
	}

	public void setRequiredQty(String requiredQty) {
		this.requiredQty = requiredQty;
	}

	public Map<String, String> getWlMap() {
		return wlMap;
	}

	public void setWlMap(Map<String, String> wlMap) {
		this.wlMap = wlMap;
	}
}

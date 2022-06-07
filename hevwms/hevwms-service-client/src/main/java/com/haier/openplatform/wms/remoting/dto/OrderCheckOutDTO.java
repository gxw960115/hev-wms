package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: OtcwmsOrderCheckOutDTO
 * @Description:
 * @author Song Yinglong // Nicholas
 * @date 2015-11-6 下午2:31:32
 * @param
 */
public class OrderCheckOutDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * @Fields status : (是否成功 S-成功 F-失败)
	 */
	private String status;
	/**
	 * @Fields msg : (错误原因描述)
	 */
	private String msg;
	/**
	 * @Fields wlList : (物料列表)
	 */
	private List<OrderMatListDTO> wlList;

	private String requiredQty;// 需要扫描的条码总数量

	private Map<String, String> wlMap;// 库位对应的物料

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

	public List<OrderMatListDTO> getWlList() {
		return wlList;
	}

	public void setWlList(List<OrderMatListDTO> wlList) {
		this.wlList = wlList;
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

	@Override
	public String toString() {
		return "OrderCheckOutDTO [status=" + status + ", msg=" + msg + ", wlList=" + wlList + ", requiredQty="
				+ requiredQty + ", wlMap=" + wlMap + "]";
	}

}

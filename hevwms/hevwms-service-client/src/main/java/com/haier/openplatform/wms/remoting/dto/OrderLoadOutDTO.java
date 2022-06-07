package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: OtcwmsOrderLoadOutDTO
 * @Description: (这里用一句话描述这个类的作用)
 * @author Song Yinglong // Nicholas
 * @date 2015-11-16 下午2:06:14
 * @param
 */
public class OrderLoadOutDTO implements Serializable {
	
	private static final long serialVersionUID = -2972645751540974447L;
	private String status; // 是否成功 S 成功 F 失败
	private String msg; // 错误原因描述
	private List<LocationDTO> location; // 盘点时返回location列表
	private List<OrderMatListDTO> wlList; // 物料列表

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

	public List<LocationDTO> getLocation() {
		return location;
	}

	public void setLocation(List<LocationDTO> location) {
		this.location = location;
	}

	public List<OrderMatListDTO> getWlList() {
		return wlList;
	}

	public void setWlList(List<OrderMatListDTO> wlList) {
		this.wlList = wlList;
	}

}

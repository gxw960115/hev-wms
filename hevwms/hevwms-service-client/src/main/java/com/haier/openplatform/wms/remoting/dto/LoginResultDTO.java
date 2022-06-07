package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: LoginResultDTO 
* @Description: (这里用一句话描述这个类的作用) 
* @author Song Yinglong // Nicholas
* @date 2015-11-5 下午3:45:36 
* @param 
*/ 
public class LoginResultDTO implements Serializable{
	
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields status : (接口调用状态) 
	*/ 
	private String status;
	/** 
	* @Fields msg : (错误原因) 
	*/ 
	private String msg;
	/** 
	* @Fields name : (用户名称) 
	*/ 
	private String name;		 
	/** 
	* @Fields sign : (签名) 
	*/ 
	private String sign;		
	/** 
	* @Fields location : (用仓库编号) 
	*/ 
	private List<LocationDTO> location;	
	/** 
	* @Fields menu : (菜单) 
	*/ 
	private List<MenuDTO> menu;	
	
	private String latestVer;
	
	public List<MenuDTO> getMenu() {
		return menu;
	}
	public void setMenu(List<MenuDTO> menu) {
		this.menu = menu;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public List<LocationDTO> getLocation() {
		return location;
	}
	public void setLocation(List<LocationDTO> location) {
		this.location = location;
	}
	public String getLatestVer() {
		return latestVer;
	}
	public void setLatestVer(String latestVer) {
		this.latestVer = latestVer;
	}
}

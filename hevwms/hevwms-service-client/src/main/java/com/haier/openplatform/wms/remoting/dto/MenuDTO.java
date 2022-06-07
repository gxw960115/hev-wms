package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/** 
* @ClassName: MenuDTO 
* @Description: (这里用一句话描述这个类的作用) 
* @author Song Yinglong // Nicholas
* @date 2015-11-5 下午4:04:19 
* @param 
*/ 
public class MenuDTO implements Serializable{
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields code : (编码) 
	*/ 
	private String code;
	/** 
	* @Fields cdte : (坐标) 
	*/ 
	private String cdte;
	/** 
	* @Fields name : (名称) 
	*/ 
	private String name;
	/** 
	* @Fields url : (URL) 
	*/ 
	private String url;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCdte() {
		return cdte;
	}
	public void setCdte(String cdte) {
		this.cdte = cdte;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}

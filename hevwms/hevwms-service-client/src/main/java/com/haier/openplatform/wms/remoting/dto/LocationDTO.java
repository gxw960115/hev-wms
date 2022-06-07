package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/** 
* @ClassName: LocationDTO 
* @Description: (location) 
* @author Song Yinglong // Nicholas
* @date 2015-11-5 下午4:02:11 
* @param 
*/ 
public class LocationDTO implements Serializable{
	
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields code : (代码) 
	*/ 
	private String code;
	/** 
	* @Fields desc : (描述) 
	*/ 
	private String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}

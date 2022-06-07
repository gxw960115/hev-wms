package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;


/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: WmsOrderIgpOutDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:47:35
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class OrderIgpOutDTO implements Serializable{
	
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields status : (/是否成功 S 成功 F 失败) 
	*/ 
	private String status;
	/** 
	* @Fields msg : (//错误原因描述) 
	*/ 
	private String msg;			
	/** 
	* @Fields orId : (//返回单号数据) 
	*/ 
	private String orId;
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
	public String getOrId() {
		return orId;
	}
	public void setOrId(String orId) {
		this.orId = orId;
	}
	@Override
	public String toString() {
		return "OrderIgpOutDTO [status=" + status + ", msg=" + msg + ", orId=" + orId + "]";
	}		
	
}

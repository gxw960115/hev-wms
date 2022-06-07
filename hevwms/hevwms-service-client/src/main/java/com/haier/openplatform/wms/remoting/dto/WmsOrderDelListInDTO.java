package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: WmsOrderDelListInDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:50:04
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class WmsOrderDelListInDTO implements Serializable {

	private static final long serialVersionUID = 8116960678931387050L;

	private String pagesize = "20";
	private String pageno = "1";
	private String orderNo;
	private String orderType;
	private String docType;
	private String user;
	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getPageno() {
		return pageno;
	}

	public void setPageno(String pageno) {
		this.pageno = pageno;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}

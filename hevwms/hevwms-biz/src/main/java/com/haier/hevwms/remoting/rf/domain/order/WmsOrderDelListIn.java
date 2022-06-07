package com.haier.hevwms.remoting.rf.domain.order;

/**
 * @ClassName: OtcwmsOrderDelListIn
 * @Description: (这里用一句话描述这个类的作用)
 * @author Song Yinglong // Nicholas
 * @date 2015-11-16 下午2:35:25
 * @param
 */
public class WmsOrderDelListIn {
	private String pagesize = "20";
	private String pageno = "1";
	private String orderNo;
	private String orderType;
	private String docType;
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
}

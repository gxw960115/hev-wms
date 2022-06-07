package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderIgpIn {
	private String user;		// 登陆账号
	private String sign;		// 签名
	private String docType;		//单据类型
	private String orderType;	//出入库类型
	private String orno;		//单号
	private String location;	//库存地点
	private String postingdate;	//过账日期
	private String carNo;		//车号
	private String version;		//泰国/巴基斯坦
	
	private String resDt;
    
    private String gooddt;
    
    private String crmdt;
    
    private String reasondt;
    
    private String vehicleType;
	
    private String transpoterName;
	
	private String lrNo;
	
	private String invoiceNo;
	
	private String lrDate;

	private String glAccount;
	private String costCenter;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOrno() {
		return orno;
	}

	public void setOrno(String orno) {
		this.orno = orno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getResDt() {
		return resDt;
	}

	public void setResDt(String resDt) {
		this.resDt = resDt;
	}

	public String getGooddt() {
		return gooddt;
	}

	public void setGooddt(String gooddt) {
		this.gooddt = gooddt;
	}

	public String getCrmdt() {
		return crmdt;
	}

	public void setCrmdt(String crmdt) {
		this.crmdt = crmdt;
	}

	public String getReasondt() {
		return reasondt;
	}

	public void setReasondt(String reasondt) {
		this.reasondt = reasondt;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getTranspoterName() {
		return transpoterName;
	}

	public void setTranspoterName(String transpoterName) {
		this.transpoterName = transpoterName;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	@Override
	public String toString() {
		return "WmsOrderIgpIn [user=" + user + ", sign=" + sign + ", docType=" + docType + ", orderType=" + orderType
				+ ", orno=" + orno + ", location=" + location + ", postingdate=" + postingdate + ", carNo=" + carNo
				+ ", version=" + version + ", resDt=" + resDt + ", gooddt=" + gooddt + ", crmdt=" + crmdt
				+ ", reasondt=" + reasondt + ", vehicleType=" + vehicleType + ", transpoterName=" + transpoterName
				+ ", lrNo=" + lrNo + ", invoiceNo=" + invoiceNo + ", lrDate=" + lrDate + ", glAccount=" + glAccount
				+ ", costCenter=" + costCenter + "]";
	}
	
}

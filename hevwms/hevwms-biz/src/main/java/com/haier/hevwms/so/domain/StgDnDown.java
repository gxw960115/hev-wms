package com.haier.hevwms.so.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class StgDnDown extends BaseDomain<Long> {
	/**
	 * Liujian
	 */
	private static final long serialVersionUID = -8291212114910047601L;

	/** ID */
 
	private Long rowId;
 
	/** 销售DN单号 */
 
	private java.lang.String dnNo;
 
	/** 销售DN行项目 */
 
	private java.lang.String dnItemNo;
 
	/** 销售单号 */
 
	private java.lang.String sellNo;
 
	/** DN类型 发货/退货/寄售出/寄售退/寄售销售 */
 
	private java.lang.String sellOrderType;
 
	/** 工厂 */
 
	private java.lang.String plant;
 
	/** DN单创建日期 */
 
	private java.lang.String dnDocDate;
 
	/** DN单修改日期 */
 
	private java.lang.String dnLastModifyDate;
 
	/** DN单创建人 */
 
	private java.lang.String dnCreateBy;
 
	/** 物料号 */
 
	private java.lang.String materialNo;
 
	/** 客户型号，将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号前 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** DN单数量 */
 
	private Long qty;
 
	/** 库存地点 */
 
	private java.lang.String location;
 
	/** 客户编码 */
 
	private java.lang.String customerNo;
 
	/** 客户名称 */
 
	private String customerName;
 
	/** 送达方编码 */
 
	private java.lang.String deliveryCode;
 
	/** 送达方名称 */
 
	private String deliveryName;
 
	/** 客户要求到货日期 */
 
	private java.lang.String deliveryDate;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 版本号 */
 
	private java.lang.Long version;
	
	private String billing;

	private String billingItem;
	
	private String unit;
    
	private Long finishQty;
    
	private String finishFlag;//完成扫描的标志； 1，完成；
    
	private String createBy;
    
	private String modifyBy;
    
	private String begin;
    
	private String end;
    
	private String userType;
    
	private Long userId;
    
    private String city;
    
    private String region;
    
    private String flag;
    
    //add by linzx @20151130
    /** sap返回标志 默认0 成功1 失败2 锁定状态3 */
    private java.lang.String sapFlag;
    /** sap返回信息 */
    private String sapMsg;
    /** sap凭证号 */
    private java.lang.String sapDocNo;
    /** 传入SAP的ID号 */
    private Long sapSendId;
    /** 手持传入过账日期 */
    private java.lang.String postingDate;
    //汇总成功标记
    private String sapFlag1;
    
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public java.lang.String getDnNo() {
		return this.dnNo;
	}
	
	public void setDnNo(java.lang.String value) {
		this.dnNo = value;
	}
	

	public java.lang.String getDnItemNo() {
		return this.dnItemNo;
	}
	
	public void setDnItemNo(java.lang.String value) {
		this.dnItemNo = value;
	}
	

	public java.lang.String getSellNo() {
		return this.sellNo;
	}
	
	public void setSellNo(java.lang.String value) {
		this.sellNo = value;
	}
	

	public java.lang.String getSellOrderType() {
		return this.sellOrderType;
	}
	
	public void setSellOrderType(java.lang.String value) {
		this.sellOrderType = value;
	}
	

	public java.lang.String getPlant() {
		return this.plant;
	}
	
	public void setPlant(java.lang.String value) {
		this.plant = value;
	}
	

	public java.lang.String getDnDocDate() {
		return this.dnDocDate;
	}
	
	public void setDnDocDate(java.lang.String value) {
		this.dnDocDate = value;
	}
	

	public java.lang.String getDnLastModifyDate() {
		return this.dnLastModifyDate;
	}
	
	public void setDnLastModifyDate(java.lang.String value) {
		this.dnLastModifyDate = value;
	}
	

	public java.lang.String getDnCreateBy() {
		return this.dnCreateBy;
	}
	
	public void setDnCreateBy(java.lang.String value) {
		this.dnCreateBy = value;
	}
	

	public java.lang.String getMaterialNo() {
		if(materialNo!=null){
			materialNo=materialNo.toUpperCase();
		}
		return materialNo;
	}
	
	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}
	

	public String getCustomerModel() {
		return this.customerModel;
	}
	
	public void setCustomerModel(String value) {
		this.customerModel = value;
	}
	

	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	

	public Long getQty() {
		return this.qty;
	}
	
	public void setQty(Long value) {
		this.qty = value;
	}
	

	public java.lang.String getLocation() {
		if(location!=null){
			location = location.toUpperCase();
		}
		return location;
	}
	
	public void setLocation(java.lang.String value) {
		this.location = value;
	}
	

	public java.lang.String getCustomerNo() {
		return this.customerNo;
	}
	
	public void setCustomerNo(java.lang.String value) {
		this.customerNo = value;
	}
	

	public String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(String value) {
		this.customerName = value;
	}
	

	public java.lang.String getDeliveryCode() {
		return this.deliveryCode;
	}
	
	public void setDeliveryCode(java.lang.String value) {
		this.deliveryCode = value;
	}
	

	public String getDeliveryName() {
		return this.deliveryName;
	}
	
	public void setDeliveryName(String value) {
		this.deliveryName = value;
	}
	

	public java.lang.String getDeliveryDate() {
		return this.deliveryDate;
	}
	
	public void setDeliveryDate(java.lang.String value) {
		this.deliveryDate = value;
	}

	public java.util.Date getCreateDate() {
		if (this.createDate == null){
			return null;
		} else {
			return (Date) this.createDate.clone();
		}
	}
	
	public void setCreateDate(java.util.Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	
	public java.util.Date getModifyDate() {
		if (this.modifyDate == null){
			return null;
		} else {
			return (Date) this.modifyDate.clone();
		}
	}
	
	public void setModifyDate(java.util.Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}
	
	public java.lang.Long getVersion() {
		return this.version;
	}
	
	public void setVersion(java.lang.Long value) {
		this.version = value;
	}

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public String getBillingItem() {
		return billingItem;
	}

	public void setBillingItem(String billingItem) {
		this.billingItem = billingItem;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getFinishQty() {
		return finishQty;
	}

	public void setFinishQty(Long finishQty) {
		this.finishQty = finishQty;
	}

	public String getFinishFlag() {
		return finishFlag;
	}

	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

    public java.lang.String getSapFlag() {
        return sapFlag;
    }

    public void setSapFlag(java.lang.String sapFlag) {
        this.sapFlag = sapFlag;
    }

    public String getSapMsg() {
        return sapMsg;
    }

    public void setSapMsg(String sapMsg) {
        this.sapMsg = sapMsg;
    }

    public java.lang.String getSapDocNo() {
        return sapDocNo;
    }

    public void setSapDocNo(java.lang.String sapDocNo) {
        this.sapDocNo = sapDocNo;
    }

    public Long getSapSendId() {
        return sapSendId;
    }

    public void setSapSendId(Long sapSendId) {
        this.sapSendId = sapSendId;
    }

    public java.lang.String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(java.lang.String postingDate) {
        this.postingDate = postingDate;
    }

    public String getSapFlag1() {
        return sapFlag1;
    }

    public void setSapFlag1(String sapFlag1) {
        this.sapFlag1 = sapFlag1;
    }
	

}


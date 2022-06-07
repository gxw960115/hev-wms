
package com.haier.openplatform.wms.order.dto;

import java.io.Serializable;
import java.util.Date;


public class StgDnDownDTO implements Serializable {
	/**
	 * Liujian
	 */
	private static final long serialVersionUID = -8291212114910047601L;

	/** ID */
 
	private Long rowId;
 
	/** 销售DN单号 */
 
	private String dnNo;
 
	/** 销售DN行项目 */
 
	private String dnItemNo;
 
	/** 销售单号 */
 
	private String sellNo;
 
	/** DN类型 发货/退货/寄售出/寄售退/寄售销售 */
 
	private String sellOrderType;
 
	/** 工厂 */
 
	private String plant;
 
	/** DN单创建日期 */
 
	private String dnDocDate;
 
	/** DN单修改日期 */
 
	private String dnLastModifyDate;
 
	/** DN单创建人 */
 
	private String dnCreateBy;
 
	/** 物料号 */
 
	private String materialNo;
 
	/** 客户型号，将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号前 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** DN单数量 */
 
	private Long qty;
 
	/** 库存地点 */
 
	private String location;
 
	/** 客户编码 */
 
	private String customerNo;
 
	/** 客户名称 */
 
	private String customerName;
 
	/** 送达方编码 */
 
	private String deliveryCode;
 
	/** 送达方名称 */
 
	private String deliveryName;
 
	/** 客户要求到货日期 */
 
	private String deliveryDate;
 
	/** 创建日期 */
 
	private Date createDate;
 
	/** 修改日期 */
 
	private Date modifyDate;
 
	/** 版本号 */
 
	private Long version;
	
	/** 关闭标志 默认-0 关闭-1 */
	
	private String dnClose;
	
	/** 发票号 */
	private String billing;

	/** 发票行项目 */
	private String billingItem;
	
	/** 单位 */
	private String unit;
    
	/** 累计完成数量 */
	private Long finishQty;
    
	/** 完成标志 默认-0 关闭-1 */
	private String finishFlag;
    
	/** 创建人 */
	private String createBy;
    
	/** 修改人 */
	private String modifyBy;
    
	/**  */
	private String begin;
    
	/**  */
	private String end;
	
	/**  */
	private String userType;
	
	/**  */
	private Long userId;
	
	/** 城市 */
    private String city;
    
    /** 地区 */
    private String region;
    
    /** 有效标记 0-有效 1-失效 */
    private String flag; 
    
    /** 发货日期 */
    private String deliverDate;
    
    /** 费用生成状态 默认0 成功1 失败2 */
    private String costFlag;
    
    /** 费用生成信息*/
    private String costMsg;
    
  //add by linzx @20151130
    /** sap返回标志 默认0 成功1 失败2 锁定状态3 */
    private String sapFlag;
    /** sap返回信息 */
    private String sapMsg;
    /** sap凭证号 */
    private String sapDocNo;
    /** 传入SAP的ID号 */
    private Long sapSendId;
    /** 手持传入过账日期 */
    private String postingDate;
    //汇总过账成功标记
    private String sapFlag1;
    //关联查出的汇总id
    private String orderInfoId;
    //关联查出的汇总sap_doc_no
    private String orderInfoSapDocNo;
  
    /**
     * getDnClose
     * @return String
     */
	public String getDnClose() {
        return dnClose;
    }

	/**
	 * setDnClose
	 * @param dnClose
	 */
    public void setDnClose(String dnClose) {
        this.dnClose = dnClose;
    }

    /**
     * getDeliverDate
     * @return String
     */
    public String getDeliverDate() {
        return deliverDate;
    }

    /**
     * setDeliverDate
     * @param deliverDate
     */
    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    /**
     * getCostFlag
     * @return String
     */
    public String getCostFlag() {
        return costFlag;
    }

    /**
     * setCostFlag
     * @param costFlag
     */
    public void setCostFlag(String costFlag) {
        this.costFlag = costFlag;
    }

    /**
     * getCostMsg
     * @return String
     */
    public String getCostMsg() {
        return costMsg;
    }

    /**
     * setCostMsg
     * @param costMsg
     */
    public void setCostMsg(String costMsg) {
        this.costMsg = costMsg;
    }

    /**
     * getCity
     * @return String
     */
    public String getCity() {
		return city;
	}

    /**
     * setCity
     * @param city
     */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * getRegion
	 * @return String
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * setRegion
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * getBegin
	 * @return String
	 */
	public String getBegin() {
		return begin;
	}

	/**
	 * setBegin
	 * @param begin
	 */
	public void setBegin(String begin) {
		this.begin = begin;
	}

	/**
	 * getEnd
	 * @return String
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * setEnd
	 * @param end
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * getCreateBy
	 * @return String
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * setCreateBy
	 * @param createBy
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * getModifyBy
	 * @return String
	 */
	public String getModifyBy() {
		return modifyBy;
	}

	/**
	 * setModifyBy
	 * @param modifyBy
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * getRowId
	 * @return Long
	 */
	public Long getRowId() {
		return this.rowId;
	}
	
	/**
	 * setRowId
	 * @param value
	 */
	public void setRowId(Long value) {
		this.rowId = value;
	}
	
	/**
	 * getDnNo
	 * @return String
	 */
	public String getDnNo() {
		return this.dnNo;
	}
	
	/**
	 * setDnNo
	 * @param value
	 */
	public void setDnNo(String value) {
		this.dnNo = value;
	}
	
	/**
	 * getDnItemNo
	 * @return String
	 */
	public String getDnItemNo() {
		return this.dnItemNo;
	}
	
	/**
	 * setDnItemNo
	 * @param value
	 */
	public void setDnItemNo(String value) {
		this.dnItemNo = value;
	}
	
	/**
	 * getSellNo
	 * @return String
	 */
	public String getSellNo() {
		return this.sellNo;
	}
	
	/**
	 * setSellNo
	 * @param value
	 */
	public void setSellNo(String value) {
		this.sellNo = value;
	}
	
	/**
	 * getSellOrderType
	 * @return String
	 */
	public String getSellOrderType() {
		return this.sellOrderType;
	}
	
	/**
	 * setSellOrderType
	 * @param value
	 */
	public void setSellOrderType(String value) {
		this.sellOrderType = value;
	}
	
	/**
	 * getPlant
	 * @return String
	 */
	public String getPlant() {
		return this.plant;
	}
	
	/**
	 * setPlant
	 * @param value
	 */
	public void setPlant(String value) {
		this.plant = value;
	}
	
	/**
	 * getDnDocDate
	 * @return String
	 */
	public String getDnDocDate() {
		return this.dnDocDate;
	}
	
	/**
	 * setDnDocDate
	 * @param value
	 */
	public void setDnDocDate(String value) {
		this.dnDocDate = value;
	}
	
	/**
	 * getDnLastModifyDate
	 * @return String
	 */
	public String getDnLastModifyDate() {
		return this.dnLastModifyDate;
	}
	
	/**
	 * setDnLastModifyDate
	 * @param value
	 */
	public void setDnLastModifyDate(String value) {
		this.dnLastModifyDate = value;
	}
	
	/**
	 * getDnCreateBy
	 * @return String
	 */
	public String getDnCreateBy() {
		return this.dnCreateBy;
	}
	
	/**
	 * setDnCreateBy
	 * @param value
	 */
	public void setDnCreateBy(String value) {
		this.dnCreateBy = value;
	}
	
	/**
	 * getMaterialNo
	 * @return String
	 */
	public String getMaterialNo() {
		if(materialNo!=null){
			materialNo=materialNo.toUpperCase();
		}
		return materialNo;
	}
	
	/**
	 * setMaterialNo
	 * @param value
	 */
	public void setMaterialNo(String value) {
		this.materialNo = value;
	}
	
	/**
	 * getCustomerModel
	 * @return String
	 */ 
	public String getCustomerModel() {
		return this.customerModel;
	}
	
	/**
	 * setCustomerModel
	 * @param value
	 */
	public void setCustomerModel(String value) {
		this.customerModel = value;
	}
	
	/**
	 * getMaterialDesp
	 * @return String
	 */
	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	/**
	 * setMaterialDesp
	 * @param value
	 */
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	
	/**
	 * getQty
	 * @return Long
	 */
	public Long getQty() {
		return this.qty;
	}
	
	/**
	 * setQty
	 * @param value
	 */
	public void setQty(Long value) {
		this.qty = value;
	}
	
	/**
	 * getLocation
	 * @return String
	 */
	public String getLocation() {
		if(location!=null){
			location = location.toUpperCase();
		}
		return location;
	}
	
	/**
	 * setLocation
	 * @param value
	 */
	public void setLocation(String value) {
		this.location = value;
	}
	
	/**
	 * getCustomerNo
	 * @return String
	 */
	public String getCustomerNo() {
		return this.customerNo;
	}
	
	/**
	 * setCustomerNo
	 * @param value
	 */
	public void setCustomerNo(String value) {
		this.customerNo = value;
	}
	
	/**
	 * getCustomerName
	 * @return String
	 */
	public String getCustomerName() {
		return this.customerName;
	}
	
	/**
	 * setCustomerName
	 * @param value
	 */
	public void setCustomerName(String value) {
		this.customerName = value;
	}
	
	/**
	 * getDeliveryCode
	 * @return String
	 */
	public String getDeliveryCode() {
		return this.deliveryCode;
	}
	
	/**
	 * setDeliveryCode
	 * @param value
	 */
	public void setDeliveryCode(String value) {
		this.deliveryCode = value;
	}
	
	/**
	 * getDeliveryName
	 * @return String
	 */
	public String getDeliveryName() {
		return this.deliveryName;
	}
	
	/**
	 * setDeliveryName
	 * @param value
	 */
	public void setDeliveryName(String value) {
		this.deliveryName = value;
	}
	
	/**
	 * getDeliveryDate
	 * @return String
	 */
	public String getDeliveryDate() {
		return this.deliveryDate;
	}
	
	/**
	 * setDeliveryDate
	 * @param value
	 */
	public void setDeliveryDate(String value) {
		this.deliveryDate = value;
	}
	
	/**
	 * getVersion
	 * @return Long
	 */
	public Long getVersion() {
		return this.version;
	}
	
	/**
	 * setVersion
	 * @param value
	 */
	public void setVersion(Long value) {
		this.version = value;
	}

	/**
	 * getBilling
	 * @return String
	 */
	public String getBilling() {
		return billing;
	}

	/**
	 * setBilling
	 * @param billing
	 */
	public void setBilling(String billing) {
		this.billing = billing;
	}

	/**
	 * getBillingItem
	 * @return String
	 */
	public String getBillingItem() {
		return billingItem;
	}

	/**
	 * setBillingItem
	 * @param billingItem
	 */
	public void setBillingItem(String billingItem) {
		this.billingItem = billingItem;
	}

	/**
	 * getUnit
	 * @return String
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * setUnit
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * getFinishQty
	 * @return Long
	 */ 
	public Long getFinishQty() {
		return finishQty;
	}

	/**
	 * setFinishQty
	 * @param finishQty
	 */
	public void setFinishQty(Long finishQty) {
		this.finishQty = finishQty;
	}

	/**
	 * getFinishFlag
	 * @return String
	 */
	public String getFinishFlag() {
		return finishFlag;
	}

	/**
	 * setFinishFlag
	 * @param finishFlag
	 */
	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}

	/**
	 * getUserType
	 * @return String
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * setUserType
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * getUserId
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * setUserId
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * getFlag
	 * @return String
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * setFlag
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * getSapFlag
	 * @return String
	 */
    public String getSapFlag() {
        return sapFlag;
    }

    /**
     * setSapFlag
     * @param sapFlag
     */
    public void setSapFlag(String sapFlag) {
        this.sapFlag = sapFlag;
    }

    /**
     * getSapMsg
     * @return String
     */
    public String getSapMsg() {
        return sapMsg;
    }

    /**
     * setSapMsg
     * @param sapMsg
     */
    public void setSapMsg(String sapMsg) {
        this.sapMsg = sapMsg;
    }

    /**
     * getSapDocNo
     * @return String
     */
    public String getSapDocNo() {
        return sapDocNo;
    }

    /**
     * setSapDocNo
     * @param sapDocNo
     */
    public void setSapDocNo(String sapDocNo) {
        this.sapDocNo = sapDocNo;
    }

    /**
     * getSapSendId
     * @return Long
     */
    public Long getSapSendId() {
        return sapSendId;
    }

    /**
     * setSapSendId
     * @param sapSendId
     */
    public void setSapSendId(Long sapSendId) {
        this.sapSendId = sapSendId;
    }

    /**
     * getPostingDate
     * @return String
     */
    public String getPostingDate() {
        return postingDate;
    }

    /**
     * setPostingDate
     * @param postingDate
     */
    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    /**
     * getSapFlag1
     * @return String
     */
    public String getSapFlag1() {
        // STG_DN_DOWN.SAP_DOC_NO不为空，并且ODS_ORD_INFO表中根据DN_NO查找不出数据的。
        // Posting Success Without Goods Delivery
    	//取消扫描前过账，恢复以前逻辑--20171109
//	if(sapDocNo!=null&&!"".equals(sapDocNo)&&orderInfoId==null){
//            sapFlag1="2";
//            return sapFlag1;
//        }else if(orderInfoId!=null&&orderInfoSapDocNo!=null&&!"".equals(orderInfoSapDocNo)){
//            return "1";//posting success
//        }
//        return "0";
    	return sapFlag1;
    }

    /**
     * setSapFlag1
     * @param sapFlag1
     */
    public void setSapFlag1(String sapFlag1) {
        this.sapFlag1 = sapFlag1;
    }

    /**
     * getOrderInfoId
     * @return String
     */
    public String getOrderInfoId() {
        return orderInfoId;
    }

    /**
     * setOrderInfoId
     * @param orderInfoId
     */
    public void setOrderInfoId(String orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    /**
     * getOrderInfoSapDocNo
     * @return String
     */
    public String getOrderInfoSapDocNo() {
        return orderInfoSapDocNo;
    }

    /**
     * setOrderInfoSapDocNo
     * @param orderInfoSapDocNo
     */
    public void setOrderInfoSapDocNo(String orderInfoSapDocNo) {
        this.orderInfoSapDocNo = orderInfoSapDocNo;
    }
	
	public Date getCreateDate() {
		if (createDate == null){
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}
	public void setCreateDate(Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	public Date getModifyDate() {
		if (modifyDate == null){
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}
	public void setModifyDate(Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}
}


package com.haier.hevwms.basic.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsHistoryLog extends BaseDomain<Long> {
    

	/** 主键 */
 
	private Long rowId;
 
	/** 操作人 */
 
	private java.lang.String operationBy;
 
	/** 操作时间 */
 
	private java.util.Date operationDate;
 
	/** 操作事件代码 */
 
	private java.lang.String operationCode;
 
	/** 操作事件内容 */
 
	private java.lang.String operationContent;
 
	/** 创建人 */
 
	private java.lang.String createBy;
 
	/** 创建时间 */
 
	private java.util.Date createDate;
 


	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public java.lang.String getOperationBy() {
		return this.operationBy;
	}
	
	public void setOperationBy(java.lang.String value) {
		this.operationBy = value;
	}
	

	public java.util.Date getOperationDate() {
		if (this.operationDate == null){
			return null;
		} else {
			return (Date) this.operationDate.clone();
		}
		
	}
	
	public void setOperationDate(java.util.Date value) {
		if (value == null){
			this.operationDate = null;
		} else {
			this.operationDate = (Date) value.clone();
		}
	}
	
	public java.lang.String getOperationCode() {
		return this.operationCode;
	}
	
	public void setOperationCode(java.lang.String value) {
		this.operationCode = value;
	}
	

	public java.lang.String getOperationContent() {
		return this.operationContent;
	}
	
	public void setOperationContent(java.lang.String value) {
		this.operationContent = value;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
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

}


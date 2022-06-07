package com.haier.openplatform.wms.security.domain;

import java.io.Serializable;
import java.util.Date;

public class UploadFile implements Serializable{

	private static final long serialVersionUID = 3054895238305105445L;
	
	private Long id;
	private String fileName;
	private String saveFileName;
	private String filePath1;
	private String filePath2;
	private Integer status;
	private Integer type;
	private String remarks;
	private Date lastModifiedDt;
	private String lastModifiedBy;
	private Date createDt;
	private String createDate;
	private String createBy;
	private String versions;
	private String page;
	private String row;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath1() {
		return filePath1;
	}
	public void setFilePath1(String filePath1) {
		this.filePath1 = filePath1;
	}
	public String getFilePath2() {
		return filePath2;
	}
	public void setFilePath2(String filePath2) {
		this.filePath2 = filePath2;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getLastModifiedDt() {
		if (lastModifiedDt == null){
			return null;
		} else {
			return (Date) lastModifiedDt.clone();
		}
	}
	public void setLastModifiedDt(Date lastModifiedDt) {
		if (lastModifiedDt == null){
			this.lastModifiedDt = null;
		} else {
			this.lastModifiedDt = (Date) lastModifiedDt.clone();
		}
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getCreateDt() {
		if (createDt == null){
			return null;
		} else {
			return (Date) createDt.clone();
		}
	}
	public void setCreateDt(Date createDt) {
		if (createDt == null){
			this.createDt = null;
		} else {
			this.createDt = (Date) createDt.clone();
		}
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getVersions() {
		return versions;
	}
	public void setVersions(String versions) {
		this.versions = versions;
	}
	
}

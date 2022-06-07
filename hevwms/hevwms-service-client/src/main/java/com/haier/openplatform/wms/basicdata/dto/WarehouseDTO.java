package com.haier.openplatform.wms.basicdata.dto;
/**
 * @author Liujian
 */
import java.io.Serializable;
import java.util.Date;

public class WarehouseDTO implements Serializable{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 4347187705861134087L;

	private Long rowId;
    
    /** 名称 */
    private String name;
    
    private String nameFat;
 
    /** 代码 */
    private String code;
 
    /** 创建人 */
 
    private String createBy;
 
    /** 创建日期 */
 
    private java.util.Date createDate;
 
    /** 修改人 */
 
    private String modifyBy;
 
    /** 修改日期 */
 
    private java.util.Date modifyDate;
 
    /** 有效标记 0-有效 1-失效 */
 
    private java.lang.String flag;
 
    /** 版本号 */
 
    private Long version;
    
    private String[] children;
    
    private String locations;
 
    /** 备注 */
    private String remark;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public java.lang.String getFlag() {
        return flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
	public java.util.Date getCreateDate() {
		if (createDate == null){
			return null;
		} else {
			return (Date) createDate.clone();
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
		if (modifyDate == null){
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}
	public void setModifyDate(java.util.Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}
    
    
}

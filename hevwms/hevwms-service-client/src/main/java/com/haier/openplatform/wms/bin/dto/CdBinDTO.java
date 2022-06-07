package com.haier.openplatform.wms.bin.dto;

import java.io.Serializable;
import java.util.Date;

public class CdBinDTO implements Serializable {
    private static final long serialVersionUID = 1913909546139518596L;
    private String rowId;
    /**
     * 编码
     */
    private String code;
    private Date createDate;
    private Date updateDate;
    /**
     * 是否可用 可用为1
     */
    private String flag;
    private String location;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package com.haier.openplatform.showcase.security.domain;

import java.util.Date;

import com.haier.openplatform.log.domain.OperationLog;

/**
* @ClassName: OperationLogSaveModel
* @Description: TODO(记录操作的实体类)
* @author linzongxiao
* @Date 2016-1-19 下午3:41:14
*/
public class OperationLogSaveModel extends OperationLog{
    Date gmtCreate=new Date();
    Date gmtModified=new Date();
    public Date getGmtCreate() {
    	if (gmtCreate == null){
    		return null;
    	}
        return (Date) gmtCreate.clone();
    }
    public void setGmtCreate(Date gmtCreate) {
    	if (gmtCreate == null){
    		this.gmtCreate = null;
    	} else {
    		this.gmtCreate = (Date) gmtCreate.clone();
    	}
    }
    public Date getGmtModified() {
    	if (gmtModified == null){
    		return null;
    	}
        return (Date) gmtModified.clone();
    }
    public void setGmtModified(Date gmtModified) {
    	if (gmtModified == null){
    		this.gmtModified = null;
    	} else {
    		this.gmtModified = (Date) gmtModified.clone();
    	}
    } 
}

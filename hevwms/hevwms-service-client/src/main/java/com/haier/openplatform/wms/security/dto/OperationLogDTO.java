package com.haier.openplatform.wms.security.dto;

import java.io.Serializable;
import java.util.Date;

/**  
* <p>Title: OperationLogDTO</p>  
* <p>Description: </p>  
* @author SJK  
* @date 2018年10月15日  
*/ 
public class OperationLogDTO implements Serializable {
	private static final long serialVersionUID = 1742664541601156646L;
	
	/**
	 * id
	 */
	private long id;
	/**
	 * 操作用户ID
	 */
	private long userId;
	/**
	 * 操作用户名称
	 */
	private String userName;
	/**
	 * 操作用户名字
	 */
	private String userNickName;
	/**
	 * 操作类型
	 */
	private int operationType;
	/**
	 * 所在模块
	 */
	private int module;
	/**
	 * 系统名称
	 */
	private String appName;
	/**
	 * 操作描述
	 */
	private String description;
	/**
	 * 修改前的数据
	 */
	private String originalData;
	/**
	 * 修改后的数据
	 */
	private String actualData;
	/**
	 * 创建时间
	 */
	private Date gmtCreate = new Date();
	/**
	 * 修改时间
	 */
	private Date gmtModified = new Date();
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public int getOperationType() {
		return operationType;
	}
	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}
	public int getModule() {
		return module;
	}
	public void setModule(int module) {
		this.module = module;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOriginalData() {
		return originalData;
	}
	public void setOriginalData(String originalData) {
		this.originalData = originalData;
	}
	public String getActualData() {
		return actualData;
	}
	public void setActualData(String actualData) {
		this.actualData = actualData;
	}
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	} 
    
}

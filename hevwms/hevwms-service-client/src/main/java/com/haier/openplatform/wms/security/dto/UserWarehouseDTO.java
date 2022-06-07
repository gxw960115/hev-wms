package com.haier.openplatform.wms.security.dto;

/**
 * <p>Description: [仓储管理中查找树的domain]</p>
 * Created on 2013-8-18
 * @author  <a href="mailto: chennsh@neusoft.com">陈乃帅</a>
 * @version 1.0
 */
public class UserWarehouseDTO{

	private String id;
	private String name;
	private String code;
	private String ckCd;
	private UserWarehouseDTO parent;
	private String type;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCkCd() {
		return ckCd;
	}
	public void setCkCd(String ckCd) {
		this.ckCd = ckCd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    public UserWarehouseDTO getParent() {
        return parent;
    }
    public void setParent(UserWarehouseDTO parent) {
        this.parent = parent;
    }
	
}

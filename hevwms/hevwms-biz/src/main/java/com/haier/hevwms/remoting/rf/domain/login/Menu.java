package com.haier.hevwms.remoting.rf.domain.login;

import java.io.Serializable;


/**
 * 
 * <p>Description: [RF登录 - 菜单]</p>
 * Created on 2013-8-1
 * @version 1.0
 */
public class Menu implements Serializable{
	/**
    * @Fields serialVersionUID : (用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 1L;
    private String code;// 编码
	private String cdte;// 坐标
	private String name;// 名称
	private String url;// URL
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCdte() {
		return cdte;
	}
	public void setCdte(String cdte) {
		this.cdte = cdte;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

package com.haier.hevwms.sapinterface.config;

import com.haier.openplatform.showcase.util.Env;

/**
 * SAP的配置参数获取基础类
 */
public class HEVWMSSAPConfig {
	
	/**
	 * 属性简要描述 
	 */
	// SAP配置信息，提取数据a
	private String sap_host = Env.getProperty("sap.connection.host"); //SAP IP 地址 
	private String sap_client = Env.getProperty("sap.connection.client"); //SAP 端口号
	private String sap_user = Env.getProperty("sap.connection.user"); //SAP 用户
	private String sap_passwd = Env.getProperty("sap.connection.passwd");//SAP 密码
	private String sap_lang = Env.getProperty("sap.connection.lang"); //SAP 语言
	private String sap_sysnr = Env.getProperty("sap.connection.sysnr"); //SAP 系统编号
	private String sap_group = Env.getProperty("sap.connection.group"); //SAP 组名
	private String sap_r3name = Env.getProperty("sap.connection.r3name"); //SAP 组名
	private String sap_flag = Env.getProperty("sap.connection.flag"); //SAP 是否组登陆
	public String getSap_host() {
		return sap_host;
	}
	public void setSap_host(String sap_host) {
		this.sap_host = sap_host;
	}
	public String getSap_client() {
		return sap_client;
	}
	public void setSap_client(String sap_client) {
		this.sap_client = sap_client;
	}
	public String getSap_user() {
		return sap_user;
	}
	public void setSap_user(String sap_user) {
		this.sap_user = sap_user;
	}
	public String getSap_passwd() {
		return sap_passwd;
	}
	public void setSap_passwd(String sap_passwd) {
		this.sap_passwd = sap_passwd;
	}
	public String getSap_lang() {
		return sap_lang;
	}
	public void setSap_lang(String sap_lang) {
		this.sap_lang = sap_lang;
	}
	public String getSap_sysnr() {
		return sap_sysnr;
	}
	public void setSap_sysnr(String sap_sysnr) {
		this.sap_sysnr = sap_sysnr;
	}
	public String getSap_group() {
		return sap_group;
	}
	public void setSap_group(String sap_group) {
		this.sap_group = sap_group;
	}
	public String getSap_r3name() {
		return sap_r3name;
	}
	public void setSap_r3name(String sap_r3name) {
		this.sap_r3name = sap_r3name;
	}
	public String getSap_flag() {
		return sap_flag;
	}
	public void setSap_flag(String sap_flag) {
		this.sap_flag = sap_flag;
	}
	
	
}

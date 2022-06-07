package com.haier.hevwms.remoting.rf.domain.login;

import java.io.Serializable;

/**
 * <p>Description: [手持RF - 登录 - 用户location]</p>
 * Created on 2013-10-16
 * create  by lichunhui
 * @version 1.0
 */
public class Location implements Serializable{
	/**
    * @Fields serialVersionUID : (用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 1L;
    private String code;// 代码
	private String desc;// 描述
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}

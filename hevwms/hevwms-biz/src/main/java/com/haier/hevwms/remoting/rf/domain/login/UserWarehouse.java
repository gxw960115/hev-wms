package com.haier.hevwms.remoting.rf.domain.login;

/**
 * <p>Description: [手持RF - 登录 - 用户仓库编码]</p>
 * Created on 2013-07-26
 * @version 1.0
 */
public class UserWarehouse {
	private Long userid;// 用户ID
	private Long ckid;// 仓库ID
	private String ckcd;// 仓库代码
	private String cknm;// 仓库名称
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getCkid() {
		return ckid;
	}
	public void setCkid(Long ckid) {
		this.ckid = ckid;
	}
	public String getCkcd() {
		return ckcd;
	}
	public void setCkcd(String ckcd) {
		this.ckcd = ckcd;
	}
	public String getCknm() {
		return cknm;
	}
	public void setCknm(String cknm) {
		this.cknm = cknm;
	}
}

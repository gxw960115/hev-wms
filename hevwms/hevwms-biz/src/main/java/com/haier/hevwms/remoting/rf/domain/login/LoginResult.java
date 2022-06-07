package com.haier.hevwms.remoting.rf.domain.login;

import java.util.List;

/**
 * <p>Description: [手持RF 登录 出参 pojo]</p>
 * Created on 2013-10-16
 * Create  by lichunhui
 * @version 1.0
 */
public class LoginResult {
	private String status;		// 接口调用状态
	private String msg;			// 错误原因
	private String name;		// 用户名称
	private String nickName;    //昵称
	private String sign;		// 签名
	private List<Location> location;	// 仓库编号
	private List<Menu> menu;	//菜单
	private String latestVer;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
     * @Description: 属性 nickName 的get方法
     * @return nickName
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * @Description: 属性 nickName 的set方法
     * nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public List<Location> getLocation() {
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	public String getLatestVer() {
		return latestVer;
	}
	public void setLatestVer(String latestVer) {
		this.latestVer = latestVer;
	}

}

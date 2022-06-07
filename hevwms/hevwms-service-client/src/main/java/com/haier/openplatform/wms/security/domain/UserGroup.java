package com.haier.openplatform.wms.security.domain;

import java.io.Serializable;

import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * @author WangXuzheng
 *
 */
public class UserGroup implements Serializable {
	private static final long serialVersionUID = -1081077809336028156L;
	private UserDTO user = new UserDTO();
	private GroupDTO group = new GroupDTO();
	private Integer admin;
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public GroupDTO getGroup() {
		return group;
	}
	public void setGroup(GroupDTO group) {
		this.group = group;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
}

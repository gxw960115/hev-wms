package com.haier.openplatform.wms.security.domain;

import java.io.Serializable;

import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;

/**
 * @author WangXuzheng
 *
 */
public class RoleGroup implements Serializable{
	private static final long serialVersionUID = -1357378382933302937L;
	private RoleDTO role = new RoleDTO();
	private GroupDTO group = new GroupDTO();
	public RoleDTO getRole() {
		return role;
	}
	public void setRole(RoleDTO role) {
		this.role = role;
	}
	public GroupDTO getGroup() {
		return group;
	}
	public void setGroup(GroupDTO group) {
		this.group = group;
	}
}

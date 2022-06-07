package com.haier.openplatform.wms.security.dto;

import java.util.HashSet;
import java.util.Set;

import com.haier.openplatform.domain.BaseDomain;

/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
public class GroupDTO extends BaseDomain<Long>{ 
	private static final long serialVersionUID = -4502159145110404481L;
	private String description; 
	private String name; 
	private Set<UserDTO> users = new HashSet<UserDTO>();
	private Set<RoleDTO> roles = new HashSet<RoleDTO>();
	
	public Set<RoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}
	public Set<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	} 
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

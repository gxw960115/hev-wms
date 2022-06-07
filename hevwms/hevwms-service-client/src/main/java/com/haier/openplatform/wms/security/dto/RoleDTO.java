package com.haier.openplatform.wms.security.dto;

import java.util.HashSet;
import java.util.Set;

import com.haier.openplatform.domain.BaseDomain;

/**
 * 角色
 * @author WangXuzheng
 *
 */
public class RoleDTO extends BaseDomain<Long> {
	private static final long serialVersionUID = -3028144700670190729L;
	private String name;
	private String description;
	private Set<ResourceDTO> resources = new HashSet<ResourceDTO>();
	private Set<UserDTO> users = new HashSet<UserDTO>();
	private String resourceIds;
	private String groupId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    public Set<ResourceDTO> getResources() {
        return resources;
    }
    public void setResources(Set<ResourceDTO> resources) {
        this.resources = resources;
    }
    public Set<UserDTO> getUsers() {
        return users;
    }
    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }
	public String getResourceIds() {
		return resourceIds;
	}
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
}

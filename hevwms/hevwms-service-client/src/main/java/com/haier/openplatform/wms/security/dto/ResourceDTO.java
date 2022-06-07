/**
* @Company 青鸟软通
* @Title: Resource.java
* @Package com.haier.openplatform.showcase.security.domain
* @author Lynn
* @date 2015-10-30 下午2:02:22
* @version V1.0
*/
package com.haier.openplatform.wms.security.dto;

import java.util.HashSet;
import java.util.Set;

import com.haier.openplatform.domain.BaseDomain;

public class ResourceDTO extends BaseDomain<Long> {
	private static final long serialVersionUID = -5758000946045547080L;
	private ResourceDTO parent;
	//private Long id;
	private Long parentId;
	private String name;
	private String code;
	private String description;
	private String url;
	private Integer type;
	private Integer status;
	private String moduleName;
	private String configuration;
	private Integer orderIndex;
	private Set<RoleDTO> roles = new HashSet<RoleDTO>();
	private Set<ResourceDTO> childResources = new HashSet<ResourceDTO>();
	private String iconUrl;
	private String typeDesc;
	private String statusDesc;
	
	/*public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }*/
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
    public ResourceDTO getParent() {
        return parent;
    }
    public void setParent(ResourceDTO parent) {
        this.parent = parent;
    }
    public Set<RoleDTO> getRoles() {
        return roles;
    }
    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
    public Set<ResourceDTO> getChildResources() {
        return childResources;
    }
    public void setChildResources(Set<ResourceDTO> childResources) {
        this.childResources = childResources;
    }
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
}

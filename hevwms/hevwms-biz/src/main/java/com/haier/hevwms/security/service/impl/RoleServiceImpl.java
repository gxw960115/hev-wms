package com.haier.hevwms.security.service.impl;

import io.terminus.pampas.common.UserUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.security.dao.ResourceDAO;
import com.haier.hevwms.security.dao.RoleDAO;
import com.haier.hevwms.security.service.ResourceService;
import com.haier.hevwms.security.service.RoleService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;

/**
 * @author WangXuzheng
 *
 */
public class RoleServiceImpl implements RoleService {
    Logger logger = Logger.getLogger(RoleServiceImpl.class);
	
	private RoleDAO roleDAO;
	private ResourceDAO resourceDAO;
	private ResourceService resourceService;

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	@Override
	public ExecuteResult<RoleDTO> createRole(RoleDTO role) {
        logger.debug("Entering createRole...");
        ExecuteResult<RoleDTO> executeResult = new ExecuteResult<RoleDTO>();
        RoleDTO dbRole = roleDAO.getRoleByName(StringUtils.trim(role.getName()));
		if(dbRole != null){
			executeResult.addErrorMessage("name" + "[" + role.getName() + "]" + "already.exist");
			return executeResult;
		}
		resetResource(role);
		role.setName(StringUtils.trim(role.getName()));
		role.setGmtCreate(new Date());
		role.setGmtModified(new Date());
		role.setCreateBy(UserUtil.getCurrentUser().getName());//获取登录信息
		role.setLastModifiedBy(UserUtil.getCurrentUser().getName());
		roleDAO.save(role);
		saveRoleResource(role.getId(),role.getResources());
		executeResult.setResult(role);
        logger.debug("Exiting createRole...");
		return executeResult;
	}

	private void resetResource(RoleDTO role) {
		if(role.getResources() == null || role.getResources().isEmpty()){
			role.setResources(null);
		}else{
			final Set<ResourceDTO> permissions = role.getResources();
			role.setResources(new HashSet<ResourceDTO>());
			for(ResourceDTO res : permissions){
				ResourceDTO p = resourceDAO.getResourceById(res.getId());
				role.getResources().add(p);
			}
		}
	}

	@Override
	public ExecuteResult<RoleDTO> updateRole(RoleDTO role) {
	    logger.debug("Entering updateRole...");
        if (role == null) {
            logger.error("Role is null, return...");
            return null;
        }
	    ExecuteResult<RoleDTO> executeResult = new ExecuteResult<RoleDTO>();
		RoleDTO dbRole = roleDAO.getRoleById(role.getId());
		if(dbRole == null){
	        logger.error("No record found for role_id " + role.getId());
			executeResult.addErrorMessage("update.role.role.not.exist");
			return executeResult;
		}
		if(!dbRole.getName().equals(role.getName())){
			if(roleDAO.getRoleByName(role.getName()) != null){
				executeResult.addErrorMessage("role.name" + 
						"[" + role.getName() + "]" + "already.exist");
				return executeResult;
			}
		}
		//resetResource(role);
		dbRole.setLastModifiedBy(UserUtil.getCurrentUser().getName());//获取登录信息
		dbRole.setGmtModified(new Date());
		dbRole.setDescription(role.getDescription());
		dbRole.setName(role.getName());
		dbRole.setResources(role.getResources());
		//先删除角色对应的资源关系
		delRoleResource(role.getId());
		//再重新增加角色对应的资源关系
		saveRoleResource(role.getId(),role.getResources());
		roleDAO.update(dbRole);
		return executeResult;
	}
	
	
	private Integer delRoleResource(Long roleId){
		return roleDAO.delRoleResourcce(roleId);
	}
	
	private void saveRoleResource(Long roleId,Set<ResourceDTO> resSet){
	    logger.debug("Entering saveRoleResource, role_id: " + roleId + "...");
	    if(resSet == null || resSet.isEmpty()){
	        logger.debug("Resource is null, return...");
	        return ;
		}
		for(ResourceDTO res : resSet){
	        logger.debug("Resource info: " + res);
			 roleDAO.saveRoleResourcce(roleId, res.getId());
		}
	}

	@Override
	public ExecuteResult<RoleDTO> deleteRole(Long roleId) {
		ExecuteResult<RoleDTO> executeResult = new ExecuteResult<RoleDTO>();
		RoleDTO role = roleDAO.getRoleById(roleId);
		List<ResourceDTO> resList = resourceService.getResourceByRole(new Long[]{roleId});
		if(role == null){
			executeResult.addWarningMessage("delete.role.role.already.delete");
			return executeResult;
		}
		role.setResources(new HashSet<ResourceDTO>(resList));
		if(role.getResources() != null && !role.getResources().isEmpty()){
			executeResult.addErrorMessage("delete fail,the role " + "[" + role.getName() + 
					"]" + " has " + role.getResources().size() + " children");
			return executeResult;
		}
		roleDAO.delete(roleId);
		return executeResult;
	}

	@Override
	public RoleDTO getRoleById(Long roleId) {
		return roleDAO.getRoleById(roleId);
	}

	@Override
	public Pager<RoleDTO> searchRoles(Pager<RoleDTO> pager, RoleDTO role) {
		List<RoleDTO> roles = roleDAO.searchRoles(pager, role);
		long size = roleDAO.searchRolesCount(role);
		return Pager.cloneFromPager(pager, size, roles);
	}

	@Override
	public List<RoleDTO> getRoles() {
		return roleDAO.getAllRole();
	}

	@Override
	public Pager<RoleDTO> getRolesByGroupId(Pager<RoleDTO> pager, RoleDTO role) {
		List<RoleDTO> roles = roleDAO.getRolesByGroupId(pager, role);
		long size = roleDAO.getRolesByGroupIdCount(role);
		return Pager.cloneFromPager(pager, size, roles);
	}

    @Override
    public List<RoleDTO> getRoleResources(long roleId) {
        return roleDAO.getRoleResources(roleId);
    }
}

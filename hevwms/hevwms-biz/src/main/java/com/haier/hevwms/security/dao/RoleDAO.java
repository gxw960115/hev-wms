package com.haier.hevwms.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.RoleDTO;

/**
 * 角色DAO
 * @author WangXuzheng
 *
 */
public interface RoleDAO extends CommonDAO<RoleDTO,Long> {
	
	/**
	 * 根据id查询角色
	 * @param id
	 * @param languageCode
	 * @return
	 */
	public RoleDTO getRoleById(@Param("id")Long id);
	/**
	 * 查询所有角色
	 * @param languageCode
	 * @return
	 */
	public List<RoleDTO> getAllRole();
	/**
	 * 查询角色信息
	 * @param searchModel
	 * @param languageCode
	 * @return
	 */
	public List<RoleDTO> searchRoles(@Param("pager") Pager<RoleDTO> pager, @Param("role")RoleDTO role);
	public Long searchRolesCount(@Param("role")RoleDTO role);
	
	/**
	 * 通过名称查询role信息
	 * @param name
	 * @param languageCode
	 * @return
	 */
	public RoleDTO getRoleByName(@Param("name")String name);
	/**
	 * 根据组ID获取组内的角色
	 * @param userid
	 * @param languageCode
	 * @return
	 */
	public List<RoleDTO> getRolesByGroupId(@Param("pager")Pager<RoleDTO> pager, @Param("role")RoleDTO role);
	public Long getRolesByGroupIdCount(@Param("role")RoleDTO role);
	
	/**
	 * 删除角色对应的资源
	 * @param roleId
	 */
	public Integer delRoleResourcce(@Param("roleId")Long roleId);
	/**
	 * 新增角色和资源对应关系
	 * @param roleId
	 * @param resourceId
	 */
	public Integer saveRoleResourcce(@Param("roleId")Long roleId,@Param("resourceId")Long resourceId);
	public List<RoleDTO> getRoleResources(@Param("roleId")Long roleId);
	
	public List<RoleDTO> getRoleResourceById(@Param("roleId")Long roleId, @Param("resourceId")Long resourceId);
}

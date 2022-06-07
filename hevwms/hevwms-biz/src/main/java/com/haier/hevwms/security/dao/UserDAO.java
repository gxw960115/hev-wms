package com.haier.hevwms.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * 用户接口
 * @author WangXuzheng
 *
 */
public interface UserDAO extends CommonDAO<UserDTO,Long>{
	
	public UserDTO get(@Param("id")Long id);
	/**
	 * 通过用户
	 * @param id
	 * @return
	 */
	public UserDTO getUserByName(@Param("name") String name);
	
	public List<UserDTO> searchUser(@Param("pager") Pager<UserDTO> pager, @Param("user")UserDTO user);
	public Long searchUserCount(@Param("user")UserDTO user);
	
	/**
	 * 查询部门下的员工列表
	 * @param departmentId
	 * @return
	 */
	public List<UserDTO> getDepartmentUsers(@Param("departmentId")long departmentId);
	
	public List<UserDTO> getUsersByGroupId(@Param("pager") Pager<UserDTO> pager, @Param("user")UserDTO user);
	public Long getUsersByGroupIdCount(@Param("user")UserDTO user);
	/**
	 * 删除用户对应的部门
	 * @param roleId
	 */
	public Integer delUserDepartment(@Param("userId")Long userId);
	/**
	 * 新增角色和资源对应关系
	 * @param roleId
	 * @param resourceId
	 */
	public Integer saveUserDepartment(@Param("userId")Long userId,@Param("departmentId")Long departmentId);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public Integer saveUserWhLoc(@Param("userId")Long userId,@Param("userType")String userType,@Param("locId")Long locId,@Param("locCode")String locCode,@Param("whId")Long whId);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public Integer deleteUserWhLoc(@Param("userId")Long userId);
	/**
	* @Title: mergeUserLogin
	* @Description: 用户登录
	* @param @param user
	* @param @return
	* @return ExecuteResult<UserDTO>
	* @throws
	 */
	public UserDTO mergeUserLogin(UserDTO user);
	
	/**
	* @Title: getExpiredList
	* @Description: 获取两个月未登录用户列表
	* @param @param user
	* @param @return
	* @return ExecuteResult<UserDTO>
	* @throws
	 */
	public List<UserDTO> getExpiredList();
	
}

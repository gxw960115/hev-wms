package com.haier.hevwms.security.service;

import java.util.List;

import com.haier.openplatform.security.LoginContext;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.UserDTO;

public interface UserService {
	/**
	 * 创建用户信息
	 * @param user
	 * @return
	 */
	public ExecuteResult<UserDTO> createUser(UserDTO user);
	
	/**
	 * 根据用户id获取用户信息
	 * @param id
	 * @return
	 */
	public UserDTO getUserById(Long id);
	
	/**
	 * 查询用户信息
	 * @param userSearchModel
	 * @return
	 */
	public Pager<UserDTO> searchUser(Pager<UserDTO> pager, UserDTO user);
	
	/**
	 * 删除用户信息
	 * @param userId 用户id，不允许为空
	 * @return
	 */
	public ExecuteResult<?> deleteUser(Long userId); 
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public ExecuteResult<UserDTO> updateUser(UserDTO user);
	
	/**
	 * 用户登录操作
	 * @param userName
	 * @param password
	 * @return
	 */
	public ExecuteResult<UserDTO> login(String userName,String password,String ipAddress);
	/**
	 * 更新密码
	 * @param userId
	 * @param password
	 */
	public void updatePassword(Long userId,String password);
	
	/**
	 * 判断用户密码是否需要提醒
	 * @param user
	 * @return
	 */
	public ExecuteResult<Boolean> shouldTipPassword(UserDTO user);
	
	/**
	 * 用户登出操作
	 * @param context
	 * @return
	 */
	public ExecuteResult<UserDTO> logout(LoginContext context);
	/**
	 * 检测用户输入的用户名、邮箱是否对应
	 * @param name
	 * @return
	 */
	public ExecuteResult<UserDTO> getUserEmailByName(String name,String email);
	/**
	 * 检测用户找回密码的URL是否正常
	 * @param name 
	 * @param encode
	 * @return
	 */
	public ExecuteResult<UserDTO> confirmUpdatePassword(String name,String encode,String password,String confirmpassword);
	/**
	 * 更新用户的Ecode
	 * @param name
	 * @return
	 */
	public ExecuteResult<UserDTO> updateUserEncode(String name);
	/**
	 * 获取用户还有多少天过期
	 * @param user
	 * @return
	 */
	public String getExpiredDate(UserDTO user); 
	/**
	 * 根据用户名获取用户信息
	 * @param user
	 * @return
	 */
	public UserDTO getUserByName(String name);
	/**
	 * 获取所有用户信息
	 * @param user
	 * @return
	 */
	public List<UserDTO> getAll();
	/**
	 * 更新失效账号信息
	 * @param user
	 * @return
	 */
	public ExecuteResult<UserDTO> updateExpiredUser(UserDTO user);
	/**
	 * 根据组ID查询组内用户
	 * @param
	 * @return
	 */
	public Pager<UserDTO> getUsersByGroupId(Pager<UserDTO> pager, UserDTO user); 
	/**
	 *
	* @Title: mergeUserLogin
	* @Description:  用户登录
	* @param @param user
	* @param @return
	* @return ExecuteResult<UserDTO>
	* @throws
	 */
	public ExecuteResult<UserDTO> mergeUserLogin(UserDTO user);
	
	/**
	* @Title: getExpiredList
	* @Description: 获取两个月未登录用户列表
	* @param @param user
	* @param @return
	* @return ExecuteResult<UserDTO>
	* @throws
	 */
	public void lockExpiredUsers();
}

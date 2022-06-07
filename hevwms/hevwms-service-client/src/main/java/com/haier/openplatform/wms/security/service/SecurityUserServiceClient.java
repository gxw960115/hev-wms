package com.haier.openplatform.wms.security.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
public interface SecurityUserServiceClient {

	/** 
	* @Title: createUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param user
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"user"})
	public String createUser(UserDTO user);

	/** 
	* @Title: searchUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param user
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<UserDTO>    返回类型 
	* @throws 
	*/
	public Pager<UserDTO> searchUser(long page, long rows, UserDTO user);

	/** 
	* @Title: deleteUserInfo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"id"})
	public String deleteUserInfo(String id);

    /** 
    * @Title: updatePassword 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param oldPwd
    * @param @param newPwd
    * @param @param confirmPwd
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"oldPwd","newPwd","confirmPwd"})
    public String updatePassword(String oldPwd,String newPwd,String confirmPwd);

    /** 
    * @Title: updateUser 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param user
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"user"})
	public String updateUser(UserDTO user);

    /** 
    * @Title: getAllMenus 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param userid
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<ResourceDTO>    返回类型 
    * @throws 
    */
    @Export(paramNames = {"userid"})
    public List<ResourceDTO> getAllMenus(Long userid);
    /**
     * 
    * @Title: userLogin
    * @Description: 用户登录 liyun
    * @param @param userCode
    * @param @param pwd
    * @param @param clientIp
    * @param @return
    * @return ExecuteResult<UserDTO>
    * @throws
     */
    @Export(paramNames = {"userCode","pwd","clientIp"})
    public ExecuteResult<UserDTO> userLogin(String userCode,String pwd,String clientIp);

	/** 
	* @Title: searchUsersByGroupId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param user
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<UserDTO>    返回类型 
	* @throws 
	*/
	public Pager<UserDTO> searchUsersByGroupId(long page, long rows,
			UserDTO user);
}
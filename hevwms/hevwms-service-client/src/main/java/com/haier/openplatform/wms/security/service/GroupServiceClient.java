package com.haier.openplatform.wms.security.service;

import io.terminus.pampas.client.Export;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;


/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
public interface GroupServiceClient {
    
	/** 
	* @Title: createGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param group
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"group"})
	public String createGroup(GroupDTO group);

	/** 
	* @Title: searchGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param groupDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<GroupDTO>    返回类型 
	* @throws 
	*/
	public Pager<GroupDTO> searchGroup(long page, long rows, GroupDTO groupDTO);
	
	/** 
	* @Title: deleteGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids"})
	public String deleteGroup(String ids);
	
	/** 
	* @Title: updateGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param group
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"group"})
	public String updateGroup(GroupDTO group);
	
	/** 
	* @Title: addUserToGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param groupId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids","groupId"})
	public String addUserToGroup(String ids,String groupId);
	
	/** 
	* @Title: deleteUserFromGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param groupId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids","groupId"})
	public String deleteUserFromGroup(String ids,String groupId);
	
	/** 
	* @Title: addRoleToGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param groupId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids","groupId"})
	public String addRoleToGroup(String ids,String groupId);
	
	/** 
	* @Title: deleteRoleFromGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param groupId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids","groupId"})
	public String deleteRoleFromGroup(String ids,String groupId);

	/** 
	* @Title: getAdminByGroupId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param user
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<UserGroup>    返回类型 
	* @throws 
	*/
	public Pager<UserGroup> getAdminByGroupId(long page, long rows, UserDTO user); 
	
	/** 
	* @Title: addAdminToGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param groupId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids","groupId"})
	public String addAdminToGroup(String ids,String groupId);

	/** 
	* @Title: deleteAdminFromGroup 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param groupId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids","groupId"})
	public String deleteAdminFromGroup(String ids,String groupId);
	
}
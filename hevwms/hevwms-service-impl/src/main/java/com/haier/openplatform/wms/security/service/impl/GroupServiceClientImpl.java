package com.haier.openplatform.wms.security.service.impl;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.security.service.GroupService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.security.service.GroupServiceClient;

/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
@Path("GroupServiceClientImpl")
@Consumes({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 参数类型
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 返回值类型
public class GroupServiceClientImpl implements GroupServiceClient {
	
	private GroupService groupService;

	/**
	 * 新增组信息
	 *ZhangYing@jbinfo.cn
	 * 2015-11-18
	 */
	@Override
	public String createGroup(GroupDTO group) {
	    BaseUser user = UserUtil.getCurrentUser();
		group.setCreateBy(user.getName());
		group.setLastModifiedBy(user.getName());
        try {
			ExecuteResult<GroupDTO> result=groupService.createGroup(group, user.getId());
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * 查询组信息
	 *ZhangYing@jbinfo.cn
	 * 2015-11-23
	 */
	@Override
	public Pager<GroupDTO> searchGroup(long page, long rows, GroupDTO group) {
		
        Pager<GroupDTO> pager=new Pager<GroupDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
		
        Pager<GroupDTO> pagerDTO = new Pager<GroupDTO>();
        Pager<GroupDTO> temp=groupService.getAllGroupsByPager(pager, group);
        long totalSize=temp.getTotalRecords();
        List<GroupDTO> listInfo = temp.getRecords();
        List<GroupDTO> list = new ArrayList<GroupDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(GroupDTO info : listInfo){
        	GroupDTO dto = new GroupDTO();
            try {
                BeanUtils.copyProperties(dto,info);
                list.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
	}

	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-11-24
	 */
	@Override
	public String deleteGroup(String ids) {
	    BaseUser user = UserUtil.getCurrentUser();
		try {
			ExecuteResult<GroupDTO> result=groupService.deleteGroup(ids, user.getId());//登录用户ID
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
	}

	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-1
	 */
	@Override
	public String updateGroup(GroupDTO dto) {
	    BaseUser user = UserUtil.getCurrentUser();
		try {
			GroupDTO group = new GroupDTO();
			group.setName(dto.getName());
			group.setDescription(dto.getDescription());
			group.setId(dto.getId());
			ExecuteResult<GroupDTO> result=groupService.updateGroup(group,group.getName(),user.getId());
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * 添加组内成员
	 *ZhangYing@jbinfo.cn
	 * 2015-12-15
	 */
	@Override
	public String addUserToGroup(String ids, String groupId) {
	    BaseUser user = UserUtil.getCurrentUser();
	    
		
		ExecuteResult<GroupDTO> result = groupService.addUserToGroup(Long.valueOf(groupId), ids, user.getId());  //获取登录用户ID
		if(!result.isSuccess()){
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} 
		return "success";
	}

	/**
	 * 删除组内成员
	 *ZhangYing@jbinfo.cn
	 * 2015-12-16
	 */
	@Override
	public String deleteUserFromGroup(String ids, String groupId) {
	    BaseUser user = UserUtil.getCurrentUser();
		
		ExecuteResult<GroupDTO> result = groupService.deleteUserFromGroup(Long.valueOf(groupId), ids, user.getId());  //获取登录用户ID
		if(!result.isSuccess()){
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} 
		return "success";
	}

	/**
	 * 添加组内角色
	 *ZhangYing@jbinfo.cn
	 * 2015-12-16
	 */
	@Override
	public String addRoleToGroup(String ids, String groupId) {
	    BaseUser user = UserUtil.getCurrentUser();
		ExecuteResult<GroupDTO> result = groupService.addRoleToGroup(Long.valueOf(groupId), ids,user.getId()/*LoginContextHolder.get().getUserId()*/);  //获取登录用户ID
		if(!result.isSuccess()){
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} 
		return "success";
	}

	/**
	 * 删除组内角色
	 *ZhangYing@jbinfo.cn
	 * 2015-12-16
	 */
	@Override
	public String deleteRoleFromGroup(String ids, String groupId) {
	    BaseUser user = UserUtil.getCurrentUser();
		
		ExecuteResult<RoleDTO> result = groupService.deleteRoleFromGroup(Long.valueOf(groupId), ids,user.getId()/*LoginContextHolder.get().getUserId()*/);  //获取登录用户ID
		if(!result.isSuccess()){
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} 
		return "success";
	}

	/**
	 * 根据组ID查询管理员
	 *ZhangYing@jbinfo.cn
	 * 2015-12-16
	 */
	@Override
	public Pager<UserGroup> getAdminByGroupId(long page, long rows, UserDTO user) {
		
		Pager<UserGroup> pager=new Pager<UserGroup>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        
        Pager<UserGroup> pagerDTO = new Pager<UserGroup>();
        Pager<UserGroup> temp=groupService.getAdminByGroupId(pager, user);
        long totalSize=temp.getTotalRecords();
        List<UserGroup> listInfo = temp.getRecords();
        List<UserGroup> list = new ArrayList<UserGroup>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(UserGroup info : listInfo){
        	UserGroup dto = new UserGroup();
            try {
                BeanUtils.copyProperties(dto,info);
                if(String.valueOf(info.getUser().getStatus()).equals("1")){
                	dto.getUser().setStatusDesc("enable");
                }else{
                	dto.getUser().setStatusDesc("disable");
                }
                list.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
		
	}

	/**
	 * 添加组内成员
	 *ZhangYing@jbinfo.cn
	 * 2015-12-17
	 */
	@Override
	public String addAdminToGroup(String ids, String groupId) {
	    BaseUser user = UserUtil.getCurrentUser();
		
		ExecuteResult<GroupDTO> result = groupService.addAdminToGroup(Long.valueOf(groupId), ids,user.getId()/*LoginContextHolder.get().getUserId()*/);  //获取登录用户ID
		if(!result.isSuccess()){
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} 
		return "success";
	}

	/**
	 * 删除组内管理员
	 *ZhangYing@jbinfo.cn
	 * 2015-12-17
	 */
	@Override
	public String deleteAdminFromGroup(String ids, String groupId) {
	    BaseUser user = UserUtil.getCurrentUser();
		
		ExecuteResult<GroupDTO> result = groupService.deleteAdminFromGroup(Long.valueOf(groupId), ids,user.getId()/*LoginContextHolder.get().getUserId()*/);  //获取登录用户ID
		if(!result.isSuccess()){
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} 
		return "success";
	}
	
	
 }

package com.haier.openplatform.wms.security.service.impl;

import io.terminus.pampas.common.UserUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.security.service.ResourceService;
import com.haier.hevwms.security.service.UserService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.PasswordUtil;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.security.service.SecurityUserServiceClient;

/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
@Path("SecurityUserServiceClientImpl")
@Consumes({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 参数类型
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 返回值类型
public class SecurityUserServiceClientImpl implements SecurityUserServiceClient {
	
	private UserService userService;
	private ResourceService resourceService;
	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-11-18
	 */
	@Override
	public String createUser(UserDTO user) {
        try {
			ExecuteResult<UserDTO> result=userService.createUser(user);
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
	 * 2015-12-2
	 */
	@Override
	public Pager<UserDTO> searchUser(long page, long rows, UserDTO user) {
		
		Pager<UserDTO> pager=new Pager<UserDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
		
        Pager<UserDTO> pagerDTO = new Pager<UserDTO>();
        Pager<UserDTO> temp=userService.searchUser(pager, user);
        long totalSize=temp.getTotalRecords();
        List<UserDTO> listInfo = temp.getRecords();
        List<UserDTO> list = new ArrayList<UserDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(UserDTO info : listInfo){
        	UserDTO dto = new UserDTO();
            try {
            	
            	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
                BeanUtils.copyProperties(dto,info);
                if(String.valueOf(info.getStatus()).equals("1")){
                	dto.setStatusDesc("Active");
                }else if(String.valueOf(info.getStatus()).equals("2")){
                	dto.setStatusDesc("Locked");
                }else{
                	dto.setStatusDesc("Disable");
                }
                list.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch(Exception e){
            	e.printStackTrace();
            }
        }
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
	}


	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-3
	 */
	@Override
	public String deleteUserInfo(String id) {
		
		try {
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			ExecuteResult<?> result=userService.deleteUser(Long.valueOf(id));//登录用户ID
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
	 * 2015-12-7
	 */
	@Override
	public String updatePassword(String oldPwd, String newPwd, String confirmPwd) {
		Long userId = UserUtil.getCurrentUser().getId();
		UserDTO user = userService.getUserById(userId);
		if(user == null || !user.getPassword().equals(PasswordUtil.encrypt(oldPwd))){
			String error = "Wrong Old Password";
			return error;
		}
		if(user.getPassword().equals(PasswordUtil.encrypt(newPwd))){
			String error ="New password must be different with old ones";
			return error;
		}
		if(!(newPwd.equals(confirmPwd))){
			String error ="Confirm password must be same as password";
			return error;
		}
		this.userService.updatePassword(userId, confirmPwd);
		return "success";
	}
    
    public ResourceService getResourceService() {
        return resourceService;
    }

    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
    
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-10
	 */
	@Override
	public String updateUser(UserDTO user) {
		try {
			ExecuteResult<UserDTO> result=userService.updateUser(user);
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
	}
    @Override
    public List<ResourceDTO> getAllMenus(Long userid) {
        return resourceService.getGroupResourceByUserId(userid);
    }
    
    @Override
    public ExecuteResult<UserDTO> userLogin(String userCode, String pwd,
            String clientIp) {
//        ExecuteResult<UserDTO> result = new ExecuteResult<UserDTO>();
        UserDTO user=new UserDTO();
        user.setName(userCode);
        try {
            user.setPassword(PasswordUtil.encrypt(pwd));
        } catch (Exception e) {
        	ExecuteResult<UserDTO> result1 = new ExecuteResult<UserDTO>();
            result1.addErrorMessage("Password encryption internal error,please contact administrator!");
            return result1;
        }
        user.setCurrentLoginIp(clientIp);
        //验证用户登录
        ExecuteResult<UserDTO> result=userService.mergeUserLogin(user);
        return result;
    }


    /**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-15
	 */
	@Override
	public Pager<UserDTO> searchUsersByGroupId(long page, long rows, UserDTO user) {
		
		Pager<UserDTO> pager=new Pager<UserDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
		
        Pager<UserDTO> pagerDTO = new Pager<UserDTO>();
        Pager<UserDTO> temp=userService.getUsersByGroupId(pager, user);
        long totalSize=temp.getTotalRecords();
        List<UserDTO> listInfo = temp.getRecords();
        List<UserDTO> list = new ArrayList<UserDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(UserDTO info : listInfo){
        	UserDTO dto = new UserDTO();
            try {
            	
            	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
                BeanUtils.copyProperties(dto,info);
                if(String.valueOf(info.getStatus()).equals("1")){
                	dto.setStatusDesc("enable");
                }else{
                	dto.setStatusDesc("disable");
                }
                list.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch(Exception e){
            	e.printStackTrace();
            }
        }
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
	}
 }

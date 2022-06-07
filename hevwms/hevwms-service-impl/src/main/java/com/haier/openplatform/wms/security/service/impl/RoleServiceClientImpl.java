package com.haier.openplatform.wms.security.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.StringUtils;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.security.service.RoleService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.service.RoleServiceClient;

/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
@Path("RoleServiceClientImpl")
@Consumes({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 参数类型
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 返回值类型
public class RoleServiceClientImpl implements RoleServiceClient {
	
	private RoleService roleService;

	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-3
	 */
	@Override
	public Pager<RoleDTO> searchRole(long page, long rows, RoleDTO role) {
		
		Pager<RoleDTO> pager=new Pager<RoleDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
		
        Pager<RoleDTO> pagerDTO = new Pager<RoleDTO>();
        Pager<RoleDTO> temp=roleService.searchRoles(pager, role);
        long totalSize=temp.getTotalRecords();
        List<RoleDTO> listInfo = temp.getRecords();
        List<RoleDTO> list = new ArrayList<RoleDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(RoleDTO info : listInfo){
        	RoleDTO dto = new RoleDTO();
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
	 * 2015-12-4
	 */
	@Override
	public String deleteRoleMessage(String id) {
		
		try {
			ExecuteResult<RoleDTO> result=roleService.deleteRole(Long.valueOf(id));
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
	}
	
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * 创建角色
	 *ZhangYing@jbinfo.cn
	 * 2015-12-12
	 */
	@Override
	public String createRole(RoleDTO role) {
		
		 try {
			 String[] resId = role.getResourceIds().split(",");
				// 设置资源信息
				for(String roleId : resId){
					if(StringUtils.isEmpty(roleId)){
						continue;
					}
					ResourceDTO res = new ResourceDTO();
					res.setId(Long.parseLong(roleId));
					role.getResources().add(res);
				}
				ExecuteResult<RoleDTO> result=roleService.createRole(role);
				if (!result.isSuccess()){
				    return result.getErrorMessages().get(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return "success";
	}

	/**
	 * 更新角色信息
	 *ZhangYing@jbinfo.cn
	 * 2015-12-12
	 */
	@Override
	public String updateRole(RoleDTO role) {
		
		try {
			 String[] resId = role.getResourceIds().split(",");
				// 设置资源信息
				for(String roleId : resId){
					if(StringUtils.isEmpty(roleId)){
						continue;
					}
					ResourceDTO res = new ResourceDTO();
					res.setId(Long.parseLong(roleId));
					role.getResources().add(res);
				}
				ExecuteResult<RoleDTO> result=roleService.updateRole(role);
				if (!result.isSuccess()){
				    return result.getErrorMessages().get(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "success";
	}

	/**
	 * 查询组内角色
	 *ZhangYing@jbinfo.cn
	 * 2015-12-16
	 */
	@Override
	public Pager<RoleDTO> searchRolesByGroupId(long page, long rows, RoleDTO role) {
		
		Pager<RoleDTO> pager=new Pager<RoleDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
		
        Pager<RoleDTO> pagerDTO = new Pager<RoleDTO>();
        Pager<RoleDTO> temp=roleService.getRolesByGroupId(pager, role);
        long totalSize=temp.getTotalRecords();
        List<RoleDTO> listInfo = temp.getRecords();
        List<RoleDTO> list = new ArrayList<RoleDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(RoleDTO info : listInfo){
        	RoleDTO dto = new RoleDTO();
            try {
            	
            	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
                BeanUtils.copyProperties(dto,info);
                /*if(String.valueOf(info.getStatus()).equals("1")){
                	dto.setStatusDesc("启用");
                }else{
                	dto.setStatusDesc("禁用");
                }*/
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

    @Override
    public List<RoleDTO> getRoleResources(long roleId) {
        return roleService.getRoleResources(roleId);
    }

	
	/**=====================================getters and setters=======================================*/
	
	
 }

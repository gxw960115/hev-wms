package com.haier.wms.controller.security;


import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.service.RoleServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * @ClassName: RoleController
 * @Description: 安全管理_角色
 * @author zhangying
 * @Date 2015-10-30 下午2:06:55
 */
@Controller
public class RoleController {
	
	/**  
	 * @Fields field:field:{}(dubbo暴漏出来的接口)  
	 */  
	@Resource
	private RoleServiceClient roleServiceClient;

	/**  
	 * @Title: getRoleServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return RoleServiceClient 
	 * @throws  
	 */  
	public RoleServiceClient getRoleServiceClient() {
		return roleServiceClient;
	}

	/**  
	 * @Title: setRoleServiceClient  
	 * @Description: (set)  
	 * @param roleServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setRoleServiceClient(RoleServiceClient roleServiceClient) {
		this.roleServiceClient = roleServiceClient;
	}
	
    /**  
     * @Title: searchRole  
     * @Description: (查询角色信息)  
     * @param request
     * @param role
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/role/searchRoleInfo",
             method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String searchRole(HttpServletRequest request,
			RoleDTO role) {
		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));
		
		PageBean bean = null;
		Pager<RoleDTO> outpager = roleServiceClient
				.searchRole(page, rows, role);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchRolesByGroupId  
     * @Description: (查询组内角色)  
     * @param request
     * @param roleSearchModel
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/role/searchRolesByGroupId",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String searchRolesByGroupId(HttpServletRequest request,
			RoleDTO role) {
		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));
		
		PageBean bean = null;
		Pager<RoleDTO> outpager = roleServiceClient.searchRolesByGroupId(page, rows, role);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
   }
}

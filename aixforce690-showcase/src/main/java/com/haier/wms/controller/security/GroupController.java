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
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.security.service.GroupServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * @ClassName: StockTakingController
 * @Description: 安全管理——组
 * @author linzongxiao
 * @Date 2015-10-30 下午2:06:55
 */
@Controller
public class GroupController {
	
	/**  
	 * @Fields field:field:{}(dubbo暴漏出来的接口)  
	 */  
	@Resource
    GroupServiceClient groupServiceClient;
 
    /**  
     * @Title: getGroupServiceClient  
     * @Description: (get)  
     * @return
     * @return GroupServiceClient 
     * @throws  
     */  
    public GroupServiceClient getGroupServiceClient() {
		return groupServiceClient;
	}

	/**  
	 * @Title: setGroupServiceClient  
	 * @Description: (set)  
	 * @param groupServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setGroupServiceClient(GroupServiceClient groupServiceClient) {
		this.groupServiceClient = groupServiceClient;
	}

	/**  
	 * @Title: searchGroup  
	 * @Description: (查询)  
	 * @param request
	 * @param group
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/group/searchGroupInfo",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody 
    public String searchGroup(HttpServletRequest request,
            GroupDTO group) {
        long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));

        PageBean bean = null;
        Pager<GroupDTO> outpager = groupServiceClient
        		.searchGroup(page, rows, group);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }  
    
    /**  
     * @Title: getAdminByGroupId  
     * @Description: (根据组ID查询管理员)  
     * @param request
     * @param userInGroupSearchModel
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/group/getAdminByGroupId",
    method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String getAdminByGroupId(HttpServletRequest request,
				UserDTO user) {
		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));
		
		PageBean bean = null;
		Pager<UserGroup> outpager = groupServiceClient
				.getAdminByGroupId(page, rows, user);
		Pager<UserDTO> users = new Pager<UserDTO>();
		for(int i = 0;i<outpager.getRecords().size();i++){
			users.getRecords().add(outpager.getRecords().get(i).getUser());
		}
		bean = PageUtil.setPager(users);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

}

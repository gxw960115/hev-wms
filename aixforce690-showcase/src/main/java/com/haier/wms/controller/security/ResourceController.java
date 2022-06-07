package com.haier.wms.controller.security;

import java.util.List;

import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.service.ResourceServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * @ClassName: RoleController
 * @Description: 安全管理_资源
 * @author zhangying
 * @Date 2015-10-30 下午2:06:55
 */
@Controller
public class ResourceController {
	
	/**  
	 * @Fields field:field:{}(dubbo暴漏出来的接口)  
	 */  
	@Resource
	private ResourceServiceClient resourceServiceClient;

	/**  
	 * @Title: getResourceServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return ResourceServiceClient 
	 * @throws  
	 */  
	public ResourceServiceClient getResourceServiceClient() {
		return resourceServiceClient;
	}

	/**  
	 * @Title: setResourceServiceClient  
	 * @Description: (set)  
	 * @param resourceServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setResourceServiceClient(ResourceServiceClient resourceServiceClient) {
		this.resourceServiceClient = resourceServiceClient;
	}
	
    /**  
     * @Title: searchResource  
     * @Description: (查询角色信息)  
     * @param request
     * @param resource
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/resource/searchResourceInfo",
             method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String searchResource(HttpServletRequest request,
			ResourceDTO resource) {
		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));
		
		PageBean bean = null;
		Pager<ResourceDTO> outpager = resourceServiceClient
				.searchResource(page, rows, resource);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: selectResourceTree  
     * @Description: (查询资源树)  
     * @param request
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/security/resourceTree", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectResourceTree(HttpServletRequest request) {
        //status为1：有效
        List<ResourceDTO> rows=resourceServiceClient.selectResourceTree(Integer.parseInt(request.getParameter("status")));
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
    }
    
    /**
    * @Title: getParentResource by liyun
    * @Description: combobox 得到父级module
    * @param @param request
    * @param @return
    * @return String
    * @throws
     */
    @RequestMapping(value = "/security/getParentResource", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getParentResource(HttpServletRequest request) {
        List<ResourceDTO> list=resourceServiceClient.getParentResource(Integer.parseInt(request.getParameter("status")));
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
}

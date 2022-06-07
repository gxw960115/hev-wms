package com.haier.wms.controller.security;


import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.wms.security.service.SystemConfigServiceClient;

/**
 * @ClassName: UserController
 * @Description: 安全管理_用户
 * @author zhangying
 * @Date 2015-10-30 下午2:06:55
 */
@Controller
public class SystemConfigController {
	
	/**  
	 * @Fields field:field:{}(dubbo暴漏出来的接口)  
	 */  
	@Resource
	private SystemConfigServiceClient systemConfigClient;

	
    /**  
     * @Title: searchUser  
     * @Description: (查询用户)  
     * @param request
     * @param user
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/security/fifoConfig",
             method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String fifoConfig(HttpServletRequest request,
			String fifoFlag, String fifoPeriod) {

    	String result = systemConfigClient.fifoConfig(fifoFlag, fifoPeriod);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    

}

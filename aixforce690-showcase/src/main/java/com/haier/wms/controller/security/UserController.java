package com.haier.wms.controller.security;


import io.terminus.common.utils.JsonMapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.showcase.domain.LoginResult;
import com.haier.openplatform.showcase.utils.Env;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.IpUtil;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
import com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.security.service.SecurityUserServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * @ClassName: UserController
 * @Description: 安全管理_用户
 * @author zhangying
 * @Date 2015-10-30 下午2:06:55
 */
@Controller
public class UserController {
	
	/**  
	 * @Fields field:field:{}(dubbo暴漏出来的接口)  
	 */  
	@Resource
	private MdDictionaryServiceClient mdDictionaryServiceClient;
	/**  
	 * @Fields field:field:{}(dubbo暴漏出来的接口)  
	 */  
	@Resource
    private CdWhInfoServiceClient cdWhInfoServiceClient;
	/**  
	 * @Fields field:field:{}(dubbo暴漏出来的接口)  
	 */  
    @Resource
    private SecurityUserServiceClient securityUserServiceClient;
    Logger log = Logger.getLogger(this.getClass());
	
	/**  
	 * @Title: getMdDictionaryServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return MdDictionaryServiceClient 
	 * @throws  
	 */  
	public MdDictionaryServiceClient getMdDictionaryServiceClient() {
		return mdDictionaryServiceClient;
	}

	/**  
	 * @Title: setMdDictionaryServiceClient  
	 * @Description: (set)  
	 * @param mdDictionaryServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setMdDictionaryServiceClient(
			MdDictionaryServiceClient mdDictionaryServiceClient) {
		this.mdDictionaryServiceClient = mdDictionaryServiceClient;
	}

	/**  
	 * @Title: getCdWhInfoServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return CdWhInfoServiceClient 
	 * @throws  
	 */  
	public CdWhInfoServiceClient getCdWhInfoServiceClient() {
		return cdWhInfoServiceClient;
	}

	/**  
	 * @Title: setCdWhInfoServiceClient  
	 * @Description: (set)  
	 * @param cdWhInfoServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setCdWhInfoServiceClient(CdWhInfoServiceClient cdWhInfoServiceClient) {
		this.cdWhInfoServiceClient = cdWhInfoServiceClient;
	}

	/**  
	 * @Title: getSecurityUserServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return SecurityUserServiceClient 
	 * @throws  
	 */  
	public SecurityUserServiceClient getSecurityUserServiceClient() {
		return securityUserServiceClient;
	}

	/**  
	 * @Title: setSecurityUserServiceClient  
	 * @Description: (set)  
	 * @param securityUserServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setSecurityUserServiceClient(
			SecurityUserServiceClient securityUserServiceClient) {
		this.securityUserServiceClient = securityUserServiceClient;
	}
	
	/**  
	 * @Title: searchDivisions  
	 * @Description: (findDivisions)  
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/user/list/select",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody 
    public String searchDivisions() {
		List<MdDictionaryDTO> list=mdDictionaryServiceClient.findDivisions();
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
	
	/**  
	 * @Title: selectLocationTree  
	 * @Description: (查询仓库)  
	 * @param request
	 * @param userType
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/user/tree/select", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectLocationTree(HttpServletRequest request,
            String userType) {
        List<HashMap<String,Object>> rows=cdWhInfoServiceClient.findWhlocalInfos(userType,Long.valueOf("24"));
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
    }
	
    /**  
     * @Title: searchUser  
     * @Description: (查询用户)  
     * @param request
     * @param user
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/user/searchUserInfo",
             method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String searchUser(HttpServletRequest request,
			UserDTO user) {
		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));
		
		PageBean bean = null;
		Pager<UserDTO> outpager = securityUserServiceClient
				.searchUser(page, rows, user);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    
    /**  
     * @Title: login  
     * @Description: (登录)  
     * @param request
     * @param response
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value="/user/userlogin",method=RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String login(HttpServletRequest request,HttpServletResponse response){
        String userCode = request.getParameter("name");
        String password = request.getParameter("password");
        LoginResult loginResult = new LoginResult();
        ExecuteResult<UserDTO> result = securityUserServiceClient.userLogin(userCode, password, IpUtil.getIpAddress(request));
        if(result.isSuccess()){
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
            HttpServletRequest requests = ((ServletRequestAttributes)ra).getRequest();  
            requests.getSession().setAttribute(SessionSecurityConstants.KEY_USER_NAME, userCode);
            requests.getSession().setAttribute(SessionSecurityConstants.KEY_USER_NICK_NAME, result.getResult().getNickName());
            requests.getSession().setAttribute(SessionSecurityConstants.KEY_USER_ID, result.getResult().getId());
            requests.getSession().setAttribute("user_duty_type", result.getResult().getDutyType());
            loginResult.setUserNickName(result.getResult().getNickName());
            loginResult.setResult("true");
            loginResult.setMsg("login success");
            loginResult.setUserId(result.getResult().getId());
            loginResult.setUserType(result.getResult().getDutyType());
            
//          Object targetUrl = request.getSession().getAttribute(SessionSecurityConstants.KEY_LAST_VISIT_URL);
//          loginResult.setTargetUrl(targetUrl == null ? Env.getProperty(Env.LOGIN_AFTER_JUMP_URL) : (String)targetUrl);
            loginResult.setTargetUrl(Env.getProperty(Env.LOGIN_AFTER_JUMP_URL));
        }else{
            log.info(result.getErrorMessages().get(0));
            loginResult.setResult("false");
            loginResult.setMsg(result.getErrorMessages().size() > 0 ? result.getErrorMessages().get(0) : "username or password is incorrect");
        }
        return JsonMapper.JSON_NON_EMPTY_MAPPER.toJson(loginResult);
    }
    
    
    /**  
     * @Title: getAllMenus  
     * @Description: (获取菜单)  
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value="/user/getAllMenus",method=RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getAllMenus(){
        Long idLong=SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        List<ResourceDTO> listRes=securityUserServiceClient.getAllMenus(idLong);
        return JsonMapper.JSON_NON_EMPTY_MAPPER.toJson(listRes);
    }
    
    /**  
     * @Title: searchUsersByGroupId  
     * @Description: (根据组ID查询组内人员)  
     * @param request
     * @param user
     * @param groupId
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/user/searchUsersByGroupId",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String searchUsersByGroupId(HttpServletRequest request,
			UserDTO user) {
    	long page = Long.parseLong(request.getParameter("page"));
    	long rows = Long.parseLong(request.getParameter("rows"));
    	
    	PageBean bean = null;
    	Pager<UserDTO> outpager = null;
    	outpager = securityUserServiceClient.searchUsersByGroupId(page, rows, user);
    	bean = PageUtil.setPager(outpager);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
}

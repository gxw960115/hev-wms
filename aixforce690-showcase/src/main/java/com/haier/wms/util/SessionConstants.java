package com.haier.wms.util;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.haier.openplatform.security.SessionSecurityConstants;
/**
 * 
* @ClassName: SessionConstants
* @Description: 用户登录后session信息
*
 */
public class SessionConstants {
    /**
     * 
    * @Title: getSession
    * @Description: 获取用户登录session的userid、username、usernickname
    * @param @return
    * @return JSONObject
    * @throws
     */
	public static JSONObject getSession(){
	    JSONObject res=new JSONObject();
	    RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        HttpServletRequest requests = ((ServletRequestAttributes)ra).getRequest();  
        res.put(SessionSecurityConstants.KEY_USER_ID, Long.parseLong(requests.getSession().getAttribute(SessionSecurityConstants.KEY_USER_ID)==null?"1":requests.getSession().getAttribute(SessionSecurityConstants.KEY_USER_ID).toString()));
        res.put(SessionSecurityConstants.KEY_USER_NAME, requests.getSession().getAttribute(SessionSecurityConstants.KEY_USER_NAME));
        res.put(SessionSecurityConstants.KEY_USER_NICK_NAME, requests.getSession().getAttribute(SessionSecurityConstants.KEY_USER_NICK_NAME));
        res.put("user_duty_type", requests.getSession().getAttribute("user_duty_type"));
        return res;
	}
}

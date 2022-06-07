package com.haier.openplatform.showcase.interceptor;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import io.terminus.pampas.engine.config.ConfigManager;
import io.terminus.pampas.engine.config.model.FrontConfig;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Strings;
import com.haier.openplatform.security.LoginContext;
import com.haier.openplatform.security.LoginContextHolder;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.IpUtil;

/**
 * 从session中读取用户信息，设置到线程上线文中
 * 
 * @author hanty
 * 
 */
@Slf4j
public class LoginContextInterceptor extends HandlerInterceptorAdapter {

	private final static String DEFAULT_LOGIN = "redirectLogin"; 
	/**************HOP4.0用信息********************/
	@Autowired
	private ConfigManager configManager;
	/**************HOP4.0用信息********************/

	private List<String> noLoginAuthUrlList = new ArrayList<String>();
	/**
	 * 用户session中的用户表示
	 */
	private String keyUserName = SessionSecurityConstants.KEY_USER_NAME;
	private String keyUserNickName = SessionSecurityConstants.KEY_USER_NICK_NAME;
	private String keyUserId = SessionSecurityConstants.KEY_USER_ID;
	private String keyLocalLanguage = SessionSecurityConstants.KEY_LOCAL_LANGUAGE;

	public void setKeyUserName(String keyUserName) {
		this.keyUserName = keyUserName;
	}

	public void setKeyUserId(String keyUserId) {
		this.keyUserId = keyUserId;
	}

	public void setKeyLocalLanguage(String keyLocalLanguage) {
		this.keyLocalLanguage = keyLocalLanguage;
	}

	public void setNoLoginAuthUrlList(List<String> noLoginAuthUrlList) {
		this.noLoginAuthUrlList = noLoginAuthUrlList;
	}
	/**
	 * 预处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession httpSession = request.getSession();
		if(!isLogin(request)){
			redirectToLogin(request,response);
			return false;
		}
		//初始化登录用户
		initlizeBaseUser(httpSession);
		LoginContext loginContext = buildLoginContext(request);
		LoginContextHolder.put(loginContext);
		return super.preHandle(request, response, handler);
	}

	/**
	 * 拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LoginContextHolder.clear();
		UserUtil.clearCurrentUser();
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 返回方法拦截
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (ex != null) {
			//log.debug(ex.getMessage());
		}
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * 判断是否登录
	 * @param httpServletRequest
	 * @return
	 */
	protected boolean isLogin(HttpServletRequest httpServletRequest) {
		String currentUrl = httpServletRequest.getRequestURI();
		for(String url : noLoginAuthUrlList){
			if(currentUrl.startsWith(url)){
				return true;
			}
		}
		HttpSession httpSession = httpServletRequest.getSession();
		String userName = (String) httpSession.getAttribute(keyUserName);
		if (userName == null) {
			// 仅仅记住get请求的链接
			if (StringUtils.equalsIgnoreCase(httpServletRequest.getMethod(),
					"GET")) {
				HttpSession session = httpServletRequest.getSession();
				String servletPath = httpServletRequest.getServletPath();
				String fullURL = new StringBuffer(servletPath).append(
						toParameterString(httpServletRequest)).toString();
				session.setAttribute(
						SessionSecurityConstants.KEY_LAST_VISIT_URL, fullURL);
			}
			return false;
		}
		return true;
	}

	/**
	 * 封装登录用户信息到用户登录上下文中，并将登录用户封装到HOP4.0用BaseUser中
	 * @param httpServletRequest
	 * @return
	 */
	protected LoginContext buildLoginContext(
			HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();
		String userName = (String) httpSession.getAttribute(keyUserName);
		Long userId = (Long) httpSession.getAttribute(keyUserId);
		Locale language = (Locale) httpSession.getAttribute(keyLocalLanguage);
		LoginContext loginContext = createLoginContext();
		loginContext.setUserId(userId);
		loginContext.setUserName(userName);
		loginContext.setIp(IpUtil.getIpAddress(httpServletRequest));
		loginContext.setLanguage(language == null ? "zh_CN" : language.toString());
		return loginContext;
	}

	/**
	 * 创建用户登录上下文
	 * @return
	 */
	protected LoginContext createLoginContext() {
		return new LoginContext();
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	private String toParameterString(HttpServletRequest httpServletRequest) {
		Enumeration<String> paramEnumeration = httpServletRequest
				.getParameterNames();
		if (!paramEnumeration.hasMoreElements()) {
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer();
		while (paramEnumeration.hasMoreElements()) {
			String paramName = paramEnumeration.nextElement();
			stringBuffer.append("&");
			stringBuffer.append(paramName);
			stringBuffer.append("=");
			stringBuffer.append(httpServletRequest.getParameter(paramName));
		}
		stringBuffer.replace(0, 1, "?");
		return stringBuffer.toString();
	}

	/**
	 * 重定向到登录页面
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void redirectToLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	    response.sendRedirect("/login");
//		
//	    String currentUrl = request.getRequestURL().toString();
//
//		if (!(Strings.isNullOrEmpty(request.getQueryString()))) {
//			currentUrl = currentUrl + "?" + request.getQueryString();
//		}
//		FrontConfig frontConfig = this.configManager.getFrontConfig();
//		UriComponents uriComponents = UriComponentsBuilder.fromUriString(
//				((String) frontConfig.getHrefs().get(DEFAULT_LOGIN))
//						+ "?target={target}").build();
//
//		URI uri = uriComponents.expand(new Object[] { currentUrl }).encode().toUri();
//		response.sendRedirect(uri.toString());
	}
	
	/**
	 * 初始化HOP4.0用登录用户信息
	 * @param userID
	 */
	protected void initlizeBaseUser(HttpSession httpSession){
		// HOP4.0添加用户到BASE_USER
		BaseUser user = new BaseUser();
		user.setId((Long)httpSession.getAttribute(keyUserId));
		user.setName((String)httpSession.getAttribute(keyUserName));
		user.setNickName((String)httpSession.getAttribute(keyUserNickName));
		UserUtil.putCurrentUser(user);
	}

}

package com.haier.openplatform.showcase.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.haier.openplatform.security.AbstractAuthenticator;
import com.haier.openplatform.security.Authentication;
import com.haier.openplatform.security.DefaultUrlAuthenticator;
import com.haier.openplatform.security.SessionSecurityConstants;

/**
 * 权限认证过滤器
 * 
 * @author WangXuzheng
 * 
 */
public abstract class AbstractAuthenticationInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 无权限跳转的页面
	 */
	private static final String NOAUTHPAGE = "/noAuth";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession httpSession = request.getSession();
		Authentication authentication = (Authentication) httpSession.getAttribute(SessionSecurityConstants.KEY_AUTHENTICATION);
		if (authentication == null || authentication.getUrlResources().isEmpty()) {
			String userCode = (String)httpSession.getAttribute(SessionSecurityConstants.KEY_USER_NAME);
			authentication = getAuthentication(userCode, request);
			httpSession.setAttribute(SessionSecurityConstants.KEY_AUTHENTICATION, authentication);
		}
		AbstractAuthenticator authenticator = getAuthenticator(authentication);
		String currentUrl = request.getServletPath();
		if(!authenticator.hasUrlAuth(currentUrl)){
			response.sendRedirect(NOAUTHPAGE);
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			super.postHandle(request, response, handler, modelAndView);
	}


	/**
	 * 获取用户授权
	 * 
	 * @param userId
	 * @return
	 */
	public abstract Authentication getAuthentication(String userCode, HttpServletRequest reqeust);
	
	/**
	 * 获取认证校验器
	 * @param authentication
	 * @return
	 */
	protected AbstractAuthenticator getAuthenticator(Authentication authentication){
		return new DefaultUrlAuthenticator(authentication);
	}
}

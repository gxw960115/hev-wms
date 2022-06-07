package com.haier.hevwms.util;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
/**
 * <p>Description: [获取调用接口的客户端IP]</p>
 * Created on 2012-6-22
 */
public class WsIpUtil {
	/**
	 * <p>Discription:[获取调用接口的客户端IP]</p>
	 * @return
	 * @author:[zh-fan]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static String getRemoteIp(WebServiceContext context) {
		MessageContext ctx = context.getMessageContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
		return request.getRemoteAddr();
	}
}

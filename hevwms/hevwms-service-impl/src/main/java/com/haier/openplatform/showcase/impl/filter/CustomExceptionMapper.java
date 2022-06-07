package com.haier.openplatform.showcase.impl.filter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CustomExceptionMapper implements ExceptionMapper<NullPointerException> {

	/**
	 * 此处以空指针异常为例,演示捕获到特定的异常,做处理后返回自定义信息
	 */
	@Override
	public Response toResponse(NullPointerException exception) {   
		//TODO 处理逻辑
		return Response.status(Response.Status.BAD_REQUEST).entity("Oops! the requested resource is null!").type("text/plain").build();
	}

}

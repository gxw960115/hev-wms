package com.haier.openplatform.showcase.impl.common;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.haier.openplatform.showcase.security.dto.UserDTO;

public class CallRestGetExample {

	public static void main(String[] args) {
		//一个参数的情况
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/services/user/123");
		Response response = target.request().get();

		try {
		    if (response.getStatus() != 200) {
		        throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
		    }
		    System.out.println("The generated id is " + response.readEntity(UserDTO.class).getId());
		} finally {
		    response.close();
		    client.close(); // 在真正开发中不要每次关闭client，比如HTTP长连接是由client持有的
		}
		
		//多个参数的情况
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/services/user/getUserByIdAndName?user_id=111&user_name=测试");
		response = target.request().get();
		
		try {
		    if (response.getStatus() != 200) {
		        throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
		    }
		    System.out.println("The generated id is " + response.readEntity(UserDTO.class).getId());
		} finally {
		    response.close();
		    client.close(); // 在真正开发中不要每次关闭client，比如HTTP长连接是由client持有的
		}
	}
}

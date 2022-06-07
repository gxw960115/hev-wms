package com.haier.openplatform.showcase.impl.common;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.haier.openplatform.showcase.security.dto.UserDTO;

public class CallRestPostExample {

	public static void main(String[] args) {
		UserDTO user = new UserDTO();
		user.setName("Larry");
		user.setId(1234);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/services/user/getUser");
		Response response = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));

		try {
		    if (response.getStatus() != 200) {
		        throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
		    }
		    System.out.println("The generated id is " + response.readEntity(UserDTO.class).getId());
		} finally {
		    response.close();
		    client.close(); // 在真正开发中不要每次关闭client，考虑是否可以重用
		}
	}
}

package com.haier.openplatform.showcase.impl.security.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.haier.openplatform.showcase.impl.common.BaseTestCase;
import com.haier.openplatform.showcase.security.dto.UserDTO;
import com.haier.openplatform.showcase.security.service.UserServiceClient;

/**
 * @author 01311917
 *
 */
public class UserServiceClientImplTest_GetUserById extends BaseTestCase{
	@Resource
	protected UserServiceClient userServiceClient;
	@Ignore
	@Test
	public void testGetUserById() {
		long id = 99999918L;
		UserDTO user = userServiceClient.getUserById(id);
		assertThat(user, notNullValue());
	}
}

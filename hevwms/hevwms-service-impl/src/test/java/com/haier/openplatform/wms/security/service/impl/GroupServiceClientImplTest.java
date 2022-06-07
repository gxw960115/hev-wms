package com.haier.openplatform.wms.security.service.impl;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opensaml.xml.signature.G;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.security.service.GroupService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.security.dto.GroupDTO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class GroupServiceClientImplTest {

	private GroupServiceClientImpl target = new GroupServiceClientImpl();
	private GroupService groupServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		groupServiceMock = EasyMock.createMock(GroupService.class);
		target.setGroupService(groupServiceMock);
		BaseUser baseUser = new BaseUser();
		baseUser.setId(11L);
		baseUser.setName("TEST");
		PowerMockito.mockStatic(UserUtil.class);
		PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(baseUser);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void createGroup(){
		GroupDTO groupDTO =new GroupDTO();
		EasyMock.expect(groupServiceMock.createGroup(
				groupDTO,
				11L)
		).andReturn(new ExecuteResult<GroupDTO>()).times(1);
		EasyMock.replay(groupServiceMock);
		target.createGroup(groupDTO);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void searchGroup(){
		EasyMock.expect(groupServiceMock.getAllGroupsByPager(
				(Pager<GroupDTO>)EasyMock.anyObject(),
				(GroupDTO)EasyMock.anyObject())
		).andReturn(new Pager<GroupDTO>());
		EasyMock.replay(groupServiceMock);
		target.searchGroup(1L,10L,new GroupDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeleteGroup() {
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
		EasyMock.expect(groupServiceMock.deleteGroup((String)EasyMock.anyObject()
				,(Long)EasyMock.anyObject())).andReturn(new ExecuteResult<GroupDTO>()).times(1);
		EasyMock.replay(groupServiceMock);
		String result = target.deleteGroup("11");
		assertTrue("success".equals(result));
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void updateGroup(){
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setName("11");
		groupDTO.setDescription("11");
		groupDTO.setId(11L);

		GroupDTO groupDTO_1 = new GroupDTO();
		groupDTO_1.setName("11");
		groupDTO_1.setDescription("11");
		groupDTO_1.setId(11L);

		EasyMock.expect(groupServiceMock.updateGroup(
				groupDTO_1,"11",11L)
		).andReturn(new ExecuteResult<GroupDTO>());
		EasyMock.replay(groupServiceMock);
//		target.updateGroup(groupDTO);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void addUserToGroup(){
		EasyMock.expect(groupServiceMock.addUserToGroup(
				11L,"11",11L)
		).andReturn(new ExecuteResult<GroupDTO>());
		EasyMock.replay(groupServiceMock);
		target.addUserToGroup("11","11");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void deleteUserFromGroup(){
		EasyMock.expect(groupServiceMock.deleteUserFromGroup(
				11L,"11",11L)
		).andReturn(new ExecuteResult<GroupDTO>());
		EasyMock.replay(groupServiceMock);
		target.deleteUserFromGroup("11","11");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void addRoleToGroup(){
		EasyMock.expect(groupServiceMock.addRoleToGroup(
				11L,"11",11L)
		).andReturn(new ExecuteResult<GroupDTO>());
		EasyMock.replay(groupServiceMock);
		target.addRoleToGroup("11","11");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void deleteRoleFromGroup(){
		EasyMock.expect(groupServiceMock.deleteRoleFromGroup(
				11L,"11",11L)
		).andReturn(new ExecuteResult<RoleDTO>());
		EasyMock.replay(groupServiceMock);
		target.deleteRoleFromGroup("11","11");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void getAdminByGroupId(){
		EasyMock.expect(groupServiceMock.getAdminByGroupId(
				(Pager<UserGroup>)EasyMock.anyObject(),
				(UserDTO)EasyMock.anyObject())
		).andReturn(new Pager<UserGroup>());
		EasyMock.replay(groupServiceMock);
		target.getAdminByGroupId(1L,10L,new UserDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void addAdminToGroup(){
		EasyMock.expect(groupServiceMock.addAdminToGroup(
				11L,"11",11L)
		).andReturn(new ExecuteResult<GroupDTO>());
		EasyMock.replay(groupServiceMock);
		target.addAdminToGroup("11","11");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void deleteAdminFromGroup(){
		EasyMock.expect(groupServiceMock.deleteAdminFromGroup(
				11L,"11",11L)
		).andReturn(new ExecuteResult<GroupDTO>());
		EasyMock.replay(groupServiceMock);
		target.deleteAdminFromGroup("11","11");
	}
}

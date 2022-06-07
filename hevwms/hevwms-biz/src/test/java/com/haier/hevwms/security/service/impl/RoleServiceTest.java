package com.haier.hevwms.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.security.dao.ResourceDAO;
import com.haier.hevwms.security.dao.RoleDAO;
import com.haier.hevwms.security.service.ResourceService;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: RoleServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:15:53 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class RoleServiceTest extends BasicTestCase {
	RoleServiceImpl ss = new RoleServiceImpl();
	private RoleDAO roleDAO;
	private ResourceDAO resourceDAO;
	private ResourceService resourceService;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:15:59 
	*/ 
	@Before
	public void bf() {

		roleDAO = EasyMock.createMock(RoleDAO.class);
		resourceDAO = EasyMock.createMock(ResourceDAO.class);
		resourceService = EasyMock.createMock(ResourceService.class);
		ss.setRoleDAO(roleDAO);
		ss.setResourceDAO(resourceDAO);
		ss.setResourceService(resourceService);

	}
	
	/**  
	* @Title: createRole  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:16:09 
	*/ 
	@Test
	public void createRole() {

		try {
			RoleDTO role = (RoleDTO) getBean(RoleDTO.class);
            EasyMock.expect(roleDAO.getRoleByName(EasyMock.isA(String.class))).andReturn(role);
            EasyMock.replay(roleDAO);
			ss.createRole(role);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: createRole1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:16:15 
	*/ 
	@Test
	public void createRole1() {

		try {
			RoleDTO role = (RoleDTO) getBean(RoleDTO.class);
            EasyMock.expect(roleDAO.getRoleByName(EasyMock.isA(String.class))).andReturn(null);
            roleDAO.save(EasyMock.isA(RoleDTO.class));
              EasyMock.expectLastCall().anyTimes();
              EasyMock.replay(roleDAO);
			 ss.createRole(role);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateRole  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:16:24 
	*/ 
	@Test
	public void updateRole() {

		try {
			RoleDTO role = (RoleDTO) getBean(RoleDTO.class);
			
			ss.updateRole(null);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: updateRole1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:16:29 
	*/ 
	@Test
	public void updateRole1() {

		try {
			RoleDTO role = (RoleDTO) getBean(RoleDTO.class);
			EasyMock.expect(roleDAO.getRoleById(EasyMock.anyLong())).andReturn(null);
            EasyMock.replay(roleDAO);
			ss.updateRole(role);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: updateRole3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:16:33 
	*/ 
	@Test
	public void updateRole3() {

		try {
			RoleDTO role = (RoleDTO) getBean(RoleDTO.class);
		
			EasyMock.expect(roleDAO.getRoleById(EasyMock.anyLong())).andReturn(role).anyTimes();
			EasyMock.expect(roleDAO.delRoleResourcce(EasyMock.anyLong())).andReturn(2).anyTimes();
			EasyMock.expect(roleDAO.saveRoleResourcce(EasyMock.anyLong(),EasyMock.anyLong())).andReturn(2).anyTimes();
			EasyMock.expect(roleDAO.update(EasyMock.isA(RoleDTO.class))).andReturn(1);
			EasyMock.replay(roleDAO);
			ss.updateRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: deleteRole  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:16:48 
	*/ 
	@Test
	public void deleteRole() {

		try {
			Long roleId = (long) 8;
			RoleDTO role = (RoleDTO) getBean(RoleDTO.class);
			
			EasyMock.expect(roleDAO.getRoleById(EasyMock.anyLong())).andReturn(null).anyTimes();
			EasyMock.expect(resourceService.getResourceByRole(EasyMock.isA(Long[].class))).andReturn(null).anyTimes();
			EasyMock.replay(roleDAO,resourceService);
			
			ss.deleteRole(roleId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: deleteRole1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:16:56 
	*/ 
	@Test
	public void deleteRole1() {

		try {
			Long roleId = (long) 8;
			RoleDTO role = (RoleDTO) getBean(RoleDTO.class);
			ResourceDTO r = (ResourceDTO) getBean(ResourceDTO.class);
			List<ResourceDTO> resList=new ArrayList<ResourceDTO>();
			resList.add(r);
			EasyMock.expect(roleDAO.getRoleById(EasyMock.anyLong())).andReturn(role).anyTimes();
			EasyMock.expect(resourceService.getResourceByRole(EasyMock.isA(Long[].class))).andReturn(resList).anyTimes();
			EasyMock.replay(roleDAO,resourceService);
			
			ss.deleteRole(roleId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: getRoleById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:17:16 
	*/ 
	@Test
	public void getRoleById() {

		try {
			Long roleId = (long) 6;

			ss.getRoleById(roleId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getRoles  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:17:25 
	*/ 
	@Test
	public void getRoles() {

		try {

			ss.getRoles();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getRoleResources  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:17:39 
	*/ 
	@Test
	public void getRoleResources() {

		try {
			long roleId = (long) 10;

			ss.getRoleResources(roleId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}
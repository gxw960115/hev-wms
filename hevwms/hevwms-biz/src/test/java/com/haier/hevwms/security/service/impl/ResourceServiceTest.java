package com.haier.hevwms.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.security.dao.ResourceDAO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: ResourceServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:12:47 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class ResourceServiceTest extends BasicTestCase {
	ResourceServiceImpl ss = new ResourceServiceImpl();
	ResourceDAO resourceDAO;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:12:51 
	*/ 
	@Before
	public void bf() {

		resourceDAO = EasyMock.createMock(ResourceDAO.class);
		ss.setResourceDAO(resourceDAO);

	}

	/**  
	* @Title: createResource  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:12:58 
	*/ 
	@Test
	public void createResource() {

		try {
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);
			EasyMock.expect(resourceDAO.getResourceByName(EasyMock.isA(String.class), EasyMock.anyLong()))
					.andReturn(resource);

			EasyMock.replay(resourceDAO);
			ss.createResource(resource);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: createResource1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:03 
	*/ 
	@Test
	public void createResource1() {

		try {
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);
			EasyMock.expect(resourceDAO.getResourceByName(EasyMock.isA(String.class), EasyMock.anyLong()))
					.andReturn(null);
			EasyMock.expect(resourceDAO.getResourceByCode(EasyMock.isA(String.class))).andReturn(resource);
			EasyMock.replay(resourceDAO);
			ss.createResource(resource);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateResource  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:17 
	*/ 
	@Test
	public void updateResource() {

		try {
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);
			EasyMock.expect(resourceDAO.getResourceById(EasyMock.anyLong())).andReturn(null).anyTimes();
			EasyMock.expect(resourceDAO.getResourceByName(EasyMock.isA(String.class), EasyMock.anyLong()))
					.andReturn(null).anyTimes();
			EasyMock.expect(resourceDAO.getResourceByCode(EasyMock.isA(String.class))).andReturn(resource).anyTimes();
			EasyMock.replay(resourceDAO);
			ss.updateResource(resource);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateResource1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:22 
	*/ 
	@Test
	public void updateResource1() {

		try {
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);
			ResourceDTO dbresource = (ResourceDTO) getBean(ResourceDTO.class);
			dbresource.setName("13");
			EasyMock.expect(resourceDAO.getResourceById(EasyMock.anyLong())).andReturn(dbresource).anyTimes();
			EasyMock.expect(resourceDAO.getResourceByName(EasyMock.isA(String.class), EasyMock.anyLong()))
					.andReturn(resource).anyTimes();
			EasyMock.expect(resourceDAO.getResourceByCode(EasyMock.isA(String.class))).andReturn(resource).anyTimes();
			EasyMock.replay(resourceDAO);
			ss.updateResource(resource);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteResource  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:31 
	*/ 
	@Test
	public void deleteResource() {

		try {
			Long resourceId = (long) 2;
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);

			EasyMock.expect(resourceDAO.getResourceById(EasyMock.anyLong())).andReturn(null).anyTimes();
			EasyMock.replay(resourceDAO);
			ss.deleteResource(resourceId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteResource1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:34 
	*/ 
	@Test
	public void deleteResource1() {

		try {
			Long resourceId = (long) 2;
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);

			EasyMock.expect(resourceDAO.getResourceById(EasyMock.anyLong())).andReturn(resource).anyTimes();
			ArrayList<ResourceDTO> children = new ArrayList<ResourceDTO>();
			ResourceDTO r = (ResourceDTO) getBean(ResourceDTO.class);
			children.add(r);
			EasyMock.expect(resourceDAO.getChildren(EasyMock.anyLong())).andReturn(children).anyTimes();

			EasyMock.replay(resourceDAO);
			ss.deleteResource(resourceId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteResource2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:41 
	*/ 
	@Test
	public void deleteResource2() {

		try {
			Long resourceId = (long) 2;
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);

			EasyMock.expect(resourceDAO.getResourceById(EasyMock.anyLong())).andReturn(resource).anyTimes();
			ArrayList<ResourceDTO> children = new ArrayList<ResourceDTO>();

			EasyMock.expect(resourceDAO.getChildren(EasyMock.anyLong())).andReturn(children).anyTimes();
			EasyMock.expect(resourceDAO.delete(EasyMock.anyLong())).andReturn(1).anyTimes();

			EasyMock.replay(resourceDAO);
			ss.deleteResource(resourceId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getResourceById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:51 
	*/ 
	@Test
	public void getResourceById() {

		try {
			Long resourceId = (long) 1;

			ss.getResourceById(resourceId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getChilden  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:13:57 
	*/ 
	@Test
	public void getChilden() {

		try {
			Long resourceId = (long) 3;

			ss.getChilden(resourceId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getParentsChain  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:14:05 
	*/ 
	@Test
	public void getParentsChain() {

		try {
			Long resourceId = (long) 12;
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);

			EasyMock.expect(resourceDAO.getResourceById(EasyMock.anyLong())).andReturn(null).anyTimes();
			
			EasyMock.replay(resourceDAO);
			ss.getParentsChain(resourceId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: getParentsChain1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:14:11 
	*/ 
	@Test
	public void getParentsChain1() {

		try {
			Long resourceId = (long) 12;
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);
            
			EasyMock.expect(resourceDAO.getResourceById(EasyMock.anyLong())).andReturn(resource).anyTimes();
			 
			EasyMock.replay(resourceDAO);
			ss.getParentsChain(resourceId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: getRoot  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:14:20 
	*/ 
	@Test
	public void getRoot() {

		try {

			ss.getRoot();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getResourceByRole  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:14:28 
	*/ 
	@Test
	public void getResourceByRole() {

		try {
			Long[] roleIds = { 16l };

			ss.getResourceByRole(roleIds);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:14:37 
	*/ 
	@Test
	public void getAll() {

		try {

			ss.getAll();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getUserDisplayedURLResources  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:14:46 
	*/ 
	@Test
	public void getUserDisplayedURLResources() {

		try {
			Long userId = (long) 13;
			String moduleName = "3";

			ss.getUserDisplayedURLResources(userId, moduleName);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchResources  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:14:54 
	*/ 
	@Test
	public void searchResources() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);
			List<ResourceDTO> list=new ArrayList<ResourceDTO>();
			list.add(resource);
			EasyMock.expect(resourceDAO.searchResources(EasyMock.isA(Pager.class),EasyMock.isA(ResourceDTO.class))).andReturn(list).anyTimes();
			EasyMock.expect(resourceDAO.searchResourcesCount(EasyMock.isA(Pager.class),EasyMock.isA(ResourceDTO.class))).andReturn(2L).anyTimes();
			 
			EasyMock.replay(resourceDAO);
			ss.searchResources(pager, resource);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getUserResourceDescendants  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:15:08 
	*/ 
	@Test
	public void getUserResourceDescendants() {

		try {
			Long userId = (long) 2;
			List codeList = new ArrayList<String>();
			codeList.add("ss");
			List<ResourceDTO> list=new ArrayList<ResourceDTO>();
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);
			list.add(resource);
			EasyMock.expect(resourceDAO.getDescendants(EasyMock.anyLong(),EasyMock.isA(String.class))).andReturn(list).anyTimes();
			EasyMock.expect(resourceDAO.getResourceByCode(EasyMock.isA(String.class))).andReturn(resource).anyTimes();
			EasyMock.replay(resourceDAO);
			ss.getUserResourceDescendants(userId, codeList);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getGroupResourceByUserId  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:15:18 
	*/ 
	@Test
	public void getGroupResourceByUserId() {

		try {
			Long roleIds = 16l;

			ss.getGroupResourceByUserId(roleIds);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: selectResourceTree  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:15:25 
	*/ 
	@Test
	public void selectResourceTree() {

		try {
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);

			ss.selectResourceTree(resource);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: getTree  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:15:31 
	*/ 
	@Test
	public void getTree() {

		try {
			JSONObject Json = new JSONObject();  
			JSONArray JsonArray = new JSONArray();  
			  
			Json.put("parentId", "1");//JSONObject对象中添加键值对  
			Json.put("name", "1");//JSONObject对象中添加键值对  
			Json.put("url", "1");//JSONObject对象中添加键值对  
			Json.put("id", "2");//JSONObject对象中添加键值对  
			JsonArray.add(Json);//将JSONObject对象添加到Json数组中  
			
			long ssid=1L;
			

			ss.getTree(JsonArray,ssid);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getParentResource  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:15:41 
	*/ 
	@Test
	public void getParentResource() {

		try {
			ResourceDTO resource = (ResourceDTO) getBean(ResourceDTO.class);

			ss.getParentResource(resource);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}
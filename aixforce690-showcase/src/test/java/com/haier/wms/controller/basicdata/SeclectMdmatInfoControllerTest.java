package com.haier.wms.controller.basicdata;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.basicdata.service.MdmathInfoServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: SeclectMdmatInfoControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月5日 下午5:27:35
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月5日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class,Servlets.class})
public class SeclectMdmatInfoControllerTest {

	private MdmathInfoServiceClient serviceClient;
	private SeclectMdmatInfoController target;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	private MultipartHttpServletRequest multipartHttpServletRequest;
	
	/**
	 * @title: init
	 * @description: 初始化方法
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午4:09:41
	 */
	@Before
	public void init(){
		serviceClient = EasyMock.createMock(MdmathInfoServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		session = EasyMock.createMock(HttpSession.class);
		servletContext = EasyMock.createMock(ServletContext.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		multipartHttpServletRequest = EasyMock.createMock(MultipartHttpServletRequest.class);
		target = new SeclectMdmatInfoController();
		target.setSeleceMaterialInfoService(serviceClient);
		
		PowerMockito.mockStatic(PageUtil.class,UserUtil.class);
		PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
		PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(new PageBean());
	}
	/**
	 * @title: testCreateMaterialInfo
	 * @description: 此方法存在static属性
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午4:11:09
	 */
	@Test
	public void testCreateMaterialInfo() {
		expect(serviceClient.createMdmatInfos((MdMatInfoDTO)anyObject())).andReturn("11");
		replay(serviceClient);
		target.createMaterialInfo(new MdMatInfoDTO());
		assertNotNull(true);
		verify(serviceClient);
	}

	/**
	 * @title: testSelectCountry
	 * @description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午4:12:34
	 */
	@Test
	public void testSelectCountry() {
		Pager<MdMatInfoDTO> pager = new Pager<MdMatInfoDTO>();
		pager.setPageSize(10L);
		pager.setCurrentPage(1L);
		expect(serviceClient.searchMdmaInfo((Pager<MdMatInfoDTO>)anyObject(),(MdMatInfoDTO)anyObject())).andReturn(pager);
		replay(serviceClient);
		String result = target.selectCountry(request, 11L, 11L, new MdMatInfoDTO());
		assertNotNull(result);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.basicdata.SeclectMdmatInfoController#deleteMdmatInfo(java.lang.String)}.
	 */
	@Test
	public void testDeleteMdmatInfo() {
		expect(serviceClient.deleteMdmatInfo((List<Long>)anyObject())).andReturn("111");
		replay(serviceClient);
		String result = target.deleteMdmatInfo("11");
		assertNotNull(result);
	}

	/**
	 * @title: testUpdateMamdtInfo
	 * @description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午4:32:41
	 */
	@Test
	public void testUpdateMamdtInfo() {
		expect(serviceClient.updateMdmatInfo((MdMatInfoDTO)anyObject())).andReturn("111");
		replay(serviceClient);
		target.updateMamdtInfo(new MdMatInfoDTO());
	}

	/**
	 * @title: testExportOdsContractInfo
	 * @description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午4:27:50
	 */
	@Test
	public void testExportOdsContractInfo() throws Exception {
		expect(serviceClient.getMdMatInfoByParam(
				(MdMatInfoDTO)anyObject())
		).andReturn(new ArrayList<MdMatInfoDTO>());
		replay(serviceClient);
		target.exportOdsContractInfo(response, request,
				new MdMatInfoDTO());
	}

	/**
	 * @title: testImportMdMatInfo
	 * @description: 
	 * @return void
	 * @version: v1.0.0
	 * @author: LJZ
	 * @throws Exception 
	 * @date: 2018年9月5日 下午4:32:46
	 */
	@Test
	public void testImportMdMatInfo() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("TEST");
		Iterator<String> l = list.iterator();
		expect(multipartHttpServletRequest.getFileNames()).andReturn(l);
		expect(serviceClient.importMaterialInfo((List<MdMatInfoDTO>)anyObject(),(BaseUser)anyObject())).andReturn("1111");
		//target.importMdMatInfo(multipartHttpServletRequest);
	}

	/**
	 * 
	 * @title: testDownload
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午5:04:21 
	 * @param
	 * @return
	 * @throws IOException 
	 * @throws NoSuchFieldException
	 * @throws SecurityException String
	 */
	@Test
	public void testDownload() throws IOException {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/template/Materail import template.xls");
		//target.download(request);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.basicdata.SeclectMdmatInfoController}.
	 */
	@Test
	public void testDownloadData() {
		expect(serviceClient.downloadData(
				(BaseUser)anyObject(),
				(String)anyObject())
		).andReturn(new InterfaceOutDTO());
		replay(serviceClient);
		target.downloadData("1111");
	}

}

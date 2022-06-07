package com.haier.wms.controller.security;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.multipart.MultipartFile;

import com.haier.openplatform.showcase.utils.Env;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.service.FileUploadServiceClient;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: FileUpDownLoadFileControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 下午1:59:45
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {Env.class})
public class FileUpDownLoadFileControllerTest {

	private FileUploadServiceClient fileUploadServiceClient;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private FileUpDownLoadFileController target;
	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		fileUploadServiceClient = EasyMock.createMock(FileUploadServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		
		target = new FileUpDownLoadFileController();
		target.setFileUploadServiceClient(fileUploadServiceClient);
		target.getFileUploadServiceClient();
		PowerMockito.mockStatic(Env.class);
		PowerMockito.when(Env.getProperty("filesUpload.name")).thenReturn("11");
	}
	
	/**
	 * @title: testDownload
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午2:12:55  void
	 */
	@Test
	public void testDownload() {
		expect(request.getParameter("id")).andReturn("1");
		replay(request);
		
		UploadFile tempFile = new UploadFile();
		tempFile.setFileName("iexplore.exe");
		tempFile.setFilePath1("C:\\Program Files\\internet explorer\\");
		expect(fileUploadServiceClient.getFileInputStreams((Long) anyObject())).andReturn(tempFile);
		replay(fileUploadServiceClient);
		
		try {
			String result = target.download(request, response);
			assertNull(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchFileUploadBySwf
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午2:13:29  void
	 */
	@Test
	public void testSearchFileUploadBySwf() {
		target.searchFileUploadBySwf();
	}

	/**
	 * Test method for {@link com.haier.wms.controller.security.FileUpDownLoadFileController#fileUploadBySwf(org.springframework.web.multipart.MultipartFile, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testFileUploadBySwf() {
		MultipartFile fileInput = createMock(MultipartFile.class);
		
		expect(fileInput.getOriginalFilename()).andReturn("11");
		
		expect(request.getParameter((String) anyObject())).andReturn("11");
		
		try {
			expect(fileInput.getInputStream()).andThrow(new RuntimeException("TestException"));
			replay(fileInput);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		replay(request);
		
		try {
			target.fileUploadBySwf(fileInput, request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

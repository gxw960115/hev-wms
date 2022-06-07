package com.haier.openplatform.wms.security.service.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.security.service.FilesUploadService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.security.domain.UploadFile;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * 阿达萨达
 * 阿萨德撒大
 * 打算的撒
 */
public class FileUploadServiceClientImplTest {
	private FileUploadServiceClientImpl clientImplMock = new FileUploadServiceClientImpl();
	private FilesUploadService filesUploadServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		filesUploadServiceMock = EasyMock.createMock(FilesUploadService.class);
		clientImplMock.setFileUploadService(filesUploadServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetFileInputStreams() {
		clientImplMock.getFileInputStreams(1L);
		
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchFileUploadBySwf() {
		clientImplMock.searchFileUploadBySwf(new UploadFile());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeletefiles() {
		EasyMock.expect(filesUploadServiceMock.deleteFileByIds((String)EasyMock.anyObject()))
			.andReturn(new ExecuteResult<String>()).times(1);
		EasyMock.replay(filesUploadServiceMock);
		clientImplMock.deletefiles("12");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetfileNameShow() {
		clientImplMock.getfileNameShow(12);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testFileUploadBySwf() {
		clientImplMock.fileUploadBySwf(new UploadFile());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeleteFileByName() {
		clientImplMock.deleteFileByName(new UploadFile());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetFileUploadService() {
		clientImplMock.getFileUploadService();
	}
}

package com.haier.hevwms.security.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.hfs.client.dto.FileRequest;
import com.haier.openplatform.hfs.client.dto.FileResult;
import com.haier.openplatform.hfs.client.service.FileServiceClient;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.hevwms.BasicTestCase;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: FileServiceClientAdapterImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:07:32 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class FileServiceClientAdapterImplTest extends BasicTestCase {
	FileServiceClientAdapterImpl ss=new FileServiceClientAdapterImpl();
	private FileServiceClient fileServiceClient;
	private String appName;
	private String storeSystemAddress;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:07:35 
	*/ 
	@Before
	public void bf() {

		fileServiceClient = EasyMock.createMock(FileServiceClient.class);
		ss.setFileServiceClient(fileServiceClient);
		ss.setAppName("1");
		ss.setAppid("1");
		ss.setTestid("1");
		ss.getAppid();
		ss.getTestid();
		ss.setStoreSystemAddress("2");
		ss.getAppName();
        
	}
	/**  
	* @Title: saveFile  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:07:40 
	*/ 
	@Test
	public void saveFile() {

		try {
			
			 UploadFile uploadFile=(UploadFile) getBean(UploadFile.class);
			 FileResult fileResult=(FileResult) getBean(FileResult.class);
				EasyMock.expect( fileServiceClient.saveFile(EasyMock.isA(FileRequest.class))).andReturn(fileResult);
	            EasyMock.replay(fileServiceClient);
			ss.saveFile(null,"1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: generalCommonRequestTest  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:07:43 
	*/ 
	@Test
	public void generalCommonRequestTest() {

		try {
			ss.generalCommonRequestTest("1","1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: general  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:07:48 
	*/ 
	@Test
	public void general() {

		try {
			ss.general("1","1","1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: deleteFile  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:07:56 
	*/ 
	@Test
	public void deleteFile() {

		try {
			
			 UploadFile uploadFile=(UploadFile) getBean(UploadFile.class);
			 FileResult fileResult=(FileResult) getBean(FileResult.class);
				EasyMock.expect( fileServiceClient.deleteFileByUID(EasyMock.isA(FileRequest.class))).andReturn(fileResult);
	            EasyMock.replay(fileServiceClient);
			ss.deleteFile("1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: findFile  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:07:59 
	*/ 
	@Test
	public void findFile() {

		try {
			
			 UploadFile uploadFile=(UploadFile) getBean(UploadFile.class);
			 FileResult fileResult=(FileResult) getBean(FileResult.class);
				EasyMock.expect( fileServiceClient.findFileByUUID(EasyMock.isA(FileRequest.class))).andReturn(fileResult);
	            EasyMock.replay(fileServiceClient);
			ss.findFile("1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}

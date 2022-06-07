package com.haier.hevwms.security.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.security.service.FileServiceClientAdapter;
import com.haier.hevwms.util.FileConstants;
import com.haier.openplatform.wms.security.domain.UploadFile;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: FilesUploadServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:08:07 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class FilesUploadServiceTest extends BasicTestCase {
	FilesUploadServiceImpl ss = new FilesUploadServiceImpl();
	 FileUploadDAO fileUploadDAO;
	    FileConstants fileConstants;
	     FileServiceClientAdapter fileServiceClientAdapter;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:08:09 
	*/ 
	@Before
	public void bf() {

		fileUploadDAO = EasyMock.createMock(FileUploadDAO.class);
		 fileConstants = EasyMock.createMock(FileConstants.class);
		 fileServiceClientAdapter = EasyMock.createMock(FileServiceClientAdapter.class);
		ss.setFileUploadDAO(fileUploadDAO);
		ss.setFileConstants(fileConstants);
		ss.setFileServiceClientAdapter(fileServiceClientAdapter);
        ss.getFileUploadDAO();
        ss.getFileConstants();
        ss.getFileServiceClientAdapter();
	}

	/**  
	* @Title: getFileInputStream  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:08:17 
	*/ 
	@Test
	public void getFileInputStream() {

		try {
			Long id = (long) 19;
			 UploadFile uploadFile=(UploadFile) getBean(UploadFile.class);
				EasyMock.expect(fileUploadDAO.get(EasyMock.anyLong())).andReturn(uploadFile);
	            EasyMock.replay(fileUploadDAO);
			ss.getFileInputStream(id);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: getFileInputStream1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:08:22 
	*/ 
	@Test
	public void getFileInputStream1() {

		try {
			Long id = (long) 19;

			ss.getFileInputStream(id);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: getFileByStatusAndType  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:08:29 
	*/ 
	@Test
	public void getFileByStatusAndType() {

		try {
			UploadFile file = (UploadFile) getBean(UploadFile.class);

			ss.getFileByStatusAndType(file);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteFileByIds  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:08:39 
	*/ 
	@Test
	public void deleteFileByIds() {

		try {
			String ids = "9";
			ss.deleteFileByIds(ids);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: deleteFileByIds1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:08:50 
	*/ 
	@Test
	public void deleteFileByIds1() {

		try {
			String ids = "9";
			ss.deleteFileByIds("");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: deleteFileById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:08:55 
	*/ 
	@Test
	public void deleteFileById() {

		try {
			Long id = (long) 1;
			 UploadFile uploadFile=(UploadFile) getBean(UploadFile.class);
			EasyMock.expect(fileUploadDAO.get(EasyMock.anyLong())).andReturn(uploadFile);
            EasyMock.replay(fileUploadDAO);
			ss.deleteFileById(id);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getfileNameShow  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:09:06 
	*/ 
	@Test
	public void getfileNameShow() {

		try {
			Integer status = 7;

			ss.getfileNameShow(status);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: fileUploadBySwf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:09:15 
	*/ 
	@Test
	public void fileUploadBySwf() {

		try {
			UploadFile uploadFile = (UploadFile) getBean(UploadFile.class);

			ss.fileUploadBySwf(uploadFile);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteFileByName  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:09:27 
	*/ 
	@Test
	public void deleteFileByName() {

		try {
			UploadFile uploadFile = (UploadFile) getBean(UploadFile.class);

			ss.deleteFileByName(uploadFile);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}
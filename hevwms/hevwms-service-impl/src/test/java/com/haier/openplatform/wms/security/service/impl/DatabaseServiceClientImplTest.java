package com.haier.openplatform.wms.security.service.impl;

import org.junit.Test;

public class DatabaseServiceClientImplTest {

	private DatabaseServiceClientImpl clientImplMock = new DatabaseServiceClientImpl();
	
	/** 
	* @Title: test1 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Test
	public void test1() {
		clientImplMock.dbInit();
	}

	/** 
	* @Title: test2 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Test
	public void test2() {
		clientImplMock.changeColumns("CD_LOC_INFO");
	}
	
	/** 
	* @Title: test3 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Test
	public void test3() {
		clientImplMock.pagingSQL("SELECT * FROM CD_LOC_INFO", 1, 10);
		clientImplMock.pagingSQL("SELECT FROM CD_LOC_INFO", 1, 10);
	}
	
	/** 
	* @Title: test4 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Test
	public void test4() {
		clientImplMock.countSQL("SELECT * FROM CD_LOC_INFO");
	}
	
	/** 
	* @Title: test5 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Test
	public void test5() {
		clientImplMock.queryData("SELECT * FROM CD_LOC_INFO", 1, 10);
	}
	
	/** 
	* @Title: test6 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Test
	public void test6() {
		clientImplMock.modifyData("UPDATE CD_LOC_INFO SET MODIFY_BY = 'admin' WHERE ROW_ID = -1 ");
	}
}

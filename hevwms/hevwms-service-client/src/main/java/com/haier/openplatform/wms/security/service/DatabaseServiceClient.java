package com.haier.openplatform.wms.security.service;

import java.util.List;

/** 
* @ClassName: DatabaseServiceClient 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2019年7月20日 下午1:25:22 
*  
*/
public interface DatabaseServiceClient {

	/** 
	* @Title: dbInit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	String dbInit();
	
	/** 
	* @Title: changeColumns 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param tableName
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	String changeColumns(String tableName);
	
	/** 
	* @Title: queryData 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param sql
	* @param @param pageSize
	* @param @param currentPage
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	String queryData(String sql,int pageSize,int currentPage);
	
	/** 
	* @Title: modifyData 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param sql
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	String modifyData(String sql);
	
	/** 
	* @Title: checkProcedure 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prcName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年7月22日
	* @return String    返回类型 
	* @throws 
	*/
	List<String> checkProcedure(String prcName);
}

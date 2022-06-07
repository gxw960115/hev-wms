package com.haier.wms.controller.security;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.wms.security.service.DatabaseServiceClient;

/** 
* @ClassName: DatabaseOperationController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2019年7月20日 下午1:25:42 
*  
*/
@Controller
public class DatabaseOperationController {
	
	@Resource
    private DatabaseServiceClient databaseServiceClient;
	
	/** 
	* @Title: dbInit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "/security/wms/init", method = RequestMethod.POST)
    @ResponseBody
    public String dbInit() {
		return databaseServiceClient.dbInit();
	}
	
	/** 
	* @Title: changeColumns 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param tableName
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "/security/wms/changeColumns", method = RequestMethod.POST)
    @ResponseBody
    public String changeColumns(String tableName) {
		return databaseServiceClient.changeColumns(tableName);
	}
	
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
	@RequestMapping(value = "/security/wms/query", method = RequestMethod.POST)
    @ResponseBody
    public String queryData(String sql,int pageSize,int currentPage) {
		return databaseServiceClient.queryData(sql, pageSize, currentPage);
	}

	/** 
	* @Title: modifyData 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param sql
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "/security/wms/modify", method = RequestMethod.POST)
    @ResponseBody
    public String modifyData(String sql) {
		return databaseServiceClient.modifyData(sql);
	}
	
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
	@RequestMapping(value = "/security/wms/checkProcedure", method = RequestMethod.POST)
    @ResponseBody
    public List<String> checkProcedure(String prcName) {
		return databaseServiceClient.checkProcedure(prcName);
	}
}

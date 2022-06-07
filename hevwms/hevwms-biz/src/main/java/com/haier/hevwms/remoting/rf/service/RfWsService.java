package com.haier.hevwms.remoting.rf.service;

import javax.xml.ws.WebServiceContext;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.RfResult;

/**
 * <p>Description: [RF手持接口 service]</p>
 * Created on 2013-8-2
 * @version 1.0
 */
public interface RfWsService {
	/**
	 * <p>Discription:[通用方法]</p>
	 * @param userCode
	 * @param content
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	RfResult execute(String userCode, Object content);

	/**
	 * <p>Discription:[手持签名校验]</p>
	 * @param userName
	 * @param sign
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	RfLogResult checkSign(String userName, String sign,String version);

	/**
	 * <p>Discription:[手持日志记录]</p>
	 * @param user
	 * @param type
	 * @param sign
	 * @param context
	 * @param status
	 * @param dydate
	 * @param fhdate
	 * @param rcnr
	 * @param ccnr
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void writeLog(String user, String type, String sign, WebServiceContext context, String status, String dydate,
			String fhdate, Object rcnr, Object ccnr);
	/**
	 * 
	 * <p>Discription:[手持程序版本校验]</p>
	 * @return
	 * @author:[李春晖]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
//	RfExeFileLoadResult checkExeFile();
	/**
	 * 
	 * <p>Discription:[手持程序版本下载]</p>
	 * @return
	 * @author:[李春晖]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
//	RfExeFileLoadResult getExeFile();
}

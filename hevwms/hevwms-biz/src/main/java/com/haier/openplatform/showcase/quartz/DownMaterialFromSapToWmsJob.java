package com.haier.openplatform.showcase.quartz;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.sapinterface.DownMaterialFromSap;

/**
 * @Title: DownMaterialFromSapToWmsJob.java
 * @Package: com.haier.openplatform.showcase.quartz
 * @Description: 用一句话描述该文件做什么
 * @author: ZhangLL
 * @date: 2018年11月30日 下午2:37:50
 * @version: V1.0
 */
public class DownMaterialFromSapToWmsJob implements Job {
	
	/**  
	 * @Fields log: 日志处理
	 */
	private static final Logger logger = LoggerFactory.getLogger(DownMaterialFromSapToWmsJob.class);
//	private OperationLogDAO operationLogDAO;
//
//	public DownMaterialFromSapToWmsJob() {
//		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
//	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Download Material Job Start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));

		Calendar cal = Calendar.getInstance();
		// 下载的结束日期
		String end = DateFormatUtils.format(cal, "yyyyMMdd");
		cal.add(Calendar.DATE, -1);
		// 下载的开始日期
		String start = DateFormatUtils.format(cal, "yyyyMMdd");

		DownMaterialFromSap sap = new DownMaterialFromSap("", start, end, start, end, "System");
		sap.exchangeWithSap();

//		OperationLogSaveModel operationLog = new OperationLogSaveModel();// 记录
//		operationLog.setAppName("DownMaterialFromSapToWmsJob");
//		operationLog.setDescription(result);
//		operationLogDAO.save(operationLog);

		logger.info("Download Material Job End:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
	}

}

package com.haier.openplatform.showcase.quartz;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.haier.hevwms.sapinterface.DownloadPoFromSap;

/**
* @ClassName: DownOrderFromSAPToWMSJob
* @Description: TODO(PO自动下载)
* @author linzongxiao
* @Date 2015-12-28 上午10:36:55
*/
public class DownOrderFromSAPToWMSJob implements Job {
    
	private static final Logger logger = Logger.getLogger(DownOrderFromSAPToWMSJob.class); 
	
//	private OperationLogDAO operationLogDAO;

//	public DownOrderFromSAPToWMSJob() {
//		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
//	}
	
	@Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Download PO Job Start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
		
		Calendar cal = Calendar.getInstance();
		// 下载的结束日期
		String end = DateFormatUtils.format(cal, "yyyyMMdd");
		cal.add(Calendar.DATE, -1);
		// 下载的开始日期
		String start = DateFormatUtils.format(cal, "yyyyMMdd");
		
		DownloadPoFromSap sap = new DownloadPoFromSap("", start, end, "System");
		String result = sap.exchangeWithSap();
//		OperationLogSaveModel operationLog = new OperationLogSaveModel();// 记录
//		operationLog.setAppName("DownOrderFromSAPToWMSJob");
//		operationLog.setDescription(result);
//		operationLogDAO.save(operationLog);

		logger.info("Download PO Job End:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
        
    }

}

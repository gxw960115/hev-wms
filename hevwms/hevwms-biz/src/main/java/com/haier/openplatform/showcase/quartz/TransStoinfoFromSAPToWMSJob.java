package com.haier.openplatform.showcase.quartz;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.sapinterface.DownloadStoFromSap;

/**
 * @ClassName: TransStoinfoFromSAPToWMSJob
 * @Description: TODO(自动下载STO)
 * @author linzongxiao
 * @Date 2015-12-28 上午10:05:24
 */
public class TransStoinfoFromSAPToWMSJob implements Job {

	/**
	 * @Fields log: 用一句话描述该文件做什么
	 */
	private static final Logger logger = LoggerFactory.getLogger(TransStoinfoFromSAPToWMSJob.class);
//	private OperationLogDAO operationLogDAO;

//	public TransStoinfoFromSAPToWMSJob() {
//		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
//	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Download Sto Job Start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));

		Calendar cal = Calendar.getInstance();
		// 下载的结束日期
		String end = DateFormatUtils.format(cal, "yyyyMMdd");
		cal.add(Calendar.DATE, -1);
		// 下载的开始日期
		String start = DateFormatUtils.format(cal, "yyyyMMdd");

		DownloadStoFromSap sap = new DownloadStoFromSap(start, end, "", "", "", "admin");
		String result = "";
		try {
			sap.exchangeWithSap();
		} catch (Exception e) {
			result = e.getMessage();
			e.printStackTrace();
		}

		// 保存定时任务记录
//		OperationLogSaveModel operationLog = new OperationLogSaveModel();// 记录
//		operationLog.setAppName("TransStoinfoFromSAPToWMSJob");
//		operationLog.setDescription(result);
//		operationLogDAO.save(operationLog);

		logger.info("Download Sto Job End:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
	}

}

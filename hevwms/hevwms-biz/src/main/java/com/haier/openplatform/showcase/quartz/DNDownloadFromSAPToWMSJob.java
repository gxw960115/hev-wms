package com.haier.openplatform.showcase.quartz;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.sapinterface.DownloadDnFromSap;

/**
* @ClassName: DNDownloadFromSAPToWMSJob
* @Description: TODO(自动下载DN)
* @author linzongxiao
* @Date 2015-12-27 下午5:56:44
*/
public class DNDownloadFromSAPToWMSJob implements Job{
    
	/**  
	 * @Fields log: 用一句话描述该文件做什么
	 */
	private static final Logger logger = LoggerFactory.getLogger(DNDownloadFromSAPToWMSJob.class);

//    private OperationLogDAO operationLogDAO;
//    public DNDownloadFromSAPToWMSJob() {
//		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
//	}
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException { 
    	logger.info("DN Download Job Start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));

        Calendar cal = Calendar.getInstance();
        //下载的结束日期
		String end = DateFormatUtils.format(cal, "yyyyMMdd");
		cal.add(Calendar.DATE, -1);
		//下载的开始日期
		String start = DateFormatUtils.format(cal, "yyyyMMdd");
		
        DownloadDnFromSap sap = new DownloadDnFromSap("", start, end, "System");
        sap.exchangeWithSap();
        //保存定时任务记录
//        OperationLogSaveModel operationLog = new OperationLogSaveModel();//记录
//		operationLog.setAppName("dNDownloadFromSapToWmsJob");
//		operationLog.setDescription(result);
//		operationLogDAO.save(operationLog);
        
		logger.info("DN Download Job End:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
    } 

}

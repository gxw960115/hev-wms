package com.haier.openplatform.showcase.quartz;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.security.service.UserService;
import com.haier.openplatform.util.SpringApplicationContextHolder;
/**
 * 不活跃用户锁定
 * @author SJK
 *
 */
public class LockInactiveAccountJob implements Job{     
	
	/**  
	 * @Fields log: 用一句话描述该文件做什么
	 */
	private static final Logger log = LoggerFactory.getLogger(LockInactiveAccountJob.class); 
	
	private UserService userService;
//	private OperationLogDAO operationLogDao;
	
	public LockInactiveAccountJob(){
		userService = SpringApplicationContextHolder.getBean("userService");
//		operationLogDao = SpringApplicationContextHolder.getBean("operationLogDAO");
	}
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException { 
		
		log.info("Lock Inactive Account Job Start:"+DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
		
		String result = "";
//		OperationLogSaveModel operationLog = new OperationLogSaveModel();//记录
		try{
			userService.lockExpiredUsers();
			result = "Success!";
		}catch(Exception e){
            if (e.toString().length() > 3000) {
            	result = e.toString().substring(0, 3000);
            } else {
            	result = e.toString();
            }
		}
//		operationLog.setAppName("LockInactiveAccountJob");
//		operationLog.setDescription(result);
//        operationLogDao.save(operationLog);
        
        log.info("Lock Inactive Account Job End:"+DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
		
	} 
}

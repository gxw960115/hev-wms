package com.haier.openplatform.showcase.security.advice;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

import com.haier.hevwms.security.service.OperationLogService;
import com.haier.openplatform.log.advice.DefaultOperationLogAdvice;
import com.haier.openplatform.log.config.LogConfiguration;
import com.haier.openplatform.log.domain.OperationLog;
import com.haier.openplatform.security.LoginContext;
import com.haier.openplatform.security.LoginContextHolder;
import com.haier.openplatform.util.HOPConstant;

/**
 * @author WangXuzheng
 *
 */
public class OperationLogAdvice extends DefaultOperationLogAdvice {
	private OperationLogService operationLogService;
	@Override
	protected void saveLog(OperationLog operationLog) {
		operationLogService.save(operationLog);
	}
	public void setOperationLogService(OperationLogService operationLogService) {
		this.operationLogService = operationLogService;
	}
	
	protected OperationLog createOperationLog(ProceedingJoinPoint thisJoinPoint,LogConfiguration logConfiguration){
		LoginContext loginContext = LoginContextHolder.get();
		if(loginContext == null){
			loginContext = new LoginContext();
			loginContext.setUserId(-999L);
			loginContext.setUserName("-SYSTEM-");
		}
		OperationLog operationLog = new OperationLog();
		operationLog.setAppName(HOPConstant.getAppName());
		operationLog.setGmtCreate(new Date());
		operationLog.setGmtModified(new Date());
		operationLog.setUserId(loginContext.getUserId());
		operationLog.setUserName(loginContext.getUserName());
		operationLog.setOperationType(logConfiguration.getType());
		operationLog.setModule(logConfiguration.getModule());
		operationLog.setDescription(executeTemplate(getMessage(logConfiguration.getMessageMap()),thisJoinPoint));
		return operationLog;
	}
}

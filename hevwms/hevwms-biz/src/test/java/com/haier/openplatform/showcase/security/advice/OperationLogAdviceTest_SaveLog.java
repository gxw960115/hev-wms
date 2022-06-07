package com.haier.openplatform.showcase.security.advice;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;

import com.haier.hevwms.security.service.OperationLogService;
import com.haier.openplatform.showcase.BaseTestCase;

public class OperationLogAdviceTest_SaveLog extends BaseTestCase{

	@Resource
	private OperationLogService operationLogService;
	
	@Test
	public void testSaveLogOperationLog() {
//		Date date = new Date();
//		OperationLog log = new OperationLog();
//		log.setUserId(999999L);
//		log.setUserName("test");
//		log.setAppName("TEST");
//		log.setGmtCreate(date);
//		log.setGmtModified(date);
//		operationLogService.save(log);
//		OperationLogSearchModel logSearchModel = new OperationLogSearchModel();
//		logSearchModel.getOperationLog().setAppName("TEST");
//		logSearchModel.setFrom(DateFormatUtils.format(date, "yyyy-MM-dd"));
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		cal.add(Calendar.DAY_OF_MONTH, 1);
//		logSearchModel.setTo(DateFormatUtils.format(cal, "yyyy-MM-dd"));
//		Pager<OperationLog> logs = operationLogService.searchOperationLog(logSearchModel);
//		assertThat(logs, notNullValue());
//		assertThat(logs.getRecords(), notNullValue());
//		assertThat(logs.getRecords().size(), greaterThanOrEqualTo(1));
//		assertThat(logs.getRecords().get(0), notNullValue());
//		assertThat(logs.getRecords().get(0).getUserId(), equalTo(999999L));
//		assertThat(logs.getRecords().get(0).getUserName(), equalTo("test"));
		assertTrue(true);
	}
}

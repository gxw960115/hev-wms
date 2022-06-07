package com.haier.openplatform.showcase.quartz;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.inventory.dao.OdsInventoryInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;

/**
 * @ClassName: OtcCaculateInventoryHistory
 * @Description: 每天定时向ods_inventory_info插入数据
 *
 */
public class OtcCaculateInventoryHistory implements Job {

	/**  
	 * @Fields log: 日志处理
	 */
	private static final Logger logger = LoggerFactory.getLogger(OtcCaculateInventoryHistory.class);

	private OdsInventoryInfoDAO odsInventoryInfoDAO;
//	private OperationLogDAO operationLogDAO;
	
	public OtcCaculateInventoryHistory() {
		odsInventoryInfoDAO = SpringApplicationContextHolder.getBean("odsInventoryInfoDAO");
//		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
    	logger.info("Save Stock Snapshot Job Start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
		try {
			odsInventoryInfoDAO.insertInventory();
		} catch (Exception e) {
			logger.error(e.toString());
		}
		
//		OperationLogSaveModel operationLog = new OperationLogSaveModel();// 记录
//		operationLog.setAppName("OtcCaculateInventoryHistory");
//		operationLog.setDescription("");
//		operationLogDAO.save(operationLog);

		logger.info("Save Stock Snapshot Job End:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
	}
}
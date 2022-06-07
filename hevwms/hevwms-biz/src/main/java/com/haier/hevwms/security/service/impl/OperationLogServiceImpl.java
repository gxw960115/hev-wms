package com.haier.hevwms.security.service.impl;

import java.util.List;

import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSearchModel;
import com.haier.openplatform.log.domain.OperationLog;
import com.haier.openplatform.util.Pager;
import com.haier.hevwms.security.service.OperationLogService;

/**
 * @author WangXuzheng
 *
 */
public class OperationLogServiceImpl implements OperationLogService {
	private OperationLogDAO operationLogDAO;

	public void setOperationLogDAO(OperationLogDAO operationLogDAO) {
		this.operationLogDAO = operationLogDAO;
	}

	@Override
	public void save(OperationLog operationLog) {
		operationLogDAO.save(operationLog);
	}

	@Override
	public Pager<OperationLog> searchOperationLog(OperationLogSearchModel logSearchModel) {
		List<OperationLog> operationLogs = operationLogDAO.searchOperationLog(logSearchModel);
		long size =  operationLogDAO.searchOperationLogCount(logSearchModel);
		return Pager.cloneFromPager(logSearchModel.getPager(),size,operationLogs);
	}
}

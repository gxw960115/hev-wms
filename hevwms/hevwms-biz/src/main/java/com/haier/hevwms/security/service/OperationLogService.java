package com.haier.hevwms.security.service;

import com.haier.hevwms.security.domain.OperationLogSearchModel;
import com.haier.openplatform.log.domain.OperationLog;
import com.haier.openplatform.util.Pager;

public interface OperationLogService {
	public void save(OperationLog operationLog);
	public Pager<OperationLog> searchOperationLog(OperationLogSearchModel logSearchModel);
}

package com.haier.hevwms.security.dao;

import java.util.List;

import com.haier.hevwms.security.domain.OperationLogSearchModel;
import com.haier.openplatform.dao.BaseDAO;
import com.haier.openplatform.log.domain.OperationLog;
import com.haier.openplatform.wms.security.dto.OperationLogDTO;

/**
 * @author WangXuzheng
 *
 */
public interface OperationLogDAO extends BaseDAO<OperationLog, Long>{
	public List<OperationLog> searchOperationLog(OperationLogSearchModel logSearchModel);
	public Long searchOperationLogCount(OperationLogSearchModel logSearchModel);
	public void save(OperationLogDTO log);
}

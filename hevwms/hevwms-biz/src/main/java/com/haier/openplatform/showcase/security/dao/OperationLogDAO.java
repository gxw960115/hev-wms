package com.haier.openplatform.showcase.security.dao;

import java.util.List;

import com.haier.openplatform.dao.BaseDAO;
import com.haier.openplatform.log.domain.OperationLog;
import com.haier.openplatform.showcase.security.domain.OperationLogSaveModel;
import com.haier.openplatform.showcase.security.model.OperationLogSearchModel;

/**
 * @author WangXuzheng
 *
 */
public interface OperationLogDAO extends BaseDAO<OperationLog, Long>{
	public List<OperationLog> searchOperationLog(OperationLogSearchModel logSearchModel);
	public Long searchOperationLogCount(OperationLogSearchModel logSearchModel);
	
	//add by linzx @20160119
	public void save(OperationLogSaveModel logSaveModel);
}

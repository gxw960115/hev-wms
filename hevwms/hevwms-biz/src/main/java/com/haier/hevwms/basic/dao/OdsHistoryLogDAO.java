package com.haier.hevwms.basic.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.hevwms.basic.domain.OdsHistoryLog;

public interface OdsHistoryLogDAO extends CommonDAO<OdsHistoryLog,Long>{
	
	public List<OdsHistoryLog> searchOdsHistoryLogs(@Param("pager") Pager<OdsHistoryLog> pager, @Param("odsHistoryLog") OdsHistoryLog odsHistoryLog);
	public Long searchOdsHistoryLogsCount(@Param("odsHistoryLog") OdsHistoryLog odsHistoryLog);
	public void deleteAll(@Param("idList")List<Long> idList);
}
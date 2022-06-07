package com.haier.hevwms.remoting.rf.dao;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.openplatform.dao.CommonDAO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: RfLogDAO.java
 * @description: 手持日志记录
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月12日 下午3:26:16
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月12日		LJZ			v1.0.0			create
 */

public interface RfLogDAO extends CommonDAO<Object, Long>{
	/**
	 * <p>Discription:[手持日志记录]</p>
	 * @param rfLog
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public void writeLog(@Param("rfLog") RfLog rfLog);
}

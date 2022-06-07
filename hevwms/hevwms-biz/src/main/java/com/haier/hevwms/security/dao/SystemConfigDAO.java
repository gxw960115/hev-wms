package com.haier.hevwms.security.dao;

import org.apache.ibatis.annotations.Param;


/**
 * 用户接口
 * @author WangXuzheng
 *
 */
public interface SystemConfigDAO {
	
	public void fifoConfig(@Param("fifoFlag") String fifoFlag, @Param("fifoPeroid") String fifoPeroid);
	
}

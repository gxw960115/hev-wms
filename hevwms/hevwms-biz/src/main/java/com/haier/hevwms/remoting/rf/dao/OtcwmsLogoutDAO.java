package com.haier.hevwms.remoting.rf.dao;

import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;

/** 
* @ClassName: OtcwmsLogoutDAO 
* @Description: TODO(手持登出) 
* @author Song Yinglong // Nicholas
* @date 2015-11-3 上午10:59:43 
* @param 
*/ 
public interface OtcwmsLogoutDAO extends CommonDAO<Object, Long>{
	/** 
	* @Title: resetSign 
	* @Description: TODO(根据用户名置空用户签名) 
	* @param @param name
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/ 
	public int resetSign(@Param("name")String name);
}

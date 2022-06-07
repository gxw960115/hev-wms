package com.haier.hevwms.remoting.rf.dao;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteOut;

/** 
* @ClassName: OtcwmsOrderDeleteDAO 
* @Description: (手持条码删除) 
* @author Song Yinglong // Nicholas
* @date 2015-11-6 下午3:22:40 
* @param 
*/ 
public interface OtcwmsOrderDeleteDAO extends CommonDAO<Object, Long>{
	/** 
	* @Title: orderDelete 
	* @Description: (手持条码删除) 
	* @param @param in
	* @param @param out    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	void orderDelete(@Param("in")WmsOrderDeleteIn in,@Param("out")WmsOrderDeleteOut out);
}

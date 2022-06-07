package com.haier.hevwms.remoting.rf.dao;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderConfirmIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderConfirmOut;

/**
 * 
 * <p>Description: [手持确认location]</p>
 * Created on 2013-8-12
 * @version 1.0
 */
public interface OtcwmsOrderConfirmDAO extends CommonDAO<Object, Long>{
	/**
	 * <p>Discription:[手持确认location]</p>
	 * @param OtcwmsOrderConfirmIn,OtcwmsOrderConfirmOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderConfirm(@Param("in")WmsOrderConfirmIn in,@Param("out")WmsOrderConfirmOut out);
}

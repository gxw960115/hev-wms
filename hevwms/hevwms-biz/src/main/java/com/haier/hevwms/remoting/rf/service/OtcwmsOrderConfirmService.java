package com.haier.hevwms.remoting.rf.service;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderConfirmIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderConfirmOut;
/**
 * <p>Description: [RF手持单据确认location]</p>
 * Created on 2013-10-16
 * @version 1.0
 */
public interface OtcwmsOrderConfirmService {
	/**
	 * 
	 * <p>Discription:[单据确认location]</p>
	 * @param WmsOrderConfirmIn
	 * @return
	 * @author:[lichhunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderConfirmOut otcwmsOrderConfirm(WmsOrderConfirmIn in);
}

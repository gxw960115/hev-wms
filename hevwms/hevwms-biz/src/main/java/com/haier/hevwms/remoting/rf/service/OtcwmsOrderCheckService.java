package com.haier.hevwms.remoting.rf.service;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckOut;

/**
 * <p>Description: [RF手持单据验证]</p>
 * Created on 2013-10-16
 * @version 1.0
 */
public interface OtcwmsOrderCheckService {
	/**
	 * <p>Discription:[单据验证]</p>
	 * @param otcwmsOrderCheckIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	 WmsOrderCheckOut otcwmsOrderCheck(WmsOrderCheckIn otcwmsOrderCheckIn);
}

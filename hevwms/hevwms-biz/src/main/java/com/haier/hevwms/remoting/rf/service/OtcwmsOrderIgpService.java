package com.haier.hevwms.remoting.rf.service;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;

/**
 * <p>Description: [RF手持过账接口]</p>
 * Created on 2013-10-16
 * @version 1.0
 */
public interface OtcwmsOrderIgpService {
	/**
	 * <p>Discription:[单据过账]</p>
	 * @param WmsOrderIgpIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderIgpOut otcwmsOrderIgp(WmsOrderIgpIn in);
	WmsOrderIgpOut otcwmsOrderIgpOnly(WmsOrderIgpIn in);
	/**
	 * <p>Discription:[单据过账dn]</p>
	 * @param WmsOrderIgpIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderIgpOut otcwmsDnOrderIgp(WmsOrderIgpIn in);
}

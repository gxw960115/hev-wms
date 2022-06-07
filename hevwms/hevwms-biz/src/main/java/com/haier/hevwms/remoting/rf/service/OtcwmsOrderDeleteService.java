package com.haier.hevwms.remoting.rf.service;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteOut;

/**
 * <p>Description: [RF手持条码删除]</p>
 * Created on 2013-10-16
 * @version 1.0
 */
public interface OtcwmsOrderDeleteService {
	/**
	 * <p>Discription:[条码删除]</p>
	 * @param loginPara
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderDeleteOut otcwmsOrderDelete(WmsOrderDeleteIn in);
}

package com.haier.hevwms.remoting.rf.service.impl;

import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderDeleteDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteOut;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderDeleteService;

public class OtcwmsOrderDeleteServiceImpl implements OtcwmsOrderDeleteService {
	private OtcwmsOrderDeleteDAO otcwmsOrderDeleteDAO;
	
	public void setOtcwmsOrderDeleteDAO(OtcwmsOrderDeleteDAO otcwmsOrderDeleteDAO) {
		this.otcwmsOrderDeleteDAO = otcwmsOrderDeleteDAO;
	}

	@Override
	public WmsOrderDeleteOut otcwmsOrderDelete(WmsOrderDeleteIn in) {
		WmsOrderDeleteOut out = new WmsOrderDeleteOut();
		otcwmsOrderDeleteDAO.orderDelete(in, out);
		if("0".equals(out.getStatus()))
		{
			out.setStatus("S");
		}
		else
		{
			out.setStatus("F");
		}
		return out;
	}
	 
}

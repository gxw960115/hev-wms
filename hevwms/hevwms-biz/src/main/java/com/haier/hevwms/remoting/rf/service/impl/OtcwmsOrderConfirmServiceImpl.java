package com.haier.hevwms.remoting.rf.service.impl;

import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderConfirmDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderConfirmIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderConfirmOut;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderConfirmService;

public class OtcwmsOrderConfirmServiceImpl implements OtcwmsOrderConfirmService {
	private OtcwmsOrderConfirmDAO otcwmsOrderConfirmDAO;
	
	public void setOtcwmsOrderConfirmDAO(OtcwmsOrderConfirmDAO otcwmsOrderConfirmDAO) {
		this.otcwmsOrderConfirmDAO = otcwmsOrderConfirmDAO;
	}

	@Override
	public WmsOrderConfirmOut otcwmsOrderConfirm(WmsOrderConfirmIn in) {
		WmsOrderConfirmOut out = new WmsOrderConfirmOut();
		otcwmsOrderConfirmDAO.orderConfirm(in, out);
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

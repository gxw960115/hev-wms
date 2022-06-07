package com.haier.hevwms.remoting.rf.service.impl;

import java.util.List;

//import com.haier.hevwms.interfacePc.webinterface.OtcTrans311AccountFromWMSToSAP;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderMoveStoDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveDoneIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveDoneOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveList;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveListIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveStoIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveStoOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcList;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcListIn;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderMoveService;

public class OtcwmsOrderMoveServiceImpl implements OtcwmsOrderMoveService {
	private OtcwmsOrderMoveStoDAO otcwmsOrderMoveStoDAO;
	
	public void setOtcwmsOrderMoveStoDAO(OtcwmsOrderMoveStoDAO otcwmsOrderMoveStoDAO) {
		this.otcwmsOrderMoveStoDAO = otcwmsOrderMoveStoDAO;
	}
	/**
	 * <p>Discription:[移库上传]</p>
	 * @param WmsOrderMoveStoIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Override
	public WmsOrderMoveStoOut otcwmsOrderMoveSto(WmsOrderMoveStoIn in) {
		WmsOrderMoveStoOut out = new WmsOrderMoveStoOut();
		otcwmsOrderMoveStoDAO.moveStoUpload(in, out);
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
	/**
	 * <p>Discription:[移库完成]</p>
	 * @param WmsOrderMoveDoneIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Override
	public WmsOrderMoveDoneOut otcwmsOrderMoveDone(WmsOrderMoveDoneIn in) {
		WmsOrderMoveDoneOut out = new WmsOrderMoveDoneOut();
		//调用sap
		try
		{
			otcwmsOrderMoveStoDAO.moveStoDoneCheck(in, out);
			if("0".equals(out.getStatus()))
			{
//				OtcTrans311AccountFromWMSToSAP p = new OtcTrans311AccountFromWMSToSAP(in.getSerialno(), in.getUser());
//				p.exchangeWithSap();
				otcwmsOrderMoveStoDAO.moveStoDone(in, out);
				if("0".equals(out.getStatus()))
				{
					out.setStatus("S");
				}
				else
				{
					out.setStatus("F");
				}
			}
			else
			{
				out.setStatus("F");
			}
		}catch (Exception e) {
			out.setStatus("F");
			out.setMsg("error:"+e);
		}
		return out;
	}
	/**
	 * <p>Discription:[先进先出列表查询]</p>
	 * @param WmsOrderXjxcListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Override
	public List<WmsOrderXjxcList> getXjxcList(WmsOrderXjxcListIn in)
	{
		return otcwmsOrderMoveStoDAO.getXjxcList(in);
	}
	/**
	 * <p>Discription:[移库列表查询]</p>
	 * @param WmsOrderMoveListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Override
	public List<WmsOrderMoveList> getMoveList(WmsOrderMoveListIn in)
	{
		return otcwmsOrderMoveStoDAO.getMoveList(in);
	}
	
}

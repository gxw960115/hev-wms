package com.haier.hevwms.remoting.rf.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderUploadDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcOut;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderUploadService;

public class OtcwmsOrderUploadServiceImpl implements OtcwmsOrderUploadService {
    Logger logger = Logger.getLogger(OtcwmsOrderUploadServiceImpl.class);
	private OtcwmsOrderUploadDAO OtcwmsOrderUploadDAO;
	
	public void setOtcwmsOrderUploadDAO(OtcwmsOrderUploadDAO otcwmsOrderUploadDAO) {
		OtcwmsOrderUploadDAO = otcwmsOrderUploadDAO;
	}

	@Override
	public WmsOrderUploadOut otcwmsOrderUpload(WmsOrderUploadIn in) {
	    logger.debug("Entering otcwmsOrderUpload...");
		WmsOrderUploadOut out = new WmsOrderUploadOut();
		//如果输入数量为空  默认为1
		if(CommonTool.isNull(in.getQty())||"0".equals(in.getQty()))
		{
			in.setQty("1");
		}
		//如果条码数量  大于20  报错
		if(!CommonTool.isNull(in.getBarcode()))
		{
			if(in.getBarcode().trim().length()>20||in.getBarcode().trim().length()<10)
			{
				out.setStatus("F");
				out.setMsg("The barcode does not conform to the rules!");
				return out;
			}
		}
		
		if("PD".equals(in.getDoctype()))
		{
			OtcwmsOrderUploadDAO.orderUploadPD(in, out);  
		}
		else
		{
			OtcwmsOrderUploadDAO.orderUpload(in, out);  //prc_barcode_check
		}
		return out;
	}
	/**
	 * <p>Discription:[先进先出校验]</p>
	 * @param WmsOrderXjxcIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Override
	public WmsOrderXjxcOut otcwmsOrderXjxcCheck(WmsOrderXjxcIn in) {
		WmsOrderXjxcOut out = new WmsOrderXjxcOut();
		OtcwmsOrderUploadDAO.orderXjxcChcek(in, out);
		return out;
	}

	/**
	 * 
	* @Title: offlineScan
	* @Description: 离线扫描
	* @param @param paramsIn
	* @param @return
	* @return Map<String,String>
	* @throws
	 */
	@Override
	public Map<String, String> offlineScan(List<WmsOrderUploadIn> paramsIn) {
		Map<String , String> result = new HashMap<String, String>();
		for (WmsOrderUploadIn otcwmsOrderUploadIn : paramsIn) {
			WmsOrderUploadOut out = otcwmsOrderUpload(otcwmsOrderUploadIn);
			if(!"0".equals(out.getStatus())){
				result.put(otcwmsOrderUploadIn.getBarcode(), out.getStatus()+"&&"+out.getMsg());
			}
		}
		return result;
	}
}

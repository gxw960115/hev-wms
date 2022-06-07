package com.haier.hevwms.remoting.rf.service;

import java.util.List;
import java.util.Map;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcOut;

/**
 * <p>Description: [单据条码扫描上传]</p>
 * Created on 2013-10-16
 * @version 1.0
 */
public interface OtcwmsOrderUploadService {
	/**
	 * <p>Discription:[单据上传]</p>
	 * @param WmsOrderUploadIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderUploadOut otcwmsOrderUpload(WmsOrderUploadIn in);
	/**
	 * <p>Discription:[先进先出校验]</p>
	 * @param WmsOrderXjxcIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderXjxcOut otcwmsOrderXjxcCheck(WmsOrderXjxcIn in);
	
	/**
	 * 
	* @Title: offlineScan
	* @Description: 离线扫描
	* @param @param paramsIn
	* @param @return
	* @return Map<String,String>
	* @throws
	 */
	Map<String , String> offlineScan(List<WmsOrderUploadIn> paramsIn);
}

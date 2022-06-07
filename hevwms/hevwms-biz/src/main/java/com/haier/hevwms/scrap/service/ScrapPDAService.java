package com.haier.hevwms.scrap.service;

import javax.xml.ws.WebServiceContext;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ScrapPDAService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月13日 上午10:12:38
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月13日		LJZ			v1.0.0			create
 */

public interface ScrapPDAService {
	/**
	 * @title: checkSign
	 * @description: 手持Scrap_签名校验
	 * @author: LJZ
	 * @date: 2018年10月30日 下午5:57:33
	 * @param user
	 * @param sign
	 * @param version
	 * @return: RfLogResult
	 */
	RfLogResult checkSign(String user, String sign, String version);

	/**
	 * @title: writeLog
	 * @description: 手持Scrap_日志记录
	 * @author: LJZ
	 * @date: 2018年10月30日 下午5:58:16
	 * @param user
	 * @param string
	 * @param sign
	 * @param context
	 * @param status
	 * @param formatDateToStr
	 * @param formatDateToStr2
	 * @param dto
	 * @param result
	 * @return: void
	 */
	void writeLog(String user, String type, String sign,
			WebServiceContext context, String status, String dydate,
			String fhdate, Object rcnr, Object ccnr);

	/**
	 * @title: scrapOrderDelete
	 * @description: 手持Scrap_扫描单 删除
	 * @author: LJZ
	 * @date: 2018年10月31日 下午5:58:25
	 * @param in
	 * @return: OtcwmsOrderDeleteOut
	 */
	OrderDeleteOutDTO scrapOrderDelete(OrderDeleteInDTO in);

	/**
	 * @title: scanScrapCheck
	 * @description: 手持Scrap_扫描检查
	 * @author: LJZ
	 * @date: 2018年11月6日 下午5:06:49 
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO scanScrapCheck(OrderUploadInDTO inpara);

	/**
	 * @title: scrapOrderIgp
	 * @description: 手持Scrap_过账Service
	 * @author: LJZ
	 * @date: 2018年11月7日 上午10:41:20 
	 * @param inpara
	 * @return: WmsOrderIgpOutDTO
	 */
	WmsOrderIgpOut scrapOrderIgp(WmsOrderIgpIn in);
	
	/**  
	* @Title: scanStatus  
	* @Description: 检测订单扫描状态
	* @author: ZhangLL
	* @param orno
	* @return long
	* @throws  
	*/
	public long scanStatus(String orno);

	/**  
	* @Title: updateSapInfo  
	* @Description: 更改信息
	* @author: ZhangLL
	* @param inpara void
	* @throws  
	*/
	public void updateSapInfo(OrderIgpInDTO inpara);
}

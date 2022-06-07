package com.haier.hevwms.po.service;

import javax.xml.ws.WebServiceContext;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: PoPDAService.java
 * @description: PO 的 PDA 相关功能
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午2:51:12
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public interface PoPDAService {

	/**
	 * @title: checkSign
	 * @description: 手持PO_签名校验
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月30日 下午5:57:33
	 * @param user
	 * @param sign
	 * @param version
	 * @return: RfLogResult
	 */
	RfLogResult checkSign(String user, String sign, String version);

	/**
	 * @title: writeLog
	 * @description: 手持PO_日志记录
	 * @author: LJZ
	 * @version: v1.0.0
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
	 * @title: poOrderDelete
	 * @description: 手持PO_扫描单 删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:58:25
	 * @param in
	 * @return: OtcwmsOrderDeleteOut
	 */
	OrderDeleteOutDTO poOrderDelete(OrderDeleteInDTO in);
	
	/**
	 * @title: poOrderDelete
	 * @description: 手持PO_扫描单 删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:58:25
	 * @param in
	 * @return: OtcwmsOrderDeleteOut
	 */
	OrderDeleteOutDTO giftPoOrderDelete(OrderDeleteInDTO in);

	/**
	 * @title: scanPoCheck
	 * @description: 手持PO_扫描检查
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月6日 下午5:06:49 
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO scanPoCheck(OrderUploadInDTO inpara);
	

	/**
	 * @title: scanPoCheck
	 * @description: 手持PO_扫描检查
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月6日 下午5:06:49 
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO scanGiftPoCheck(OrderUploadInDTO inpara);

	/**
	 * @title: poOrderIgp
	 * @description: 手持PO_过账Service
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午10:41:20 
	 * @param inpara
	 * @return: WmsOrderIgpOutDTO
	 */
	OrderIgpOutDTO poOrderIgp(OrderIgpInDTO inpara);
	
	/**
	 * @title: poOrderIgp
	 * @description: 手持PO_过账Service
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午10:41:20 
	 * @param inpara
	 * @return: WmsOrderIgpOutDTO
	 */
	OrderIgpOutDTO giftPoOrderIgp(OrderIgpInDTO inpara);

}

package com.haier.hevwms.so.service;

import javax.xml.ws.WebServiceContext;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

public interface SoPDAService {

	/**
	 * @title: checkSign
	 * @description: 手持签名校验
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
	 * @description: 手持日志记录
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
	 * @title: soOrderDelete
	 * @description: SO扫描单 删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:58:25
	 * @param in
	 * @return: OtcwmsOrderDeleteOut
	 */
	OrderDeleteOutDTO soOrderDelete(OrderDeleteInDTO in);
	
	/**
	 * @title: soOrderDelete
	 * @description: SO扫描单 删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:58:25
	 * @param in
	 * @return: OtcwmsOrderDeleteOut
	 */
	OrderDeleteOutDTO giftSoOrderDelete(OrderDeleteInDTO in);

	/**
	 * @title: scanSoCheck
	 * @description: 手持扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月6日 下午5:06:49
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO scanSoCheck(OrderUploadInDTO inpara);
	OrderUploadOutDTO scanSoOldBarcodeCheck(OrderUploadInDTO inpara);
	
	OrderUploadOutDTO scanGiftSoCheck(OrderUploadInDTO inpara);

	/**
	 * @title: soOrderIgp
	 * @description: 手持_过账Service
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午10:41:20
	 * @param inpara
	 * @return: WmsOrderIgpOutDTO
	 */
	OrderIgpOutDTO soOrderIgp(OrderIgpInDTO inpara);
	
	/**
	 * @title: soOrderIgp
	 * @description: 手持_过账Service
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午10:41:20
	 * @param inpara
	 * @return: WmsOrderIgpOutDTO
	 */
	OrderIgpOutDTO giftSoOrderIgp(OrderIgpInDTO inpara);

}

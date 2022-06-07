package com.haier.hevwms.sto.service;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.openplatform.wms.remoting.dto.*;

import javax.xml.ws.WebServiceContext;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StoPDAService.java
 * @description: STO 的 PDA 相关功能
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午5:51:07
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public interface StoPDAService {

	/**
	 * @title: checkSign
	 * @description: 手持STO_签名校验
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
	 * @description: 手持STO_日志记录
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
	 * @title: stoOrderDelete
	 * @description: 手持STO_扫描单 删除
	 * @author: LJZ
	 * @date: 2018年10月31日 下午5:58:25
	 * @param in
	 * @return: OtcwmsOrderDeleteOut
	 */
	OrderDeleteOutDTO stoOrderDelete(OrderDeleteInDTO in);

	/**
	 * 手持STODN_扫描单 删除
	 * @param in
	 * @return
	 */
	OrderDeleteOutDTO stodnOrderDelete(OrderDeleteInDTO in);

	/**
	 * @title: scanStoCheck
	 * @description: 手持STO_扫描检查
	 * @author: LJZ
	 * @date: 2018年11月6日 下午5:06:49 
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO scanStoCheck(OrderUploadInDTO inpara);

	/**
	 * 手持STODN_条码扫描
	 * stodn 出库
	 * @param inpara
	 * @return
	 */
	OrderUploadOutDTO scanStoDnOutCheck(OrderUploadInDTO inpara);

	/**
	 * 手持STODN_条码扫描
	 * stodn 入库
	 * @param inpara
	 * @return
	 */
	OrderUploadOutDTO scanStoDnInCheck(OrderUploadInDTO inpara);

	/**
	 * @title: scanStodnCheck
	 * @description: 手持STO_扫描检查
	 * @author: LJZ
	 * @date: 2018年11月6日 下午5:06:49 
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO scanStodnCheck(OrderUploadInDTO inpara);

	
	/**
	 * @title: stoOrderIgp
	 * @description: 手持STO_过账Service
	 * @author: LJZ
	 * @date: 2018年11月7日 上午10:41:20 
	 * @param inpara
	 * @return: WmsOrderIgpOutDTO
	 */
	OrderIgpOutDTO stoOrderOgp(OrderIgpInDTO inpara);
	
	public OrderIgpOutDTO stodnOrderIgp(OrderIgpInDTO inpara) ;
}

package com.haier.openplatform.wms.consume.service;

import com.haier.openplatform.wms.remoting.dto.*;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ConsumePDAServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月12日 下午2:50:04
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月12日		LJZ			v1.0.0			create
 */

public interface ConsumePDAServiceClient {
	/**
	 * @title: ConsumeOrderCheck
	 * @description: 手持Consume_检查一下订单是否存在是否需要下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月30日 下午5:47:44 
	 * @param dto
	 * @param version
	 * @return
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO consumeOrderCheck(OrderCheckInDTO dto, String version);

	/**
	 * @title: consumeOrderDownload
	 * @description: 手持Consume_调用SAP下载订单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 上午10:58:15 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderLoadOutDTO
	 */
	public OrderLoadOutDTO consumeOrderDownload(OrderLoadInDTO inpara, String version);

	/**
	 * @title: consumeOrderDelete
	 * @description: 手持Consume_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO consumeOrderDelete(OrderDeleteInDTO inpara, String version);
	/**
	 * @title: consumeOrderDelete
	 * @description: 手持Consume_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO consumeOrdersDelete(OrderDeleteInDTO inpara, String version);

	/**
	 * @title: consumeOrderIgp
	 * @description: 手持Consume_IGP
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:11:39 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	public OrderIgpOutDTO consumeOrderIgp(OrderIgpInDTO inpara, String version ,String sapFlag) throws IllegalAccessException, InvocationTargetException ;

	/**  
	* @Title: orderPosting  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param inpara
	* @param sapFlag
	* @return
	* @throws IllegalAccessException
	* @throws InvocationTargetException OrderIgpOutDTO
	* @throws  
	*/
	public OrderIgpOutDTO orderPosting(OrderIgpInDTO inpara,String sapFlag) throws IllegalAccessException, InvocationTargetException ;
	
	/**
	 * @title: barcodeList
	 * @description: 手持PS_查询条码明细
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:24:34 
	 * @param inpara
	 * @return
	 * @return: OtcwmsOrderDelListOutDTO
	 */
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara);

	/**
	 * @title: consumeOrderUpload
	 * @description: 手持Consume_扫条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:46:56 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderUploadOutDTO
	 */
	public OrderUploadOutDTO consumeOrderScan(OrderUploadInDTO inpara, String version);
}

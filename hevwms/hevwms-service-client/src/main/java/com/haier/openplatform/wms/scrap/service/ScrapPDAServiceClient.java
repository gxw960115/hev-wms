package com.haier.openplatform.wms.scrap.service;

import com.haier.openplatform.wms.remoting.dto.*;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ScrapPDAServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月13日 上午10:20:40
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月13日		LJZ			v1.0.0			create
 */

public interface ScrapPDAServiceClient {
	/**
	 * @title: ScrapOrderCheck
	 * @description: 手持Scrap_检查一下订单是否存在是否需要下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月30日 下午5:47:44 
	 * @param dto
	 * @param version
	 * @return
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO scrapOrderCheck(OrderCheckInDTO dto, String version);

	/**
	 * @title: scrapOrderDownload
	 * @description: 手持Scrap_调用SAP下载订单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 上午10:58:15 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderLoadOutDTO
	 */
	public OrderLoadOutDTO scrapOrderDownload(OrderLoadInDTO inpara, String version);

	/**
	 * @title: scrapOrderDelete
	 * @description: 手持Scrap_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO scrapOrderDelete(OrderDeleteInDTO inpara, String version);
	/**
	 * @title: scrapOrderDelete
	 * @description: 手持Scrap_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO scrapOrdersDelete(OrderDeleteInDTO inpara, String version);

	/**
	 * @title: scrapOrderIgp
	 * @description: 手持Scrap_IGP
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:11:39 
	 * @param inpara
	 * @param version
	 * @param sapFlag
	 * @return
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	public OrderIgpOutDTO scrapOrderIgp(OrderIgpInDTO inpara, String version,String sapFlag) throws IllegalAccessException, InvocationTargetException;

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
	 * @title: scrapOrderUpload
	 * @description: 手持Scrap_扫条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:46:56 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderUploadOutDTO
	 */
	public OrderUploadOutDTO scrapOrderScan(OrderUploadInDTO inpara, String version);

}

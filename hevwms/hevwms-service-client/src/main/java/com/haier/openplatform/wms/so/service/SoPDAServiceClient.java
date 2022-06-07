package com.haier.openplatform.wms.so.service;

import com.haier.openplatform.wms.remoting.dto.*;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: SoPDAServiceClient.java
 * @description: 手持SO_Client
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月8日 上午10:28:15
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月8日		LJZ			v1.0.0			create
 */

public interface SoPDAServiceClient {
	
	/**
	 * @title: soOrderCheck
	 * @description: 手持SO_检查一下订单是否存在是否需要下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月30日 下午5:47:44
	 * @param dto
	 * @param version
	 * @return
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO soOrderCheck(OrderCheckInDTO dto, String version);

	/**
	 * @title: soOrderDownload
	 * @description: 手持SO_调用SAP下载订单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 上午10:58:15
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderLoadOutDTO
	 */
	public OrderLoadOutDTO soOrderDownload(OrderLoadInDTO inpara, String version);

	/**
	 * @title: soOrderDelete
	 * @description: 手持SO_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO soOrderDelete(OrderDeleteInDTO inpara, String version);

	/**
	 * @title: soOrderDelete
	 * @description: 手持SO_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO giftSoOrderDelete(OrderDeleteInDTO inpara, String version);

	/**
	 * @title: soOrderDelete
	 * @description: 手持SO_ 订单循环删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO soOrdersDelete(OrderDeleteInDTO inpara, String version);

	/**
	 * @title: soOrderIgp
	 * @description: 手持SO_IGP
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:11:39
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	public OrderIgpOutDTO soOrderIgp(OrderIgpInDTO inpara, String version);
	
	/**
	 * @title: soOrderIgp
	 * @description: 手持SO_IGP
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:11:39
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	public OrderIgpOutDTO giftSoOrderIgp(OrderIgpInDTO inpara, String version);

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
	 * @title: soOrderUpload
	 * @description: 手持SO_扫条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:46:56
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderUploadOutDTO
	 */
	public OrderUploadOutDTO soOrderScan(OrderUploadInDTO inpara, String version);
	/**
	 * @title: soOrderUpload
	 * @description: 手持SO_扫条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:46:56
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderUploadOutDTO
	 */
	public OrderUploadOutDTO giftSoOrderScan(OrderUploadInDTO inpara, String version);
	/** 
	* @Title: soOrderScanOldBarcode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param inpara
	* @param @param version
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return OrderUploadOutDTO    返回类型 
	* @throws 
	*/
	public OrderUploadOutDTO soOrderScanOldBarcode(OrderUploadInDTO inpara, String version);

	/** 
	* @Title: getFifo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param inpara
	* @param @param location
	* @param @param materialNo
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return WmsOrderDelListOutDTO    返回类型 
	* @throws 
	*/
	public WmsOrderDelListOutDTO getFifo(WmsOrderDelListInDTO inpara, String location, String materialNo);

	/**
	 * 直发派遣 导入So出库单Excel
	 * @param inpara
	 * @return
	 */
	public OrderUploadOutDTO soOrderScanBarcodeExcel(OrderUploadInDTO inpara);
}

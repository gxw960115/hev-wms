package com.haier.openplatform.wms.sto.service;

import com.haier.openplatform.wms.remoting.dto.*;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StoPDAServiceClient.java
 * @description: STO PDA 操作 Client
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月31日 上午10:29:43
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月31日		LJZ			v1.0.0			create
 */

public interface StoPDAServiceClient {

	/**
	 * @title: stoOrderCheck
	 * @description: 手持STO_检查订单是否需要下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:46:56 
	 * @param inpara
	 * @param version
	 * @return: OrderCheckOutDTO
	 */
	OrderCheckOutDTO stoOrderCheck(OrderCheckInDTO inpara, String version);

	/**
	 * @title: stoOrderDownload
	 * @description: 手持STO_调用SAP接口，下载STO订单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:47:24 
	 * @param inpara
	 * @param version
	 * @return: OrderLoadOutDTO
	 */
	OrderLoadOutDTO stoOrderDownload(OrderLoadInDTO inpara, String version, String stoNo);

	/**
	 * @title: stoOrderDelete
	 * @description: 手持STO_删除扫描的订单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:47:45 
	 * @param inParam
	 * @param version
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	OrderDeleteOutDTO stoOrderDelete(OrderDeleteInDTO inParam, String version);

	/**
	 * @title: stoOrderDelete
	 * @description: 手持STO_删除扫描的订单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:47:45
	 * @param inParam
	 * @param version
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	OrderDeleteOutDTO stoOrdersDelete(OrderDeleteInDTO inParam, String version);

	/**
	 * 手持STODN_删除扫描的订单
	 * @param inParam
	 * @param version
	 * @return
	 */
	OrderDeleteOutDTO stodnScanDelete(OrderDeleteInDTO inParam, String version);

	/**
	 * @title: stoOrderIgp
	 * @description: 手持STO_订单过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:48:01 
	 * @param inpara
	 * @param version
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	OrderIgpOutDTO stoOrderIgp(OrderIgpInDTO inpara, String version);
	
	/**
	 * @title: stoOrderIgp
	 * @description: 手持STO_订单过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:48:01 
	 * @param inpara
	 * @param version
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	OrderIgpOutDTO stoOrderOgp(OrderIgpInDTO inpara, String version);

	/**
	 * @title: barcodeList
	 * @description: 手持STO_获取条码列表
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:50:29 
	 * @param inpara
	 * @return: OtcwmsOrderDelListOutDTO
	 */
	WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara);

	/**
	 * 手持STODN_获取条码列表
	 * @param inpara
	 * @return
	 */
	WmsOrderDelListOutDTO getBarcodeList(WmsOrderDelListInDTO inpara);

	/**
	 * @title: stoOrderUpload
	 * @description: 手持STO_条码扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:50:45 
	 * @param inpara
	 * @param version
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO stoOrderUpload(OrderUploadInDTO inpara, String version);

	/**
	 * 手持STODN_条码扫描
	 * @param inpara
	 * @return
	 */
	OrderUploadOutDTO stodnInfoUpload(OrderUploadInDTO inpara);

	/**
	 * @title: stoOrderUpload
	 * @description: 手持STO_条码扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月5日 上午10:50:45 
	 * @param inpara
	 * @param version
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO stodnOrderUpload(OrderUploadInDTO inpara, String version);

    /** 
    * @Title: inoutWarehouseSto 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param orderNo
    * @param @param orderType
    * @param @param userName
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    String inoutWarehouseSto(String orderNo, String orderType, String userName);


	/**
	 * @title: stoOrderUpload
	 * 直发派遣 导入STO入库单Excel
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO stodnOrderUploadExcel(OrderUploadInDTO inpara);



	/**
	 * @title: stoOrderUpload
	 * @description: 直发派遣STO单出库  导入Excel
	 * @param inpara
	 * @return: OrderUploadOutDTO
	 */
	OrderUploadOutDTO stoOrderUploadExcel(OrderUploadInDTO inpara);
}

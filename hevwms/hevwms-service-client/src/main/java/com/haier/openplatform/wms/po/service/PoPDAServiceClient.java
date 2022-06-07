package com.haier.openplatform.wms.po.service;

import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: PoPDAServiceClient.java
 * @description: 关于PO的PDA
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午2:16:16
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public interface PoPDAServiceClient {
	
	/**
	 * @title: poOrderCheck
	 * @description: 手持PO_检查一下订单是否存在是否需要下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月30日 下午5:47:44 
	 * @param dto
	 * @param version
	 * @return
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO poOrderCheck(OrderCheckInDTO dto, String version);
	
	/**
	 * @title: poOrderCheck
	 * @description: 手持PO_检查一下订单是否存在是否需要下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月30日 下午5:47:44 
	 * @param dto
	 * @param version
	 * @return
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO giftPoOrderCheck(OrderCheckInDTO dto, String version);

	/**
	 * @title: poOrderDownload
	 * @description: 手持PO_调用SAP下载订单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 上午10:58:15 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderLoadOutDTO
	 */
	public OrderLoadOutDTO poOrderDownload(OrderLoadInDTO inpara, String version);

	/**
	 * @title: poOrderDelete
	 * @description: 手持PO_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO poOrderDelete(OrderDeleteInDTO inpara, String version);
	
	/**
	 * @title: poOrderDelete
	 * @description: 手持PO_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO giftPoOrderDelete(OrderDeleteInDTO inpara, String version);

	/**
	 * @title: poOrderDelete
	 * @description: 手持PO_订单删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午5:02:13
	 * @param inParam
	 * @param version
	 * @return
	 * @return: OtcwmsOrderDeleteOutDTO
	 */
	public OrderDeleteOutDTO poOrdersDelete(OrderDeleteInDTO inParam, String version);

	/**
	 * @title: poOrderIgp
	 * @description: 手持PO_IGP
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:11:39 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	public OrderIgpOutDTO poOrderIgp(OrderIgpInDTO inpara, String version);
	
	/**
	 * @title: poOrderIgp
	 * @description: 手持PO_IGP
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:11:39 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OtcwmsOrderIgpOutDTO
	 */
	public OrderIgpOutDTO giftPoOrderIgp(OrderIgpInDTO inpara, String version);

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
	 * @title: poOrderUpload
	 * @description: 手持PO_扫条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:46:56 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderUploadOutDTO
	 */
	public OrderUploadOutDTO poOrderScan(OrderUploadInDTO inpara, String version);
	
	/**
	 * @title: poOrderUpload
	 * @description: 手持PO_扫条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:46:56 
	 * @param inpara
	 * @param version
	 * @return
	 * @return: OrderUploadOutDTO
	 */
	public OrderUploadOutDTO giftPoOrderScan(OrderUploadInDTO inpara, String version);


	/**
	 * 直发派遣 导入po单Excel
	 * @param inpara
	 * @return
	 */
	public OrderUploadOutDTO poOrderScanExcel(OrderUploadInDTO inpara);
}

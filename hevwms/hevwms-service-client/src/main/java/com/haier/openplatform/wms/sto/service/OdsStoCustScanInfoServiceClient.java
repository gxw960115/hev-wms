package com.haier.openplatform.wms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Package: com.haier.openplatform.wms.sto.service
 * @Description: 用一句话描述该文件做什么
 * @Author: ZhangLL
 * @Date: 2018/12/18
 * @Version: V1.0
 */
public interface OdsStoCustScanInfoServiceClient {

	/**
	 * @title: searchOdsStoCustScanInfoByPage
	 * @description: 
	 * @author: ZhangLL
	 * @version: v1.0.0
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 * @return: Pager<OdsStoCustScanInfoDTO>
	 */
	Pager<OdsStoCustScanInfoDTO> searchOdsStoCustScanInfoByPage(Long page, Long rows,
                                                        OdsStoCustScanInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 
	 * @author: ZhangLL
	 * @version: v1.0.0
	 * @param dto
	 * @return
	 * @return: Long
	 */
	Long getExportAmount(OdsStoCustScanInfoDTO dto);

	/**
	 * @title: getOdsSoScanInfos
	 * @description: 
	 * @author: ZhangLL
	 * @version: v1.0.0
	 * @param dto
	 * @return
	 * @return: List<OdsStoCustScanInfoDTO>
	 */
	List<OdsStoCustScanInfoDTO> getOdsStoCustScanInfos(OdsStoCustScanInfoDTO dto);

	/**
	 * @Title: orderDelete
	 * @Description: 订单删除,手持
	 * @author: ZhangLL
	 * @param inpara
	 * @param version
	 * @return OrderDeleteOutDTO
	 * @throws
	 */
	public OrderDeleteOutDTO orderDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;

	/**
	 * @Title: orderDelete
	 * @Description: 订单删除(多选),手持
	 * @author: ZhangLL
	 * @param inpara
	 * @param version
	 * @return OrderDeleteOutDTO
	 * @throws
	 */
	public OrderDeleteOutDTO ordersDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;

	/**
	 * @Title: orderScan
	 * @Description: 手持扫码
	 * @author: ZhangLL
	 * @param inpara
	 * @param version
	 * @return OrderUploadOutDTO
	 * @throws
	 */
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;


	/**
	 * @Title: barcodeList
	 * @Description: 查询订单已扫描信息
	 * @author: ZhangLL
	 * @param inpara
	 * @return WmsOrderDelListOutDTO
	 * @throws
	 */
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara);

}

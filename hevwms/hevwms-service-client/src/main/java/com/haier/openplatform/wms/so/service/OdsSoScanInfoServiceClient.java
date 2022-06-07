package com.haier.openplatform.wms.so.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoScanInfoServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 上午10:22:58
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public interface OdsSoScanInfoServiceClient {
	/**
	 * @title: searchOdsPoScanInfoByPage
	 * @description: 根据条件分页查询PO Scan Info
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:15:17 
	 * @param page
	 * @param rows
	 * @param OdsSoScanInfoDTO
	 * @return: Pager<OdsOrderInfoDtlDTO>
	 */
	Pager<OdsSoScanInfoDTO> searchOdsPoScanInfoByPage(Long page, Long rows, OdsSoScanInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 查询Po导出数量
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午3:49:28 
	 * @param OdsOrderInfoDtlDTO
	 * @return: Long
	 */
	Long getExportAmount(OdsSoScanInfoDTO dto);

	/**
	 * @title: getOdsPoScanInfos
	 * @description: 导出到excel表
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午4:03:26 
	 * @param dto
	 * @return
	 * @return: List<OdsSoScanInfoDTO>
	 */
	List<OdsSoScanInfoDTO> getOdsPoScanInfos(OdsSoScanInfoDTO dto);
	
	/**
	 * @title: printSoDetail
	 * @description: 分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月18日 下午7:16:33 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: byte[]
	 */
	public byte[] printSoDetail(String filePath, Map<String, Object> parameters);
	
	/** 
	* @Title: updateOldBarcode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsSoScanInfoDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String updateOldBarcode(OdsSoScanInfoDTO odsSoScanInfoDTO) ;
}

package com.haier.openplatform.wms.sto.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoScanInfoServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 下午6:22:19
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public interface OdsStoScanInfoServiceClient {

	/**
	 * @title: searchOdsStoScanInfoByPage
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月19日 下午6:22:27 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 * @return: Pager<OdsStoScanInfoDTO>
	 */
	Pager<OdsStoScanInfoDTO> searchOdsStoScanInfoByPage(Long page, Long rows,
			OdsStoScanInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月19日 下午6:22:32 
	 * @param dto
	 * @return
	 * @return: Long
	 */
	Long getExportAmount(OdsStoScanInfoDTO dto);

	/**
	 * @title: getOdsSoScanInfos
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月19日 下午6:22:36 
	 * @param dto
	 * @return
	 * @return: List<OdsStoScanInfoDTO>
	 */
	List<OdsStoScanInfoDTO> getOdsStoScanInfos(OdsStoScanInfoDTO dto);

	/** 
	* @Title: printStoDetail 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param filePath
	* @param @param parameters
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return byte[]    返回类型 
	* @throws 
	*/
	byte[] printStoDetail(String filePath, Map<String, Object> parameters);

	/**
	 * @title: getExportOdsStoDnScanInfoAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @param dto
	 * @return: Long
	 */
	Long getExportOdsStoDnScanInfoAmount(OdsStodnScanInfoDTO dto);

	/**
	 * @title: getStoDnScanInfoListByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @param dto
	 * @return: List<OdsStodnScanInfoDTO>
	 */
	List<OdsStodnScanInfoDTO> getStoDnScanInfoListByParm(OdsStodnScanInfoDTO dto);

}

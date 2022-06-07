package com.haier.hevwms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoGigrInfoService.java
 * @description:
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午4:10:00
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public interface OdsStoGigrInfoService {

	/**
	 * @title: getListByPage
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月15日 下午5:35:37
	 * @param pager
	 * @param dto
	 * @return: Pager<OdsStoGigrInfoDTO>
	 */
	Pager<OdsStoGigrInfoDTO> getListByPage(Pager<OdsStoGigrInfoDTO> pager,
			OdsStoGigrInfoDTO dto);

	/**
	 * @title: getOdsStoGigrInfoCountByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月15日 下午5:35:42
	 * @param dto
	 * @return: Long
	 */
	Long getOdsStoGigrInfoCountByParm(OdsStoGigrInfoDTO dto);

	/**
	 * @title: getOdsStoDnGigrInfoCountByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @param dto
	 * @return: Long
	 */
	Long getOdsStoDnGigrInfoCountByParm(OdsStodnGigrInfoDTO dto);

	/**
	 * @title: getListByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月15日 下午6:10:15
	 * @param dto
	 * @return: List<OdsStoGigrInfoDTO>
	 */
	List<OdsStoGigrInfoDTO> getListByParm(OdsStoGigrInfoDTO dto);

	/**
	 * @title: getListByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月15日 下午6:10:15
	 * @param dto
	 * @return: List<OdsStoGigrInfoDTO>
	 */
	List<OdsStodnGigrInfoDTO> getStoDnListByParm(OdsStodnGigrInfoDTO dto);

	/**
	 * 根据orderNo修改
	 * @param vnptNo
	 * @param orderNo
	 */
	void updateByOrderNo(String stodnNo, String materialDesp, String vnptNo);

}

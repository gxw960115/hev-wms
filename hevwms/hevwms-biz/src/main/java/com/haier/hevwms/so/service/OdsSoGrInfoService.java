package com.haier.hevwms.so.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoGrInfoService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月18日 下午7:07:50
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月18日		LJZ			v1.0.0			create
 */

public interface OdsSoGrInfoService {
	Pager<OdsSoGrInfoDTO> searchOdsSoGrInfoListByPage(Pager<OdsSoGrInfoDTO> pager,OdsSoGrInfoDTO dto);

	Long getExportAmout(OdsSoGrInfoDTO dto);

	List<OdsSoGrInfoDTO> getListByParm(OdsSoGrInfoDTO dto);
}

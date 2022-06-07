package com.haier.hevwms.scrap.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;

public interface OdsScrapScanInfoDAO extends CommonDAO<OdsScrapScanInfoDTO, Long> {

	public List<OdsScrapScanInfoDTO> searchOdsScrapScanInfoByPage(@Param("pager")Pager<OdsScrapScanInfoDTO> pager,
    		@Param("odsScrapScanInfo") OdsScrapScanInfoDTO OdsScrapScanInfoDTO);
    // 条件统计数量
    public Long searchOdsScrapScanInfoCount(@Param("odsScrapScanInfo") OdsScrapScanInfoDTO OdsScrapScanInfoDTO);

	/**
	 * @title: getListByParam
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午5:08:35 
	 * @param dto
	 * @return: List<OdsScrapScanInfoDTO>
	 */
	public List<OdsScrapScanInfoDTO> getListByParam(@Param("odsScrapScanInfo") OdsScrapScanInfoDTO dto);

}
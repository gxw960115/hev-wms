package com.haier.hevwms.so.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;

public interface OdsSoScanInfoDAO extends CommonDAO<OdsSoScanInfoDTO, Long>{

    int insertSelective(OdsSoScanInfoDTO record);

	/**
	 * @title: searchOdsSoScanInfoByPage
	 * @description: 分页查询SOScan
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月19日 下午1:25:51 
	 * @param pager
	 * @param dto
	 * @return
	 * @return: List<OdsSoScanInfoDTO>
	 */
	List<OdsSoScanInfoDTO> searchOdsSoScanInfoByPage(@Param("pager")
			Pager<OdsSoScanInfoDTO> pager, @Param("odsSoScanInfo") OdsSoScanInfoDTO odsSoScanInfo);

	/**
	 * @title: searchOdsSoScanInfoCount
	 * @description: 根据DTO进行统计行数
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月19日 下午1:25:59 
	 * @param dto
	 * @return: long
	 */
	Long searchOdsSoScanInfoCount(@Param("odsSoScanInfo") OdsSoScanInfoDTO dto);

	/**
	 * @title: getListByParam
	 * @description: 根据DTO进行条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月19日 下午1:26:04 
	 * @param dto
	 * @return: List<OdsSoScanInfoDTO>
	 */
	List<OdsSoScanInfoDTO> getListByParam(@Param("odsSoScanInfo") OdsSoScanInfoDTO dto);

	List<OdsSoScanInfoDTO> getListByBarcodes(@Param("barcodes") String barcodes);
	
	public Integer updateOldBarcode(@Param("odsSoScanInfo") OdsSoScanInfoDTO dto);

}
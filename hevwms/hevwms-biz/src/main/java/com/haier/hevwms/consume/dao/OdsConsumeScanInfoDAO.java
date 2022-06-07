package com.haier.hevwms.consume.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;

public interface OdsConsumeScanInfoDAO extends CommonDAO<OdsConsumeScanInfoDTO, Long> {

	/**
	 * @title: searchOdsConsumeScanInfoByPage
	 * @description: 分页条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月25日 下午3:42:46 
	 * @param pager
	 * @param OdsConsumeScanInfoDTO
	 * @return: List<OdsConsumeScanInfoDTO>
	 */
	public List<OdsConsumeScanInfoDTO> searchOdsConsumeScanInfoByPage(@Param("pager")Pager<OdsConsumeScanInfoDTO> pager,
    		@Param("odsConsumeScanInfo") OdsConsumeScanInfoDTO OdsConsumeScanInfoDTO);
	
    /**
     * @title: searchOdsConsumeScanInfoCount
     * @description: 条件统计数量
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月25日 下午3:43:21 
     * @param OdsConsumeScanInfoDTO
     * @return: Long
     */
    public Long searchOdsConsumeScanInfoCount(@Param("odsConsumeScanInfo") OdsConsumeScanInfoDTO OdsConsumeScanInfoDTO);

	/**
	 * @title: getListByParam
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午5:08:35 
	 * @param dto
	 * @return: List<OdsConsumeScanInfoDTO>
	 */
	public List<OdsConsumeScanInfoDTO> getListByParam(@Param("odsConsumeScanInfo") OdsConsumeScanInfoDTO dto);

}
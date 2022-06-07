package com.haier.hevwms.po.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.po.domain.OdsPoScanInfo;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;

public interface OdsPoScanInfoDAO extends CommonDAO<OdsPoScanInfo,Long> {

    public void insertSelective(OdsPoScanInfo record);

    public List<OdsPoScanInfo> selectByExample(OdsPoScanInfo odsPoScanInfo);

	/**
	 * @title: searchOdsOrderInfoDtls
	 * @description: 根据条件分页查询PO Scan Info
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:33:24 
	 * @param pager
	 * @param dto
	 * @return: List<OdsOrderInfoDtlDTO>
	 */
    public List<OdsPoScanInfoDTO> searchOdsPoScanInfoByPage(@Param("pager")Pager<OdsPoScanInfoDTO> pager,
    		@Param("odsPoScanInfoDTO") OdsPoScanInfoDTO odsPoScanInfoDTO);
    // 条件统计数量
    public Long searchOdsPoScanInfoCount(@Param("odsPoScanInfoDTO") OdsPoScanInfoDTO odsPoScanInfoDTO);

	/**
	 * @title: getListByParam
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午5:08:35 
	 * @param dto
	 * @return: List<OdsPoScanInfoDTO>
	 */
	public List<OdsPoScanInfoDTO> getListByParam(@Param("odsPoScanInfoDTO") OdsPoScanInfoDTO dto);

}
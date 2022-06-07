package com.haier.hevwms.sto.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnScanInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OdsStoScanInfoDAO extends CommonDAO<OdsStoScanInfoDTO, Long> {

	/**
	 * @title: insertSelective
	 * @description: 选择插入 
	 * @author: LJZ
	 * @date: 2018年11月14日 上午10:15:44 
	 * @param record
	 * @return: int
	 */
    public int insertSelective(OdsStoScanInfoDTO record);

    /**
     * @title: searchOdsStoScanInfoByPage
     * @description: 条件分页查询
     * @author: LJZ
     * @date: 2018年11月14日 上午10:14:54 
     * @param pager
     * @param dto
     * @return: List<OdsStoScanInfoDTO>
     */
    public List<OdsStoScanInfoDTO> searchOdsStoScanInfoByPage(@Param("pager")
		Pager<OdsStoScanInfoDTO> pager, @Param("odsStoScanInfo") OdsStoScanInfoDTO dto);
    
    /**
     * @title: searchOdsStoScanInfoCount
     * @description: 条件统计数量 
     * @author: LJZ
     * @date: 2018年11月14日 上午10:15:15 
     * @param dto
     * @return: Long
     */
    public Long searchOdsStoScanInfoCount(@Param("odsStoScanInfo") OdsStoScanInfoDTO dto);
    
    /**
     * @title: getListByParam
     * @description: 条件查询
     * @author: LJZ
     * @date: 2018年11月14日 上午10:15:30 
     * @param dto
     * @return: List<OdsStoScanInfoDTO>
     */
    public List<OdsStoScanInfoDTO> getListByParam(@Param("odsStoScanInfo") OdsStoScanInfoDTO dto);


    public List<OdsStoScanInfoDTO> getOdsStodnScanInfo(@Param("dto") OdsStoScanInfoDTO dto);

    public void updateStodnInfo(@Param("odsStoScanInfo") OdsStoScanInfoDTO dto);

	List<OdsStoScanInfoDTO> getListByBarcodes(@Param("orderNo")String orderNo, @Param("barcodes") String barcodes);

	/**
	 * <p>Title: searchOdsStoDnScanInfosCount</p>
	 * <p>Description: </p>
	 *
	 * @param odsStodnScanInfoDTO
	 * @return
	 */
	public Long searchOdsStoDnScanInfosCount(
			@Param("odsStodnScanInfoDTO") OdsStodnScanInfoDTO odsStodnScanInfoDTO);

	/**
	 * <p>Title: searchList</p>
	 * <p>Description: </p>
	 *
	 * @param odsStodnScanInfoDTO
	 * @return
	 */
	public List<OdsStodnScanInfoDTO> searchStoDnList(@Param("odsStodnScanInfoDTO") OdsStodnScanInfoDTO odsStodnScanInfoDTO);

}
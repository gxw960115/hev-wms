package com.haier.hevwms.takestock.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;

public interface OdsPdTempDAO extends CommonDAO<OdsPdTempDTO, Serializable>{

	int add(@Param("odsPdTempDTO") OdsPdTempDTO odsPdTempDTO);

	@Override
	int update(@Param("odsPdTempDTO")OdsPdTempDTO odsPdTempDTO);

	List<OdsPdTempDTO> searchOdsPdTempDTOs(@Param("odsPdTempDTO") OdsPdTempDTO odsPdTempDTO
												,@Param("firstResult")Long firstResult
														, @Param("pageSize")Long pageSize);
										
	long searchOdsPdTempDTOsCount(@Param("odsPdTempDTO") OdsPdTempDTO odsPdTempDTO);
	
	int updateStatus(@Param("odsPdTempDTO") OdsPdTempDTO odsPdTempDTO);
	
}

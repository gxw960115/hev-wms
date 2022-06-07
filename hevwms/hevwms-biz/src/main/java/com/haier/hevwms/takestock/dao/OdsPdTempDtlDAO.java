package com.haier.hevwms.takestock.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;

public interface OdsPdTempDtlDAO extends CommonDAO<OdsPdTempDtlDTO, Serializable>{

	public int add(@Param("pdTempDtl")OdsPdTempDtlDTO pdTempDtl);
	
	public int updateOrderStatus(@Param("pdTempDtl")OdsPdTempDtlDTO pdTempDtl);
	
	public List<OdsPdTempDtlDTO> searchOdsPdTempDtlDTOs(@Param("pdTempDtl")OdsPdTempDtlDTO pdTempDtl,
									@Param("firstResult")long firstResult,@Param("pageSize")long pageSize);
	
	public long searchOdsPdTempDtlDTOsCount(@Param("pdTempDtl")OdsPdTempDtlDTO pdTempDtl);
	
	public Long getScanQty(@Param("orderNo") String orderNo);
	
	public int barcodeCheck(@Param("orderNo") String orderNo,@Param("barcode") String barcode);
	
	public int materialExisted(@Param("materialNo") String materialNo);
	
	public List<OdsPdTempDtlDTO> getListByparam(@Param("pdTempDtl")OdsPdTempDtlDTO pdTempDtl);
	
	public int deleteById(@Param("rowId")Long rowId);
	
	public String cusModel(@Param("materialNo") String materialNo);
	
	public OdsPdTempDtlDTO getById(@Param("rowId")Long rowId);
	
	public int deleteByorderNo(@Param("rowId") Long rowId);
	
	public String getUnit(@Param("materialNo") String materialNo);
	
}

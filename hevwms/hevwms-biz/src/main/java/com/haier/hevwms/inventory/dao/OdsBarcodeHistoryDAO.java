package com.haier.hevwms.inventory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.inventory.domain.OdsBarcodeHistory;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;

/**
* @ClassName: OdsBarcodeHistoryDAO
* @Description: 条码历史dao层方法
*
*/
public interface OdsBarcodeHistoryDAO extends CommonDAO<OdsBarcodeHistory,Long>{
	
	public List<OdsBarcodeHistoryDTO> searchOdsBarcodeHistorys(@Param("pager") Pager<OdsBarcodeHistoryDTO> pager, @Param("odsBarcodeHistory") OdsBarcodeHistoryDTO odsBarcodeHistory);
	public Long searchOdsBarcodeHistorysCount(@Param("odsBarcodeHistory") OdsBarcodeHistoryDTO odsBarcodeHistory);
	public void deleteAll(@Param("idList")List<Long> idList);
	public List<OdsBarcodeHistoryDTO> getOdsBarcodeHistoryByParam(@Param("odsBarcodeHistory") OdsBarcodeHistoryDTO odsBarcodeHistory);
	
	public void saveBarcodeHistoryWhenPD(@Param("dtl")OdsInventoryInfoDtl dtl);
	
	public void deleteBacodeInfoBySapOrderNo(@Param("sapOrderNo") String sapOrderNo);
}
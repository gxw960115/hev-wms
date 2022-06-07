package com.haier.hevwms.inventory.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;

public interface OdsBarcodeHistoryService {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsBarcodeHistoryDTO> createOdsBarcodeHistory(OdsBarcodeHistoryDTO odsBarcodeHistory);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsBarcodeHistoryDTO> updateOdsBarcodeHistory(OdsBarcodeHistoryDTO odsBarcodeHistory);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsBarcodeHistoryDTO> deleteOdsBarcodeHistory(Long odsBarcodeHistoryId);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsBarcodeHistoryDTO> deleteOdsBarcodeHistoryAll(List<Long> idList);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public Pager<OdsBarcodeHistoryDTO> searchOdsBarcodeHistorys(Pager<OdsBarcodeHistoryDTO> pager,OdsBarcodeHistoryDTO odsBarcodeHistory);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public OdsBarcodeHistoryDTO getOdsBarcodeHistoryById(Long odsBarcodeHistoryId);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public List<OdsBarcodeHistoryDTO> getOdsBarcodeHistorys();
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public List<OdsBarcodeHistoryDTO> getOdsBarcodeHistoryByParam(OdsBarcodeHistoryDTO odsBarcodeHistory);
	public Long getExportAmount(OdsBarcodeHistoryDTO dto);
	
}

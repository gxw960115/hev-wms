package com.haier.hevwms.order.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;

/**
 * inbound detail
 * 
 * @author sunyanfei 2015-11-25
 * 
 */
public interface StgInboundDownService {
	public ExecuteResult<StgInboundDownDTO> createStgInboundDown(
			StgInboundDownDTO stgInboundDown);

	public ExecuteResult<StgInboundDownDTO> updateStgInboundDown(
			StgInboundDownDTO stgInboundDown);

	public ExecuteResult<StgInboundDownDTO> deleteStgInboundDown(
			Long stgInboundDownId);

	public ExecuteResult<StgInboundDownDTO> deleteStgInboundDownAll(
			List<Long> idList);

	public Pager<StgInboundDownDTO> searchStgInboundDowns(
			Pager<StgInboundDownDTO> pager, StgInboundDownDTO stgInboundDown);

	public StgInboundDownDTO getStgInboundDownById(Long stgInboundDownId);

	public List<StgInboundDownDTO> getStgInboundDowns();

	/**
	 * 查询inbound详情 导出
	 * 
	 * @param stgInboundDown
	 * @return
	 */
	public List<StgInboundDownDTO> getStgInboundDownByParam(
			StgInboundDownDTO stgInboundDown);

	/**
	 * @Title: removeHistory
	 * @Description:
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean removeHistory() throws Exception;

	public Long getExportAmount(StgInboundDownDTO dto);

}

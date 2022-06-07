package com.haier.openplatform.wms.order.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;

/**
 * inbound detail
 * @author sunyanfei 2015-11-25
 *
 */
public interface StgInboundDownServiceClient {
	/**
	 * 查询分页
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<StgInboundDownDTO> searchStgInboundDowns(Pager<StgInboundDownDTO> pager,
			StgInboundDownDTO dto);
	/**
	 * 导出 查询
	 * @param dto
	 * @return
	 */
	public List<StgInboundDownDTO> getStgInboundDownByParam(StgInboundDownDTO dto);
	
	public Long getExportAmount(StgInboundDownDTO dto);
}

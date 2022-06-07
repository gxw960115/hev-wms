package com.haier.hevwms.order.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;
import com.haier.hevwms.order.domain.OdsWmsOrder;

public interface OdsWmsOrderService {
	public ExecuteResult<OdsWmsOrderDTO> createOdsWmsOrder(
			OdsWmsOrderDTO odsWmsOrderDTO);

	public ExecuteResult<OdsWmsOrderDTO> updateOdsWmsOrder(
			OdsWmsOrderDTO odsWmsOrderDTO);

	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrder(Long odsWmsOrderId);

	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrderAll(List<Long> idList);

	public Pager<OdsWmsOrderDTO> searchOdsWmsOrders(
			Pager<OdsWmsOrderDTO> pager, OdsWmsOrderDTO odsWmsOrderDTO);

	public OdsWmsOrderDTO getOdsWmsOrderById(Long odsWmsOrderId);

	public List<OdsWmsOrderDTO> getOdsWmsOrders(OdsWmsOrderDTO odsWmsOrderDTO);

	public ExecuteResult<OdsWmsOrderDTO> deltGfOrder(
			OdsWmsOrderDTO odsWmsOrderDTO);

	public ExecuteResult<OdsWmsOrderDTO> saveScrapOrder(
			OdsWmsOrderDTO odsWmsOrderDTO, String ids);

	public ExecuteResult<OdsWmsOrderDTO> updateScrapOrder(
			OdsWmsOrderDTO odsWmsOrderDTO);

	public ExecuteResult<OdsWmsOrderDTO> deleteScrapOrder(
			OdsWmsOrderDTO odsWmsOrderDTO);

	/**
	 * 查询odsWmsOrder
	 * 
	 * @param odsWmsOrder
	 * @return
	 */
	public List<OdsWmsOrderDTO> getOdsWmsOrder(OdsWmsOrderDTO odsWmsOrderDTO);

	public void save(OdsWmsOrderDTO odsWmsOrderDTO);

	public void updateScrapDtl(OdsWmsOrderDTO odsWmsOrderDTO);

	public void deltByOrderNo(OdsWmsOrderDTO odsWmsOrderDTO, String docType);

	public Pager<OdsInventoryInfoDtlDTO> searchScrapBarcodeDtl(
			Pager<OdsInventoryInfoDtlDTO> pager,
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
}

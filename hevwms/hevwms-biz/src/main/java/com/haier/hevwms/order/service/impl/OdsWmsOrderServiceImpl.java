package com.haier.hevwms.order.service.impl;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.order.dao.OdsWmsOrderDAO;
import com.haier.hevwms.order.service.OdsWmsOrderService;
import com.haier.hevwms.po.dao.OdsOrderInfoDtlDAO;

public class OdsWmsOrderServiceImpl implements OdsWmsOrderService {
	private OdsWmsOrderDAO odsWmsOrderDAO;
	private OdsOrderInfoDtlDAO odsOrderInfoDtlDAO;
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
	
	@Override
	public ExecuteResult<OdsWmsOrderDTO> createOdsWmsOrder(OdsWmsOrderDTO odsWmsOrder) {
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();

		odsWmsOrderDAO.save(odsWmsOrder);
		executeResult.setResult(odsWmsOrder);
		return executeResult;
	}

	public ExecuteResult<OdsWmsOrderDTO> updateOdsWmsOrder(OdsWmsOrderDTO odsWmsOrder) {
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();

		odsWmsOrderDAO.update(odsWmsOrder);
		executeResult.setResult(odsWmsOrder);
		return executeResult;
	}

	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrder(Long odsWmsOrderId) {
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();

		odsWmsOrderDAO.delete(odsWmsOrderId);
		return executeResult;
	}

	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrderAll(List<Long> idList) {
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();

		odsWmsOrderDAO.deleteAll(idList);
		return executeResult;
	}

	public Pager<OdsWmsOrderDTO> searchOdsWmsOrders(Pager<OdsWmsOrderDTO> pager,
			OdsWmsOrderDTO odsWmsOrder) {
		List<OdsWmsOrderDTO> odsWmsOrders = odsWmsOrderDAO.searchOdsWmsOrders(
				pager, odsWmsOrder);
		long size = odsWmsOrderDAO.searchOdsWmsOrdersCount(odsWmsOrder);
		return Pager.cloneFromPager(pager, size, odsWmsOrders);
	}

//	@Override
//	public ExecuteResult<OdsWmsOrderDTO> deltGfOrder(OdsWmsOrderDTO odsWmsOrder) {
//		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();
//		OdsOrderInfoDtl odsOrderInfoDtl = new OdsOrderInfoDtl();
//		odsOrderInfoDtl.setSapOrderNo(odsWmsOrder.getWmsOrderNo());
//		List<OdsOrderInfoDtl> list = odsOrderInfoDtlDAO.getListByParam(odsOrderInfoDtl);
//		if (list.size() <= 0) {
//			odsWmsOrderDAO.deltByOrderNo(odsWmsOrder, "GIFT");
//		} else {
//			executeResult.addErrorMessage("alert.used");
//		}
//		return executeResult;
//	}

//	@Override
//	public ExecuteResult<OdsWmsOrderDTO> saveScrapOrder(OdsWmsOrderDTO odsWmsOrder,
//			String ids) {
//		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();
//		try {
//
//			String[] idArray = ids.split(",");
//			// 锁定数据
//			odsInventoryInfoDtlDAO.updateUseQty(idArray);
//			// 获取数据
//			List<OdsInventoryInfoDtl> list = odsInventoryInfoDtlDAO
//					.getListByids(idArray);
//			// 存储物料
//			Map<String, OdsWmsOrderDTO> map = new HashMap<String, OdsWmsOrderDTO>();
//			// 生成订单明细
//			for (OdsInventoryInfoDtl dtl : list) {
//				if (map.get(dtl.getMaterialNo()) == null) {
//					// 生成wms Order 详情
//					OdsWmsOrderDTO tempWms = new OdsWmsOrderDTO();
//					tempWms.setCreateBy(odsWmsOrder.getCreateBy());
//					tempWms.setCreateDate(new Date());
//					tempWms.setCustomerModel(dtl.getCustomerModel());
//					tempWms.setDocTpye("SCRAP");
//					tempWms.setLocation(dtl.getLocation());
//					tempWms.setMaterialDesp(dtl.getMaterialDesp());
//					tempWms.setMaterialNo(dtl.getMaterialNo());
//					tempWms.setOrderType("2");
//					tempWms.setPlant(dtl.getPlant());
//					tempWms.setRequireQty(dtl.getQty());
//					tempWms.setUnit(dtl.getUnit());
//					tempWms.setWmsOrderItem(String.format("%04d",
//							list.indexOf(dtl) + 1));
//					tempWms.setCheckFlag("0");
//					tempWms.setWmsOrderNo(odsWmsOrder.getWmsOrderNo());
//					map.put(dtl.getMaterialNo(), tempWms);
//				} else {
//					OdsWmsOrderDTO tempWms = map.get(dtl.getMaterialNo());
//					tempWms.setRequireQty(dtl.getQty()+tempWms.getRequireQty());
//					map.put(dtl.getMaterialNo(), tempWms);
//				}
//				// 生成 IGP/OGP 明细
//				OdsOrderInfoDtl orderDtl = new OdsOrderInfoDtl();
//				orderDtl.setBarcode(dtl.getBarcode());
//				orderDtl.setBatchNo(dtl.getBatchNo());
//				orderDtl.setCustomerModel(dtl.getCustomerModel());
//				orderDtl.setDocType("SCRAP");
//				orderDtl.setLocation(dtl.getLocation());
//				orderDtl.setMaterialDesp(dtl.getMaterialDesp());
//				orderDtl.setMaterialNo(dtl.getMaterialNo());
//				orderDtl.setPlant(dtl.getPlant());
//				orderDtl.setQty(dtl.getQty());
//				orderDtl.setOrderType("2");
//				orderDtl.setOrderItem(map.get(dtl.getMaterialNo())
//						.getWmsOrderItem());
//				orderDtl.setOrderNo(map.get(dtl.getMaterialNo())
//						.getWmsOrderNo());
//				orderDtl.setSapOrderItem(map.get(dtl.getMaterialNo())
//						.getWmsOrderItem());
//				orderDtl.setSapOrderNo(map.get(dtl.getMaterialNo())
//						.getWmsOrderNo());
//				orderDtl.setUnit(dtl.getUnit());
//				orderDtl.setFinishFlag("0");
//				orderDtl.setInOutFlag("0");
//				orderDtl.setUsedFlag("1");
//				orderDtl.setScannedBy(odsWmsOrder.getCreateBy());
//				orderDtl.setScannedDate(new Date());
//				orderDtl.setCreateBy(odsWmsOrder.getCreateBy());
//				orderDtl.setCreateDate(new Date());
//				odsOrderInfoDtlDAO.save(orderDtl);
//			}
//			// 保存单据明细
//			Set<String> keys = map.keySet();
//			for (String key : keys) {
//				odsWmsOrderDAO.save(map.get(key));
//			}
//
//		} catch (Exception e) {
//			throw new HOPException("" + OdsWmsOrderServiceImpl.class, e);
//		}
//		return executeResult;
//	}
	
//	@Override
//	public ExecuteResult<OdsWmsOrderDTO> deleteScrapOrder(OdsWmsOrderDTO odsWmsOrder) {
//		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();
//		//清除库存占用
//		odsInventoryInfoDtlDAO.updateUseQtyByOrderNo(odsWmsOrder);
//		odsWmsOrderDAO.update(odsWmsOrder);
//		odsWmsOrderDAO.updateScrapDtl(odsWmsOrder);
//		return executeResult;
//	}

	@Override
	public ExecuteResult<OdsWmsOrderDTO> updateScrapOrder(OdsWmsOrderDTO odsWmsOrder) {
		
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();
		odsWmsOrderDAO.updateScrapOrder(odsWmsOrder);
		return executeResult;
	}
	
	@Override
	public void deltByOrderNo(OdsWmsOrderDTO odsWmsOrderDTO, String docType) {
		odsWmsOrderDAO.deltByOrderNo(odsWmsOrderDTO, docType);
	}

	public List<OdsWmsOrderDTO> getOdsWmsOrder(OdsWmsOrderDTO odsWmsOrder) {
		return odsWmsOrderDAO.getOdsWmsOrder(odsWmsOrder);

	}

	public OdsWmsOrderDTO getOdsWmsOrderById(Long odsWmsOrderId) {
		return odsWmsOrderDAO.get(odsWmsOrderId);
	}

	public List<OdsWmsOrderDTO> getOdsWmsOrders() {
		return odsWmsOrderDAO.getAll();
	}
	

	@Override
	public void save(OdsWmsOrderDTO odsWmsOrderDTO) {
		odsWmsOrderDAO.save(odsWmsOrderDTO);
	}
	
	@Override
	public void updateScrapDtl(OdsWmsOrderDTO odsWmsOrderDTO) {
		
		odsWmsOrderDAO.updateScrapDtl(odsWmsOrderDTO);
	}
	
	@Override
	public List<OdsWmsOrderDTO> getOdsWmsOrders(OdsWmsOrderDTO odsWmsOrderDTO) {
		
		return odsWmsOrderDAO.getOdsWmsOrder(odsWmsOrderDTO);
	}
	
	@Override
	public ExecuteResult<OdsWmsOrderDTO> deltGfOrder(OdsWmsOrderDTO odsWmsOrderDTO) {
		//  Auto-generated method stub
		return null;
	}
	
	@Override
	public ExecuteResult<OdsWmsOrderDTO> saveScrapOrder(OdsWmsOrderDTO odsWmsOrderDTO,
			String ids) {
		//  Auto-generated method stub
		return null;
	}
	
	@Override
	public ExecuteResult<OdsWmsOrderDTO> deleteScrapOrder(OdsWmsOrderDTO odsWmsOrderDTO) {
		//  Auto-generated method stub
		return null;
	}
	

	public void setOdsWmsOrderDAO(OdsWmsOrderDAO odsWmsOrderDAO) {
		this.odsWmsOrderDAO = odsWmsOrderDAO;
	}

	public OdsWmsOrderDAO getOdsWmsOrderDAO() {
		return odsWmsOrderDAO;
	}

	public OdsOrderInfoDtlDAO getOdsOrderInfoDtlDAO() {
		return odsOrderInfoDtlDAO;
	}

	public void setOdsOrderInfoDtlDAO(OdsOrderInfoDtlDAO odsOrderInfoDtlDAO) {
		this.odsOrderInfoDtlDAO = odsOrderInfoDtlDAO;
	}

	public OdsInventoryInfoDtlDAO getOdsInventoryInfoDtlDAO() {
		return odsInventoryInfoDtlDAO;
	}

	public void setOdsInventoryInfoDtlDAO(
			OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO) {
		this.odsInventoryInfoDtlDAO = odsInventoryInfoDtlDAO;
	}

	@Override
	public Pager<OdsInventoryInfoDtlDTO> searchScrapBarcodeDtl(
			Pager<OdsInventoryInfoDtlDTO> pager,
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		List<OdsInventoryInfoDtlDTO> inventoryInfoDtl = odsInventoryInfoDtlDAO.searchScrapBarcodeDtlList(
				pager, odsInventoryInfoDtlDTO);
		long size = odsInventoryInfoDtlDAO.searchScrapBarcodeDtlCount(odsInventoryInfoDtlDTO);
		return Pager.cloneFromPager(pager, size, inventoryInfoDtl);
	}
}

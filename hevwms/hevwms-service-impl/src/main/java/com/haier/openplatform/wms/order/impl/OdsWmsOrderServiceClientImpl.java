/**
* @Company 青鸟软通
* @Title: OdsWmsOrderServiceClientImpl.java
* @Package com.haier.openplatform.wms.order.impl
* @author Administrator
* @date 2015-11-6 上午10:42:39
* @version V1.0
*/
package com.haier.openplatform.wms.order.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.OdsInventoryInfoDtlService;
import com.haier.hevwms.order.domain.OdsWmsOrder;
import com.haier.hevwms.order.service.OdsWmsOrderService;
import com.haier.hevwms.order.service.impl.OdsWmsOrderServiceImpl;
import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.HOPException;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;
import com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;

/**
 * @ClassName: OdsWmsOrderServiceClientImpl
 * @Description: 
 */
public class OdsWmsOrderServiceClientImpl implements OdsWmsOrderServiceClient{
	private Logger logger = Logger.getLogger(OdsWmsOrderServiceClientImpl.class);

    /**  
     * @Fields field:field:{}(odsWmsOrderService)  
     */  
    private OdsWmsOrderService odsWmsOrderService;
    /**  
     * @Fields field:field:{}(orderInfoDtlService)  
     */  
    private OdsOrderInfoDtlService orderInfoDtlService;
	/**  
	 * @Fields field:field:{}(odsInventoryInfoDtlService)  
	 */  
	private OdsInventoryInfoDtlService odsInventoryInfoDtlService;
    

    /**
    * <p>Title: SearchOdsWmsOrders</p>
    * <p>Description: </p>
    * @param pager
    * @param dto
    * @return
    * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#SearchOdsWmsOrders(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO)
    */
    @Override
    public Pager<OdsWmsOrderDTO> searchOdsWmsOrders(Pager<OdsWmsOrderDTO> pager, OdsWmsOrderDTO dto) {
    	logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
        return odsWmsOrderService.searchOdsWmsOrders(pager, dto);
    }

	/** (non-Javadoc)  
	 * <p>Title: createOdsWmsOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#createOdsWmsOrder(com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> createOdsWmsOrder(
			OdsWmsOrderDTO odsWmsOrderDTO) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		return odsWmsOrderService.createOdsWmsOrder(odsWmsOrderDTO);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateOdsWmsOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#updateOdsWmsOrder(com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> updateOdsWmsOrder(
			OdsWmsOrderDTO odsWmsOrderDTO) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		return null;
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteOdsWmsOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderId
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#deleteOdsWmsOrder(java.lang.Long)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrder(Long odsWmsOrderId) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		return null;
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteOdsWmsOrderAll</p>  
	 * <p>Description: </p>  
	 * @param idList
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#deleteOdsWmsOrderAll(java.util.List)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrderAll(List<Long> idList) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		
		return null;
	}

	/** (non-Javadoc)  
	 * <p>Title: getOdsWmsOrderById</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderId
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#getOdsWmsOrderById(java.lang.Long)  
	 */
	@Override
	public OdsWmsOrderDTO getOdsWmsOrderById(Long odsWmsOrderId) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		OdsWmsOrderDTO dto = odsWmsOrderService.getOdsWmsOrderById(odsWmsOrderId);
		return dto;
	}

	/** (non-Javadoc)  
	 * <p>Title: getOdsWmsOrders</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#getOdsWmsOrders()  
	 */
	@Override
	public List<OdsWmsOrderDTO> getOdsWmsOrders() {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		return null;
	}

	/** (non-Javadoc)  
	 * <p>Title: deltGfOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#deltGfOrder(com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> deltGfOrder(
			OdsWmsOrderDTO odsWmsOrderDTO) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();
		OdsOrderInfoDtlDTO odsOrderInfoDtl = new OdsOrderInfoDtlDTO();
		odsOrderInfoDtl.setPoNo(odsWmsOrderDTO.getWmsOrderNo());
		List<OdsOrderInfoDtlDTO> list = orderInfoDtlService.getOdsOrderInfoDtls(odsOrderInfoDtl);
		if (list.size() <= 0) {
			odsWmsOrderService .deltByOrderNo(odsWmsOrderDTO, "GIFT");
		} else {
			executeResult.addErrorMessage("The Order is Still Used");
		}
		return executeResult;
	}

	/** (non-Javadoc)  
	 * <p>Title: saveScrapOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderDTO
	 * @param ids
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#saveScrapOrder(com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO, java.lang.String)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> saveScrapOrder(
			OdsWmsOrderDTO odsWmsOrderDTO, String ids) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		ExecuteResult<OdsWmsOrder> executeResult = new ExecuteResult<OdsWmsOrder>();
		try {

			String[] idArray = ids.split(",");
			// 锁定数据
			odsInventoryInfoDtlService.updateUseQty(idArray);
			// 获取数据
			List<OdsInventoryInfoDtl> list = odsInventoryInfoDtlService
					.getListByids(idArray);
			// 存储物料
			Map<String, OdsWmsOrderDTO> map = new HashMap<String, OdsWmsOrderDTO>();
			// 生成订单明细
			for (OdsInventoryInfoDtl dtl : list) {
				if (map.get(dtl.getMaterialNo()) == null) {
					// 生成wms Order 详情
					OdsWmsOrderDTO tempWms = new OdsWmsOrderDTO();
					tempWms.setCreateBy(odsWmsOrderDTO.getModifyBy());
					tempWms.setCreateDate(new Date());
					tempWms.setCustomerModel(dtl.getCustomerModel());
					tempWms.setDocTpye("SCRAP");
					tempWms.setLocation(dtl.getLocation());
					tempWms.setMaterialDesp(dtl.getMaterialDesp());
					tempWms.setMaterialNo(dtl.getMaterialNo());
					tempWms.setOrderType("2");
					tempWms.setPlant(dtl.getPlant());
					tempWms.setRequireQty(dtl.getQty());
					tempWms.setUnit(dtl.getUnit());
					tempWms.setWmsOrderItem(String.format("%04d",
							list.indexOf(dtl) + 1));
					tempWms.setCheckFlag("0");
					tempWms.setWmsOrderNo(odsWmsOrderDTO.getWmsOrderNo());
					map.put(dtl.getMaterialNo(), tempWms);
				} else {
					OdsWmsOrderDTO tempWms = map.get(dtl.getMaterialNo());
					tempWms.setRequireQty(dtl.getQty()+tempWms.getRequireQty());
					map.put(dtl.getMaterialNo(), tempWms);
				}
				// 生成 IGP/OGP 明细
				OdsOrderInfoDtlDTO orderDtl = new OdsOrderInfoDtlDTO();
				orderDtl.setBarcode(dtl.getBarcode());
				orderDtl.setBatchNo(dtl.getBatchNo());
				orderDtl.setCustomerModel(dtl.getCustomerModel());
//	 测试无问题，则删掉			orderDtl.setDocType("SCRAP");
				orderDtl.setLocation(dtl.getLocation());
				orderDtl.setMaterialDesp(dtl.getMaterialDesp());
				orderDtl.setMaterialNo(dtl.getMaterialNo());
				orderDtl.setPlant(dtl.getPlant());
				orderDtl.setQty(dtl.getQty());
				orderDtl.setOrderType("2");
				orderDtl.setOrderItem(map.get(dtl.getMaterialNo())
						.getWmsOrderItem());
				orderDtl.setOrderNo(map.get(dtl.getMaterialNo())
						.getWmsOrderNo());
				orderDtl.setPoItemNo(map.get(dtl.getMaterialNo())
						.getWmsOrderItem());
				orderDtl.setPoNo(map.get(dtl.getMaterialNo())
						.getWmsOrderNo());
				orderDtl.setUnit(dtl.getUnit());
				orderDtl.setFinishFlag("0");
				orderDtl.setInOutFlag("0");
				orderDtl.setUsedFlag("0");
				orderDtl.setScannedBy(odsWmsOrderDTO.getModifyBy());
				orderDtl.setScannedDate(new Date());
				orderDtl.setCreateBy(odsWmsOrderDTO.getModifyBy());
				orderDtl.setCreateDate(new Date());
				orderInfoDtlService. save(orderDtl);
			}
			// 保存单据明细
//			Set<String> keys = map.keySet();
//			for (String key : keys) {
//				odsWmsOrderService.save(map.get(key));
//			}
			Set<Entry<String, OdsWmsOrderDTO>> entries = map.entrySet();
			if (entries != null){
				Iterator<Entry<String, OdsWmsOrderDTO>> it = entries.iterator();
				while(it.hasNext()){
	                Entry<String, OdsWmsOrderDTO> entry = it.next();
	                odsWmsOrderService.save(entry.getValue());
	            }
			}
		} catch (Exception e) {
			throw new HOPException("" + OdsWmsOrderServiceImpl.class, e);
		}
		ExecuteResult<OdsWmsOrderDTO> result=new ExecuteResult<OdsWmsOrderDTO>();
		try {
			BeanUtils.copyProperties(result, executeResult);// 把dto
																	// 照order复制一下？
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** (non-Javadoc)  
	 * <p>Title: updateScrapOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#updateScrapOrder(com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> updateScrapOrder(
			OdsWmsOrderDTO odsWmsOrderDTO) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();
		odsWmsOrderService.updateScrapOrder(odsWmsOrderDTO);
		return executeResult;
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteScrapOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#deleteScrapOrder(com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO)  
	 */
	@Override
	public ExecuteResult<OdsWmsOrderDTO> deleteScrapOrder(
			OdsWmsOrderDTO odsWmsOrderDTO) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		OdsWmsOrder odsWmsOrder=new OdsWmsOrder();
		try {
			BeanUtilEx.copyProperties(odsWmsOrder, odsWmsOrderDTO);// 把dto
																	// 照order复制一下？
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ExecuteResult<OdsWmsOrder> executeResult = new ExecuteResult<OdsWmsOrder>();
		//清除库存占用
		odsInventoryInfoDtlService.updateUseQtyByOrderNo(odsWmsOrder);
		odsWmsOrderService.updateOdsWmsOrder(odsWmsOrderDTO);
		odsWmsOrderService.updateScrapDtl(odsWmsOrderDTO);
		ExecuteResult<OdsWmsOrderDTO> result=new ExecuteResult<OdsWmsOrderDTO>();
		try {
			BeanUtilEx.copyProperties(result, executeResult);// 把dto
																	// 照order复制一下？
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** (non-Javadoc)  
	 * <p>Title: getOdsWmsOrder</p>  
	 * <p>Description: </p>  
	 * @param odsWmsOrderDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#getOdsWmsOrder(com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO)  
	 */
	@Override
	public List<OdsWmsOrderDTO> getOdsWmsOrder(OdsWmsOrderDTO odsWmsOrderDTO) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		return odsWmsOrderService.getOdsWmsOrders(odsWmsOrderDTO);
	}

	/** (non-Javadoc)  
	 * <p>Title: searchScrapBarcodeDtl</p>  
	 * <p>Description: </p>  
	 * @param pager
	 * @param odsInventoryInfoDtlDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient#searchScrapBarcodeDtl(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO)  
	 */
	@Override
	public Pager<OdsInventoryInfoDtlDTO> searchScrapBarcodeDtl(
			Pager<OdsInventoryInfoDtlDTO> pager,
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		logger.info("===================================");
		return odsWmsOrderService.searchScrapBarcodeDtl(pager, odsInventoryInfoDtlDTO);
	}
	
	/**  
	 * @Title: getOrderInfoDtlService  
	 * @Description: (get)  
	 * @return
	 * @return OdsOrderInfoDtlService 
	 * @throws  
	 */  
	public OdsOrderInfoDtlService getOrderInfoDtlService() {
		return orderInfoDtlService;
	}

	/**  
	 * @Title: setOrderInfoDtlService  
	 * @Description: (set)  
	 * @param orderInfoDtlService
	 * @return void 
	 * @throws  
	 */  
	public void setOrderInfoDtlService(OdsOrderInfoDtlService orderInfoDtlService) {
		this.orderInfoDtlService = orderInfoDtlService;
	}

	/**  
	 * @Title: getOdsInventoryInfoDtlService  
	 * @Description: (get)  
	 * @return
	 * @return OdsInventoryInfoDtlService 
	 * @throws  
	 */  
	public OdsInventoryInfoDtlService getOdsInventoryInfoDtlService() {
		return odsInventoryInfoDtlService;
	}

	/**  
	 * @Title: setOdsInventoryInfoDtlService  
	 * @Description: (set)  
	 * @param odsInventoryInfoDtlService
	 * @return void 
	 * @throws  
	 */  
	public void setOdsInventoryInfoDtlService(
			OdsInventoryInfoDtlService odsInventoryInfoDtlService) {
		this.odsInventoryInfoDtlService = odsInventoryInfoDtlService;
	}
	
	/**  
	 * @Title: getOdsWmsOrderService  
	 * @Description: (get)  
	 * @return
	 * @return OdsWmsOrderService 
	 * @throws  
	 */  
	public OdsWmsOrderService getOdsWmsOrderService() {
        return odsWmsOrderService;
    }

    /**  
     * @Title: setOdsWmsOrderService  
     * @Description: (set)  
     * @param odsWmsOrderService
     * @return void 
     * @throws  
     */  
    public void setOdsWmsOrderService(OdsWmsOrderService odsWmsOrderService) {
        this.odsWmsOrderService = odsWmsOrderService;
    }

}

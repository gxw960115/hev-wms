package com.haier.openplatform.wms.po.impl;

import com.haier.hevwms.po.service.StgPoDownService;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.po.service.StgPoDownServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

/**
* @ClassName: StgPoDownServiceClientImpl
* @Description:PO订单的相关方法
*
*/
public class StgPoDownServiceClientImpl implements StgPoDownServiceClient{
	
	Logger logger = Logger.getLogger(StgPoDownServiceClientImpl.class);
	/**  
	 * @Fields field:field:{}(stgPoDownService)  
	 */  
	private StgPoDownService stgPoDownService;
	
	/**  
	 * @Title: getStgPoDownService  
	 * @Description: (get)  
	 * @return
	 * @return StgPoDownService 
	 * @throws  
	 */  
	public StgPoDownService getStgPoDownService() {
		return stgPoDownService;
	}

	/**  
	 * @Title: setStgPoDownService  
	 * @Description: (set)  
	 * @param stgPoDownService
	 * @return void 
	 * @throws  
	 */  
	public void setStgPoDownService(StgPoDownService stgPoDownService) {
		this.stgPoDownService = stgPoDownService;
	}


	/** (non-Javadoc)
	 * <p>Title: searchStgPoDown</p>  
	 * <p>Description: </p>  
	 * @param pager
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.po.service.StgPoDownServiceClient#searchStgPoDown(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.po.dto.StgPoDownDTO)  
	 */
	@Override
	public Pager<StgPoDownDTO> searchStgPoDown(Pager<StgPoDownDTO> pager,
			StgPoDownDTO dto) {
	    Pager<StgPoDownDTO>  page=stgPoDownService.searchStgPoDowns(pager, dto);
	    return page;
	}

	/** (non-Javadoc)  
	 * <p>Title: createStgPoDown</p>  
	 * <p>Description:创建 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#createStgPoDown(com.haier.openplatform.wms.order.dto.StgPoDownDTO)  
	 */
	@Override
	public String createStgPoDown(StgPoDownDTO dto) {
		return stgPoDownService.createStgPoDown(dto);
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteStgPoDown</p>  
	 * <p>Description:删除 </p>  
	 * @param idList
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#deleteStgPoDown(java.util.List)  
	 */
	@Override
	public String deleteStgPoDown(List<Long> idList) {
		return stgPoDownService.deleteStgPoDownAll(idList);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateStgPoDown</p>  
	 * <p>Description:更新 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#updateStgPoDown(com.haier.openplatform.wms.order.dto.StgPoDownDTO)  
	 */
	@Override
	public String updateStgPoDown(StgPoDownDTO dto) {
		return stgPoDownService.updateStgPoDown(dto);
	}

	/** (non-Javadoc)  
	 * <p>Title: getStgPoDownByParam</p>  
	 * <p>Description:按条件查询 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#getStgPoDownByParam(com.haier.openplatform.wms.order.dto.StgPoDownDTO)  
	 */
	@Override
	public List<StgPoDownDTO> getStgPoDownByParam(StgPoDownDTO dto) {
		return stgPoDownService.getStgPoDownByParam(dto);
	}

	/** (non-Javadoc)  
	 * <p>Title: getExportAmount</p>  
	 * <p>Description:查询数量 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#getExportAmount(com.haier.openplatform.wms.order.dto.StgPoDownDTO)  
	 */
	@Override
	public Long getExportAmount(StgPoDownDTO dto) {
		return stgPoDownService.getExportAmount(dto);
	}
	
	/** (non-Javadoc)
	 * <p>Title: downloadPo</p>  
	 * <p>Description: </p>  
	 * @param poNo
	 * @param beginTime
	 * @param endTime
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#downloadPo(java.lang.String, java.lang.String, java.lang.String)  
	 */
	@Override
	public String downloadPo(String poNo, String beginTime, String endTime, String userName) {
		logger.info("Download PO start with orderNo: " + poNo + ", begin: " + beginTime + ", end: " + endTime);
		
		try {
			// 日期处理
			if (beginTime != null && !"".equals(beginTime)) {
				beginTime = DataFormat.formatDate(DataFormat.parseDate(beginTime, "yyyy-MM-dd"), "yyyyMMdd");
			} else {
				beginTime = DataFormat.formatDate(new Date());
			}
			if (endTime != null && !"".equals(endTime)) {
				endTime = DataFormat.formatDate(DataFormat.parseDate(endTime, "yyyy-MM-dd"), "yyyyMMdd");
			} else {
				endTime = DataFormat.formatDate(new Date());
			}
		} catch (Exception e) {
			logger.info("Date parsing exception......");
		}
		return stgPoDownService.downloadPo(poNo, beginTime, endTime, userName);
	}


	/** (non-Javadoc)
	 * <p>Title: postPo</p>  
	 * <p>Description: </p>  
	 * @param userName
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#postPo(java.lang.String, java.lang.String)  
	 */
	@Override
	public String postPo(String orderNo, String orderType,String returnType, String sapFlag, String userName) {
		logger.info("Post PO start with orderNo: " + orderNo);
		OrderIgpInDTO inpara = new OrderIgpInDTO();
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(userName);
		inpara.setDocType("PO");
		inpara.setOrderType(orderType);
		inpara.setVersion("HEV");
		String result = stgPoDownService.postPo(orderNo, orderType, returnType, sapFlag, userName);
		if ("1".equals(orderType)){
//			String result = new PostPoToSap(orderNo, sapFlag, userName).exchangeWithSap();
			if("S".equalsIgnoreCase(result)){
				outResult.setMsg("S");
				OrderGoodsTransOutDTO ret = stgPoDownService.poGoodsReceive(inpara);
				if ("0".equals(ret.getStatus())){
					outResult.setStatus("S");
					outResult.setMsg(ret.getMsg());
				} else {
					outResult.setStatus("F");
					outResult.setMsg(ret.getMsg());
				}
				
			}else {
				outResult.setStatus("F");
				outResult.setMsg("PO Posting error!");
			}
		} else {
//			String result =  new ReversePoToSap(orderNo, sapFlag , userName, returnType).exchangeWithSap();
			if("S".equalsIgnoreCase(result)){
				outResult.setMsg("S");
				OrderGoodsTransOutDTO ret = stgPoDownService.poGoodsDelivery(inpara);
				if ("0".equals(ret.getStatus())) {
					outResult.setStatus("S");
					outResult.setMsg(ret.getMsg());
				} else {
					outResult.setStatus("F");
					outResult.setMsg(ret.getMsg());
				}
			}else {
				outResult.setStatus("F");
				outResult.setMsg("PO Posting error!");
			}
		}
		
		return outResult.getStatus();
	}

	/** (non-Javadoc)
	 * <p>Title: postPo</p>  
	 * <p>Description: </p>  
	 * @param userName
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgPoDownServiceClient#postPo(java.lang.String, java.lang.String)  
	 */
	@Override
	public String postGiftPo(String orderNo, String orderType, String sapFlag, String userName) {
		logger.info("Post PO start with orderNo: " + orderNo);
		OrderIgpInDTO inpara = new OrderIgpInDTO();
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(userName);
		inpara.setDocType("PO");
		inpara.setOrderType(orderType);
		inpara.setVersion("HEV");
		String result = stgPoDownService.postPo(orderNo, orderType, "", sapFlag, userName);
		if("S".equalsIgnoreCase(result)){
			outResult.setMsg("S");
			OrderGoodsTransOutDTO ret = stgPoDownService.giftPoGoodsReceive(inpara);
			if ("0".equals(ret.getStatus())){
				outResult.setStatus("S");
				outResult.setMsg(ret.getMsg());
			} else {
				outResult.setStatus("F");
				outResult.setMsg(ret.getMsg());
			}
			
		}else {
			outResult.setStatus("F");
			outResult.setMsg("PO Posting error!");
		}
		
		return outResult.getStatus();
	}
	
	@Override
	public String inoutWarehousePo(String orderNo, String orderType,String userName) {
		OrderGoodsTransOutDTO ret;
		OrderIgpInDTO inpara = new OrderIgpInDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(userName);
		inpara.setDocType("PO");
		inpara.setOrderType(orderType);
		inpara.setVersion("HEV");
		if ("1".equals(orderType)){
			ret = stgPoDownService.poGoodsReceive(inpara);
		} else {
			ret = stgPoDownService.poGoodsDelivery(inpara);
		}
		if ("0".equals(ret.getStatus())){
			return "S";
		} else {
			return "F" + ret.getMsg();
		}
	}
	
	@Override
	public String giftInoutWarehousePo(String orderNo, String orderType,String userName) {
		OrderGoodsTransOutDTO ret;
		OrderIgpInDTO inpara = new OrderIgpInDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(userName);
		inpara.setDocType("PO");
		inpara.setOrderType(orderType);
		inpara.setVersion("HEV");
		ret = stgPoDownService.giftPoGoodsReceive(inpara);

		if ("0".equals(ret.getStatus())){
			return "S";
		} else {
			return "F" + ret.getMsg();
		}
	}
	
}

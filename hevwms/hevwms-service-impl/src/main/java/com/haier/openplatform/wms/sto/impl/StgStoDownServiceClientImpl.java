package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.haier.openplatform.wms.sto.service.StgStoDownServiceClient;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @ClassName: StgStoDownServiceClientImpl
* @Description:Sto订单的相关方法
*
*/
public class StgStoDownServiceClientImpl implements StgStoDownServiceClient{
	Logger logger = Logger.getLogger(StgStoDownServiceClientImpl.class);
    /**  
     * @Fields field:field:{todo}(stgStoDownService)  
     */  
    private StgStoDownService stgStoDownService;
    	
	/**  
	 * @Title: getStgStoDownService  
	 * @Description: (get)  
	 * @return
	 * @return StgStoDownService 
	 * @throws  
	 */  
	public StgStoDownService getStgStoDownService() {
        return stgStoDownService;
    }

	/**  
	 * @Title: setStgStoDownService  
	 * @Description: (set)  
	 * @param stgStoDownService
	 * @return void 
	 * @throws  
	 */  
	public void setStgStoDownService(StgStoDownService stgStoDownService) {
		this.stgStoDownService = stgStoDownService;
	}

	/** (non-Javadoc)  
	 * <p>Title: SearchStgStoDown</p>  
	 * <p>Description:查询 </p>  
	 * @param pager
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgStoDownServiceClient#SearchStgStoDown(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.StgStoDownDTO)  
	 */
	@Override
	public Pager<StgStoDownDTO> searchStgStoDown(Pager<StgStoDownDTO> pager,
			StgStoDownDTO dto) {
        return stgStoDownService.searchStgStoDowns(pager, dto);
	}


	/** (non-Javadoc)
     * <p>Title: createStgStoDown</p>  
     * <p>Description:创建 </p>  
     * @param dto
     * @return  
     * @see com.haier.openplatform.wms.order.service.StgStoDownServiceClient#createStgStoDown(com.haier.openplatform.wms.order.dto.StgStoDownDTO)  
     */
    @Override
    public String createStgStoDown(StgStoDownDTO dto) {
        return null;
    }

	/** (non-Javadoc)  
	 * <p>Title: getStgStoDowns</p>  
	 * <p>Description:查询 </p>  
	 * @param stgStoDown
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgStoDownServiceClient#getStgStoDowns(com.haier.openplatform.wms.order.dto.StgStoDownDTO)  
	 */
	@Override
	public List<StgStoDownDTO> getStgStoDowns(StgStoDownDTO stgStoDown) {
		return stgStoDownService.getStgStoDowns(stgStoDown);
	}

	/** (non-Javadoc)  
	 * <p>Title: closeStgStoDown</p>  
	 * <p>Description:关闭 </p>  
	 * @param userName
	 * @param ids
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgStoDownServiceClient#closeStgStoDown(java.lang.String, java.lang.String)  
	 */
	@Override
	public String closeStgStoDown(String userName, String ids) {
		return stgStoDownService.closeStgStoDown(userName, ids);
	}

	/** (non-Javadoc)  
	 * <p>Title: openStgStoDown</p>  
	 * <p>Description:打开 </p>  
	 * @param userName
	 * @param ids
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgStoDownServiceClient#openStgStoDown(java.lang.String, java.lang.String)  
	 */
	@Override
	public String openStgStoDown(String userName, String ids) {
		return stgStoDownService.openStgStoDown(userName, ids);
	}

	/**
	* @Title: confirmSto
	* @Description: 同一个工厂的sto调拨需要审批
	* @param @param ids
	* @param @return
	* @return String
	* @throws
	 */
	@Override
	public String confirmSto(String stoNos) {
		int succNum=0;
		int failNum=0;
		String[] stos =stoNos.split(",");
		if (stos == null || stos.length==0) {
			return "Please select at least one data";
		}else{
			Set<String> orderNos=new HashSet<String>();
			//去重
			for (String stoNo : stos) {
				orderNos.add(stoNo);
			}
			for (String stoNo : orderNos) {
				int num=stgStoDownService.updateStoConfirm(stoNo);
				if (num ==0){
					failNum++;
				}else{
					succNum++;
				}
			}
		}
		if (failNum >0 ) {
			return "Success:"+succNum+",Failed:"+failNum;
		}else {
			return "success";
		}
	}
	
	/** (non-Javadoc)  
	 * <p>Title: getExportAmount</p>  
	 * <p>Description:获取导出数量 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgStoDownServiceClient#getExportAmount(com.haier.openplatform.wms.order.dto.StgStoDownDTO)
	 */
	@Override
	public Long getExportAmount(StgStoDownDTO dto) {
		return stgStoDownService.getExportAmount(dto);
	}
	
	/* (非 Javadoc) 
	* <p>Title: downloadSto</p> 
	* <p>Description: </p> 
	* @param stoNo
	* @param beginTime
	* @param endTime
	* @param userName
	* @return 
	* @see com.haier.openplatform.wms.sto.service.StgStoDownServiceClient#downloadSto(java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
	*/
	@Override
	public InterfaceOutDTO downloadSto(String stoNo, String beginTime, String endTime, String userName) {
		logger.info("Download PO start with orderNo: " + stoNo + ", begin: " + beginTime + ", end: " + endTime);
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
		
		return stgStoDownService.downloadSto(stoNo, beginTime, endTime, userName);
	}

	/* (非 Javadoc) 
	* <p>Title: postSto</p> 
	* <p>Description: </p> 
	* @param orderNo
	* @param stodnNo
	* @param orderType
	* @param sapFlag
	* @param userName
	* @return 
	* @see com.haier.openplatform.wms.sto.service.StgStoDownServiceClient#postSto(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
	*/
	@Override
	public OrderIgpOutDTO postSto(String orderNo, String stodnNo, String orderType, String sapFlag, String userName) {
		logger.info("Post Sto start with orderNo: " + orderNo);
		OrderIgpInDTO inpara = new OrderIgpInDTO();
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setUser(userName);
		inpara.setOrderType(orderType);
		inpara.setVersion("HEV");
		if ("1".equals(orderType)) {
			inpara.setOrno(stodnNo);
			inpara.setDocType("STODN");
			InterfaceOutDTO result = stgStoDownService.postStodn(orderNo, sapFlag, userName);
			if("S".equals(result.getStatus())){
				OrderGoodsTransOutDTO ret = stgStoDownService.stoGoodsReceive(inpara);
				if ("0".equals(ret.getStatus())){
					outResult.setStatus("S");
					outResult.setMsg(ret.getMsg());
				} else {
					outResult.setStatus("F");
					outResult.setMsg(ret.getMsg());
				}
			} else {
				outResult.setStatus("F");
				outResult.setMsg(result.getMsg());
			}
		} else {
			inpara.setOrno(orderNo);
			inpara.setDocType("STO");
			InterfaceOutDTO result = stgStoDownService.postSto(orderNo, stodnNo, orderType, sapFlag, userName);
			if("S".equals(result.getStatus()) || "1".equals(result.getStatus())){
				OrderGoodsTransOutDTO ret = stgStoDownService.stoGoodsDelivery(inpara);
				if ("0".equals(ret.getStatus())){
					outResult.setStatus("S");
					outResult.setMsg(ret.getMsg());
				} else {
					outResult.setStatus("F");
					outResult.setMsg(ret.getMsg());
				}
			} else {
				outResult.setStatus("F");
				outResult.setMsg(result.getMsg());
			}
		}
		
		return outResult;
	}
	
	@Override
	public List<String> getGiLocationNameListBySTONO(String stoNo) {
		return stgStoDownService.getGiLocationNameListBySTONO(stoNo);
	}

	@Override
	public List<String> getGrLocationNameListBySTONO(String stoNo) {
		return stgStoDownService.getGrLocationNameListBySTONO(stoNo);
	}
}

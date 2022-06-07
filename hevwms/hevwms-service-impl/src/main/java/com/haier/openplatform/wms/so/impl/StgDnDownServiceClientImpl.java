package com.haier.openplatform.wms.so.impl;

import com.haier.hevwms.interfacePc.webinterface.PostDNFromIndiaWMSToGVSRF;
import com.haier.hevwms.interfacePc.webinterface.PostSTODNReceiveToGVSRF;
import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.service.StgDnDownServiceClient;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

public class StgDnDownServiceClientImpl implements StgDnDownServiceClient{
	
    /**
     * Logger
     */
    Logger logger = Logger.getLogger(StgDnDownServiceClientImpl.class);
    
    private StgDnDownService stgDnDownService;

	private OdsOrderInfoDtlService odsOrderInfoDtlService;

    public StgDnDownService getStgDnDownService() {
        return stgDnDownService;
    }

    public void setStgDnDownService(StgDnDownService stgDnDownService) {
        this.stgDnDownService = stgDnDownService;
    }
    
    /* (非 Javadoc) 
    * <p>Title: searchStgDnDown</p> 
    * <p>Description: </p> 
    * @param pager
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#searchStgDnDown(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
    */
    @Override
    public Pager<StgDnDownDTO> searchStgDnDown(Pager<StgDnDownDTO> pager,
            StgDnDownDTO dto) {
        return stgDnDownService.searchStgDnDowns(pager, dto);
    }
    
    /* (非 Javadoc) 
    * <p>Title: searchStgDnReverse</p> 
    * <p>Description: </p> 
    * @param pager
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#searchStgDnReverse(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
    */
    @Override
    public Pager<StgDnDownDTO> searchStgDnReverse(Pager<StgDnDownDTO> pager,
            StgDnDownDTO dto) {
        return stgDnDownService.searchStgDnReverse(pager, dto);
    }

    /* (非 Javadoc) 
    * <p>Title: downStgDnDown</p> 
    * <p>Description: </p> 
    * @param dnNo
    * @param begin
    * @param end
    * @param userName
    * @return
    * @throws Exception 
    * @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#downStgDnDown(java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
    */
    @Override
    public InterfaceOutDTO downStgDnDown(String dnNo, String begin, String end, String userName) throws Exception {
        logger.debug("Entering downStgDnDown with orderNo: " + dnNo + ", begin: " + begin + ", end: " + end);
		String msg = "";
		// 日期处理
        InterfaceOutDTO outDTO;
		if (begin != null && !"".equals(begin)) {
			begin = DataFormat.formatDate(DataFormat.parseDate(begin, "yyyy-MM-dd"), "yyyyMMdd");
		} else {
			begin = DataFormat.formatDate(new Date());
		}
		if (end != null && !"".equals(end)) {
			end = DataFormat.formatDate(DataFormat.parseDate(end, "yyyy-MM-dd"), "yyyyMMdd");
		} else {
			end = DataFormat.formatDate(new Date());
		}

		if (dnNo != null && !"".equals(dnNo.trim())) {
            // 有单号
		    outDTO = stgDnDownService.downloadDnFromSAP(dnNo,begin,end,userName);
		} else {
		    // 无单号
            outDTO = stgDnDownService.downloadDnFromSAP(null,begin,end,userName);
		}
        return outDTO;
    }

	/* (非 Javadoc) 
	* <p>Title: getStgDnDownsByParam</p> 
	* <p>Description: </p> 
	* @param stgDnDown
	* @return 
	* @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#getStgDnDownsByParam(com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
	*/
	@Override
	public List<StgDnDownDTO> getStgDnDownsByParam(StgDnDownDTO stgDnDown) {
		return stgDnDownService.getStgDnDownsByParam(stgDnDown);
	}

	/* (非 Javadoc) 
	* <p>Title: postDn</p> 
	* <p>Description: </p> 
	* @param orderNo
	* @param orderType
	* @param sapFlag
	* @param userName
	* @return 
	* @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#postDn(java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
	*/
	@Override
	public InterfaceOutDTO postDn(String orderNo, String orderType, String sapFlag, String userName) {
		logger.info("Post DN start with orderNo: " + orderNo);
		OrderIgpInDTO inParam = new OrderIgpInDTO();
		inParam.setOrno(orderNo);
		inParam.setUser(userName);
		inParam.setDocType("SO");
		inParam.setOrderType(orderType);
		inParam.setVersion("HEV");
		// 过账
        InterfaceOutDTO result = stgDnDownService.postDn(orderNo, orderType, sapFlag, userName);
		if(result == null) {
			return result;
		}else if("TMS".equalsIgnoreCase(result.getIsCome())){
			if(!"1".equalsIgnoreCase(result.getStatus())) {
				return result;
			}
		}else if("SAP".equalsIgnoreCase(result.getIsCome())) {
			if(!"S".equalsIgnoreCase(result.getStatus())) {
				return result;
			}
		}
        // 出入库
        OrderGoodsTransOutDTO ret;
		if ("1".equals(orderType)) {
            ret = stgDnDownService.soGoodsReceive(inParam);
        } else {
            ret = stgDnDownService.soGoodsDelivery(inParam);
        }

        if ("0".equals(ret.getStatus())) {
            result.setMsg(ret.getMsg());
        } else {
            result.setStatus("F");
            result.setMsg(ret.getMsg());
        }

		return result;
	}
	
	/* (非 Javadoc) 
	* <p>Title: postGiftDn</p> 
	* <p>Description: </p> 
	* @param orderNo
	* @param orderType
	* @param sapFlag
	* @param userName
	* @return 
	* @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#postGiftDn(java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
	*/
	@Override
	public InterfaceOutDTO postGiftDn(String orderNo, String orderType, String sapFlag, String userName) {
		logger.info("Post Gift DN start with orderNo: " + orderNo);
		OrderIgpInDTO inParam = new OrderIgpInDTO();
		inParam.setOrno(orderNo);
		inParam.setUser(userName);
		inParam.setDocType("SO");
		inParam.setOrderType(orderType);
		inParam.setVersion("HEV");
		// 过账
        InterfaceOutDTO result = stgDnDownService.postDn(orderNo, orderType, sapFlag, userName);
		if(result == null) {
			return result;
		}else if("TMS".equalsIgnoreCase(result.getIsCome())){
			if(!"1".equalsIgnoreCase(result.getStatus())) {
				return result;
			}
		}else if("SAP".equalsIgnoreCase(result.getIsCome())) {
			if(!"S".equalsIgnoreCase(result.getStatus())) {
				return result;
			}
		}
        // 出入库
        OrderGoodsTransOutDTO ret = stgDnDownService.giftSoGoodsDelivery(inParam);

        if ("0".equals(ret.getStatus())) {
            result.setMsg(ret.getMsg());
        } else {
            result.setStatus("F");
            result.setMsg(ret.getMsg());
        }

		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: inoutWarehousePo</p> 
	* <p>Description: </p> 
	* @param orderNo
	* @param orderType
	* @param userName
	* @return 
	* @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#inoutWarehousePo(java.lang.String, java.lang.String, java.lang.String) 
	*/
	@Override
	public String inoutWarehousePo(String orderNo, String orderType, String userName) {
		OrderGoodsTransOutDTO ret;
		OrderIgpInDTO inpara = new OrderIgpInDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(userName);
		inpara.setDocType("PO");
		inpara.setOrderType(orderType);
		inpara.setVersion("HEV");
		if ("1".equals(orderType)){
			ret = stgDnDownService.soGoodsReceive(inpara);
		} else {
			ret = stgDnDownService.soGoodsDelivery(inpara);
		}
		if ("0".equals(ret.getStatus())){
			return "S";
		} else {
			return "F" + ret.getMsg();
		}

	}
	
	/* (非 Javadoc) 
	* <p>Title: giftInoutWarehousePo</p> 
	* <p>Description: </p> 
	* @param orderNo
	* @param orderType
	* @param userName
	* @return 
	* @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#giftInoutWarehousePo(java.lang.String, java.lang.String, java.lang.String) 
	*/
	@Override
	public String giftInoutWarehousePo(String orderNo, String orderType, String userName) {
		OrderGoodsTransOutDTO ret;
		OrderIgpInDTO inpara = new OrderIgpInDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(userName);
		inpara.setDocType("PO");
		inpara.setOrderType(orderType);
		inpara.setVersion("HEV");

		ret = stgDnDownService.giftSoGoodsDelivery(inpara);
		if ("0".equals(ret.getStatus())){
			return "S";
		} else {
			return "F" + ret.getMsg();
		}

	}

	/* (非 Javadoc) 
	* <p>Title: getExportAmount</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#getExportAmount(com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
	*/
	@Override
	public Long getExportAmount(StgDnDownDTO dto) {
		return stgDnDownService.getExportAmount(dto);
	}

    /* (非 Javadoc) 
    * <p>Title: dnReverse</p> 
    * <p>Description: </p> 
    * @param inpara
    * @return 
    * @see com.haier.openplatform.wms.so.service.StgDnDownServiceClient#dnReverse(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO) 
    */
    @Override
    public OrderIgpOutDTO dnReverse(OrderIgpInDTO inpara) {
        return stgDnDownService.dnReverse(inpara);
    }


	/* (非 Javadoc)
	 * <p>Title: searchDirectDispatchDn</p>
	 * <p>Description: </p>
	 * @param pager
	 * @param dto
	 * @return
	 * @see com.haier.openplatform.wms.order.service.StgDnDownServiceClient#searchDirectDispatchDn(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.StgDnDownDTO)
	 */
	@Override
	public Pager<StgDnDownDTO> searchDirectDispatchDn(Pager<StgDnDownDTO> pager,
													  StgDnDownDTO dto) {
		long a = System.currentTimeMillis();
		Pager<StgDnDownDTO> page = stgDnDownService.searchDirectDispatchDn(pager, dto);
		long b = System.currentTimeMillis();
		logger.info("Dn Query===>Client===>data size:"+pager.getPageSize()+", take time:"+(b-a)+"ms");
		return page;
	}



	/* (非 Javadoc)
	 * <p>Title: directDispatch</p>
	 * <p>Description: </p>
	 * @param stodnNo
	 * @param dnNo
	 * @param userName
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoDtlServiceClient#directDispatch(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public OrderDirectDispatchOutDTO directDispatch(String stodnNo, String dnNo, String userName)
			throws IllegalAccessException, InvocationTargetException {

		String stoPostStatus = "";
		String dnPostStatus = "";
		//汇总
		OrderDirectDispatchOutDTO out = new OrderDirectDispatchOutDTO();
		out = odsOrderInfoDtlService.directDispatchCollect(stodnNo, dnNo, userName);

		if ("0".equals(out.getStatus())) {
			//过账
			try {
				PostSTODNReceiveToGVSRF stoDn = new PostSTODNReceiveToGVSRF(out.getIgpOrderNo(), userName);
				stoPostStatus = stoDn.exchangeWithSap();
			}catch (Exception e) {
				e.printStackTrace();
				out.setStatus("F");
				out.setMsg("stodn posting error, please contact with administrator.");
			}

			if ("S".equals(stoPostStatus)) {
				try {
					PostDNFromIndiaWMSToGVSRF dn = new PostDNFromIndiaWMSToGVSRF(out.getOgpOrderNo(), userName);
					dnPostStatus = dn.exchangeWithSap();
				} catch(Exception e){
					e.printStackTrace();
					out.setStatus("F");
					out.setMsg("dn posting error, please contact with administrator.");
				}
				if ("S".equals(dnPostStatus)) {
					out.setStatus("S");
					out.setMsg("SUCCESS");
				} else {
					out.setStatus("F");
					out.setMsg(dnPostStatus);
				}
			} else {
				out.setStatus("F");
				out.setMsg(stoPostStatus);
			}
		}
		return out;
	}
}

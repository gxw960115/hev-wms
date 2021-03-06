package com.haier.openplatform.wms.remoting.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.login.LoginPara;
import com.haier.hevwms.remoting.rf.domain.login.LoginResult;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutPara;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadIn;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;
import com.haier.hevwms.takestock.service.OdsPdInfoDtlService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.remoting.dto.LoginParaDTO;
import com.haier.openplatform.wms.remoting.dto.LoginResultDTO;
import com.haier.openplatform.wms.remoting.dto.LogoutParaDTO;
import com.haier.openplatform.wms.remoting.dto.LogoutResultDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDelDetialDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.service.RfWsClient;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient;

@Path("/remoting")
@Consumes({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class RfWsImpl extends RfWsBase implements RfWsClient {
    Logger logger = Logger.getLogger(RfWsImpl.class);

    /**
     * @Title: test
     * @Description: (?????????????????????????????????????????????)
     * @param @return ????????????
     * @return String ????????????
     * @throws
     */
    @Override
    public String test(@PathParam("id") String id) {
		Date date = new Date();
		String ss = "";
		ss = id + date;
		return ss;
    }

    /**
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: otcwmsLogin
     * @Description: (??????????????????)
     * @param @param loginPara
     * @param @return ????????????
     * @return LoginResult ????????????
     * @throws
     */

    @Override
    public LoginResultDTO otcwmsLogin(LoginParaDTO loginParaDTO,String version)
    		throws IllegalAccessException, InvocationTargetException {
		LoginPara loginPara = new LoginPara();
		BeanUtils.copyProperties(loginPara, loginParaDTO);
		LoginResultDTO loginResult = new LoginResultDTO();
		// ?????????????????????
		Date startDate = new Date();
		// ??????IP??????
		// ??????service
		LoginResult result = otcwmsLoginService.userLogin(loginPara,version);
		// ????????????
		Date endDate = new Date();
		BeanUtils.copyProperties(loginResult, result);
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(CommonTool.isNull(loginPara.getUser()) ? ""
			: loginPara.getUser(), "Otcwms_Login", CommonTool.isNull(result
			.getSign()) ? "" : result.getSign(), context, result
			.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), loginPara, result);
		return loginResult;
    }

    /**
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: otcwmsLogout
     * @Description: (?????????????????????????????????????????????)
     * @param @param logoutPara
     * @param @return ????????????
     * @return LogoutResult ????????????
     * @throws
     */
    @Override
    public LogoutResultDTO otcwmsLogout(LogoutParaDTO logoutParaDTO)
    		throws IllegalAccessException, InvocationTargetException {
//		LogoutResult result = new LogoutResult();
		LogoutPara logoutPara = new LogoutPara();
		BeanUtils.copyProperties(logoutPara, logoutParaDTO);
		LogoutResultDTO logoutResult = new LogoutResultDTO();
		// ????????????
		Date startDate = new Date();
		LogoutResult result = otcwmsLogoutService.userLogout(logoutPara);
		// ????????????
		/*
		 * RfLogResult rfLogResult = rfWsService.checkSign(logoutPara.getUser(),
		 * logoutPara.getSign()); if ("S".equals(rfLogResult.getStatus())) {
		 * //??????service result = otcwmsLogoutService.userLogout(logoutPara); }
		 * else { result.setStatus(rfLogResult.getStatus());
		 * result.setMsg(rfLogResult.getMsg()); }
		 */
		// ????????????
		Date endDate = new Date();
		BeanUtils.copyProperties(logoutResult, result);
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(logoutPara.getUser(), "Otcwms_Logout",
			logoutPara.getSign(), context, result.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), logoutPara, result);
	
		return logoutResult;
    }

    /**
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: otcwmsOrderCheck
     * @Description: (??????????????????????????????????????????????????????????????????????????????????????????????????????????????????)
     * @param @param in
     * @param @return ????????????
     * @return OtcwmsOrderCheckOut ????????????
     * @throws
     */
    @Override
    public OrderCheckOutDTO otcwmsOrderCheck(OrderCheckInDTO inpara,String version)
		    throws IllegalAccessException, InvocationTargetException {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		
		Date startDate = new Date();

		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if("PD".equals(inpara.getDoctype())) {
				result = odsPdInfoService.checkPdInfo(inpara);
			} else if("CUSTOMER".equals(inpara.getDoctype())) {
				result = odsCustomerOrderService.checkCustomerOrder(inpara);
			} 
//		    result = otcwmsOrderCheckService.otcwmsOrderCheck(in);
		    // ??????service
		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// ????????????
		Date endDate = new Date();
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(inpara.getUser(), "Otcwms_Order_Check", inpara.getSign(),
			context, result.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, result);
	
		return result;
    }

    /**
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: otcwmsOrderDelete
     * @Description: (????????????)
     * @param @param in
     * @param @return ????????????
     * @return OtcwmsOrderDeleteOut ????????????
     * @throws
     */
    @Override
    public OrderDeleteOutDTO otcwmsOrderDelete(OrderDeleteInDTO inpara,String version) 
		    throws IllegalAccessException,InvocationTargetException {
		WmsOrderDeleteIn in = new WmsOrderDeleteIn();
		WmsOrderDeleteOut result = new WmsOrderDeleteOut();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		BeanUtils.copyProperties(in, inpara);
		// ????????????
		Date startDate = new Date();
		// ????????????
		RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(),
			in.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
		    // ??????service
		    result = otcwmsOrderDeleteService.otcwmsOrderDelete(in);
		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// ????????????
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, result);
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(in.getUser(), "PO_Order_Delete", in.getSign(),
			context, result.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), in, result);
		return outResult;
    }

    /**
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: otcwmsOrderUpload
     * @Description: ????????????
     * @param @param in
     * @param @return ????????????
     * @return OtcwmsOrderUploadOut ????????????
     * @throws
     */
    @Override
    public OrderUploadOutDTO otcwmsOrderUpload(OrderUploadInDTO inpara,String version) 
		    throws IllegalAccessException,InvocationTargetException {
		logger.debug("Entering otcwmsOrderUpload......");
		
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// ????????????
		Date startDate = new Date();
	
		// ????????????
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),
				inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if ("PO".equals(inpara.getDoctype())){
				outResult = stgPoDownService.scanPoCheck(inpara);
			} else if ("STO".equals(inpara.getDoctype())){
				if ("1".equals(inpara.getOrdertype())){  //??????
					
				} else {
					
				}
			} else if ("CUSTOMER".equals(inpara.getDoctype())) {
				outResult = odsCustomerScanInfoService.scanCustomer(inpara);
			}
			
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// ????????????
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, outResult);
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(inpara.getUser(), "Otcwms_Order_Upload", inpara.getSign(),
			context, outResult.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
	
		return outResult;
    }

    /**
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: otcwmsOrderIgp
     * @Description: (??????????????????)
     * @param @param in
     * @param @return ????????????
     * @return OtcwmsOrderIgpOut ????????????
     * @throws
     */
    @Override
    public OrderIgpOutDTO otcwmsOrderIgp(OrderIgpInDTO inpara,String version)
		    throws IllegalAccessException, InvocationTargetException {
		logger.debug("Entering otcwmsOrderIgp...");
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		WmsOrderIgpOut result = new WmsOrderIgpOut();
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
		// ????????????
		Date startDate = new Date();
	
		// ????????????
		RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(), in.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
		    logger.debug("Sign check successful...");
		    // ??????service
		    if ("DN".equals(in.getDocType()) && "1".equals(in.getOrderType())) {
		        // dn??????
		        logger.debug("Document type is DN and Order type is 1, means DN return...");
		        result = otcwmsOrderIgpService.otcwmsDnOrderIgp(in);
	        } else if ("PD".equals(in.getDocType()) && !"".equals(in.getOrno())) {
	            // PD close
	            logger.debug("Document type is Stock Audit and Order no is not null...");
	            StocktakingServiceClient service = SpringApplicationContextHolder.getBean("stocktakingServiceClient");
	            OdsPdInfoDTO odsPdInfoDTO = new OdsPdInfoDTO();
	            odsPdInfoDTO.setOrderNo(in.getOrno());
	            odsPdInfoDTO.setOrderStatus("2");
	            String res = service.updateStocktakingOrder(odsPdInfoDTO);
	            result.setStatus(res);
	        } else if ("CUSTOMER".equals(in.getDocType())) {
	        	logger.debug("Document type is Customer ");
			} else {
	            logger.debug("Entering normal workflow...");
	            result = otcwmsOrderIgpService.otcwmsOrderIgp(in);
	        }
		} else {
		    logger.error("sign check failed, user must re-login...");
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// ????????????
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, result);
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(in.getUser(), "Otcwms_Order_Igp", in.getSign(),
			context, result.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), in, result);
	
		logger.debug("Exiting otcwmsOrderIgp...");
		return outResult;
    }

    /**  
     * <p>Title: otcwmsOrderLoad</p>  
     * <p>Description: ?????????SAP??????</p>  
     * @param inpara
     * @param version
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException  
     */
    @Override
    public OrderLoadOutDTO otcwmsOrderLoad(OrderLoadInDTO inpara,String version)
		    throws IllegalAccessException, InvocationTargetException {
    	String result ;
		OrderLoadOutDTO outResult = new OrderLoadOutDTO();
		// ????????????
		Date startDate = new Date();
		// ????????????
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),
				inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
		    // ??????service
			if ("PO".equals(inpara.getDoctype())) {
				result = stgPoDownService.downloadPo(inpara.getOrno(), "2018-11-11", null, inpara.getUser());
				if ("S".equals(result)){
					outResult.setStatus("S");
					outResult.setMsg("SUCCESS");
					outResult.setWlList(stgPoDownService.getPoMaterialList(inpara.getOrno()));
				} else {
					outResult.setStatus("F");
					outResult.setMsg("Sap download nothing!");
				}
				
			} else if("STO".equals(inpara.getDoctype())) {
				
			} else if("DN".equals(inpara.getDoctype())) {
				
			} else if("TRANSFOR".equals(inpara.getDoctype())) {
				
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// ????????????
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, outResult);
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(inpara.getUser(), "Otcwms_Order_Downoad", inpara.getSign(),
			context, outResult.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
	
		return outResult;
    }

    /**
     * @Title: OtcwmsBarcodeList
     * @Description: (??????????????????)
     * @param @param inpara
     * @param @return
     * @param @throws IllegalAccessException
     * @param @throws InvocationTargetException ????????????
     * @return OtcwmsOrderDelListOutDTO ????????????
     * @throws
     */
    @Override
    public WmsOrderDelListOutDTO otcwmsBarcodeList(WmsOrderDelListInDTO inpara) {
		OdsOrderInfoDtlDTO odsOrderInfoDtlDTO = new OdsOrderInfoDtlDTO();
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		// ????????????
		Date startDate = new Date();
		// ????????????
		/*RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),
			inpara.getSign(),version);*/
	//	if ("S".equals(rfLogResult.getStatus())) {
		    List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
	    if ("PD".equals(inpara.getDocType())) {// ????????????????????????
	    	OdsPdInfoDtl dtl = new OdsPdInfoDtl();
			dtl.setOrderNo(inpara.getOrderNo());
			dtl.setCreateBy(inpara.getUser());
			OdsPdInfoDtlService service = SpringApplicationContextHolder
				.getBean("odsPdInfoDtlService");
			List<OdsPdInfoDtl> list = service.getOdsPdInfoDtls(dtl);
			if (list == null) {
			    return outResult;
			}
			for (OdsPdInfoDtl odsPdInfoDtl : list) {
			    OrderDelDetialDTO dto = new OrderDelDetialDTO();
			    dto.setBarcode(odsPdInfoDtl.getBarcode());
			    dto.setQty(odsPdInfoDtl.getQty().toString());
			    dto.setSapOrderNo(odsPdInfoDtl.getOrderNo());
			    dto.setRowId(odsPdInfoDtl.getRowId().toString());
			    dto.setLocation(odsPdInfoDtl.getLocation());
			    detial.add(dto);
			}
			outResult.setTotal(list.size() + "");
	    } else if ("CUSTOMER".equals(inpara.getDocType())) {
	    	OdsCustomerScanInfoDTO info = new OdsCustomerScanInfoDTO();
	    	info.setCtrOrderNo(inpara.getOrderNo());
//	    	info.setCreateBy(inpara.getUser());
			List<OdsCustomerScanInfoDTO> list = odsCustomerScanInfoService.getListByParams(info);
			if (list == null) {
			    return outResult;
			}
			for (OdsCustomerScanInfoDTO scanDTO : list) {
			    OrderDelDetialDTO dto = new OrderDelDetialDTO();
			    dto.setBarcode(scanDTO.getBarcode());
			    dto.setQty(scanDTO.getQty().toString());
			    dto.setSapOrderNo(scanDTO.getOrderNo());
			    dto.setRowId(scanDTO.getRowId().toString());
			    dto.setLocation(scanDTO.getLocation());
			    detial.add(dto);
			}
			outResult.setTotal(list.size() + "");
		} else {
	    	// ??????????????????
			odsOrderInfoDtlDTO.setPoNo(inpara.getOrderNo());
			odsOrderInfoDtlDTO.setScannedBy(inpara.getUser());
			odsOrderInfoDtlDTO.setOrderType(inpara.getOrderType());
			// ??????odsOrderInfoDtlService
			OdsOrderInfoDtlService service = SpringApplicationContextHolder
				.getBean("odsOrderInfoDtlService");
			// ????????????????????????????????????
			List<OdsOrderInfoDtlDTO> list = service
				.getOdsOrderInfoDtls(odsOrderInfoDtlDTO);
			if (list == null) {
			    return outResult;
			}
			// ?????????????????????????????????????????????
			for (OdsOrderInfoDtlDTO info : list) {
			    OrderDelDetialDTO otcwmsOrderDelDetialDTO = new OrderDelDetialDTO();
			    otcwmsOrderDelDetialDTO.setBarcode(info.getBarcode());
			    otcwmsOrderDelDetialDTO.setQty(info.getQty().toString());
			    otcwmsOrderDelDetialDTO.setSapOrderNo(info.getPoNo());
			    otcwmsOrderDelDetialDTO
				    .setRowId(info.getRowId().toString());
			    detial.add(otcwmsOrderDelDetialDTO);
			}
			outResult.setTotal(list.size() + "");
	    }
	    outResult.setDetial(detial);
	//	}
		// ????????????
		Date endDate = new Date();
		// RF????????????????????????????????????????????????IP?????????????????????????????????????????????????????????????????????????????????
		rfWsService.writeLog(inpara.getUser(), "Otcwms_Order_GetCarlist",
			inpara.getSign(), context, "",
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
    }

    /**
	 * 
	* @Title: offlineScan
	* @Description: ????????????
	* @param @param paramsIn
	* @param @return
	* @return Map<String,String>
	* @throws
	 */
	@Override
	public Map<String, String> offlineScan(List<OrderUploadInDTO > paramsIn) {
		List<WmsOrderUploadIn > ins = new ArrayList<WmsOrderUploadIn>();
		for (OrderUploadInDTO otcwmsOrderUploadInDTO : paramsIn) {
			WmsOrderUploadIn in = new WmsOrderUploadIn();
			try {
				BeanUtils.copyProperties(in, otcwmsOrderUploadInDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ins.add(in);
		}
		return otcwmsOrderUploadService.offlineScan(ins);
	}

}

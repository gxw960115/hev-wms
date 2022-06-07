package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sto.service.OdsStoCustService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import com.haier.openplatform.wms.sto.service.OdsStoCustServiceClient;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**  
 * @Title:  OdsStoCustServiceClientImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0 
 */  
public class OdsStoCustServiceClientImpl implements OdsStoCustServiceClient {

	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsStoCustServiceClientImpl.class);
	
	@Resource
	private WebServiceContext context;
	private OdsStoCustService odsStoCustService;
	private RfWsService rfWsService;
	public OdsStoCustService getOdsStoCustService() {
		return odsStoCustService;
	}

	public void setOdsStoCustService(OdsStoCustService odsStoCustService) {
		this.odsStoCustService = odsStoCustService;
	}

	public RfWsService getRfWsService() {
		return rfWsService;
	}

	public void setRfWsService(RfWsService rfWsService) {
		this.rfWsService = rfWsService;
	}

	public WebServiceContext getContext() {
		return context;
	}

	public void setContext(WebServiceContext context) {
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#searchOdsStoCusts(long, long, com.haier.openplatform.wms.customer.dto.OdsStoCustDTO)
	 */
	@Override
	public Pager<OdsStoCustDTO> searchOdsStoCusts(long page, long rows, OdsStoCustDTO odsStoCustDTO) {
		Pager<OdsStoCustDTO> pager = new Pager<OdsStoCustDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);

		Pager<OdsStoCustDTO> temp = odsStoCustService.searchOdsStoCusts(pager, odsStoCustDTO);
		long totalSize = temp.getTotalRecords();
		List<OdsStoCustDTO> listInfo = temp.getRecords();
		pager.setRecords(listInfo);
		pager.setTotalRecords(totalSize);
		return pager;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#searchOdsStoCustsCount(com.haier.openplatform.wms.customer.dto.OdsStoCustDTO)
	 */
	@Override
	public Long searchOdsStoCustsCount(OdsStoCustDTO odsStoCustDTO) {
		return odsStoCustService.searchOdsStoCustsCount(odsStoCustDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#getStoCustNo()
	 */
	@Override
	public String getStoCustNo() {
		Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String dateString = formatter.format(currentTime);
        //当前天+sequence eg.1711100001
        String sequence = odsStoCustService.getStoCustNo();
        return dateString + sequence;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#addStoCustInfo(com.haier.openplatform.wms.customer.dto.OdsStoCustDTO, java.util.List)
	 */
	@Override
	public String addStoCustInfo(OdsStoCustDTO odsStoCustDTO, List<OdsStoCustDTO> msg) {
		return odsStoCustService.addStoCustInfo(odsStoCustDTO, msg);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#deleteStoCustBystoNo(java.lang.String)
	 */
	@Override
	public String deleteStoCustByNo(String stoNo) {
		return odsStoCustService.deleteStoCustByNo(stoNo);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#deleteStoCustByIds(java.util.List)
	 */
	@Override
	public String deleteStoCustByIds(List<Long> idList) {
		return odsStoCustService.deleteStoCustByIds(idList);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#customerApprove(java.lang.String, java.lang.String)
	 */
	@Override
	public String stoApprove(String stoNo, String modifyBy) {
		return odsStoCustService.stoApprove(stoNo, modifyBy);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsStoCustServiceClient#orderCheck(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO, java.lang.String)
	 */
	@Override
	public OrderCheckOutDTO orderCheck(OrderCheckInDTO inpara, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
				result = odsStoCustService.checkStoCust(inpara);
		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "Customer_Order_Check", inpara.getSign(),
			context, result.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, result);
	
		return result;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.odsStoCustScanInfoServiceClient#orderDelivery(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO, java.lang.String)
	 */
	@Override
	public OrderIgpOutDTO orderOgp(OrderIgpInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		log.debug("Entering STO CUST OrderIgp...");
		WmsOrderIgpOut result = new WmsOrderIgpOut();
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
		Date startDate = new Date();
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(), inpara.getSign(),version);

		// 调用Service
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
			log.debug("Sign check successful...");
			List<OdsStoCustDTO> list = odsStoCustService.scanStatus(inpara.getOrno());
			String finishFlag = "1",inOutFlag = "0";
			for (OdsStoCustDTO dto : list) {
				if ("1".equals(inpara.getOrderType())){
					if ("0".equals(dto.getGrFinishFlag())) {
						finishFlag = "0";
						break;
					}
					if(!"0".equals(dto.getInFlag())){
						inOutFlag = dto.getInFlag();
						break;
					}
				}
				if ("2".equals(inpara.getOrderType())){
					if ("0".equals(dto.getGiFinishFlag())) {
						finishFlag = "0";
						break;
					}
					if(!"0".equals(dto.getOutFlag())){
						inOutFlag = dto.getOutFlag();
						break;
					}
				}
			}
			if ("1".equals(finishFlag)) {
				//扫描完毕,更改信息
				if ("0".equals(inOutFlag)) {
					odsStoCustService.updateOgpInfo(inpara);
					result = odsStoCustService.orderOgp(in);
				} else {
					if ("1".equals(inOutFlag)) {
						result.setMsg("This Order has already Posting Success!");
					} else {
						result.setMsg("Please post this order on portal!");
					}
				}
			} else {
				result.setMsg("Order Is Not Finished");
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		BeanUtils.copyProperties(outResult, result);
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "StoCust_PDA_Igp", inpara.getSign(),
				context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		log.debug("Exiting STO Cust OrderIgp...");
		return outResult;
	}
}

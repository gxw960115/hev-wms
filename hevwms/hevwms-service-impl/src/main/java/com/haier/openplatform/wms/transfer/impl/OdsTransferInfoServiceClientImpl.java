package com.haier.openplatform.wms.transfer.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.transfer.service.OdsTransferInfoService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient;

/**
 * @Title: OdsTransferInfoServiceClientImpl.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date: 2018年11月7日 下午2:58:10
 * @version V1.0
 */
public class OdsTransferInfoServiceClientImpl implements OdsTransferInfoServiceClient {

	/**  
	* @Fields log: 用一句话描述该文件做什么
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsTransferInfoServiceClientImpl.class);
	
	@Resource
	private WebServiceContext context;
	private OdsTransferInfoService odsTransferInfoService;
	private RfWsService rfWsService;

	public OdsTransferInfoService getOdsTransferInfoService() {
		return odsTransferInfoService;
	}

	public void setOdsTransferInfoService(OdsTransferInfoService odsTransferInfoService) {
		this.odsTransferInfoService = odsTransferInfoService;
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
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#searchOdsTransferInfos(long, long, com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO)
	 */
	@Override
	public Pager<OdsTransferInfoDTO> searchOdsTransferInfos(long page, long rows,
			OdsTransferInfoDTO odsTransferInfoDTO) {
		
		Pager<OdsTransferInfoDTO> pager = new Pager<OdsTransferInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);

		Pager<OdsTransferInfoDTO> temp = odsTransferInfoService.searchTransferInfos(pager,odsTransferInfoDTO);
		long totalSize = temp.getTotalRecords();
		List<OdsTransferInfoDTO> listInfo = temp.getRecords();
		pager.setRecords(listInfo);
		pager.setTotalRecords(totalSize);
		return pager;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#getTransferOrderNo()
	 */
	@Override
	public String getTransferOrderNo() {
		Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String dateString = formatter.format(currentTime);
        //当前天+sequence eg.1711100001
        String sequence = odsTransferInfoService.getTransferOrderNo();
        return dateString + sequence;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#addTranferInfo(com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO, java.util.List)
	 */
	@Override
	public String addTranferInfo(OdsTransferInfoDTO odsTransferInfoDTO, List<OdsTransferInfoDTO> msg) {
		String result = odsTransferInfoService.addTransferInfo(odsTransferInfoDTO, msg);
        return result;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#deleteTransferInfoByTransNo(java.lang.String)
	 */
	@Override
	public String deleteTransferInfoByTransNo(String transNo) {
		return odsTransferInfoService.deleteTransferInfoByTransNo(transNo);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#transferApprove(java.lang.String)
	 */
	@Override
	public String transferApprove(String transNo,String modifyBy) {
		return odsTransferInfoService.transferApprove(transNo,modifyBy);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#deleteTransferInfoByIds(java.lang.String)
	 */
	@Override
	public String deleteTransferInfoByIds(List<Long> idList) {
		return odsTransferInfoService.deleteTransferInfoByIds(idList);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#searchOdsTransferInfosCount(com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO)
	 */
	@Override
	public Long searchOdsTransferInfosCount(OdsTransferInfoDTO odsTransferInfoDTO) {
		return odsTransferInfoService.searchOdsTransferInfosCount(odsTransferInfoDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient#orderCheck(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO, java.lang.String)
	 */
	@Override
	public OrderCheckOutDTO orderCheck(OrderCheckInDTO inpara, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if("TRANSFER".equals(inpara.getDoctype())) {
				result = odsTransferInfoService.checkTransferInfo(inpara);
			} 
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
}

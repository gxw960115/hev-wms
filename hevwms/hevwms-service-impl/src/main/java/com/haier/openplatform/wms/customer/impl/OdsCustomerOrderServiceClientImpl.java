package com.haier.openplatform.wms.customer.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import net.sf.jasperreports.engine.JasperRunManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;
import com.haier.hevwms.customer.service.OdsCustomerOrderService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.customer.service.OdsCustomerOrderServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;

/**  
 * @Title:  OdsCustomerOrderServiceClientImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:42:15   
 * @version V1.0 
 */  
public class OdsCustomerOrderServiceClientImpl implements OdsCustomerOrderServiceClient {

	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsCustomerOrderServiceClientImpl.class);
	
	@Resource
	private WebServiceContext context;
	private OdsCustomerOrderService odsCustomerOrderService;
	private RfWsService rfWsService;
	public OdsCustomerOrderService getOdsCustomerOrderService() {
		return odsCustomerOrderService;
	}

	public void setOdsCustomerOrderService(OdsCustomerOrderService odsCustomerOrderService) {
		this.odsCustomerOrderService = odsCustomerOrderService;
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
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#searchOdsCustomerOrders(long, long, com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO)
	 */
	@Override
	public Pager<OdsCustomerOrderDTO> searchOdsCustomerOrders(long page, long rows,OdsCustomerOrderDTO odsCustomerOrderDTO) {
		Pager<OdsCustomerOrderDTO> pager = new Pager<OdsCustomerOrderDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);

		Pager<OdsCustomerOrderDTO> temp = odsCustomerOrderService.searchOdsCustomerOrders(pager, odsCustomerOrderDTO);
		long totalSize = temp.getTotalRecords();
		List<OdsCustomerOrderDTO> listInfo = temp.getRecords();
		pager.setRecords(listInfo);
		pager.setTotalRecords(totalSize);
		return pager;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#searchOdsCustomerOrdersCount(com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO)
	 */
	@Override
	public Long searchOdsCustomerOrdersCount(OdsCustomerOrderDTO odsCustomerOrderDTO) {
		return odsCustomerOrderService.searchOdsCustomerOrdersCount(odsCustomerOrderDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#getCustomerOrderNo()
	 */
	@Override
	public String getCustomerOrderNo() {
		Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String dateString = formatter.format(currentTime);
        //当前天+sequence eg.1711100001
        String sequence = odsCustomerOrderService.getCustomerOrderNo();
        return dateString + sequence;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#addCustomerOrderInfo(com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO, java.util.List)
	 */
	@Override
	public String addCustomerOrderInfo(OdsCustomerOrderDTO odsCustomerOrderDTO, List<OdsCustomerOrderDTO> msg) {
		return odsCustomerOrderService.addCustomerOrderInfo(odsCustomerOrderDTO, msg);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#deleteCustomerOrderByCusNo(java.lang.String)
	 */
	@Override
	public String deleteCustomerOrderByCusNo(String cusNo) {
		return odsCustomerOrderService.deleteCustomerOrderByCusNo(cusNo);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#deleteCustomerOrderByIds(java.util.List)
	 */
	@Override
	public String deleteCustomerOrderByIds(List<Long> idList) {
		return odsCustomerOrderService.deleteCustomerOrderByIds(idList);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#customerApprove(java.lang.String, java.lang.String)
	 */
	@Override
	public String customerApprove(String cusNo, String modifyBy) {
		return odsCustomerOrderService.customerApprove(cusNo, modifyBy);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerOrderServiceClient#orderCheck(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO, java.lang.String)
	 */
	@Override
	public OrderCheckOutDTO orderCheck(OrderCheckInDTO inpara, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if("CUSTOMER".equals(inpara.getDoctype())) {
				result = odsCustomerOrderService.checkCustomerOrder(inpara);
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
	
	/* (非 Javadoc) 
	* <p>Title: printDetail</p> 
	* <p>Description: </p> 
	* @param filePath
	* @param parameters
	* @return 
	* @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#printDetail(java.lang.String, java.util.Map) 
	*/
	@Override
	public byte[] printDetail(String filePath, Map<String, Object> parameters) {
		byte[] bytes = null;
		Connection conn = null;
		try {
			DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
			conn = datasource.getConnection();
			if (conn == null) {
				return null;
			}
			bytes = JasperRunManager.runReportToPdf(filePath, parameters, conn);
			conn.close();
			String orderNo = parameters.get("orderNo").toString();
			odsCustomerOrderService.updatePrintFlag(orderNo.substring(1, orderNo.length()-1),parameters.get("modifyBy").toString());
		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return bytes;
	}
	
}

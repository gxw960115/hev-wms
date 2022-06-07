package com.haier.wms.controller.order;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.ResultMsg;
import com.haier.wms.util.SessionConstants;

/**
 * @author liujiazhen
 */

@Controller
public class OdsOrderInfoController {
	Logger logger = Logger.getLogger(OdsOrderInfoController.class);

	@Resource
	private OdsOrderInfoServiceClient odsOrderInfoService;

	@Resource
	private PsiReportServiceClient psiReportServiceClient;

	@Resource
	private StgStodnDownServiceClient stgStodnDownServiceClient;

	/**  
	 * @Title: searchOIGPOrders  
	 * @Description: (查询)
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchOIGPOrder", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOIGPOrders(Long page, Long rows, OdsOrderInfoDTO dto) {
		String userType = SessionConstants.getSession().getString("user_duty_type");
		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
		dto.setUserId(userId);
		dto.setUserType(userType);
		Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = odsOrderInfoService.searchOdsOrderInfo(pager, dto);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);

	}
	
	/**  
	 * @Title: searchOIGPOrderInfo  
	 * @Description: (查询)
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchOIGPOrderInfo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOIGPOrderInfo(Long page, Long rows, OdsOrderInfoDTO dto) {
		String userType = SessionConstants.getSession().getString("user_duty_type");
		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
		dto.setUserId(userId);
		dto.setUserType(userType);
		Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = odsOrderInfoService.searchOIGPOrderInfo(pager, dto);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchOIGPOrdersByNo  
	 * @Description: (根据No查询)
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchOrderByNo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOIGPOrdersByNo(OdsOrderInfoDTO dto) {
		List<OdsOrderInfoDTO> bean = odsOrderInfoService.getListByParams(dto);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: report  
	 * @Description: (返回iReport报表视图)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/printReport")
	public String report(HttpServletRequest request, HttpServletResponse response, OdsOrderInfoDTO dto) {
		String path = null;
		byte[] bytes = null;
		// 报表数据源
		String orderNo = dto.getOrderNo();
		String flag = dto.getFlag();
		String handFlag = dto.getHandFlag();
		String carFlag = dto.getCarFlag();
		String sapFlag = dto.getSapFlag();
		String docTpye = dto.getDocTpye();
		Map<String, Object> parameter = new HashMap<String, Object>();

		parameter.put("FLAG", flag);
		parameter.put("SAP_FLAG", sapFlag);
		parameter.put("HAND_FLAG", handFlag);
		parameter.put("DOC_TPYE", docTpye);
		parameter.put("ORDER_NO", orderNo);
		if (carFlag.equals("-1")) {
			path = request.getSession().getServletContext().getRealPath("/")
					+ "/jasper/reportPrint1.jasper";
		} else {
			path = request.getSession().getServletContext().getRealPath("/")
					+ "/jasper/reportPrint.jasper";
		}
		File reportFile = new File(path);

		try {
			response.setContentType("application/pdf");
			ServletOutputStream outStream;

			bytes = psiReportServiceClient.generatePsiReport(
					reportFile.getPath(), parameter);
			outStream = response.getOutputStream();
			if (bytes != null) {
				response.setContentLength(bytes.length);
				outStream.write(bytes, 0, bytes.length);
			}
			outStream.flush();
			outStream.close();
			// conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**  
	 * @Title: addGFOrder  
	 * @Description: (添加出入库单据表)  
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/addScrapOrder", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addGFOrder(OdsOrderInfoDTO dto) {

		return odsOrderInfoService.createOdsOrderInfo(dto);
	}

	/**  
	 * @Title: deleteGFOrder  
	 * @Description: (删除)  
	 * @param ids
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/deleteGFOrder", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteGFOrder(String ids) {

		String result = odsOrderInfoService.deleteOdsOrderInfo(ids);
		return result;
	}
	
	/**  
	 * @Title: searchOrderNo  
	 * @Description: (preScan 单据号grid)  
	 * @param odsOrderInfo
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchOrderNo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOrderNo(OdsOrderInfoDTO odsOrderInfo, Long page, Long rows) {
		odsOrderInfo.setSapFlag("1");
		odsOrderInfo.setFlag("0");
		odsOrderInfo.setInOutFlag("1");
		odsOrderInfo.setPresacnFlag("0");
		odsOrderInfo.setDocTpye("PO");
		Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = odsOrderInfoService.searchOrderNos(pager, odsOrderInfo);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchStoDNDetail  
	 * @Description: (根绝sto dn no查询其下面的所有order items)  
	 * @param odsOrderInfo
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchStoDNDetail", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchStoDNDetail(OdsOrderInfoDTO odsOrderInfo, Long page, Long rows) {
		Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = odsOrderInfoService.searchStoDNDetail(pager, odsOrderInfo);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchOgpDetailList  
	 * @Description: (根绝sto dn no查询对应的发货扫描明细待接收的明细)  
	 * @param odsOrderInfoDtl
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchOgpDetailList", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOgpDetailList(OdsOrderInfoDtlDTO odsOrderInfoDtl, Long page, Long rows) {
		Pager<OdsOrderInfoDtlDTO> pager = new Pager<OdsOrderInfoDtlDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = odsOrderInfoService.searchOgpDetailsByStodnNo(pager, odsOrderInfoDtl);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: prescanImportCheck  
	 * @Description: (根据选择的ogp detail 批量进行入库前校验)  
	 * @param stoDNNo
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/prescanImportCheck", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String prescanImportCheck(String stoDNNo) {
		Map<String, String> result = new HashMap<String, String>();
		try {
			OdsOrderInfoDTO odsOrderInfoDTO = new OdsOrderInfoDTO();
			odsOrderInfoDTO.setSapOrderNo(stoDNNo);

			//根据STO DN单号，获取单据下的所有出入库单据
			List<OdsOrderInfoDTO> odsOrderInfoDTOList = odsOrderInfoService.getListByParams(odsOrderInfoDTO);
			
			result.put("success", "success");
			
			for (OdsOrderInfoDTO odsOrderInfoDTOTemp : odsOrderInfoDTOList) {
				//判断是否做过入库
				if("1".equals(odsOrderInfoDTOTemp.getOrderType())){
					result.put("success", "fail");
					result.put("result", "The data already Pre Scan!");
					break;
				}
				
				//判断出库过账是否成功
				if(!"1".equals(odsOrderInfoDTOTemp.getSapFlag())){
					result.put("success", "fail");
					result.put("result", "Order_NO:"+odsOrderInfoDTOTemp.getOrderNo()+" POST SAP FAIL,don't allow Pre Scan!");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> answer = new HashMap<String, String>();
			answer.put("success", "fail");
			answer.put("result", "Network Abnormal!");
			return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(answer);
		}

		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**  
	 * @Title: searchList  
	 * @Description: (preScan 单据号grid)  
	 * @param odsOrderInfo
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchOrderList", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchList(OdsOrderInfoDTO odsOrderInfo) {
		List<OdsOrderInfoDTO> rows = odsOrderInfoService.getOdsOrderInfos(odsOrderInfo);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
	}
	
	/**  
	 * @Title: iogpCancel  
	 * @Description: (取消IGP/OGP.不调接口手动操作sap，只删除wms扫描记录)
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/iogpCancel", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String iogpCancel(OdsOrderInfoDTO dto) {
		OrderIgpOutDTO outDto = odsOrderInfoService.iogpCancel(dto);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outDto);
	}
	
	/**
	 * @Title: prescan
	 * @Description:  (本与扫描 当前只对STODN 有效)
	 * @param @param msg
	 * @param @param postingDate
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/order/prescan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String prescan(String msg, String postingDate) {
		odsOrderInfoService.saveOdsInfoDtls(msg);
		ResultMsg result = new ResultMsg();
		result.setSuccess("success");
		try {
			ExecuteResult<OdsOrderInfoDTO>  executeResult = odsOrderInfoService.savePreScan(msg, postingDate);
			OdsOrderInfoDTO odsOrderInfo = executeResult.getResult();
			if (odsOrderInfo.getMsg() != null) {
				result.setMsg(odsOrderInfo.getMsg());
			}
			if (!"0".equals(odsOrderInfo.getStatus())) {
				odsOrderInfoService.deleteOdsOrderInfoDtlByNo(msg);
				odsOrderInfoService.updateFinishQty(msg);
				result.setStatus(odsOrderInfo.getStatus());
				result.setSuccess("false");
				result.setSapReturn(odsOrderInfo.getSapReturn());
			}
			if (odsOrderInfo.getOrId() != null) {
				result.setOrId(odsOrderInfo.getOrId());
			}
		} catch (Exception e) {
			odsOrderInfoService.deleteOdsOrderInfoDtlByNo(msg);
			odsOrderInfoService.updateFinishQty(msg);
			result.setSuccess("false");
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**  
	 * @Title: postOrder  
	 * @Description: (过账失败的单据重新过账)  
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/postOrder", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String postOrder(String orderNo) throws Exception {
		logger.debug("Entering postOrder, orderNo = " + orderNo);
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		String sap = odsOrderInfoService.postOrder(orderNo, userName);

		logger.debug("Exiting postOrder, return = " + sap);
		return sap;
	}
	
	/**  
	 * @Title: searchOrderInfoAmount  
	 * @Description: (查询导出数据数量)
	 * @param odsOrderInfo
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchOrderInfoAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOrderInfoAmount(OdsOrderInfoDTO odsOrderInfo){
    	String result = "success";

    	Long exportAmount = odsOrderInfoService.getExportAmount(odsOrderInfo);
    	if (exportAmount > 30000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    	
    }
	
	/**  
	 * @Title: print  
	 * @Description: (ogpigp info打印)  
	 * @param request
	 * @param response
	 * @param orderNos
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/printOgpIgpInfo")
	@ResponseBody
	public String print(HttpServletRequest request, HttpServletResponse response, String orderNos) {
		Map parameters = new HashMap();
		/* "SQLSTR"是报表中定义的参数名称,其类型为String 型
			设置SQLSTR参数的内容,根据需要赋值sql语句
		*/

		String[] orderNo = orderNos.split(",");
		StringBuffer orderNosSb = new StringBuffer();

		if (orderNo.length > 0) {
			for (int i = 0; i < orderNo.length; i++) {
				orderNosSb.append("'").append(orderNo[i]).append("'");
				if (i != orderNo.length - 1) {
					orderNosSb.append(",") ;
				}
			}
		}
		parameters.put("orderNo", orderNosSb.toString());
		String path = request.getSession().getServletContext().getRealPath("/") + "/report/igpOgpInfo.jasper";

		File reportFile = new File(path);

		try {
			ServletOutputStream outStream = response.getOutputStream();
			byte[] bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameters);
			response.setContentType("application/pdf");
			if (bytes != null) {
				response.setContentLength(bytes.length);
				outStream.write(bytes, 0, bytes.length);
			}
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**  
	 * @Title: printOfp  
	 * @Description: (ogpigp info打印)  
	 * @param request
	 * @param response
	 * @param orderNos
	 * @param plantCode
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/printOgp")
	@ResponseBody
	public String printOfp(HttpServletRequest request,
						   HttpServletResponse response, String orderNos, String plantCode) {
		logger.debug("Entering printOfp, orderNo = " + orderNos);
		Map parameters = new HashMap();
		// "SQLSTR"是报表中定义的参数名称,其类型为String 型
		// 设置SQLSTR参数的内容,根据需要赋值sql语句
		String path = request.getSession().getServletContext().getRealPath("/") + "/report/";
		if (orderNos != null) {
			parameters.put("order_no", orderNos);
			parameters.put("SUBREPORT_DIR", path);
			parameters.put("plant", plantCode);
		}
		path = path + "printOgp.jasper";
		logger.debug("Path of report: " + path);
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);
		try {
			ServletOutputStream outStream = response.getOutputStream();
			byte[] bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameters);
			response.setContentType("application/pdf");
			if (bytes != null) {
				response.setContentLength(bytes.length);
				outStream.write(bytes, 0, bytes.length);
			}
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
			logger.error("Catch Unknow Exception: " + e.getMessage());
			e.printStackTrace();
		}
		logger.debug("Exiting printOfp...");
		return null;
	}

	public void setOdsOrderInfoService(
			OdsOrderInfoServiceClient odsOrderInfoService) {
		this.odsOrderInfoService = odsOrderInfoService;
	}

	public PsiReportServiceClient getPsiReportServiceClient() {
		return psiReportServiceClient;
	}

	public void setPsiReportServiceClient(
			PsiReportServiceClient psiReportServiceClient) {
		this.psiReportServiceClient = psiReportServiceClient;
	}

	public StgStodnDownServiceClient getStgStoDnDownServiceClient() {
		return stgStodnDownServiceClient;
	}

	public void setStgStoDnDownServiceClient(
			StgStodnDownServiceClient stgStodnDownServiceClient) {
		this.stgStodnDownServiceClient = stgStodnDownServiceClient;
	}
}

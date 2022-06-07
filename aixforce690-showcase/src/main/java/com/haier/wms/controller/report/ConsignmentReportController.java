package com.haier.wms.controller.report;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
import com.haier.openplatform.wms.report.service.ConsignmentReportServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.controller.report.exceltemplate.ExportConsignmentReportTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
/**
* Consignment Report查询、导出
* @Company: 青鸟软通
* @Title: ConsignmentReportController.java
* @Package com.haier.wms.controller.report
* @author YanFengdan
* @date 2015-11-30 上午11:01:34
*/
@Controller
public class ConsignmentReportController {

	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
	private ConsignmentReportServiceClient consignmentReportServiceClient;
	
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
    private PsiReportServiceClient psiReportServiceClient;
	
	/**  
	 * @Title: searchConsignmentReport  
	 * @Description: (寄售查询)  
	 * @param request
	 * @param page
	 * @param rows
	 * @param consignmentReportDTO
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/searchConsignmentReport",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String searchConsignmentReport(HttpServletRequest request, Long page,
			Long rows, ConsignmentReportDTO consignmentReportDTO) throws Exception {
		PageBean bean = null;
		Pager<ConsignmentReportDTO> pager = new Pager<ConsignmentReportDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = consignmentReportServiceClient.searchConsignmentReport(pager, consignmentReportDTO);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchInventoryAmount  
	 * @Description: (寄售数量查询)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/searchConsignmentReportAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchInventoryAmount(HttpServletRequest request,
          HttpServletResponse response,ConsignmentReportDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = consignmentReportServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
	
	/**  
	 * @Title: exportConsignmentReport  
	 * @Description: (寄售报表导出)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/exportConsignmentReport")
    @ResponseBody
	public String exportConsignmentReport(HttpServletRequest request,
            HttpServletResponse response, ConsignmentReportDTO dto) {
		String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		Servlets.setFileDownloadHeader(request, response, "ConsignmentReport.xlsx");
		List<ConsignmentReportDTO> temp = consignmentReportServiceClient.getConsignmentReportInfos(dto);
		ExcelExportTemplate<ConsignmentReportDTO> export = new ExportConsignmentReportTemplate(temp);
		try {
			export.doExport(response.getOutputStream(), dto);
		}catch(Exception e) {
			e.printStackTrace();
            flag = "false";
            return null;
		}
		return null;
	}
	
	/**  
	 * @Title: printConsigment  
	 * @Description: (寄售报表打印)  
	 * @param request
	 * @param response
	 * @param consignmentReportDTO
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value="/report/printConsigment")
	public String printConsigment(HttpServletRequest request,
            HttpServletResponse response,ConsignmentReportDTO consignmentReportDTO) {
//	    Connection conn = JDBCFactory.getConnection();
//	    Connection conn = psiReportServiceClient.getDBConnection();
	    String path=null;
	    byte[] bytes=null;
	  
	   Map<String, Object> parameter = new HashMap<String,Object>(); 
	     if(!"".equals(consignmentReportDTO.getMaterialNo())&&consignmentReportDTO.getMaterialNo()!=null){
	         parameter.put("MATERIAL_NO",consignmentReportDTO.getMaterialNo());
	     }
	     if(!"".equals(consignmentReportDTO.getCustomerNo())&&consignmentReportDTO.getCustomerNo()!=null){
	         parameter.put("CUSTOMER_NO",consignmentReportDTO.getCustomerNo());
         }
	     if(!"".equals(consignmentReportDTO.getDivision())&&consignmentReportDTO.getDivision()!=null){
	         parameter.put("DIVISION",consignmentReportDTO.getDivision());
         }
	   
	    path = request.getSession().getServletContext().getRealPath("/")
	                + "/report/reportConsigment.jasper";   
	    
	    File reportFile = new File(path);
	 
	    try {
	        response.setContentType("application/pdf");
	        ServletOutputStream outStream;
//	        bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameter, conn);
	        bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameter);
	        outStream = response.getOutputStream();
	        if (bytes != null) {
	            response.setContentLength(bytes.length);
	            outStream.write(bytes, 0, bytes.length);
	        }
	        outStream.flush();
	        outStream.close();
//	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	/**  
	 * @Title: getPsiReportServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return PsiReportServiceClient 
	 * @throws  
	 */  
	public PsiReportServiceClient getPsiReportServiceClient() {
        return psiReportServiceClient;
    }

    /**  
     * @Title: setPsiReportServiceClient  
     * @Description: (set)  
     * @param psiReportServiceClient
     * @return void 
     * @throws  
     */  
    public void setPsiReportServiceClient(
            PsiReportServiceClient psiReportServiceClient) {
        this.psiReportServiceClient = psiReportServiceClient;
    }

	/**  
	 * @Title: getConsignmentReportServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return ConsignmentReportServiceClient 
	 * @throws  
	 */  
	public ConsignmentReportServiceClient getConsignmentReportServiceClient() {
		return consignmentReportServiceClient;
	}

	/**  
	 * @Title: setConsignmentReportServiceClient  
	 * @Description: (set)  
	 * @param consignmentReportServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setConsignmentReportServiceClient(
			ConsignmentReportServiceClient consignmentReportServiceClient) {
		this.consignmentReportServiceClient = consignmentReportServiceClient;
	}
}

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
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.report.service.SalesReturnReportServiceClient;
import com.haier.wms.controller.report.exceltemplate.ExportSalesReturnReportTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
* Sales Return Report查询、导出
* @Company: 青鸟软通
* @Title: SalesReturnReportController.java
* @Package com.haier.wms.controller.report
* @author YanFengdan
* @date 2015-11-30 上午11:02:35
*/
@Controller
public class SalesReturnReportController {

	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
	private SalesReturnReportServiceClient salesReturnReportServiceClient;
	
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
    private PsiReportServiceClient psiReportServiceClient;
	
	/**  
	 * @Title: searchSalesReturnReport  
	 * @Description: (查询)  
	 * @param request
	 * @param page
	 * @param rows
	 * @param salesReturnReportDTO
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/searchSalesReturnReport",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String searchSalesReturnReport(HttpServletRequest request, Long page,
			Long rows, SalesReturnReportDTO salesReturnReportDTO) throws Exception {
		PageBean bean = null;
		Pager<SalesReturnReportDTO> pager = new Pager<SalesReturnReportDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = salesReturnReportServiceClient.searchSalesReturnReport(pager, salesReturnReportDTO);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchSalesReturnAmount  
	 * @Description: (查询数量)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/searchSalesReturnAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchSalesReturnAmount(HttpServletRequest request,
          HttpServletResponse response,SalesReturnReportDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = salesReturnReportServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

	/**  
	 * @Title: exportSalesReturnReport  
	 * @Description: (导出)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/exportSalesReturnReport")
    @ResponseBody
	public String exportSalesReturnReport(HttpServletRequest request,
            HttpServletResponse response, SalesReturnReportDTO dto) {
		String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		Servlets.setFileDownloadHeader(request, response, "SalesReturnReport.xlsx");
		List<SalesReturnReportDTO> temp = salesReturnReportServiceClient.getSalesReturnReportInfos(dto);
		ExcelExportTemplate<SalesReturnReportDTO> export = new ExportSalesReturnReportTemplate(temp);
		try {
			export.doExport(response.getOutputStream(), dto);
		}catch(Exception e) {
			e.printStackTrace();
            flag = "false";
            return null;
		}
		return flag;
	}
	
	/**  
	 * @Title: printOfp  
	 * @Description: (打印)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/sales/return/report")
	@ResponseBody
	public String printOfp(HttpServletRequest request,HttpServletResponse response,
               SalesReturnReportDTO dto){
	    Map<String,Object> parameters = new HashMap<String,Object>();
	    //"SQLSTR"是报表中定义的参数名称,其类型为String 型
	    //设置SQLSTR参数的内容,根据需要赋值sql语句
	    if(!"".equals(dto.getBegin())&&dto.getBegin()!=null){
	        parameters.put("begin", dto.getBegin());
	    }
	    if(!"".equals(dto.getEnd())&&dto.getEnd()!=null){
            parameters.put("end", dto.getEnd());
        }
	    if(!"".equals(dto.getLocation())&&dto.getLocation()!=null){
            parameters.put("location", dto.getLocation());
        }
	    if(!"".equals(dto.getMaterialNo())&&dto.getMaterialNo()!=null){
            parameters.put("materialNo", dto.getMaterialNo());
        }
//	    Connection conn = null;
	    String path = request.getSession().getServletContext().getRealPath("/")
	             + "/report/salesReturnReport.jasper";   
	    byte[] bytes=null;
	    //报表编译之后生成的.jasper文件的存放位置
	    File reportFile = new File(path);
	    try {
	        ServletOutputStream outStream=  response.getOutputStream();
//	            conn = JDBCFactory.getConnection();
//	            conn = psiReportServiceClient.getDBConnection();
//	            bytes= JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn);
	            bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameters);
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
	 * @Title: getSalesReturnReportServiceClient  
	 * @Description: (get)  
	 * @return
	 * @return SalesReturnReportServiceClient 
	 * @throws  
	 */  
	public SalesReturnReportServiceClient getSalesReturnReportServiceClient() {
		return salesReturnReportServiceClient;
	}

	/**  
	 * @Title: setSalesReturnReportServiceClient  
	 * @Description: (set)  
	 * @param salesReturnReportServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setSalesReturnReportServiceClient(
			SalesReturnReportServiceClient salesReturnReportServiceClient) {
		this.salesReturnReportServiceClient = salesReturnReportServiceClient;
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
}

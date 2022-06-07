package com.haier.wms.controller.report;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.controller.report.exceltemplate.ExportPsiReportTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * PSI Report查询、导出
 * 
 * @Company: 青鸟软通
 * @Title: PsiReportController.java
 * @Package com.haier.wms.controller.report
 * @author YanFengdan
 * @date 2015-11-30 上午11:00:27
 */
@Controller
public class PsiReportController {

    /**  
     * @Fields field:field:{}(dubbo接口)  
     */  
    @Resource
    private PsiReportServiceClient psiReportServiceClient;

    /**
     * @Title: searchPsiReport
     * @Description: PSI Report查询
     * @param @param request
     * @param @param page
     * @param @param rows
     * @param @param psiReportDTO
     * @param @return
     * @param @throws Exception
     * @return String
     * @throws
     */
    @RequestMapping(value = "/report/searchPsiReport", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchPsiReport(HttpServletRequest request, Long page,
	    Long rows, PsiReportDTO psiReportDTO) throws Exception {
		PageBean bean = null;
		Pager<PsiReportDTO> pager = new Pager<PsiReportDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = psiReportServiceClient.searchPsiReport(pager, psiReportDTO);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchPsiReportAmount  
     * @Description: (PSI Report数量查询)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/report/searchPsiReportAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchPsiReportAmount(HttpServletRequest request,
          HttpServletResponse response,PsiReportDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = psiReportServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

    /**
     * @Title: exportPsiReport
     * @Description: PSI Report导出
     * @param @param request
     * @param @param response
     * @param @param dto
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/report/exportPsiReport")
    @ResponseBody
    public String exportPsiReport(HttpServletRequest request,
    		HttpServletResponse response, PsiReportDTO dto) {
		String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		Servlets.setFileDownloadHeader(request, response, "PsiReport.xlsx");
		List<PsiReportDTO> temp = psiReportServiceClient.getPsiReportInfos(dto);
		ExcelExportTemplate<PsiReportDTO> export = new ExportPsiReportTemplate(
			temp);
		try {
		    export.doExport(response.getOutputStream(), dto);
		} catch (Exception e) {
		    e.printStackTrace();
		    flag = "false";
		    return null;
		}
		return null;
    }
    
    /**  
     * @Title: print  
     * @Description: (打印)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/psi/print")
    @ResponseBody
    public String print(HttpServletRequest request,
		    HttpServletResponse response, PsiReportDTO dto) {
		Map parameters = new HashMap();
		  PsiReportDTO prd = psiReportServiceClient.conn();
		// "SQLSTR"是报表中定义的参数名称,其类型为String 型
		// 设置SQLSTR参数的内容,根据需要赋值sql语句
		if (!"".equals(dto.getBegin()) && dto.getBegin() != null) {
		    parameters.put("begin", dto.getBegin());
		}
		if (!"".equals(dto.getEnd()) && dto.getEnd() != null) {
		    parameters.put("end", dto.getEnd());
		}
		if (!"".equals(dto.getWarehouseCode())
			&& dto.getWarehouseCode() != null) {
		    parameters.put("warehouseCode", dto.getWarehouseCode());
		}
		if (!"".equals(dto.getLocation()) && dto.getLocation() != null) {
		    parameters.put("location", dto.getLocation());
		}
		if (!"".equals(dto.getMaterialNo()) && dto.getMaterialNo() != null) {
		    parameters.put("materialNo", dto.getMaterialNo());
		}
		if (!"".equals(dto.getDivision()) && dto.getDivision() != null) {
		    parameters.put("division", dto.getDivision());
		}
		String path = null;
		Connection con = null;
		// 报表数据源
		path = request.getSession().getServletContext().getRealPath("/")
			+ "/report/psiReport.jasper";
		File reportFile = new File(path);
		JasperReport jasperReport = null;
		try {
		    jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		} catch (JRException e1) {
		    e1.printStackTrace();
		}
		try {
		    try {
				// 加载MySql的驱动类
				Class.forName(prd.getDriverClassName());
		    } catch (ClassNotFoundException e) {
		    	e.printStackTrace();
		    }
		    try {
		    	con = DriverManager.getConnection(prd.getUrl(), prd.getUserName(),
	                prd.getPassWord());
		    } catch (Exception se) {
		    	se.printStackTrace();
		    }
		    if (con != null) {
				JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, con);
				response.setContentType("text/html");
		
				ServletOutputStream ouputStream = response.getOutputStream();
				JRHtmlExporter exporter = new JRHtmlExporter();
				exporter.setParameter(
					JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
					Boolean.FALSE);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,
					jasperPrint);
				exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,
					"UTF-8");
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					ouputStream);
				exporter.exportReport();
				ouputStream.flush();
				ouputStream.close();
				JasperPrintManager.printReport(jasperPrint, true); // 打印
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}finally{
		    if(con!=null){
		        try {
		        	con.close();
		        } catch (SQLException e) {
		            //  Auto-generated catch block
		            e.printStackTrace();
		        }
	        }
		}
		return null;
    }
    
    /**  
     * @Title: printInQty  
     * @Description: (打印)  
     * @param request
     * @param response
     * @param location
     * @param materialNo
     * @param inoutType
     * @param begin
     * @param end
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/psi/inWarehouseQty")
    @ResponseBody
    public String printInQty(HttpServletRequest request,
		    HttpServletResponse response, String location, String materialNo,
		    String inoutType, String begin, String end) {
		Map parameters = new HashMap();
		// "SQLSTR"是报表中定义的参数名称,其类型为String 型
		// 设置SQLSTR参数的内容,根据需要赋值sql语句
		parameters.put("location", location);
		parameters.put("material_no", materialNo);
		parameters.put("inout_type", inoutType);
		parameters.put("begin", begin);
		parameters.put("end", end);
		String path = request.getSession().getServletContext().getRealPath("/")
			+ "/report/psiIn.jasper";
		byte[] bytes = null;
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);
		try {
		    ServletOutputStream outStream = response.getOutputStream();
		    bytes = psiReportServiceClient.generatePsiReport(
			    reportFile.getPath(), parameters);
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
     * @Title: printOutQty  
     * @Description: (打印)  
     * @param request
     * @param response
     * @param location
     * @param materialNo
     * @param begin
     * @param end
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/psi/outWarehouseQty")
    @ResponseBody
    public String printOutQty(HttpServletRequest request,
		    HttpServletResponse response, String location, String materialNo,
		    String begin, String end) {
		Map parameters = new HashMap();
		// "SQLSTR"是报表中定义的参数名称,其类型为String 型
		// 设置SQLSTR参数的内容,根据需要赋值sql语句
		parameters.put("location", location);
		parameters.put("materialNo", materialNo);
		parameters.put("begin", begin);
		parameters.put("end", end);
		String path = request.getSession().getServletContext().getRealPath("/")
			+ "/report/psiOut.jasper";
		byte[] bytes = null;
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);
		try {
		    ServletOutputStream outStream = response.getOutputStream();
		    bytes = psiReportServiceClient.generatePsiReport(
			    reportFile.getPath(), parameters);
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
     * @Title: printWmsQty  
     * @Description: (打印)  
     * @param request
     * @param response
     * @param location
     * @param materialNo
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/psi/wmsQty")
    @ResponseBody
    public String printWmsQty(HttpServletRequest request,
		    HttpServletResponse response, String location, String materialNo) {
		Map parameters = new HashMap();
		// "SQLSTR"是报表中定义的参数名称,其类型为String 型
		// 设置SQLSTR参数的内容,根据需要赋值sql语句
		parameters.put("location", location);
		parameters.put("materialNo", materialNo);
		String path = request.getSession().getServletContext().getRealPath("/")
			+ "/report/psiWmsQty.jasper";
		byte[] bytes = null;
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);
		try {
		    ServletOutputStream outStream = response.getOutputStream();
		    bytes = psiReportServiceClient.generatePsiReport(
			    reportFile.getPath(), parameters);
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
     * @Title: printOpenQty  
     * @Description: (打印)  
     * @param request
     * @param response
     * @param location
     * @param materialNo
     * @param begin
     * @param end
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/psi/openQty")
    @ResponseBody
    public String printOpenQty(HttpServletRequest request,
		    HttpServletResponse response, String location, String materialNo,
		    String begin, String end) {
		Map parameters = new HashMap();
		// "SQLSTR"是报表中定义的参数名称,其类型为String 型
		// 设置SQLSTR参数的内容,根据需要赋值sql语句
		parameters.put("location", location);
		parameters.put("materialNo", materialNo);
		parameters.put("begin", begin);
		parameters.put("end", end);
		String path = request.getSession().getServletContext().getRealPath("/")
			+ "/report/psiOpenQty.jasper";
		byte[] bytes = null;
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);
		try {
		    ServletOutputStream outStream = response.getOutputStream();
		    bytes = psiReportServiceClient.generatePsiReport(
			    reportFile.getPath(), parameters);
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

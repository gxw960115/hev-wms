package com.haier.wms.controller.report;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.sql.Connection;
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
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.report.service.StoIntransitReportServiceClient;
import com.haier.wms.controller.report.exceltemplate.ExportStoIntransitReportTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
* STO Intransit Report查询、导出
* @Company: 青鸟软通
* @Title: StoIntransitReportController.java
* @Package com.haier.wms.controller.report
* @author YanFengdan
* @date 2015-11-30 上午11:02:12
*/
@Controller
public class StoIntransitReportController {

	/**  
	 * @Fields field:field:{}(用一句话描述这个变量表示什么)  
	 */  
	@Resource
	private StoIntransitReportServiceClient stoIntransitReportServiceClient;
	
	/**  
	 * @Fields field:field:{}(用一句话描述这个变量表示什么)  
	 */  
	@Resource
    private PsiReportServiceClient psiReportServiceClient;
	
	/**  
	 * @Title: searchStoIntransitReport  
	 * @Description: (查询)  
	 * @param request
	 * @param page
	 * @param rows
	 * @param stoIntransitReportDTO
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/searchStoIntransitReport",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String searchStoIntransitReport(HttpServletRequest request, Long page,
			Long rows, StoIntransitReportDTO stoIntransitReportDTO) throws Exception {
		PageBean bean = null;
		Pager<StoIntransitReportDTO> pager = new Pager<StoIntransitReportDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = stoIntransitReportServiceClient.searchStoIntransitReport(pager, stoIntransitReportDTO);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchStoIntransitAmount  
	 * @Description: (查询数量)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/searchStoIntransitAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStoIntransitAmount(HttpServletRequest request,
          HttpServletResponse response,StoIntransitReportDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stoIntransitReportServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    	
    }
	
	/**  
	 * @Title: exportStoIntransitReport  
	 * @Description: (导出)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/report/exportStoIntransitReport")
    @ResponseBody
	public String exportStoIntransitReport(HttpServletRequest request,
            HttpServletResponse response, StoIntransitReportDTO dto) {
		String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		Servlets.setFileDownloadHeader(request, response, "StoIntransitReport.xlsx");
		List<StoIntransitReportDTO> temp = stoIntransitReportServiceClient.getStoIntransitPsiReportInfos(dto);
		ExcelExportTemplate<StoIntransitReportDTO> export = new ExportStoIntransitReportTemplate(temp);
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
     * @Title: printOfp  
     * @Description: (打印)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/sto/intransit/report")
    @ResponseBody
    public String printOfp(HttpServletRequest request,HttpServletResponse response,
    			StoIntransitReportDTO dto){
    	Map parameters = new HashMap();
    	//"SQLSTR"是报表中定义的参数名称,其类型为String 型
    	//设置SQLSTR参数的内容,根据需要赋值sql语句
    	if(!"".equals(dto.getStoNo())&&dto.getStoNo()!=null){
    		parameters.put("stoNo", dto.getStoNo());
    	}
    	if(!"".equals(dto.getMaterialNo())&&dto.getMaterialNo()!=null){
    		parameters.put("materialNo", dto.getMaterialNo());
    	}
    	if(!"".equals(dto.getDivision())&&dto.getDivision()!=null){
    		parameters.put("division", dto.getDivision());
    	}
    	Connection conn = null;
        String   path = request.getSession().getServletContext().getRealPath("/")
                     + "/report/stoIntrasitReport.jasper";   
        byte[] bytes=null;
        //报表编译之后生成的.jasper文件的存放位置
        File reportFile = new File(path);
        try {
        	ServletOutputStream outStream=  response.getOutputStream();
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
	 * @Title: getStoIntransitReportServiceClient  
	 * @Description: (ge)  
	 * @return
	 * @return StoIntransitReportServiceClient 
	 * @throws  
	 */  
	public StoIntransitReportServiceClient getStoIntransitReportServiceClient() {
		return stoIntransitReportServiceClient;
	}

	/**  
	 * @Title: setStoIntransitReportServiceClient  
	 * @Description: (set)  
	 * @param stoIntransitReportServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setStoIntransitReportServiceClient(
			StoIntransitReportServiceClient stoIntransitReportServiceClient) {
		this.stoIntransitReportServiceClient = stoIntransitReportServiceClient;
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

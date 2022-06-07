package com.haier.wms.controller.sto;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnScanInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoScanInfoServiceClient;
import com.haier.wms.exceltemplate.sto.ExportOdsStoDnGigrInfoListTemplet;
import com.haier.wms.exceltemplate.sto.ExportOdsStoDnScanInfoListTemplet;
import com.haier.wms.exceltemplate.sto.ExportOdsStoScanInfoListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

import io.terminus.common.utils.JsonMapper;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoScanInfoController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 上午9:45:15
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

@Controller
public class OdsStoScanInfoController {
	
	@Resource
	private OdsStoScanInfoServiceClient odsStoScanInfoServiceClient;
	
	@Resource
    private PsiReportServiceClient psiReportServiceClient;

	public void setOdsStoScanInfoServiceClient(OdsStoScanInfoServiceClient odsStoScanInfoServiceClient) {
		this.odsStoScanInfoServiceClient = odsStoScanInfoServiceClient;
	}

	Logger logger = Logger.getLogger(OdsStoScanInfoController.class);
	
	@RequestMapping(value = "/sto/searchOdsStoScanInfo", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsStoScanInfo(Long page, Long rows, OdsStoScanInfoDTO dto) {
        Pager<OdsStoScanInfoDTO> pager = odsStoScanInfoServiceClient.searchOdsStoScanInfoByPage(page, rows, dto);
        PageBean bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
	
	/**  
     * @Title: searchStgDnDownAmount  
     * @Description: 查询导出的数据，并判断是否大于25000
     * @param request
     * @param response
     * @param dto
     * @return String 
     */  
    @RequestMapping(value = "/sto/searchOdsStoScanInfoAmount", method = RequestMethod.POST,
    		produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsStoScanInfoAmount(OdsStoScanInfoDTO dto){
    	String result = "success";
    	//查询导出的数据总量是多少
    	Long exportAmount = odsStoScanInfoServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    @RequestMapping(value = "/sto/exportOdsStoScanInfo", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportOdsStoScanInfo(HttpServletRequest request,HttpServletResponse response,OdsStoScanInfoDTO dto) throws Exception {
		String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StoScanInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
        
		List<OdsStoScanInfoDTO> temp = odsStoScanInfoServiceClient.getOdsStoScanInfos(dto);
		ExcelExportTemplate<OdsStoScanInfoDTO> exportTemplet = new ExportOdsStoScanInfoListTemplet(temp);
		try {
			exportTemplet.doExport(response.getOutputStream(),dto == null ? new OdsStoScanInfoDTO() : dto);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "failture";
			return flag;
		}
		return null;
	}
    
    @RequestMapping(value = "/sto/printStoDetail")
    @ResponseBody
    public String printSoDetail(HttpServletRequest request,HttpServletResponse response,String barcodes, String orderNo){
    	Map<String,Object> parameters = new HashMap<String,Object>();
    	
    	String[] barcode = barcodes.split(",");
    	StringBuffer barcodesSb = new StringBuffer();
		// 拼sql in(,,,,)
		if (barcode.length > 0) {
			for (int i = 0; i < barcode.length; i++) {
				barcodesSb.append("'").append(barcode[i]).append("'");
				if (i != barcode.length - 1) {
					barcodesSb.append(",");
				}
			}
		}
		String basicPath = request.getSession().getServletContext().getRealPath("/");
		parameters.put("barcode", barcodesSb.toString());
		parameters.put("orderNo", "'"+orderNo+"'");
		parameters.put("logo", basicPath+"/pdf/aqua.png");
		String path = basicPath + "/pdf/stoDetail.jasper";
		
		byte[] bytes = null;
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);

    	try {
    		ServletOutputStream outStream =	response.getOutputStream();
			bytes = odsStoScanInfoServiceClient.printStoDetail(reportFile.getPath(), parameters);


//			bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameters);
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
	 * @title: searchStoDnAmount
	 * @description: 统计
	 * @param dto
	 * @return: String
	 */
	@RequestMapping(value = "/stoDn/searchOdsStoDnScanInfoAmount", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchStoDnAmount(OdsStodnScanInfoDTO dto) {
		String result = "success";
		Long size = odsStoScanInfoServiceClient.getExportOdsStoDnScanInfoAmount(dto);
		if (size > 25000) {
			result = "The amount of data you exported is too large, please narrowing the query range!";
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**
	 * @title: exportExcel
	 * @description: 导出Excel报表
	 * @author: LJZ
	 * @version: v1.0.0
	 * @param request
	 * @param response
	 * @param dto
	 * @return: String
	 */
	@RequestMapping(value = "/stoDn/exportOdsStoDnScanInfoExcel", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportStoDnExcel(HttpServletRequest request,HttpServletResponse response,OdsStodnScanInfoDTO dto) {
		String flag = "success";

		response.setContentType(Servlets.EXCEL_TYPE);
		StringBuffer fileNameBuffer = new StringBuffer();
		fileNameBuffer.append("StoDnScanInfo");
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		fileNameBuffer.append(fmtDate.format(new Date()));
		fileNameBuffer.append(".xlsx");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		List<OdsStodnScanInfoDTO> list = odsStoScanInfoServiceClient.getStoDnScanInfoListByParm(dto);
		ExcelExportTemplate<OdsStodnScanInfoDTO> listTemplet = new ExportOdsStoDnScanInfoListTemplet(list);
		try {
			listTemplet.doExport(response.getOutputStream(), dto == null ? new OdsStodnScanInfoDTO():dto);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "failture";
			return flag;
		}
		return null;
	}
}

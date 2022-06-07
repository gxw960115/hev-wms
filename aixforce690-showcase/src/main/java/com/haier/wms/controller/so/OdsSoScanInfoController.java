package com.haier.wms.controller.so;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
import com.haier.openplatform.wms.so.service.OdsSoScanInfoServiceClient;
import com.haier.wms.exceltemplate.so.ExportOdsSoScanInfoListTemplet;
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
 * @className: OdsSoScanInfoController.java
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
public class OdsSoScanInfoController {
	
	@Resource
	private OdsSoScanInfoServiceClient odsSoScanInfoServiceClient;

	@Resource
	private PsiReportServiceClient psiReportServiceClient;

	public void setOdsSoScanInfoServiceClient(OdsSoScanInfoServiceClient odsSoScanInfoServiceClient) {
		this.odsSoScanInfoServiceClient = odsSoScanInfoServiceClient;
	}

	Logger logger = Logger.getLogger(OdsSoScanInfoController.class);
	
	@RequestMapping(value = "/so/searchOdsSoScanInfo", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsSoScanInfo(Long page, Long rows, OdsSoScanInfoDTO dto) {
        Pager<OdsSoScanInfoDTO> pager = odsSoScanInfoServiceClient.searchOdsPoScanInfoByPage(page, rows, dto);
        PageBean bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
	
	/**  
     * @Title: searchStgDnDownAmount  
     * @Description: 查询导出的数据，并判断是否大于25000
     * @param dto
     * @return String 
     */  
    @RequestMapping(value = "/so/searchOdsSoScanInfoAmount", method = RequestMethod.POST,
    		produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsSoScanInfoAmount(OdsSoScanInfoDTO dto){
    	String result = "success";
    	//查询导出的数据总量是多少
    	Long exportAmount = odsSoScanInfoServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    @RequestMapping(value = "/so/updateOldBarcode", method = RequestMethod.POST,
    		produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String updateOldBarcode(OdsSoScanInfoDTO dto){

    	String result = odsSoScanInfoServiceClient.updateOldBarcode(dto);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**
     * @title: exportOdsSoScanInfo
     * @description: 
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月20日 上午12:13:18
     * @param response
     * @param dto
     * @throws Exception
     * @return: String
     */
    @RequestMapping(value = "/so/exportOdsSoScanInfo", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportOdsSoScanInfo(HttpServletResponse response,OdsSoScanInfoDTO dto) {
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("SoScanInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
		
		List<OdsSoScanInfoDTO> temp = odsSoScanInfoServiceClient.getOdsPoScanInfos(dto);
		ExcelExportTemplate<OdsSoScanInfoDTO> exportTemplate = new ExportOdsSoScanInfoListTemplet(temp);
		try {
			exportTemplate.doExport(response.getOutputStream(),dto == null ? new OdsSoScanInfoDTO() : dto);
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		return null;
	}

	/**
	 * 打印扫描详情
	 * @param request
	 * @param response
	 * @param barcodes
	 * @param dnNo
	 * @param orderNo
	 * @return
	 */
    @RequestMapping(value = "/so/printSoDetail")
    @ResponseBody
    public String printSoDetail(HttpServletRequest request,HttpServletResponse response,String barcodes,String dnNo, String orderNo){
    	Map<String,Object> parameters = new HashMap<String,Object>(8);
    	String[] barcode = barcodes.split(",");
    	StringBuilder barcodeBuilder = new StringBuilder(229);
		// 拼sql in(,,,,)
		if (barcode.length > 0) {
			for (int i = 0; i < barcode.length; i++) {
				barcodeBuilder.append("'").append(barcode[i]).append("'");
				if (i != barcode.length - 1) {
					barcodeBuilder.append(",");
				}
			}
		}
		String basicPath = request.getSession().getServletContext().getRealPath("/");
		parameters.put("barcode", barcodeBuilder.toString());
		parameters.put("orderNo", "'"+orderNo+"'");
		parameters.put("logo", basicPath+"/pdf/aqua.png");
		parameters.put("dnNo", dnNo);

		String path = basicPath + "/pdf/soDetail.jasper";
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);

    	try {
    		ServletOutputStream outStream =	response.getOutputStream();
			byte[] bytes = odsSoScanInfoServiceClient.printSoDetail(reportFile.getPath(), parameters);
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
}

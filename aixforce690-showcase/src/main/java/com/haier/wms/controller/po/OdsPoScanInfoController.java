package com.haier.wms.controller.po;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
import com.haier.openplatform.wms.po.service.OdsPoScanInfoServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.exceltemplate.po.ExportOdsPoScanInfoListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

@Controller
public class OdsPoScanInfoController {
	@Resource
	private OdsPoScanInfoServiceClient odsPoScanInfoServiceClient;
	
	@Resource
    private PsiReportServiceClient psiReportServiceClient;

	public void setOdsPoScanInfoServiceClient(OdsPoScanInfoServiceClient odsPoScanInfoServiceClient) {
		this.odsPoScanInfoServiceClient = odsPoScanInfoServiceClient;
	}

	public void setPsiReportServiceClient(PsiReportServiceClient psiReportServiceClient) {
		this.psiReportServiceClient = psiReportServiceClient;
	}

	/**
	 * @title: searchOdsOrderInfoDtl
	 * @description: 根据条件分页查询PO Scan Info
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:06:48 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: String
	 */
	@RequestMapping(value = "/po/searchOdsPoScanInfo",
						method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOdsPoScanInfo(Long page, Long rows,OdsPoScanInfoDTO dto){
		Pager<OdsPoScanInfoDTO> pager = odsPoScanInfoServiceClient.searchOdsPoScanInfoByPage(page, rows, dto);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	

	/**
	 * @title: searchOrderInfoDtlAmount
	 * @description: 查询导出excel数量
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午3:50:48 
	 * @param OdsOrderInfoDtlDTO
	 * @return: String
	 */
	@RequestMapping(value = "/po/searchPoScanInfoExportAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchPoScanInfoExportAmount(OdsPoScanInfoDTO dto){
    	String result = "success";
    	Long exportAmount = odsPoScanInfoServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
	
	/**  
	 * @Title: exportOdsOrderInfoDtl  
	 * @Description: ogp igp detail 导出)  
	 * @param request
	 * @param response
	 * @param odsOrderInfoDtl
	 * @throws Exception
	 * @return String 
	 */  
	@RequestMapping(value = "/po/exportPoScanInfo", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportPoScanInfo(HttpServletRequest request,HttpServletResponse response,OdsPoScanInfoDTO dto)throws Exception{
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("PoScanInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		String flag="success";
		List<OdsPoScanInfoDTO> temp = odsPoScanInfoServiceClient.getOdsPoScanInfos(dto);
		ExcelExportTemplate<OdsPoScanInfoDTO> exportTemplet= new ExportOdsPoScanInfoListTemplet(temp);
		try {
			exportTemplet.doExport(response.getOutputStream(), dto == null ? new OdsPoScanInfoDTO(): dto);
		}catch (Exception e) {
			e.printStackTrace();
            flag = "failture";
            return flag;
		} 
		return null;
	}
    
    @RequestMapping(value = "/po/printPoDetail")
    @ResponseBody
    public String printPoDetail(HttpServletRequest request,HttpServletResponse response,String barcodes, String orderNo){
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
		String path = basicPath + "/pdf/poDetail.jasper";
		
		byte[] bytes = null;
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);

    	try {
    		ServletOutputStream outStream =	response.getOutputStream();
//			conn = JDBCFactory.getConnection();
//    		conn = psiReportServiceClient.getDBConnection();
//			bytes= JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn);
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
}

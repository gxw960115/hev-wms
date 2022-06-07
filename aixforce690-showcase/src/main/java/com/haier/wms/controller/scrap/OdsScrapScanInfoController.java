package com.haier.wms.controller.scrap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;
import com.haier.openplatform.wms.scrap.service.OdsScrapScanInfoServiceClient;
import com.haier.wms.exceltemplate.scrap.ExportOdsScrapScanInfoListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

import io.terminus.common.utils.JsonMapper;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapScanInfoController.java
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
public class OdsScrapScanInfoController {
	
	@Resource
	private OdsScrapScanInfoServiceClient odsScrapScanInfoServiceClient;

	public void setOdsScrapScanInfoServiceClient(OdsScrapScanInfoServiceClient odsScrapScanInfoServiceClient) {
		this.odsScrapScanInfoServiceClient = odsScrapScanInfoServiceClient;
	}

	Logger logger = Logger.getLogger(OdsScrapScanInfoController.class);
	
	@RequestMapping(value = "/scrap/searchOdsScrapScanInfo", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsScrapScanInfo(Long page, Long rows, OdsScrapScanInfoDTO dto) {
        Pager<OdsScrapScanInfoDTO> pager = odsScrapScanInfoServiceClient.searchOdsScrapScanInfoByPage(page, rows, dto);
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
    @RequestMapping(value = "/scrap/searchOdsScrapScanInfoAmount", method = RequestMethod.POST,
    		produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsScrapScanInfoAmount(OdsScrapScanInfoDTO dto){
    	String result = "success";
    	//查询导出的数据总量是多少
    	Long exportAmount = odsScrapScanInfoServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**
     * @title: exportOdsScrapScanInfo
     * @description: 导出Excel
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月24日 下午4:31:24 
     * @param request
     * @param response
     * @param dto
     * @throws Exception
     * @return: String
     */
    @RequestMapping(value = "/scrap/exportOdsScrapScanInfo", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportOdsScrapScanInfo(HttpServletRequest request,HttpServletResponse response,OdsScrapScanInfoDTO dto) throws Exception {

    	String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("ScrapScanInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		List<OdsScrapScanInfoDTO> temp = odsScrapScanInfoServiceClient.getOdsScrapScanInfos(dto);
		ExcelExportTemplate<OdsScrapScanInfoDTO> exportTemplet = new ExportOdsScrapScanInfoListTemplet(temp);
		try {
			exportTemplet.doExport(response.getOutputStream(),dto == null ? new OdsScrapScanInfoDTO() : dto);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "failture";
			return flag;
		}
		return null;
	}
    
}

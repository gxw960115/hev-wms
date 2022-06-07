package com.haier.wms.controller.consume;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import com.haier.openplatform.wms.consume.service.OdsConsumeScanInfoServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.wms.exceltemplate.consume.ExportOdsConsumeScanInfoListTemplet;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeScanInfoController.java
 * @description: 领用扫描订单Controller
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
public class OdsConsumeScanInfoController {
	
	@Resource
	private OdsConsumeScanInfoServiceClient odsConsumeScanInfoServiceClient;

	public void setOdsConsumeScanInfoServiceClient(OdsConsumeScanInfoServiceClient odsConsumeScanInfoServiceClient) {
		this.odsConsumeScanInfoServiceClient = odsConsumeScanInfoServiceClient;
	}

	Logger logger = Logger.getLogger(OdsConsumeScanInfoController.class);
	
	@RequestMapping(value = "/consume/searchOdsConsumeScanInfo", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsConsumeScanInfo(Long page, Long rows, OdsConsumeScanInfoDTO dto) {
        Pager<OdsConsumeScanInfoDTO> pager = odsConsumeScanInfoServiceClient.searchOdsConsumeScanInfoByPage(page, rows, dto);
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
    @RequestMapping(value = "/consume/searchOdsConsumeScanInfoAmount", method = RequestMethod.POST,
    		produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOdsConsumeScanInfoAmount(OdsConsumeScanInfoDTO dto){
    	String result = "success";
    	//查询导出的数据总量是多少
    	Long exportAmount = odsConsumeScanInfoServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**
     * @title: exportOdsConsumeScanInfo
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
    @RequestMapping(value = "/consume/exportOdsConsumeScanInfo", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportOdsConsumeScanInfo(HttpServletRequest request,HttpServletResponse response,OdsConsumeScanInfoDTO dto) throws Exception {
		
		String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("ConsumeScanInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		List<OdsConsumeScanInfoDTO> temp = odsConsumeScanInfoServiceClient.getOdsConsumeScanInfos(dto);
		ExcelExportTemplate<OdsConsumeScanInfoDTO> exportTemplet = new ExportOdsConsumeScanInfoListTemplet(temp);
		try {
			exportTemplet.doExport(response.getOutputStream(),dto == null ? new OdsConsumeScanInfoDTO() : dto);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "failture";
			return flag;
		}
		return null;
	}
    
}

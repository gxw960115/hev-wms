package com.haier.wms.controller.scrap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.scrap.service.OdsScrapOrderServiceClient;
import com.haier.wms.exceltemplate.scrap.ExportOdsScrapOrderTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapOrderController.java
 * @description: 报废单Controller
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月23日 下午2:04:57
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月23日		LJZ			v1.0.0			create
 */

@Controller
public class OdsScrapOrderController {
	
	private static final Logger logger = Logger.getLogger(OdsScrapOrderController.class);
	
	@Resource
	private OdsScrapOrderServiceClient odsScrapOrderServiceClient;

	public void setOdsScrapOrderServiceClient(OdsScrapOrderServiceClient odsScrapOrderServiceClient) {
		this.odsScrapOrderServiceClient = odsScrapOrderServiceClient;
	}

	/**
	 * @title: serachOdsScrapOrders
	 * @description: 条件分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午2:50:03 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: String
	 */
	@RequestMapping(value = "/scrap/searchOdsScrapOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String serachOdsScrapOrders(Long page, Long rows, OdsScrapOrderDTO dto){
		Pager<OdsScrapOrderDTO> pager = odsScrapOrderServiceClient.searchOdsScrapOrderByPage(page, rows, dto);
        PageBean bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**
	 * @title: deleteScrapOrder
	 * @description: 删除ScrapOrder
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午5:07:00 
	 * @return: String
	 */
	@RequestMapping(value = "/scrap/deleteScrapOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteScrapOrder(String rowIds) {
		if (rowIds == null || rowIds.length() < 1) {
			return "Can't get IDs!";
		}
		String[] ids = rowIds.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			idList.add(Long.parseLong(id));
		}
		
		int row = odsScrapOrderServiceClient.deleteScrapOrder(idList);
		logger.info("delete scrap Order "+row+" data!");
		
		return "deleteSuccess";
	}
	
	/**
	 * @title: approveScrapOrder
	 * @description: 确认报废单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 上午11:15:47 
	 * @param rowIds
	 * @return: String
	 */
	@RequestMapping(value = "/scrap/approveScrapOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String approveScrapOrder(String rowIds) {
		if (rowIds == null || rowIds.length() < 1) {
			return "Can't get IDs!";
		}
		String[] ids = rowIds.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			idList.add(Long.parseLong(id));
		}
		String userName = SessionConstants.getSession().getString("_user_name");
		
		int row = odsScrapOrderServiceClient.approveScrapOrder(idList, userName);
		logger.info("approve scrap Order "+row+" data!");
		return "approveSuccess";
	}
	
	/**  
	 * <p>Title: getScrapSequence</p>  
	 * <p>Description:获取id </p>  
	 * @return  
	 */
	@RequestMapping(value = "/scrap/getScrapSequence", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getScrapSequence() {
		
		return odsScrapOrderServiceClient.getScrapSequence();
	}
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "/scrap/saveScrapOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addScrapOrder(HttpServletRequest request, String msg, OdsScrapOrderDTO dto) {
		dto.setCreateBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		dto.setCreateDate(new Date());
		List<OdsScrapOrderDTO> list = JSON.parseArray(msg, OdsScrapOrderDTO.class);
		String result = odsScrapOrderServiceClient.saveScrapOrder(list, dto);
		return result;
	}
	
	
	/** 
	* @Title: updateCostCenter 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param request
	* @param @param msg
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年7月9日
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "/scrap/updateCostCenter", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String updateCostCenter(HttpServletRequest request, String msg, OdsScrapOrderDTO dto) {
		dto.setModifyBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		dto.setModifyDate(new Date());
		int result = odsScrapOrderServiceClient.updateCostCenter(dto);
		logger.info("update scrap Order "+result+" data!");
		return "success";
	}
	
	/**
	 * @title: searchExportAmount
	 * @description: 查询导出数据大小
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午4:41:01 
	 * @return: String
	 */
	@RequestMapping(value = "/scrap/searchOdsScrapOrderAmount", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchExportAmount(OdsScrapOrderDTO dto) {
		String result = "success";
		Long exportAmount = odsScrapOrderServiceClient.getExportAmount(dto);
		if (exportAmount > 25000) {
			result = "The amount of data you exported is too large, please narrowing the query range!";
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**
	 * @title: exportOdsScrapOrder
	 * @description: 导出Excel
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午4:35:14 
	 * @return: String
	 */
	@RequestMapping(value = "/scrap/exportOdsScrapOrder", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	public void exportOdsScrapOrder(HttpServletRequest request,HttpServletResponse response,OdsScrapOrderDTO dto) {

		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("ScrapOrderInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
        
		List<OdsScrapOrderDTO> resultList = odsScrapOrderServiceClient.getOdsScrapOrderByList(dto);
		ExcelExportTemplate<OdsScrapOrderDTO> templet = new ExportOdsScrapOrderTemplet(resultList);
		try {
			templet.doExport(response.getOutputStream(), dto == null ? new OdsScrapOrderDTO() : dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

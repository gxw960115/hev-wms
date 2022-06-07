package com.haier.wms.controller.consume;

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
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.wms.exceltemplate.consume.ExportOdsConsumeOrderTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeOrderController.java
 * @description: 
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
public class OdsConsumeOrderController {
	
	private static final Logger logger = Logger.getLogger(OdsConsumeOrderController.class);
	
	@Resource
	private OdsConsumeOrderServiceClient odsConsumeOrderServiceClient;

	public void setOdsConsumeOrderServiceClient(OdsConsumeOrderServiceClient odsConsumeOrderServiceClient) {
		this.odsConsumeOrderServiceClient = odsConsumeOrderServiceClient;
	}

	/**
	 * @title: serachOdsConsumeOrders
	 * @description: 条件分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午2:50:03 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: String
	 */
	@RequestMapping(value = "/consume/searchOdsConsumeOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String serachOdsConsumeOrders(Long page, Long rows, OdsConsumeOrderDTO dto){
		Pager<OdsConsumeOrderDTO> pager = odsConsumeOrderServiceClient.searchOdsConsumeOrderByPage(page, rows, dto);
        PageBean bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**
	 * @title: deleteConsumeOrder
	 * @description: 删除ConsumeOrder
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午5:07:00 
	 * @return: String
	 */
	@RequestMapping(value = "/consume/deleteConsumeOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteConsumeOrder(String rowIds) {
		if (rowIds == null || rowIds.length() < 1) {
			return "Can't get IDs!";
		}
		String[] ids = rowIds.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			idList.add(Long.parseLong(id));
		}
		
		int row = odsConsumeOrderServiceClient.deleteConsumeOrder(idList);
		logger.info("delete consume Order "+row+" data!");
		
		return "deleteSuccess";
	}
	
	/**
	 * @title: approveConsumeOrder
	 * @description: 确认领用单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 上午11:15:47 
	 * @param rowIds
	 * @return: String
	 */
	@RequestMapping(value = "/consume/approveConsumeOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String approveConsumeOrder(String rowIds) {
		if (rowIds == null || rowIds.length() < 1) {
			return "Can't get IDs!";
		}
		String[] ids = rowIds.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			idList.add(Long.parseLong(id));
		}
		String userName = SessionConstants.getSession().getString("_user_name");
		
		int row = odsConsumeOrderServiceClient.approveConsumeOrder(idList, userName);
		logger.info("approve consume Order "+row+" data!");
		return "approveSuccess";
	}
	
	/**  
	 * <p>Title: getConsumeSequence</p>  
	 * <p>Description: </p>  
	 * @return  
	 */
	@RequestMapping(value = "/consume/getConsumeSequence", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getConsumeSequence() {
		return odsConsumeOrderServiceClient.getConsumeSequence();
	}
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "/consume/saveConsumeOrder", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addConsumeOrder(HttpServletRequest request, String msg, OdsConsumeOrderDTO dto) {
		dto.setCreateBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		dto.setCreateDate(new Date());
		List<OdsConsumeOrderDTO> list = JSON.parseArray(msg, OdsConsumeOrderDTO.class);
		String result = odsConsumeOrderServiceClient.saveConsumeOrder(list, dto);
		return result;
	}
	
	/**
	 * @title: searchExportAmount
	 * @description: 查询导出数据大小
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午4:41:01 
	 * @return: String
	 */
	@RequestMapping(value = "/consume/searchOdsConsumeOrderAmount", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchExportAmount(OdsConsumeOrderDTO dto) {
		String result = "success";
		Long exportAmount = odsConsumeOrderServiceClient.getExportAmount(dto);
		if (exportAmount > 25000) {
			result = "The amount of data you exported is too large, please narrowing the query range!";
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
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
	@RequestMapping(value = "/consume/updateCostCenter", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String updateCostCenter(HttpServletRequest request, String msg, OdsConsumeOrderDTO dto) {
		dto.setModifyBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		dto.setModifyDate(new Date());
		int result = odsConsumeOrderServiceClient.updateCostCenter(dto);
		logger.info("update consume Order "+result+" data!");
		return "success";
	}
	
	/**
	 * @title: exportOdsConsumeOrder
	 * @description: 导出Excel
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午4:35:14 
	 * @return: String
	 */
	@RequestMapping(value = "/consume/exportOdsConsumeOrder", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	public void exportOdsConsumeOrder(HttpServletRequest request,HttpServletResponse response,OdsConsumeOrderDTO dto) {

		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("ConsumeOrderInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		List<OdsConsumeOrderDTO> resultList = odsConsumeOrderServiceClient.getOdsConsumeOrderByList(dto);
		ExcelExportTemplate<OdsConsumeOrderDTO> templet = new ExportOdsConsumeOrderTemplet(resultList);
		try {
			templet.doExport(response.getOutputStream(), dto == null ? new OdsConsumeOrderDTO() : dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

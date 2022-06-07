package com.haier.wms.controller.sto;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
import com.haier.openplatform.wms.util.MyAnnotation;
import com.haier.openplatform.wms.util.ValidateResult;
import com.haier.wms.exceltemplate.sto.ExportStgStodnDownListTemplet;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.common.utils.JsonMapper;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StgStodnDownController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月15日 下午1:04:58
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月15日		LJZ			v1.0.0			create
 */

@Controller
public class StgStodnDownController {

	private static final Logger logger = Logger.getLogger(StgStodnDownController.class);

	@Resource
	private StgStodnDownServiceClient stgStodnDownServiceClient;

	public void setStgStodnDownServiceClient(StgStodnDownServiceClient stgStodnDownServiceClient) {
		this.stgStodnDownServiceClient = stgStodnDownServiceClient;
	}

	@RequestMapping(value = "/sto/searchStodn", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getlist(StgStodnDownDTO stoDnDown, Long page, Long rows) {
		Pager<StgStodnDownDTO> pager = stgStodnDownServiceClient.searchStgStodnDowns(page, rows, stoDnDown);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	@RequestMapping(value = "/sto/searchStgStodnDownAmount", method = RequestMethod.POST, 
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchAmount(StgStodnDownDTO dto) {
		String result = "success";
		Long size = stgStodnDownServiceClient.getExportAmount(dto);
		if (size > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	@RequestMapping(value = "/sto/exportStgStodnDownExcel", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportExcel(HttpServletRequest request,HttpServletResponse response,StgStodnDownDTO dto) {
		String flag = "success";

		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StoDnDown");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
        
		List<StgStodnDownDTO> list = stgStodnDownServiceClient.getStgStodnDownListByParm(dto);
		ExcelExportTemplate<StgStodnDownDTO> listTemplet = new ExportStgStodnDownListTemplet(list);
		try {
			listTemplet.doExport(response.getOutputStream(), dto == null ? new StgStodnDownDTO() : dto);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "failture";
			return flag;
		}
		return null;
	}
	
	@RequestMapping(value = "/sto/downloadStodn",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String downloadStodn(HttpServletRequest request,HttpServletResponse response,String stoNo, String stodnNo){
		stoNo = HevUtil.orderNoFormat(stoNo);
		stodnNo = HevUtil.orderNoFormat(stodnNo);
    	String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		InterfaceOutDTO result = stgStodnDownServiceClient.downloadStodn(stoNo, stodnNo, userName);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

	/**
	 * STODN 过账
	 * @param orderNo
	 * @param orderType
	 * @return
	 */
	@RequestMapping(value = "/stodn/postStodn", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String postOrder(String orderNo, String orderType) {
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		OrderIgpOutDTO result = stgStodnDownServiceClient.postStodn(orderNo, orderType, userName);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**
	 * STODN 手持过账
	 * @param stgStoDnDTO
	 * @return
	 */
	@RequestMapping(value = "/pdaStodn/stodnGiGr", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String stodnGiGr(StgStoDnDTO stgStoDnDTO) {
//		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		OrderIgpOutDTO result = stgStodnDownServiceClient.stodnGiGr(stgStoDnDTO);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**
	 * TMS STODN 推送
	 * @param request
	 * @param response
	 * @param stgStoDnDTO
	 * @return
	 */
	@RequestMapping(value = "/rf/downloadStodn",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String downloadStodnFromTMS(HttpServletRequest request, HttpServletResponse response, StgStoDnDTO stgStoDnDTO){
		logger.info("TMS PUSH STODN:" + stgStoDnDTO.toString());
		InterfaceOutDTO result = new InterfaceOutDTO();
		List<ValidateResult> validate = MyAnnotation.validate(stgStoDnDTO);
		for (ValidateResult va : validate) {
			if (!va.isValid()) {
				result.setStatus("E");
				result.setMsg(va.getMessage());
				return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
			}
		}
		result = stgStodnDownServiceClient.downloadStodnFromTMS(stgStoDnDTO);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}


	/**
	 * STODN 分页查询
	 * @param request
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/stodn/search", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String selectStgStoDn(HttpServletRequest request, Long page,
								 Long rows, StgStoDnDTO dto) {
//		String userType = SessionConstants.getSession().getString("user_duty_type");
//		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
//		dto.setUserType(userType);
//		dto.setUserId(userId);
		PageBean bean = null;
		Pager<StgStoDnDTO> pager = new Pager<StgStoDnDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = stgStodnDownServiceClient.searchStgStoDn(pager, dto);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

	/**
	 * STODN 扫描详情分页查询
	 * @param request
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/stodn/searchScanDetail", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String selectStoDnScanDetail(HttpServletRequest request, Long page,
								 Long rows, StgStoDnDTO dto) {
//		String userType = SessionConstants.getSession().getString("user_duty_type");
//		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
//		dto.setUserType(userType);
//		dto.setUserId(userId);
		PageBean bean = null;
		Pager<StgStoDnDTO> pager = new Pager<StgStoDnDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = stgStodnDownServiceClient.searchScanDetail(pager, dto);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

	/**
	 * STODN 过账信息分页查询
	 * @param request
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/stodn/searchPoatDetail", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String selectStoDnPost(HttpServletRequest request, Long page,
								 Long rows, StgStoDnDTO dto) {
//		String userType = SessionConstants.getSession().getString("user_duty_type");
//		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
//		dto.setUserType(userType);
//		dto.setUserId(userId);
		PageBean bean = null;
		Pager<StgStoDnDTO> pager = new Pager<StgStoDnDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = stgStodnDownServiceClient.searchPostDetail(pager, dto);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

	/**
	 * stodn物料信息检查获取
	 * @return
	 */
	@RequestMapping(value = "/pdaStodn/checkStoDnNo",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String checkStoDnNo(String username, String sign, String orderNo,
							   String orderType, String docType, String version){
//		InterfaceOutDTO result = new InterfaceOutDTO();
		InterfaceOutDTO result = stgStodnDownServiceClient.checkStoDnNo(orderNo);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**
	 * @Title: getlist   直接派遣页面查询
	 * @Description: TODO(查询stgstodn 分页)
	 * @param stoDnDown
	 * @param page
	 * @param rows
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/order/searchStoDnFromFactory", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchStoDnFromFactory(StgStodnDownDTO stoDnDown, Long page, Long rows) {
//		String userType = SessionConstants.getSession().getString("user_duty_type");
//		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
//		stoDnDown.setUserType(userType);
//		stoDnDown.setUserId(userId);
		Pager<StgStodnDownDTO> pager = new Pager<StgStodnDownDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = stgStodnDownServiceClient.searchStgStoDnDownsFromFactory(pager, stoDnDown);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
}

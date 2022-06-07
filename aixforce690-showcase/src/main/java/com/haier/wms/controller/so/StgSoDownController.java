package com.haier.wms.controller.so;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.service.StgDnDownServiceClient;
import com.haier.wms.exceltemplate.so.ExportStgDnDownListTemplet;
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
 * @className: StgDnDownController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月18日 下午4:02:57
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月18日		LJZ			v1.0.0			create
 */

@Controller
public class StgSoDownController {
    private Logger logger = Logger.getLogger(StgSoDownController.class);

	@Resource
	private StgDnDownServiceClient stgDnDownService;

    public void setStgDnDownService(StgDnDownServiceClient stgDnDownService) {
        this.stgDnDownService = stgDnDownService;
    }

    /**
    * @Title: selectDnDowns 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param request
    * @param @param page
    * @param @param rows
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/searchDnDownByPage", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectDnDowns(HttpServletRequest request, Long page,
            Long rows, StgDnDownDTO dto) {
        String userType = SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        
        logger.debug("************* userType = " + userType + ", userId = " + userId);
        dto.setUserType(userType);
        dto.setUserId(userId);
        PageBean bean = null;
        Pager<StgDnDownDTO> pager = new Pager<StgDnDownDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = stgDnDownService.searchStgDnDown(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }

    /** 
    * @Title: searchStgDnDownAmount 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param request
    * @param @param response
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/searchStgDnDownAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStgDnDownAmount(HttpServletRequest request,
          HttpServletResponse response,StgDnDownDTO dto){
    	String result = "success";
    	//查询导出的数据总量是多少
    	Long exportAmount = stgDnDownService.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
        
    /** 
    * @Title: exportStgDnDown 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param request
    * @param @param response
    * @param @param stgDnDown
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/exportStgDnDown", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportStgDnDown(HttpServletRequest request,HttpServletResponse response,StgDnDownDTO stgDnDown) {
		String flag = "success";
		
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("SoInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
		
		List<StgDnDownDTO> temp = stgDnDownService.getStgDnDownsByParam(stgDnDown);
		ExcelExportTemplate<StgDnDownDTO> exportDnListTemplet = new ExportStgDnDownListTemplet(temp);
		try {
			exportDnListTemplet.doExport(response.getOutputStream(),stgDnDown == null ? new StgDnDownDTO() : stgDnDown);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "failures";
			return flag;
		}
		return null;
	}
    
    /** 
    * @Title: downloadSo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dnNo
    * @param @param begin
    * @param @param end
    * @param @return
    * @param @throws Exception    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/downloadSo", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String downloadSo(String dnNo, String begin, String end) throws Exception {
    	dnNo = HevUtil.orderNoFormat(dnNo);
        String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
        InterfaceOutDTO result = stgDnDownService.downStgDnDown(dnNo, begin, end, userName);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /** 
    * @Title: postDn 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param orderNo
    * @param @param orderType
    * @param @param sapFlag
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/postDn", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String postDn(String orderNo,String orderType,String sapFlag) {
    	String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
        InterfaceOutDTO result = stgDnDownService.postDn(orderNo, orderType, sapFlag, userName);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /** 
    * @Title: postGiftDn 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param orderNo
    * @param @param orderType
    * @param @param sapFlag
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/postGiftDn", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String postGiftDn(String orderNo,String orderType,String sapFlag) {
    	String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
        InterfaceOutDTO result = stgDnDownService.postGiftDn(orderNo, orderType, sapFlag, userName);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
	/** 
	* @Title: inoutWarehouse 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param request
	* @param @param response
	* @param @param orderNo
	* @param @param orderType
	* @param @param docType
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "/so/inoutWarehouse",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String inoutWarehouse(HttpServletRequest request, HttpServletResponse response, String orderNo, String orderType, String docType){
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		return stgDnDownService.inoutWarehousePo(orderNo, orderType, userName);
	}
	
	/** 
	* @Title: giftInoutWarehouse 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param request
	* @param @param response
	* @param @param orderNo
	* @param @param orderType
	* @param @param docType
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "/so/giftInoutWarehouse",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftInoutWarehouse(HttpServletRequest request, HttpServletResponse response, String orderNo, String orderType, String docType){
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		return stgDnDownService.giftInoutWarehousePo(orderNo, orderType, userName);
	}
	
    /** 
    * @Title: searchDnReverse 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param request
    * @param @param page
    * @param @param rows
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/searchDnReverse", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchDnReverse(HttpServletRequest request, Long page,
            Long rows, StgDnDownDTO dto) {
        String userType = SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);

        logger.debug("************* userType = " + userType + ", userId = " + userId);
        dto.setUserType(userType);
        dto.setUserId(userId);
        PageBean bean = null;
        Pager<StgDnDownDTO> pager = new Pager<StgDnDownDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = stgDnDownService.searchStgDnReverse(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }

    /** 
    * @Title: dnReverse 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param request
    * @param @param page
    * @param @param rows
    * @param @param dto
    * @param @param inpara
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/so/dnReverse", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String dnReverse(HttpServletRequest request, Long page,Long rows, StgDnDownDTO dto,OrderIgpInDTO inpara) {
        String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
        inpara.setUser(userName);
        OrderIgpOutDTO outResult = stgDnDownService.dnReverse(inpara);
        if("0".equals(outResult.getStatus())){
            return "S";
        } else {
          return outResult.getMsg();
        }
    }
}

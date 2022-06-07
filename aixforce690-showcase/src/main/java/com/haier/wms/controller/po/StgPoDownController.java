package com.haier.wms.controller.po;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.po.service.StgPoDownServiceClient;
import com.haier.wms.exceltemplate.po.ExportStgPoDownListTemplet;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

import io.terminus.common.utils.JsonMapper;

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
 * @ClassName: StgPoDownController
 * @Description: PO订单的请求分发
 * 
 */
@Controller
public class StgPoDownController{

	private static final String EX_FILE_NAME = "PO_Info.xlsx";
	
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
	private StgPoDownServiceClient stgPoDownService;
	
	/**  
     * @Description: (stgPoDownService的get方法)  
     * @return stgPoDownService
     */ 
	public StgPoDownServiceClient getStgPoDownService() {
		return stgPoDownService;
	}
	/**  
     * @Description: (stgPoDownService的set方法)  
     * @param stgPoDownService
     */ 
	public void setStgPoDownService(StgPoDownServiceClient stgPoDownService) {
		this.stgPoDownService = stgPoDownService;
	}
	
	/**
     * @Title: createMaterialInfo
     * @Description: 添加PO订单请求 
     * @param @param dto
     * @param @return
     * @return JSONObject
     * @throws
     */
    @RequestMapping(value = "/order/savePo", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String createMaterialInfo(StgPoDownDTO dto) {
        String flag = stgPoDownService.createStgPoDown(dto);
        return flag;
    }
    
    /**
     * @Title: selectStgPo
     * @Description: PO订单查询请求 
     * @param @param request
     * @param @param page
     * @param @param rows
     * @param @param dto
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/po/searchPoInfo", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStgPoDowns(HttpServletRequest request, Long page,
            Long rows, StgPoDownDTO dto) {
        String userType = SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserType(userType);
        dto.setUserId(userId);
        PageBean bean = null;
        Pager<StgPoDownDTO> pager = new Pager<StgPoDownDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = stgPoDownService.searchStgPoDown(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchStgPoDownAmount  
     * @Description: (PO订单查询数量)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/order/searchStgPoDownAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStgPoDownAmount(HttpServletRequest request,
          HttpServletResponse response,StgPoDownDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stgPoDownService.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: exportStgPoDown  
     * @Description: (po detail页面导出)  
     * @param request
     * @param response
     * @param stgPoDown
     * @return
     * @throws Exception
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/po/exportPoInfo", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String exportStgPoDown(HttpServletRequest request,HttpServletResponse response,StgPoDownDTO stgPoDown)throws Exception{
    	
    	response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("PoInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
        
		List<StgPoDownDTO> temp=stgPoDownService.getStgPoDownByParam(stgPoDown);
		String flag="success";
		ExcelExportTemplate<StgPoDownDTO> exportStgPoDownListTemplet= new ExportStgPoDownListTemplet(temp);
		try {
			exportStgPoDownListTemplet.doExport(response.getOutputStream(), stgPoDown==null ?new StgPoDownDTO(): stgPoDown);
		} catch (Exception e) {
			e.printStackTrace();
            flag = "failture";
            return flag;
		} 
		return null;
	}
    
    /*
     * 从SAP下载
     */
    @RequestMapping(value = "/po/downloadPo", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String downloadPo(String poNo, String beginTime, String endTime) throws Exception{
    	poNo = HevUtil.orderNoFormat(poNo);
        String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
    	String resultString = stgPoDownService.downloadPo(poNo, beginTime, endTime, userName);
    	return resultString;
    }
    
	@RequestMapping(value = "/po/postPo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String postOrder(String orderNo,String orderType, String returnType, String sapFlag) throws Exception {
		String userName = SessionConstants.getSession().getString(
				SessionSecurityConstants.KEY_USER_NAME);
		String sap = stgPoDownService.postPo(orderNo, orderType, returnType, sapFlag, userName);
		return sap;
	}
	
	@RequestMapping(value = "/po/postGiftPo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String postGiftOrder(String orderNo,String orderType, String sapFlag) throws Exception {
		String userName = SessionConstants.getSession().getString(
				SessionSecurityConstants.KEY_USER_NAME);
		String sap = stgPoDownService.postGiftPo(orderNo, orderType, sapFlag, userName);
		return sap;
	}
	
	@RequestMapping(value = "/po/inoutWarehouse",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String inoutWarehouse(HttpServletRequest request,HttpServletResponse response,String orderNo, String orderType, String docType){
		
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		
		return stgPoDownService.inoutWarehousePo(orderNo, orderType, userName);

	}
	
	@RequestMapping(value = "/po/giftInoutWarehouse",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftInoutWarehouse(HttpServletRequest request,HttpServletResponse response,String orderNo, String orderType, String docType){
		
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		
		return stgPoDownService.giftInoutWarehousePo(orderNo, orderType, userName);

	}
}

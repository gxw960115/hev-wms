package com.haier.wms.controller.sto;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.haier.openplatform.wms.sto.service.StgStoDownServiceClient;
import com.haier.wms.exceltemplate.sto.ExportStgStoDownListTemplet;
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
 * @ClassName: StgStoDownController  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2015-4-20  
 */ 
@Controller
public class StgStoDownController {
    private static final String EX_FILE_NAME = "STO_Info.xlsx";

	@Resource
	private StgStoDownServiceClient stgStoDownServiceClient;

	public void setStgStoDownServiceClient(StgStoDownServiceClient stgStoDownServiceClient) {
		this.stgStoDownServiceClient = stgStoDownServiceClient;
	}

	public StgStoDownServiceClient getStgStoDownServiceClient() {
        return stgStoDownServiceClient;
    }
    
    /**  
     * @Title: selectStgStoDowns  
     * @Description: (获取所有的sto订单)  
     * @param request
     * @param page
     * @param rows
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/sto/searchSto", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStgStoDowns(HttpServletRequest request, Long page,
            Long rows, StgStoDownDTO dto) {
        String userType = SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserType(userType);
        dto.setUserId(userId);
        PageBean bean = null;
        Pager<StgStoDownDTO> pager = new Pager<StgStoDownDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = stgStoDownServiceClient.searchStgStoDown(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchList  
	 * @Description: (获取所有的sto订单)  
	 * @param stgStoDown
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchStoList", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchList(StgStoDownDTO stgStoDown) throws Exception {
		List<StgStoDownDTO> rows = stgStoDownServiceClient.getStgStoDowns(stgStoDown);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
	}
	
	/**  
	 * @Title: searchStgStoDownAmount  
	 * @Description: (获取所有的sto订单数量)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchStgStoDownAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStgStoDownAmount(HttpServletRequest request,
          HttpServletResponse response,StgStoDownDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stgStoDownServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
	
	/**  
	 * @Title: exportStgStoDown  
	 * @Description: (导出sto订单)  
	 * @param request
	 * @param response
	 * @param stgStoDown
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/exportStgStoDown",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportStgStoDown(HttpServletRequest request,HttpServletResponse response,StgStoDownDTO stgStoDown)throws Exception{
		
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StoInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
        
		
		String flag="success";
		List<StgStoDownDTO> temp=stgStoDownServiceClient.getStgStoDowns(stgStoDown);
		ExcelExportTemplate<StgStoDownDTO> exportStgStoDownListTemplet= new ExportStgStoDownListTemplet(temp);
		try {
			exportStgStoDownListTemplet.doExport(response.getOutputStream(), stgStoDown==null ? new StgStoDownDTO(): stgStoDown);
		} catch (Exception e) {
			e.printStackTrace();
            flag = "failture";
            return flag;
		} 
		return null;
	}
	
	/**  
	 * @Title: searchStgStoDownAmount  
	 * @Description: (获取所有的sto订单数量)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/sto/downloadSto",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String downloadSto(HttpServletRequest request,HttpServletResponse response,
    		String stoNo, String beginTime, String endTime){
		stoNo = HevUtil.orderNoFormat(stoNo);
    	String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		InterfaceOutDTO result = stgStoDownServiceClient.downloadSto(stoNo, beginTime, endTime, userName);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

	@RequestMapping(value = "/sto/postSto", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String postOrder(String orderNo,String stodnNo, String orderType, String sapFlag) {
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
		OrderIgpOutDTO result = stgStoDownServiceClient.postSto(orderNo, stodnNo, orderType, sapFlag, userName);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
}

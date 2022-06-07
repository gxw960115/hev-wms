package com.haier.wms.controller.order;

import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.openplatform.wms.order.service.StgInboundDownServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

@Controller
public class StgInboundDownController {
	@Resource
	private StgInboundDownServiceClient stgInboundDownService;
	private static final String EX_FILE_NAME = "Inbound_Order_Info.xlsx";
	
	/**  
	 * @Title: searchStgInboundDowns  
	 * @Description: (查询INBOUND采购下载)  
	 * @param request
	 * @param response
	 * @param stgInboundDown
	 * @param page
	 * @param rows
	 * @throws Exception
	 * @return String 
	 */  
	@RequestMapping(value="/order/searchStgInboundDown",method=RequestMethod.POST,produces=MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchStgInboundDowns(HttpServletRequest request,
			HttpServletResponse response, StgInboundDownDTO stgInboundDown,
			Long page, Long rows) throws Exception {
		String userType = SessionConstants.getSession().getString("user_duty_type");
		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
	    stgInboundDown.setUserType(userType);
		stgInboundDown.setUserId(userId);
		Pager<StgInboundDownDTO> pager = new Pager<StgInboundDownDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = stgInboundDownService.searchStgInboundDowns(pager,
				stgInboundDown);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchStgInboundDownAmount  
	 * @Description: (查询数量)  
	 * @param request
	 * @param response
	 * @param dto
	 * @return String 
	 */  
	@RequestMapping(value = "/order/searchStgInboundDownAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStgInboundDownAmount(HttpServletRequest request,
          HttpServletResponse response,StgInboundDownDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stgInboundDownService.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
	
	
	public StgInboundDownServiceClient getStgInboundDownService() {
		return stgInboundDownService;
	}
	public void setStgInboundDownService(
			StgInboundDownServiceClient stgInboundDownService) {
		this.stgInboundDownService = stgInboundDownService;
	}

}

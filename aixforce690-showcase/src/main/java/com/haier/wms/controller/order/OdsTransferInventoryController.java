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
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;
import com.haier.openplatform.wms.order.service.TransferInventoryServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

@Controller
public class OdsTransferInventoryController {
    /**  
     * @Fields field:field:{}(dubbo接口)  
     */  
    @Resource
    public TransferInventoryServiceClient transferInventoryServiceClient;// dubbo暴漏出来的接口
    
    /**  
     * @Title: searchTransInventoryOrder  
     * @Description: (查询)  
     * @param request
     * @param odsTransferInventoryDTO
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/searchTransInventoryOrder/list",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchTransInventoryOrder(HttpServletRequest request,
    		OdsTransferInventoryDTO odsTransferInventoryDTO) {
    	String userType =SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));
        odsTransferInventoryDTO.setUserType(userType);
        odsTransferInventoryDTO.setUserId(userId);

        PageBean bean = null;
        Pager<OdsTransferInventoryDTO> outpager = transferInventoryServiceClient
        		.searchTransInventoryOrder(page, rows, odsTransferInventoryDTO);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchTransInventoryOrderAmount  
     * @Description: (查询数量)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/order/searchTransInventoryOrderAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchTransInventoryOrderAmount(HttpServletRequest request,
          HttpServletResponse response,OdsTransferInventoryDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = transferInventoryServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**   
	 * @Description: (transferInventoryServiceClient的get方法)  
	 * @return transferInventoryServiceClient
	 */ 
	public TransferInventoryServiceClient getTransferInventoryServiceClient() {
		return transferInventoryServiceClient;
	}
	/**   
	 * @Description: (transferInventoryServiceClient的set方法)  
	 * @param transferInventoryServiceClient
	 */ 
	public void setTransferInventoryServiceClient(
			TransferInventoryServiceClient transferInventoryServiceClient) {
		this.transferInventoryServiceClient = transferInventoryServiceClient;
	}
    
}

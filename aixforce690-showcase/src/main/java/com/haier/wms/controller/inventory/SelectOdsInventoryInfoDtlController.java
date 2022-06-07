package com.haier.wms.controller.inventory;

import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

@Controller
public class SelectOdsInventoryInfoDtlController {
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
	private OdsInventoryInfoDtlServiceClient odsInventoryInfoDtlServiceClient;

	/**
	 * 增加库存
	 * @param dto 参数
	 * @return result
	 */
	@RequestMapping(value = "/inventory/addInventory", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addInventory(OdsInventoryInfoDtlDTO dto) {
		String[] arr = {""};
		arr[0] = odsInventoryInfoDtlServiceClient.addInventory(dto);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(arr);
	}

	/**
	 *
	 * @param barcode 条码
	 * @return 返回值
	 */
	@RequestMapping(value = "/inventory/deleteInventory", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteInventory(String barcode) {
		String[] arr = {""};
		if (barcode == null || barcode.length() != 20) {
			arr[0] = "Please enter the correct barcode!";
			return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(arr);
		}
		String result = odsInventoryInfoDtlServiceClient.deleteInventory(barcode);
		arr[0] = result;
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(arr);
	}
	/**  
	 * @Title: searchOdsInventoryInfoDtl  
	 * @Description: 查询
	 * @param request
	 * @param page
	 * @param rows
	 * @param odsInventoryInfoDtlDTO
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/inventory/searchOdsInventoryInfoDtl", 
						method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOdsInventoryInfoDtl(HttpServletRequest request,
			Long page, Long rows, OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
	    String userType=SessionConstants.getSession().getString("user_duty_type");
	    odsInventoryInfoDtlDTO.setUserType(userType);
		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
		odsInventoryInfoDtlDTO.setUserId(userId);
		Pager<OdsInventoryInfoDtlDTO> pager = odsInventoryInfoDtlServiceClient
				.searchOdsInventoryInfoDtlDTOs(page,rows, odsInventoryInfoDtlDTO);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	
	/**  
	 * @Title: setOdsInventoryInfoDtlClient  
	 * @Description: (odsInventoryInfoDtlServiceClient的set方法)  
	 * @param odsInventoryInfoDtlServiceClient
	 */  
	public void setOdsInventoryInfoDtlClient(
			OdsInventoryInfoDtlServiceClient odsInventoryInfoDtlServiceClient) {
		this.odsInventoryInfoDtlServiceClient = odsInventoryInfoDtlServiceClient;
	}
	
	
	
}

package com.haier.wms.controller.order;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.openplatform.wms.order.service.StgInboundDownServiceClient;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.service.StgDnDownServiceClient;
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

@Controller
public class StgDnDownController {


	@Resource
	private StgDnDownServiceClient stgDnDownService;
	/** 直接派遣 调度按钮查询
	 * @param request
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/order/searchDirectDispatchDn", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchDirectDispatchDn(HttpServletRequest request, Long page,
										 Long rows, StgDnDownDTO dto) {
		String userType =SessionConstants.getSession().getString("user_duty_type");
		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);

		dto.setUserType(userType);
		dto.setUserId(userId);
		PageBean bean = null;
		Pager<StgDnDownDTO> pager = new Pager<StgDnDownDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = stgDnDownService.searchDirectDispatchDn(pager, dto);
		bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);

	}

}

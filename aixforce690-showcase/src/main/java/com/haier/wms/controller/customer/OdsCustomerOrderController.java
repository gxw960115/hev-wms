package com.haier.wms.controller.customer;

import com.alibaba.fastjson.JSON;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.customer.service.OdsCustomerOrderServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.wms.exceltemplate.customer.ExportCustomerOrderTemplate;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: OdsCustomerOrderController.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date: 2018年11月11日
 * @version V1.0
 */
@Controller
public class OdsCustomerOrderController {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */
	private static Logger log = LoggerFactory.getLogger(OdsCustomerOrderController.class);

	/**
	 * @Fields field:field:{todo}(dubbo接口)
	 */
	@Resource
	private OdsCustomerOrderServiceClient odsCustomerOrderServiceClient;

	public void setOdsCustomerOrderServiceClient(OdsCustomerOrderServiceClient odsCustomerOrderServiceClient) {
		this.odsCustomerOrderServiceClient = odsCustomerOrderServiceClient;
	}

	/**
	 * @Title: searchCustomerOrder 
	 * @Description: TODO(查询用户订单列表) 
	 * @author zhangll 
	 * @param request 
	 * @param odsCustomerOrderDTO 
	 * @return String 
	 * @throws
	 */
	@RequestMapping(value = "/odsCustomerOrder/list", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchCustomerOrder(HttpServletRequest request, OdsCustomerOrderDTO odsCustomerOrderDTO) {

		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));

		PageBean bean = null;
		Pager<OdsCustomerOrderDTO> outpager = odsCustomerOrderServiceClient.searchOdsCustomerOrders(page, rows,
				odsCustomerOrderDTO);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

	/**  
	* @Title: addCustomerOrder  
	* @Description: TODO(保存用户订单)  
	* @author zhangll
	* @param odsCustomerOrderDTO
	* @param msg
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/add",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addCustomerOrder(OdsCustomerOrderDTO odsCustomerOrderDTO,String msg) {
		//处理前台接收的信息
		BaseUser user = UserUtil.getCurrentUser();
		String userName = "";
        try {
            userName = user.getName();
        } catch (Exception e) {
            return "Cant't get user name,please login again!";
        }
        odsCustomerOrderDTO.setCreateBy(userName);
        List<OdsCustomerOrderDTO> list = JSON.parseArray(msg, OdsCustomerOrderDTO.class);
		String flag = odsCustomerOrderServiceClient.addCustomerOrderInfo(odsCustomerOrderDTO, list);
		return flag;
	}
	
	/**  
	* @Title: getCustomerOrderNo  
	* @Description: TODO(获取订单号)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/sequenceNo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getCustomerOrderNo() {
		String orderNo = odsCustomerOrderServiceClient.getCustomerOrderNo();
		return "K" + orderNo;
	}

	/**  
	* @Title: deleteCustomerOrderByCusNo  
	* @Description: TODO(删除订单)  
	* @author zhangll
	* @param odsCustomerOrderDTO
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/deleteByCusNo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteCustomerOrderByCusNo(OdsCustomerOrderDTO odsCustomerOrderDTO) {
		BaseUser user = UserUtil.getCurrentUser();
		if (user == null) {
			return "Update failed,Can't get The login User,Please login again";
		}
		if (odsCustomerOrderDTO.getCreateBy().equalsIgnoreCase(user.getName())) {
			String result = odsCustomerOrderServiceClient
					.deleteCustomerOrderByCusNo(odsCustomerOrderDTO.getCtrOrderNo());
			if ("success".equals(result)) {
				return "success";
			}
			return "error!";
		} else {
			return "You can't delete, because this order isn't created by you!";
		}
	}

	/**  
	* @Title: deleteCustomerOrderByIds  
	* @Description: TODO(删除订单)  
	* @author zhangll
	* @param rowIds
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/deleteByIds", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteCustomerOrderByIds(String rowIds) {
		BaseUser user = UserUtil.getCurrentUser();
		if (user == null) {
			return "Update failed,Can't get The login User,Please login again";
		}
		if (rowIds == null || rowIds.length() < 1) {
			return "Plaese select datas!";
		}
		String[] ids = rowIds.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			idList.add(Long.parseLong(id));
		}

		String result = odsCustomerOrderServiceClient.deleteCustomerOrderByIds(idList);
		if ("success".equals(result)) {
			return "success delete";
		}
		return "error!";
	}

	
	/**  
	* @Title: searchCustomerOrdersAmount  
	* @Description: TODO(统计数量)  
	* @author zhangll
	* @param request
	* @param response
	* @param dto
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/searchAmount", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchCustomerOrdersAmount(HttpServletRequest request, HttpServletResponse response,
			OdsCustomerOrderDTO dto) {
		String result = "success";

		// 查询导出的数据总量是多少
		Long exportAmount = odsCustomerOrderServiceClient.searchOdsCustomerOrdersCount(dto);
		if (exportAmount > 25000) {
			result = "The amount of data you exported is too large, please narrowing the query range!";
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**  
	* @Title: exportExcel  
	* @Description: TODO(导出)  
	* @author zhangll
	* @param odsCustomerOrderDTO
	* @param request
	* @param response
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/export", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportExcel(OdsCustomerOrderDTO odsCustomerOrderDTO, HttpServletRequest request,HttpServletResponse response) {
		
		String result = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		StringBuffer fileNameBuffer = new StringBuffer();
		fileNameBuffer.append("CustomerOrder");
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		fileNameBuffer.append(fmtDate.format(new Date()));
		fileNameBuffer.append(".xlsx");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		try {
			Pager<OdsCustomerOrderDTO> temp = odsCustomerOrderServiceClient.searchOdsCustomerOrders(1, 25000,odsCustomerOrderDTO);
			ExportCustomerOrderTemplate template = new ExportCustomerOrderTemplate(temp.getRecords());
			template.doExport(response.getOutputStream(), odsCustomerOrderDTO);
		} catch (Exception e) {
			result = "false";
		}
		return null;
	}
	
	/**  
	* @Title: customerApprove  
	* @Description: 审批
	* @author: ZhangLL
	* @param cusNo
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/customerApprove",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String customerApprove(String cusNo) {
		BaseUser user = UserUtil.getCurrentUser();
		if (user == null){
			return "Update failed,Can't get The login User,Please login again";
		}
		String result = odsCustomerOrderServiceClient.customerApprove(cusNo,user.getName());
		if("success".equals(result)) {
			return "success";
		}
		return "error!";
	}
	
	/**  
	* @Title: orderCheck  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param username
	* @param sign
	* @param orderNo
	* @param doctype 订单类型CUSTOMER
	* @param orderType 出入库类型 1-入库 2-出库
	* @param version
	* @param dnType
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerOrder/orderCheck", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderCheck(String username,String sign,String orderNo,String doctype,String orderType,String version,String dnType){
	    
		orderNo = HevUtil.orderNoFormat(orderNo); 
	    
	    log.debug("Entering orderCheck with user: " + username + ", sign: " + sign + ", orderNo: " + orderNo + ", doctype: " + doctype + ", orderType: " + orderType);

	    OrderCheckInDTO inpara = new OrderCheckInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setDnType(dnType);
		OrderCheckOutDTO orderResult = odsCustomerOrderServiceClient.orderCheck(inpara,version);
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		
		log.debug("Exit orderCheck with result: " + result);
		return result;
	}
	
    /** 
    * @Title: printDetail 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param request
    * @param @param response
    * @param @param barcodes
    * @param @param dnNo
    * @param @param orderNo
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年9月17日
    * @return String    返回类型 
    * @throws 
    */
    @RequestMapping(value = "/odsCustomerOrder/printDetail")
    @ResponseBody
    public String printDetail(HttpServletRequest request,HttpServletResponse response,String barcodes,String dnNo, String orderNo){
    	Map<String,Object> parameters = new HashMap<String,Object>(8);

		String basicPath = request.getSession().getServletContext().getRealPath("/");
		BaseUser user = UserUtil.getCurrentUser();
		parameters.put("orderNo", "'"+orderNo+"'");
		parameters.put("modifyBy", user.getName());
		parameters.put("logo", basicPath+"/pdf/aqua.png");

		String path = basicPath + "/pdf/customerDetail.jasper";
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);

    	try {
    		ServletOutputStream outStream =	response.getOutputStream();
			byte[] bytes = odsCustomerOrderServiceClient.printDetail(reportFile.getPath(), parameters);
			response.setContentType("application/pdf");
			if (bytes != null) {
				response.setContentLength(bytes.length);
				outStream.write(bytes, 0, bytes.length);
			}
	        outStream.flush();
	        outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
	
}

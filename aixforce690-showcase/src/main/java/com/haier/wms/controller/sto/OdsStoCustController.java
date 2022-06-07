package com.haier.wms.controller.sto;


import com.alibaba.fastjson.JSON;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoCustScanInfoServiceClient;
import com.haier.openplatform.wms.sto.service.OdsStoCustServiceClient;
import com.haier.wms.exceltemplate.sto.ExportOdsStoCustScanInfoListTemplet;
import com.haier.wms.exceltemplate.sto.ExportStoCustTemplate;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title: OdsStoCustController.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date: 2018年12月18日
 * @version V1.0
 */
@Controller
public class OdsStoCustController {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */
	private static Logger log = LoggerFactory.getLogger(OdsStoCustController.class);

	/**
	 * @Fields field:field:{todo}(dubbo接口)
	 */
	@Resource
	private OdsStoCustServiceClient odsStoCustServiceClient;
	@Resource
	private OdsStoCustScanInfoServiceClient odsStoCustScanInfoServiceClient;

	public void setOdsStoCustServiceClient(OdsStoCustServiceClient odsStoCustServiceClient) {
		this.odsStoCustServiceClient = odsStoCustServiceClient;
	}

	public void setOdsStoCustScanInfoServiceClient(OdsStoCustScanInfoServiceClient odsStoCustScanInfoServiceClient) {
		this.odsStoCustScanInfoServiceClient = odsStoCustScanInfoServiceClient;
	}
/**********************************************************STO CUST ORDER*******************************************************/

	/**
	 * @Title: searchStoCust 
	 * @Description: TODO(查询用户订单列表) 
	 * @author zhangll 
	 * @param request 
	 * @param odsStoCustDTO 
	 * @return String 
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustInfo/list", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchStoCust(HttpServletRequest request, OdsStoCustDTO odsStoCustDTO) {

		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));

		PageBean bean = null;
		Pager<OdsStoCustDTO> outpager = odsStoCustServiceClient.searchOdsStoCusts(page,rows,odsStoCustDTO);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

	/**  
	* @Title: addStoCust  
	* @Description: TODO(保存用户订单)  
	* @author zhangll
	* @param odsStoCustDTO
	* @param msg
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsStoCustInfo/add",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addStoCust(OdsStoCustDTO odsStoCustDTO,String msg) {
		//处理前台接收的信息
		BaseUser user = UserUtil.getCurrentUser();
		String userName = "";
        try {
            userName = user.getName();
        } catch (Exception e) {
            return "Cant't get user name,please login again!";
        }
        odsStoCustDTO.setCreateBy(userName);
        List<OdsStoCustDTO> list = JSON.parseArray(msg, OdsStoCustDTO.class);
		String flag = odsStoCustServiceClient.addStoCustInfo(odsStoCustDTO, list);
		return flag;
	}
	
	/**  
	* @Title: getStoCustNo  
	* @Description: TODO(获取订单号)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsStoCustInfo/sequenceNo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getStoCustNo() {
		String orderNo = odsStoCustServiceClient.getStoCustNo();
		return "X" + orderNo;
	}

	/**  
	* @Title: deleteStoCustByCusNo  
	* @Description: TODO(删除订单)  
	* @author zhangll
	* @param odsStoCustDTO
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsStoCustInfo/deleteByStoNo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteStoCustByCusNo(OdsStoCustDTO odsStoCustDTO) {
		BaseUser user = UserUtil.getCurrentUser();
		if (user == null) {
			return "Update failed,Can't get The login User,Please login again";
		}
		if (odsStoCustDTO.getCreateBy().equalsIgnoreCase(user.getName())) {
			String result = odsStoCustServiceClient.deleteStoCustByNo(odsStoCustDTO.getStoNo());
			if ("success".equals(result)) {
				return "success";
			}
			return "error!";
		} else {
			return "You can't delete, because this order isn't created by you!";
		}
	}

	/**  
	* @Title: deleteStoCustByIds  
	* @Description: TODO(删除订单)  
	* @author zhangll
	* @param rowIds
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsStoCustInfo/deleteByIds", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteStoCustByIds(String rowIds) {
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

		String result = odsStoCustServiceClient.deleteStoCustByIds(idList);
		if ("success".equals(result)) {
			return "success delete";
		}
		return "error!";
	}

	/**
	* @Title: searchStoCustsAmount  
	* @Description: TODO(统计数量)  
	* @author zhangll
	* @param request
	* @param response
	* @param dto
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsStoCustInfo/searchStoCustInfosAmount", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchStoCustsAmount(HttpServletRequest request, HttpServletResponse response,
			OdsStoCustDTO dto) {
		String result = "success";

		// 查询导出的数据总量是多少
		Long exportAmount = odsStoCustServiceClient.searchOdsStoCustsCount(dto);
		if (exportAmount > 25000) {
			result = "The amount of data you exported is too large, please narrowing the query range!";
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**  
	* @Title: exportExcel  
	* @Description: TODO(导出)  
	* @author zhangll
	* @param odsStoCustDTO
	* @param request
	* @param response
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsStoCustInfo/export", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportExcel(OdsStoCustDTO odsStoCustDTO, HttpServletRequest request,HttpServletResponse response) {
		
		String result = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		StringBuffer fileNameBuffer = new StringBuffer();
		fileNameBuffer.append("OdsStoCustInfo");
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		fileNameBuffer.append(fmtDate.format(new Date()));
		fileNameBuffer.append(".xlsx");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		try {
			Pager<OdsStoCustDTO> temp = odsStoCustServiceClient.searchOdsStoCusts(1, 25000,odsStoCustDTO);
			ExportStoCustTemplate template = new ExportStoCustTemplate(temp.getRecords());
			template.doExport(response.getOutputStream(), odsStoCustDTO);
		} catch (Exception e) {
			result = "false";
		}
		return null;
	}
	
	/**  
	* @Title: customerApprove  
	* @Description: 审批
	* @author: ZhangLL
	* @param stoNo
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsStoCustInfo/stoApprove",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String customerApprove(String stoNo) {
		BaseUser user = UserUtil.getCurrentUser();
		if (user == null){
			return "Update failed,Can't get The login User,Please login again";
		}
		String result = odsStoCustServiceClient.stoApprove(stoNo,user.getName());
		if("success".equals(result)) {
			return "success";
		}
		return "error!";
	}

	/********************************************************** STO CUST SCAN *******************************************************/

	/**
	 * @Title: searchCustomerScanInfo
	 * @Description: TODO(查询列表)
	 * @author zhangll
	 * @param request
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustDtl/list", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchCustomerScanInfo(HttpServletRequest request, OdsStoCustScanInfoDTO dto) {

		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));

		PageBean bean = null;
		Pager<OdsStoCustScanInfoDTO> outpager = odsStoCustScanInfoServiceClient.searchOdsStoCustScanInfoByPage(page,rows,dto);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

	/**
	 * @Title: searchCustomerScanInfosAmount 
	 * @Description: TODO(统计导出数量是否超出25000) 
	 * @author zhangll 
	 * @param request 
	 * @param response 
	 * @param dto 
	 * @return String 
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustDtl/searchAmount", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchCustomerScanInfosAmount(HttpServletRequest request, HttpServletResponse response,OdsStoCustScanInfoDTO dto) {
		String result = "success";

		// 查询导出的数据总量是多少
		Long exportAmount = odsStoCustScanInfoServiceClient.getExportAmount(dto);
		if (exportAmount > 25000) {
			result = "The amount of data you exported is too large, please narrowing the query range!";
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**
	 * @Title: exportExcel
	 * @Description: TODO(导出)
	 * @author zhangll
	 * @param request
	 * @param response
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustDtl/export", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportExcel(OdsStoCustScanInfoDTO dto, HttpServletRequest request, HttpServletResponse response) {
		String result = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		StringBuffer fileNameBuffer = new StringBuffer();
		fileNameBuffer.append("OdsStoCustScanInfo");
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		fileNameBuffer.append(fmtDate.format(new Date()));
		fileNameBuffer.append(".xlsx");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		try {
			Pager<OdsStoCustScanInfoDTO> temp = odsStoCustScanInfoServiceClient.searchOdsStoCustScanInfoByPage(1L,25000L,dto);
			ExportOdsStoCustScanInfoListTemplet template = new ExportOdsStoCustScanInfoListTemplet(temp.getRecords());
			template.doExport(response.getOutputStream(), dto);
		} catch (Exception e) {
			result = "false";
		}
		return null;
	}

	/********************************************************** STO CUST PDA *******************************************************/

	/**
	 * @Title: orderCheck
	 * @Description: 一句话描述这个方法的作用
	 * @author: ZhangLL
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param doctype
	 * @param orderType 出入库类型 1-入库 2-出库
	 * @param version
	 * @param dnType
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustPDA/orderCheck", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
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

		OrderCheckOutDTO orderResult = odsStoCustServiceClient.orderCheck(inpara,version);

		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);

		log.debug("Exit orderCheck with result: " + result);
		return result;
	}

	/**
	 * @Title: orderDelete
	 * @Description: 订单删除(手持)
	 * @author: ZhangLL
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param orderType 出入库类型 1-入库 2-出库
	 * @param version
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustPDA/orderDelete", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		orderNo = HevUtil.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setUser(username);
		//调用dubbo方法执行删除操作
		try {
			outResult = odsStoCustScanInfoServiceClient.orderDelete(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @Title: ordersDelete
	 * @Description: 订单删除(手持)
	 * @author: ZhangLL
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param orderType 出入库类型 1-入库 2-出库
	 * @param version
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustPDA/ordersDelete", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		orderNo = HevUtil.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setUser(username);
		//调用dubbo方法执行删除操作
		try {
			outResult = odsStoCustScanInfoServiceClient.ordersDelete(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @Title: barcodeList
	 * @Description: (获取条码列表)
	 * @param @param username 登录用户
	 * @param @param sign 手持签名
	 * @param @param orderNo 订单号的
	 * @param @param orderType 出入库类型 1-入库 2-出库
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	@RequestMapping(value = "/odsStoCustPDA/barcodeList", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType){

		orderNo = HevUtil.orderNoFormat(orderNo);

		WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();

		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
		//调用dubbo方法获取barcode列表
		WmsOrderDelListOutDTO outResult = odsStoCustScanInfoServiceClient.barcodeList(inpara);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @Title: orderScan
	 * @Description: 扫码
	 * @author: ZhangLL
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param doctype 订单类型CUSTOMER
	 * @param orderType 出入库类型 1-入库 2-出库
	 * @param bin
	 * @param qty
	 * @param version
	 * @param remark
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustPDA/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
							String bin, String qty,String version, String remark){

		orderNo = HevUtil.orderNoFormat(orderNo);

		log.debug("Entering orderScan with user: " + username + ", sign: " + sign + ", orderNo: " + orderNo + ", doctype: " + doctype+ ", orderType: " + orderType + ", bin: " + bin + ", barcode: " + barcode + ", qty: " + qty + ", version: IND," + ",remark:" + remark);
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		OrderUploadInDTO inpara = new OrderUploadInDTO();
		inpara.setUser(username);
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setBin(bin);
		inpara.setVersion("HEV");
		inpara.setRemark(remark);
		//调用后台dubbo方法执行扫描操作
		try {
			outResult = odsStoCustScanInfoServiceClient.orderScan(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @Title: orderOgp
	 * @Description: 出库(手持)
	 * @author: ZhangLL
	 * @param username
	 * @param postDate
	 * @param orderNo
	 * @param version
	 * @param inpara
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsStoCustPDA/orderOgp", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderOgp(String username,String postDate,String orderNo,String version,OrderIgpInDTO inpara){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei
		orderNo = HevUtil.orderNoFormat(orderNo);

		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(username);
		inpara.setVersion("HEV");
		try {
			outResult = odsStoCustServiceClient.orderOgp(inpara, version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		log.debug("Exiting orderIOgp with result: " + result);
		return result;
	}

}

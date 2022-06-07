package com.haier.wms.controller.transfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient;
import com.haier.wms.exceltemplate.transfer.ExportTransferInfoTemplate;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

/**  
 * @Title:  OdsTransferInfo.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:41:42   
 * @version V1.0 
 */  
@Controller
public class OdsTransferInfoController {

	private static Logger log = LoggerFactory.getLogger(OdsTransferInfoController.class);
	
	/**  
	* @Fields field:field:{todo}(dubbo接口)  
	*/
	@Resource
	private OdsTransferInfoServiceClient odsTransferInfoServiceClient;

	public void setOdsTransferInfoServiceClient(OdsTransferInfoServiceClient odsTransferInfoServiceClient) {
		this.odsTransferInfoServiceClient = odsTransferInfoServiceClient;
	}

	/**
	* @Title: searchTransferOrder  
	* @Description: TODO(分页查询)  
	* @author zhangll
	* @param request
	* @param odsTransferInfoDTO
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferInfo/list",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchTransferOrder(HttpServletRequest request,
    		OdsTransferInfoDTO odsTransferInfoDTO) {

		long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));

        PageBean bean = null;
        Pager<OdsTransferInfoDTO> outpager = odsTransferInfoServiceClient.searchOdsTransferInfos(page, rows, odsTransferInfoDTO);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
	
	/**  
	* @Title: getTransferOrderNo  
	* @Description: TODO(获取移库单号)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferInfo/sequenceNo",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getTransferOrderNo() {
        String orderNo = odsTransferInfoServiceClient.getTransferOrderNo();
        return "T" + orderNo;
    }
	
	/**  
	* @Title: addTransferInfo  
	* @Description: TODO(新增移库单)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferInfo/add",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addTransferInfo(OdsTransferInfoDTO odsTransferInfoDTO,String msg) {
		//处理前台接收的信息
		BaseUser user = UserUtil.getCurrentUser();
		String userName = "";
        try {
            userName = user.getName();
        } catch (Exception e) {
            return "Cant't get user name,please login again!";
        }
        odsTransferInfoDTO.setCreateBy(userName);
        List<OdsTransferInfoDTO> list = JSON.parseArray(msg, OdsTransferInfoDTO.class);
		String flag = odsTransferInfoServiceClient.addTranferInfo(odsTransferInfoDTO, list);
		return flag;
	}
	
	/**  
	* @Title: deleteTransferInfo  
	* @Description: TODO(按照transNo删除移库单)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferInfo/deleteByTransNo",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteTransferInfoByTransNo(OdsTransferInfoDTO odsTransferInfoDTO) {
		BaseUser user = UserUtil.getCurrentUser();
    	if (user == null){
    		return "Update failed,Can't get The login User,Please login again";
    	}
    	if(odsTransferInfoDTO.getCreateBy().equalsIgnoreCase(user.getName())){
    		String result = odsTransferInfoServiceClient.deleteTransferInfoByTransNo(odsTransferInfoDTO.getTransNo());
            if("success".equals(result)) {
            	return "success";
            }
            return "error!";
        } else {
        	return "You can't delete, because this order isn't created by you!";
        }
	}
	
	/**  
	 * @Title: deleteTransferInfo  
	 * @Description: TODO(按照transNo删除移库单)  
	 * @author zhangll
	 * @return String
	 * @throws  
	 */
	@RequestMapping(value = "/odsTransferInfo/deleteByIds",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteTransferInfoByIds(String rowIds) {
		BaseUser user = UserUtil.getCurrentUser();
		if (user == null){
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
		
		String result = odsTransferInfoServiceClient.deleteTransferInfoByIds(idList);
		if("success".equals(result)) {
			return "success delete";
		}
		return "error!";
	}
	
	@RequestMapping(value = "/odsTransferInfo/transferApprove",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String transferApprove(String transNo) {
		BaseUser user = UserUtil.getCurrentUser();
		if (user == null){
			return "Update failed,Can't get The login User,Please login again";
		}
		String result = odsTransferInfoServiceClient.transferApprove(transNo,user.getName());
		if("success".equals(result)) {
			return "success";
		}
		return "error!";
	}
	
	/**  
	* @Title: searchTransInventoryOrderAmount  
	* @Description: TODO(查询当前查询条件返回的结果数量)  
	* @author zhangll
	* @param request
	* @param response
	* @param dto
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferInfo/searchTransInfosAmount",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchTransferInfosAmount(HttpServletRequest request,
          HttpServletResponse response,OdsTransferInfoDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = odsTransferInfoServiceClient.searchOdsTransferInfosCount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
	
	/**  
	* @Title: exportExcel  
	* @Description: TODO(导出)  
	* @author zhangll
	* @param odsTransferInfoDTO
	* @param request
	* @param response
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferInfo/export",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
    public String exportExcel(OdsTransferInfoDTO odsTransferInfoDTO,HttpServletRequest request, HttpServletResponse response) {
        String result = "success";
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("TransferInfoOrder");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        try {
            Pager<OdsTransferInfoDTO> temp = odsTransferInfoServiceClient.searchOdsTransferInfos(1, 25000, odsTransferInfoDTO);
            ExportTransferInfoTemplate template = new ExportTransferInfoTemplate(temp.getRecords());
            template.doExport(response.getOutputStream(), odsTransferInfoDTO);
        } catch (Exception e) {
            result = "false";
        }
        return null;
    }
	
	/**  
	* @Title: orderCheck  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param username
	* @param sign
	* @param orderNo
	* @param doctype 订单类型Transfer
	* @param orderType 出入库类型 1-入库 2-出库
	* @param version
	* @param dnType
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferInfo/orderCheck", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
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
		OrderCheckOutDTO orderResult = odsTransferInfoServiceClient.orderCheck(inpara,version);
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		
		log.debug("Exit orderCheck with result: " + result);
		return result;
	}
}

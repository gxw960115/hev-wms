package com.haier.wms.controller.transfer;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
import com.haier.openplatform.wms.transfer.service.OdsTransferDtlServiceClient;
import com.haier.wms.exceltemplate.transfer.ExportTransferDtlTemplate;
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
import java.util.Date;

/**  
 * @Title:  OdsTransferInfo.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:41:42   
 * @version V1.0 
 */  
@Controller
public class OdsTransferDtlController {

	private static Logger log = LoggerFactory.getLogger(OdsTransferDtlController.class);
	
	/**  
	* @Fields field:field:{todo}(dubbo接口)  
	*/
	@Resource
	private OdsTransferDtlServiceClient odsTransferDtlServiceClient;

	public void setOdsTransferDtlServiceClient(OdsTransferDtlServiceClient odsTransferDtlServiceClient) {
		this.odsTransferDtlServiceClient = odsTransferDtlServiceClient;
	}

	/**
	* @Title: searchTransferOrder  
	* @Description: TODO(查询手持移库扫描信息)  
	* @author zhangll
	* @param request
	* @param odsTransferDtlDTO
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferDtl/list",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchTransferDtl(HttpServletRequest request, OdsTransferDtlDTO odsTransferDtlDTO) {
        long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));

        Pager<OdsTransferDtlDTO> outpager = odsTransferDtlServiceClient.searchOdsTransferDtls(page, rows, odsTransferDtlDTO);
		PageBean bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
	
	/**  
	* @Title: searchTransDtlsAmount  
	* @Description: TODO(查询条数是否超出25000)  
	* @author zhangll
	* @param dto
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferDtl/searchTransDtlsAmount",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchTransDtlsAmount(OdsTransferDtlDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = odsTransferDtlServiceClient.searchOdsTransferDtlsCount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
	
	/**  
	* @Title: exportExcel  
	* @Description: TODO(导出)  
	* @author zhangll
	* @param odsTransferDtlDTO
	* @param request
	* @param response
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferDtl/export",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
    public String exportExcel(OdsTransferDtlDTO odsTransferDtlDTO,
            HttpServletRequest request, HttpServletResponse response) {
        String result = "success";
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("TransferDetails");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        try {
            Pager<OdsTransferDtlDTO> temp = odsTransferDtlServiceClient.searchOdsTransferDtls(1, 25000, odsTransferDtlDTO);
            ExportTransferDtlTemplate template = new ExportTransferDtlTemplate(temp.getRecords());
            template.doExport(response.getOutputStream(), odsTransferDtlDTO);
        } catch (Exception e) {
            result = "false";
        }
        return null;
    }
	
	/**  
	* @Title: orderDelete  
	* @Description: 订单删除(手持)
	* @author: ZhangLL
	* @param username
	* @param sign
	* @param orderNo
	* @param barcode
	* @param doctype 订单类型Transfer
	* @param orderType 出入库类型 1-入库 2-出库
	* @param version
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferDtl/orderDelelte", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
		orderNo = HevUtil.orderNoFormat(orderNo);

	    OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		//调用dubbo方法执行删除操作
		try {
			outResult = odsTransferDtlServiceClient.orderDelete(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @Title: orderDelete
	 * @Description: 订单删除(手持)
	 * @author: ZhangLL
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param doctype 订单类型Transfer
	 * @param orderType 出入库类型 1-入库 2-出库
	 * @param version
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsTransferDtl/ordersDelete", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei
		orderNo = HevUtil.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		//调用dubbo方法执行删除操作
		try {
			outResult = odsTransferDtlServiceClient.orderDelete(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
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
	* @param doctype 订单类型TRANSFER
	* @param orderType 出入库类型 1-入库 2-出库
	* @param bin
	* @param qty
	* @param version
	* @param remark
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferDtl/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
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
		inpara.setOrdertype("2");
		inpara.setOrno(orderNo);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setBin(bin);
		inpara.setVersion("HEV");
		inpara.setRemark(remark);
		//调用后台dubbo方法执行扫描操作
		try {
			outResult = odsTransferDtlServiceClient.orderScan(inpara,version);
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
	* @param orderNo
	* @param inpara
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsTransferDtl/orderOgp", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderOgp(String sapFlag, String orderNo,OrderIgpInDTO inpara) {
		orderNo = HevUtil.orderNoFormat(orderNo);

		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);

		try {
			outResult = odsTransferDtlServiceClient.orderOgp(inpara, inpara.getVersion(), sapFlag);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		log.debug("Exiting orderIOgp with result: " + result);
		return result;
	}
	
	/**
	* @Title: barcodeList
	* @Description: (获取条码列表)
	* @param @param username 登录用户
	* @param @param sign 手持签名 
	* @param @param orderNo 订单号的
	* @param @param docType 订单类型（PO,Inbound,DN,STO-DN,Scrap,GIFT,stocktaking)
	* @param @param orderType 出入库类型 1-入库 2-出库
	* @param @return    设定文件
	* @return String    返回类型
	*/ 
	@RequestMapping(value = "/odsTransferDtl/barcodeList", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType){

	    orderNo = HevUtil.orderNoFormat(orderNo);
	    	
	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();

		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
		// 调用dubbo方法获取barcode列表
		WmsOrderDelListOutDTO outResult = odsTransferDtlServiceClient.barcodeList(inpara);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**  
	 * @Title: orderPosting
	 * @Description: 出库(后台)
	 * @author: ZhangLL
	 * @param orderNo
	 * @param inpara
	 * @return String
	 * @throws  
	 */
	@RequestMapping(value = "/odsTransferDtl/orderPosting", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderPosting(String orderNo,OrderIgpInDTO inpara, String giLocation, String grLocation, String sapFlag){
		
		orderNo = HevUtil.orderNoFormat(orderNo);
		
		BaseUser user = UserUtil.getCurrentUser();
		
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(user.getName());
		inpara.setVersion("HEV");
		try {
			outResult = odsTransferDtlServiceClient.orderPosting(inpara, giLocation, grLocation, sapFlag);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		log.debug("Exiting orderIOgp with result: " + outResult);
		//成功返回success,失败返回失败信息
		if ("0".equals(outResult.getStatus())) {
			return "success";
		} else {
			return outResult.getMsg();
		}
	}
}

package com.haier.wms.controller.stocktaking;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingDtlServiceClient;
import com.haier.wms.template.stocktaking.ExportStocktakingorderDtlSumTemplate;
import com.haier.wms.template.stocktaking.ExportStocktakingorderDtlTemplate;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.common.utils.JsonMapper;
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
import java.util.List;

/**  
 * @ClassName: StockTakingDtlController  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2016-4-20  
 */ 
@Controller
public class StockTakingDtlController {
    private static final Logger log = LoggerFactory.getLogger(StockTakingDtlController.class);
    
    /**  
     * @Fields field:field:{}(dubbo接口)  
     */  
    @Resource
    StocktakingDtlServiceClient stocktakingDtlServiceClient;

    /**  
     * @Title: getStocktakingDtlServiceClient  
     * @Description: (get)  
     * @return
     * @return StocktakingDtlServiceClient 
     * @throws  
     */  
    public StocktakingDtlServiceClient getStocktakingDtlServiceClient() {
        return stocktakingDtlServiceClient;
    }

    /**  
     * @Title: setStocktakingDtlServiceClient  
     * @Description: (set)  
     * @param stocktakingDtlServiceClient
     * @return void 
     * @throws  
     */  
    public void setStocktakingDtlServiceClient(
            StocktakingDtlServiceClient stocktakingDtlServiceClient) {
        this.stocktakingDtlServiceClient = stocktakingDtlServiceClient;
    }

    /**  
     * @Title: selectStocktakingDtlInfo  
     * @Description: (查询)  
     * @param request
     * @param odsPdInfoDtlDTO
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDtl/list",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStocktakingDtlInfo(HttpServletRequest request,
            OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
    	String userType =SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        odsPdInfoDtlDTO.setUserId(userId);
        odsPdInfoDtlDTO.setUserType(userType);
        long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));
        PageBean bean = null;
        Pager<OdsPdInfoDtlDTO> outpager = stocktakingDtlServiceClient
        		.searchStocktakingOrderDtl(page, rows, odsPdInfoDtlDTO);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: selectStocktakingDtlSum  
     * @Description: (查询总数)  
     * @param request
     * @param odsPdInfoDtlDTO
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDtlSum/list",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStocktakingDtlSum(HttpServletRequest request,
            OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
        long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));
        PageBean bean = null;
        Pager<OdsPdInfoDtlDTO> outpager = stocktakingDtlServiceClient
        		.searchStocktakingOrderDtlSum(page, rows, odsPdInfoDtlDTO);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**
     * 
    * @Title: pdQtyDetail
    * @Description:  (这里用一句话描述这个类的作用)stock audit detail sum 查询location qty 明细
    * @param @param odsPdInfoDtlDTO
    * @param @param request
    * @param @param response
    * @param @return
    * @return String
    * @throws
     */
    @RequestMapping(value = "/stocktakingOrderDtlSum/materialqtyDetail",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String pdQtyDetail(Long page,Long rows,
            OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
        PageBean bean = null;
        Pager<OdsPdInfoDtlDTO> outpager = stocktakingDtlServiceClient
        		.getPdQtyDetail(page, rows, odsPdInfoDtlDTO);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchPdExportAmount  
     * @Description: (查询导出数量)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDtl/searchPdExportAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchPdExportAmount(HttpServletRequest request,
          HttpServletResponse response,OdsPdInfoDtlDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stocktakingDtlServiceClient.getPdExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: exportExcel  
     * @Description: (导出)  
     * @param odsPdInfoDtlDTO
     * @param request
     * @param response
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDtl/export", method = RequestMethod.GET,
    produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody  
    public String exportExcel(OdsPdInfoDtlDTO odsPdInfoDtlDTO, HttpServletRequest request, HttpServletResponse response) {
        String result="success";
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StocktakingOrderDtl");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
//        fileNameBuffer.append((int) (10F * (new Random()).nextFloat()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition","attachment;filename="+fileNameBuffer.toString()); 
        //Servlets.setFileDownloadHeader(request,response, "StocktakingOrderDtl.xlsx");
        
        try {
//            String fileName = new String(fileNameBuffer.toString().getBytes("GBK"), "ISO-8859-1");
            List<OdsPdInfoDtlDTO> temp=stocktakingDtlServiceClient.getOdsPdInfoDtls(odsPdInfoDtlDTO);
            ExportStocktakingorderDtlTemplate template=new ExportStocktakingorderDtlTemplate(temp);
            template.doExport(response.getOutputStream(), odsPdInfoDtlDTO);
        } catch (Exception e) {
            log.debug("Exception:",e);
            result="false";
        }
        return null;
    }
    
    /**  
     * @Title: searchPdDetailSumAmount  
     * @Description: (查询总数)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDtl/searchPdDetailSumAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchPdDetailSumAmount(HttpServletRequest request,
          HttpServletResponse response,OdsPdInfoDtlDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stocktakingDtlServiceClient.searchOdsPdInfoDtlsCountBySum(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: exportDetailsSum  
     * @Description: (导出总数)  
     * @param odsPdInfoDtlDTO
     * @param request
     * @param response
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDtl/exportSum", method = RequestMethod.GET,
    	    produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody  
    public String exportDetailsSum(OdsPdInfoDtlDTO odsPdInfoDtlDTO, HttpServletRequest request, HttpServletResponse response) {
        String result="success";
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StocktakingDtlSum");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
//        fileNameBuffer.append((int) (10F * (new Random()).nextFloat()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition","attachment;filename="+fileNameBuffer.toString()); 
        //Servlets.setFileDownloadHeader(request,response, "StocktakingOrderDtl.xlsx");
        try {
            List<OdsPdInfoDtlDTO> temp=stocktakingDtlServiceClient.searchStocktakingOrderDtlSumList(odsPdInfoDtlDTO);
            ExportStocktakingorderDtlSumTemplate template=new ExportStocktakingorderDtlSumTemplate(temp);
            template.doExport(response.getOutputStream(), odsPdInfoDtlDTO);
        } catch (Exception e) {
            log.debug("Exception:",e);
            result="false";
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
	* @param doctype 订单类型PD
	* @param orderType 出入库类型 1-入库 2-出库
	* @param version
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/stocktakingOrderDtl/orderDelelte", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
		orderNo = HevUtil.orderNoFormat(orderNo);

	    OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		inpara.setBin("1");
		//调用dubbo方法执行删除操作
		try {
			outResult = stocktakingDtlServiceClient.orderDelete(inpara,version);
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
	* @param doctype 订单类型PD
	* @param orderType 出入库类型 1-入库 2-出库
	* @param version
	* @return String
	* @throws
	*/
	@RequestMapping(value = "/stocktakingOrderDtl/ordersDelete", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei
		orderNo = HevUtil.orderNoFormat(orderNo);

	    OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		inpara.setBin("1");
		//调用dubbo方法执行删除操作
		try {
			outResult = stocktakingDtlServiceClient.ordersDelete(inpara,version);
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
	* @param doctype 订单类型PD
	* @param orderType 出入库类型 1-入库 2-出库
	* @param bin
	* @param qty
	* @param version
	* @param remark
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/stocktakingOrderDtl/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark,String location){
		
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
		inpara.setLocation(location);
		inpara.setVersion("HEV");
		inpara.setRemark(remark);
		
		//调用后台dubbo方法执行扫描操作
		try {
			outResult = stocktakingDtlServiceClient.orderScan(inpara,version);
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
	@RequestMapping(value = "/stocktakingOrderDtl/barcodeList", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
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
		WmsOrderDelListOutDTO outResult = stocktakingDtlServiceClient.barcodeList(inpara);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
}

package com.haier.wms.controller.stocktaking;


import java.text.SimpleDateFormat;
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

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient;
import com.haier.wms.template.stocktaking.ExportStocktakingorderTemplate;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

import io.terminus.common.utils.JsonMapper;

/**
 * @ClassName: StockTakingController
 * @Description: 库存盘点单 相关操作（查询），经此调dubbo方法
 * @author linzongxiao
 * @Date 2015-10-30 下午2:06:55
 */
@Controller
public class StockTakingController {
	
	/**  
	* @Fields log: 用一句话描述该文件做什么
	*/
	private static final Logger log = LoggerFactory.getLogger(StockTakingController.class);
	
    /**  
     * @Fields field:field:{}(dubbo暴漏出来的接口)  
     */  
    @Resource
    StocktakingServiceClient stocktakingServiceClient;

    /**
     * @Title: getStocktakingServiceClient
     * @Description: getter方法
     * @param @return
     * @return StocktakingServiceClient
     * @throws
     */
    public StocktakingServiceClient getStocktakingServiceClient() {
        return stocktakingServiceClient;
    }

    /**
     * @Title: setStocktakingServiceClient
     * @Description: setter方法
     * @param @param stocktakingServiceClient
     * @return void
     * @throws
     */
    public void setStocktakingServiceClient(StocktakingServiceClient stocktakingServiceClient) {
        this.stocktakingServiceClient = stocktakingServiceClient;
    }

    /**
     * @Title: selectStocktakingOrder
     * @Description: 查询 库存盘点单
     * @param @param request
     * @param @param odsPdInfoDTO
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/stocktakingOrder/list",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStocktakingOrder(HttpServletRequest request,OdsPdInfoDTO odsPdInfoDTO) {
    	String userType =SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));
        odsPdInfoDTO.setUserType(userType);
        odsPdInfoDTO.setUserId(userId);

        PageBean bean = null;
        Pager<OdsPdInfoDTO> outpager = stocktakingServiceClient.searchStocktakingOrder(page, rows, odsPdInfoDTO);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchStockAuditAmount  
     * @Description: (查询 库存盘点单数量)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrder/searchStockAuditAmount",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStockAuditAmount(HttpServletRequest request,HttpServletResponse response,OdsPdInfoDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stocktakingServiceClient.searchOdsPdInfosCount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

    /**  
     * @Title: exportExcel  
     * @Description: (导出)  
     * @param odsPdInfoDTO
     * @param request
     * @param response
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrder/export", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportExcel(OdsPdInfoDTO odsPdInfoDTO,HttpServletRequest request, HttpServletResponse response) {
        String result = "success";
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StocktakingOrder");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename="+ fileNameBuffer.toString());

        try {
            List<OdsPdInfoDTO> temp = stocktakingServiceClient.getOdsPdInfo(odsPdInfoDTO);
            ExportStocktakingorderTemplate template = new ExportStocktakingorderTemplate(temp);
            template.doExport(response.getOutputStream(), odsPdInfoDTO);
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
	* @param doctype 订单类型PD
	* @param orderType 出入库类型 1-入库 2-出库
	* @param version
	* @param dnType
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/stocktakingOrder/orderCheck", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
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
        OrderCheckOutDTO orderResult = stocktakingServiceClient.orderCheck(inpara,version);
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		
		log.debug("Exit orderCheck with result: " + result);
		return result;
	}
    
}

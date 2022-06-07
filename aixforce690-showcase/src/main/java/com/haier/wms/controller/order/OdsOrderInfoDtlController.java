package com.haier.wms.controller.order;

import com.haier.openplatform.wms.remoting.dto.OrderDirectDispatchOutDTO;
import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.po.service.OdsOrderInfoDtlServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

@Controller
public class OdsOrderInfoDtlController {
	@Resource
	private OdsOrderInfoDtlServiceClient odsOrderInfoDtlServiceClient;
	
	@Resource
    private PsiReportServiceClient psiReportServiceClient;
	
	/**  
	 * @Title: searchOdsOrderInfoDtl  
	 * @Description: 根据条件分页查询PO_Detail 
	 * @param request
	 * @param page
	 * @param rows
	 * @param odsOrderInfoDtlDTO
	 * @return String 
	 */  
	@RequestMapping(value = "/order/searchOdsOrderInfoDtl",
						method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOdsOrderInfoDtl(HttpServletRequest request,
			Long page, Long rows,OdsOrderInfoDtlDTO odsOrderInfoDtlDTO){
		String userType =SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        odsOrderInfoDtlDTO.setUserId(userId);
        odsOrderInfoDtlDTO.setUserType(userType);
		Pager<OdsOrderInfoDtlDTO> pager
				= odsOrderInfoDtlServiceClient.searchOdsOrderDtls(page, rows, odsOrderInfoDtlDTO);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: searchOrderInfoDtlAmount  
	 * @Description: 查询导出数据数量
	 * @param request
	 * @param response
	 * @param odsOrderInfoDtl
	 * @return String 
	 */  
	@RequestMapping(value = "/order/searchOrderInfoDtlAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchOrderInfoDtlAmount(HttpServletRequest request,HttpServletResponse response,
			OdsOrderInfoDtlDTO odsOrderInfoDtl){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = odsOrderInfoDtlServiceClient.getExportAmount(odsOrderInfoDtl);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    	
    }
	
    /**  
     * @Title: print  
     * @Description: ogpigp detail 打印)  
     * @param request
     * @param response
     * @param barcodes
     * @param orderNos
     * @return String 
     */  
    @RequestMapping(value = "/order/printOgpIgpDetail")
    @ResponseBody
    public String print(HttpServletRequest request,HttpServletResponse response,
    								String barcodes, String orderNos){
    	Map<String,Object> parameters = new HashMap<String,Object>();
    	//"SQLSTR"是报表中定义的参数名称,其类型为String 型
    	//设置SQLSTR参数的内容,根据需要赋值sql语句
    	
    	String[] barcode = barcodes.split(",");
    	String[] orderNo = orderNos.split(",");
    	
    	StringBuffer barcodesSb = new StringBuffer();
		// 拼sql in(,,,,)
		if (barcode.length > 0) {
			for (int i = 0; i < barcode.length; i++) {
				barcodesSb.append("'").append(barcode[i]).append("'");
				if (i != barcode.length - 1) {
					barcodesSb.append(",");
				}
			}
		}

		StringBuffer orderNosSb = new StringBuffer();
		// 拼sql in(,,,,)
		if (orderNo.length > 0) {
			for (int i = 0; i < orderNo.length; i++) {
				orderNosSb.append("'").append(orderNo[i]).append("'");
				if (i != orderNo.length - 1) {
					orderNosSb.append(",");
				}
			}
		}
		parameters.put("barcode", barcodesSb.toString());
		parameters.put("orderNo", orderNosSb.toString());
//		Connection conn = null;
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "/report/igpOgpDetail.jasper";
		byte[] bytes = null;
		// 报表编译之后生成的.jasper文件的存放位置
		File reportFile = new File(path);

    	try {
    		ServletOutputStream outStream =	response.getOutputStream();
//			conn = JDBCFactory.getConnection();
//    		conn = psiReportServiceClient.getDBConnection();
//			bytes= JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn);
			bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameters);
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
    
	public void setOdsOrderInfoDtlServiceClient(
			OdsOrderInfoDtlServiceClient odsOrderInfoDtlServiceClient) {
		this.odsOrderInfoDtlServiceClient = odsOrderInfoDtlServiceClient;
	}
	public PsiReportServiceClient getPsiReportServiceClient() {
        return psiReportServiceClient;
    }
    public void setPsiReportServiceClient(
            PsiReportServiceClient psiReportServiceClient) {
        this.psiReportServiceClient = psiReportServiceClient;
    }




	/**
	 * 直发调度确认
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/order/directDispatch",
			method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String directDispatch(HttpServletRequest request,HttpServletResponse response,
								 String stodnNo, String dnNo)throws Exception{


		String userType =SessionConstants.getSession().getString("user_duty_type");
		String userName=SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);

		OrderDirectDispatchOutDTO outResult = new OrderDirectDispatchOutDTO();

		try {
			outResult = odsOrderInfoDtlServiceClient.directDispatch(stodnNo, dnNo, userName);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		return result;
	}
}

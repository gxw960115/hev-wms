package com.haier.wms.controller.order;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.sql.Connection;
import java.util.Date;
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
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;
import com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.ResultMsg;
import com.haier.wms.util.SessionConstants;

/**  
 * @ClassName: OdsWmsOrderController  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2015-4-20  
 */ 
@Controller
public class OdsWmsOrderController {
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
	private OdsWmsOrderServiceClient odsWmsOrderServiceClient;
	
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
    private PsiReportServiceClient psiReportServiceClient;
	
	/**  
	 * @Title: searchGfOrder  
	 * @Description: (查询)  
	 * @param request
	 * @param page
	 * @param rows
	 * @param odsWmsOrderDTO
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchGfOrder", 
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchGfOrder(HttpServletRequest request, Long page,
			Long rows, OdsWmsOrderDTO odsWmsOrderDTO) {
		String userType =SessionConstants.getSession().getString("user_duty_type");
        Long userId=SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
	    odsWmsOrderDTO.setUserId(userId);
		odsWmsOrderDTO.setUserType(userType);
		Pager<OdsWmsOrderDTO> pager = new Pager<OdsWmsOrderDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsWmsOrderServiceClient
				.searchOdsWmsOrders(pager, odsWmsOrderDTO);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: saveScrapOrder  
	 * @Description: (add 窗口的save)  
	 * @param request
	 * @param msg
	 * @param odsWmsOrderDTO
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/saveScrapOrder", 
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String saveScrapOrder(HttpServletRequest request, String msg, OdsWmsOrderDTO odsWmsOrderDTO) {
		odsWmsOrderDTO.setDocTpye("SCRAP");
		odsWmsOrderDTO.setCreateBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		odsWmsOrderDTO.setCreateDate(new Date());
		ExecuteResult<OdsWmsOrderDTO> executeResult = odsWmsOrderServiceClient
				.saveScrapOrder(odsWmsOrderDTO, msg);
		//this.setSuccess(executeResult.isSuccess());
		/*if (!executeResult.isSuccess()) {
			addActionErrorsFromResult(executeResult);
			return SUCCESS;
		}*/
		ResultMsg result=new ResultMsg();
        if (!executeResult.isSuccess()) {
        	result.setMsg(executeResult.getErrorMessages().get(0));
        }
        result.setSuccess("success");
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**  
	 * @Title: deltScrapOrder  
	 * @Description: (导出)  
	 * @param rowId
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/deltScrapOrder", 
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deltScrapOrder(String rowId) {
		OdsWmsOrderDTO odsWmsOrderDTO=odsWmsOrderServiceClient.getOdsWmsOrderById(Long.valueOf(rowId));
		odsWmsOrderDTO.setFlag("1");
		odsWmsOrderDTO.setModifyBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		odsWmsOrderDTO.setModifyDate(new Date());
		ExecuteResult<OdsWmsOrderDTO> executeResult = odsWmsOrderServiceClient
				.deleteScrapOrder(odsWmsOrderDTO);
		ResultMsg result=new ResultMsg();
        if (!executeResult.isSuccess()) {
        	result.setMsg(executeResult.getErrorMessages().get(0));
        }
        result.setSuccess("success");
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**  
	 * @Title: checkScrapOrder  
	 * @Description: (审批)  
	 * @param odsWmsOrderDTO
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/checkScrapOrder",
			 method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String checkScrapOrder(OdsWmsOrderDTO odsWmsOrderDTO){
		odsWmsOrderDTO.setCheckFlag("1");
		odsWmsOrderDTO.setCheckBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		odsWmsOrderDTO.setCheckDate(new Date());
		ExecuteResult<OdsWmsOrderDTO> executeResult = odsWmsOrderServiceClient
				.updateScrapOrder(odsWmsOrderDTO);
		ResultMsg result=new ResultMsg();
		if (!executeResult.isSuccess()) {
			result.setMsg(executeResult.getErrorMessages().get(0));
        }
		else{
			 result.setSuccess("success");
		}
       return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**  
	 * @Title: deltGfOrder  
	 * @Description: (删除)  
	 * @param odsWmsOrder
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/deleteGFOrder/giftOrder",
			 method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deltGfOrder(OdsWmsOrderDTO odsWmsOrder) throws Exception {
		odsWmsOrder.setModifyBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		odsWmsOrder.setModifyDate(new Date());
		ExecuteResult<OdsWmsOrderDTO> executeResult = 
				odsWmsOrderServiceClient.deltGfOrder(odsWmsOrder);
		ResultMsg result=new ResultMsg();
		if (!executeResult.isSuccess()) {
			result.setMsg(executeResult.getErrorMessages().get(0));
        }
		else{
			 result.setSuccess("success");
		}
       return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**  
	 * @Title: searchScrapBarcodeDtl  
	 * @Description: (查询)  
	 * @param request
	 * @param page
	 * @param rows
	 * @param odsInventoryInfoDtlDTO
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/searchScrapBarcodeDtl", 
			method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchScrapBarcodeDtl(HttpServletRequest request,
			Long page, Long rows,OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		String userType=SessionConstants.getSession().getString("user_duty_type");
		odsInventoryInfoDtlDTO.setUserType(userType);
		Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
		odsInventoryInfoDtlDTO.setUserId(userId);
		Pager<OdsInventoryInfoDtlDTO> pager = new Pager<OdsInventoryInfoDtlDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsWmsOrderServiceClient.searchScrapBarcodeDtl(pager,odsInventoryInfoDtlDTO);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**  
	 * @Title: saveGfOrder  
	 * @Description: (保存)  
	 * @param odsWmsOrder
	 * @return
	 * @throws Exception
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value = "/order/saveGfOrder",
			 method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String saveGfOrder(OdsWmsOrderDTO odsWmsOrder) throws Exception {
		odsWmsOrder.setCreateBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		odsWmsOrder.setWmsOrderItem("0001");
		odsWmsOrder.setDocTpye("GIFT");
		odsWmsOrder.setCreateDate(new Date());
		ExecuteResult<OdsWmsOrderDTO> executeResult = odsWmsOrderServiceClient
				.createOdsWmsOrder(odsWmsOrder);
		ResultMsg result=new ResultMsg();
		if (!executeResult.isSuccess()) {
			result.setSuccess("Add Failed");
        	result.setMsg(executeResult.getErrorMessages().get(0));
        }
		else{
			result.setSuccess("Add Success");
		}
       return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
    /**  
     * @Title: print  
     * @Description: (打印)  
     * @param request
     * @param response
     * @param wmsOrderNos
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/order/printGiftOrder")
    @ResponseBody
    public String print(HttpServletRequest request,HttpServletResponse response,
    								String wmsOrderNos){
    	Map parameters = new HashMap();
    	//"SQLSTR"是报表中定义的参数名称,其类型为String 型
    	//设置SQLSTR参数的内容,根据需要赋值sql语句
    	String[] wmsOrderNo=wmsOrderNos.split(",");
    	StringBuffer wmsOrderNosSb = new StringBuffer();
    	//拼sql in(,,,,)
    	if(wmsOrderNo.length>0){
    		for(int i=0;i<wmsOrderNo.length;i++){
    			wmsOrderNosSb.append("'").append(wmsOrderNo[i]).append("'");
    			if(i!=wmsOrderNo.length-1){
    				wmsOrderNosSb.append(",");
    			}
    		}
    	}
    	parameters.put("wmsOrderNo", wmsOrderNosSb.toString());
    	Connection conn = null;
        String   path = request.getSession().getServletContext().getRealPath("/")
                     + "/report/giftOrderInfo.jasper";   
        byte[] bytes=null;
    	//报表编译之后生成的.jasper文件的存放位置
    	File reportFile = new File(path);
    	try {
    		ServletOutputStream outStream=	response.getOutputStream();
//			conn =JDBCFactory.getConnection();
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
    
    /**   
	 * @Description: (odsWmsOrderServiceClient的set方法)  
	 * @param odsWmsOrderServiceClient
	 */ 
	public void setOdsWmsOrderClient(OdsWmsOrderServiceClient odsWmsOrderServiceClient) {
		this.odsWmsOrderServiceClient = odsWmsOrderServiceClient;
	}
	/**   
	 * @Description: (psiReportServiceClient的get方法)  
	 * @return psiReportServiceClient
	 */ 
	public PsiReportServiceClient getPsiReportServiceClient() {
        return psiReportServiceClient;
    }
	/**   
	 * @Description: (psiReportServiceClient的set方法)  
	 * @param psiReportServiceClient
	 */ 
    public void setPsiReportServiceClient(
            PsiReportServiceClient psiReportServiceClient) {
        this.psiReportServiceClient = psiReportServiceClient;
    }
}

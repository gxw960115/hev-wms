package com.haier.wms.controller.inventory;

import io.terminus.common.utils.JsonMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;
import com.haier.openplatform.wms.inventory.service.SearchOldsBarcodeInfoClient;
import com.haier.wms.controller.inventory.exceltemplate.ExportOdsBarcodeHistoryListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * @Company 青鸟软通
 * @Title:历史条码请求分发
 * @Package com.haier.wms.controller.inventory
 * @author sunhaoyu
 * @date 2015/10/27
 * @version V1.0
 */
@Controller
public class SelectOldsBarcodeInfoController {
    /**  
     * @Fields field:field:{}(dubbo接口)  
     */  
    @Resource
    private SearchOldsBarcodeInfoClient searchOldsBarcodeInfoClient;

    /**
     * @Description: 属性 searchOldsBarcodeInfoClient 的get方法
     * @return searchOldsBarcodeInfoClient
     */
    public SearchOldsBarcodeInfoClient getSearchOldsBarcodeInfoClient() {
        return searchOldsBarcodeInfoClient;
    }

    /**
     * @Description: 属性 searchOldsBarcodeInfoClient 的set方法
     */
    public void setSearchOldsBarcodeInfoClient(
            SearchOldsBarcodeInfoClient searchOldsBarcodeInfoClient) {
        this.searchOldsBarcodeInfoClient = searchOldsBarcodeInfoClient;
    }

    /**
     * @Title: selectStockAgeReport
     * @Description: 历史条码查询
     * @param @param request
     * @param page
     * @param rows
     * @param dto
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/oldsBarcode/search", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStockAgeReport(HttpServletRequest request, Long page,
            Long rows, OdsBarcodeHistoryDTO dto) {
    	String userType=SessionConstants.getSession().getString("user_duty_type");
    	Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
    	dto.setUserId(userId);
    	dto.setUserType(userType);
        PageBean bean = null;
        Pager<OdsBarcodeHistoryDTO> pager = new Pager<OdsBarcodeHistoryDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = searchOldsBarcodeInfoClient.searchOdsBarcodeInfo(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchInventoryAmount  
     * @Description: (这里用一句话描述这个方法的作用)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/oldsBarcode/searchOldsBarcodeAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchInventoryAmount(HttpServletRequest request,
          HttpServletResponse response,OdsBarcodeHistoryDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = searchOldsBarcodeInfoClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: exportOdsBarcodeInfo  
     * @Description: (这里用一句话描述这个方法的作用)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/oldsBarcode/export")
    @ResponseBody
    public String exportOdsBarcodeInfo(HttpServletRequest request,HttpServletResponse response, OdsBarcodeHistoryDTO dto) {
    	response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("BarCodeHistory");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        List<OdsBarcodeHistoryDTO> temp = searchOldsBarcodeInfoClient.getOdsBarcodeInfoByParams(dto);
        ExcelExportTemplate<OdsBarcodeHistoryDTO> exportOdsBarcodeInfoListTemplet = new ExportOdsBarcodeHistoryListTemplet(temp);
        try {
            exportOdsBarcodeInfoListTemplet.doExport(
                    response.getOutputStream(), dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

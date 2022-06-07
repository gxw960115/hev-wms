package com.haier.wms.controller.inventory;

import io.terminus.common.utils.JsonMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient;
import com.haier.wms.controller.inventory.exceltemplate.ExportOdsInventoryInfoDtlListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * @Company 青鸟软通
 * @Title:库存报表详情请求
 * @Package com.haier.wms.controller.inventory
 * @author sunhaoyu
 * @date 2015/10/26
 * @version V1.0
 */
@Controller
public class SelectStockAgeReportController {
    /**  
     * @Fields field:field:{todo}(dubbo接口)  
     */  
    @Resource
    private SearchStockAgeReportClient searchStockAgeReportClient;

    /**
     * @Description: 属性 searchStockAgeReportClient 的get方法
     * @return searchStockAgeReportClient
     */
    public SearchStockAgeReportClient getSearchStockAgeReportClient() {
        return searchStockAgeReportClient;
    }
    /**
     * @Description: 属性 searchStockAgeReportClient 的set方法
     */
    public void setSearchStockAgeReportClient(
            SearchStockAgeReportClient searchStockAgeReportClient) {
        this.searchStockAgeReportClient = searchStockAgeReportClient;
    }

    /**
     * @Title: selectStockAgeReport
     * @Description:库存报表详情查询
     * @param @param request
     * @param @param page
     * @param @param rows
     * @param @param dto
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/stockAgeReport/search",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStockAgeReport(HttpServletRequest request, Long page,
            Long rows, OdsInventoryInfoDtlDTO dto) {
        String userType=SessionConstants.getSession().getString("user_duty_type");
        dto.setUserType(userType);
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserId(userId);
        PageBean bean = null;
        Pager<OdsInventoryInfoDtlDTO> pager = new Pager<OdsInventoryInfoDtlDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = searchStockAgeReportClient.getStockAgeReport(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchStockAmount  
     * @Description: TODO(库存报表详情导出数量)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/searchStockAmount/export",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStockAmount(HttpServletRequest request,
          HttpServletResponse response,OdsInventoryInfoDtlDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = searchStockAgeReportClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    	
    }

    /**  
     * @Title: exportOdsInventoryDtlInfo  
     * @Description: TODO(库存报表导出)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stockAgeReport/export")
    @ResponseBody
    public String exportOdsInventoryDtlInfo(HttpServletRequest request,HttpServletResponse response, OdsInventoryInfoDtlDTO dto) {
    	
        String userType=SessionConstants.getSession().getString("user_duty_type");
        dto.setUserType(userType);
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserId(userId);
        
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StockAgeReport");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        List<OdsInventoryInfoDtlDTO> temp = searchStockAgeReportClient.getInventoryInfoDtlByParams(dto);
        ExcelExportTemplate<OdsInventoryInfoDtlDTO> exportOdsInventoryInfoListTemplet = new ExportOdsInventoryInfoDtlListTemplet(temp);
        try {
            exportOdsInventoryInfoListTemplet.doExport(response.getOutputStream(), dto);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }
    /**
    * @Title: sapQtyDetail
    * @Description: TODO (这里用一句话描述这个类的作用)stock audit detail sum sap qty 明细
    * @param @param request
    * @param @param page
    * @param @param rows
    * @param @param dto
    * @param @return
    * @return String
    * @throws
     */
    @RequestMapping(value = "/stockAgeReport/sapQtyDetail",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String sapQtyDetail(Long page,
            Long rows, OdsInventoryInfoDtlDTO dto) {
        PageBean bean = null;
        Pager<OdsInventoryInfoDtlDTO> pager = new Pager<OdsInventoryInfoDtlDTO>();
        pager.setPageSize(0L);
        pager.setCurrentPage(0L);
        pager = searchStockAgeReportClient.sapQtyDetail(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: updateBarcodeStatus  
     * @Description: TODO(锁定库存状态)  
     * @param barcodes
     * @param lockFlag
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stockAgeReport/updateBarcodeStatus",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String updateBarcodeStatus(String barcodes,String lockFlag){
    	
    	String[] splitBarcodes =  StringUtils.split(barcodes,",");
    	List<OdsInventoryInfoDtlDTO> list = new ArrayList<OdsInventoryInfoDtlDTO>();
    	OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO = null;
    	for (String barcode : splitBarcodes) {
    		odsInventoryInfoDtlDTO = new OdsInventoryInfoDtlDTO();
    		odsInventoryInfoDtlDTO.setBarcode(barcode);
    		list.add(odsInventoryInfoDtlDTO);
		}
    	searchStockAgeReportClient.updateBarcodeStatus(list, lockFlag);
    	return "Success";
    }
}

package com.haier.wms.controller.inventory;

import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import io.terminus.common.utils.JsonMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient;
import com.haier.wms.controller.inventory.exceltemplate.ExportActualStockGapTemplate;
import com.haier.wms.controller.inventory.exceltemplate.ExportStgSapStockListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * @Company 青鸟软通
 * @Title:sap库存查询
 * @Package com.haier.wms.controller.inventory
 * @author sunhaoyu
 * @date 2015/10/30
 * @version V1.0
 */
@Controller
public class SelectStgSapStockInfoController {
    @Resource
    private StgSapStockServiceClient stgSapStockServiceClient;
    @Resource
    private CdWhInfoServiceClient cdWhInfoServiceClient;
    
    /**
     * @Description: 属性 cdWhInfoServiceClient 的get方法
     * @return cdWhInfoServiceClient
     */
    public CdWhInfoServiceClient getCdWhInfoServiceClient() {
        return cdWhInfoServiceClient;
    }
    /**
     * @Description: 属性 stgSapStockServiceClient 的set方法
     */
    public void setCdWhInfoServiceClient(
            CdWhInfoServiceClient cdWhInfoServiceClient) {
        this.cdWhInfoServiceClient = cdWhInfoServiceClient;
    }
    /**
     * @Description: 属性 stgSapStockServiceClient 的get方法
     * @return stgSapStockServiceClient
     */
    public StgSapStockServiceClient getStgSapStockServiceClient() {
        return stgSapStockServiceClient;
    }
    /**
     * @Description: 属性 stgSapStockServiceClient 的set方法
     */
    public void setStgSapStockServiceClient(
            StgSapStockServiceClient stgSapStockServiceClient) {
        this.stgSapStockServiceClient = stgSapStockServiceClient;
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
    @RequestMapping(value = "/sapInfo/search", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStockAgeReport(HttpServletRequest request, Long page,
            Long rows, StgSapStockDTO dto) {
        String userType=SessionConstants.getSession().getString("user_duty_type");
        dto.setUserType(userType);
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserId(userId);
        PageBean bean = null;
        Pager<StgSapStockDTO> pager = new Pager<StgSapStockDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = stgSapStockServiceClient.searchStgSapStockInfo(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchMb52Amount  
     * @Description:   
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/sapInfo/searchMb52Amount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchMb52Amount(HttpServletRequest request,
          HttpServletResponse response,StgSapStockDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stgSapStockServiceClient.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

    /**
    * @Title: exportStgSapStockInfo
    * @Description: 导出
    * @param @param request
    * @param @param response
    * @param @param dto
    * @param @return
    * @return String
    * @throws
    */
    @RequestMapping(value = "/sapInfo/export")
    @ResponseBody
    public String exportStgSapStockInfo(HttpServletRequest request,HttpServletResponse response, StgSapStockDTO dto) {
        String userType=SessionConstants.getSession().getString("user_duty_type");
        dto.setUserType(userType);
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserId(userId);
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("MB52_");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        List<StgSapStockDTO> temp = stgSapStockServiceClient.getStgSapInfoInfoByParams(dto);
        ExcelExportTemplate<StgSapStockDTO> exportOdsStgSapInfoListTemplet = new ExportStgSapStockListTemplet(temp);
        try {
            exportOdsStgSapInfoListTemplet.doExport(response.getOutputStream(),dto);
        } catch (Exception e) {
            e.printStackTrace();
          
        }
        return null;

    }

    /**
    * @Title: selectLocationTree
    * @Description: 查询树结构
    * @param @param request
    * @param @param userType
    * @param @param userId
    * @param @return
    * @return String
    * @throws
    */
    @RequestMapping(value = "/sapInfo/localTree", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectLocationTree(HttpServletRequest request,
            String userType, Long userId) {
//        userId=SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        List<HashMap<String,Object>> rows=cdWhInfoServiceClient.findWhlocalInfos(userType,userId);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
    }
    
    /**
     * @Title: searchActualStockGap
     * @Description:查询库存差异
     * @param request
     * @return String
     */
    @RequestMapping(value = "/sapInfo/stockGap", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchActualStockGap(HttpServletRequest request, Long page,
            Long rows, StgSapStockDTO dto) {
        String userType=SessionConstants.getSession().getString("user_duty_type");
        dto.setUserType(userType);
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserId(userId);
        PageBean bean = null;
        Pager<StgSapStockDTO> pager = new Pager<StgSapStockDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = stgSapStockServiceClient.searchActualStockGap(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**
     * @Title: exportStgSapStockInfo
     * @Description: 导出
     * @param @param request
     * @param @param response
     * @param @param dto
     */
     @RequestMapping(value = "/sapInfo/exportGap")
     @ResponseBody
     public String exportActualStockGap(HttpServletRequest request,
             HttpServletResponse response, StgSapStockDTO dto) {
         String userType=SessionConstants.getSession().getString("user_duty_type");
         dto.setUserType(userType);
         Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
         dto.setUserId(userId);
         response.setContentType(Servlets.EXCEL_TYPE);
         Servlets.setFileDownloadHeader(request, response, "MB52 Gap.xlsx");
         List<StgSapStockDTO> temp = stgSapStockServiceClient.searchActualStockGapList(dto);
         ExcelExportTemplate<StgSapStockDTO> exportOdsStgSapInfoListTemplet = new ExportActualStockGapTemplate(
                 temp);
         try {
             exportOdsStgSapInfoListTemplet.doExport(response.getOutputStream(),
                     dto);
         } catch (Exception e) {
             e.printStackTrace();
           
         }
         return null;
     }
     
     /**  
     * @Title: downAllInventoryFromSap  
     * @Description: (下载所有MB52)  
     * @param request
     * @param response
     * @return void 
     * @throws  
     */  
    @RequestMapping(value = "/inventory/downAllInventoryFromSap")
    @ResponseBody
    public void downAllInventoryFromSap(HttpServletRequest request,
             HttpServletResponse response) {
        stgSapStockServiceClient.downAllInventoryFromSap();
    }
    
    /**
     * @title: downLoadByPlantAndLocation
     * @description: 
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月17日 下午5:28:22 
     * @return: String
     */
    @RequestMapping(value = "/inventory/downInventoryFromSapController",produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String downLoadByPlantAndLocation(String plant, String locations) {
    	String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
    	InterfaceOutDTO result = stgSapStockServiceClient.downInventoryFromSap(plant, locations, userName);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
}

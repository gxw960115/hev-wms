package com.haier.wms.controller.inventory;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.basicdata.dto.CdFactoryDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.InventoryInfoServiceClient;
import com.haier.openplatform.wms.security.service.PlantServiceClient;
import com.haier.wms.controller.inventory.exceltemplate.ExportOdsInventoryBinInfoTemplet;
import com.haier.wms.controller.inventory.exceltemplate.ExportOdsInventoryInfoListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.common.utils.JsonMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Company 青鸟软通
 * @Title:库存功能请求分发
 * @Package com.haier.wms.controller.inventory
 * @author sunhaoyu
 * @date 2015/10/26
 * @version V1.0
 */
@Controller
public class SeclectOdsInventoryInfoController {

    /**  
     * @Fields field:field:{}(dubbo接口)  
     */  
    @Resource
    private InventoryInfoServiceClient seleceInventoryInfoService;

    /**  
     * @Fields field:field:{}(dubbo接口)  
     */  
    @Resource
    private PlantServiceClient plantServiceClient;
    
    /**
     * @Description: 属性 getPlantServiceClient 的get方法
     * @return getPlantServiceClient
     */
    public PlantServiceClient getPlantServiceClient() {
        return plantServiceClient;
    }
    
    /**
     * @Description: 属性 plantServiceClient 的set方法
     */
    public void setPlantServiceClient(PlantServiceClient plantServiceClient) {
        this.plantServiceClient = plantServiceClient;
    }

    /**
     * @Description: 属性 seleceInventoryInfoService 的get方法
     * @return seleceInventoryInfoService
     */
    public InventoryInfoServiceClient getSeleceInventoryInfoService() {
        return seleceInventoryInfoService;
    }

    /**
     * @Description: 属性 seleceInventoryInfoService 的set方法
     */
    public void setSeleceInventoryInfoService(
            InventoryInfoServiceClient seleceInventoryInfoService) {
        this.seleceInventoryInfoService = seleceInventoryInfoService;
    }

    /**
     * @Title: selectOdsInventory
     * @Description: 查询库存信息
     * @param request
     * @param page
     * @param rows
     * @param dto
     * @param
     * @return String
     * @throws
     */
    @RequestMapping(value = "/inventory/search", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectOdsInventory(HttpServletRequest request, Long page,
            Long rows, OdsInventoryInfoDTO dto) {
    	String userType=SessionConstants.getSession().getString("user_duty_type");
    	Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
    	dto.setUserId(userId);
    	dto.setUserType(userType);
    	PageBean bean = null;
    	Pager<OdsInventoryInfoDTO> pager = new Pager<OdsInventoryInfoDTO>();
    	pager.setPageSize(rows);
    	pager.setCurrentPage(page);
    	pager = seleceInventoryInfoService.searchOdsInventoryInfo(pager, dto);
    	bean = PageUtil.setPager(pager);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }

    /**
     * @Title: selectOdsInventoryBin
     * @Description: 查询库存信息
     * @param request
     * @param page
     * @param rows
     * @param dto
     * @param
     * @return String
     * @throws
     */
    @RequestMapping(value = "/inventory/inventoryStatistics", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectOdsInventoryBin(HttpServletRequest request, Long page,Long rows, OdsInventoryInfoDtlDTO dto) {
    	String userType=SessionConstants.getSession().getString("user_duty_type");
    	Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
    	dto.setUserId(userId);
    	dto.setUserType(userType);
    	PageBean bean = null;
    	Pager<OdsInventoryInfoDtlDTO> pager = new Pager<OdsInventoryInfoDtlDTO>();
    	pager.setPageSize(rows);
    	pager.setCurrentPage(page);
    	pager = seleceInventoryInfoService.searchOdsInventoryBinInfo(pager, dto);
    	bean = PageUtil.setPager(pager);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }

    /**
    * @Title: wmsQtyDetail
    * @Description:  (这里用一句话描述这个类的作用)
    * @param @param request
    * @param @param page
    * @param @param rows
    * @param @param dto
    * @param @return
    * @return String 
    * @throws
     */
    @RequestMapping(value = "/inventory/wmsQtyDetail", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String wmsQtyDetail(HttpServletRequest request, Long page,
            Long rows, OdsInventoryInfoDTO dto) {
    	PageBean bean = null;
        Pager<OdsInventoryInfoDTO> pager = new Pager<OdsInventoryInfoDTO>();
        pager.setPageSize(1L);
        pager.setCurrentPage(1L);
        pager = seleceInventoryInfoService.wmsQtyDetail(pager, dto);
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
    @RequestMapping(value = "/inventory/searchInventoryAmount",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchInventoryAmount(HttpServletRequest request,
          HttpServletResponse response,OdsInventoryInfoDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = seleceInventoryInfoService.getExportAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
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
    @RequestMapping(value = "/inventory/searchInventoryBinAmount",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchInventoryBinAmount(HttpServletRequest request,HttpServletResponse response,OdsInventoryInfoDtlDTO dto){
    	String result = "success";

    	//查询导出的数据总量是多少
    	Long exportAmount = seleceInventoryInfoService.getExportBinAmount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

    /**
     * @Title: exportOdsInventoryInfo
     * @Description: 导出库存报表
     * @param request
     * @param response
     * @param dto
     * @param
     * @return String
     * @throws
     */
    @RequestMapping(value = "/inventory/export")
    @ResponseBody
    public String exportOdsInventoryInfo(HttpServletRequest request, HttpServletResponse response, OdsInventoryInfoDTO dto) {
        
    	String userType=SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        dto.setUserId(userId);
        dto.setUserType(userType);
        
        response.setContentType(Servlets.EXCEL_TYPE);
		StringBuffer fileNameBuffer = new StringBuffer();
		fileNameBuffer.append("Inventory");
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		fileNameBuffer.append(fmtDate.format(new Date()));
		fileNameBuffer.append(".xlsx");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		List<OdsInventoryInfoDTO> temp = seleceInventoryInfoService.getInventoryInfoByParams(dto);
        ExcelExportTemplate<OdsInventoryInfoDTO> exportOdsInventoryInfoListTemplet = new ExportOdsInventoryInfoListTemplet(temp);
        try {
            exportOdsInventoryInfoListTemplet.doExport(response.getOutputStream(), dto);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
    /**
     * @Title: exportOdsInventoryInfo
     * @Description: 导出库存报表
     * @param request
     * @param response
     * @param dto
     * @param
     * @return String
     * @throws
     */
    @RequestMapping(value = "/inventory/exportBin", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportOdsInventoryInfo(HttpServletRequest request, HttpServletResponse response, OdsInventoryInfoDtlDTO dto) {

        String result = "success";
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("InventoryBin");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        Pager<OdsInventoryInfoDtlDTO> pager = new Pager<OdsInventoryInfoDtlDTO>();
        pager.setCurrentPage(1L);
        pager.setPageSize(25000L);

        List<OdsInventoryInfoDtlDTO> list = seleceInventoryInfoService.searchOdsInventoryBinList(1L,25000L,dto);
        ExcelExportTemplate<OdsInventoryInfoDtlDTO> template = new ExportOdsInventoryBinInfoTemplet(list);
        try {
            template.doExport(response.getOutputStream(), dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * @Title: searchFactory
    * @Description:获取所有工厂信息
    * @param @param request
    * @param @return
    * @return String
    * @throws
    */
    @RequestMapping(value = "/inventory/searchFactory", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchFactory(HttpServletRequest request) {
        List<CdFactoryDTO> rows = plantServiceClient.searchAll();
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
    }

}

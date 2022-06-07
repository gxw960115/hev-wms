package com.haier.wms.controller.stocktaking;

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

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingDiffServiceClient;
import com.haier.wms.template.stocktaking.ExportStocktakingorderDiffTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**  
 * @ClassName: StockTakingDiffController  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2015-4-20  
 */ 
@Controller
public class StockTakingDiffController {
    /**  
     * @Fields field:field:{}(dubbo暴漏出来的接口)  
     */  
    @Resource
    StocktakingDiffServiceClient stocktakingDiffServiceClient;
    
    /**  
     * @Title: selectStocktakingDiffInfo  
     * @Description: (查询)  
     * @param request
     * @param odsPdDiffDtlDTO
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingDiff/list",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectStocktakingDiffInfo(HttpServletRequest request,OdsPdDiffDtlDTO odsPdDiffDtlDTO) {
    	String userType =SessionConstants.getSession().getString("user_duty_type");
        Long userId = SessionConstants.getSession().getLong(SessionSecurityConstants.KEY_USER_ID);
        //查询用户可见范围的盘点差异
        odsPdDiffDtlDTO.setUserType(userType);
        odsPdDiffDtlDTO.setUserId(userId);
        long page = Long.parseLong(request.getParameter("page"));
        long rows = Long.parseLong(request.getParameter("rows"));
        PageBean bean = null;
        Pager<OdsPdDiffDtlDTO> outpager = stocktakingDiffServiceClient.searchStocktakingDiff(page, rows, odsPdDiffDtlDTO);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: searchStockTakingDiffAmount  
     * @Description: (查询数量)  
     * @param request
     * @param response
     * @param dto
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDiff/searchStockTakingDiffAmount",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStockTakingDiffAmount(HttpServletRequest request, HttpServletResponse response,OdsPdDiffDtlDTO dto){
    	String result = "success";
    	
    	//查询导出的数据总量是多少
    	Long exportAmount = stocktakingDiffServiceClient.searchOdsPdDiffDtlsCount(dto);
    	if (exportAmount > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: exportExcel  
     * @Description: (导出)  
     * @param odsPdDiffDtlDTO
     * @param request
     * @param response
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/stocktakingOrderDiff/export", method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody  
    public String exportExcel(OdsPdDiffDtlDTO odsPdDiffDtlDTO, HttpServletResponse response) {
        String result="success";
        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StocktakingOrderDiff");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition","attachment;filename="+fileNameBuffer.toString()); 
        
        try {
            List<OdsPdDiffDtlDTO> temp=stocktakingDiffServiceClient.getOdsPdDiffInfo(odsPdDiffDtlDTO);
            ExportStocktakingorderDiffTemplate template=new ExportStocktakingorderDiffTemplate(temp);
            template.doExport(response.getOutputStream(), odsPdDiffDtlDTO);
        } catch (Exception e) {
            e.printStackTrace();
            result="false";
        }
        return null;
    }

    @RequestMapping(value = "/stocktakingOrderDiff/lockAndUnlock", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String lockAndUnlock(String ids, String processFlag) {
        String result = stocktakingDiffServiceClient.lockAndUnlock(ids, processFlag);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

    /**  
     * @Title: getStocktakingDiffServiceClient  
     * @Description: (get)  
     * @return
     * @return StocktakingDiffServiceClient 
     * @throws  
     */  
    public StocktakingDiffServiceClient getStocktakingDiffServiceClient() {
        return stocktakingDiffServiceClient;
    }

    /**  
     * @Title: setStocktakingDiffServiceClient  
     * @Description: (set)  
     * @param stocktakingDiffServiceClient
     * @return void 
     * @throws  
     */  
    public void setStocktakingDiffServiceClient(StocktakingDiffServiceClient stocktakingDiffServiceClient) {
        this.stocktakingDiffServiceClient = stocktakingDiffServiceClient;
    }
}

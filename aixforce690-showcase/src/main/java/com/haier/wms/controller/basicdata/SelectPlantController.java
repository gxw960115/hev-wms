package com.haier.wms.controller.basicdata;

import io.terminus.common.utils.JsonMapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdFactoryDTO;
import com.haier.openplatform.wms.security.dto.PlantDTO;
import com.haier.openplatform.wms.security.service.PlantServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
* @ClassName: SelectPlantController
* @Description: 桥梁工程中，处理 工厂信息管理 相关的功能
* @author songyinglong
* @Date 2015-10-30 下午3:10:29
*/
@Controller
public class SelectPlantController {
    /**  
     * @Fields field:field:{todo}(dubbo接口)  
     */  
    @Resource
    private PlantServiceClient plantServiceClient;
    
    /**  
     * @Title: selectPlant  
     * @Description: (页面加载时查询 工厂信息)  
     * @param request
     * @param page
     * @param rows
     * @param dto
     * @return String 
     */  
    @RequestMapping(value = "/plant/list",
    method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectPlant(HttpServletRequest request, Long page, Long rows,PlantDTO dto) {
        dto.setCode(request.getParameter("plantCode"));
        dto.setName(request.getParameter("plantName"));
        PageBean bean = null;
        Pager<PlantDTO> outpager = plantServiceClient.searchPlantByParams(page, rows, dto);
        bean = PageUtil.setPager(outpager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: selectPlantList  
     * @Description: (添加功能，工厂的下拉框)  
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/plant/list/select",
    method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectPlantList() {
        List<CdFactoryDTO> list=plantServiceClient.searchAll();
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }

    /**
     * @Title: getPlantServiceClient
     * @Description: getter方法
     */
    public PlantServiceClient getPlantServiceClient() {
        return plantServiceClient;
    }

    /**
    * @Title: setPlantServiceClient
    * @Description: setter方法
    */
    public void setPlantServiceClient(PlantServiceClient plantServiceClient) {
        this.plantServiceClient = plantServiceClient;
    }
}

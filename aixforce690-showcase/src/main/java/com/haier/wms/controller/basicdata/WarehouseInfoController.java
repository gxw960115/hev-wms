package com.haier.wms.controller.basicdata;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient;
import com.haier.wms.controller.basicdata.exceltemplate.ImportWarehouseExcelTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * 仓库信息管理
 */
@Controller
public class WarehouseInfoController {
    
    @Resource
    private CdWhInfoServiceClient cdWhInfoServiceClient;

    public void setCdWhInfoServiceClient(CdWhInfoServiceClient cdWhInfoServiceClient) {
        this.cdWhInfoServiceClient = cdWhInfoServiceClient;
    }

    private static final Logger log = LoggerFactory.getLogger(WarehouseInfoController.class);
    
    /**  
     * @Title: selectWarehouseCboxList  
     * @Description: (查询 仓库code 和name)  
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/warehouse/list/cbox",
    		method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectWarehouseCboxList() {
        List<CdWhInfoDTO> list=cdWhInfoServiceClient.searchWhInfo();
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**
     * @Title: searchAvailableWh  
     * @Description: (查询 仓库code 和name)  
     * @return String 
     */
    @RequestMapping(value = "/warehouse/searchAvailableWh",
    	    method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchAvailableWh() {
    	BaseUser user = UserUtil.getCurrentUser();
        List<CdWhInfoDTO> list = cdWhInfoServiceClient.searchAvailableWh(user.getId());
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**  
     * @Title: selectPhysicalWhList  
     * @Description: (查询物理仓库code 和name)  
     * @return String 
     */  
    @RequestMapping(value = "/warehouse/list/physicalWh",
    		method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectPhysicalWhList() {
        List<CdWhInfoDTO> list=cdWhInfoServiceClient.searchPhysicalWhInfo();
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**  
     * @Title: SEARCHAVAILABLEPHYWH  
     * @Description: (查询物理仓库code 和name)  
     * @return String 
     */  
    @RequestMapping(value = "/warehouse/searchAvailablePhyWh",
    		method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchAvailablePhyWh() {
    	BaseUser user = UserUtil.getCurrentUser();
        List<CdWhInfoDTO> list=cdWhInfoServiceClient.searchAvailablePhyWh(user.getId());
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**  
     * @Title: SEARCHAVAILABLEPHYWHGAP  
     * @Description: (查询物理仓库code 和name)  
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/warehouse/searchAvailablePhyWhGap",
    		method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchAvailablePhyWhGap() {
    	BaseUser user = UserUtil.getCurrentUser();
        List<CdWhInfoDTO> list=cdWhInfoServiceClient.searchAvailablePhyWhGap(user.getId());
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**  
     * @Title: getAllwhInfo  
     * @Description: (查询仓库信息)  
     * @param request
     * @param page
     * @param rows
     * @param whinfo
     * @return String 
     */  
    @RequestMapping(value = "/warehouse/getAllwhInfo", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody 
    public String getAllwhInfo(Long page, Long rows, CdWhInfoDTO  whinfo){
    	 PageBean bean = null;
         Pager<CdWhInfoDTO> pager = cdWhInfoServiceClient.searchCdWhInfos(page, rows, whinfo);
         bean = PageUtil.setPager(pager);
    	 return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: importMdMatInfo  
     * @Description: (导入仓库信息)  
     * @param request
     * @throws Exception
     * @return String 
     */  
    @RequestMapping(value = "/warehouse/importWarehouseInfo",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String importMdMatInfo(MultipartHttpServletRequest request) throws Exception {
        BaseUser user = UserUtil.getCurrentUser();
    	
        // 获得文件
        Iterator<String> fileNames = request.getFileNames();
        String str = "";
        while (fileNames.hasNext()) {
            String name = fileNames.next();
            MultipartFile file = request.getFile(name);
            ImportWarehouseExcelTemplate importWarehouseExcelTemplate = new ImportWarehouseExcelTemplate();
            try {
				byte[] imageData = file.getBytes();
				List<CdWhInfoDTO> list = importWarehouseExcelTemplate.importInfo(imageData, user.getName());
				str = cdWhInfoServiceClient.saveOrUpdate(list, user);
			} catch (Exception e) {
				log.debug("Exception:",e);
				str = "import fail";
			}
        }
        return str;
	}
    
    /**  
     * @Title: download  
     * @Description: (下载导入模版)  
     * @param request
     * @throws IOException
     * @return ResponseEntity<byte[]> 
     */  
    @RequestMapping("/warehouse/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        // 获得路径
        String path = request.getSession().getServletContext().getRealPath("/")
                + "/template/Warehouse import template.xls";
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        // 为了解决中文名称乱码问题
        String fileName = new String("Warehouse import template.xls".getBytes("UTF-8"), "UTF-8");
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // ie不支持201状态码，改为200
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

}

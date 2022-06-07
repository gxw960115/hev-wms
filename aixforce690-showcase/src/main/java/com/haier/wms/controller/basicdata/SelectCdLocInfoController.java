package com.haier.wms.controller.basicdata;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.LocTreeDTO;
import com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient;
import com.haier.wms.controller.basicdata.exceltemplate.ImportLocationExcelTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * @ClassName: SelectCdLocInfoController
 * @Description: 库存地点相关基础数据的请求分发
 * @author:
 */
@Controller
public class SelectCdLocInfoController {
	
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
	private CdLocInfoServiceClient cdLocInfoServiceClient;
	
	/**  
	 * @Fields field:field:{}(log)  
	 */  
	private static final Logger log = LoggerFactory.getLogger(SelectCdLocInfoController.class);
    
	public CdLocInfoServiceClient getCdLocInfoServiceClient() {
		return cdLocInfoServiceClient;
	}

	public void setCdLocInfoServiceClient(
			CdLocInfoServiceClient cdLocInfoServiceClient) {
		this.cdLocInfoServiceClient = cdLocInfoServiceClient;
	}
	
    /**  
     * @Title: getAllLocInfo  
     * @Description: (查询仓库地点)  
     * @param request
     * @param page
     * @param rows
     * @param cdLocInfo
     * @return
     * @throws  
     */  
    @RequestMapping(value = "/location/getAllLocInfo",   method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody 
    public String getAllLocInfo(HttpServletRequest request, Long page,
            Long rows,CdLocInfoDTO  cdLocInfo){
    	 PageBean bean = null;
         Pager<CdLocInfoDTO> pager = null;
//         pager.setPageSize(rows);
//         pager.setCurrentPage(page);
         pager = cdLocInfoServiceClient.searchCdLocInfoByCondition(rows, page, cdLocInfo);
         bean = PageUtil.setPager(pager);
    			return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: importMdMatInfo  
     * @Description: (导入库位信息)  
     * @param request
     * @return
     * @throws Exception
     * @throws  
     */  
    @RequestMapping(value = "/location/importLocationInfo",
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
            ImportLocationExcelTemplate importLocationExcelTemplate = new ImportLocationExcelTemplate();
            try {
				byte[] imageData = file.getBytes();
				List<CdLocInfoDTO> list = importLocationExcelTemplate.importInfo(imageData, user.getName());
				//String mess = importMdExcelTemplate.importMdMatInfo(imageData);
				str = cdLocInfoServiceClient.saveOrUpdate(list, user);
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
     * @return
     * @throws IOException
     * @throws  
     */  
    @RequestMapping("/location/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request)
            throws IOException {
        // 获得路径
        String path = request.getSession().getServletContext().getRealPath("/")
                + "/template/Location import template.xls";
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
     // 为了解决中文名称乱码问题
        String fileName = new String("Location import template.xls".getBytes("UTF-8"), "UTF-8");
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // ie不支持201状态码，改为200
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
    
    
	 /**
     * @Title: createLocInfo
     * @Description: 添加库存地点信息请求 (这里用一句话描述这个类的作用)
     * @param @param dto
     * @return JSONObject
     * @throws
     */
    @RequestMapping(value = "/loc/saveLocInfo", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String createLocInfo(CdLocInfoDTO dto) {
        dto.setModifyBy(UserUtil.getCurrentUser().getName());
        String flag = cdLocInfoServiceClient.createLocInfos(dto);
        return flag;

    }
    
    /**
     * @Title: selectLocInfo
     * @Description: 库存地点查询请求 (这里用一句话描述这个类的作用)
     * @param @param request
     * @param @param page
     * @param @param rows
     * @param @param dto
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/loc/search", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectLocInfo(HttpServletRequest request, Long page,
            Long rows, CdLocInfoDTO dto) {
        PageBean bean = null;
        Pager<CdLocInfoDTO> pager = new Pager<CdLocInfoDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = cdLocInfoServiceClient.searchCdLocInfo(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**
     * @Title: deleteLocInfo
     * @Description: 库存地点信息删除
     * @param @param ids
     * @param @return
     * @return JSONObject
     * @throws
     */
    @RequestMapping(value = "/loc/delete", method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String deleteLocInfo(String ids) {
        List<Long> idList = new ArrayList<Long>();
        for (String cdLocInfoId : StringUtils.split(ids, ",")) {
            if (StringUtils.isEmpty(cdLocInfoId)) {
                continue;
            }
            idList.add(Long.valueOf(cdLocInfoId));
        }
        String result = cdLocInfoServiceClient.deleteLocInfo(idList);
        return result;
    }
    
    /**
     * @Title: updateLocInfo
     * @Description: 更新库存地点请求分发 (这里用一句话描述这个类的作用)
     * @param @param locInfoDTO
     * @param @return
     * @return String
     * @throws
     */

    @RequestMapping(value = "/loc/update", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String updateLocInfo(CdLocInfoDTO dto) {
        dto.setModifyBy(UserUtil.getCurrentUser().getName());
        String flag = cdLocInfoServiceClient.updateLocInfo(dto);
    	return flag;
    };

    /**  
    * @Title: selectPhysicalLoc  
    * @Description: (这里用一句话描述这个方法的作用)  
    * @author zhangll
    * @param request
    * @param dto
    * @return String
    * @throws  
    */
    @RequestMapping(value = "/loc/select/physicalLoc", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectPhysicalLoc(HttpServletRequest request,CdWhInfoDTO dto) {
    	List<CdLocInfoDTO> temp=cdLocInfoServiceClient.selectPhysicalLoc(dto.getRowId());
        List<LocTreeDTO> list=new ArrayList<LocTreeDTO>();
        for(CdLocInfoDTO d:temp){
            LocTreeDTO t=new LocTreeDTO();
            t.setId(d.getCode());
            t.setText(d.getName());
            list.add(t);
        }
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**  
     * @Title: selectLocTree  
     * @Description: (stocktakingOrder的add功能，需要根据warehouse级联显示location的下拉框)  
     * @param request
     * @param dto
     * @return
     * @throws  
     */  
    @RequestMapping(value = "/loc/select/tree", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectLocTree(HttpServletRequest request,CdWhInfoDTO dto, String locType) {
        List<CdLocInfoDTO> temp=cdLocInfoServiceClient.selectLocTree(dto.getRowId(), locType);
//        CdLocInfoDTO d=temp.get(0);
        List<LocTreeDTO> list=new ArrayList<LocTreeDTO>();
        for(CdLocInfoDTO d:temp){
            LocTreeDTO t=new LocTreeDTO();
            t.setId(d.getCode());
            t.setText(d.getName());
            list.add(t);
        }
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**  
    * @Title: selectLocTreeWithType  
    * @Description: 根据locationType选择库位,locationType为空代表查询全部
    * @author: ZhangLL
    * @param request
    * @param dto
    * @return String
    * @throws  
    */
    @RequestMapping(value = "/loc/select/treeWithType", method = RequestMethod.POST,
    		produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectLocTreeWithType(HttpServletRequest request,CdLocInfoDTO dto) {
    	List<CdLocInfoDTO> temp = cdLocInfoServiceClient.selectLocTreeWithType(dto);
    	List<LocTreeDTO> list = new ArrayList<LocTreeDTO>();
    	for(CdLocInfoDTO d:temp){
    		LocTreeDTO t=new LocTreeDTO();
    		t.setId(d.getCode());
    		t.setText(d.getName());
    		list.add(t);
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    @RequestMapping(value = "/loc/select/treeWithLocation", method = RequestMethod.POST,
    		produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectLocTreeWithLocation(HttpServletRequest request,CdLocInfoDTO dto) {
    	List<CdLocInfoDTO> temp = cdLocInfoServiceClient.selectLocTreeWithLocation(dto);
    	List<LocTreeDTO> list = new ArrayList<LocTreeDTO>();
    	for(CdLocInfoDTO d:temp){
    		LocTreeDTO t=new LocTreeDTO();
    		t.setId(d.getCode());
    		t.setText(d.getName());
    		list.add(t);
    	}
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
    
    /**  
     * @Title: cdLocTree  
     * @Description: (获取库存地点树)  
     * @param request
     * @param dto
     * @return
     * @throws  
     */  
    @RequestMapping(value = "/loc/select/cdLocTree", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String cdLocTree(HttpServletRequest request,CdWhInfoDTO dto) {
//    	String rowId= request.getParameter("rowId");
    	List<CdLocInfoDTO> temp = cdLocInfoServiceClient.getCdLocInfosByParentId(dto.getRowId());		 	 
        List<LocTreeDTO> list=new ArrayList<LocTreeDTO>();
        for(CdLocInfoDTO d:temp){
             LocTreeDTO t=new LocTreeDTO();
             t.setId(d.getRowId().toString());
             t.setText(d.getName());
             t.setChecked(d.isChecked());
             list.add(t);
         }
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
	}
	
    /**  
     * @Title: cdLocTreeByParentId  
     * @Description: (根据父id得到库存地点树)  
     * @param request
     * @param dto
     * @return
     * @throws  
     */  
    @RequestMapping(value = "/plan/cdLocTreeByParentId", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String cdLocTreeByParentId(HttpServletRequest request,CdLocInfoDTO dto) {
        dto.setLocationType("0");
		List<CdLocInfoDTO> list=cdLocInfoServiceClient.getCdTreeByParentId(Long.parseLong(request.getParameter("parentId")),dto.getLocationType());		 	 
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }

    /**
     * 获取Location列表,作为页面的查询条件
     * @author: LJZ
     */
    @RequestMapping(value = "/loc/getLocationList", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getLocationList(CdLocInfoDTO dto) {
        List<CdLocInfoDTO> cdLocInfoManyColumn = cdLocInfoServiceClient.getCdLocInfoManyColumn(dto);
        List<LocTreeDTO> list = new ArrayList<LocTreeDTO>();
        for (CdLocInfoDTO d : cdLocInfoManyColumn) {
            LocTreeDTO t = new LocTreeDTO();
            t.setId(d.getCode());
            t.setText(d.getName());
            list.add(t);
        }
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }
}

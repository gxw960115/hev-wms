package com.haier.wms.controller.basicdata;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
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

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.basicdata.service.MdmathInfoServiceClient;
import com.haier.wms.controller.basicdata.exceltemplate.ExportMdMatInfoListTemplet;
import com.haier.wms.controller.basicdata.exceltemplate.ImportMdExcelTemplate;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

/**
 * @Company 青鸟软通
 * @Title:SeclectMdmatInfoController
 * @Package com.haier.wms.controller.basicdata
 * @author sunhaoyu
 * @date 2015/10/26
 * @version V1.0
 */

@Controller
public class SeclectMdmatInfoController {

	private static final Logger logger = Logger.getLogger(SeclectMdmatInfoController.class);
	
    @Resource
    private MdmathInfoServiceClient seleceMaterialInfoService;
    
    public MdmathInfoServiceClient getSeleceMaterialInfoService() {
        return seleceMaterialInfoService;
    }

    public void setSeleceMaterialInfoService(
            MdmathInfoServiceClient seleceMaterialInfoService) {
        this.seleceMaterialInfoService = seleceMaterialInfoService;
    }

    /**
     * @Title: createMaterialInfo
     * @Description: 添加物料信息请求
     * @param @param dto
     * @param @return
     * @return JSONObject
     * @throws
     */
    @RequestMapping(value = "/api/saveMamdtInfo", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String createMaterialInfo(MdMatInfoDTO dto) {
        BaseUser user = UserUtil.getCurrentUser();
        String name = user.getName();
        Date date = new Date();
        dto.setCreatedBy(name);
        dto.setCreatedDate(date);
        dto.setModifyBy(name);
        dto.setModifyDate(date);
        dto.setActivestate("0");
        dto.setVersion(0L);
        dto.setInOut("0");
        String flag = seleceMaterialInfoService.createMdmatInfos(dto);
        return flag;

    }

    /**
     * @Title: selectCountry
     * @Description: 物料查询请求 (这里用一句话描述这个类的作用)
     * @param @param request
     * @param @param page
     * @param @param rows
     * @param @param dto
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/api/search", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectCountry(HttpServletRequest request, Long page,
            Long rows, MdMatInfoDTO dto) {
        PageBean bean = null;
        Pager<MdMatInfoDTO> pager = new Pager<MdMatInfoDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        pager = seleceMaterialInfoService.searchMdmaInfo(pager, dto);
        bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }

    /**
     * @Title: deleteMdmatInfo
     * @Description: 物料信息删除
     * @param @param ids
     * @param @return
     * @return JSONObject
     * @throws
     */
    @RequestMapping(value = "/api/delete", method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String deleteMdmatInfo(String ids) {
        List<Long> idList = new ArrayList<Long>();
        for (String mdMatInfoId : StringUtils.split(ids, ",")) {
            if (StringUtils.isEmpty(mdMatInfoId)) {
                continue;
            }
            idList.add(Long.valueOf(mdMatInfoId));
        }
        String result = seleceMaterialInfoService.deleteMdmatInfo(idList);
        return result;
    }

    /**
     * @Title: updateMamdtInfo
     * @Description: 更新物料请求分发 (这里用一句话描述这个类的作用)
     * @param @param mdMatInfoDTO
     * @param @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/api/update", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String updateMamdtInfo(MdMatInfoDTO mdMatInfoDTO) {
        logger.debug("Entering updateMamdtInfo...");
        BaseUser user = UserUtil.getCurrentUser();
        mdMatInfoDTO.setModifyBy(user.getName());
        String flag = seleceMaterialInfoService.updateMdmatInfo(mdMatInfoDTO);
        return flag;
    };
    
    /**  
     * @Title: exportOdsContractInfo  
     * @Description: (物料导出)  
     * @param response
     * @param request
     * @param dto
     * @return
     * @throws Exception
     * @throws  
     */  
    @RequestMapping(value = "/material/exportMaterialInfo")
    @ResponseBody
    public String exportOdsContractInfo(HttpServletResponse response,HttpServletRequest request, MdMatInfoDTO dto) throws Exception {
    	
    	response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("Materials");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
       
    	
    	String flag = "success";
        List<MdMatInfoDTO> temp =  seleceMaterialInfoService.getMdMatInfoByParam(dto);
        ExcelExportTemplate<MdMatInfoDTO> exportMdMatInfoListTemplet = new ExportMdMatInfoListTemplet(temp);
       
        try {
			exportMdMatInfoListTemplet.doExport(response.getOutputStream(),
					dto == null ? new MdMatInfoDTO() : dto);
        } catch (Exception e) {
            e.printStackTrace();
            flag = "failure";
        }
        return null;
    }

    /**  
     * @Title: importMdMatInfo  
     * @Description: (物料导入)  
     * @param request
     * @return
     * @throws Exception
     * @throws  
     */  
    @RequestMapping(value = "/material/importMaterialInfo",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String importMdMatInfo(MultipartHttpServletRequest request) throws Exception {
        BaseUser user = UserUtil.getCurrentUser();
    	
        // 获得文件
        Iterator<String> fileNames = request.getFileNames();
        String str = "";
        while (fileNames.hasNext()) {
            String name = fileNames.next();
            MultipartFile file = request.getFile(name);
            ImportMdExcelTemplate importMdExcelTemplate = new ImportMdExcelTemplate();
	        try {
				byte[] imageData = file.getBytes();
				List<MdMatInfoDTO> list = importMdExcelTemplate.importMdMatInfo(imageData, user.getName());
				str = seleceMaterialInfoService.importMaterialInfo(list, user);
			} catch (Exception e) {
				logger.error("Exception:",e);
				str = "import fail";
			}
        }
        return str;

	}
    
    /**  
     * @Title: download  
     * @Description: (下载导入模板)  
     * @param request
     * @return
     * @throws IOException
     * @throws  
     */  
    @RequestMapping("/material/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        // 获得路径
        String path = request.getSession().getServletContext().getRealPath("/") + "/template/Materail import template.xls";
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        String fileName = new String("Materail import template.xls".getBytes("UTF-8"), "UTF-8");// 为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // ie不支持201状态码，改为200
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
    
    /**  
     * @Title: downloadData  
     * @Description: TODO(从MDM获取物料)  
     * @return
     * @throws  
     */  
    @RequestMapping(value = "/basic/downloadData",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String downloadData(String materialNo) {
    	BaseUser user = UserUtil.getCurrentUser();
        InterfaceOutDTO result = seleceMaterialInfoService.downloadData(user, materialNo);

        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
}

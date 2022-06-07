package com.haier.wms.controller.basicdata;

import io.terminus.common.utils.JsonMapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
import com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

@Controller
public class MdDictionaryController {
    @Resource
    private MdDictionaryServiceClient mdDictionaryServiceClient;

    public void setMdDictionaryServiceClient(MdDictionaryServiceClient mdDictionaryServiceClient) {
        this.mdDictionaryServiceClient = mdDictionaryServiceClient;
    }

    /**
     * @Title: findDivisions  
     * @Description: (获取所有的产品大类)  
     * @param @return 
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/basicdata/mddictionary/listbox", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String findDivisions(){
        List<MdDictionaryDTO> list=mdDictionaryServiceClient.findDivisions();
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }

    /**  
    * @Title: searchAllDictionary  
    * @Description: 查询字典信息
    * @author: ZhangLL
    * @param request
    * @param type
    * @return String
    * @throws  
    */
    @RequestMapping(value = "/plan/searchAllDictionary",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchAllDictionary(HttpServletRequest request, String type) {
        List<MdDictionaryDTO> rows = mdDictionaryServiceClient.searchAllDictionInfo(type);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
    }
     
    /**  
     * @Title: searchAllDictionInfo  
     * @Description: (查询所有的有效字典)  
     * @param request
     * @param page
     * @param rows
     * @param mdDictionaryDTO
     * @return
     * @throws  
     */  
    @RequestMapping(value = "/basic/mdDictionary", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchAllDictionInfo(HttpServletRequest request, Long page,
            Long rows,MdDictionaryDTO mdDictionaryDTO ){
    	 PageBean bean = null;
         Pager<MdDictionaryDTO> pager = new Pager<MdDictionaryDTO>();
         pager.setPageSize(rows);
         pager.setCurrentPage(page);
         pager = mdDictionaryServiceClient.getAllMdDictionarys(page,rows, mdDictionaryDTO);
         bean = PageUtil.setPager(pager);
         return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    
    /**  
     * @Title: findAllKindType  
     * @Description: (查询所有的有效字典类型)  
     * @param @return
     * @return String
     * @throws  
     */  
    @RequestMapping(value = "/basic/findAllKindType", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String findAllKindType() {
		List<MdDictionaryDTO> rows = mdDictionaryServiceClient.findAllKindType();
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(rows);
	}
    
    /**  
     * @Title: deleteDictionaryInfo  
     * @Description: (删除一条或多条字典维护查询)  
     * @param @param ids
     * @param @return 
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/basic/mdDictionary/delete", method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String deleteDictionaryInfo(String ids) {
        List<Long> idList = new ArrayList<Long>();
        for (String id : StringUtils.split(ids, ",")) {
            if (StringUtils.isEmpty(id)) {
                continue;
            }
            idList.add(Long.valueOf(id));
        }
        return  mdDictionaryServiceClient.deleteDictionarys(idList);
    }

}

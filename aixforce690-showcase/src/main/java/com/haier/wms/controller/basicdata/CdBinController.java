package com.haier.wms.controller.basicdata;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.bin.dto.CdBinDTO;
import com.haier.openplatform.wms.bin.service.CdBinServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import io.terminus.common.utils.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CdBinController {
    @Resource
    private CdBinServiceClient cdBinServiceClient;

    public CdBinServiceClient getCdBinServiceClient() {
        return cdBinServiceClient;
    }
    public void setCdBinServiceClient(CdBinServiceClient cdBinServiceClient) {
        this.cdBinServiceClient = cdBinServiceClient;
    }

    @RequestMapping(value = "/bin/list",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String selectPlant(HttpServletRequest request, Long page, Long rows, CdBinDTO dto) {
        dto.setCode(request.getParameter("binCode"));
        dto.setLocation(request.getParameter("binLocation"));
        PageBean bean = null;
        try {
            Pager<CdBinDTO> outpager = cdBinServiceClient.getBins(page, rows, dto);
            bean = PageUtil.setPager(outpager);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
    @RequestMapping(value = "/bin/save",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String save(CdBinDTO dto) {
        if (dto != null){
            dto.setCreateDate(new Date());
            dto.setUpdateDate(new Date());
            if (StringUtils.equals(dto.getFlag(),"enable")){
                dto.setFlag("1");
            }else {
                dto.setFlag("0");
            }
        }
        String result = "";
        try {
             result = cdBinServiceClient.addBin(dto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/bin/update",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String update(CdBinDTO dto) {
        if (dto != null){
            dto.setUpdateDate(new Date());
            if (StringUtils.equals(dto.getFlag(),"enable")){
                dto.setFlag("1");
            }else {
                dto.setFlag("0");
            }
        }
        String result = "";
        try {
            result = cdBinServiceClient.updateBin(dto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/bin/delete",
            method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String delete(String ids) {
        List<String> idList = new ArrayList<String>();
        if (StringUtils.isNotBlank(ids)){
            idList = Arrays.asList(ids.split(","));
        }
        try {
            this.cdBinServiceClient.deleteBins(idList);
            return "success";
        }catch (Exception e){
            return "delete failure,msg:"+e.getMessage();
        }
    }

    @RequestMapping(value = "/bin/getBinByLocation", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getBinByLocation(Long page, Long rows, CdBinDTO dto) {

        String location = dto.getLocation();
        Pager<CdBinDTO> bins = cdBinServiceClient.getBinByLocation(page, rows, location);
        PageBean pageBean = PageUtil.setPager(bins);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(pageBean);
    }

    /**
     * 模糊查询BIN
     * @param page
     * @param rows
     * @param dto
     * @return
     */
    @RequestMapping(value = "/bin/getBinByCode", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getBinByCode(Long page, Long rows, CdBinDTO dto) {

        String location = dto.getLocation();
        String bin = dto.getCode();
        Pager<CdBinDTO> bins = cdBinServiceClient.getBinByCode(page, rows, location, bin);
        PageBean pageBean = PageUtil.setPager(bins);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(pageBean);
    }
}

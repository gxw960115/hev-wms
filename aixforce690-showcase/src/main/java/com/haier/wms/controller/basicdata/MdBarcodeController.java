package com.haier.wms.controller.basicdata;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO;
import com.haier.openplatform.wms.basicdata.dto.MdBarcodeDTO;
import com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: MdBarcodeController.java
 * @description: (Barcode 查询分页 以及创建功能)
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月29日 下午3:01:54
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月29日		LJZ			v1.0.0			create
 */
@Controller
public class MdBarcodeController {
	
	@Resource
	private MdBarcodeServiceClient mdBarcodeServiceClient;
	@Resource
    private PsiReportServiceClient psiReportServiceClient;
	
	/**
	* @Title: searchBarCodes
	* @Description: (查询条码)
	* @param @param request
	* @param @param page
	* @param @param rows
	* @param @param dto
	* @return String 返回类型
	*/ 
	@RequestMapping(value = "/api/searchBarcodes", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String searchBarCodes(Long page, Long rows, MdBarcodeDTO dto){
		if (dto == null) {
			dto = new MdBarcodeDTO();
		}
		Pager<MdBarcodeDTO> pager = new Pager<MdBarcodeDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = mdBarcodeServiceClient.searchBarcodes(pager, dto);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}

	/**
	* @Title: searchGiftBarcodes
	* @Description: (查询条码)
	* @param @param request
	* @param @param page
	* @param @param rows
	* @param @param dto
	* @return String 返回类型
	*/ 
	@RequestMapping(value = "/api/searchGiftBarcodes", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String searchGiftBarcodes(Long page, Long rows, GiftBarcodeDTO dto){
		if (dto == null) {
			dto = new GiftBarcodeDTO();
		}
		Pager<GiftBarcodeDTO> pager = new Pager<GiftBarcodeDTO>();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		pager = mdBarcodeServiceClient.searchGiftBarcodes(pager, dto);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	@RequestMapping(value = "/api/modifyBarcodeBin", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String modifyBarcodeBin(String plant,String location,String barcode,String bin){

		OrderUploadInDTO inpara = new OrderUploadInDTO();
		inpara.setBarcode(barcode);
		inpara.setPlant(plant);
		inpara.setBin(bin);
		inpara.setLocation(location);

		OrderUploadOutDTO outResult = mdBarcodeServiceClient.modifyBarcodeBin(inpara);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	@RequestMapping(value = "/api/initUserPlantAndLoc", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String initUserPlantAndLoc(String username,String plantId) {
		OrderUploadInDTO inParam = new OrderUploadInDTO();
		inParam.setUser(username);
		inParam.setPlant(plantId);

		//调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = mdBarcodeServiceClient.initUserPlantAndLoc(inParam);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	* @Title: addBarcodes
	* @Description: (新增条码)
	* @param @param request
	* @param @param page
	* @param @param rows
	* @param @param dto
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping(value = "/api/addBarcodes", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String addBarcodes(String materialNo,String materialDesp,String barCodeNum,String productLine) throws Exception{
		// 构造后台对象
		MdBarcodeDTO dto = new MdBarcodeDTO();
		dto.setMaterialNo(materialNo);
		dto.setMaterialDesp(materialDesp);
		if(barCodeNum == null){
			barCodeNum = "1";
		}
		dto.setBarcodeNum(Long.parseLong(barCodeNum));
		dto.setProductLine(productLine);
		dto.setCreateBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		// 调用UBBO接口
		String flag = mdBarcodeServiceClient.createBarcodes(dto);
		return flag;
	}
	
	/**
	* @Title: addBarcodes
	* @Description: (新增条码)
	* @param @param request
	* @param @param page
	* @param @param rows
	* @param @param dto
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping(value = "/api/addGiftBarcode", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
	public String addGiftBarcode(String materialNo,String materialDesp) throws Exception{
		// 构造后台对象
		GiftBarcodeDTO dto = new GiftBarcodeDTO();
		dto.setMaterialNo(materialNo);
		dto.setMaterialDesp(materialDesp);

		dto.setCreateBy(SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME));
		// 调用UBBO接口
		String flag = mdBarcodeServiceClient.createGiftBarcode(dto);
		return flag;
	}
	
	/**  
	 * @Title: searchMdBarcode  
	 * @Description: (查询条码)  
	 * @param @param request
	 * @param @param page
	 * @param @param rows
	 * @param @param dto
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */  
	@RequestMapping(value = "/mdBarcode/search", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchMdBarcode(Long page, Long rows, MdBarcodeDTO dto) {
		if (dto == null) {
			dto = new MdBarcodeDTO();
		}
		Pager<MdBarcodeDTO> outPager = mdBarcodeServiceClient.searchMdBarcode(page, rows, dto);
		PageBean bean = PageUtil.setPager(outPager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }
	
	/**  
	 * @Title: printBarcode  
	 * @Description: (打印条码)  
	 * @param @param request
	 * @param @param response
	 * @param @param barcodes
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */  
	@RequestMapping(value ="/barcode/print")
    public String printBarcode(HttpServletRequest request,HttpServletResponse response,String barcodes, String matType) {
        String path;
        byte[] bytes;
        // 报表数据源
        String[] bars = barcodes.split(",");
        StringBuffer barcode = new StringBuffer();
    	// 此处为 拼数据库SQL语句，增加 where 条件中的 in ('XXX', 'XXX')
    	if(bars.length>0) {
    		for(int i=0;i<bars.length;i++){
    			barcode.append("'").append(bars[i]).append("'");
    			if(i!=bars.length-1){
    				barcode.append(",");
    			}
    		}
    	}
        Map<String,Object> parameter = new HashMap<String,Object>();  
        parameter.put("barcode", barcode.toString());
        if ("CBU".equals(matType)){
        	path = request.getSession().getServletContext().getRealPath("/")
                    + "/pdf/small_barcode.jasper";
        } else {
        	path = request.getSession().getServletContext().getRealPath("/")
                    + "/pdf/gift_barcode.jasper";
        }
        
        File reportFile = new File(path);
        try {
            response.setContentType("application/pdf");
            ServletOutputStream outStream;
            bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameter);
            outStream = response.getOutputStream();
            if (bytes != null) {
                response.setContentLength(bytes.length);
                outStream.write(bytes, 0, bytes.length);
            }
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**  
	 * @Title: printOriginalBarcode  
	 * @Description: (打印自定义条码)  
	 * @param @param request
	 * @param @param response
	 * @param @param barcodes
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */  
	@RequestMapping(value ="/originalbarcode/print")
    public String printOriginalBarcode(HttpServletRequest request,HttpServletResponse response,String barcodes) {
        // 报表数据源
        String[] bars=barcodes.split(",");
        String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);
        for(int i=0;i<bars.length;i++){
        	if(!mdBarcodeServiceClient.existBarcode(bars[i])){
        		mdBarcodeServiceClient.insert(bars[i], userName);
        	}
        }
        printBarcode(request, response, barcodes, "CBU");
        return null;
    }
	
	public void setMdBarcodeServiceClient(
			MdBarcodeServiceClient mdBarcodeServiceClient) {
		this.mdBarcodeServiceClient = mdBarcodeServiceClient;
	}

	public void setPsiReportServiceClient(
			PsiReportServiceClient psiReportServiceClient) {
		this.psiReportServiceClient = psiReportServiceClient;
	}
}

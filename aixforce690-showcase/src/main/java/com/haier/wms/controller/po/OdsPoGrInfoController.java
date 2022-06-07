package com.haier.wms.controller.po;

import io.terminus.common.utils.JsonMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
import com.haier.openplatform.wms.po.service.OdsPoGrInfoServiceClient;
import com.haier.wms.exceltemplate.po.ExportOdsPoGrInfoListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoGrInfoController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午2:50:50
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

@Controller
public class OdsPoGrInfoController {
	@Resource
	private OdsPoGrInfoServiceClient odsPoGrInfoServiceClient;

	public void setOdsPoGrInfoServiceClient(OdsPoGrInfoServiceClient odsPoGrInfoServiceClient) {
		this.odsPoGrInfoServiceClient = odsPoGrInfoServiceClient;
	}

	@RequestMapping(value = "/po/searchOdsPoGrInfo",
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOdsPoGrInfo(Long page, Long rows, OdsPoGrInfoDTO dto){
		Pager<OdsPoGrInfoDTO> pager = odsPoGrInfoServiceClient.searchOdsPoGrInfoListByPage(page,rows,dto);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	@RequestMapping(value = "/po/searchPoGrInfoAmount",
		method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportCount(OdsPoGrInfoDTO dto){
		String result = "success";
		Long size = odsPoGrInfoServiceClient.getExportAmount(dto);
		if (size > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	@RequestMapping(value = "/po/exportPoGrInfo",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getPoGrInfoList(HttpServletRequest request,HttpServletResponse response,OdsPoGrInfoDTO dto){
		String flag = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("PoGrInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		List<OdsPoGrInfoDTO> list = odsPoGrInfoServiceClient.getOdsPoGrInfoListByParm(dto);
		ExcelExportTemplate<OdsPoGrInfoDTO> listTemplet = new ExportOdsPoGrInfoListTemplet(list);
		try {
			listTemplet.doExport(response.getOutputStream(), dto == null?new OdsPoGrInfoDTO():dto);
		} catch (Exception e) {
			e.printStackTrace();
            flag = "failture";
            return flag;
		}
		return null;
	}
	
	@RequestMapping(value = "/po/printDn")
	@ResponseBody
	public String printDn(HttpServletRequest request,
			HttpServletResponse response, String msg) {
		
		List<OdsPoGrInfoDTO> list = JSON.parseArray(msg, OdsPoGrInfoDTO.class);
		int total = 0;
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
        	String pdfFilePath = request.getSession().getServletContext().getRealPath("/")+"/pdf/dn_print.pdf";
//        	String jpgFilePath = request.getSession().getServletContext().getRealPath("/")+"/pdf/dn_print.jpg";
            PdfReader reader = new PdfReader(pdfFilePath);
            PdfStamper stamper = new PdfStamper(reader, ba);
//	        Image img = Image.getInstance(jpgFilePath);
//	        img.setAbsolutePosition(0,0);
//	        img.scaleToFit(reader.getPageSize(1).getWidth(),reader.getPageSize(1).getHeight());
//	        PdfContentByte under = stamper.getUnderContent(1);
//	        under.addImage(img,img.getScaledWidth(),0,0,img.getScaledHeight(),0,0);
//	        under.addImage(img);
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED); 
            AcroFields form = stamper.getAcroFields();
            form.addSubstitutionFont(bf);
            
            for (int i = 0; i<list.size(); i++){
            	OdsPoGrInfoDTO temp = list.get(i);
            	if (i == 0){
                    form.setField("FORM_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    form.setField("FORM_REQUEST_TO", "");
                    form.setField("FORM_FROM", "");
                    form.setField("FORM_ADDRESS_FROM", "");
                    form.setField("FORM_TO", "");
                    form.setField("FORM_ADDRESS_TO", "");
                    form.setField("FORM_TRANS", temp.getTransporterCode());
                    form.setField("FORM_CAR", temp.getCarNo());
            	}
                form.setField("DETAIL_GOOD"+(i+1),temp.getMaterialNo()+":"+temp.getMaterialDesp());
                form.setField("DETAIL_QTY"+(i+1), String.valueOf(temp.getScannedQty()));
                total += temp.getScannedQty();
            }
            form.setField("DETAIL_TOTAL_QTY", String.valueOf(total));
            stamper.setFormFlattening(true);

            stamper.close();
            response.setContentType("application/pdf");
            response.setContentLength(ba.size());
            ServletOutputStream out = response.getOutputStream();
            ba.writeTo(out);
            out.flush();
            out.close();
            ba.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
	}
}

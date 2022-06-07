package com.haier.wms.controller.so;

import com.alibaba.fastjson.JSON;
import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.service.OdsSoGrInfoServiceClient;
import com.haier.openplatform.wms.so.service.StgDnDownServiceClient;
import com.haier.wms.exceltemplate.so.ExportOdsSoGrInfoListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import io.terminus.common.utils.JsonMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoGrInfoController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月18日 下午6:31:59
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月18日		LJZ			v1.0.0			create
 */

@Controller
public class OdsSoGrInfoController {

    private static final Logger log = LoggerFactory.getLogger(OdsSoGrInfoController.class);

	@Resource
	private OdsSoGrInfoServiceClient odsSoGrInfoServiceClient;
	
	@Resource
	private StgDnDownServiceClient stgDnDownServiceClient;

    @Resource
    private PsiReportServiceClient psiReportServiceClient;

    @Resource
    private CdLocInfoServiceClient cdLocInfoServiceClient;

    public void setOdsSoGrInfoServiceClient(OdsSoGrInfoServiceClient odsSoGrInfoServiceClient) {
        this.odsSoGrInfoServiceClient = odsSoGrInfoServiceClient;
    }

    public void setStgDnDownServiceClient(StgDnDownServiceClient stgDnDownServiceClient) {
        this.stgDnDownServiceClient = stgDnDownServiceClient;
    }

    public void setCdLocInfoServiceClient(CdLocInfoServiceClient cdLocInfoServiceClient) {
        this.cdLocInfoServiceClient = cdLocInfoServiceClient;
    }

    @RequestMapping(value = "/so/searchOdsSoGrInfo",
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchOdsSoGrInfo(Long page, Long rows, OdsSoGrInfoDTO dto){
		Pager<OdsSoGrInfoDTO> pager = odsSoGrInfoServiceClient.searchOdsSoGrInfoListByPage(page,rows,dto);
		PageBean bean = PageUtil.setPager(pager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	@RequestMapping(value = "/so/searchSoGrInfoAmount",
		method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportCount(OdsSoGrInfoDTO dto){
		String result = "success";
		Long size = odsSoGrInfoServiceClient.getExportAmount(dto);
		if (size > 25000) {
    		result = "The amount of data you exported is too large, please narrowing the query range!";
    	}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	@RequestMapping(value = "/so/exportSoGrInfo",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getSoGrInfoList(HttpServletResponse response,OdsSoGrInfoDTO dto){
		response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("SoGrInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());
        
		List<OdsSoGrInfoDTO> list = odsSoGrInfoServiceClient.getOdsSoGrInfoListByParm(dto);
		ExcelExportTemplate<OdsSoGrInfoDTO> listTemplate = new ExportOdsSoGrInfoListTemplet(list);
		try {
            listTemplate.doExport(response.getOutputStream(), dto == null?new OdsSoGrInfoDTO():dto);
		} catch (Exception e) {
			e.printStackTrace();
            return "failure";
		}
		return null;
	}
	
	/**  
	 * <p>Title: print</p>  
	 * <p>Description: </p>  
	 * @param request
	 * @param response
	 * @return  
	 */
	@RequestMapping(value = "/so/printOgp")
	@ResponseBody
	public String printOgp(HttpServletRequest request, HttpServletResponse response, String msg) {
		List<OdsSoGrInfoDTO> list = JSON.parseArray(msg, OdsSoGrInfoDTO.class);
		
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
        	String pdfFilePath = request.getSession().getServletContext().getRealPath("/")+"/pdf/dn_ogp_print.pdf";
//        	String jpgFilePath = request.getSession().getServletContext().getRealPath("/")+"/pdf/ogp_print.jpg";
            PdfReader reader = new PdfReader(pdfFilePath);
            PdfStamper stamper = new PdfStamper(reader, ba);
//            Image img = Image.getInstance(jpgFilePath);
//            img.setAbsolutePosition(0,0);
//            img.scaleToFit(reader.getPageSize(1).getWidth(),reader.getPageSize(1).getHeight());
//            PdfContentByte under = stamper.getUnderContent(1);
//            under.addImage(img,img.getScaledWidth(),0,0,img.getScaledHeight(),0,0);
//            under.addImage(img);

            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED); 
            AcroFields form = stamper.getAcroFields();
            form.addSubstitutionFont(bf);

            for (int i = 0; i < list.size(); i++) {
                OdsSoGrInfoDTO temp = list.get(i);
                if (i == 0) {
                    form.setField("NAME", temp.getPlant());
                    form.setField("COMPANY", temp.getTransporterCode());
                    form.setField("DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    form.setField("CARNO", temp.getCarNo());
                    form.setField("INVOICE_NO", temp.getInvoiceNo());
                }
                form.setField("GOODS_" + (i + 1), temp.getMaterialDesp());
                form.setField("UNIT_" + (i + 1), temp.getUnit());
                form.setField("QTY_" + (i + 1), String.valueOf(temp.getScannedQty()));
                form.setField("REMARK_" + (i + 1), "");
            }
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
	
	@RequestMapping(value = "/so/printDn")
	@ResponseBody
	public String printDn(HttpServletRequest request, HttpServletResponse response, String msg) throws IOException {
		List<OdsSoGrInfoDTO> list = JSON.parseArray(msg, OdsSoGrInfoDTO.class);
		int total = 0;
//		ByteArrayOutputStream ba = new ByteArrayOutputStream();
        byte[] bytes = null;
        // 报表数据源
        //TODO 报表数据源
        Map<String, Object> parameter = new HashMap<String, Object>();
        List<StgDnDownDTO> dtoList = null;
        for(int i = 0; i < list.size(); i++){
            OdsSoGrInfoDTO temp = list.get(i);
            if(i == 0) {
                //根据DN查询详情
                StgDnDownDTO dto = new StgDnDownDTO();
                dto.setDnNo(temp.getDnNo());
                dtoList = stgDnDownServiceClient.getStgDnDownsByParam(dto);
                //报表数据
                parameter.put("customer_po", dtoList.get(0).getCustomerPo());
                parameter.put("to", dtoList.get(0).getDeliveryName());
                parameter.put("address_to", dtoList.get(0).getDeliveryAddress());
                parameter.put("dn_no", temp.getDnNo());
                parameter.put("car_no", temp.getCarNo());
//                parameter.put("MATERIAL_NO", temp.getMaterialNo());
                parameter.put("transporter_code", temp.getTransporterCode());

                //from
                StringBuffer locationCodes = new StringBuffer();
                for (int j = 0; j < dtoList.size(); j++) {
                    if (j == dtoList.size() - 1) {
                        locationCodes.append("'").append(dtoList.get(j).getLocation()).append("'");
                    } else {
                        locationCodes.append("'").append(dtoList.get(j).getLocation()).append("',");
                    }
                }
                StringBuffer locationNames = new StringBuffer();
                String locationAddress = "";
                List<CdLocInfoDTO> cdLocInfoDTOList = cdLocInfoServiceClient.getCdLocInfoListByCode(locationCodes.toString());
                if (cdLocInfoDTOList.size() != 0) {
                    locationAddress = cdLocInfoDTOList.get(0).getAddress();
                    for (int x = 0; x < cdLocInfoDTOList.size(); x++) {
                        if (x == cdLocInfoDTOList.size() - 1) {
                            locationNames.append(cdLocInfoDTOList.get(x).getName());
                        } else {
                            locationNames.append(cdLocInfoDTOList.get(x).getName()).append(" / ");
                        }
                    }
                }
                parameter.put("from", locationNames.toString());
                if(StringUtils.isBlank(locationAddress)){
                    locationAddress = "";
                }
                parameter.put("address_from", locationAddress);
            }
            String customerModel = "";
            String materialDesc = "";
            for (int j = 0; j < dtoList.size(); j++) {
                if (dtoList.get(j) != null && dtoList.get(j).getMaterialNo() != null) {
                    if (dtoList.get(j).getMaterialNo().equalsIgnoreCase(temp.getMaterialNo())) {
//                        customerModel = dtoList.get(j).getCustomerModel();
                        materialDesc = dtoList.get(j).getMaterialDesp();
                    }
                }
            }
//            parameter.put("mat_desc_" + (i + 1), customerModel + ":" + materialDesc);
            parameter.put("mat_desc_" + (i + 1), materialDesc);
            parameter.put("qty_" + (i + 1), String.valueOf(temp.getScannedQty()));
            total += temp.getScannedQty();
        }
        parameter.put("total", total);
        ServletOutputStream outStream = null;
        log.info("parameter:" + parameter);
        try {
            String pdfFilePath = request.getSession().getServletContext().getRealPath("/") + "/jasper/DN_print.jasper";
            File reportFile = new File(pdfFilePath);
            response.setContentType("application/pdf");
            log.info(pdfFilePath);
            bytes = psiReportServiceClient.generatePsiReport(reportFile.getPath(), parameter);
            log.info(String.valueOf(bytes));
            outStream = response.getOutputStream();
            if (bytes != null) {
                response.setContentLength(bytes.length);
                outStream.write(bytes, 0, bytes.length);
            }
//             conn.close();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } finally {
            if(outStream != null) {
                outStream.flush();
                outStream.close();
            }
        }
        return null;
//        	String jpgFilePath = request.getSession().getServletContext().getRealPath("/")+"/pdf/dn_print.jpg";
//            PdfReader reader = new PdfReader(pdfFilePath);
//            PdfStamper stamper = new PdfStamper(reader, ba);

//	        Image img = Image.getInstance(jpgFilePath);
//	        img.setAbsolutePosition(0,0);
//	        img.scaleToFit(reader.getPageSize(1).getWidth(),reader.getPageSize(1).getHeight());
//	        PdfContentByte under = stamper.getUnderContent(1);
//	        under.addImage(img,img.getScaledWidth(),0,0,img.getScaledHeight(),0,0);
//	        under.addImage(img);

//            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
//            AcroFields form = stamper.getAcroFields();
//            form.addSubstitutionFont(bf);
//
//            List<StgDnDownDTO> dtoList = null;
//
//            for (int i = 0; i < list.size(); i++) {
//                OdsSoGrInfoDTO temp = list.get(i);
//                if (i == 0) {
//                    String dnNo = temp.getDnNo();
//                    StgDnDownDTO dto = new StgDnDownDTO();
//                    dto.setDnNo(dnNo);
//                    dtoList = stgDnDownServiceClient.getStgDnDownsByParam(dto);
//                    form.setField("CUSTOMER_PO", dtoList.get(0).getCustomerPo());
//                    StringBuffer locationCodes = new StringBuffer();
//                    for (int j = 0; j < dtoList.size(); j++) {
//                        if (j == dtoList.size() - 1) {
//                            locationCodes.append("'").append(dtoList.get(j).getLocation()).append("'");
//                        } else {
//                            locationCodes.append("'").append(dtoList.get(j).getLocation()).append("',");
//                        }
//                    }
//                    StringBuffer locationNames = new StringBuffer();
//                    String locationAddress = "";
//                    List<CdLocInfoDTO> cdLocInfoDTOList = cdLocInfoServiceClient.getCdLocInfoListByCode(locationCodes.toString());
//                    if (cdLocInfoDTOList.size() != 0) {
//                        locationAddress = cdLocInfoDTOList.get(0).getAddress();
//                        for (int x = 0; x < cdLocInfoDTOList.size(); x++) {
//                            if (x == cdLocInfoDTOList.size() - 1) {
//                                locationNames.append(cdLocInfoDTOList.get(x).getName());
//                            } else {
//                                locationNames.append(cdLocInfoDTOList.get(x).getName()).append(" / ");
//                            }
//                        }
//                    }
//
//                    form.setField("DN_NO",dnNo);
//
//                    form.setField("FORM_DATE", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
//                    form.setField("FORM_REQUEST_TO", "");
//
//                    form.setField("FORM_FROM", locationNames.toString());
//                    form.setField("FORM_ADDRESS_FROM", locationAddress);
//                    form.setField("FORM_TO", dtoList.get(0).getDeliveryName());
//                    form.setField("FORM_ADDRESS_TO", dtoList.get(0).getDeliveryAddress());
//
//                    form.setField("FORM_TRANS", temp.getTransporterCode());
//                    form.setField("FORM_CAR", temp.getCarNo());
//            	}
//
//                String customerModel = "";
//                String materialDesc = "";
//                for (int j = 0; j < dtoList.size(); j++) {
//                    if (dtoList.get(j) != null && dtoList.get(j).getMaterialNo() != null) {
//                        if (dtoList.get(j).getMaterialNo().equalsIgnoreCase(temp.getMaterialNo())) {
//                            customerModel = dtoList.get(j).getCustomerModel();
//                            materialDesc = dtoList.get(j).getMaterialDesp();
//                        }
//                    }
//                }
//
//                form.setField("DETAIL_GOOD" + (i + 1), customerModel + ":" + materialDesc);
//                form.setField("DETAIL_QTY" + (i + 1), String.valueOf(temp.getScannedQty()));
//                total += temp.getScannedQty();
//            }
//            form.setField("DETAIL_TOTAL_QTY", String.valueOf(total));
//            stamper.setFormFlattening(true);
//
//            stamper.close();
//            response.setContentType("application/pdf");
//            response.setContentLength(ba.size());
//            ServletOutputStream out = response.getOutputStream();
//            ba.writeTo(out);
//            out.flush();
//            out.close();
//            ba.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        return null;
	}
}

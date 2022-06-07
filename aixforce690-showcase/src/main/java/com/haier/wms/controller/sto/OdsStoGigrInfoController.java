package com.haier.wms.controller.sto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoGigrInfoServiceClient;
import com.haier.openplatform.wms.sto.service.StgStoDownServiceClient;
import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
import com.haier.wms.exceltemplate.sto.ExportOdsStoDnGigrInfoListTemplet;
import com.haier.wms.exceltemplate.sto.ExportOdsStoGigrInfoListTemplet;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import io.terminus.common.utils.JsonMapper;
import org.apache.commons.lang3.StringUtils;
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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className: OdsStoGigrInfoController.java
 * @description: OdsStoGigrInfo_Controller
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午2:52:01
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

@Controller
public class OdsStoGigrInfoController {
    @Resource
    private OdsStoGigrInfoServiceClient odsStoGigrInfoServiceClient;

    @Resource
    private StgStoDownServiceClient stgStoDownServiceClient;

    @Resource
    private StgStodnDownServiceClient stgStodnDownServiceClient;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void setOdsStoGigrInfoServiceClient(OdsStoGigrInfoServiceClient odsStoGigrInfoServiceClient) {
        this.odsStoGigrInfoServiceClient = odsStoGigrInfoServiceClient;
    }

    public void setStgStoDownServiceClient(StgStoDownServiceClient stgStoDownServiceClient) {
        this.stgStoDownServiceClient = stgStoDownServiceClient;
    }

    public void setStgStodnDownServiceClient(StgStodnDownServiceClient stgStodnDownServiceClient) {
        this.stgStodnDownServiceClient = stgStodnDownServiceClient;
    }

    /**
     * @param dto
     * @param page
     * @param rows
     * @title: getListByPage
     * @description:
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月15日 下午6:04:22
     * @return: String
     */
    @RequestMapping(value = "/sto/searchOdsStoGigrInfo", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getListByPage(OdsStoGigrInfoDTO dto, Long page, Long rows) {
        Pager<OdsStoGigrInfoDTO> pager = odsStoGigrInfoServiceClient.searchOdsStoGigrInfoByPage(page, rows, dto);
        PageBean bean = PageUtil.setPager(pager);
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
    }

    /**
     * @param dto
     * @title: searchAmount
     * @description: 统计
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月15日 下午6:04:15
     * @return: String
     */
    @RequestMapping(value = "/sto/searchOdsStoGigrInfoAmount", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchAmount(OdsStoGigrInfoDTO dto) {
        String result = "success";
        Long size = odsStoGigrInfoServiceClient.getExportOdsStoGigrInfoAmount(dto);
        if (size > 25000) {
            result = "The amount of data you exported is too large, please narrowing the query range!";
        }
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

    /**
     * @param dto
     * @title: searchStoDnAmount
     * @description: 统计
     * @return: String
     */
    @RequestMapping(value = "/stoDn/searchOdsStoDnGigrInfoAmount", method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String searchStoDnAmount(OdsStodnGigrInfoDTO dto) {
        String result = "success";
        Long size = odsStoGigrInfoServiceClient.getExportOdsStoDnGigrInfoAmount(dto);
        if (size > 25000) {
            result = "The amount of data you exported is too large, please narrowing the query range!";
        }
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }

    /**
     * @param request
     * @param response
     * @param dto
     * @title: exportExcel
     * @description: 导出Excel报表
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月15日 下午6:04:07
     * @return: String
     */
    @RequestMapping(value = "/sto/exportOdsStoGigrInfoExcel", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportExcel(HttpServletRequest request, HttpServletResponse response, OdsStoGigrInfoDTO dto) {
        String flag = "success";

        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StoGrInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        List<OdsStoGigrInfoDTO> list = odsStoGigrInfoServiceClient.getStoGigrInfoListByParm(dto);
        ExcelExportTemplate<OdsStoGigrInfoDTO> listTemplet = new ExportOdsStoGigrInfoListTemplet(list);
        try {
            listTemplet.doExport(response.getOutputStream(), dto == null ? new OdsStoGigrInfoDTO() : dto);
        } catch (Exception e) {
            e.printStackTrace();
            flag = "failture";
            return flag;
        }
        return null;
    }

    /**
     * @param request
     * @param response
     * @param dto
     * @title: exportExcel
     * @description: 导出Excel报表
     * @author: LJZ
     * @version: v1.0.0
     * @return: String
     */
    @RequestMapping(value = "/stoDn/exportOdsStoDnGigrInfoExcel", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String exportStoDnExcel(HttpServletRequest request, HttpServletResponse response, OdsStodnGigrInfoDTO dto) {
        String flag = "success";

        response.setContentType(Servlets.EXCEL_TYPE);
        StringBuffer fileNameBuffer = new StringBuffer();
        fileNameBuffer.append("StoDnGrInfo");
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        fileNameBuffer.append(fmtDate.format(new Date()));
        fileNameBuffer.append(".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

        List<OdsStodnGigrInfoDTO> list = odsStoGigrInfoServiceClient.getStoDnGigrInfoListByParm(dto);
        ExcelExportTemplate<OdsStodnGigrInfoDTO> listTemplet = new ExportOdsStoDnGigrInfoListTemplet(list);
        try {
            listTemplet.doExport(response.getOutputStream(), dto == null ? new OdsStodnGigrInfoDTO() : dto);
        } catch (Exception e) {
            e.printStackTrace();
            flag = "failture";
            return flag;
        }
        return null;
    }

    @RequestMapping(value = "/sto/printOgp")
    @ResponseBody
    public String printOgp(HttpServletRequest request, HttpServletResponse response, String msg) {
        List<OdsStoGigrInfoDTO> list = JSON.parseArray(msg, OdsStoGigrInfoDTO.class);

        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            String pdfFilePath = request.getSession().getServletContext().getRealPath("/") + "/pdf/sto_ogp_print.pdf";
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
                OdsStoGigrInfoDTO temp = list.get(i);
                if (i == 0) {
                    form.setField("NAME", temp.getPlant());
                    form.setField("COMPANY", temp.getTransporterCode());
                    form.setField("DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    form.setField("CARNO", temp.getCarNo());
                    form.setField("INVOICE_NO", temp.getInvoiceNo());
                }
                if (temp.getMaterialDesp() == null) {
                    temp.setMaterialDesp("");
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

    /**
     * DN Print
     *
     * @param request
     * @param response
     * @param msg
     * @return
     */
    @RequestMapping(value = "/sto/printDn")
    @ResponseBody
    public String printDn(HttpServletRequest request, HttpServletResponse response, String msg) {
        List<OdsStoGigrInfoDTO> list = JSON.parseArray(msg, OdsStoGigrInfoDTO.class);
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            String pdfFilePath = request.getSession().getServletContext().getRealPath("/") + "/pdf/stodn_print.pdf";

            PdfReader reader = new PdfReader(pdfFilePath);
            PdfStamper stamper = new PdfStamper(reader, ba);
            //
//	        Image img = Image.getInstance(jpgFilePath);
//	        img.setAbsolutePosition(0,0);
//	        img.scaleToFit(reader.getPageSize(1).getWidth(),reader.getPageSize(1).getHeight());
//	        PdfContentByte under = stamper.getUnderContent(1);
//	        under.addImage(img,img.getScaledWidth(),0,0,img.getScaledHeight(),0,0);
//	        under.addImage(img);

            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
            AcroFields form = stamper.getAcroFields();
            form.addSubstitutionFont(bf);

            int totalQty = 0;
            String orderType = "";
            String stoNo = list.get(0).getStoNo();
            for (int i = 0; i < list.size(); i++) {
                OdsStoGigrInfoDTO dto = list.get(i);
                if (i == 0) {
                    form.setField("ORDER_1", dto.getStoNo() + ("".equals(dto.getStodnNo()) ? "" : " / " + dto.getStodnNo()));
                    form.setField("ADDRESS_1", dto.getPlantName());
                    form.setField("TRANS_CO", dto.getTransporterCode());
                    form.setField("CAR_NO", dto.getCarNo());
                    form.setField("FIXED_TEXT", "XUÂT HÀNG NỘI BỘ");
                    orderType = dto.getOrderType();
                }

                form.setField("SN_" + (i + 1), (i + 1) + "");
                int a = dto.getMaterialDesp().indexOf(':');
                if (a != -1) {
                    form.setField("GOODS_" + (i + 1), dto.getMaterialDesp().substring(0, a));
                } else {
                    form.setField("GOODS_" + (i + 1), dto.getMaterialDesp());
                }

                form.setField("CODE_" + (i + 1), "");
                form.setField("UNIT_" + (i + 1), dto.getUnit());
                if ("1".equals(dto.getOrderType())) {
                    form.setField("IMPORT_" + (i + 1), dto.getScannedQty() + "");
                }
                if ("2".equals(dto.getOrderType())) {
                    form.setField("EXPORT_" + (i + 1), dto.getScannedQty() + "");
                }
                totalQty += dto.getScannedQty();
            }

            String dateV = new SimpleDateFormat("dd").format(new Date());
            String monthV = new SimpleDateFormat("MM").format(new Date());
            String yearV = new SimpleDateFormat("yyyy").format(new Date());
            form.setField("DATE_0", dateV);
            form.setField("MONTH_0", monthV);
            form.setField("YEAR_0", yearV);
            if ("1".equals(orderType)) {
                form.setField("DATE_1", dateV);
                form.setField("MONTH_1", monthV);
                form.setField("YEAR_1", yearV);
                form.setField("TOTAL_QTY1", totalQty + "");

                String stodnNo = list.get(0).getStodnNo();
                List<String> grLocationList = stgStodnDownServiceClient.getGrLocationNameListByStodnNo(stodnNo);
                StringBuffer grLocationName = new StringBuffer();
                for (String grLocation : grLocationList) {
                    grLocationName.append(grLocation).append(" / ");
                }
                if (grLocationName.length() > 1) {
                    form.setField("RECEIVE_LOCATION_1", grLocationName.substring(0, grLocationName.length() - 3));
                } else {
                    form.setField("RECEIVE_LOCATION_1", grLocationName.toString());
                }
            }
            if ("2".equals(orderType)) {
                form.setField("DATE_2", dateV);
                form.setField("MONTH_2", monthV);
                form.setField("YEAR_2", yearV);
                form.setField("TOTAL_QTY2", totalQty + "");

                List<String> giLocationList = stgStoDownServiceClient.getGiLocationNameListBySTONO(stoNo);
                List<String> grLocationList = stgStoDownServiceClient.getGrLocationNameListBySTONO(stoNo);
                StringBuffer grLocationName = new StringBuffer();
                StringBuffer giLocationName = new StringBuffer();
                for (String giLocation : giLocationList) {
                    giLocationName.append(giLocation).append(" / ");
                }
                for (String grLocation : grLocationList) {
                    grLocationName.append(grLocation).append(" / ");
                }
                // 此处判空为保证安全和PDF的显示

                if (giLocationName.length() >= 1) {
                    form.setField("ISSUE_LOCATION_1", giLocationName.substring(0, giLocationName.length() - 3));
                } else {
                    form.setField("ISSUE_LOCATION_1", giLocationName.toString());
                }
                if (grLocationName.length() >= 1) {
                    form.setField("RECEIVE_LOCATION_1", grLocationName.substring(0, grLocationName.length() - 3));
                } else {
                    form.setField("RECEIVE_LOCATION_1", grLocationName.toString());
                }
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

    /**
     * VNPT
     *
     * @param request
     * @param response
     * @param msg
     * @return
     */
    @RequestMapping(value = "/sto/printVNPT")
    @ResponseBody
    public String printVNPT(HttpServletRequest request, HttpServletResponse response, String msg) {
        List<OdsStoGigrInfoDTO> list = JSON.parseArray(msg, OdsStoGigrInfoDTO.class);
        StringBuffer sb = new StringBuffer();
        OrderIgpOutDTO result = new OrderIgpOutDTO();
        String rowid = UUID.randomUUID().toString().replace("-", "");
        if (list == null || list.size() < 1) {
            result.setStatus("F");
            result.setMsg("please chose one data at least!");
            return JSONObject.toJSONString(result);
        }
        try {
            int totalQty = 0;
            String orderType = list.get(0).getOrderType();
//			String opgNo = list.get(0).getOrderNo();
            String dateV = new SimpleDateFormat("dd").format(new Date());
            String monthV = new SimpleDateFormat("MM").format(new Date());
            String yearV = new SimpleDateFormat("yyyy").format(new Date());
            String exportAddr = "";
            String importAddr = "";
            //获取ordertype 根据ordertype取 发货地址 和 收货地址
            if ("1".equals(orderType)) {//入库
                String stodnNo = list.get(0).getStodnNo();
                List<String> grLocationList = stgStodnDownServiceClient.getGrLocationNameListByStodnNo(stodnNo);
                StringBuffer grLocationName = new StringBuffer();
                for (String grLocation : grLocationList) {
                    grLocationName.append(grLocation).append(" / ");
                }
                if (grLocationName.length() > 1) {
                    importAddr = grLocationName.substring(0, grLocationName.length() - 3);
                } else {
                    importAddr = grLocationName.toString();
                }
            }
            if ("2".equals(orderType)) {//出库
                String stoNo = list.get(0).getStoNo();
                List<String> giLocationList = stgStoDownServiceClient.getGiLocationNameListBySTONO(stoNo);
                List<String> grLocationList = stgStoDownServiceClient.getGrLocationNameListBySTONO(stoNo);
                StringBuffer grLocationName = new StringBuffer();
                StringBuffer giLocationName = new StringBuffer();
                for (String giLocation : giLocationList) {
                    giLocationName.append(giLocation).append(" / ");
                }
                for (String grLocation : grLocationList) {
                    grLocationName.append(grLocation).append(" / ");
                }

                if (giLocationName.length() >= 1) {
                    exportAddr = giLocationName.substring(0, giLocationName.length() - 3);
                } else {
                    exportAddr = giLocationName.toString();
                }
                if (grLocationName.length() >= 1) {
                    importAddr = grLocationName.substring(0, grLocationName.length() - 3);
                } else {
                    importAddr = grLocationName.toString();
                }
            }
            if (StringUtils.isBlank(importAddr)) {
                result.setStatus("F");
                result.setMsg("DocImport is empty,check please!");
                return JSONObject.toJSONString(result);
            }
            for (int i = 0; i < list.size(); i++) {
                OdsStoGigrInfoDTO dd = list.get(i);
                totalQty += dd.getScannedQty();
            }
            for (int i = 0; i < list.size(); i++) {
                OdsStoGigrInfoDTO dto = list.get(i);
//                if (i == 0) {
                sb.append("<Invoices>\n" +
                        "<Inv>\n" +
                        "<key>" + rowid + "</key>\n" +
                        "<Invoice>\n" +
                        "<ArisingDate>" + simpleDateFormat.format(new Date()) + "</ArisingDate>\n" +
                        "<CusCode>" + importAddr + "</CusCode>\n" +
                        "<CusName>" + importAddr + "</CusName>\n" +
                        "<CusAddress></CusAddress>\n" +
                        "<CusPhone></CusPhone>\n" +
                        "<ReferenceNo></ReferenceNo>\n" +
                        "<LDDNBo>" + dto.getStoNo() + ("".equals(dto.getStodnNo()) ? "" : " / " + dto.getStodnNo()) + "</LDDNBo>\n" +
                        "<Extra>" + dateV + " " + monthV + " " + yearV + "</Extra>\n" +
                        "<Extra1>Aqua Electrical Appliances(VN)</Extra1>\n" +
                        "<Extra2>XUÂT HÀNG NỘI BỘ</Extra2>\n" +
                        "<TNVChuyen>" + dto.getTransporterCode() + "</TNVChuyen>\n" +
                        "<ContractNumber></ContractNumber>\n" +
                        "<PTVChuyen>" + dto.getCarNo() + "</PTVChuyen>\n" +
                        "<Extra3>" + importAddr + "</Extra3>\n" +
                        "<TotalQuantity>" + totalQty + "</TotalQuantity>\n" +
                        "<Products>\n");
//                }
                String prodName = "";
                int a = dto.getMaterialDesp().indexOf(':');
                if (a != -1) {
                    prodName = dto.getMaterialDesp().substring(0, a);
                } else {
                    prodName = dto.getMaterialDesp();
                }
                sb.append("<Product>\n" +
                        "<ProdName>" + prodName + "</ProdName>\n" +
                        "<ProdUnit>" + dto.getUnit() + "</ProdUnit>\n" +
                        "<ProdQuantity>" + dto.getScannedQty() + "</ProdQuantity>\n" +
                        "<Extra1></Extra1>\n" +
                        "<Amount>0</Amount>\n" +
                        "<IsSum>0</IsSum>\n" +
                        "</Product>\n");
            }
            sb.append("</Products>\n" +
                    "<Total>0</Total>\n" +
                    "<Extra4>" + simpleDateFormat.format(new Date()) + "</Extra4>\n" +
                    "<Amount>0</Amount>\n" +
                    "<AmountInWords>mười đồng</AmountInWords>\n" +
                    "</Invoice>\n" +
                    "</Inv>\n" +
                    "</Invoices>");
            System.err.println("--------------------------------------------------");
            System.err.println(sb.toString());
            System.err.println("--------------------------------------------------");
            result = odsStoGigrInfoServiceClient.printVNPT(sb.toString(), list.get(0).getStodnNo(), list.get(0).getMaterialDesp());
            System.err.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("F");
            result.setMsg(e.getMessage());
        }
        System.err.println("vnpt print finnaly return:" + JSONObject.toJSONString(result));
        return JSONObject.toJSONString(result);

    }
}

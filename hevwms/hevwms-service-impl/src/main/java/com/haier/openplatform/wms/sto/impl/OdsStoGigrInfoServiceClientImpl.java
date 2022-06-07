package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.sto.service.OdsStoGigrInfoService;
import com.haier.hevwms.sto.service.vnpt.PrintInvoiceService;
import com.haier.hevwms.sto.service.vnpt.PublishServiceSoap;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoGigrInfoServiceClient;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className: OdsStoGigrInfoServiceClientImpl.java
 * @description:
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午4:06:25
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public class OdsStoGigrInfoServiceClientImpl implements OdsStoGigrInfoServiceClient {
    private OdsStoGigrInfoService odsStoGigrInfoService;
    private PrintInvoiceService printInvoiceService;

    public void setPrintInvoiceService(PrintInvoiceService printInvoiceService) {
        this.printInvoiceService = printInvoiceService;
    }

    public PrintInvoiceService getPrintInvoiceService() {
        return printInvoiceService;
    }

    public OdsStoGigrInfoService getOdsStoGigrInfoService() {
        return odsStoGigrInfoService;
    }

    public void setOdsStoGigrInfoService(OdsStoGigrInfoService odsStoGigrInfoService) {
        this.odsStoGigrInfoService = odsStoGigrInfoService;
    }

    /**
     * 分页
     */
    @Override
    public Pager<OdsStoGigrInfoDTO> searchOdsStoGigrInfoByPage(Long page,
                                                               Long rows, OdsStoGigrInfoDTO dto) {
        Pager<OdsStoGigrInfoDTO> pager = new Pager<OdsStoGigrInfoDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        return odsStoGigrInfoService.getListByPage(pager, dto);
    }

    /**
     * 统计
     */
    @Override
    public Long getExportOdsStoGigrInfoAmount(OdsStoGigrInfoDTO dto) {
        return odsStoGigrInfoService.getOdsStoGigrInfoCountByParm(dto);
    }

    /**
     * 统计
     */
    @Override
    public Long getExportOdsStoDnGigrInfoAmount(OdsStodnGigrInfoDTO dto) {
        return odsStoGigrInfoService.getOdsStoDnGigrInfoCountByParm(dto);
    }

    /**
     * 条件
     */
    @Override
    public List<OdsStoGigrInfoDTO> getStoGigrInfoListByParm(
            OdsStoGigrInfoDTO dto) {
        return odsStoGigrInfoService.getListByParm(dto);
    }

    /**
     * 条件
     */
    @Override
    public List<OdsStodnGigrInfoDTO> getStoDnGigrInfoListByParm(
            OdsStodnGigrInfoDTO dto) {
        return odsStoGigrInfoService.getStoDnListByParm(dto);
    }

    @Override
    public OrderIgpOutDTO printVNPT(String makexml, String stodnNo, String materialDesp) {
        OrderIgpOutDTO resultdto = new OrderIgpOutDTO();
        try {
            PublishServiceSoap publishServiceSoap = printInvoiceService.getPublishServiceSoap();
            String result = publishServiceSoap.importAndPublishInv("aquavnadmin", "Einv@oi@vn#pt20", makexml, "aquaservice", "123456aA@", "6/001", "C22NQA", 0);
            System.err.println("VNPT INTERFACE RETURN:" + result);
            if (StringUtils.contains(result, "OK")) {

                String num = "C22NQA";
                String[] arr1 = result.split(";");
                String str = arr1[1];
                int count = str.lastIndexOf(num);
                if (count != -1) {
                    str = str.substring(count + num.length());
                    String[] strings = str.split("_");
                    //修改
                    odsStoGigrInfoService.updateByOrderNo(stodnNo, materialDesp, strings[1]);
                    if (arr1.length > 1) {
                        List<String> list = new ArrayList<String>(Arrays.asList(arr1));
                        list.remove(0);
                        if (list.size() > 0) {
                            for (String string : list) {
                                String[] arr3 = string.split("_");
                                //修改
                                odsStoGigrInfoService.updateByOrderNo(stodnNo, materialDesp, arr3[1]);
                            }
                        }
                    }
                }

                System.err.println("VNPT SUCCESS!");
                resultdto.setStatus("S");
                resultdto.setMsg(result);
            } else if (StringUtils.contains(result, "ERR:13")) {
				resultdto.setMsg("STO Invoice number is existed. Please check again!");
            } else {
                System.err.println("VNPT FAILURE!");
                resultdto.setStatus("F");
                resultdto.setMsg(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultdto.setStatus("F");
            resultdto.setMsg(e.getMessage());
        }
        return resultdto;
    }

}

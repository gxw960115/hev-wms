package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.sto.service.OdsStoScanInfoService;
import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.hevwms.sto.service.StgStodnDownService;
import com.haier.hevwms.sto.service.StoPDAService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.service.StoPDAServiceClient;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className: StoPDAServiceClientImpl.java
 * @description: STO 手持 Service Client
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月31日 上午10:31:20
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年10月31日		LJZ			v1.0.0			create
 */

public class StoPDAServiceClientImpl implements StoPDAServiceClient {

    private Logger logger = Logger.getLogger(StoPDAServiceClientImpl.class);
    @Resource
    private WebServiceContext context;

    private StoPDAService stoPDAService;

    private StgStoDownService stgStoDownService;

    private StgStodnDownService stgStodnDownService;

    public StoPDAService getStoPDAService() {
        return stoPDAService;
    }

    public void setStoPDAService(StoPDAService stoPDAService) {
        this.stoPDAService = stoPDAService;
    }

    public StgStoDownService getStgStoDownService() {
        return stgStoDownService;
    }

    public void setStgStoDownService(StgStoDownService stgStoDownService) {
        this.stgStoDownService = stgStoDownService;
    }

    public StgStodnDownService getStgStodnDownService() {
        return stgStodnDownService;
    }

    public void setStgStodnDownService(StgStodnDownService stgStodnDownService) {
        this.stgStodnDownService = stgStodnDownService;
    }

    /**
     * 手持STO_检查订单是否可以扫描
     */
    @Override
    public OrderCheckOutDTO stoOrderCheck(OrderCheckInDTO dto, String version) {
        OrderCheckOutDTO result = new OrderCheckOutDTO();
        Date startDate = new Date();
        // 检查版本号 与 用户信息
        RfLogResult rfLogResult = stoPDAService.checkSign(dto.getUser(), dto.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            result = stgStoDownService.checkOrderByPDA(dto);
        } else {
            result.setStatus(rfLogResult.getStatus());
            result.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        // 日志记录
        stoPDAService.writeLog(dto.getUser(), "STO_PDA_Check", dto.getSign(),
                context, result.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), dto, result);
        return result;
    }

    /**
     * 手持STO_调用SAP接口，下载STO订单
     */
    @Override
    public OrderLoadOutDTO stoOrderDownload(OrderLoadInDTO inpara, String version, String stoNo) {
        InterfaceOutDTO result;
        OrderLoadOutDTO outResult = new OrderLoadOutDTO();
        // 接口调用开始时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = stoPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            if ("1".equals(inpara.getOrdertype())) {
                result = stgStodnDownService.downloadStodn(stoNo, inpara.getOrno(), inpara.getUser());
            } else {
                result = stgStoDownService.downloadSto(stoNo, null, null, inpara.getUser());
            }
            outResult.setStatus(result.getStatus());
            outResult.setMsg(result.getMsg());
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Download", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持STO_删除扫描的订单
     */
    @Override
    public OrderDeleteOutDTO stoOrderDelete(OrderDeleteInDTO inpara, String version) {
        Date startDate = new Date();
        RfLogResult rfLogResult = stoPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        // 调用Service
        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {
            // 调用service
            outResult = stoPDAService.stoOrderDelete(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }

        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        Date endDate = new Date();
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Delete", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持STO_删除扫描的订单
     */
    @Override
    public OrderDeleteOutDTO stoOrdersDelete(OrderDeleteInDTO inParam, String version) {
        Date startDate = new Date();
        RfLogResult rfLogResult = stoPDAService.checkSign(inParam.getUser(), inParam.getSign(), version);

        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {
            String[] barcodes = inParam.getBarcode().split(",");
            for (String barcode : barcodes) {
                inParam.setBarcode(barcode);
                outResult = stoPDAService.stoOrderDelete(inParam);
            }
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        Date endDate = new Date();
        stoPDAService.writeLog(inParam.getUser(), "STO_PDA_Delete", inParam.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inParam, outResult);
        return outResult;
    }

    /**
     * 手持STODN_删除扫描的订单
     */
    @Override
    public OrderDeleteOutDTO stodnScanDelete(OrderDeleteInDTO inParam, String version) {
        Date startDate = new Date();
        RfLogResult rfLogResult = stoPDAService.checkSign(inParam.getUser(), inParam.getSign(), version);

        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {
            String[] barcodes = inParam.getBarcode().split(",");
            for (String barcode : barcodes) {
                inParam.setBarcode(barcode);
                outResult = stoPDAService.stodnOrderDelete(inParam);
            }
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        Date endDate = new Date();
        stoPDAService.writeLog(inParam.getUser(), "STO_PDA_Delete", inParam.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inParam, outResult);
        return outResult;
    }

    /**
     * 手持STO_订单过账
     */
    @Override
    public OrderIgpOutDTO stoOrderIgp(OrderIgpInDTO inpara, String version) {
        logger.debug("Entering StoOrderIgp...");
        Date startDate = new Date();
        RfLogResult rfLogResult = stoPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        // 调用Service
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {
            logger.debug("Sign check successful...");
            // 调用service sto入库
            outResult = stoPDAService.stodnOrderIgp(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }

        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Igp", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        logger.debug("Exiting otcwmsOrderIgp...");
        return outResult;
    }

    /**
     * 手持STO_订单过账
     */
    @Override
    public OrderIgpOutDTO stoOrderOgp(OrderIgpInDTO inpara, String version) {
        logger.debug("Entering StoOrderIgp...");
        Date startDate = new Date();
        RfLogResult rfLogResult = stoPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {

            if ("1".equals(inpara.getOrderType())) {
                outResult = stoPDAService.stodnOrderIgp(inpara);
                if ("0".equals(outResult.getStatus())) {
                    //上传sap
                    InterfaceOutDTO result = stgStoDownService.postStodn(outResult.getOrId(), "0", inpara.getUser());
                    if ("S".equals(result.getStatus())) {
                        OrderGoodsTransOutDTO ret = stgStoDownService.stoGoodsReceive(inpara);
                        if ("0".equals(ret.getStatus())) {
                            outResult.setStatus("S");
                            outResult.setMsg(ret.getMsg());
                        } else {
                            outResult.setStatus("F");
                            outResult.setMsg(ret.getMsg());
                        }
                    } else {
                        outResult.setStatus("F");
                        outResult.setMsg(result.getMsg());
                    }
                }

            } else {
                outResult = stoPDAService.stoOrderOgp(inpara);
                if ("0".equals(outResult.getStatus())) {
                    InterfaceOutDTO result = stgStoDownService.postSto(outResult.getOrId(), null, inpara.getOrderType(), "0", inpara.getUser());
                    if ("1".equals(result.getStatus()) || "S".equals(result.getStatus())) {
                        //传汇总单号
                        inpara.setOrno(outResult.getOrId());
                        OrderGoodsTransOutDTO ret = stgStoDownService.stoGoodsDelivery(inpara);
                        if ("0".equals(ret.getStatus())) {
                            outResult.setStatus("S");
                            outResult.setMsg(ret.getMsg());
                        } else {
                            outResult.setStatus("F");
                            outResult.setMsg(ret.getMsg());
                        }
                    } else {
                        outResult.setStatus("F");
                        outResult.setMsg(result.getMsg());
                    }
                }
            }

        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }

        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Igp", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        logger.debug("Exiting otcwmsOrderIgp...");
        return outResult;
    }

    /**
     * 手持STO_获取条码列表
     */
    @Override
    public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
        OdsStoScanInfoDTO dto = new OdsStoScanInfoDTO();
        WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
        Date startDate = new Date();
        // 权限校验
        List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
        // 拼装查询条件
        if ("2".equals(inpara.getOrderType())) {
            dto.setStoNo(inpara.getOrderNo());
        } else {
            dto.setStodnNo(inpara.getOrderNo());
        }
        dto.setScannedBy(inpara.getUser());
        dto.setOrderType(inpara.getOrderType());
        dto.setFinishFlag("0");   //未汇总
        // 引用 OdsStoScanInfoService
        OdsStoScanInfoService service = SpringApplicationContextHolder
                .getBean("odsStoScanInfoService");
        // 按照条件查询到想要的结果
        List<OdsStoScanInfoDTO> list = service.getOdsStoScanInfos(dto);
        if (list == null) {
            return outResult;
        }
        // 把查询结果拼装成想要的列表返回
        for (OdsStoScanInfoDTO info : list) {
            OrderDelDetialDTO tempDTO = new OrderDelDetialDTO();
            tempDTO.setBarcode(info.getBarcode());
            tempDTO.setQty(info.getQty().toString());
            tempDTO.setSapOrderNo(info.getStoNo());
            tempDTO.setRowId(info.getRowId().toString());
            detial.add(tempDTO);
        }
        outResult.setTotal(list.size() + "");
        outResult.setDetial(detial);

        Date endDate = new Date();
        // PDA 日志记录
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_GetDetailList",
                inpara.getSign(), context, "", CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持STODN_获取条码列表
     * @param inpara
     * @return
     */
    @Override
    public WmsOrderDelListOutDTO getBarcodeList(WmsOrderDelListInDTO inpara) {
        OdsStoScanInfoDTO dto = new OdsStoScanInfoDTO();
        WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
        Date startDate = new Date();
        // 权限校验
        List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
        // 引用 OdsStoScanInfoService
        OdsStoScanInfoService service = SpringApplicationContextHolder
                .getBean("odsStoScanInfoService");
        // 按照条件查询到想要的结果
        dto.setScannedBy(inpara.getUser());
        dto.setOrderNo(inpara.getOrderNo());
        dto.setOrderType(inpara.getOrderType());
        List<OdsStoScanInfoDTO> list = service.getOdsStodnScanInfo(dto);
        if (list == null) {
            return outResult;
        }
        // 把查询结果拼装成想要的列表返回
        for (OdsStoScanInfoDTO info : list) {
            OrderDelDetialDTO tempDTO = new OrderDelDetialDTO();
            tempDTO.setBarcode(info.getBarcode());
            tempDTO.setQty(info.getQty().toString());
//            tempDTO.setSapOrderNo(info.getStoNo());
            tempDTO.setRowId(info.getRowId().toString());
            detial.add(tempDTO);
        }
        outResult.setTotal(list.size() + "");
        outResult.setDetial(detial);

        Date endDate = new Date();
        // PDA 日志记录
        stoPDAService.writeLog(inpara.getUser(), "STO_DN_PDA_GetDetailList",
                inpara.getSign(), context, "", CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持STO_条码扫描
     */
    @Override
    public OrderUploadOutDTO stoOrderUpload(OrderUploadInDTO inpara, String version) {
        logger.debug("Entering StoPDA_OrderScan......");
        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = stoPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            outResult = stoPDAService.scanStoCheck(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Upload", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持STODN_条码扫描
     * @param inpara
     * @return
     */
    @Override
    public OrderUploadOutDTO stodnInfoUpload(OrderUploadInDTO inpara) {
        logger.debug("Entering StoPDA_OrderScan......");
        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = stoPDAService.checkSign(inpara.getUser(), null, null);
        if ("S".equals(rfLogResult.getStatus())) {
            if(StringUtils.isNotBlank(inpara.getOrdertype()) && "1".equals(inpara.getOrdertype())) {
                outResult = stoPDAService.scanStoDnInCheck(inpara);
            } else if (StringUtils.isNotBlank(inpara.getOrdertype()) && "2".equals(inpara.getOrdertype())) {
                outResult = stoPDAService.scanStoDnOutCheck(inpara);
            } else {
                outResult.setStatus("1");
                outResult.setMsg("Please check if there is an outbound and inbound mark");
            }

        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        logger.info("STODN outbound and inbound information:" + outResult.toString());
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STODN_PDA_Upload", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持STODN_条码扫描
     */
    @Override
    public OrderUploadOutDTO stodnOrderUpload(OrderUploadInDTO inpara, String version) {
        logger.debug("Entering StoPDA_OrderScan......");
        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = stoPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            outResult = stoPDAService.scanStodnCheck(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Upload", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * @param orderNo
     * @param orderType
     * @param userName
     * @return
     */
    @Override
    public String inoutWarehouseSto(String orderNo, String orderType, String userName) {
        OrderGoodsTransOutDTO ret;
        OrderIgpInDTO inpara = new OrderIgpInDTO();
        inpara.setOrno(orderNo);
        inpara.setUser(userName);
        inpara.setDocType("STO");
        inpara.setOrderType(orderType);
        inpara.setVersion("HEV");
        if ("1".equals(orderType)) {
            ret = stgStoDownService.stoGoodsReceive(inpara);
        } else {
            ret = stgStoDownService.stoGoodsDelivery(inpara);
        }
        if ("0".equals(ret.getStatus())) {
            return "S";
        } else {
            return "F" + ret.getMsg();
        }
    }


    /**
     * 直发派遣STO单出库  导入Excel
     * @param inpara
     * @return
     */
    @Override
    public OrderUploadOutDTO stoOrderUploadExcel(OrderUploadInDTO inpara) {
        logger.debug("Entering StoPDA_OrderScan......");
        // 调用时间
        Date startDate = new Date();
        OrderUploadOutDTO outResult = stoPDAService.scanStoCheck(inpara);
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Upload", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }


    /**
     * 直发派遣 导入STO入库单Excel
     */
    @Override
    public OrderUploadOutDTO stodnOrderUploadExcel(OrderUploadInDTO inpara) {
        logger.debug("Entering StoPDA_OrderScan......");
        // 调用时间
        Date startDate = new Date();
        OrderUploadOutDTO  outResult = stoPDAService.scanStodnCheck(inpara);
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        stoPDAService.writeLog(inpara.getUser(), "STO_PDA_Upload", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }
}

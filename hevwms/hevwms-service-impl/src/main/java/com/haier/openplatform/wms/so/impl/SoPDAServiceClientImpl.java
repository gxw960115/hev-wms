package com.haier.openplatform.wms.so.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.so.service.OdsSoScanInfoService;
import com.haier.hevwms.so.service.SoPDAService;
import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
import com.haier.openplatform.wms.so.service.SoPDAServiceClient;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright ? 2013-2018 LiuJiazhen
 *
 * @className: SoPDAServiceClientImpl.java
 * @description: 手持SO_ Client
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月31日 上午10:30:52
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年10月31日		LJZ			v1.0.0			create
 */

public class SoPDAServiceClientImpl implements SoPDAServiceClient {
    private Logger logger = Logger.getLogger(SoPDAServiceClientImpl.class);
    @Resource
    private WebServiceContext context;

    private StgDnDownService stgDnDownService;

    private SoPDAService soPDAService;

    public SoPDAService getSoPDAService() {
        return soPDAService;
    }

    public void setSoPDAService(SoPDAService soPDAService) {
        this.soPDAService = soPDAService;
    }

    public StgDnDownService getStgDnDownService() {
        return stgDnDownService;
    }

    public void setStgDnDownService(StgDnDownService stgDnDownService) {
        this.stgDnDownService = stgDnDownService;
    }

    /**
     * 手持SO_按照输入的单号，验证单号是否存在可扫，如果单号不存在则提示需要下载输入的单号
     */
    @Override
    public OrderCheckOutDTO soOrderCheck(OrderCheckInDTO dto, String version) {
        OrderCheckOutDTO result = new OrderCheckOutDTO();
        Date startDate = new Date();
        // 检查版本号 与 用户信息
        RfLogResult rfLogResult = soPDAService.checkSign(dto.getUser(), dto.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {

            result = stgDnDownService.checkSo(dto);
        } else {
            result.setStatus(rfLogResult.getStatus());
            result.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(dto.getUser(), "SO_PDA_Check", dto.getSign(),
                context, result.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), dto, result);

        return result;
    }

    /**
     * 手持SO_调用SAP接口，下载SO
     */
    @Override
    public OrderLoadOutDTO soOrderDownload(OrderLoadInDTO inpara, String version) {
        InterfaceOutDTO result;
        OrderLoadOutDTO outResult = new OrderLoadOutDTO();
        // 接口调用开始时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            result = stgDnDownService.downloadDnFromSAP(inpara.getOrno(), null, null, inpara.getUser());
            outResult.setStatus(result.getStatus());
            outResult.setMsg(result.getMsg());

            outResult.setWlList(stgDnDownService.getSoMaterialList(inpara.getOrno()));
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(inpara.getUser(), "SO_Order_Downoad", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持SO_删除
     */
    @Override
    public OrderDeleteOutDTO soOrderDelete(OrderDeleteInDTO inpara, String version) {
        Date startDate = new Date();
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        // 调用Service
        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {
            // 调用service
            outResult = soPDAService.soOrderDelete(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }

        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        Date endDate = new Date();
        soPDAService.writeLog(inpara.getUser(), "SO_PDA_Delete", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持SO_删除
     */
    @Override
    public OrderDeleteOutDTO giftSoOrderDelete(OrderDeleteInDTO inpara, String version) {
        Date startDate = new Date();
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        // 调用Service
        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {
            // 调用service
            outResult = soPDAService.giftSoOrderDelete(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }

        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        Date endDate = new Date();
        soPDAService.writeLog(inpara.getUser(), "GIFT_SO_PDA_Delete", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持SO_ 循环删除
     */
    @Override
    public OrderDeleteOutDTO soOrdersDelete(OrderDeleteInDTO inpara, String version) {
        Date startDate = new Date();
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        if ("S".equals(rfLogResult.getStatus())) {
            // 循环调用service
            String[] barcodes = inpara.getBarcode().split(",");
            for (String barcode : barcodes) {
                inpara.setBarcode(barcode);
                outResult = soPDAService.soOrderDelete(inpara);
            }
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }

        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        Date endDate = new Date();
        soPDAService.writeLog(inpara.getUser(), "SO_PDA_Delete", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持SO_过账
     */
    @Override
    public OrderIgpOutDTO soOrderIgp(OrderIgpInDTO inpara, String version) {
        logger.debug("Entering DN_OrderIgp...");
        Date startDate = new Date();
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        if (!"S".equals(rfLogResult.getStatus())) {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
            return outResult;
        }
        outResult = soPDAService.soOrderIgp(inpara);
        if ("0".equals(outResult.getStatus())) {
            // 过账
            InterfaceOutDTO postResult = stgDnDownService.postDn(outResult.getOrId(),
                    inpara.getOrderType(), "0", inpara.getUser());
            if (postResult == null) {
                outResult.setStatus("F");
                outResult.setMsg("Post Error!");
                return outResult;
            } else if ("TMS".equalsIgnoreCase(postResult.getIsCome())) {
                if (!"1".equalsIgnoreCase(postResult.getStatus())) {
                    outResult.setStatus("F");
                    outResult.setMsg("Post Error!");
                    return outResult;
                }
            } else if ("SAP".equalsIgnoreCase(postResult.getIsCome())) {
                if (!"S".equalsIgnoreCase(postResult.getStatus())) {
                    outResult.setStatus("F");
                    outResult.setMsg("Post Error!");
                    return outResult;
                }
            }
            // 出入库
            OrderGoodsTransOutDTO ret;
            inpara.setOrno(outResult.getOrId());
            if ("1".equals(inpara.getOrderType())) {
                ret = stgDnDownService.soGoodsReceive(inpara);
            } else {
                ret = stgDnDownService.soGoodsDelivery(inpara);
            }
            if ("0".equals(ret.getStatus())) {
                outResult.setStatus("S");
                outResult.setMsg(ret.getMsg());
            } else {
                outResult.setStatus("F");
                outResult.setMsg(ret.getMsg());
            }
        }
        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(inpara.getUser(), "DN_Order_Igp", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        logger.debug("Exiting DN_PDA_IGP...");
        return outResult;
    }


    /**
     * 手持SO_过账
     */
    @Override
    public OrderIgpOutDTO giftSoOrderIgp(OrderIgpInDTO inpara, String version) {
        logger.debug("Entering DN_OrderIgp...");
        Date startDate = new Date();
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);

        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        if (!"S".equals(rfLogResult.getStatus())) {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
            return outResult;
        }
        outResult = soPDAService.giftSoOrderIgp(inpara);
        if ("S".equals(outResult.getStatus())) {
            // 过账
            InterfaceOutDTO postResult = stgDnDownService.postDn(outResult.getOrId(),
                    inpara.getOrderType(), "0", inpara.getUser());
            if (postResult == null) {
                outResult.setStatus("F");
                outResult.setMsg("Post Error!");
                return outResult;
            } else if ("TMS".equalsIgnoreCase(postResult.getIsCome())) {
                if (!"1".equalsIgnoreCase(postResult.getStatus())) {
                    outResult.setStatus("F");
                    outResult.setMsg("Post Error!");
                    return outResult;
                }
            } else if ("SAP".equalsIgnoreCase(postResult.getIsCome())) {
                if (!"S".equalsIgnoreCase(postResult.getStatus())) {
                    outResult.setStatus("F");
                    outResult.setMsg("Post Error!");
                    return outResult;
                }
            }
            // 出入库
            OrderGoodsTransOutDTO ret;
            inpara.setOrno(outResult.getOrId());

            ret = stgDnDownService.giftSoGoodsDelivery(inpara);

            if ("0".equals(ret.getStatus())) {
                outResult.setStatus("S");
                outResult.setMsg(ret.getMsg());
            } else {
                outResult.setStatus("F");
                outResult.setMsg(ret.getMsg());
            }
        }
        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(inpara.getUser(), "DN_Order_Igp", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        logger.debug("Exiting DN_PDA_IGP...");
        return outResult;
    }

    /**
     * 手持SO_查询条码明细
     */
    @Override
    public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
        OdsSoScanInfoDTO dto = new OdsSoScanInfoDTO();
        WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
        Date startDate = new Date();
        // 拼装查询条件
        dto.setSoNo(inpara.getOrderNo());
        dto.setScannedBy(inpara.getUser());
        dto.setOrderType(inpara.getOrderType());
        dto.setFinishFlag("0");
        // 引用 OdsPoScanInfoService
        OdsSoScanInfoService service = SpringApplicationContextHolder.getBean("odsSoScanInfoService");
        // 按照条件查询到想要的结果
        List<OdsSoScanInfoDTO> list = service.getOdsSoScanInfos(dto);
        if (list != null && !list.isEmpty()) {
            List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
            for (OdsSoScanInfoDTO info : list) {
                OrderDelDetialDTO tempDTO = new OrderDelDetialDTO();
                tempDTO.setBarcode(info.getBarcode());
                tempDTO.setQty(info.getQty().toString());
                tempDTO.setSapOrderNo(info.getSoNo());
                tempDTO.setRowId(info.getRowId().toString());
                detial.add(tempDTO);
            }
            outResult.setTotal(list.size() + "");
            outResult.setDetial(detial);
            System.out.println("-------------------------------------------------------" + detial + "-------------------------------------------------");
            Date endDate = new Date();
            // PDA 日志记录
            soPDAService.writeLog(inpara.getUser(), "SO_PDA_GetDetailList",
                    inpara.getSign(), context, "", CommonTool.getFormatDateToStr(startDate),
                    CommonTool.getFormatDateToStr(endDate), inpara, outResult);
            return outResult;
        } else {
            outResult.setTotal("0");
            return outResult;
        }
    }

    /**
     * 手持SO_扫描单
     */
    @Override
    public OrderUploadOutDTO soOrderScan(OrderUploadInDTO inpara, String version) {
        logger.debug("Entering SO_PDA_OrderScan......");

        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            outResult = soPDAService.scanSoCheck(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(inpara.getUser(), "SO_Order_SCAN", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    /**
     * 手持SO_扫描单
     */
    @Override
    public OrderUploadOutDTO giftSoOrderScan(OrderUploadInDTO inpara, String version) {
        logger.debug("Entering SO_PDA_OrderScan......");

        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            outResult = soPDAService.scanGiftSoCheck(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(inpara.getUser(), "SO_Order_SCAN", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    @Override
    public OrderUploadOutDTO soOrderScanOldBarcode(OrderUploadInDTO inpara, String version) {
        logger.debug("Entering SO_PDA_OrderScan......");

        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = soPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            outResult = soPDAService.scanSoOldBarcodeCheck(inpara);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(inpara.getUser(), "SO_Order_SCAN", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    @Override
    public WmsOrderDelListOutDTO getFifo(WmsOrderDelListInDTO inpara, String location, String materialNo) {
        logger.debug("Entering SO_PDA_FIFO.......");

        return stgDnDownService.getFifoList(inpara, location, materialNo);
    }

    @Override
    public OrderUploadOutDTO soOrderScanBarcodeExcel(OrderUploadInDTO inpara) {
        logger.debug("Entering SO_PDA_OrderScan......");
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        OrderUploadOutDTO outResult = soPDAService.scanSoCheck(inpara);
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        soPDAService.writeLog(inpara.getUser(), "SO_Order_SCAN", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }
}

package com.haier.openplatform.wms.transfer.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sapinterface.GoodsMovementToSap;
import com.haier.hevwms.transfer.service.OdsTransferDtlService;
import com.haier.hevwms.transfer.service.OdsTransferInfoService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import com.haier.openplatform.wms.transfer.service.OdsTransferDtlServiceClient;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Title: OdsTransferDtlServiceClientImpl.java
 * @Description:
 * @author: zhangll
 * @date: 2018年11月7日 下午2:58:25
 */
public class OdsTransferDtlServiceClientImpl implements OdsTransferDtlServiceClient {

    /**
     * @Fields log: 用一句话描述该文件做什么
     */
    private static final Logger log = LoggerFactory.getLogger(OdsTransferDtlServiceClientImpl.class);

    @Resource
    private WebServiceContext context;
    private RfWsService rfWsService;
    private OdsTransferDtlService odsTransferDtlService;
    private OdsTransferInfoService odsTransferInfoService;

    public OdsTransferInfoService getOdsTransferInfoService() {
        return odsTransferInfoService;
    }

    public void setOdsTransferInfoService(OdsTransferInfoService odsTransferInfoService) {
        this.odsTransferInfoService = odsTransferInfoService;
    }

    public OdsTransferDtlService getOdsTransferDtlService() {
        return odsTransferDtlService;
    }

    public void setOdsTransferDtlService(OdsTransferDtlService odsTransferDtlService) {
        this.odsTransferDtlService = odsTransferDtlService;
    }

    public WebServiceContext getContext() {
        return context;
    }

    public void setContext(WebServiceContext context) {
        this.context = context;
    }

    public RfWsService getRfWsService() {
        return rfWsService;
    }

    public void setRfWsService(RfWsService rfWsService) {
        this.rfWsService = rfWsService;
    }

    @Override
    public Pager<OdsTransferDtlDTO> searchOdsTransferDtls(long page, long rows, OdsTransferDtlDTO odsTransferDtlDTO) {
        Pager<OdsTransferDtlDTO> pager = new Pager<OdsTransferDtlDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);

        Pager<OdsTransferDtlDTO> temp = odsTransferDtlService.searchOdsTransferDtls(pager, odsTransferDtlDTO);
        long totalSize = temp.getTotalRecords();
        List<OdsTransferDtlDTO> listInfo = temp.getRecords();
        pager.setRecords(listInfo);
        pager.setTotalRecords(totalSize);
        return pager;
    }

    @Override
    public Long searchOdsTransferDtlsCount(OdsTransferDtlDTO odsTransferDtlDTO) {
        return odsTransferDtlService.searchOdsTransferDtlsCount(odsTransferDtlDTO);
    }

    @Override
    public OrderDeleteOutDTO orderDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
        WmsOrderDeleteIn in = new WmsOrderDeleteIn();
        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        BeanUtils.copyProperties(in, inpara);
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(), in.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            String[] barcodes = inpara.getBarcode().split(",");
            for (int i = 0; i < barcodes.length; i++) {
                inpara.setBarcode(barcodes[i]);
                // 调用service
                outResult = odsTransferDtlService.orderDelete(in);
            }
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        rfWsService.writeLog(in.getUser(), "Transfer_Order_Delete", in.getSign(),
                context, outResult.getStatus(),
                CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), in, outResult);
        return outResult;
    }

    @Override
    public OrderDeleteOutDTO ordersDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
        WmsOrderDeleteIn in = new WmsOrderDeleteIn();
        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        BeanUtils.copyProperties(in, inpara);
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(), in.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            // 调用service
            outResult = odsTransferDtlService.orderDelete(in);
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        rfWsService.writeLog(in.getUser(), "Transfer_Order_Delete", in.getSign(),
                context, outResult.getStatus(),
                CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), in, outResult);
        return outResult;
    }

    @Override
    public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
        WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
        // 调用时间
        Date startDate = new Date();
        // 权限校验
        List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
        if ("TRANSFER".equals(inpara.getDocType())) {
            OdsTransferDtlDTO info = new OdsTransferDtlDTO();
            info.setTransNo(inpara.getOrderNo());
            info.setInOutFlag("0");
            List<OdsTransferDtlDTO> list = odsTransferDtlService.getListByParams(info);
            if (list == null) {
                return outResult;
            }
            for (OdsTransferDtlDTO scanDTO : list) {
                OrderDelDetialDTO dto = new OrderDelDetialDTO();
                dto.setBarcode(scanDTO.getBarcode());
                dto.setQty(scanDTO.getQty().toString());
                dto.setSapOrderNo(scanDTO.getOrderNo());
                dto.setRowId(scanDTO.getRowId().toString());
//			    dto.setLocation(scanDTO.getLocation());
                detial.add(dto);
            }
            outResult.setTotal(list.size() + "");
        }
        outResult.setDetial(detial);
        // 调用时间
        Date endDate = new Date();
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        rfWsService.writeLog(inpara.getUser(), "Transfer_Order_GetCarlist",
                inpara.getSign(), context, "",
                CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);
        return outResult;
    }

    @Override
    public OrderIgpOutDTO orderPosting(OrderIgpInDTO inpara, String giLocation, String grLocation, String sapFlag) throws IllegalAccessException, InvocationTargetException {

        log.debug("Entering Transfer Posting...");
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        WmsOrderIgpOut result = new WmsOrderIgpOut();
        WmsOrderIgpIn in = new WmsOrderIgpIn();
        BeanUtils.copyProperties(in, inpara);
        if (!StringUtils.isEmpty(giLocation) && giLocation.equalsIgnoreCase(grLocation)) {
            result = odsTransferDtlService.orderOgp(in);
        } else {
            //调用SAP接口过账
            log.info("<<<GoodsMovementToSap>>> GoodsMovementToSap By portal!");
            GoodsMovementToSap gmts = new GoodsMovementToSap(inpara.getOrno(), sapFlag);
            String sapResult = gmts.exchangeWithSap();
            if ("S".equals(sapResult)) {
                result = odsTransferDtlService.orderOgp(in);
            } else {
                result.setMsg("Exchange with sap failure");
            }
        }
        BeanUtils.copyProperties(outResult, result);

        return outResult;
    }

    @Override
    public OrderIgpOutDTO orderOgp(OrderIgpInDTO inpara, String version, String sapFlag) throws IllegalAccessException, InvocationTargetException {

        log.debug("Entering CustomerOrderIgp...");
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        WmsOrderIgpOut result = new WmsOrderIgpOut();
        result.setStatus("1");
        WmsOrderIgpIn in = new WmsOrderIgpIn();
        BeanUtils.copyProperties(in, inpara);
        // 调用时间
        Date startDate = new Date();

        // 权限校验
        RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(), in.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            log.debug("Sign check successful...");
            // 调用service
            if ("TRANSFER".equals(in.getDocType())) {
                //检测订单是否已经全部扫描完毕
//		    	long scanFlag =  odsTransferDtlService.scanStatus(inpara.getOrno());
                List<OdsTransferInfoDTO> list = odsTransferInfoService.scanStatus(inpara.getOrno());
                String finishFlag = "1", dbSapFlag = "0";
                for (OdsTransferInfoDTO dto : list) {
                    if ("0".equals(dto.getFinishFlag())) {
                        finishFlag = "0";
                        break;
                    }
                    if (!"0".equals(dto.getSapFlag())) {
                        dbSapFlag = dto.getSapFlag();
                        break;
                    }
                }
                if ("1".equals(finishFlag)) {
                    if ("0".equals(dbSapFlag)) {
                        //扫描完毕,更改信息
                        odsTransferDtlService.updateSapInfo(inpara);
                        if (list.get(0).getGrLocation().equalsIgnoreCase(list.get(0).getGiLocation())) {
                            //不跨location,直接修改bin位
                            result = odsTransferDtlService.orderOgp(in);
                        } else {
                            //跨location, 调用SAP接口过账
                            log.info("<<<GoodsMovementToSap>>> GoodsMovementToSap By PDA");
                            GoodsMovementToSap gmts = new GoodsMovementToSap(inpara.getOrno(), sapFlag);
                            String sapResult = gmts.exchangeWithSap();
                            if ("S".equals(sapResult)) {
                                result = odsTransferDtlService.orderOgp(in);
                            } else {
                                result.setMsg("Exchange with sap failure");
                            }
                        }
                    } else {
                        if ("1".equals(dbSapFlag)) {
                            result.setMsg("This Order has already Posting Success!");
                        } else {
                            result.setMsg("Please post this order on portal!");
                        }
                    }
                } else {
                    result.setMsg("Order Is Not Finished");
                }
            }
        } else {
            log.error("sign check failed, user must re-login...");
            result.setStatus(rfLogResult.getStatus());
            result.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        BeanUtils.copyProperties(outResult, result);
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        rfWsService.writeLog(in.getUser(), "Transfer_Order_Igp", in.getSign(),
                context, result.getStatus(),
                CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), in, result);

        log.debug("Exiting Transfer Order Igp...");
        return outResult;
    }

    @Override
    public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
        log.debug("Entering Transfer Order Scan......");
        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        // 调用时间
        Date startDate = new Date();

        // 权限校验
        RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(), inpara.getSign(), version);
        if ("S".equals(rfLogResult.getStatus())) {
            if ("TRANSFER".equals(inpara.getDoctype())) {
                outResult = odsTransferDtlService.scanTransfer(inpara);
            }
        } else {
            outResult.setStatus(rfLogResult.getStatus());
            outResult.setMsg(rfLogResult.getMsg());
        }
        // 返回时间
        Date endDate = new Date();
        BeanUtils.copyProperties(outResult, outResult);
        // RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
        rfWsService.writeLog(inpara.getUser(), "Transfer_Order_Upload", inpara.getSign(),
                context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
                CommonTool.getFormatDateToStr(endDate), inpara, outResult);

        return outResult;
    }

}

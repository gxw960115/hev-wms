package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.StgDnDownDAO;
import com.haier.hevwms.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.sap.conn.jco.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.Map.Entry;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className:
 * @description: 根据订单创建日期或者订单号，下载销售订单抬头和明细到WMS系统，以供后续发货参考。
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月30日 下午3:51:26
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年9月30日		LJZ			v1.0.0			create
 */

public class DownloadDnFromSap {
    // RFC函数名
    String rfc_id = "ZSD_HEV_WMS_DOWNLOAD_DN";
    String system_id = "HEVWMS";
    String beginTime;
    String endTime;
    String soNo;
    String userName;
    private OperationLogDAO operationLogDAO;
    private StgDnDownDAO stgDnDownDAO;

    Logger logger = Logger.getLogger(DownloadDnFromSap.class);

    public DownloadDnFromSap(OperationLogDAO operationLogDAO,
                             StgDnDownDAO stgDnDownDAO,
                             String beginTime,
                             String endTime,
                             String soNo) {
        this.operationLogDAO = operationLogDAO;
        this.stgDnDownDAO = stgDnDownDAO;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.soNo = soNo;
    }

    public DownloadDnFromSap(String soNo, String beginTime, String endTime, String userName) {
        this.soNo = soNo;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.userName = userName;
        stgDnDownDAO = SpringApplicationContextHolder.getBean("stgDnDownDAO");
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
    }

    public InterfaceOutDTO exchangeWithSap() {
        logger.info("Download DN Start========>" + soNo);
        String message = "";
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("DownloadDnFromSap");
        // 返回结果result
        InterfaceOutDTO result = new InterfaceOutDTO();
        result.setStatus("S");
        result.setMsg("Download Success!");
        try {
            SapConnection.initSapConn();
            logger.debug("SAP connection successfully");
        } catch (Exception ex) {
            result.setStatus("E");
            result.setMsg("SAP Connection Failed!");
            message = ex.getMessage();
            log.setDescription("SAP Connection Failed:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            logger.info(ex);
            return result;
        }

        JCoDestination destination = null;
        JCoFunction function = null;
        try {
            destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            function = destination.getRepository().getFunction(rfc_id);
        } catch (JCoException e) {
            logger.info(e);
            result.setStatus("E");
            result.setMsg("SAP Function does not exist!");
            return result;
        }

        // 输入日期参数
        if (beginTime != null && !"".equals(beginTime)) {
            if (endTime != null && !"".equals(endTime)) {
                if (beginTime.equals(endTime)) {
                    function.getImportParameterList().setValue("DATE_FROM", beginTime);
                } else {
                    function.getImportParameterList().setValue("DATE_FROM", beginTime);
                    function.getImportParameterList().setValue("DATE_TO", endTime);
                }
            } else {
                function.getImportParameterList().setValue("DATE_FROM", beginTime);
            }
        }
        // 输入销售组织
        function.getImportParameterList().setValue("VKORG", "65C0");
        // 输入销售订单号
        if (soNo != null && !"".equals(soNo)) {
            function.getImportParameterList().setValue("VBELN", soNo);
        }
        logger.info("Download DN Input========>\n" + function.getImportParameterList());

        // 执行接口
        try {
            function.execute(destination);
        } catch (JCoException e) {
            message = e.getMessage();
            logger.error("Function execute error:" + message);
            log.setDescription("Function execute error:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("SAP Function execute error!");
            return result;
        }
        // 获取接口返回结果
        JCoTable codes = function.getTableParameterList().getTable("ZSD_DN_ITEM");
        logger.info("Download DN Output========>\n" + codes);
        if (codes != null && codes.getNumRows() > 0) {
            //SO No: VBELN    SO item No: POSNR
            Map<String, Set<String>> newOrder = new HashMap<String, Set<String>>();
            Map<String, Set<String>> oldOrder = new HashMap<String, Set<String>>();
            for (int i = 0; i < codes.getNumRows(); i++) {
                codes.setRow(i);
                Set<String> newItem = new HashSet<String>();
                // 判定Map中是否已经保存了新下载的OrderNumber,如果没有，则加入map，
                if (newOrder.get(codes.getString("VBELN".toUpperCase())) == null) {
                    newItem.add(codes.getString("POSNR".toUpperCase()));
                    newOrder.put(codes.getString("VBELN".toUpperCase()), newItem);
                } else {
                    //如果Map中已经有OrderNumber,则将其加入到Map对应的Set中
                    newItem = newOrder.get(codes.getString("VBELN".toUpperCase()));
                    newItem.add(codes.getString("POSNR".toUpperCase()));
                }
                // 判断从数据库查询的结果中，是否已经包含接口中下载的数据
                if (oldOrder.get(codes.getString("VBELN".toUpperCase())) == null) {
                    StgDnDownDTO oldTemp = new StgDnDownDTO();
                    oldTemp.setDnNo(codes.getString("VBELN".toUpperCase()));
                    // 查询数据库
                    List<String> oldPoItems = stgDnDownDAO.getSoItemsNoBySoNo(oldTemp);
                    // 将查询出的数据库保存到set集合中，并将Set集合保存到Map中
                    Set<String> oldItem = new HashSet<String>(oldPoItems);
                    oldOrder.put(codes.getString("VBELN".toUpperCase()), oldItem);
                }
            }

            Set<Entry<String, Set<String>>> entrySet = oldOrder.entrySet();
            for (Entry<String, Set<String>> oldSo : entrySet) {
                Set<String> oldItems = oldSo.getValue();
                Set<String> newItems = newOrder.get(oldSo.getKey());
                for (String exsitedItem : oldItems) {
                    boolean deleteFlag = false;
                    for (String checkItem : newItems) {
                        if (checkItem.equals(exsitedItem)) {
                            deleteFlag = true;
                            break;
                        }
                    }
                    if (!deleteFlag) {
                        StgDnDownDTO checkTemp = new StgDnDownDTO();
                        checkTemp.setDnNo(oldSo.getKey());
                        checkTemp.setDnItemNo(exsitedItem);
                        Long ifStart = stgDnDownDAO.ifScanningStart(checkTemp);
                        if (ifStart == 0) {
                            stgDnDownDAO.bankupDeletedItems(checkTemp);
                            stgDnDownDAO.deleteByDnItems(checkTemp);
                        }
                    }

                }
            }

            // 获取结果集中的数据
            for (int j = 0; j < codes.getNumRows(); j++) {
                codes.setRow(j);
                // 对订单进行过滤，只下载65C1工厂的订单
                String plant = codes.getString("WERKS");
                if ("65C1".equalsIgnoreCase(plant)) {
                    StgDnDownDTO so = new StgDnDownDTO();
                    // 销售订单号
                    so.setDnNo(codes.getString("VBELN"));
                    // 行项目 Item number
                    so.setDnItemNo(codes.getString("POSNR"));
                    // 订单类型
                    so.setSellOrderType(codes.getString("AUART"));
                    // 物料号 Material
                    so.setMaterialNo(codes.getString("MATNR"));
                    // 工厂 Plant
                    so.setPlant(codes.getString("WERKS"));
                    // 库位 Storage Location
                    so.setLocation(codes.getString("LGORT"));
                    // 数量
                    String qty = codes.getString("LFIMG");
                    if (qty == null || "".equals(qty)) {
                        qty = "0";
                    }
                    so.setQty(Double.valueOf(qty).longValue());
                    so.setFinishQty(0L);
                    so.setFinishFlag("0");
                    so.setDnClose("0");
                    // 单位
                    so.setUnit(codes.getString("VRKME"));

                    // 物料描述 Material Desc
                    String materialDesp = codes.getString("ARKTX");
                    if (materialDesp != null && !"".equals(materialDesp.trim())) {
                        materialDesp = CommonTool.replace(materialDesp, "'", " ");
                        materialDesp = CommonTool.replace(materialDesp, "\"", "");
                    }
                    so.setMaterialDesp(materialDesp);

                    // Customer Model
                    String customerModel = codes.getString("ZARKTX");
                    if (customerModel != null && !"".equals(customerModel.trim())) {
                        customerModel = CommonTool.replace(customerModel, "'", " ");
                        customerModel = CommonTool.replace(customerModel, "\"", "");
                    }
                    so.setCustomerModel(customerModel);
                    // 创建日期ERDAT
                    Date date = new Date();
                    so.setCreateDate(date);
                    so.setModifyDate(date);
                    // SAP_FLAG
                    so.setSapFlag("0");

                    // DN_CREATE_BY
                    so.setDnCreateBy(codes.getString("ERNAM"));
                    // DN_DOC_DATE
                    so.setDnDocDate(codes.getString("ERDAT"));
                    // customer no
                    so.setCustomerNo(codes.getString("KUNAG"));
                    so.setCustomerName(codes.getString("NAME"));
                    so.setDeliveryCode(codes.getString("KUNNR_SH"));
                    so.setDeliveryName(codes.getString("NAME_SH"));
                    so.setDeliveryDate(codes.getString("WADAT"));
                    so.setBilling(codes.getString("BILLING"));
                    so.setBillingItem(codes.getString("BILLING_ITEM"));
                    so.setCity(codes.getString("CITY1"));
                    so.setRegion(codes.getString("REGION"));

                    so.setCustomerPo(codes.getString("BSTKD"));
                    so.setDeliveryAddress(codes.getString("ZADDR"));
                    so.setPickingDate(codes.getString("KODAT"));
                    so.setVendorCode(codes.getString("KUNNR_SP"));
                    so.setVendorName(codes.getString("SP_NAME"));
                    so.setComeFromTms("SAP");

                    logger.info(so.toString());
                    // 查看接口下载的数据是否已存在数据库中
                    List<StgDnDownDTO> poList = stgDnDownDAO.getExistingDnItem(so);
                    if (poList == null || poList.size() == 0) {
                        so.setCreateBy(userName);
                        so.setCreateDate(new Date());
                        stgDnDownDAO.save(so);
                    } else {
                        Long ifStart = stgDnDownDAO.ifScanningStart(so);
                        // 判断当前订单是否已经在扫描，如果在扫描，则只更新时间
                        // 若没有进行扫描，全部更新
                        if (ifStart == 0) {
                            so.setModifyBy(userName);
                            so.setModifyDate(new Date());
                            stgDnDownDAO.updateByDnItem(so);
                        }
                    }
                }
            }
        } else {
            // 判断单号是否为空
            if (soNo != null && !"".equalsIgnoreCase(soNo) && soNo.length() > 1) {
                StgDnDownDTO dto = new StgDnDownDTO();
                dto.setDnNo(soNo);
                // 根据单号查询数据
                List<StgDnDownDTO> stgDnDownList = stgDnDownDAO.getStgDnDownListByParam(dto);
                if (stgDnDownList != null && stgDnDownList.size() > 0) {
                    for (int i = 0; i < stgDnDownList.size(); i++) {
                        StgDnDownDTO checkDto = stgDnDownList.get(i);
                        Long ifStart = stgDnDownDAO.ifScanningStart(checkDto);
                        // 如果没有开始扫描，则进行备份并删除
                        if (ifStart == 0) {
                            stgDnDownDAO.bankupDeletedItems(checkDto);
                            stgDnDownDAO.deleteByDnItems(checkDto);
                        }
                    }
                }
            }
            logger.info("Order:" + soNo + ", No data is downloaded!");
            log.setDescription("No data is downloaded!");
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("No data is downloaded!");
        }
        logger.info("Download DN End========>" + soNo);
        return result;
    }

}
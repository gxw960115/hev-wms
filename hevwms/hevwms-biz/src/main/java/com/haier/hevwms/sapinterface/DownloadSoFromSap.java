package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.StgDnDownDAO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.sap.conn.jco.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.Map.Entry;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className: DownloadSOFromSap.java
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

public class DownloadSoFromSap {
    // RFC函数名
    String rfc_id = "ZSD_AEV_INT_01";
    String system_id = "HEVWMS";
    String beginTime;
    String endTime;
    String soNo;
    String userName;
    private OperationLogDAO operationLogDAO;
    private StgDnDownDAO stgDnDownDAO;
    Logger logger = Logger.getLogger(DownloadSoFromSap.class);

    public DownloadSoFromSap(String soNo, String beginTime, String endTime, String userName) {
        this.soNo = soNo;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.userName = userName;
//        stgDnDownDAO = SpringApplicationContextHolder.getBean("stgDnDownDAO");
//        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
    }

    public String exchangeWithSap() {
        logger.info("Exchange with SAP start------------------------");
        String result = "S";
        String message;
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("DownloadSoFromSap");

        try {
            SapConnection.initSapConn();
        } catch (Exception ex) {
            result = "E";
            message = ex.getMessage();
            log.setDescription("Sap Connection Failed:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            logger.info(ex);
        }
        logger.info("SAP connection successfully");

        JCoDestination destination = null;
        JCoFunction function = null;
        try {
            destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            function = destination.getRepository().getFunction(rfc_id);
        } catch (JCoException e) {
            e.printStackTrace();
        }

        // 输入日期参数
        if (beginTime != null) {
            if (endTime != null) {
                if (beginTime.equals(endTime)) {
                    function.getImportParameterList().setValue("ERDAT_B", beginTime);
                } else {
                    function.getImportParameterList().setValue("ERDAT_B", beginTime);
                    function.getImportParameterList().setValue("ERDAT_E", endTime);
                }
            } else {
                function.getImportParameterList().setValue("ERDAT_B", beginTime);
            }
        }
        // 输入销售组织
        if (function != null) {
            function.getImportParameterList().setValue("VKORG", "65C0");
        } else {
            return "E";
        }
        // 输入销售订单号
        if (soNo != null && !"".equals(soNo)) {
            function.getImportParameterList().setValue("VBELN", soNo);
        }
        logger.info("\n" + function.getImportParameterList());

        // 执行接口
        try {
            function.execute(destination);
        } catch (JCoException e) {
            logger.error("Function execute error:" + e.getMessage());
            e.printStackTrace();
        }
        // 获取接口返回结果
        JCoTable codes = function.getTableParameterList().getTable("SO_DETAIL");
        logger.info("SO_DETAIL Table=========\n" + codes);
        if (codes != null) {
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
//							stgDnDownDAO.bankupDeletedItems(checkTemp);
                            stgDnDownDAO.deleteByDnItems(checkTemp);
                        }
                    }

                }
            }

            // 获取结果集中的数据
            for (int j = 0; j < codes.getNumRows(); j++) {
                codes.setRow(j);
                String plant = codes.getString("WERKS");
                if ("65C1".equalsIgnoreCase(plant)) {
                    StgDnDownDTO so = new StgDnDownDTO();
                    // 订单类型
                    so.setSellOrderType(codes.getString("AUART"));
                    // 销售订单号
                    so.setSellNo(codes.getString("VBELN"));
                    // 创建日期ERDAT
                    //so.setCreateDate(codes.getString("ERDAT"));
                    so.setCreateDate(new Date());
                    // Sales Organization销售组织
//				codes.getString("VKORG");
                    // 客户的PO号码 Customer PO
//				codes.getString("BSTKD");
                    // 售达方 Sold-to
                    so.setCustomerNo(codes.getString("KUNNR"));
                    // 售达方名称 Name
                    so.setCustomerName(codes.getString("NAME1"));
                    // 送达方 Ship-to
                    so.setDeliveryCode(codes.getString("KUNWE"));
                    // 送达方名称
                    so.setDeliveryName(codes.getString("NAME2"));
                    // 行项目 Item number
                    so.setDnItemNo(codes.getString("POSNR"));
                    // 工厂 Plant
                    so.setPlant(codes.getString("WERKS"));
                    // 物料号 Material
                    so.setMaterialNo(codes.getString("MATNR"));
                    // 物料描述 Material Desc
                    so.setMaterialDesp(codes.getString("ARKTX"));
                    // 销售单位数量  QTY in Sales Units
//				codes.getString("KWMENG");
                    // 销售单位 UoM
//				codes.getString("ZIEME");
                    // 基本单位数量 QTY in Basic Units
                    String qty = codes.getString("BMENG");
                    if ("".equals(qty) || qty == null) {
                        qty = "0";
                    }
                    so.setQty(Long.parseLong(qty));
                    // 基本单位 Basic UoM
                    so.setUnit(codes.getString("BMEINS"));
                    // 预计发货日期 Schedule line date
                    so.setDeliverDate(codes.getString("EDATU"));
                    // 库位 Storage Location
                    so.setLocation(codes.getString("LGORT"));
                    // 销售退回原因 Reason for rejection of SO
//				codes.getString("ABGRU");
                    /*
                     * 发货状态 Delivery status
                     * A：未发货，B：部分发货， C:发货完成
                     * 加判断：SO 和item level 都不可以是C status
                     */
//				codes.getString("LFSTK");
                    Date date = new Date();
                    so.setCreateDate(date);
                    so.setModifyDate(date);

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
            log.setDescription("No data is downloaded!");
            operationLogDAO.save(log);
            result = "E";
        }
        logger.info("Download Po Finish!");
        return result;
    }

}
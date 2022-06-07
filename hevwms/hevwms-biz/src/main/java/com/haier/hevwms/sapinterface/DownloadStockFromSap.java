package com.haier.hevwms.sapinterface;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.inventory.dao.StgSapStockDAO;
import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import com.haier.openplatform.wms.security.dto.OperationLogDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

/**
 * Copyright: Copyright © 2013-2018
 *
 * @className: PostSoToSap.java
 * @description: 必传plant, 可传location, 不传mateialNo
 * @version: v1.0.0
 * @author: SJK
 * @date 2018年11月14日 上午9:19:35
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年10月14日		SJK			v1.0.0			create
 */
public class DownloadStockFromSap {
    String rfc_id = "Z_MM_INT_IM_30_AEV";
    String plantB;// 工厂从
    String plantE;// 工厂
    String matCodeB;// 物料从
    String matCodeE;// 到
    String locationB;// 库存地点从
    String locationE;// 到
    String userName;
    private StgSapStockDAO stgSapStockDAO;
    private OperationLogDAO operationLogDAO;

    Logger logger = Logger.getLogger(DownloadPoFromSap.class);

    public DownloadStockFromSap(String plantB, String plantE, String matCodeB,
                                String matCodeE, String locationB, String locationE, String userName) {
        this.plantB = plantB;
        this.plantE = plantE;
        this.matCodeB = matCodeB;
        this.matCodeE = matCodeE;
        this.locationB = locationB;
        this.locationE = locationE;
        this.userName = userName;
        stgSapStockDAO = SpringApplicationContextHolder.getBean("stgSapStockDAO");
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
    }

    public InterfaceOutDTO exchangeWithSap() {
        logger.info("Exchange with sap start------------------------");
        InterfaceOutDTO result = new InterfaceOutDTO();
        result.setStatus("S");
        result.setMsg("Download success!");
        String message;
        OperationLogDTO log = new OperationLogDTO();
        log.setUserName(userName);
        log.setAppName("DownloadStockFromSap");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            SapConnection.initSapConn();
            logger.info("SAP connection successfully");
        } catch (Exception ex) {
            message = ex.getMessage();
            log.setDescription("Sap Connection Failed:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            logger.info(ex);
            result.setStatus("E");
            result.setMsg("SAP connection failed!");
            return result;
        }

        try {
            JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            JCoFunction function = destination.getRepository().getFunction(rfc_id);

            // 定义输入输出参数
            JCoParameterList inParam = function.getImportParameterList();
            StgSapStockDTO dto = new StgSapStockDTO();
            if (plantB != null) {
                inParam.setValue("WERKS_B", plantB);
                dto.setPlant(plantB);
            }
            if (plantE != null && !plantE.equals(plantB)) {
                inParam.setValue("WERKS_E", plantE);
            }
            if (matCodeB != null) {
                inParam.setValue("MATNR_B", matCodeB);
                dto.setMaterialNo(matCodeB);
            }
            if (matCodeE != null && !matCodeE.equals(matCodeB)) {
                inParam.setValue("MATNR_E", matCodeE);
            }

            if (locationB != null) {
                inParam.setValue("LGORT_B", locationB);
                dto.setLocation(locationB);
            }
            if (locationE != null && !locationE.equals(locationB)) {
                inParam.setValue("LGORT_E", locationE);
            }

            logger.info("INPUT Parameters=========>" + function.getImportParameterList());
            function.execute(destination);

            JCoTable outTable = function.getTableParameterList().getTable("ITAB_RESULT");
            logger.info("OUTPUT Table=========>" + outTable);

            //根据参数删除
            stgSapStockDAO.deleteSapStockByLocation(dto);

            if (outTable != null && outTable.getNumRows() > 0) {
                for (int m = 0; m < outTable.getNumRows(); m++) {
                    outTable.setRow(m);
                    /**
                     ITAB_RESULT	MATNR	CHAR	18	Material Number
                     ITAB_RESULT	WERKS	CHAR	4	Plant
                     ITAB_RESULT	LGORT	CHAR	4	Storage Location
                     ITAB_RESULT	LABST	QUAN	13	Valuated Unrestricted-Use Stock
                     ITAB_RESULT	DISPO	CHAR	3	MRP Controller (Materials Planner)
                     ITAB_RESULT	STPRS	CURR	11	Standard price
                     ITAB_RESULT	PEINH	DEC	    5	Price Unit
                     ITAB_RESULT	MAKTX	CHAR	40	Material Description (Short Text)
                     ITAB_RESULT	QTY_SUM	QUAN	13	Valuated Unrestricted-Use Stock
                     ITAB_RESULT	VALUE_SUM	CURR	13	Value of Total Valuated Stock
                     ITAB_RESULT	MEINS	UNIT	3	Base Unit of Measure
                     */
                    String plant = outTable.getString("WERKS");
                    if ("65C1".equalsIgnoreCase(plant)) {
                        StgSapStockDTO temp = new StgSapStockDTO();
                        temp.setMaterialNo(outTable.getString("MATNR"));
                        temp.setPlant(outTable.getString("WERKS"));

                        temp.setQty(Double.valueOf(outTable.getString("QTY_SUM")).longValue());
                        temp.setMaterialDesp(outTable.getString("MAKTX"));
                        temp.setUnit(outTable.getString("MEINS"));

                        Date date = new Date();
                        temp.setSapDownDate(sdf.format(date));
                        temp.setCreateDate(date);
                        temp.setMrpController(outTable.getString("DISPO"));
                        temp.setPrice(Double.valueOf(outTable.getString("PEINH")));
                        temp.setTotalValue(Double.valueOf(outTable.getString("VALUE_SUM")));
//						temp.setCustomerModel(outTable.getString("MAKTX"));
                        temp.setLocation(this.locationMapping(outTable.getString("LGORT")));
                        try {
                            //校验对应工厂，库位，物料是否已经存在
                            Integer num = stgSapStockDAO.checkSapStock(temp);
                            if(num > 0) {
                                stgSapStockDAO.updateQty(temp);
                            }else {
                                stgSapStockDAO.save(temp);
                            }
                        } catch (Exception e) {
                            log.setDescription("Insert sap stock fail! Material:" + outTable.getString("MATNR") + ", " + e.getMessage());
                            operationLogDAO.save(log);
                            continue;
                        }
                    }
                }
            } else {
                log.setDescription("No data is downloaded!");
                operationLogDAO.save(log);
                result.setStatus("E");
                result.setMsg("No data is downloaded!");
            }
        } catch (Exception e) {
            message = e.getMessage();
            logger.error("Catch Exception when download PO: " + message);
            log.setDescription("Execute Sap Function failed:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("SAP function execute failed!");
            return result;
        }
        logger.info("Download Inventory Success!");
        return result;
    }

    private String locationMapping(String location) {
        switch (location) {
            case "26S1":
                location = "S101";
                break;
            case "26S2":
                location = "S201";
                break;
            case "26S3":
                location = "S301";
                break;
            case "26S4":
                location = "S401";
                break;
            case "26S5":
                location = "S501";
                break;
            case "HTN1":
                location = "N101";
                break;
            case "CPC2":
                location = "C201";
                break;
            case "CPN1":
                location = "N101";
                break;
            case "CPS1":
                location = "S101";
                break;
            case "CPS2":
                location = "S201";
                break;
            case "CPS3":
                location = "S301";
                break;
            case "CPS4":
                location = "S401";
                break;
            case "CPS5":
                location = "S501";
                break;
            case "DMS1":
                location = "S101";
                break;
            case "DMS2":
                location = "S201";
                break;
            case "DMS3":
                location = "S301";
                break;
            case "DMS4":
                location = "S401";
                break;
            case "DMS5":
                location = "S501";
                break;
            case "DMC2":
                location = "C201";
                break;
            case "DMN1":
                location = "N101";
                break;
            case "MMN1":
                location = "N101";
                break;
            case "MMC2":
                location = "C201";
                break;
            case "NKS1":
                location = "S101";
                break;
            case "NKS2":
                location = "S201";
                break;
            case "NKS3":
                location = "S301";
                break;
            case "NKS4":
                location = "S401";
                break;
            case "NKS5":
                location = "S501";
                break;
            case "NKC2":
                location = "C201";
                break;
            case "NKN1":
                location = "N101";
                break;
            case "PIN1":
                location = "N101";
                break;
            case "VHN1":
                location = "N101";
                break;
            case "VHC2":
                location = "C201";
                break;
            default:
                location = location;
                break;
        }
        return location;
    }

}

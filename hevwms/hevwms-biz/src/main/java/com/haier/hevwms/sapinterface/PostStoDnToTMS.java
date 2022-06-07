package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.hevwms.sto.service.tms.*;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.sap.conn.jco.*;
import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.util.ArrayList;
import java.util.List;

public class PostStoDnToTMS {
    Logger logger = Logger.getLogger(PostDnToTMS.class);
    String rfc_id = "ZMM_HEV_WMS_POST_GR";
    String system_id = "HEVWMS";
    String[] orderNos;
    String orderType;
    String message;
    private String userName;
    private OperationLogDAO operationLogDAO;
    private OdsSoGrInfoDAO odsSoGrInfoDAO;
    private GetWmsWebService getTmsDNService;

    public PostStoDnToTMS(String[] orderNos, OperationLogDAO operationLogDAO, OdsSoGrInfoDAO odsSoGrInfoDAO) {
        this.orderNos = orderNos;
        this.operationLogDAO = operationLogDAO;
        this.odsSoGrInfoDAO = odsSoGrInfoDAO;
    }

    public PostStoDnToTMS(String orderNo, String orderType, String userName) {
        this.orderNos = orderNo.split(",");
        this.orderType = orderType;
        this.userName = userName;
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        odsSoGrInfoDAO = SpringApplicationContextHolder.getBean("odsSoGrInfoDAO");
        getTmsDNService = SpringApplicationContextHolder.getBean("getTmsDNService");
    }



    public InterfaceOutDTO exchangeWithTMS() {
        System.setProperty("https.protocols", "TLSv1.2");
        logger.info("Post DN Start========>" + orderNos[0]);
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("PostDnToTMS");
        InterfaceOutDTO result = new InterfaceOutDTO();

        LoadParam loadParam = new LoadParam();
        List<Load> loadList = new ArrayList<>();
        Load load = new Load();
        List<Material> materialList = new ArrayList<>();
        String tradeId = String.valueOf(System.currentTimeMillis());
        String stoNo = null;
        logger.error("tradeId:========================================="+tradeId);
        try {

            for (int i = 0; i < orderNos.length; i++) {
                OdsSoGrInfoDTO odsSoGrInfo = new OdsSoGrInfoDTO();
                odsSoGrInfo.setOrderNo(orderNos[i]);
                odsSoGrInfo.setSapFlag(orderType);
                //根据出入库订单查询过账数据
                OdsSoGrInfoDTO odsSoGrInfoDTO = odsSoGrInfoDAO.getOdsSoGrGiInfoByOGPOrIGP(odsSoGrInfo);
                if(odsSoGrInfoDTO == null) {
                    result.setStatus("E");
                    result.setMsg(orderNos[0] + " The order has been posted and cannot be reposted!");
                    return result;
                }
                //物料详细集合
                List<OdsSoGrInfoDTO> list = odsSoGrInfoDAO.getMatListByStodn(odsSoGrInfoDTO.getStodnNo(), orderType);
                    if(list.size() <= 0){
                    result.setStatus("E");
                    result.setMsg("The material information is wrong and cannot be posted!");
                    return result;
                }
                for(OdsSoGrInfoDTO dto : list) {
                    Material material = new Material();
                    //物料编码
                    material.setMaterialCode(dto.getMaterialNo());
                    //过账数量
                    material.setQty(dto.getQty().toString());
                    materialList.add(material);
                }
                load.setMaterialList(materialList);
                //出入库订单号
                load.setOrderCode(odsSoGrInfoDTO.getOrderNo());
                //类型
                load.setDocType("sto");
                //车次
                load.setTrain(odsSoGrInfoDTO.getCarNo());
                //STODN 号
                load.setDn(odsSoGrInfoDTO.getStodnNo());
                loadList.add(load);
                loadParam.setLoadList(loadList);
                loadParam.setTradeId(tradeId);
                //调用TMS 现接口缺少用于区分so，sto的参数
                WmsWebService wmsWebService = getTmsDNService.getWmsWebService();
                logger.info("STODN OUT Post Incoming parameters: " + loadParam.toString());
                StatusResult statusResult =  wmsWebService.pushLoadInfo(loadParam);
                logger.info("STODN Post Status:" + statusResult.toString());
                // 1：成功 0：失败
                if("1".equals(statusResult.getStatus())) {
                    result.setStatus(statusResult.getStatus());
                    result.setMsg(statusResult.getMsg());
                    //修改改订单状态为完成
                    odsSoGrInfoDAO.updateFlag("1", "SUCCESS", orderNos[i], odsSoGrInfoDTO.getStodnNo(), userName);
                    odsSoGrInfoDAO.updateGiGrFlag("1", "SUCCESS", orderNos[i], odsSoGrInfoDTO.getStodnNo(), userName);
                } else {
                    //修改改订单状态为失败
                    odsSoGrInfoDAO.updateFlag("2", "FALSE", orderNos[i], odsSoGrInfoDTO.getStodnNo(), userName);
                    odsSoGrInfoDAO.updateGiGrFlag("2", "TMS FALSE", orderNos[i], odsSoGrInfoDTO.getStodnNo(), userName);
                    logger.info("Order:" + orderNos[i] + ", no data to post!");
                    log.setDescription("Order:" + orderNos[i] + ", no data to post!");
                    operationLogDAO.save(log);
                    result.setStatus("E");
                    result.setMsg("POST TMS SUCCESS，BUT RETURN FAILSE!");
                }
            }
            logger.info("Post DN End========>" + orderNos[0]);
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
            logger.error("Post DN failed: " + e.getMessage());
            log.setDescription("Post DN failed: " + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("SAP function execute failed! Please contact the administrator.");
            return result;
        }

        return result;
    }

    public InterfaceOutDTO exchangeWithSap() {
        logger.info("Exchange with sap start------------------------");
        InterfaceOutDTO result = new InterfaceOutDTO();
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("PostStodnInToSap");

        try {
            SapConnection.initSapConn();
            logger.info("SAP connection successfully");
        } catch (Exception ex) {
            logger.info(ex);
            message = ex.getMessage();
            log.setDescription("Sap Connection Failed:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("SAP connection failed!");
            return result;
        }

        try {
            JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            JCoFunction function = destination.getRepository().getFunction(rfc_id);

            // 定义输入参数
            JCoParameterList parameterList = function.getTableParameterList();
            JCoTable tableIn = parameterList.getTable("IT_GR_INPUT");
            tableIn.clear();

            for (int i = 0; i < orderNos.length; i++) {
                //根据出入库订单查询过账数据
                OdsSoGrInfoDTO odsSoGrInfoDTO = new OdsSoGrInfoDTO();
                odsSoGrInfoDTO.setOrderNo(orderNos[i]);
                odsSoGrInfoDTO.setOrderType(orderType);
                OdsSoGrInfoDTO odsSoGrInfo = odsSoGrInfoDAO.getOdsSoGrGiInfoByOGPOrIGP(odsSoGrInfoDTO);
                List<OdsSoGrInfoDTO> list = odsSoGrInfoDAO.getMatListByStodn(odsSoGrInfo.getStodnNo(), orderType);
                if (list != null && list.size() > 0) {
                    for (OdsSoGrInfoDTO dto : list) {
                        tableIn.appendRow();
                        tableIn.setValue("EBELN", dto.getStoNo());
                        tableIn.setValue("EBELP", dto.getStoItem());
                        tableIn.setValue("VBELN", dto.getStodnNo());
                        tableIn.setValue("POSNR", dto.getStodnItem());
                        tableIn.setValue("MATNR", dto.getMaterialNo());
                        tableIn.setValue("LFIMG", dto.getQty());
                        tableIn.setValue("LGORT", dto.getGrLocation());
                        tableIn.setValue("MEINS", dto.getUnit());
                        tableIn.setValue("WERKS", dto.getGrPlant());
                    }
                    logger.info("INPUT Table=========> \n" + tableIn);
                    function.execute(destination);
//					JCoStructure outputStruct = function.getExportParameterList().getStructure("RETURN");
                    JCoTable tableOut = function.getTableParameterList().getTable("IT_GR_OUTPUT");

                    logger.info("OUTPUT Structure=========>" + tableOut);
                    for (int j = 0; j < tableOut.getNumRows(); j++) {
                        tableOut.setRow(j);

                        if (StringUtils.isEmpty(tableOut.getString("MBLNR"))) {
                            //修改改订单状态为失败
                            odsSoGrInfoDAO.updateFlag("2", "FALSE", orderNos[i], odsSoGrInfo.getStodnNo(), userName);
                            odsSoGrInfoDAO.updateGiGrFlag("2", "TMS FALSE", orderNos[i], odsSoGrInfo.getStodnNo(), userName);
                            logger.info("Order:" + orderNos[i] + ", no data to post!");
                            log.setDescription("Order:" + orderNos[i] + ", no data to post!");
                            operationLogDAO.save(log);
                            result.setStatus("E");
                            result.setMsg(tableOut.getString("MSG"));
                        } else {
                            result.setStatus("1");
                            result.setMsg(tableOut.getString("MSG"));
                            //修改改订单状态为完成
                            odsSoGrInfoDAO.updateFlag("1", "SUCCESS", orderNos[i], odsSoGrInfo.getStodnNo(), userName);
                            odsSoGrInfoDAO.updateGiGrFlag("1", "SUCCESS", orderNos[i], odsSoGrInfo.getStodnNo(), userName);

                            //调用TMS 完成出入库闭环
                            for (OdsSoGrInfoDTO dto : list) {
                                String dn = dto.getStodnNo();
                                WmsWebService wmsWebService = getTmsDNService.getWmsWebService();
                                wmsWebService.finishDn(dn);
                            }
                        }
                    }

                } else {
                    logger.info("Order:" + orderNos[i] + ",  no data to post!");
                    log.setDescription("Order:" + orderNos[i] + ",  no data to post!");
                    operationLogDAO.save(log);
                    result.setStatus("E");
                    result.setMsg("No data to post!");
                }
            }
        } catch (Exception e) {
            message = e.getMessage();
            logger.error("Catch Exception when post STO DN: " + e.getMessage());
            log.setDescription("Execute Sap Function failed!" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("Execute SAP function failed!");
            return result;
        }
        logger.info("Post Stodn to SAP Success!");
        return result;
    }


}

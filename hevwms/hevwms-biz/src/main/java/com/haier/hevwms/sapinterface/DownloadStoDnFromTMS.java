package com.haier.hevwms.sapinterface;

import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.sto.dao.StgStoDownDAO;
import com.haier.hevwms.sto.service.tms.DnResult;
import com.haier.hevwms.sto.service.tms.GetWmsWebService;
import com.haier.hevwms.sto.service.tms.WmsWebService;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import org.apache.log4j.Logger;

import java.util.*;

public class DownloadStoDnFromTMS {

    private String beginTime;
    private String endTime;
    private String stoNo; // 调拨单号
    private String userName;
    private StgStoDownDAO stgStoDownDAO;
    private OperationLogDAO operationLogDAO;
    private GetWmsWebService getTmsDNService;

    Logger logger = Logger.getLogger(DownloadStoFromSap.class);

    public DownloadStoDnFromTMS(String beginTime,
                                String endTime,
                                String stoNo,
                                String userName,
                                StgStoDownDAO stgStoDownDAO,
                                OperationLogDAO operationLogDAO,
                                GetWmsWebService getTmsDNService) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.stoNo = stoNo;
        this.userName = userName;
        this.stgStoDownDAO = stgStoDownDAO;
        this.operationLogDAO = operationLogDAO;
        this.getTmsDNService = getTmsDNService;
    }

    public DownloadStoDnFromTMS(String beginTime, String endTime, String stoNo, String userName) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.stoNo = stoNo;
        this.userName = userName;
        stgStoDownDAO = SpringApplicationContextHolder.getBean("stgStoDownDAO");
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        getTmsDNService = SpringApplicationContextHolder.getBean("getTmsDNService");
    }

    public InterfaceOutDTO exchangeWithTMS() {
        String message = "";
        // 返回结果result
        InterfaceOutDTO result = new InterfaceOutDTO();
        result.setStatus("S");
        result.setMsg("Download Success!");

        //日志保存
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("getTmsDN");
        try{
            logger.info("Download DN Start========>" + stoNo);

            //调用TMS  现接口缺少用于区分so，sto的参数
            WmsWebService wmsWebService = getTmsDNService.getWmsWebService();

            List<DnResult> results = wmsWebService.getDn(beginTime,endTime,stoNo,"STO");

            if(results.size()>0 ){
                Map<String, Set<String>> newOrder = new HashMap<String, Set<String>>();
                Map<String, Set<String>> oldOrder = new HashMap<String, Set<String>>();
                for(DnResult dn : results){
                    Set<String> newItem = new HashSet<String>();
                    if (newOrder.get(dn.getDnCode()) == null) {
                        newItem.add(dn.getDnItem());
                        newOrder.put(dn.getDnCode(), newItem);
                    } else {
                        //如果Map中已经有OrderNumber,则将其加入到Map对应的Set中
                        newItem = newOrder.get(dn.getDnCode());
                        newItem.add(dn.getDnItem());
                    }
                    // 判断从数据库查询的结果中，是否已经包含接口中下载的数据
                    if (oldOrder.get(dn.getDnCode()) == null) {
                        StgStoDownDTO oldTemp = new StgStoDownDTO();
                        oldTemp.setStoNo(dn.getDnCode());
                        // 查询数据库
                        List<String> oldPoItems = stgStoDownDAO.getStoItemsByStoNo(oldTemp);
                        // 将查询出的数据库保存到set集合中，并将Set集合保存到Map中
                        Set<String> oldItem = new HashSet<String>(oldPoItems);
                        oldOrder.put(dn.getDnCode(), oldItem);
                    }
                }

                Set<Map.Entry<String, Set<String>>> entrySet = oldOrder.entrySet();
                for (Map.Entry<String, Set<String>> oldPo:entrySet) {
                    Set<String> oldItems = oldPo.getValue();
                    Set<String> newItems = newOrder.get(oldPo.getKey());
                    for (String exsitedItem:oldItems) {
                        boolean deleteFlag = false;
                        for (String checkItem:newItems) {
                            if(checkItem.equals(exsitedItem)) {
                                deleteFlag = true;
                                break;
                            }
                        }
                        if (!deleteFlag) {
                            StgStoDownDTO checkTemp = new StgStoDownDTO();
                            checkTemp.setStoNo(oldPo.getKey());
                            checkTemp.setStoItemNo(exsitedItem);
                            Long ifStart = stgStoDownDAO.ifScanningStart(checkTemp);
                            if (ifStart == 0) {
                                stgStoDownDAO.bankupDeletedItems(checkTemp);
                                stgStoDownDAO.deleteByStoItems(checkTemp);
                            }
                        }

                    }
                }


                for(DnResult dn : results){
                    if ("65C1".equalsIgnoreCase(dn.getStoGrPlant())) {
                        StgStoDownDTO sto = new StgStoDownDTO();
                        sto.setStoNo(dn.getDnCode());
                        sto.setGrPlant(dn.getStoGrPlant());
//                        sto.setGiPlant(table.getString("GI_PLANT"));
                        sto.setStoDocDate(dn.getStoCdate());
//                        sto.setStoLastModifyDate(table.getString("STO_EDATE"));
//                        sto.setStoCreateBy(table.getString("STO_CREATER"));
                        sto.setStoItemNo(dn.getDnItem());
                        sto.setMaterialNo(dn.getMaterialCode());
                        sto.setStoType(dn.getOrderType());

//                        String materialDesp = table.getString("MATERIAL_DESP".toUpperCase());
//                        if (!"".equals(materialDesp) && materialDesp != null) {
//                            materialDesp = CommonTool.replace(materialDesp, "'", " ");
//                            materialDesp = CommonTool.replace(materialDesp, "\"", "");
//                        }
//                        sto.setMaterialDesp(materialDesp);
                        String qty = dn.getQty();
                        if(qty == null || qty.equals("")){
                            qty = "0";
                        }
                        sto.setQty(Double.valueOf(qty).longValue());
                        sto.setGiFinishQty(0L);
                        sto.setGiFinishFlag("0");
                        sto.setGrFinishQty(0L);
                        sto.setGrFinishFlag("0");
                        sto.setUnit(dn.getUnit());
//                        sto.setGrLocation(table.getString("GR_LGORT"));
//                        sto.setGrDate(table.getString("GR_DATE"));
//                        sto.setGiLocation(table.getString("GI_LGORT"));
//                        sto.setGiDate(table.getString("GI_DATE"));
//                        String itemDeltet = table.getString("ITEM_DELTET");
//                        if (itemDeltet == null || "".equals(itemDeltet)) {
//                            itemDeltet = "0";
//                        }
                        sto.setItemDeltet("0");
//                        // STO_CLOSE 空对应0 其余对应1
//                        String stoClose = table.getString("STO_CLOSE");
//                        if (stoClose == null || "".equals(stoClose)) {
//                            stoClose = "0";
//                        }
                        sto.setStoClose("0");
                        sto.setComeFromTms("TMS");

                        List<StgStoDownDTO> stoList = stgStoDownDAO.getExistingStoItem(sto);
                        if (stoList == null || stoList.size() == 0) {
                            sto.setCreateBy(userName);
                            sto.setCreateDate(new Date());
                            stgStoDownDAO.save(sto);
                        } else {
                            Long ifStart = stgStoDownDAO.ifScanningStart(sto);
                            if (ifStart == 0) {
                                sto.setModifyBy(userName);
                                sto.setModifyDate(new Date());
                                stgStoDownDAO.updateByStoItem(sto);
                            }
                        }
                    }
                }
            }else {
                if (stoNo != null && !"".equals(stoNo) && stoNo.length() > 0) {
                    StgStoDownDTO stoDTO = new StgStoDownDTO();
                    stoDTO.setStoNo(stoNo);
                    List<StgStoDownDTO> stoDownList = stgStoDownDAO.getListByParam(stoDTO);
                    if (stoDownList != null && stoDownList.size() > 0) {
                        for (int i = 0; i < stoDownList.size(); i++) {
                            StgStoDownDTO checkDTO = stoDownList.get(i);
                            Long ifStart = stgStoDownDAO.ifScanningStart(checkDTO);
                            if (ifStart == 0) {
                                stgStoDownDAO.bankupDeletedItems(checkDTO);
                                stgStoDownDAO.deleteByStoItems(checkDTO);
                            }
                        }
                    }
                }
                log.setDescription("No data is downloaded!");
                operationLogDAO.save(log);
                result.setStatus("E");
                result.setMsg("No data is downloaded!");
            }


        }catch (Exception e){
            message = e.getMessage();
            logger.error("Function execute error:" + message);
            log.setDescription("Function execute error:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("TMS Function execute error!");
            return result;
        }

        return result;
    }

//    public static void main(String[] args) {
//        GetTmsDNService getTmsDNService = new GetTmsDNService();
//        WmsWebService wmsWebService = getTmsDNService.getWmsWebService();
//        List<DnResult> list = wmsWebService.getDn("", "", "0080235782", "sto");
//        System.out.println(list);
//    }
}

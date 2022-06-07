package com.haier.hevwms.sapinterface;

import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.StgDnDownDAO;
import com.haier.hevwms.sto.service.tms.DnResult;
import com.haier.hevwms.sto.service.tms.GetWmsWebService;
import com.haier.hevwms.sto.service.tms.WmsWebService;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.*;

public class DownloadSoDnFromTMS {
    // RFC函数名
//    String rfc_id = "ZSD_HEV_WMS_DOWNLOAD_DN";
//    String system_id = "HEVWMS";
    String beginTime;
    String endTime;
    String dnCode;
    String userName;
    private OperationLogDAO operationLogDAO;
    private StgDnDownDAO stgDnDownDAO;
    private GetWmsWebService getTmsDNService;

    Logger logger = Logger.getLogger(DownloadDnFromSap.class);

    public DownloadSoDnFromTMS(OperationLogDAO operationLogDAO,
                               StgDnDownDAO stgDnDownDAO,
                               String beginTime,
                               String endTime,
                               String dnCode) {
        this.operationLogDAO = operationLogDAO;
        this.stgDnDownDAO = stgDnDownDAO;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.dnCode = dnCode;
    }

    public DownloadSoDnFromTMS(String dnCode, String beginTime, String endTime, String userName) {
        this.dnCode = dnCode;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.userName = userName;
        stgDnDownDAO = SpringApplicationContextHolder.getBean("stgDnDownDAO");
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
            logger.info("Download DN Start========>" + dnCode);

            //调用TMS   现接口缺少用于区分so，sto的参数
            WmsWebService wmsWebService = getTmsDNService.getWmsWebService();

            if(StringUtils.isBlank(beginTime)) {
                beginTime = "";
            }
            if(StringUtils.isBlank(endTime)) {
                endTime = "";
            }
            List<DnResult> results = wmsWebService.getDn(beginTime,endTime,dnCode,"SO");

            if(results != null && results.size() > 0 ){
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
                        StgDnDownDTO oldTemp = new StgDnDownDTO();
                        oldTemp.setDnNo(dn.getDnCode());
                        // 查询数据库
                        List<String> oldPoItems = stgDnDownDAO.getSoItemsNoBySoNo(oldTemp);
                        // 将查询出的数据库保存到set集合中，并将Set集合保存到Map中
                        Set<String> oldItem = new HashSet<String>(oldPoItems);
                        oldOrder.put(dn.getDnCode(), oldItem);
                    }
                }

                Set<Map.Entry<String, Set<String>>> entrySet = oldOrder.entrySet();
                for (Map.Entry<String, Set<String>> oldSo : entrySet) {
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
                for(DnResult dn : results){
                    if ("65C1".equalsIgnoreCase(dn.getSoPlant())) {
                        StgDnDownDTO so = new StgDnDownDTO();
                        // 销售订单号
                        so.setDnNo(dn.getDnCode());
                        // 行项目 Item number
                        so.setDnItemNo(dn.getDnItem());
                        // 订单类型
                        so.setSellOrderType(dn.getSellOrderType());
                        // 物料号 Material
                        so.setMaterialNo(dn.getMaterialCode());
                        // 工厂 Plant
                        so.setPlant(dn.getSoPlant());
                        // 库位 Storage Location
                        so.setLocation(dn.getLocation());
                        // 数量
                        String qty = dn.getQty();
                        if (qty == null || "".equals(qty)) {
                            qty = "0";
                        }
                        so.setQty(Double.valueOf(qty).longValue());
                        so.setFinishQty(0L);
                        so.setFinishFlag("0");
                        so.setDnClose("0");
                        // 单位
                        so.setUnit(dn.getUnit());

//                        // 物料描述 Material Desc
//                        String materialDesp = codes.getString("ARKTX");
//                        if (materialDesp != null && !"".equals(materialDesp.trim())) {
//                            materialDesp = CommonTool.replace(materialDesp, "'", " ");
//                            materialDesp = CommonTool.replace(materialDesp, "\"", "");
//                        }
//                        so.setMaterialDesp(materialDesp);

                        // Customer Model
//                        String customerModel = codes.getString("ZARKTX");
//                        if (customerModel != null && !"".equals(customerModel.trim())) {
//                            customerModel = CommonTool.replace(customerModel, "'", " ");
//                            customerModel = CommonTool.replace(customerModel, "\"", "");
//                        }
//                        so.setCustomerModel(customerModel);
                        // 创建日期ERDAT
                        Date date = new Date();
                        so.setCreateDate(date);
                        so.setModifyDate(date);
                        // SAP_FLAG
                        so.setSapFlag("0");
                        // DN_DOC_DATE
                        so.setDnDocDate(dn.getTmsCreated());
//
//                        // DN_CREATE_BY
//                        so.setDnCreateBy(codes.getString("ERNAM"));
//                        // customer no
//                        so.setCustomerNo(codes.getString("KUNAG"));
//                        so.setCustomerName(codes.getString("NAME"));
//                        so.setDeliveryCode(codes.getString("KUNNR_SH"));
//                        so.setDeliveryName(codes.getString("NAME_SH"));
//                        so.setDeliveryDate(codes.getString("WADAT"));
//                        so.setBilling(codes.getString("BILLING"));
//                        so.setBillingItem(codes.getString("BILLING_ITEM"));
//                        so.setCity(codes.getString("CITY1"));
//                        so.setRegion(codes.getString("REGION"));
//
//                        so.setCustomerPo(codes.getString("BSTKD"));
//                        so.setDeliveryAddress(codes.getString("ZADDR"));
//                        so.setPickingDate(codes.getString("KODAT"));
//                        so.setVendorCode(codes.getString("KUNNR_SP"));
//                        so.setVendorName(codes.getString("SP_NAME"));

                        so.setComeFromTms("TMS");
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



            }else {
                // 判断单号是否为空
                if (dnCode != null && !"".equalsIgnoreCase(dnCode) && dnCode.length() > 1) {
                    StgDnDownDTO dto = new StgDnDownDTO();
                    dto.setDnNo(dnCode);
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
                logger.info("Order:" + dnCode + ", No data is downloaded!");
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

}

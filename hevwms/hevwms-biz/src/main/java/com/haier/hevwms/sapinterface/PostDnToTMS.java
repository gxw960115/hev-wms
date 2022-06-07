package com.haier.hevwms.sapinterface;

import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.hevwms.sto.service.tms.*;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDnToTMS {
    Logger logger = Logger.getLogger(PostDnToTMS.class);
    String[] orderNos;
    String sapFlag;
    String message;
    private String userName;
    private OperationLogDAO operationLogDAO;
    private OdsSoGrInfoDAO odsSoGrInfoDAO;
    private GetWmsWebService getTmsDNService;

    public PostDnToTMS(String[] orderNos, OperationLogDAO operationLogDAO, OdsSoGrInfoDAO odsSoGrInfoDAO) {
        this.orderNos = orderNos;
        this.operationLogDAO = operationLogDAO;
        this.odsSoGrInfoDAO = odsSoGrInfoDAO;
    }

    public PostDnToTMS(String orderNo, String sapFlag, String userName) {
        this.orderNos = orderNo.split(",");
        this.sapFlag = sapFlag;
        this.userName = userName;
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        odsSoGrInfoDAO = SpringApplicationContextHolder.getBean("odsSoGrInfoDAO");
        getTmsDNService = SpringApplicationContextHolder.getBean("getTmsDNService");
    }

    public InterfaceOutDTO exchangeWithTMS() {
        logger.info("Post DN Start========>" + orderNos[0]);
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("PostDnToSap");
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
                odsSoGrInfo.setSapFlag(sapFlag);
                List<OdsSoGrInfoDTO> list = odsSoGrInfoDAO.getOdsSoGrInfoListByOGP(odsSoGrInfo);
                if (list != null && list.size() > 0) {
                    for (OdsSoGrInfoDTO dto : list) {
                        {
                            Material material = new Material();
                            material.setMaterialCode(dto.getMaterialNo());
                            material.setQty(String.valueOf(dto.getScannedQty()));
                            materialList.add(material);
                            load.setMaterialList(materialList);
                            load.setDn(dto.getDnNo());
                            load.setDocType("DN");
                            stoNo = dto.getDnNo();
                        }
                    }
                    // 执行接口，获取输出结果
                    loadList.add(load);
                    loadParam.setLoadList(loadList);
                    loadParam.setTradeId(tradeId);

                    //调用TMS   现接口缺少用于区分so，sto的参数
                    WmsWebService wmsWebService = getTmsDNService.getWmsWebService();

                    StatusResult statusResult =  wmsWebService.pushLoadInfo(loadParam);
                    logger.info("OUTPUT Structure=========>" + statusResult.toString());

                    OdsSoGrInfoDTO resultDto = new OdsSoGrInfoDTO();
                    if(statusResult != null){
                        resultDto.setSapFlag(statusResult.getStatus());
                        result.setStatus(statusResult.getStatus());
                        result.setMsg(statusResult.getMsg());
                        resultDto.setSapMsg(statusResult.getStatus() + ":" + statusResult.getMsg());
                    }

                    resultDto.setDnNo(stoNo);
                    resultDto.setModifyBy(userName);
                    resultDto.setModifyDate(new Date());
                    odsSoGrInfoDAO.updatePostResult(resultDto);

                } else {
                    logger.info("Order:" + orderNos[i] + ", no data to post!");
                    log.setDescription("Order:" + orderNos[i] + ", no data to post!");
                    operationLogDAO.save(log);
                    result.setStatus("E");
                    result.setMsg("No data to post!");
                }
            }
            logger.info("Post DN End========>" + orderNos[0]);
        } catch (Exception e) {
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

}

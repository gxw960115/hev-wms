package com.haier.openplatform.showcase.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.haier.hevwms.basic.service.CdLocInfoService;
import com.haier.hevwms.basic.service.CdWhInfoService;
import com.haier.hevwms.inventory.service.StgSapStockService;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;

/**
* @ClassName: DownAllInventoryFromSAPToWMSJob
* @Description:定时任务自动下载SAP库存
* @author yanfengdan
* @Date 2018-02-24 上午10:14:49
*/
public class DownAllInventoryFromSAPToWMSJob implements Job {
    private static final Logger logger = Logger.getLogger(DownAllInventoryFromSAPToWMSJob.class);
    private CdWhInfoService cdWhInfoService;
    private CdLocInfoService cdLocInfoService;
    private StgSapStockService stgSapStockService;
//    private OperationLogDAO operationLogDAO;
    
    public DownAllInventoryFromSAPToWMSJob() {
    	cdWhInfoService = SpringApplicationContextHolder.getBean("cdWhInfoService");
    	cdLocInfoService = SpringApplicationContextHolder.getBean("cdLocInfoService");
    	stgSapStockService = SpringApplicationContextHolder.getBean("stgSapStockService");
//    	operationLogDAO=SpringApplicationContextHolder.getBean("operationLogDAO");
    }
    
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
    	logger.info("Download Sap Stock Job Start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
    	DownAllInventoryFromSAPToWMSJob download = new DownAllInventoryFromSAPToWMSJob();
    	download.downloadSAPInventory();
    	logger.info("Download Sap Stock Job End:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
    }
    
    public void downloadSAPInventory() {
        
		List<CdWhInfoDTO> list = cdWhInfoService.getCdWhInfos();//获取所有的仓库
		
		List<String> whList = new ArrayList<String>();
		for (CdWhInfoDTO whDTO:list) {
			whList.add(whDTO.getCode());
		}
		
//		OperationLogSaveModel log=new OperationLogSaveModel();//记录
//        log.setAppName("DownAllInventoryFromSAPToWMSJob");
		
        try {
        	for (String wh:whList){
        		
        		stgSapStockService.downInventoryFromSap(wh,"","","System");
        	}
        } catch (Exception e) {
        	String mess = "";
            if (e.toString().length() > 1900) {
                mess = e.toString().substring(0, 1900);
            } else {
                mess = e.toString();
            }
        	e.printStackTrace();
//        	log.setDescription("DownAllInventoryFromSAPToWMSJob interface error: " + mess);
//            operationLogDAO.save(log);
        }
        
//        log.setActualData(whList.toString());
//        operationLogDAO.save(log);
    }

}

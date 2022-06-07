package com.haier.openplatform.wms.inventory.impl;

import java.util.List;

import com.haier.hevwms.basic.service.CdLocInfoService;
import com.haier.hevwms.basic.service.CdWhInfoService;
import com.haier.hevwms.inventory.service.StgSapStockService;
import com.haier.openplatform.showcase.quartz.DownAllInventoryFromSAPToWMSJob;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;

/**
 * @author sunhaoyu
 * @version V1.0
 * @Company 青鸟软通
 * @Title:SAP库存查询dubbo实现
 * @Package com.haier.openplatform.wms.inventory.service;
 * @date 2015/10/29
 */
public class StgSapStockServiceClientImpl implements StgSapStockServiceClient {
    private StgSapStockService stgSapStockService;
    private CdLocInfoService cdLocInfoService;
    private CdWhInfoService cdWhInfoService;

    /* (非 Javadoc) 
    * <p>Title: downInventoryFromSap</p> 
    * <p>Description: </p> 
    * @param plant
    * @param locations
    * @param userName
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient#downInventoryFromSap(java.lang.String, java.lang.String, java.lang.String) 
    */
    @Override
    public InterfaceOutDTO downInventoryFromSap(String plant, String locations, String userName) {
        InterfaceOutDTO result = stgSapStockService.downInventoryFromSap(plant, "", locations, userName);

        return result;
    }

    /* (非 Javadoc) 
    * <p>Title: searchActualStockGapList</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient#searchActualStockGapList(com.haier.openplatform.wms.inventory.dto.StgSapStockDTO) 
    */
    @Override
    public List<StgSapStockDTO> searchActualStockGapList(StgSapStockDTO dto) {

        return stgSapStockService.physicalStockGapList(dto);
    }

    /* (非 Javadoc) 
    * <p>Title: downAllInventoryFromSap</p> 
    * <p>Description: </p>  
    * @see com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient#downAllInventoryFromSap() 
    */
    @Override
    public void downAllInventoryFromSap() {
        DownAllInventoryFromSAPToWMSJob downInventory = new DownAllInventoryFromSAPToWMSJob();
        downInventory.downloadSAPInventory();
    }

    /** 
    * @Title: getStgSapStockService 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return StgSapStockService    返回类型 
    * @throws 
    */
    public StgSapStockService getStgSapStockService() {
        return stgSapStockService;
    }

    /**
     * @Description: 属性 stgSapStockService 的set方法
     */
    public void setStgSapStockService(StgSapStockService stgSapStockService) {
        this.stgSapStockService = stgSapStockService;
    }

    public CdLocInfoService getCdLocInfoService() {
        return cdLocInfoService;
    }

    public void setCdLocInfoService(CdLocInfoService cdLocInfoService) {
        this.cdLocInfoService = cdLocInfoService;
    }

    /* (非 Javadoc) 
    * <p>Title: searchStgSapStockInfo</p> 
    * <p>Description: </p> 
    * @param pager
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient#searchStgSapStockInfo(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.StgSapStockDTO) 
    */
    @Override
    public Pager<StgSapStockDTO> searchStgSapStockInfo(Pager<StgSapStockDTO> pager, StgSapStockDTO dto) {

        return stgSapStockService.searchStgSapStocks(pager, dto);
    }

    /* (非 Javadoc) 
    * <p>Title: searchActualStockGap</p> 
    * <p>Description: </p> 
    * @param pager
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient#searchActualStockGap(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.StgSapStockDTO) 
    */
    @Override
    public Pager<StgSapStockDTO> searchActualStockGap(Pager<StgSapStockDTO> pager, StgSapStockDTO dto) {

        return stgSapStockService.physicalStockGap(pager, dto);
    }

    /* (非 Javadoc) 
    * <p>Title: getStgSapInfoInfoByParams</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient#getStgSapInfoInfoByParams(com.haier.openplatform.wms.inventory.dto.StgSapStockDTO) 
    */
    @Override
    public List<StgSapStockDTO> getStgSapInfoInfoByParams(StgSapStockDTO dto) {
        return stgSapStockService.getStgSapStockByParam(dto);
    }

    /* (非 Javadoc) 
    * <p>Title: getExportAmount</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient#getExportAmount(com.haier.openplatform.wms.inventory.dto.StgSapStockDTO) 
    */
    @Override
    public Long getExportAmount(StgSapStockDTO dto) {
        return stgSapStockService.getExportAmount(dto);
    }

    public CdWhInfoService getCdWhInfoService() {
        return cdWhInfoService;
    }

    public void setCdWhInfoService(CdWhInfoService cdWhInfoService) {
        this.cdWhInfoService = cdWhInfoService;
    }
}

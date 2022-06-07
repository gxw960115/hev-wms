package com.haier.hevwms.inventory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;

public interface StgSapStockDAO extends CommonDAO<StgSapStockDTO, Long> {

    public List<StgSapStockDTO> searchStgSapStocks(
            @Param("pager") Pager<StgSapStockDTO> pager,
            @Param("stgSapStock") StgSapStockDTO stgSapStock);

    public Long searchStgSapStocksCount(
            @Param("stgSapStock") StgSapStockDTO stgSapStock);

    public void deleteAll(@Param("idList") List<Long> idList);


    public Integer checkSapStock(@Param("temp") StgSapStockDTO temp);

    public void updateQty(@Param("temp") StgSapStockDTO temp);

    /**
     * 清空表内容
     */
    public void deleteSapStock();
    /**
     * 
    * @Title: deleteSapStockByPlant
    * @Description: TODO (这里用一句话描述这个类的作用)仅删除所选plant的sap库存
    * @param 
    * @return void
    * @throws
     */
    public void deleteSapStockByPlant(String plant);
    
    /* 
 	modified by gaozhaomei 2016-10-09
	*/
    public void deleteSapStockByLocation( @Param("stgSapStock") StgSapStockDTO stgSapStock);

    public List<StgSapStockDTO> getStgSapStockByParam(
            @Param("stgSapStock") StgSapStockDTO stgSapStock);
    
    public List<StgSapStockDTO> physicalStockGap(
            @Param("pager") Pager<StgSapStockDTO> pager,
            @Param("stgSapStock") StgSapStockDTO stgSapStock);
    
    public List<String> getAvailableWhs(@Param("userId") Long userId);
    
}

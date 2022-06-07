package com.haier.hevwms.inventory.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;

public interface StgSapStockService {
	public ExecuteResult<StgSapStockDTO> createStgSapStock(StgSapStockDTO stgSapStock);
	
	public ExecuteResult<StgSapStockDTO> updateStgSapStock(StgSapStockDTO stgSapStock);
	
	public ExecuteResult<StgSapStockDTO> deleteStgSapStock(Long stgSapStockId);
	public ExecuteResult<StgSapStockDTO> deleteStgSapStockAll(List<Long> idList);
	
	public Pager<StgSapStockDTO> searchStgSapStocks(Pager<StgSapStockDTO> pager,StgSapStockDTO stgSapStock);
	
	public StgSapStockDTO getStgSapStockById(Long stgSapStockId);
	
	public List<StgSapStockDTO> getStgSapStocks();

	/**
	 * 下载库存
	 * @param plant
	 * @param materialNo
	 * @param location
	 * @param userName
	 * @return
	 */
	public InterfaceOutDTO downInventoryFromSap(String plant, String materialNo, String location, String userName);
	
	public List<StgSapStockDTO> getStgSapStockByParam(StgSapStockDTO stgSapStock);
	
	public Pager<StgSapStockDTO> physicalStockGap(Pager<StgSapStockDTO> pager,StgSapStockDTO stgSapStock);
	public List<StgSapStockDTO> physicalStockGapList(StgSapStockDTO stgSapStock);

	public Long getExportAmount(StgSapStockDTO dto);
}

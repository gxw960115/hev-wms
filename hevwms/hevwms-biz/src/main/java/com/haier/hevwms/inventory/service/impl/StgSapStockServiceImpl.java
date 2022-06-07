package com.haier.hevwms.inventory.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.haier.hevwms.inventory.dao.StgSapStockDAO;
import com.haier.hevwms.inventory.service.StgSapStockService;
import com.haier.hevwms.sapinterface.DownloadStockFromSap;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;


/**
 * @Company 青鸟软通
 * @Title:sap查询库存方法实现
 * @Package com.haier.hevwms.inventory.service.impl
 * @author sunhaoyu
 * @date 2015/10/30
 * @version V1.0
 */
public class StgSapStockServiceImpl implements StgSapStockService {
	private static Logger logger = Logger.getLogger(StgSapStockServiceImpl.class);
    private StgSapStockDAO stgSapStockDAO;

    /**
     * Title: createStgSapStock
     * Description:新增方法
     * @param stgSapStock
     * @return
     */
    @Override
    public ExecuteResult<StgSapStockDTO> createStgSapStock(StgSapStockDTO stgSapStock) {
        ExecuteResult<StgSapStockDTO> executeResult = new ExecuteResult<StgSapStockDTO>();
        // 保存
        stgSapStockDAO.save(stgSapStock);
        executeResult.setResult(stgSapStock);
        return executeResult;
    }

    /**
     * Title: updateStgSapStock Description: 更新方法
     * 
     * @param stgSapStock
     * @return
     */
    @Override
    public ExecuteResult<StgSapStockDTO> updateStgSapStock(StgSapStockDTO stgSapStock) {
        ExecuteResult<StgSapStockDTO> executeResult = new ExecuteResult<StgSapStockDTO>();
        // 更新
        stgSapStockDAO.update(stgSapStock);
        executeResult.setResult(stgSapStock);
        return executeResult;
    }

    /**
     * Title: deleteStgSapStock Description:
     * 删除方法
     * @param stgSapStockId
     * @return
     */
    @Override
    public ExecuteResult<StgSapStockDTO> deleteStgSapStock(Long stgSapStockId) {
        ExecuteResult<StgSapStockDTO> executeResult = new ExecuteResult<StgSapStockDTO>();
        // 删除
        stgSapStockDAO.delete(stgSapStockId);
        return executeResult;
    }

    /**
     * <p>
     * Title: deleteStgSapStockAll
     * Description:删除所有
     * @param idList
     * @return
     */
    @Override
    public ExecuteResult<StgSapStockDTO>deleteStgSapStockAll(List<Long> idList) {
        ExecuteResult<StgSapStockDTO> executeResult = new ExecuteResult<StgSapStockDTO>();
        // 删除所有
        stgSapStockDAO.deleteAll(idList);
        return executeResult;
    }

    /**
     * Title: searchStgSapStocks
     * Description:查询所有的方法
     * @param pager
     * @param stgSapStock
     */
    @Override
    public Pager<StgSapStockDTO> searchStgSapStocks(Pager<StgSapStockDTO> pager, StgSapStockDTO stgSapStock) {
        List<StgSapStockDTO> stgSapStocks = stgSapStockDAO.searchStgSapStocks(pager, stgSapStock);
        long size = stgSapStockDAO.searchStgSapStocksCount(stgSapStock);
        return Pager.cloneFromPager(pager, size, stgSapStocks);
    }

    /**
    * <p>Title: downInventoryFromSap</p>
    * <p>Description:从sap下载数据 </p>
    * @param plant
    * @param materialNo
    * @param locations
    */
    @Override
    public InterfaceOutDTO downInventoryFromSap(String plant, String materialNo, String locations, String userName) {
    	InterfaceOutDTO result = new InterfaceOutDTO();
    	StringBuffer resultMsg = new StringBuffer();
    	if (locations != null && !locations.equals("")) {
            String[] locationArr = locations.split(",");
            String location;
            for (int i = 0; i < locationArr.length; i++) {
                location = locationArr[i];
                result = new DownloadStockFromSap(plant, null, null, null, location, null, userName).exchangeWithSap();
                resultMsg.append(location).append(":").append(result.getMsg());
                logger.info("Download Inventory-->"+plant+"-->"+location+":"+result.getMsg());
            }
           
    	}else{
    	    result = new DownloadStockFromSap(plant, null, null, null, null, null, userName).exchangeWithSap();
    	    resultMsg.append(result.getMsg());
            logger.info("Download Inventory-->"+plant+"-->ALL:"+result.getMsg());
    	}
    	result.setMsg(resultMsg.toString());
    	return result;
    }

    @Override
    public StgSapStockDTO getStgSapStockById(Long stgSapStockId) {
        return stgSapStockDAO.get(stgSapStockId);
    }

    @Override
    public List<StgSapStockDTO> getStgSapStocks() {
        return stgSapStockDAO.getAll();
    }

	/**
     * <p>
     * Title: getStgSapStockByParam
     * Description:带参数查询
     * @param stgSapStock
     * @return
     */
    @Override
    public List<StgSapStockDTO> getStgSapStockByParam(StgSapStockDTO stgSapStock) {
        return stgSapStockDAO.getStgSapStockByParam(stgSapStock);
    }
    
    
//	public Pager<StgSapStockDTO> searchActualStockGap(Pager<StgSapStockDTO> pager,
//			StgSapStockDTO stgSapStock) {
//		String plant = stgSapStock.getPlant();
//		CdWhMappingDTO cdWhMapping = new CdWhMappingDTO();
//		cdWhMapping.setPhysicalWh(plant);
//		List<CdWhMappingDTO> mappings = cdWhMappingDAO.getByParam(cdWhMapping);
//		Set<String> virtualWhs = new HashSet<String>();
//		StgSapStockDTO temp = new StgSapStockDTO();
//		List<StgSapStockDTO> tempList = new ArrayList<StgSapStockDTO>();
//		if (mappings != null && mappings.size() > 0){
//			for (CdWhMappingDTO mapping:mappings){
//				if (!"".equals(mapping.getCorrespondingWhA())&&mapping.getCorrespondingWhA() !=null){
//					virtualWhs.add(mapping.getCorrespondingWhA());
//				}
//				if (!"".equals(mapping.getCorrespondingWhB())&&mapping.getCorrespondingWhB() !=null){
//					virtualWhs.add(mapping.getCorrespondingWhB());				
//				}
//				if (!"".equals(mapping.getCorrespondingWhC())&&mapping.getCorrespondingWhC() !=null){
//					virtualWhs.add(mapping.getCorrespondingWhC());
//				}
//				if (!"".equals(mapping.getCorrespondingWhD())&&mapping.getCorrespondingWhD() !=null){
//					virtualWhs.add(mapping.getCorrespondingWhD());
//				}
//			}
//		}
//		List<StgSapStockDTO> physicalGaps = stgSapStockDAO.searchStockGap(pager, stgSapStock);
//		List<StgSapStockDTO> physicalCombineGaps = this.combineVirtualLoc(physicalGaps);
//		Iterator<String> it = virtualWhs.iterator();
//		while (it.hasNext()){
//			String virtualWh = it.next();
//			temp.setPlant(virtualWh);
//			List<StgSapStockDTO> virtualGaps = stgSapStockDAO.searchStockGap(pager, temp);
//			List<StgSapStockDTO> virtualCombineGaps = this.combineVirtualLoc(virtualGaps);
//			for (StgSapStockDTO virtualCombineGap:virtualCombineGaps){
//				for (StgSapStockDTO physicalCombineGap:physicalCombineGaps){
//					if (virtualCombineGap.getLocation().equalsIgnoreCase(physicalCombineGap.getLocation())
//							&&virtualCombineGap.getMaterialNo().equalsIgnoreCase(physicalCombineGap.getMaterialNo())){
//						physicalCombineGap.setQty(physicalCombineGap.getQty()+virtualCombineGap.getQty());
//						tempList.add(physicalCombineGap);
//						continue;
//					}
//					virtualCombineGap.setPlant(physicalCombineGap.getPlant());
//					tempList.add(virtualCombineGap);
//				}
//			}
//			
//		}
//		long size = stgSapStockDAO.searchStgSapStocksCount(stgSapStock);
//        return Pager.cloneFromPager(pager, size, physicalGaps);
//	}
    /**
     * 将sap库存按照wms实体库位整合
     * SJK
     */
	@Override
	public Pager<StgSapStockDTO> physicalStockGap(Pager<StgSapStockDTO> pager, StgSapStockDTO stgSapStock) {
//		List<Object> result = stgSapStockDAO.physicalStockGap(pager,stgSapStock);
		if ("3".equals(stgSapStock.getUserType()) && (stgSapStock.getPlant() == null || "".equals(stgSapStock.getPlant()))){
			StringBuffer sb = new StringBuffer();
			List<String> whs = stgSapStockDAO.getAvailableWhs(stgSapStock.getUserId());
			for (int i = 0; i < whs.size(); i++) {
				if (i == whs.size() - 1) {
					sb.append(whs.get(i));
				} else {
					sb.append(whs.get(i)).append(",");
				}
			}
			stgSapStock.setPlant(sb.toString());
		}
		
		List<StgSapStockDTO> sapStockGaps = stgSapStockDAO.physicalStockGap(pager,stgSapStock);

		return Pager.cloneFromPager(pager,pager.getTotalRecords(), sapStockGaps);
	}
	
	@Override
	public List<StgSapStockDTO> physicalStockGapList(StgSapStockDTO stgSapStock) {
		Pager<StgSapStockDTO> pager = new Pager<StgSapStockDTO>();
		pager.setCurrentPage(1L);
		pager.setPageSize(new Long(Integer.MAX_VALUE));
		List<StgSapStockDTO> sapStockGapList = stgSapStockDAO.physicalStockGap(pager,stgSapStock);
		return sapStockGapList;
	}
	
	@Override
	public Long getExportAmount(StgSapStockDTO dto) {
		return stgSapStockDAO.searchStgSapStocksCount(dto);
	}

    public void setStgSapStockDAO(StgSapStockDAO stgSapStockDAO) {
        this.stgSapStockDAO = stgSapStockDAO;
    }

    public StgSapStockDAO getStgSapStockDAO() {
        return stgSapStockDAO;
    }
}

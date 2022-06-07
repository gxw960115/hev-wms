package com.haier.hevwms.order.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.hevwms.order.dao.StgInboundDownDAO;
import com.haier.hevwms.order.dao.StgInboundDownTempDAO;
import com.haier.hevwms.order.service.StgInboundDownService;
	/**
	 * inbound detail  
	 * @author sunyanfei 2015-11-25
	 *
	 */
public class StgInboundDownServiceImpl implements StgInboundDownService{
    Logger logger = Logger.getLogger(StgInboundDownServiceImpl.class);
	private StgInboundDownDAO stgInboundDownDAO;
	private StgInboundDownTempDAO stgInboundDownTempDAO;
	
	@Override
	public ExecuteResult<StgInboundDownDTO> createStgInboundDown(StgInboundDownDTO stgInboundDown){
		ExecuteResult<StgInboundDownDTO> executeResult = new ExecuteResult<StgInboundDownDTO>();
		
		stgInboundDownDAO.save(stgInboundDown);
		executeResult.setResult(stgInboundDown);
		return executeResult;
	}
	
	public ExecuteResult<StgInboundDownDTO> updateStgInboundDown(StgInboundDownDTO stgInboundDown){
		ExecuteResult<StgInboundDownDTO> executeResult = new ExecuteResult<StgInboundDownDTO>();
		
		stgInboundDownDAO.update(stgInboundDown);
		executeResult.setResult(stgInboundDown);
		return executeResult;
	}
	
	public ExecuteResult<StgInboundDownDTO> deleteStgInboundDown(Long stgInboundDownId){
		ExecuteResult<StgInboundDownDTO> executeResult = new ExecuteResult<StgInboundDownDTO>();
		
		stgInboundDownDAO.delete(stgInboundDownId);
		return executeResult;
	}
	public ExecuteResult<StgInboundDownDTO> deleteStgInboundDownAll(List<Long> idList){
		ExecuteResult<StgInboundDownDTO> executeResult = new ExecuteResult<StgInboundDownDTO>();
		
		stgInboundDownDAO.deleteAll(idList);
		return executeResult;
	}
	public Pager<StgInboundDownDTO> searchStgInboundDowns(Pager<StgInboundDownDTO> pager, StgInboundDownDTO stgInboundDown){
		List<StgInboundDownDTO> stgInboundDowns = stgInboundDownDAO.searchStgInboundDowns(pager, stgInboundDown);
		long size = stgInboundDownDAO.searchStgInboundDownsCount(stgInboundDown);
		return Pager.cloneFromPager(pager, size, stgInboundDowns);
	}
	public List<StgInboundDownDTO> getStgInboundDownByParam(StgInboundDownDTO stgInboundDown){
		return stgInboundDownDAO.getStgInboundDownsByParam(stgInboundDown);
	}
	public StgInboundDownDTO getStgInboundDownById(Long stgInboundDownId){
		return stgInboundDownDAO.get(stgInboundDownId);
	}
	
	public List<StgInboundDownDTO> getStgInboundDowns(){
		return stgInboundDownDAO.getAll();
	}
	
	/**
     * @throws Exception 
    * @Title: removeHistory
    * @Description: 
    * @param 
    * @return void
    * @throws
     */
    @Transactional(rollbackFor=Exception.class)
    public boolean removeHistory() throws Exception {
        boolean flag = true;
        logger.debug("Entering removeHistory...");
        
        int insNum = stgInboundDownTempDAO.insertInbdTempHistory();
        logger.debug("Number of records insert = " + insNum);
        
        int delNum = 0;
        if (insNum > 0) {
            delNum = stgInboundDownTempDAO.delInbdDownTempHistory();
            logger.debug("Number of records delete = " + delNum);
            
            if (delNum != insNum) {
                flag = false;
                logger.error("Num of deleted records is not equal to num of inserted records!");
                throw new Exception();
            } 
        } else {
            logger.debug("Number of records insert is 0, no need delete...");
        }
        
        logger.debug("Exiting removeHistory with flag: " + flag);
        return flag;
    }
    
    @Override
	public Long getExportAmount(StgInboundDownDTO dto) {
		return stgInboundDownDAO.searchStgInboundDownsCount(dto);
	}

    /**
     * @Description: 属性 stgInboundDownTempDAO 的get方法
     * @return stgInboundDownTempDAO
     */
    public StgInboundDownTempDAO getStgInboundDownTempDAO() {
        return stgInboundDownTempDAO;
    }

    /**
     * @Description: 属性 stgInboundDownTempDAO 的set方法
     * stgInboundDownTempDAO
     */
    public void
            setStgInboundDownTempDAO(StgInboundDownTempDAO stgInboundDownTempDAO) {
        this.stgInboundDownTempDAO = stgInboundDownTempDAO;
    }
    
    public void setStgInboundDownDAO(StgInboundDownDAO stgInboundDownDAO){
		this.stgInboundDownDAO = stgInboundDownDAO;
	}
	public StgInboundDownDAO getStgInboundDownDAO(){
		return stgInboundDownDAO;
	}
}

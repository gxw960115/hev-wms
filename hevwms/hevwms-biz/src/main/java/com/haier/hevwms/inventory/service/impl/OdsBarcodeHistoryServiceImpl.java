package com.haier.hevwms.inventory.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.domain.OdsBarcodeHistory;
import com.haier.hevwms.inventory.service.OdsBarcodeHistoryService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;

/**
* @ClassName: OdsBarcodeHistoryServiceImpl
* @Description:条码历史业务方法
*
*/
public class OdsBarcodeHistoryServiceImpl implements OdsBarcodeHistoryService{
	private OdsBarcodeHistoryDAO odsBarcodeHistoryDAO;
	
	/**
	* <p>Title: createOdsBarcodeHistory</p>
	* <p>Description: 条码增加
	* @param odsBarcodeHistory
	* @return
	* @see com.haier.hevwms.inventory.service.OdsBarcodeHistoryService#createOdsBarcodeHistory(com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO)
	*/
	@Override
	public ExecuteResult<OdsBarcodeHistoryDTO> createOdsBarcodeHistory(OdsBarcodeHistoryDTO odsBarcodeHistory){
		ExecuteResult<OdsBarcodeHistoryDTO> executeResult = new ExecuteResult<OdsBarcodeHistoryDTO>();
		
		OdsBarcodeHistory domain=new OdsBarcodeHistory();
        try {
            BeanUtils.copyProperties(domain, odsBarcodeHistory);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
		
		odsBarcodeHistoryDAO.save(domain);
		executeResult.setResult(odsBarcodeHistory);
		return executeResult;
	}
	
	/**
	* <p>Title: updateOdsBarcodeHistory</p>
	* <p>Description:条码历史更新 </p>
	* @param odsBarcodeHistory
	* @return
	* @see com.haier.hevwms.inventory.service.OdsBarcodeHistoryService#updateOdsBarcodeHistory(com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO)
	*/
	@Override
	public ExecuteResult<OdsBarcodeHistoryDTO> updateOdsBarcodeHistory(OdsBarcodeHistoryDTO odsBarcodeHistory){
		ExecuteResult<OdsBarcodeHistoryDTO> executeResult = new ExecuteResult<OdsBarcodeHistoryDTO>();
		
		OdsBarcodeHistory domain=new OdsBarcodeHistory();
		try {
            BeanUtils.copyProperties(domain, odsBarcodeHistory);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
		
		odsBarcodeHistoryDAO.update(domain);
		executeResult.setResult(odsBarcodeHistory);
		return executeResult;
	}
	
	@Override
	public ExecuteResult<OdsBarcodeHistoryDTO> deleteOdsBarcodeHistory(Long odsBarcodeHistoryId){
		ExecuteResult<OdsBarcodeHistoryDTO> executeResult = new ExecuteResult<OdsBarcodeHistoryDTO>();
		
		odsBarcodeHistoryDAO.delete(odsBarcodeHistoryId);
		return executeResult;
	}
	/**
	* <p>Title: deleteOdsBarcodeHistoryAll</p>
	* <p>Description:条码历史删除 </p>
	* @param idList
	* @return
	* @see com.haier.hevwms.inventory.service.OdsBarcodeHistoryService#deleteOdsBarcodeHistoryAll(java.util.List)
	*/
	@Override
	public ExecuteResult<OdsBarcodeHistoryDTO> deleteOdsBarcodeHistoryAll(List<Long> idList){
		ExecuteResult<OdsBarcodeHistoryDTO> executeResult = new ExecuteResult<OdsBarcodeHistoryDTO>();
		
		odsBarcodeHistoryDAO.deleteAll(idList);
		return executeResult;
	}
	/**
	* <p>Title: searchOdsBarcodeHistorys</p>
	* <p>Description:查询所有条码历史信息 </p>
	* @param pager
	* @param odsBarcodeHistory
	* @return
	* @see com.haier.hevwms.inventory.service.OdsBarcodeHistoryService#searchOdsBarcodeHistorys(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO)
	*/
	@Override
	public Pager<OdsBarcodeHistoryDTO> searchOdsBarcodeHistorys(Pager<OdsBarcodeHistoryDTO> pager, OdsBarcodeHistoryDTO odsBarcodeHistory){
		List<OdsBarcodeHistoryDTO> odsBarcodeHistorys = odsBarcodeHistoryDAO.searchOdsBarcodeHistorys(pager, odsBarcodeHistory);
		long size = odsBarcodeHistoryDAO.searchOdsBarcodeHistorysCount(odsBarcodeHistory);
		return Pager.cloneFromPager(pager, size, odsBarcodeHistorys);
	}
	
	/**
	* <p>Title: getOdsBarcodeHistoryById</p>
	* <p>Description:根据id查询 </p>
	* @param odsBarcodeHistoryId
	* @return
	* @see com.haier.hevwms.inventory.service.OdsBarcodeHistoryService#getOdsBarcodeHistoryById(java.lang.Long)
	*/
	@Override
	public OdsBarcodeHistoryDTO getOdsBarcodeHistoryById(Long odsBarcodeHistoryId){
	    OdsBarcodeHistory odsBarcodeHistory= odsBarcodeHistoryDAO.get(odsBarcodeHistoryId);
	    OdsBarcodeHistoryDTO dto=new OdsBarcodeHistoryDTO();
	    try {
            BeanUtils.copyProperties(dto, odsBarcodeHistory);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
	    return dto;
	}
	
	@Override
	public List<OdsBarcodeHistoryDTO> getOdsBarcodeHistorys(){
	    List<OdsBarcodeHistory> temp=odsBarcodeHistoryDAO.getAll();
	    List<OdsBarcodeHistoryDTO> list=new ArrayList<OdsBarcodeHistoryDTO>();
	    for(OdsBarcodeHistory s:temp){
	        OdsBarcodeHistoryDTO dto=new OdsBarcodeHistoryDTO();
	        try {
                BeanUtils.copyProperties(dto, s);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
	        list.add(dto);
	    }
		return list;
	}
	
	public void setOdsBarcodeHistoryDAO(OdsBarcodeHistoryDAO odsBarcodeHistoryDAO){
		this.odsBarcodeHistoryDAO = odsBarcodeHistoryDAO;
	}
	public OdsBarcodeHistoryDAO getOdsBarcodeHistoryDAO(){
		return odsBarcodeHistoryDAO;
	}

	@Override
	public List<OdsBarcodeHistoryDTO> getOdsBarcodeHistoryByParam(OdsBarcodeHistoryDTO odsBarcodeHistory){
		return odsBarcodeHistoryDAO.getOdsBarcodeHistoryByParam(odsBarcodeHistory);
	}

	@Override
	public Long getExportAmount(OdsBarcodeHistoryDTO dto) {
		return odsBarcodeHistoryDAO.searchOdsBarcodeHistorysCount(dto);
	}
}

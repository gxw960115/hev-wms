package com.haier.hevwms.po.service.impl;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.hevwms.po.dao.OdsOrderInfoDtlDAO;
import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.openplatform.wms.remoting.dto.OrderDirectDispatchOutDTO;

public class OdsOrderInfoDtlServiceImpl implements OdsOrderInfoDtlService{
	private OdsOrderInfoDtlDAO odsOrderInfoDtlDAO;
	
	
    public ExecuteResult<OdsOrderInfoDtlDTO> updateOdsOrderInfoDtl(OdsOrderInfoDtlDTO odsOrderInfoDtl){
		ExecuteResult<OdsOrderInfoDtlDTO> executeResult = new ExecuteResult<OdsOrderInfoDtlDTO>();
		odsOrderInfoDtlDAO.update(odsOrderInfoDtl);
		executeResult.setResult(odsOrderInfoDtl);
		return executeResult;
	}
	
	public ExecuteResult<OdsOrderInfoDtlDTO> deleteOdsOrderInfoDtl(Long odsOrderInfoDtlId){
		ExecuteResult<OdsOrderInfoDtlDTO> executeResult = new ExecuteResult<OdsOrderInfoDtlDTO>();
		
		odsOrderInfoDtlDAO.delete(odsOrderInfoDtlId);
		return executeResult;
	}
	public ExecuteResult<OdsOrderInfoDtlDTO> deleteOdsOrderInfoDtlAll(List<Long> idList){
		ExecuteResult<OdsOrderInfoDtlDTO> executeResult = new ExecuteResult<OdsOrderInfoDtlDTO>();
		
		odsOrderInfoDtlDAO.deleteAll(idList);
		return executeResult;
	}
	@Override
	public Pager<OdsOrderInfoDtlDTO> searchOdsOrderInfoDtls(Pager<OdsOrderInfoDtlDTO> pager, OdsOrderInfoDtlDTO odsOrderInfoDtl){
		List<OdsOrderInfoDtlDTO> odsOrderInfoDtls = odsOrderInfoDtlDAO.searchOdsOrderInfoDtls(pager, odsOrderInfoDtl);
		long size = odsOrderInfoDtlDAO.searchOdsOrderInfoDtlsCount(odsOrderInfoDtl);
		return Pager.cloneFromPager(pager, size, odsOrderInfoDtls);
	}
	
	@Override
	public void save(OdsOrderInfoDtlDTO odsOrderInfoDtl) {
		odsOrderInfoDtlDAO.save(odsOrderInfoDtl);
	}
	
	@Override
	public List<OdsOrderInfoDtlDTO> getOdsOrderInfoDtls(
			OdsOrderInfoDtlDTO odsOrderInfoDtl){
		return odsOrderInfoDtlDAO.getListByParam(odsOrderInfoDtl);
	}
	
	public OdsOrderInfoDtlDTO getOdsOrderInfoDtlById(Long odsOrderInfoDtlId){
		return odsOrderInfoDtlDAO.get(odsOrderInfoDtlId);
	}
	
	public List<OdsOrderInfoDtlDTO> getOdsOrderInfoDtls(){
		return odsOrderInfoDtlDAO.getAll();
	}
	
	public void setOdsOrderInfoDtlDAO(OdsOrderInfoDtlDAO odsOrderInfoDtlDAO){
		this.odsOrderInfoDtlDAO = odsOrderInfoDtlDAO;
	}
	public OdsOrderInfoDtlDAO getOdsOrderInfoDtlDAO(){
		return odsOrderInfoDtlDAO;
	}

	
	public Long getExportAmount(OdsOrderInfoDtlDTO odsOrderInfoDtl) {
		return odsOrderInfoDtlDAO.searchOdsOrderInfoDtlsCount(odsOrderInfoDtl);
	}

	@Override
	public OrderDirectDispatchOutDTO directDispatchCollect(String stodnNo, String dnNo,
														   String userName) {
		// TODO Auto-generated method stub
		OrderDirectDispatchOutDTO out = new OrderDirectDispatchOutDTO();

		odsOrderInfoDtlDAO.directDispatchCollect(stodnNo, dnNo, userName, out);

		return out;
	}
	

	

	


	

//	@Override
//	public ExecuteResult<OdsOrderInfoDtl> createOdsOrderInfoDtl(OdsOrderInfoDtl odsOrderInfoDtl){
//		ExecuteResult<OdsOrderInfoDtl> executeResult = new ExecuteResult<OdsOrderInfoDtl>();
//		
//		odsOrderInfoDtlDAO.save(odsOrderInfoDtl);
//		executeResult.setResult(odsOrderInfoDtl);
//		return executeResult;
//	}
//	
//	public ExecuteResult<OdsOrderInfoDtl> updateOdsOrderInfoDtl(OdsOrderInfoDtl odsOrderInfoDtl){
//		ExecuteResult<OdsOrderInfoDtl> executeResult = new ExecuteResult<OdsOrderInfoDtl>();
//		
//		odsOrderInfoDtlDAO.update(odsOrderInfoDtl);
//		executeResult.setResult(odsOrderInfoDtl);
//		return executeResult;
//	}
//	
//	public ExecuteResult<OdsOrderInfoDtl> deleteOdsOrderInfoDtl(Long odsOrderInfoDtlId){
//		ExecuteResult<OdsOrderInfoDtl> executeResult = new ExecuteResult<OdsOrderInfoDtl>();
//		
//		odsOrderInfoDtlDAO.delete(odsOrderInfoDtlId);
//		return executeResult;
//	}
//	public ExecuteResult<OdsOrderInfoDtl> deleteOdsOrderInfoDtlAll(List<Long> idList){
//		ExecuteResult<OdsOrderInfoDtl> executeResult = new ExecuteResult<OdsOrderInfoDtl>();
//		
//		odsOrderInfoDtlDAO.deleteAll(idList);
//		return executeResult;
//	}
//	
//	public List<OdsOrderInfoDtl> getOdsOrderInfoDtls(
//			OdsOrderInfoDtl odsOrderInfoDtl){
//		return odsOrderInfoDtlDAO.getListByParam(odsOrderInfoDtl);
//	}
//	
//	public OdsOrderInfoDtl getOdsOrderInfoDtlById(Long odsOrderInfoDtlId){
//		return odsOrderInfoDtlDAO.get(odsOrderInfoDtlId);
//	}
//	
//	public List<OdsOrderInfoDtl> getOdsOrderInfoDtls(){
//		return odsOrderInfoDtlDAO.getAll();
//	}
//	
//	public void setOdsOrderInfoDtlDAO(OdsOrderInfoDtlDAO odsOrderInfoDtlDAO){
//		this.odsOrderInfoDtlDAO = odsOrderInfoDtlDAO;
//	}
//	public OdsOrderInfoDtlDAO getOdsOrderInfoDtlDAO(){
//		return odsOrderInfoDtlDAO;
//	}


	
}

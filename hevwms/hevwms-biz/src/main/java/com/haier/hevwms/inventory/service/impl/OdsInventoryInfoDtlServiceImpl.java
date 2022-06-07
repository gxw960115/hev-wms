package com.haier.hevwms.inventory.service.impl;

import java.util.List;

import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.OdsInventoryInfoDtlService;
import com.haier.hevwms.order.domain.OdsWmsOrder;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;

public class OdsInventoryInfoDtlServiceImpl implements
		OdsInventoryInfoDtlService {
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
	

	@Override
	public ExecuteResult<OdsInventoryInfoDtl> createOdsInventoryInfoDtl(
			OdsInventoryInfoDtl odsInventoryInfoDtl) {
		ExecuteResult<OdsInventoryInfoDtl> executeResult = new ExecuteResult<OdsInventoryInfoDtl>();

		odsInventoryInfoDtlDAO.save(odsInventoryInfoDtl);
		executeResult.setResult(odsInventoryInfoDtl);
		return executeResult;
	}

	public ExecuteResult<OdsInventoryInfoDtl> updateOdsInventoryInfoDtl(
			OdsInventoryInfoDtl odsInventoryInfoDtl) {
		ExecuteResult<OdsInventoryInfoDtl> executeResult = new ExecuteResult<OdsInventoryInfoDtl>();

		odsInventoryInfoDtlDAO.update(odsInventoryInfoDtl);
		executeResult.setResult(odsInventoryInfoDtl);
		return executeResult;
	}

	public ExecuteResult<OdsInventoryInfoDtl> deleteOdsInventoryInfoDtl(
			Long odsInventoryInfoDtlId) {
		ExecuteResult<OdsInventoryInfoDtl> executeResult = new ExecuteResult<OdsInventoryInfoDtl>();

		odsInventoryInfoDtlDAO.delete(odsInventoryInfoDtlId);
		return executeResult;
	}

	public ExecuteResult<OdsInventoryInfoDtl> deleteOdsInventoryInfoDtlAll(
			List<Long> idList) {
		ExecuteResult<OdsInventoryInfoDtl> executeResult = new ExecuteResult<OdsInventoryInfoDtl>();

		odsInventoryInfoDtlDAO.deleteAll(idList);
		return executeResult;
	}

	public Pager<OdsInventoryInfoDtl> searchOdsInventoryInfoDtls(
			Pager<OdsInventoryInfoDtl> pager,
			OdsInventoryInfoDtl odsInventoryInfoDtl) {
		List<OdsInventoryInfoDtl> odsInventoryInfoDtls = odsInventoryInfoDtlDAO
				.searchOdsInventoryInfoDtls(pager, odsInventoryInfoDtl);
		long size = odsInventoryInfoDtlDAO
				.searchOdsInventoryInfoDtlsCount(odsInventoryInfoDtl);
		return Pager.cloneFromPager(pager, size, odsInventoryInfoDtls);
	}

	@Override
	public void updateUseQtyByOrderNo(OdsWmsOrder odsWmsOrder) {
		odsInventoryInfoDtlDAO.updateUseQtyByOrderNo(odsWmsOrder);
	}
	
	@Override
	public void updateUseQty(String[] ids) {
		odsInventoryInfoDtlDAO.updateUseQty(ids);
	}
	
	@Override
	public List<OdsInventoryInfoDtl> getListByids(String[] ids) {
		// TODO Auto-generated method stub
		return odsInventoryInfoDtlDAO.getListByids(ids);
	}
	
	public OdsInventoryInfoDtl getOdsInventoryInfoDtlById(
			Long odsInventoryInfoDtlId) {
		return odsInventoryInfoDtlDAO.get(odsInventoryInfoDtlId);
	}

	public List<OdsInventoryInfoDtl> getOdsInventoryInfoDtls() {
		return odsInventoryInfoDtlDAO.getAll();
	}

	public void setOdsInventoryInfoDtlDAO(
			OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO) {
		this.odsInventoryInfoDtlDAO = odsInventoryInfoDtlDAO;
	}

	public OdsInventoryInfoDtlDAO getOdsInventoryInfoDtlDAO() {
		return odsInventoryInfoDtlDAO;
	}

	@Override
	public Pager<OdsInventoryInfoDtl> searchDiffInventorys(
			Pager<OdsInventoryInfoDtl> pager,
			OdsInventoryInfoDtl odsInventoryInfoDtl) {
		List<OdsInventoryInfoDtl> odsInventoryInfoDtls = odsInventoryInfoDtlDAO
				.searchDiffInventorys(pager, odsInventoryInfoDtl);
		long size = odsInventoryInfoDtlDAO
				.searchDiffInventoryCount(odsInventoryInfoDtl);
		return Pager.cloneFromPager(pager, size, odsInventoryInfoDtls);
	}

	@Override
	public List<OdsInventoryInfoDtl> getDiffInventoryByParam(OdsInventoryInfoDtl odsInventoryInfoDtl){
		return odsInventoryInfoDtlDAO.getDiffInventoryByParam(odsInventoryInfoDtl);
	}
	public List<OdsInventoryInfoDtl> getOdsInventoryInfoDtlByParam(OdsInventoryInfoDtl odsInventoryInfoDtl){
		return odsInventoryInfoDtlDAO.getOdsInventoryInfoDtlByParam(odsInventoryInfoDtl);
	}
	@Override
	public Pager<OdsInventoryInfoDtl> sapQtyDetail(
		Pager<OdsInventoryInfoDtl> pager,
		OdsInventoryInfoDtl odsInventoryInfoDtl) {
	    List<OdsInventoryInfoDtl> list =odsInventoryInfoDtlDAO.sapQtyDetail(pager, odsInventoryInfoDtl);
	    Long size=odsInventoryInfoDtlDAO.sapQtyDetailCount(odsInventoryInfoDtl);
	    pager.setRecords(list);
	    pager.setTotalRecords(size);
	    return pager;
	}
	
	/**
	 * 修改库存条码备注
	 * @param odsOrderInfoDtl
	 * @return
	 */
	@Override
	public ExecuteResult<OdsInventoryInfoDtl> updateBarcodeRemark(
			OdsInventoryInfoDtl odsInventoryInfoDtl) {
		ExecuteResult<OdsInventoryInfoDtl> executeResult = new ExecuteResult<OdsInventoryInfoDtl>();
		
		int count = odsInventoryInfoDtlDAO.updateBarcodeRemark(odsInventoryInfoDtl);
		if (count != 0){
			executeResult.setResult(odsInventoryInfoDtl);
		} 
		return executeResult;
	}

	/**
	 * 更新条码锁定状态
	 * @param barcode
	 * @param status
	 * @return
	 */
	@Override
	public String updateBarcodeStatus(String barcode, String status) {
		
		return String.valueOf(odsInventoryInfoDtlDAO.updateBarcodeStatus(barcode, status));
	}	
	
	public Long getExportAmount(OdsInventoryInfoDtl dto){
		return odsInventoryInfoDtlDAO.searchOdsInventoryInfoDtlsCount(dto);
	}

	@Override
	public String addInventory(OdsInventoryInfoDtlDTO dto) {
		OdsInventoryInfoDtlDTO result = new OdsInventoryInfoDtlDTO();
		odsInventoryInfoDtlDAO.addInventory(dto, result);
		if (result != null && result.getMsg() != null) {
			return result.getMsg();
		}
		return "ERROR";
	}

	@Override
	public String deleteInventory(String barcode) {
		try {
			int i = odsInventoryInfoDtlDAO.deleteInventory(barcode);
			return "SUCCESS, delete " + i + " rows!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Delete Error : " + e.getMessage();
		}
	}
}

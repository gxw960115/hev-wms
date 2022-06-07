package com.haier.hevwms.inventory.service;

import java.util.List;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.order.domain.OdsWmsOrder;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;

public interface OdsInventoryInfoDtlService {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsInventoryInfoDtl> createOdsInventoryInfoDtl(
			OdsInventoryInfoDtl odsInventoryInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsInventoryInfoDtl> updateOdsInventoryInfoDtl(
			OdsInventoryInfoDtl odsInventoryInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsInventoryInfoDtl> deleteOdsInventoryInfoDtl(
			Long odsInventoryInfoDtlId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsInventoryInfoDtl> deleteOdsInventoryInfoDtlAll(
			List<Long> idList);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<OdsInventoryInfoDtl> searchOdsInventoryInfoDtls(
			Pager<OdsInventoryInfoDtl> pager,
			OdsInventoryInfoDtl odsInventoryInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public OdsInventoryInfoDtl getOdsInventoryInfoDtlById(
			Long odsInventoryInfoDtlId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsInventoryInfoDtl> getOdsInventoryInfoDtls();

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<OdsInventoryInfoDtl> searchDiffInventorys(
			Pager<OdsInventoryInfoDtl> pager,
			OdsInventoryInfoDtl odsInventoryInfoDtl);
	public List<OdsInventoryInfoDtl> getListByids(String[] ids);
	public void updateUseQty(String[] ids);
	public List<OdsInventoryInfoDtl> getDiffInventoryByParam(OdsInventoryInfoDtl odsInventoryInfoDtl);
	public void updateUseQtyByOrderNo(OdsWmsOrder odsWmsOrder);
	public List<OdsInventoryInfoDtl> getOdsInventoryInfoDtlByParam(OdsInventoryInfoDtl odsInventoryInfoDtl);
	
	/**
	 * 
	* @Title: sapQtyDetail
	* @Description:  (这里用一句话描述这个类的作用)
	* @param @param pager
	* @param @param odsInventoryInfoDtl
	* @param @return
	* @return Pager<OdsInventoryInfoDtl>
	* @throws
	 */
	public Pager<OdsInventoryInfoDtl> sapQtyDetail(
		Pager<OdsInventoryInfoDtl> pager,
		OdsInventoryInfoDtl odsInventoryInfoDtl);
	/**
	 * 修改库存条码备注
	 * @param odsOrderInfoDtl
	 * @return
	 */
	public ExecuteResult<OdsInventoryInfoDtl> updateBarcodeRemark(OdsInventoryInfoDtl odsInventoryInfoDtl);
	
	/**
	 * 更新条码锁定状态
	 * @param barcode
	 * @param status
	 * @return
	 */
	public String updateBarcodeStatus(String barcode,String status);

	/**
	 * 查询导出数量
	 * @param dto
	 */
	public Long getExportAmount(OdsInventoryInfoDtl dto);

	/**
	 * 增加库存
	 * @param dto
	 * @return
	 */
	String addInventory(OdsInventoryInfoDtlDTO dto);

	/**
	 * 删除库存
	 * @param barcode
	 * @return
	 */
	String deleteInventory(String barcode);
}

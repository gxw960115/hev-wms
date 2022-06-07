package com.haier.hevwms.inventory.dao;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.order.domain.OdsWmsOrder;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OdsInventoryInfoDtlDAO extends
		CommonDAO<OdsInventoryInfoDtl, Long> {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsInventoryInfoDtl> searchOdsInventoryInfoDtls(
			@Param("pager") Pager<OdsInventoryInfoDtl> pager,
			@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Long searchOdsInventoryInfoDtlsCount(
			@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void deleteByBarcode(@Param("barcode") String barcode);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public OdsInventoryInfoDtl getByBarcode(@Param("barcode") String barcode);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void updateAmtByBarcode(@Param("barcode") String barcode,
			@Param("amt") Long amt);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsInventoryInfoDtl> getListByids(@Param("ids") String[] ids);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void updateUseQty(@Param("ids") String[] ids);
	
	public void updateUseQtyByOrderNo(@Param("odsWmsOrder") OdsWmsOrder odsWmsOrder);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsInventoryInfoDtl> searchDiffInventorys(
			@Param("pager") Pager<OdsInventoryInfoDtl> pager,
			@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Long searchDiffInventoryCount(
			@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsInventoryInfoDtl> getDiffInventoryByParam(@Param("odsInventoryInfoDtl")
			OdsInventoryInfoDtl odsInventoryInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsInventoryInfoDtl> getOdsInventoryInfoDtlByParam(@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);
	/**
	 * 
	* @Title: getInventoryPieData
	* @Description:  (这里用一句话描述这个类的作用)
	* @param @return
	* @return List<OdsInventoryInfoDtl>
	* @throws
	 */
	public List<OdsInventoryInfoDtlDTO> getInventoryPieData();
	/**
	 * 
	* @Title: sapQtyDetail
	* @Description:  (这里用一句话描述这个类的作用)
	* @param @param pager
	* @param @param odsInventoryInfoDtl
	* @param @return
	* @return List<OdsInventoryInfoDtl>
	* @throws
	 */
	public List<OdsInventoryInfoDtl> sapQtyDetail(
		@Param("pager") Pager<OdsInventoryInfoDtl> pager,
		@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);
	/**
	 * 
	* @Title: sapQtyDetailCount
	* @Description:  (这里用一句话描述这个类的作用)
	* @param @param odsInventoryInfoDtl
	* @param @return
	* @return Long
	* @throws
	 */
	public Long sapQtyDetailCount(
		@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);

	/**
	 * 
	* @Title: receiptWhenPD
	* @Description: 盘点时入库
	* @param @param odsInventoryInfoDtl
	* @return void
	* @throws
	 */
	public void receiptWhenPD(@Param("dtl") OdsInventoryInfoDtl dtl);
	
	/**
	 * 
	* @Title: updateQty
	* @Description: 盘点时出库冲减库存
	* @param @param id
	* @return void
	* @throws
	 */
	public void updateQty(@Param("id")Long id,@Param("barcode")String barcode
					,@Param("scanQty")Long scanQty);
	
	/**
	 * 修改库存条码备注
	 * @param odsOrderInfoDtl
	 * @return
	 */
	public Integer updateBarcodeRemark(@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);
	
	/**
	 * 更新条码锁定状态
	 * @param barcode
	 * @param status
	 * @return
	 */
	public Integer updateBarcodeStatus(@Param("barcode")String barcode,@Param("status")String status);

	//更新库位为入库的物理库位
	public void updateInventoryLocation(@Param("odsInventoryInfoDtl")OdsInventoryInfoDtl odsInventoryInfoDtl);
	
	public void updateQtyInfo(@Param("id")Long id,@Param("qty")Long qty, @Param("useQty")Long useQty);
	
	public void updateInventoryDtlBin(@Param("barcode")String barcode, @Param("orderNo") String orderNo);

	//更新use_qty
	public void updateUseQtyBySapOrderNo(@Param("odsInventoryInfoDtl")OdsInventoryInfoDtl odsInventoryInfoDtl, @Param("qty")Long qty);
	/**
	 * 
	 * @param odsWmsOrder
	 * @return
	 */
	public List<OdsInventoryInfoDtlDTO> searchScrapBarcodeDtlList(
			@Param("pager") Pager<OdsInventoryInfoDtlDTO> pager,
			@Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
	/**
	 * 
	 * @param odsWmsOrder
	 * @return
	 */
	public long searchScrapBarcodeDtlCount(@Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/**
	 * @Title: searchOdsInventoryInfos
	 * @Description: 查询所有库存
	 * @param pager
	 * @param odsInventoryInfo
	 * @return List<OdsInventoryInfoDTO>
	 * @throws
	 */
//	public List<OdsInventoryInfoDtl> searchOdsInventoryBinInfos(@Param("pager") Pager<OdsInventoryInfoDtl> pager, @Param("odsInventoryInfoDtl") OdsInventoryInfoDtl OdsInventoryInfoDtl);
	public List<OdsInventoryInfoDtlDTO> searchOdsInventoryBinInfos(@Param("pager") Pager<OdsInventoryInfoDtlDTO> pager, @Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
	public List<OdsInventoryInfoDtlDTO> searchOdsInventoryMaterialInfos(@Param("pager") Pager<OdsInventoryInfoDtlDTO> pager, @Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
	public List<OdsInventoryInfoDtlDTO> searchOdsInventoryInfos(@Param("pager") Pager<OdsInventoryInfoDtlDTO> pager, @Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/**
	 * @Title: searchOdsInventoryInfosCount
	 * @Description: 查询总数
	 * @param odsInventoryInfo
	 * @return Long
	 * @throws
	 */
//	public Long searchOdsInventoryBinInfosCount(@Param("odsInventoryInfoDtl") OdsInventoryInfoDtl odsInventoryInfoDtl);

	public Long searchOdsInventoryBinInfosCount(@Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
	public Long searchOdsInventoryMaterialInfosCount(@Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
	public Long searchOdsInventoryInfosCount(@Param("odsInventoryInfoDtl") OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/**
	 * 增加库存
	 * @param inParam
	 * @param outParam
	 */
	void addInventory(@Param("inParam") OdsInventoryInfoDtlDTO inParam, @Param("outParam") OdsInventoryInfoDtlDTO outParam);

	/**
	 * 删除库存
	 * @param barcode
	 * @return 删除行数
	 */
	int deleteInventory(@Param("barcode") String barcode);
}

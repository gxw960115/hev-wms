package com.haier.hevwms.inventory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.inventory.domain.OdsMoveInventory;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;

public interface OdsMoveInventoryDAO extends CommonDAO<OdsMoveInventory,Long>{
	public List<OdsMoveInventory> searchOdsMoveInventorys(@Param("pager") Pager<OdsMoveInventory> pager, @Param("odsMoveInventory") OdsMoveInventory odsMoveInventory);
	public Long searchOdsMoveInventorysCount(@Param("odsMoveInventory") OdsMoveInventory odsMoveInventory);
	public void deleteAll(@Param("idList")List<Long> idList);
	/**
	 * 根据条件查询移库明细
	 * @param odsMoveInventory
	 * @return
	 */
	public List<OdsMoveInventory> searchOdsMoveInventoryByParam(@Param("odsMoveInventory") OdsMoveInventory odsMoveInventory);
	/**
	 * 根据sap返回信息更新移库过账是否成功和信息
	 * @param odsMI
	 */
	public void updateSapBySendId(@Param("odsMoveInventory") OdsMoveInventory odsMoveInventory);
}

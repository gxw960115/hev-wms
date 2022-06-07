package com.haier.hevwms.order.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgStoDownDTO;


public interface StgStoDownDAO extends CommonDAO<StgStoDownDTO, Long> {

	public List<StgStoDownDTO> searchStgStoDowns(@Param("pager") Pager<StgStoDownDTO> pager, @Param("stgStoDown") StgStoDownDTO stgStoDown);

	public Long searchStgStoDownsCount(
            @Param("stgStoDown") StgStoDownDTO stgStoDown);

	public String deleteAll(@Param("idList") List<Long> idList);

	/**
	 * 根据stg查询stgstodown的信息（查看是否存在重复）
	 * 
	 * @param stgStoDown
	 * @return
	 */
	public StgStoDownDTO getStgStoDownByParam(
            @Param("stgStoDown") StgStoDownDTO stgStoDown);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<StgStoDownDTO> getListByParam(
            @Param("stgStoDown") StgStoDownDTO stgStoDown);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String updatePrescanByStoNo(@Param("stoNo") String stoNo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void updateFinishQty(@Param("stoNo") String stoNo);
	
	public void cleanFinishQty(@Param("stoNo") String stoNo);
	
	public void closeStgStoDown(@Param("idList") String[] idList);
	//20140721 STO reopen chenp
	public void openStgStoDown(@Param("idList") String[] idList);
	/*
	 * add by linzx @20151207 
	 * TODO：获取stg_sto_down表中最近一天的所有订单信息
	 */
	public List<StgStoDownDTO> searchAllForStodnDown();
	
	public int getStoByStodn(@Param("stgStoDown") StgStoDownDTO stgStoDown);
	
	/**
	 * 
	* @Title: updateStoConfirm
	* @Description: 更新sto审批标记
	* @param @param id
	* @param @return
	* @return int
	* @throws
	 */
	public int updateStoConfirm(@Param("stoNo") String stoNo);
}
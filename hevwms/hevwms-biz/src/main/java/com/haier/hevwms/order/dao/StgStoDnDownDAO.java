package com.haier.hevwms.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgStoDnDownDTO;

public interface StgStoDnDownDAO extends CommonDAO<StgStoDnDownDTO, Long>{
	
	public List<StgStoDnDownDTO> searchStgStoDnDowns(@Param("pager") Pager<StgStoDnDownDTO> pager, @Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);

	public Long searchStgStoDnDownsCount(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	
	public List<StgStoDnDownDTO> getStgStoDnDowns(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<StgStoDnDownDTO> getListByParam(
            @Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	
	public void updateFinishQty(@Param("stoDnNo") String stoDnNo);
	
	public void cleanFinishQty(@Param("stoDnNo") String stoDnNo);
	
	public void updatePrescanByStoNo(@Param("stoDnNo") String stoDnNo);
	
	//add by linzx @20151207 下载STODN的时候更新操作
	public void updateStoDnDown(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	public void save(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	public List<StgStoDnDownDTO> getStgStoDnDowns2(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	
	public void updateErrorNoNotSuc(@Param("stoDnNo") String stoDnNo);
	/**
	 * Sun Yanfei  根据stodn号和物料关联sto查询是否是来自9990工厂的sto
	 * @param stoDnNo
	 * @param materialNo
	 * @return
	 */
	public int getStoDnCountByParam(@Param("stoDnNo") String stoDnNo, @Param("materialNo") String materialNo);
	
	public int insertToStoDnDelete(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	/**
	 * 
	* @Title: insertstodnDeleteBystodn
	* @Description: 把删除的行项目插到stodn删除表
	* @param @param stodnNo
	* @param @param stodnItemNo
	* @return void
	* @throws
	 */
	public void insertstodnDeleteBystodn(@Param("stodnNo") String stodnNo, @Param("stodnItemNo") String stodnItemNo);
	
	/**
	 * 
	* @Title: deleteByStodnAndStodnItem
	* @Description: 删除行项目
	* @param @param stodnNo
	* @param @param stodnItemNo
	* @return void
	* @throws
	 */
	public void deleteByStodnAndStodnItem(@Param("stodnNo") String stodnNo, @Param("stodnItemNo") String stodnItemNo);
	
	/**
	 * 
	* @Title: ifStartScan
	* @Description: 检查订单是否开始扫描
	* @param @param stodnNo
	* @param @param stodnItemNo
	* @param @return
	* @return String
	* @throws
	 */
	public int ifStartScan(@Param("stodnNo") String stodnNo, @Param("stodnItemNo") String stodnItemNo);
	/**
	 * 根据stodn no 获取stodn items
	 * @param stgStoDnDown
	 * @return
	 */
	public List<String> getStodnItems(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	
	/**
	 * 根据sto no 获取stodnno
	 */
	public List<String> getStodnNos(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	
	public List<StgStoDnDownDTO> searchStgStoDnDownsFromFactory(@Param("pager") Pager<StgStoDnDownDTO> pager, @Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
	
	public Long searchStgStoDnDownsFromFactoryCount(@Param("stgStoDnDown") StgStoDnDownDTO stgStoDnDown);
}

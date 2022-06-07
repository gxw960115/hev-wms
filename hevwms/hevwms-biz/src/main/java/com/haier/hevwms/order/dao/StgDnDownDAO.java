package com.haier.hevwms.order.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgDnDownDTO;


public interface StgDnDownDAO extends CommonDAO<StgDnDownDTO,Long>{
	
	public List<StgDnDownDTO> searchStgDnDowns(@Param("pager") Pager<StgDnDownDTO> pager, @Param("stgDnDown") StgDnDownDTO stgDnDown);
	
	public Long searchStgDnDownsCount(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	/**
	 * 
	* @Title: searthDnDetail
	* @Description: billing detail 页面分页查询
	* @param @param pager
	* @param @param stgDnDown
	* @param @return
	* @return List<StgDnDownDTO>
	* @throws
	 */
	public List<StgDnDownDTO> searthDnDetail(@Param("pager") Pager<StgDnDownDTO> pager, @Param("stgDnDown") StgDnDownDTO stgDnDown);
	/**
	 * @param pager
	 * @param stgDnDown
	 * @return
	 */
	public List<StgDnDownDTO> searchDirectDispatchDn(@Param("pager") Pager<StgDnDownDTO> pager, @Param("stgDnDown") StgDnDownDTO stgDnDown);
	/**
	 * 
	* @Title: searthDnDetailCount
	* @Description: billing detail 分页，总条数查询
	* @param @param stgDnDown
	* @param @return
	* @return Long
	* @throws
	 */
	public Long searthDnDetailCount(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	
	/**
	 * @param stgDnDown
	 * @return
	 */
	public Long searchDirectDispatchDnCount(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	/**
	 * @param stgDnDown
	 * @return
	 */
	public Long searchDirectDispatchDn(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	
	public void deleteAll(@Param("idList") List<Long> idList);
	/**
	 * 根据条件查询stgdndown
	 * @param stgDnDown
	 * @return
	 */
	
	public StgDnDownDTO getStgDnDownByParam(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	/**
	 * 查询结果列表导出excel
	 * @param stgDnDown
	 * @return
	 */
	
	public List<StgDnDownDTO> getStgDnDownsByParam(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	
	public void closeStgDn(@Param("idArray") String[] idArray);
	//20140721 DN reopen chenp
	public void openStgDn(@Param("idArray") String[] idArray);
	//add by linzx @20151130
	public void updateSapBackByOrderNo(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	//add by linzx @20151130
    public List<StgDnDownDTO> getStgDnDowns2ByParam(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    /**
     * sunyanfei 进入过账更改标记
     */
    public void updateErrorNoNotSuc(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    /**
     * 
    * @Title: updatePostSuccess
    * @Description: TODO (孙艳飞，过账成功更新 2015-12-10)
    * @param @param stgDnDown
    * @return void
    * @throws
     */
    public void updatePostSuccess(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    /*
     * add by linzx @20151222
     * 根据DN号查询stg_dn_down中所有的记录，返回list
     */
    public List<StgDnDownDTO> getListByDn(@Param("dnNo") String dnNo);
    
    /**
     *   判断dn是否为billing
     * @param dnNo
     * @return
     */
    public boolean isBilling(@Param("dnNo") String dnNo);
    /**
     * 查询没有全部完成出库的billing 总数
     * @param stgDnDown
     * @return
     */
    public Long searchBillingUnFinishedCount(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    /**
     * 分页查询没有全部完成出库的billing 
     * @param stgDnDown
     * @return
     */
    public List<StgDnDownDTO> searchBillingUnFinishedList(@Param("pager") Pager<StgDnDownDTO> pager, @Param("stgDnDown") StgDnDownDTO stgDnDown);
}
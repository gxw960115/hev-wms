package com.haier.hevwms.order.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.hevwms.order.domain.DnForTemp;
import com.haier.hevwms.order.domain.StgDnDownTemp;

public interface StgDnDownTempDAO extends CommonDAO<StgDnDownTemp,Long>{
	
	public List<StgDnDownTemp> searchStgDnDownTemps(@Param("pager") Pager<StgDnDownTemp> pager, @Param("stgDnDownTemp") StgDnDownTemp stgDnDownTemp);
	public Long searchStgDnDownTempsCount(@Param("stgDnDownTemp") StgDnDownTemp stgDnDownTemp);
	public void deleteAll(@Param("idList")List<Long> idList);
	/**
	 * 生成流水号
	 * @return
	 */
	public Long searchStgDnTempSTNO();
	/**
	 * 调用存储过程
	 * @param dnForTemp
	 */
	public void toDnDowm(@Param("dnForTemp") DnForTemp dnForTemp);
	
	/**
	* @Title: delDnDownTempHistory
	* @Description: 
	* @param @return
	* @return int
	* @throws
	 */
	public int delDnDownTempHistory();
	
	/**
	* @Title: insertDnTempHistory
	* @Description: 
	* @param @return
	* @return int
	* @throws
	 */
	public int insertDnTempHistory();
}
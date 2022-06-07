package com.haier.hevwms.order.dao;

import com.haier.hevwms.order.domain.InboundForTemp;
import com.haier.hevwms.order.domain.StgInboundDownTemp;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StgInboundDownTempDAO extends CommonDAO<StgInboundDownTemp,Long>{

	public List<StgInboundDownTemp> searchStgInboundDownTemps(@Param("pager") Pager<StgInboundDownTemp> pager, @Param("stgInboundDownTemp") StgInboundDownTemp stgInboundDownTemp);
	public Long searchStgInboundDownTempsCount(@Param("stgInboundDownTemp") StgInboundDownTemp stgInboundDownTemp);
	public void deleteAll(@Param("idList")List<Long> idList);
	/**
	 * 获得序列号作为批次号
	 * @return
	 */
	public Long searchStgInboundDownSt();
	/**
	 * 调用存储过程
	 * @param inboundForTemp
	 * @return
	 */
	public InboundForTemp toInboundDown(InboundForTemp inboundForTemp);

    /**
     * @Title: delInbdDownTempHistory
     * @Description:
     * @param @return
     * @return int
     * @throws
      */
     public int delInbdDownTempHistory();

     /**
     * @Title: insertInbdTempHistory
     * @Description:
     * @param @return
     * @return int
     * @throws
      */
     public int insertInbdTempHistory();
}

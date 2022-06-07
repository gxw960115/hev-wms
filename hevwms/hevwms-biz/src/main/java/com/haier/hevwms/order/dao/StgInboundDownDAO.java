package com.haier.hevwms.order.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;

/**
 * inbound detail
 * 
 * @author sunyanfei 2015-11-25
 * 
 */
public interface StgInboundDownDAO extends CommonDAO<StgInboundDownDTO, Long> {

	public List<StgInboundDownDTO> searchStgInboundDowns(
			@Param("pager") Pager<StgInboundDownDTO> pager,
			@Param("stgInboundDown") StgInboundDownDTO stgInboundDown);

	public Long searchStgInboundDownsCount(
			@Param("stgInboundDown") StgInboundDownDTO stgInboundDown);

	public void deleteAll(@Param("idList") List<Long> idList);

	/**
	 * 跟回传的Inbound查询数据
	 * 
	 * @param stgInboundDown
	 * @return
	 */
	public StgInboundDownDTO getStgInboundDownByParam(StgInboundDownDTO stgInboundDown);

	/**
	 * 查询inbound信息不分页
	 * 
	 * @param stgInboundDown
	 * @return
	 */
	public List<StgInboundDownDTO> getStgInboundDownsByParam(
			@Param("stgInboundDown") StgInboundDownDTO stgInboundDown);
}
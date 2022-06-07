package com.haier.hevwms.order.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;

public interface OdsWmsOrderDAO extends CommonDAO<OdsWmsOrderDTO, Long> {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsWmsOrderDTO> searchOdsWmsOrders(
			@Param("pager") Pager<OdsWmsOrderDTO> pager,
			@Param("odsWmsOrder") OdsWmsOrderDTO odsWmsOrder);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Long searchOdsWmsOrdersCount(
			@Param("odsWmsOrder") OdsWmsOrderDTO odsWmsOrder);

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
	public void deltByOrderNo(@Param("odsWmsOrder") OdsWmsOrderDTO odsWmsOrder,
			@Param("docType") String docType);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void updateScrapOrder(@Param("odsWmsOrder") OdsWmsOrderDTO odsWmsOrder);
	
	public void updateScrapDtl(@Param("odsWmsOrder") OdsWmsOrderDTO odsWmsOrder);
	/**
	 * 
	 * @param odsWmsOrder
	 * @return
	 */
	public List<OdsWmsOrderDTO> getOdsWmsOrder(@Param("odsWmsOrder") OdsWmsOrderDTO odsWmsOrder);
}
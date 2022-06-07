package com.haier.hevwms.po.dao;

import java.util.List;

import com.haier.openplatform.wms.remoting.dto.OrderDirectDispatchOutDTO;
import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;

public interface OdsOrderInfoDtlDAO extends CommonDAO<OdsOrderInfoDtlDTO,Long>{
	
	public List<OdsOrderInfoDtlDTO> searchOdsOrderInfoDtls(@Param("pager") Pager<OdsOrderInfoDtlDTO> pager, @Param("odsOrderInfoDtl") OdsOrderInfoDtlDTO odsOrderInfoDtl);
	public Long searchOdsOrderInfoDtlsCount(@Param("odsOrderInfoDtl") OdsOrderInfoDtlDTO odsOrderInfoDtl);
	public void deleteAll(@Param("idList")List<Long> idList);

	public List<OdsOrderInfoDtlDTO> getListByParam(@Param("odsOrderInfoDtl") OdsOrderInfoDtlDTO odsOrderInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public void deleteOdsOrderInfoDtlByNo(@Param("stoNo")String stoNo);
	
	/**
	 * added by gaozhaomei  2016-11-7
	 * 方法描述：根绝stodnNo 和itemNo 获取相应扫描出库成功但是未扫描入库的明细， 
	 * 
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNo(
			@Param("pager") Pager<OdsOrderInfoDtlDTO> pager,
			@Param("odsOrderInfoDtl") OdsOrderInfoDtlDTO odsOrderInfoDtl);
	/**
	 * added by gaozhaomei  2016-11-7
	 * 方法描述：根绝stodnNo 和itemNo 获取相应扫描出库成功但是未扫描入库的明细， 
	 * 
	 * @param
	 * @return
	 */
	public Long searchOgpDetailsByStodnNoCount(
			@Param("odsOrderInfoDtl") OdsOrderInfoDtlDTO odsOrderInfoDtl);
	
	//更新订单的库位信息
	public void updateOrderDtlLocation(OdsOrderInfoDtlDTO odsOrderInfoDtl);
	
	//通过sapOrderNo删除odsOrderInfoDtl中已经扫描的信息
	public void deleteOrderDtlBySapOrderNo(@Param("sapOrderNo")String sapOrderNo);
	
	//根据sapOrderNo查询订单的扫描信息
	public List<OdsOrderInfoDtlDTO> searchOrderDtlBySapOrderNo(@Param("sapOrderNo")String sapOrderNo);

	public void directDispatchCollect(@Param("stodnNo")String stodnNo, @Param("dnNo")String dnNo,
									  @Param("userName")String userName, @Param("out") OrderDirectDispatchOutDTO out);
}
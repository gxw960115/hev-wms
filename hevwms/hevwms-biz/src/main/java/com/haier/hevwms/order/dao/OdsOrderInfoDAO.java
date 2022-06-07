package com.haier.hevwms.order.dao;

import com.haier.hevwms.order.domain.OdsOrderInfo;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OdsOrderInfoDAO extends CommonDAO<OdsOrderInfoDTO, Long> {
	/**
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDTO> searchOdsOrderInfos(
			@Param("pager") Pager<OdsOrderInfoDTO> pager,
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public Long searchOdsOrderInfosCount(@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);
	/**
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public void deleteAll(@Param("idList") List<Long> idList);
	/**
	 * 查询所有需要过账的po
	 *
	 * @return
	 */
	public List<OdsOrderInfoDTO> getAllOdsWithPo();
	/**
	 * po记账sap返回信息更新
	 *
	 * @param odsOrderInfo
	 */
	public void updateSapToWms(
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 根据id查询需要过账的po
	 *
	 * @param rowId
	 * @return
	 */
	public OdsOrderInfoDTO getByRowIds(@Param("rowId") Long rowId);
	/**
	 * 根据orderNo查询Order信息
	 *
	 * @param orderNo
	 * @return
	 */
	public List<OdsOrderInfoDTO> searchByDnNo(@Param("orderNo") String orderNo);
	/**
	 * 根据orderNo更新sapFlag锁定
	 *
	 * @param orderNo
	 * @return
	 */
	public int updateByDnNo(@Param("orderNo") String orderNo);
	/**
	 * pc端重新过账失败的数据
	 *
	 * @param orderNo
	 * @return
	 */
	public int updateForPc(@Param("orderNo") String orderNo);
	/**
	 * 根据sap返回信息更新sap返回字段
	 *
	 * @param odsInfo
	 */
	public void updateDnSapBackByOrderNo(OdsOrderInfo odsOrderInfo);
	/**
	 * 根据ids查询出入库单据明细
	 *
	 * @param ids
	 * @return
	 */
	public OdsOrderInfoDTO searchOdsOrderInfoByids(@Param("id") String id);
	/**
	 * sto过账更新回传数据
	 *
	 * @param odsOrderInfo
	 */
	public void updateSapByBatchNo(OdsOrderInfoDTO odsOrderInfo);
	/**
	 * 锁定失败更新失败标记
	 *
	 * @param orderNo
	 */
	public void updateErrorNo(@Param("orderNo") String orderNo);
	/**
	 * 重新过账锁定失败 以失败解锁
	 *
	 * @param orderNo
	 */
	public void updateErrorPc(@Param("orderNo") String orderNo);
	/**
	 *
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDTO> searchOrderNos(
			@Param("pager") Pager<OdsOrderInfoDTO> pager,
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);
	/**
	 *
	 * 方法描述：根绝stodnno获取 该单号下的所有sto dn detail
	 *
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDTO> searchStoDNDetail(
			@Param("pager") Pager<OdsOrderInfoDTO> pager,
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);
	/**
	 * 方法描述：根绝stodnno获取 该单号下的所有sto dn detail
	 *
	 * @param
	 * @return
	 */
	public Long searchStoDNDetailCount(
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);
	/**
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public Long searchOrderNosCount(
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);
	/**
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDTO> getListByParam(
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);
	/**
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public void updatePrescanByOrderNo(@Param("orderNo") String orderNo);
	/**
	 * 根据单据号更新sapFlag
	 *
	 * @param rowId
	 */
	// public void updateSapFlag(@Param("rowId") Long rowId);
	/**
	 *
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public Long createOrderNo();

	/**
	 *
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public void deltByOrderNo(@Param("orderNo") String orderNo,
			@Param("docType") String docType);

	/**
	 * 根据rowId解锁过账单据
	 *
	 * @param rowId
	 */
	public void updateByRowId(@Param("rowId") Long rowId);

	public void updateCarNoByOrderNo(OdsOrderInfoDTO odsOrderInfo);

	/**
	 *
	 * 方法描述：参数描述：返回值描述
	 *
	 * @param
	 * @return
	 */
	public void updateErrorNoNotSuc(@Param("orderNo") String orderNo,
			@Param("userName") String userName);

	public List<OdsOrderInfoDTO> getAllByName(
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);

	/*
	 * add by linzx@20151208 根据SAP凭证单号进行更新
	 */
	public void updateSapBySAPOrderNo(
			@Param("odsInfoWms") OdsOrderInfoDTO odsInfoWms);

	/*
	 * add by linzx@20151211 根据SAP凭证单号进行更新
	 */
	public void updateSapByOrderNo(
			@Param("odsInfoWms") OdsOrderInfoDTO odsInfoWms);

	/*
	 * add by linzx 220151222 根据DN单号查询ods_order_info 中的数量，大于0表明已经通过RF汇总过。
	 */
	public long getByDn(@Param("dnNo") String dnNo);

	/*
	 * add by linzx @20151222 根据order_no查询对应的DN单号
	 */
	public String getDnByOrderNo(@Param("orderNo") String orderNo);

	/*
	 * add by linzx @20151223 根据order_no跟新SAPFLAG的状态
	 */
	public void updateSAPFlagByOrderNo(@Param("orderNo") String orderNo);

	public void updateDocNoOfDN(@Param("orderNo") String orderNo,
			@Param("docNO") String docNO);

	/**
     *
     */
	public List<OdsOrderInfoDTO> getOrdersByNo(
			@Param("orderNo") String orderNo,
			@Param("orderType") String orderType,
			@Param("docTpye") String docTpye);

	/**
	 *
	 * @Title: updateSapBackMsgOfDn
	 * @Description: dn pc 端过账 更细sap信息
	 * @param @param orderInfo
	 * @return void
	 * @throws
	 */
	public void updateSapBackMsgOfDn(
			@Param("orderInfo") OdsOrderInfoDTO orderInfo);

	public void updateOrderLocation(OdsOrderInfoDTO odsInfoDto);

	public String iogpCancel(@Param("in") WmsOrderIgpIn in,
			@Param("out") WmsOrderIgpOut out);

	public long searchOIGPOrderInfoCount(
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);

	public List<OdsOrderInfoDTO> searchOIGPOrderInfo(
			@Param("pager") Pager<OdsOrderInfoDTO> pager,
			@Param("odsOrderInfo") OdsOrderInfoDTO odsOrderInfo);

	// 删除ods_order_info中已经汇总的信息
	public void deleteOrderBySapOrderNo(@Param("sapOrderNo") String transOrderNo);
}

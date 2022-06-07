package com.haier.hevwms.order.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.order.domain.OdsOrderInfo;
import com.haier.hevwms.order.service.OdsOrderInfoService;
import com.haier.hevwms.po.dao.OdsOrderInfoDtlDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderIgpDAO;
import com.haier.hevwms.remoting.rf.domain.Returnentity;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.sto.dao.StgStodnDownDAO;
import com.haier.hevwms.sto.dao.StgStoDownDAO;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.HOPException;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;

public class OdsOrderInfoServiceImpl implements OdsOrderInfoService {
	Logger logger = Logger.getLogger(OdsOrderInfoServiceImpl.class);
	private OdsOrderInfoDAO odsOrderInfoDAO;
	private StgStoDownDAO stgStoDownDAO;
	private OtcwmsOrderIgpDAO otcwmsOrderIgpDAO;
	private OdsOrderInfoDtlDAO odsOrderInfoDtlDAO;
	private StgStodnDownDAO StgStodnDownDAO;

	@Override
	public void saveOdsInfoDtls(String msg) {
		try {
			String[] msgs = msg.split(",");
			// 解释字符串
			String orderNo = msgs[0];
			String stoDnNo = msgs[1];
			String carNo = msgs[2];

			Map<String, StgStodnDownDTO> stoMap = new HashMap<String, StgStodnDownDTO>();
			StgStodnDownDTO temp = new StgStodnDownDTO();
			temp.setStodnNo(stoDnNo);
			List<StgStodnDownDTO> stoList = StgStodnDownDAO.getListByParam(temp);
			for (StgStodnDownDTO stgStoDown : stoList) {
				stoMap.put(stgStoDown.getMaterialNo(), stgStoDown);
			}
			OdsOrderInfoDtlDTO tempOrder = new OdsOrderInfoDtlDTO();
			tempOrder.setOrderNo(orderNo);
			List<OdsOrderInfoDtlDTO> orderList = odsOrderInfoDtlDAO
					.getListByParam(tempOrder);

			if (orderList.size() > 0) {
				// 生成出库明细
				// 生成出库明细
				for (OdsOrderInfoDtlDTO dtl : orderList) {
					OdsOrderInfoDtlDTO ogp = new OdsOrderInfoDtlDTO();
					ogp.setBarcode(dtl.getBarcode());
					ogp.setCarNo(carNo);
					ogp.setCreateBy(dtl.getCreateBy());
					ogp.setCreateDate(new Date());
					ogp.setCustomerModel(dtl.getCustomerModel());
					ogp.setDeliveryCode(dtl.getDeliveryCode());
					ogp.setDeliveryDate(dtl.getDeliveryDate());
					ogp.setDeliveryName(dtl.getDeliveryName());
					ogp.setLocation(dtl.getLocation());
					ogp.setMaterialDesp(dtl.getMaterialDesp());
					ogp.setMaterialNo(dtl.getMaterialNo());
					ogp.setPlant(dtl.getPlant());
					ogp.setQty(dtl.getQty());
					ogp.setOrderType("2");
					StgStodnDownDTO sto = stoMap.get(dtl.getMaterialNo());
					ogp.setPoItemNo(sto.getStodnItemNo());
					ogp.setPoNo(sto.getStodnNo());
					ogp.setScannedBy(dtl.getScannedBy());
					ogp.setScannedDate(dtl.getScannedDate());
					ogp.setUnit(dtl.getUnit());
					ogp.setVendorCode(dtl.getVendorCode());
					ogp.setVendorName(dtl.getVendorName());
					ogp.setFinishFlag("0");
					ogp.setInOutFlag("0");
					ogp.setUsedFlag("1");
					odsOrderInfoDtlDAO.save(ogp);
				}
				// 出库成功 更新 发货数量 和 状态
				StgStodnDownDAO.updateFinishQty(stoDnNo);
			}

		} catch (Exception e) {
			throw new HOPException("exception" + OdsOrderInfoServiceImpl.class,
					e);
		}
	}

	@Override
	public ExecuteResult<OdsOrderInfoDTO> savePreScan(String msg,
			String postingDate) {
		ExecuteResult<OdsOrderInfoDTO> executeResult = new ExecuteResult<OdsOrderInfoDTO>();
		OdsOrderInfoDTO orderInfo = new OdsOrderInfoDTO();
		String[] msgs = msg.split(",");
		// 解释字符串
		String orderNo = msgs[0];
		String stoDnNo = msgs[1];
		String carNo = msgs[2];
		OdsOrderInfoDtlDTO tempOrder = new OdsOrderInfoDtlDTO();
		tempOrder.setOrderNo(orderNo);
		List<OdsOrderInfoDtlDTO> orderList = odsOrderInfoDtlDAO
				.getListByParam(tempOrder);

		// 调用存储过程 生成单据明细
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		OdsOrderInfoDtlDTO dtl = orderList.get(0);
		in.setCarNo(carNo);
		in.setDocType("STO");
		in.setLocation(dtl.getLocation());
		in.setOrderType("2");
		in.setOrno(stoDnNo);
		in.setSign(null);
		in.setPostingdate(postingDate);
		in.setUser(dtl.getCreateBy());
		WmsOrderIgpOut out = new WmsOrderIgpOut();
		otcwmsOrderIgpDAO.orderOgp(in, out);
		if ("0".equals(out.getStatus())) {
			// 更新 sto 的 收货扫描状态
			StgStodnDownDAO.updatePrescanByStoNo(stoDnNo);
			// 更新 order 的预扫描标记
			odsOrderInfoDAO.updatePrescanByOrderNo(orderNo);
			// 单据过账 暂取消此步骤 孙艳飞 2015-11-24 stodndowndetail prescan
			// OtcTransStogrOrderFromWMSToSAP sap = new
			// OtcTransStogrOrderFromWMSToSAP(
			// out.getOrId(), dtl.getCreateBy());
			// String str = sap.exchangeWithSap();
			// orderInfo.setSapReturn(str);
			// if ("S".equals(str)) {
			// in = new OtcwmsOrderIgpIn();
			// in.setOrno(out.getOrId());
			// in.setUser(dtl.getCreateBy());
			// in.setDoctype("STO");
			// returnentity ret = new returnentity();
			// otcwmsOrderIgpDAO.orderMakeStorageOut(in, ret);
			//
			// }
		}
		if (out.getStatus() != null) {
			orderInfo.setStatus(out.getStatus());
		}
		if (out.getMsg() != null) {
			orderInfo.setMsg(out.getMsg());
		}
		if (out.getOrId() != null) {
			orderInfo.setOrId(out.getOrId());
		}
		executeResult.setResult(orderInfo);
		return executeResult;
	}

	@Override
	public String createOdsOrderInfo(OdsOrderInfoDTO odsOrderInfo) {
		// ExecuteResult<OdsOrderInfoDTO> executeResult = new
		// ExecuteResult<OdsOrderInfoDTO>();

		odsOrderInfoDAO.save(odsOrderInfo);
		// executeResult.setResult(odsOrderInfo);
		return "";
	}

	public ExecuteResult<OdsOrderInfoDTO> updateOdsOrderInfo(
			OdsOrderInfoDTO odsOrderInfo) {
		ExecuteResult<OdsOrderInfoDTO> executeResult = new ExecuteResult<OdsOrderInfoDTO>();

		odsOrderInfoDAO.update(odsOrderInfo);
		executeResult.setResult(odsOrderInfo);
		return executeResult;
	}

	public ExecuteResult<OdsOrderInfoDTO> deleteOdsOrderInfo(
			Long odsOrderInfoId) {
		ExecuteResult<OdsOrderInfoDTO> executeResult = new ExecuteResult<OdsOrderInfoDTO>();

		odsOrderInfoDAO.delete(odsOrderInfoId);
		return executeResult;
	}

	public ExecuteResult<OdsOrderInfoDTO> deleteOdsOrderInfoAll(
			List<Long> idList) {
		ExecuteResult<OdsOrderInfoDTO> executeResult = new ExecuteResult<OdsOrderInfoDTO>();

		odsOrderInfoDAO.deleteAll(idList);
		return executeResult;
	}

	// 此处已开始测试
	public Pager<OdsOrderInfoDTO> searchOdsOrderInfos(
			Pager<OdsOrderInfoDTO> pager, OdsOrderInfoDTO odsOrderInfo) {
		List<OdsOrderInfoDTO> odsOrderInfos = odsOrderInfoDAO
				.searchOdsOrderInfos(pager, odsOrderInfo);
		long size = odsOrderInfoDAO.searchOdsOrderInfosCount(odsOrderInfo);
		return Pager.cloneFromPager(pager, size, odsOrderInfos);
	}

	@Override
	public Pager<OdsOrderInfoDTO> searchOrderNos(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo) {
		List<OdsOrderInfoDTO> odsOrderInfos = odsOrderInfoDAO
				.searchOrderNos(pager, odsOrderInfo);
		long size = odsOrderInfoDAO.searchOrderNosCount(odsOrderInfo);
		return Pager.cloneFromPager(pager, size, odsOrderInfos);
	}
	@Override
	public Pager<OdsOrderInfoDTO> searchStoDNDetail(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo) {
		List<OdsOrderInfoDTO> odsOrderInfos = odsOrderInfoDAO
				.searchStoDNDetail(pager, odsOrderInfo);
		long size = odsOrderInfoDAO.searchStoDNDetailCount(odsOrderInfo);
		return Pager.cloneFromPager(pager, size, odsOrderInfos);
	}
	
	
	@Override
	public Pager<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNo(Pager<OdsOrderInfoDtlDTO> pager,
			OdsOrderInfoDtlDTO odsOrderInfoDtl) {
		List<OdsOrderInfoDtlDTO> odsOrderInfoDtls = odsOrderInfoDtlDAO.searchOgpDetailsByStodnNo(pager, odsOrderInfoDtl);
		long size = odsOrderInfoDtlDAO.searchOgpDetailsByStodnNoCount(odsOrderInfoDtl);
		return Pager.cloneFromPager(pager, size, odsOrderInfoDtls);
	}
	
	@Override
	public List<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNoList(OdsOrderInfoDtlDTO odsOrderInfoDtl) {
		List<OdsOrderInfoDtlDTO> odsOrderInfoDtls = odsOrderInfoDtlDAO.searchOgpDetailsByStodnNo(null,odsOrderInfoDtl);
		
		return odsOrderInfoDtls;
	}

	@Override
	public OdsOrderInfoDTO getOdsOrderInfoById(Long odsOrderInfoId) {
		return odsOrderInfoDAO.get(odsOrderInfoId);
	}

	@Override
	public List<OdsOrderInfoDTO> getOdsOrderInfos(
			OdsOrderInfoDTO odsOrderInfo) {
		List<OdsOrderInfoDTO> orderList = null;
		try {
			Map<String, StgStoDownDTO> stoMap = new HashMap<String, StgStoDownDTO>();
			StgStoDownDTO temp = new StgStoDownDTO();
			temp.setStoNo(odsOrderInfo.getSapOrderNo());
			List<StgStoDownDTO> stoList = stgStoDownDAO.getListByParam(temp);
			for (StgStoDownDTO stgStoDown : stoList) {
				stoMap.put(stgStoDown.getMaterialNo() + stgStoDown.getQty(),
						stgStoDown);
			}
			OdsOrderInfoDTO tempOrder = new OdsOrderInfoDTO();
			tempOrder.setOrderNo(odsOrderInfo.getOrderNo());
			orderList = odsOrderInfoDAO.getAllByName(tempOrder);
			boolean flag = true;
			if (stoList.size() != orderList.size()) {
				flag = false;
			}
			for (OdsOrderInfoDTO order : orderList) {
				if (stoMap.get(order.getMaterialNo()
						+ order.getScannedQty()) == null) {
					order.setSuccessFlag(true);
					flag = false;
				} else {
					order.setSuccessFlag(false);
				}
				order.setSuccessFlag(flag);
			}
			return orderList;
		} catch (Exception e) {
			throw new HOPException("exception" + OdsOrderInfoServiceImpl.class,
					e);
		}
	}


	@Override
	public void deleteOdsOrderInfoDtlByNo(String msg) {
		String[] msgs = msg.split(",");
		// 解释字符串
		String stoNo = msgs[1];
		odsOrderInfoDtlDAO.deleteOdsOrderInfoDtlByNo(stoNo);
	}

	public List<OdsOrderInfoDTO> getListByParam(OdsOrderInfo odsOrderInfo) {
		OdsOrderInfoDTO odsOrderInfoDto = new OdsOrderInfoDTO();
		try {
			BeanUtilEx.copyProperties(odsOrderInfoDto, odsOrderInfo);
		} catch (InvocationTargetException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
		return odsOrderInfoDAO.getListByParam(odsOrderInfoDto);
	}


	@Override
	public List<OdsOrderInfoDTO> getListByName(OdsOrderInfoDTO odsOrderInfo) {
		return odsOrderInfoDAO.getAllByName(odsOrderInfo);
	}

	@Override
	public ExecuteResult<OdsOrderInfoDTO> saveInOrder(
			OdsOrderInfoDTO odsOrderInfo) {
		ExecuteResult<OdsOrderInfoDTO> executeResult = new ExecuteResult<OdsOrderInfoDTO>();
		odsOrderInfo.setOrderItem("1");
		// odsOrderInfo.setOrderType("1");
		odsOrderInfo.setDocTpye("GIFT");
		odsOrderInfo.setSapOrderNo(odsOrderInfo.getOrderNo());
		odsOrderInfo.setSapOrderItem("1");
		odsOrderInfo.setHandFlag("1");
		odsOrderInfo.setInOutFlag("0");
		odsOrderInfo.setCheckFlag("1");
		// gongchang
		odsOrderInfoDAO.save(odsOrderInfo);
		executeResult.setResult(odsOrderInfo);
		return executeResult;
	}

	@Override
	public ExecuteResult<OdsOrderInfoDTO> deltGfOrder(
			OdsOrderInfoDTO odsOrderInfo) {
		ExecuteResult<OdsOrderInfoDTO> executeResult = new ExecuteResult<OdsOrderInfoDTO>();

		return executeResult;
	}

	@Override
	public List<OdsOrderInfoDTO> findCarList(OdsOrderInfoDTO odsOrderInfo) {
		List<OdsOrderInfoDTO> templist = new ArrayList<OdsOrderInfoDTO>();

		return templist;
	}

	@Override
	public String postOrder(String orderNo, String userName) {
		return null;
	}

	@Override
	public String createOrderNo(String inOut) {
		Long no = odsOrderInfoDAO.createOrderNo();
		// 生成10位长度的订单号
		String orderNo = "000000000" + no.toString();
		return inOut
				+ orderNo.substring(orderNo.length() - 9, orderNo.length());
	}

	@Override
	public void saveOdsInfoDtlsByInvetory(String msg, String orderNo) {

	}

	@Override
	public void updateFinishQty(String stoNo) {
		String[] msgs = stoNo.split(",");
		// 解释字符串
		String stoNoT = msgs[1];
		StgStodnDownDAO.cleanFinishQty(stoNoT);
	}

	@Override
	public String inOutWarehouse(String orderNo, String orderType, String userName) {
		return null;
	}
	
	/**
	 * iogp取消
	 * SJK
	 */
	@Override
	public WmsOrderIgpOut iogpCancel(OdsOrderInfoDTO odsOrderInfo) {
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		WmsOrderIgpOut out = new WmsOrderIgpOut();
		in.setOrno(odsOrderInfo.getSapOrderNo());
		in.setOrderType(odsOrderInfo.getOrderType());
		in.setUser(odsOrderInfo.getCreateBy());
		odsOrderInfoDAO.iogpCancel(in, out);
		return out;
	}
	
	public OdsOrderInfoDAO getOdsOrderInfoDAO() {
		return odsOrderInfoDAO;
	}

	public void setOdsOrderInfoDAO(OdsOrderInfoDAO odsOrderInfoDAO) {
		this.odsOrderInfoDAO = odsOrderInfoDAO;
	}

	public StgStoDownDAO getStgStoDownDAO() {
		return stgStoDownDAO;
	}

	public void setStgStoDownDAO(StgStoDownDAO stgStoDownDAO) {
		this.stgStoDownDAO = stgStoDownDAO;
	}

	public OtcwmsOrderIgpDAO getOtcwmsOrderIgpDAO() {
		return otcwmsOrderIgpDAO;
	}

	public void setOtcwmsOrderIgpDAO(OtcwmsOrderIgpDAO otcwmsOrderIgpDAO) {
		this.otcwmsOrderIgpDAO = otcwmsOrderIgpDAO;
	}

	public OdsOrderInfoDtlDAO getOdsOrderInfoDtlDAO() {
		return odsOrderInfoDtlDAO;
	}

	public void setOdsOrderInfoDtlDAO(OdsOrderInfoDtlDAO odsOrderInfoDtlDAO) {
		this.odsOrderInfoDtlDAO = odsOrderInfoDtlDAO;
	}

	public StgStodnDownDAO getStgStodnDownDAO() {
		return StgStodnDownDAO;
	}

	public void setStgStodnDownDAO(StgStodnDownDAO StgStodnDownDAO) {
		this.StgStodnDownDAO = StgStodnDownDAO;
	}

	@Override
	public String postOrderPlus(String orderNo, String userName) throws Exception {
		logger.debug("Entering postOrderPlus, orderNo = " + orderNo+ ", userName = " + userName);
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		Returnentity ret = new Returnentity();
		String sap = null;
		OdsOrderInfoDTO odsOrderInfo = new OdsOrderInfoDTO();
		odsOrderInfo.setOrderNo(orderNo);
		 
		List<OdsOrderInfoDTO> odsList = odsOrderInfoDAO.getListByParam(odsOrderInfo);
//		String docType = "";
//		String sapOrderNo = "";
//		String orderType="";
		if (odsList.size() > 0) {
			OdsOrderInfoDTO temp  = odsList.get(0);
//			docType = temp.getDocTpye();
//			sapOrderNo = temp.getSapOrderNo();
//			orderType = temp.getOrderType();
			if ("1".equals(temp.getSapFlag())) {
				in.setDocType(temp.getDocTpye());
				in.setOrno(orderNo);
				in.setUser(userName);
				if ("1".equals(temp.getOrderType())) {
					in.setOrderType("1");
					otcwmsOrderIgpDAO.orderMakeStorageIn(in, ret);
				} else if ("2".equals(temp.getOrderType())) {
					in.setOrderType("2");
					otcwmsOrderIgpDAO.orderMakeStorageOut(in, ret);
				}
			}
		}
		if ("0".equals(ret.getStatus())) {
			logger.debug("Exit postOrder with result Success...");
			// dn 出库扫描完成 传入sap 完成时间
			 
			return "S";
		} else {
			logger.debug("Exit postOrder with result msg: " + ret.getMsg());
			return "E," + ret.getMsg();
		}
	}

	@Override
	public Pager<OdsOrderInfoDTO> searchOIGPOrderInfo(
			Pager<OdsOrderInfoDTO> pager, OdsOrderInfoDTO odsOrderInfo) {
		List<OdsOrderInfoDTO> odsOrderInfos = odsOrderInfoDAO
				.searchOIGPOrderInfo(pager, odsOrderInfo);
		long size = odsOrderInfoDAO.searchOIGPOrderInfoCount(odsOrderInfo);
		return Pager.cloneFromPager(pager, size, odsOrderInfos);
	}
	
	public Long getExportAmount(OdsOrderInfoDTO odsOrderInfo) {
		return odsOrderInfoDAO.searchOdsOrderInfosCount(odsOrderInfo);
	}
}

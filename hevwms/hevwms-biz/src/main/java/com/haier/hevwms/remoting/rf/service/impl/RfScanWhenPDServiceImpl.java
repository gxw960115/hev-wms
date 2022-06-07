package com.haier.hevwms.remoting.rf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDelDetialDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.StgInoutBarcodeWhenPDDTO;
import com.haier.openplatform.wms.remoting.dto.StgOrdersWhenPDDTO;
import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderCheckDAO;
import com.haier.hevwms.remoting.rf.dao.ScanAndIOGPWhenPD;
import com.haier.hevwms.remoting.rf.dao.StgInoutBarcodeWhenPDDAO;
import com.haier.hevwms.remoting.rf.dao.StgOrdersWhenPDDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckIn;
import com.haier.hevwms.remoting.rf.service.RfScanWhenPDService;

/**
 * * @author 作者 :sunyanfei
 * 
 * @date 创建时间：2016-3-25 上午11:11:36
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class RfScanWhenPDServiceImpl implements RfScanWhenPDService {
	private StgInoutBarcodeWhenPDDAO stgInoutBarcodeWhenPDDAO;
	private StgOrdersWhenPDDAO stgOrdersWhenPDDAO;
	private OdsOrderInfoDAO orderInfoDAO;
	private ScanAndIOGPWhenPD scanAndIOGPWhenPD;
	private OdsInventoryInfoDtlDAO inventoryInfoDtlDAO;
	private OdsBarcodeHistoryDAO barcodeHistoryDAO;
	private OtcwmsOrderCheckDAO otcwmsOrderCheckDAO;

	@Override
	public OrderIgpOutDTO orderCkeck(OrderCheckInDTO in) {
		OrderIgpOutDTO result = new OrderIgpOutDTO();
		WmsOrderCheckIn otcwmsOrderCheckIn = new WmsOrderCheckIn();
		otcwmsOrderCheckIn.setOrno(in.getOrno());
		otcwmsOrderCheckIn.setDoctype(in.getDoctype());
		String ret = otcwmsOrderCheckDAO.orderCheck(otcwmsOrderCheckIn);
		if ("Y".equals(ret)) { // STO inbound Y订单存在
			result.setStatus("S");
		} else if ("N".equals(ret)) {
			result.setStatus("F");
			result.setMsg("This order is not existed,please download at portal");
			return result;
		} else {
			if ("1".equals(in.getOrdertype())) {
				if ("R".equals(ret) || "SRN".equals(ret)
						|| "ConPickUp".equals(ret)) {// po_type不是ZRE，DN是ZRE,ZKA,返回R
					result.setStatus("S");
				} else {
					result.setStatus("F");
					result.setMsg("This order is GI,Plase [" + in.getDoctype()
							+ " Dispatch]");
					return result;
				}
			} else if ("2".equals(in.getOrdertype())) {
				if ("C".equals(ret) || "Billing".equals(ret)
						|| "ConIssue".equals(ret)) {// po是ZRE，dn不是ZRE，ZKA 返回C
					result.setStatus("S");
				} else {
					result.setStatus("F");
					result.setMsg("This order is GR,Plase [" + in.getDoctype()
							+ " Receipt]");
					return result;
				}
			}
		}
		Long size = orderExist(in.getOrno(), in.getOrdertype(), in.getDoctype());
		if (size > 0) {
			List<String> list = stgOrdersWhenPDDAO.getOrdersLocation(
					in.getOrno(), in.getOrdertype(), in.getDoctype());
			StringBuffer locs = new StringBuffer();
			for (int i = 0; i < list.size() - 1; i++) {
				locs.append(list.get(i) + ",");
			}
			locs.append(list.get(list.size() - 1));
			result.setStatus("S");
			result.setMsg(locs.toString());
			return result;
		} else {
			result.setStatus("F");
			result.setMsg("Please Click DownLoad First!");
			return result;
		}
	}

	@Override
	public OrderIgpOutDTO orderDownLoad(OrderCheckInDTO in) {
		OrderIgpOutDTO result = new OrderIgpOutDTO();
		List<OdsOrderInfoDTO> orders = orderInfoDAO.getOrdersByNo(in.getOrno(),
				in.getOrdertype(), in.getDoctype());
		if (orders.size() < 1) {
			result.setStatus("F");
			result.setMsg("this order is not existed or it has begun scanning,please check at portal -> GR&GI");
			return result;
		}
		List<StgOrdersWhenPDDTO> list = stgOrdersWhenPDDAO.getOrders(
				in.getOrno(), in.getOrdertype(), in.getDoctype());
		for (OdsOrderInfoDTO info : orders) {
			boolean flag = true;
			for (int i = 0; i < list.size(); i++) {
				StgOrdersWhenPDDTO stgOrdersWhenPDDTO = list.get(i);
				if (stgOrdersWhenPDDTO.getOrderNo()
						.equals(info.getSapOrderNo())
						&& stgOrdersWhenPDDTO.getOrderItem().equals(
								info.getSapOrderItem())) {
					if (stgOrdersWhenPDDTO.getQty().longValue() != info
							.getRequireQty().longValue()) {
						stgOrdersWhenPDDTO.setQty(info.getRequireQty());
						stgOrdersWhenPDDTO.setModifyBy(in.getUser());
						stgOrdersWhenPDDTO.setModifyDate(new Date());
						stgOrdersWhenPDDAO.update(stgOrdersWhenPDDTO);
					}
					list.remove(i);
					flag = false;
					break;
				}
			}
			if (flag) {
				StgOrdersWhenPDDTO dto = new StgOrdersWhenPDDTO();
				dto.setDocTpye(in.getDoctype());
				dto.setOrderType(in.getOrdertype());
				dto.setOrderNo(info.getSapOrderNo());
				dto.setOrderItem(info.getSapOrderItem());
				dto.setMaterialNo(info.getMaterialNo());
				dto.setPlant(info.getPlant());
				dto.setLocaton(info.getLocation());
				dto.setQty(info.getRequireQty());
				dto.setCreateBy(in.getUser());
				dto.setCreateDate(new Date());
				dto.setUnit(info.getUnit());
				stgOrdersWhenPDDAO.save(dto);
			}
		}
		result.setStatus("S");
		result.setMsg("Success!");
		return result;
	}

	@Override
	public OrderUploadOutDTO orderScan(OrderUploadInDTO in) {
		OrderUploadOutDTO out = new OrderUploadOutDTO();
		if (CommonTool.isNull(in.getQty()) || "0".equals(in.getQty())) {
			in.setQty("0");
		}
		// 如果条码数量 大于20 报错
		if (!CommonTool.isNull(in.getBarcode())) {
			if (!"PD".equals(in.getDoctype()) && in.getBarcode().length() > 20
					|| in.getBarcode().length() < 10) {
				out.setStatus("F");
				out.setMsg("The barcode does not conform to the rules!");
				return out;
			}
		}
		scanAndIOGPWhenPD.orderScan(in, out);
		return out;
	}

	@Override
	public Map<String, String> offlineScan(List<OrderUploadInDTO> paramsIn) {
		Map<String, String> result = new HashMap<String, String>();
		for (OrderUploadInDTO otcwmsOrderUploadInDTO : paramsIn) {
			OrderUploadOutDTO out = orderScan(otcwmsOrderUploadInDTO);
			if (!"0".equals(out.getStatus())) {
				result.put(otcwmsOrderUploadInDTO.getBarcode(), out.getStatus()
						+ "&&" + out.getMsg());
			}
		}
		return result;
	}

	@Override
	public OrderUploadOutDTO orderDelete(OrderUploadInDTO in) {
		OrderUploadOutDTO out = new OrderUploadOutDTO();
		scanAndIOGPWhenPD.orderDelete(in, out);
		return out;
	}

	@Override
	public WmsOrderDelListOutDTO barcodeDetail(OrderUploadInDTO in) {
		List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
		List<StgInoutBarcodeWhenPDDTO> list = stgInoutBarcodeWhenPDDAO
				.getByOrderNoAndType(in.getOrno(), in.getOrdertype());
		for (StgInoutBarcodeWhenPDDTO stgInoutBarcodeWhenPDDTO : list) {
			OrderDelDetialDTO dto = new OrderDelDetialDTO();
			dto.setBarcode(stgInoutBarcodeWhenPDDTO.getBarcode());
			dto.setSapOrderNo(stgInoutBarcodeWhenPDDTO.getOrderNo());
			dto.setQty(stgInoutBarcodeWhenPDDTO.getScanQty().toString());
			dto.setRowId(stgInoutBarcodeWhenPDDTO.getId().toString());
			dto.setLocation(stgInoutBarcodeWhenPDDTO.getLocation());
			detial.add(dto);
		}
		WmsOrderDelListOutDTO delListOutDTO = new WmsOrderDelListOutDTO();
		delListOutDTO.setDetial(detial);
		delListOutDTO.setTotal(list.size() + "");
		return delListOutDTO;
	}

	@Override
	public OrderUploadOutDTO orderIogp(OrderUploadInDTO in) {
		DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) SpringApplicationContextHolder
				.getBean("transactionManager");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		OrderUploadOutDTO dto = new OrderUploadOutDTO();
		Long size = orderExist(in.getOrno(), in.getOrdertype(), in.getDoctype());
		if (size <= 0) {
			dto.setStatus("F");
			dto.setMsg("This Order is not existed,please ckeck");
			return dto;
		}
		try {
			// 查询未完成订单
			if (!"PO".equals(in.getDoctype())) {
				Long count = stgOrdersWhenPDDAO.getOrderCountNotFinish(in);// 查询未完成扫描或已经完成汇总的
				if (count > 0) {
					dto.setStatus("F");
					dto.setMsg("This Order is not finished or has done I/OGP complete");
					return dto;
				}
			}
			List<StgInoutBarcodeWhenPDDTO> list = stgInoutBarcodeWhenPDDAO
					.getByOrderNoAndType(in.getOrno(), in.getOrdertype());
			dto.setMsg("");
			for (StgInoutBarcodeWhenPDDTO stgInoutBarcodeWhenPDDTO : list) {
				OdsInventoryInfoDtl dtl = new OdsInventoryInfoDtl();
				// if ("1".equals(in.getOrdertype())) {// 入库插入WMS库存
				dtl.setBarcode(stgInoutBarcodeWhenPDDTO.getBarcode());
				dtl.setUnit(stgInoutBarcodeWhenPDDTO.getUnit());
				dtl.setLocation(stgInoutBarcodeWhenPDDTO.getLocation());
				dtl.setPlant(stgInoutBarcodeWhenPDDTO.getPlant());
				dtl.setMaterialNo(stgInoutBarcodeWhenPDDTO.getMaterialNo());
				dtl.setCreateBy(in.getUser());
				dtl.setDocTpye(stgInoutBarcodeWhenPDDTO.getDocTpye());
				dtl.setSapOrderNo(stgInoutBarcodeWhenPDDTO.getOrderNo());
				dtl.setSapOrderItem(stgInoutBarcodeWhenPDDTO.getOrderItem());
				dtl.setQty(stgInoutBarcodeWhenPDDTO.getScanQty());
				dtl.setUserType(in.getOrdertype());// 插入条码历史用的，入库标记，用这个属性顶一下-_-
				// inventoryInfoDtlDAO.receiptWhenPD(dtl);
				// } else if ("2".equals(in.getOrdertype())) {// 出库
				// dtl = inventoryInfoDtlDAO
				// .getByBarcode(stgInoutBarcodeWhenPDDTO.getBarcode());
				// if (dtl.getQty() > stgInoutBarcodeWhenPDDTO.getScanQty()) {//
				// 冲减库存
				// inventoryInfoDtlDAO.updateQty(dtl.getRowId(),
				// stgInoutBarcodeWhenPDDTO.getBarcode(),
				// stgInoutBarcodeWhenPDDTO.getScanQty());
				// } else if (dtl.getQty() == stgInoutBarcodeWhenPDDTO
				// .getScanQty()) {// 相等时删除库存
				// inventoryInfoDtlDAO.delete(dtl.getRowId());
				// }
				// dtl.setUserType("2");// 插入条码历史用的，chu库标记，用这个属性顶一下-_-
				// } else {// 传入出入库标记有问题
				// try {
				// throw new Exception();
				// } catch (Exception e) {
				// dto.setStatus("F");
				// dto.setMsg("");
				// }
				//
				// }
				dtl.setQty(stgInoutBarcodeWhenPDDTO.getScanQty());
				dtl.setCreateBy(in.getUser());
				// 出入的条码都要出入条码历史ODS_BARCODE_HISTORY
				barcodeHistoryDAO.saveBarcodeHistoryWhenPD(dtl);
			}
			dto.setStatus("S");
		} catch (Exception e) {
			dto.setStatus("F");
			dto.setMsg("I/OGP exception please Contact your administrator,order NO is:"
					+ in.getOrno());
			try {
				throw new RuntimeException();
			} catch (RuntimeException e1) {
				e1.printStackTrace();
				transactionManager.rollback(status);// 有一个失败就回滚
			}
		}
		stgOrdersWhenPDDAO.updateInoutFlag(in);
		stgInoutBarcodeWhenPDDAO.updateInoutFlag(in);
		// 全部成功后统一commit
		transactionManager.commit(status);
		return dto;
	}

	public Long orderExist(String orderNo, String orderType, String docType) {
		return stgOrdersWhenPDDAO.searchOrderCount(orderNo, orderType, docType);
	}

	public StgInoutBarcodeWhenPDDAO getStgInoutBarcodeWhenPDDAO() {
		return stgInoutBarcodeWhenPDDAO;
	}

	public void setStgInoutBarcodeWhenPDDAO(
			StgInoutBarcodeWhenPDDAO stgInoutBarcodeWhenPDDAO) {
		this.stgInoutBarcodeWhenPDDAO = stgInoutBarcodeWhenPDDAO;
	}

	public StgOrdersWhenPDDAO getStgOrdersWhenPDDAO() {
		return stgOrdersWhenPDDAO;
	}

	public void setStgOrdersWhenPDDAO(StgOrdersWhenPDDAO stgOrdersWhenPDDAO) {
		this.stgOrdersWhenPDDAO = stgOrdersWhenPDDAO;
	}

	public OdsOrderInfoDAO getOrderInfoDAO() {
		return orderInfoDAO;
	}

	public void setOrderInfoDAO(OdsOrderInfoDAO orderInfoDAO) {
		this.orderInfoDAO = orderInfoDAO;
	}

	public void setScanAndIOGPWhenPD(ScanAndIOGPWhenPD scanAndIOGPWhenPD) {
		this.scanAndIOGPWhenPD = scanAndIOGPWhenPD;
	}

	public OdsInventoryInfoDtlDAO getInventoryInfoDtlDAO() {
		return inventoryInfoDtlDAO;
	}

	public void setInventoryInfoDtlDAO(
			OdsInventoryInfoDtlDAO inventoryInfoDtlDAO) {
		this.inventoryInfoDtlDAO = inventoryInfoDtlDAO;
	}

	public ScanAndIOGPWhenPD getScanAndIOGPWhenPD() {
		return scanAndIOGPWhenPD;
	}

	public OdsBarcodeHistoryDAO getBarcodeHistoryDAO() {
		return barcodeHistoryDAO;
	}

	public void setBarcodeHistoryDAO(OdsBarcodeHistoryDAO barcodeHistoryDAO) {
		this.barcodeHistoryDAO = barcodeHistoryDAO;
	}

	public OtcwmsOrderCheckDAO getOtcwmsOrderCheckDAO() {
		return otcwmsOrderCheckDAO;
	}

	public void setOtcwmsOrderCheckDAO(OtcwmsOrderCheckDAO otcwmsOrderCheckDAO) {
		this.otcwmsOrderCheckDAO = otcwmsOrderCheckDAO;
	}

}

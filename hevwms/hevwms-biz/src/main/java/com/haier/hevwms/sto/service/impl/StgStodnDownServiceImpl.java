package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.sapinterface.DownloadStodnFromSap;
import com.haier.hevwms.sapinterface.PostStoDnToTMS;
import com.haier.hevwms.sto.dao.StgStodnDownDAO;
import com.haier.hevwms.sto.service.StgStodnDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGiGrDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * @Company 青鸟软通
 * @Title: StgStodnDownServiceImpl
 * @Package com.haier.hevwms.order.service.impl
 * @author 孙艳飞
 * @date 2015-11-24
 * @version
 */

public class StgStodnDownServiceImpl implements StgStodnDownService {
	
	private Logger logger = Logger.getLogger(StgStodnDownServiceImpl.class);
	/** 依赖注入的stgStodnDownDAO */

	private StgStodnDownDAO stgStodnDownDAO;

	/**
	 * 
	 * @Title: searchStgStodnDowns
	 * @Description: (查询stgstodndown分页)
	 * @param @param pager
	 * @param @param dto
	 * @param @return
	 * @return Pager<StgStodnDownDTO>
	 * @throws
	 */

	@Override
	public Pager<StgStodnDownDTO> searchStgStodnDowns(
			Pager<StgStodnDownDTO> pager, StgStodnDownDTO dto) {
		List<StgStodnDownDTO> odsOrderInfos = stgStodnDownDAO
				.searchStgStodnDowns(pager, dto);
		long size = stgStodnDownDAO.searchStgStodnDownsCount(dto);
		return Pager.cloneFromPager(pager, size, odsOrderInfos);
	}

	/**
	 * 
	 * @Title: getStgStodnDowns
	 * @Description: (查询stgstodndown列表)
	 * @param @param dto
	 * @param dto
	 * @return List<StgStodnDownDTO>
	 * @throws
	 */

	@Override
	public List<StgStodnDownDTO> getStgStodnDownListByParm(StgStodnDownDTO dto) {
		return stgStodnDownDAO.getStgStodnDownListByParm(dto);
	}

	/**
	 * 说明 此为stodnDetail过账 暂不使用
	 * <p>
	 * Title: postStnDn
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param stoDnNo
	 * @param userName
	 * @return
	 * @see com.haier.hevwms.order.service(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String postStnDn(String stoDnNo, String userName) {
		// OtcwmsOrderIgpIn in = new OtcwmsOrderIgpIn();
		// returnentity ret = new returnentity();
		// String sap = null;
		// StgStodnDownDTO dto = new StgStodnDownDTO();
		// dto.setStoDnNo(stoDnNo);
		// //odsOrderInfo.setSapFlag("-1");
		// List<StgStodnDownDTO> odsList = stgStodnDownDAO
		// .getListByParam(dto);
		// //更新状态 把 单号下 不为1的 更新成2
		//
		// if (odsList.size() > 0) {
		// StgStodnDownDTO temp = odsList.get(0);
		// stgStodnDownDAO.updateErrorNoNotSuc(temp.getStoDnNo());
		// /*
		// if ("STO".equals(temp.getDocTpye())) {
		// sap = new PostPOFromIndiaWmsToGVSPC(orderNo) 调用接口对stodn过账
		// .exchangeWithSap();
		// } */
		// in.setDoctype("STO");
		// in.setOrno(stoDnNo);
		// in.setUser(userName);
		// if ("S".equals(sap)) {
		// // if ("1".equals(temp.getOrderType())) {//ordertype 1入库
		// // in.setOrdertype("1");
		// // otcwmsOrderIgpDAO.orderMakeStorageIn(in, ret);
		// // } else if ("2".equals(temp.getOrderType())) { //2出库
		// in.setOrdertype("2");
		// otcwmsOrderIgpDAO.orderMakeStorageOut(in, ret);
		// // }
		// } else {
		// return "E";
		// }
		// }
		// if ("0".equals(ret.getStatus())) {
		// return "S";
		// } else {
		// return "E," + ret.getMsg();
		// }
		return null;
	}

	@Override
	public Long getExportAmount(StgStodnDownDTO dto) {
		return stgStodnDownDAO.searchStgStodnDownsCount(dto);
	}

	/**
	 * @author Sun Yanfei 根据stodn号和物料关联sto查询是否是来自9990工厂的sto
	 * @param stoDnNo
	 * @param materialNo
	 * @return
	 */
	@Override
	public int getStoDnCountByParam(String stoDnNo, String materialNo) {
		return stgStodnDownDAO.getStoDnCountByParam(stoDnNo, materialNo);
	}

	/**
	 * @Description: stgStodnDownDAO 的set方法
	 * @param stgStodnDownDAO
	 *
	 */
	public void setStgStodnDownDAO(StgStodnDownDAO stgStodnDownDAO) {
		this.stgStodnDownDAO = stgStodnDownDAO;
	}
	
	@Override
	public InterfaceOutDTO downloadStodn(String stoNo, String stodnNo, String userName){
		logger.info("Download STODN start with orderNo: " + stodnNo );
		InterfaceOutDTO result = new DownloadStodnFromSap(stoNo, stodnNo, userName).exchangeWithSap();
		return result;

	}

	/**
	 * TMS STODN 推送
	 * @param stgStoDnDTO
	 * @return
	 */
	@Override
	public InterfaceOutDTO downloadStodnFromTMS(StgStoDnDTO stgStoDnDTO) {
		logger.info("****** Download STODN From TMS ******");
		InterfaceOutDTO result = new InterfaceOutDTO();
		try {
			//判断物料描述是否存在
			if(StringUtils.isBlank(stgStoDnDTO.getMaterialDesp())) {
				//根据物料查询物料描述
				String materialDesp = stgStodnDownDAO.getMaterialDespByMaterialNo(stgStoDnDTO.getMaterialNo());
				stgStoDnDTO.setMaterialDesp(materialDesp);
			}
			stgStodnDownDAO.saveStoDn(stgStoDnDTO);
			result.setStatus("S");
			result.setMsg("SUCCESS");
		} catch (Exception e) {
			if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
				result.setStatus("E");
				result.setMsg("Already exist, please do not push repeatedly");
			}else {
				result.setStatus("E");
				result.setMsg("Unknown download error");
			}
			logger.error("Unknown download error: " + result.toString());
		}
		return result;
	}

	/**
	 * stodn物料信息检查获取
	 * @param stoDnNo
	 * @return
	 */
	@Override
	public InterfaceOutDTO checkStoDnNo(String stoDnNo) {
		InterfaceOutDTO result = new InterfaceOutDTO();
		//校验stodn是否存在
		Integer count = stgStodnDownDAO.checkStodn(stoDnNo);
		if(count <= 0) {
			result.setStatus("E");
			result.setMsg("Order doesn't exist!");
			return result;
		}
		result.setStatus("S");
		result.setMsg("Order has been download, please scan!");
		return result;
	}

	@Override
	public List<String> getGrLocationNameListByStodnNo(String stodnNo) {
		return stgStodnDownDAO.getGrLocationNameListByStodnNo(stodnNo);
	}

	/**
	 * 直发派遣列表查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	@Override
	public Pager<StgStodnDownDTO> searchStgStoDnDownsFromFactory(Pager<StgStodnDownDTO> pager,
																 StgStodnDownDTO dto) {
		List<StgStodnDownDTO> odsOrderInfos = stgStodnDownDAO.searchStgStoDnDownsFromFactory(pager, dto);
		long size = stgStodnDownDAO.searchStgStoDnDownsFromFactoryCount(dto);
		return Pager.cloneFromPager(pager, size, odsOrderInfos);
	}

	/**
	 * STODN 分页查询
	 * @param pager
	 * @param stgStoDown
	 * @return
	 */
	@Override
	public Pager<StgStoDnDTO> searchStgStoDn(Pager<StgStoDnDTO> pager, StgStoDnDTO stgStoDown) {
		long size = stgStodnDownDAO.searchStgStoDnCount(stgStoDown);
		List<StgStoDnDTO> stgStoDowns = stgStodnDownDAO.searchStgStoDn(pager, stgStoDown);
		return Pager.cloneFromPager(pager, size, stgStoDowns);
	}

	/**
	 * STODN 扫描详情分页查询
	 * @param pager
	 * @param stgStoDown
	 * @return
	 */
	@Override
	public Pager<StgStoDnDTO> searchScanDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO stgStoDown) {
		long size = stgStodnDownDAO.searchStoDnScanCount(stgStoDown);
		List<StgStoDnDTO> stgStoDowns = stgStodnDownDAO.searchStoDnScan(pager, stgStoDown);
		return Pager.cloneFromPager(pager, size, stgStoDowns);
	}

	/**
	 * STODN 过账信息分页查询
	 * @param pager
	 * @param stgStoDown
	 * @return
	 */
	@Override
	public Pager<StgStoDnDTO> searchPostDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO stgStoDown) {
		long size = stgStodnDownDAO.searchPostDetailCount(stgStoDown);
		List<StgStoDnDTO> stgStoDowns = stgStodnDownDAO.searchPostDetail(pager, stgStoDown);
		return Pager.cloneFromPager(pager, size, stgStoDowns);
	}

	/**
	 * TMS STODN 过账
	 * @param orderNo
	 * @param orderType
	 * @param userName
	 * @return
	 */
	@Override
	public InterfaceOutDTO postStodn(String orderNo, String orderType, String userName) {
		logger.info("Post PO start with orderNo: " + orderNo);
		InterfaceOutDTO result = null;
		if("2".equals(orderType)) {
			result = new PostStoDnToTMS(orderNo, orderType,userName).exchangeWithTMS();
		}else if("1".equals(orderType)) {
			result = new PostStoDnToTMS(orderNo, orderType,userName).exchangeWithSap();
		}else {
			result.setStatus("Abnormal inbound and outbound status！");
		}
		return result;
	}

	@Override
	public InterfaceOutDTO stoDnGoodsDelivery(StgStoDnDTO stgStoDnDTO) {
		InterfaceOutDTO out = new InterfaceOutDTO();
		stgStodnDownDAO.stoDnGoodsDelivery(stgStoDnDTO,out);
		return out;
	}

	@Override
	public InterfaceOutDTO stoDnGoodsReceive(StgStoDnDTO stgStoDnDTO) {
		InterfaceOutDTO out = new InterfaceOutDTO();
		stgStodnDownDAO.stoDnGoodsReceive(stgStoDnDTO,out);
		return out;
	}

	/**
	 * 生成过账汇总
	 * @param stgStoDnDTO
	 * @return
	 */
	@Override
	public OrderGiGrDTO saveStodnGiGrInfo(StgStoDnDTO stgStoDnDTO) {
		OrderGiGrDTO out = new OrderGiGrDTO();
		stgStodnDownDAO.saveStodnGiGrInfo(stgStoDnDTO,out);
		return out;
	}


}

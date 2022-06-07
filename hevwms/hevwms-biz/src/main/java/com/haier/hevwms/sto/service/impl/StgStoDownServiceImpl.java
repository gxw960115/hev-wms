package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.basic.dao.OdsHistoryLogDAO;
import com.haier.hevwms.sapinterface.*;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.sto.dao.StgStoDownDAO;
import com.haier.hevwms.sto.dao.StoPDADAO;
import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;

public class StgStoDownServiceImpl implements StgStoDownService{

	private Logger logger = Logger.getLogger(StgStoDownServiceImpl.class);

	private StgStoDownDAO stgStoDownDAO;
	private OdsHistoryLogDAO odsHistoryLogDAO;
	private UserDAO userDAO;
	private StoPDADAO stoPDADAO;

	public void setStgStoDownDAO(StgStoDownDAO stgStoDownDAO){
		this.stgStoDownDAO = stgStoDownDAO;
	}
	public StgStoDownDAO getStgStoDownDAO(){
		return stgStoDownDAO;
	}

	public OdsHistoryLogDAO getOdsHistoryLogDAO() {
		return odsHistoryLogDAO;
	}

	public void setOdsHistoryLogDAO(OdsHistoryLogDAO odsHistoryLogDAO) {
		this.odsHistoryLogDAO = odsHistoryLogDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public StoPDADAO getStoPDADAO() {
		return stoPDADAO;
	}
	public void setStoPDADAO(StoPDADAO stoPDADAO) {
		this.stoPDADAO = stoPDADAO;
	}
	/**
	 * 分页查询
	 */
	@Override
	public Pager<StgStoDownDTO> searchStgStoDowns(Pager<StgStoDownDTO> pager, StgStoDownDTO stgStoDown){
		long size = stgStoDownDAO.searchStgStoDownsCount(stgStoDown);
		List<StgStoDownDTO> stgStoDowns = stgStoDownDAO.searchStgStoDowns(pager, stgStoDown);
		return Pager.cloneFromPager(pager, size, stgStoDowns);
	}

	/**
	 * ID查询
	 */
	@Override
	public StgStoDownDTO getStgStoDownById(Long stgStoDownId){
		return stgStoDownDAO.get(stgStoDownId);
	}

	/**
	 * 条件查询
	 */
	@Override
	public List<StgStoDownDTO> getStgStoDowns(StgStoDownDTO stgStoDown){
		return stgStoDownDAO.getListByParam(stgStoDown);
	}

	//	@Override
//	public String closeStgStoDown(String userName, String ids) {
//		String[] idArray=ids.split(",");
//		if(idArray.length>0){
//			stgStoDownDAO.closeStgStoDown(idArray);
//			OdsHistoryLog log=new OdsHistoryLog();
//			log.setOperationBy(userName);
//			log.setOperationCode("STO_CLOSE");
//			log.setOperationContent(userName+"===STO ID==="+ids);
//			log.setCreateBy(UserUtil.getCurrentUser().getName());
//			odsHistoryLogDAO.save(log);
//			return "S";
//		}else{
//			return "S";
//		}	 
//	}
	@Override
	public String closeStgStoDown(String userName, String ids) {
		return null;
	}
	@Override
	public String openStgStoDown(String userName, String ids) {
		return null;
	}

//	//20140721 STO reopen chenp
//	@Override
//	public String openStgStoDown(String userName, String ids) {
//		String[] idArray = ids.split(",");
//		if (idArray.length > 0) {
//			stgStoDownDAO.openStgStoDown(idArray);
//			OdsHistoryLog log = new OdsHistoryLog();
//			log.setOperationBy(userName);
//			log.setOperationCode("STO_OPEN");
//			log.setOperationContent(userName + "===STO ID===" + ids);
//			log.setCreateBy(UserUtil.getCurrentUser().getName());
//			odsHistoryLogDAO.save(log);
//			return "S";
//		} else {
//			return "S";
//		}
//	}

	@Override
	public int updateStoConfirm(String stoNo) {
		return stgStoDownDAO.updateStoConfirm(stoNo);
	}

	@Override
	public Long getExportAmount(StgStoDownDTO dto) {
		return stgStoDownDAO.searchStgStoDownsCount(dto);
	}

	@Override
	public OrderCheckOutDTO checkStoReceive(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String errorMsg = "";
		String result = stgStoDownDAO.checkStoReceiveExist(dto);
		if ("Y".equals(result)){
			UserDTO user = userDAO.getUserByName(dto.getUser());
			if ("3".equals(user.getDutyType())){
				result = stgStoDownDAO.checkStoReceiveLoc(dto, user.getId());
				if (!"Y".equals(result)){
					errorMsg = "User has no authority to scan this order!";
				}
			}
		} else {
			errorMsg = "Order doens't exist!";
		}
		if ("Y".equals(result)){
			out.setStatus("S");
			out.setMsg("Order has been download, please scan!");
		} else {
			out.setStatus("F");
			out.setMsg(errorMsg);
		}
		return out;
	}
	@Override
	public OrderCheckOutDTO checkStoDelivery(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String errorMsg = "";
		String result = stgStoDownDAO.checkStoDeliveryExist(dto);
		if ("Y".equals(result)){
			UserDTO user = userDAO.getUserByName(dto.getUser());
			if ("3".equals(user.getDutyType())){
				result = stgStoDownDAO.checkStoDeliveryLoc(dto, user.getId());
				if (!"Y".equals(result)){
					errorMsg = "User has no authority to scan this order!";
				}
			}
		} else {
			errorMsg = "Order doens't exist!";
		}
		if ("Y".equals(result)){
			out.setStatus("S");
			out.setMsg("Order has been download, please scan!");
		} else {
			out.setStatus("F");
			out.setMsg(errorMsg);
		}
		return out;
	}

	/**
	 * 手持STO_调用SAP接口下载STO订单
	 */
	@Override
	public InterfaceOutDTO downloadSto(String stoNo, String begin, String end, String userName) {
		logger.info("Download PO start with orderNo: " + stoNo + ", begin: " + begin + ", end: " + end);
		InterfaceOutDTO result = new InterfaceOutDTO();
		try {
			logger.info("Start TMS STO download...");
			result = new DownloadStoDnFromTMS(begin, end, stoNo, userName).exchangeWithTMS();
			if("E".equals(result.getStatus())) {
				logger.info("TMS download failed! Download in SAP");
				result = new DownloadStoFromSap(begin, end, null, stoNo, null, userName).exchangeWithSap();
			}
		}catch (Exception e){
			logger.debug("STO Download failed! Exception:"+e.getLocalizedMessage());
		}
		logger.info("Download STO:" + result.toString());
		return result;
	}

	/** (non-Javadoc)
	 * <p>Title: postSto</p>
	 * <p>Description: </p>
	 * @param orderNo
	 * @param sapFlag
	 * @param userName
	 * @return
	 * @see com.haier.hevwms.sto.service.StgStoDownService#
	 * postSto(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public InterfaceOutDTO postSto(String orderNo, String stodnNo, String orderType, String sapFlag, String userName) {
		logger.info("Post STO start with orderNo: " + orderNo + ", stodnNo: " + stodnNo + ", orderType: " + orderType + ", sapFlag: " + sapFlag + ", userName: " + userName);
		InterfaceOutDTO result = null;
		String[] arr = orderNo.split(",");
		for(int i = 0;i < arr.length; i++) {
//			String comeFromTMS = stgStoDownDAO.getComeFromTMS(arr[i]);
//			if("TMS".equals(comeFromTMS)) {
//				logger.info("Post STO start To TMS");
//				result = new PostStoDnToTMS(orderNo, sapFlag, userName).exchangeWithTMS();
//				result.setIsCome("TMS");
//				logger.info("Post STO Result: " + result.toString());
//			}else {
//				logger.info("Post STO start To SAP");
				if ("2".equals(sapFlag) && !StringUtils.isEmpty(stodnNo)) {
					result = new RePostStoToSap(orderNo, sapFlag, userName, orderType).exchangeWithSap();
					result.setIsCome("SAP");
				} else {
					result =  new PostStoToSap(orderNo, sapFlag, userName).exchangeWithSap();
					result.setIsCome("SAP");
					if ("S".equals(result.getStatus())) {
						// 下载DN
						for (String dnNo:result.getDnNos()) {
							InterfaceOutDTO s = new DownloadStodnFromSap(result.getStoNo(), dnNo, userName).exchangeWithSap();
							if (!"S".equals(s.getStatus())) {
								logger.info("Download STODN failed! stodn_no:"+dnNo);
							}
						}
					}
				}
				logger.info("Post STO Result: " + result.toString());
			}
//		}
		return result;
	}
	@Override
	public InterfaceOutDTO postStodn(String orderNo, String sapFlag, String userName) {
		logger.info("Post PO start with orderNo: " + orderNo);

		InterfaceOutDTO result = new PostStodnToSap(orderNo, sapFlag, userName).exchangeWithSap();


		return result;
	}

	@Override
	public OrderGoodsTransOutDTO stoGoodsDelivery(OrderIgpInDTO inpara){
		OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
		stoPDADAO.stoGoodsDelivery(inpara, ret);
		return ret;
	}
	@Override
	public OrderGoodsTransOutDTO stoGoodsReceive(OrderIgpInDTO inpara) {
		OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
		stoPDADAO.stoGoodsReceive(inpara, ret);
		return ret;
	}

	@Override
	public OrderCheckOutDTO checkOrderByPDA(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String errorMsg = "";
		String result;
		String stoResult = stgStoDownDAO.checkStoDeliveryExist(dto);
		String dnResult = stgStoDownDAO.checkStoReceiveExist(dto);
		if ("N".equals(stoResult) && "N".equals(dnResult)) {
			out.setStatus("F");
			out.setMsg("Order doesn't exist!");
			return out;
		}

		if ("Y".equals(stoResult) && dto.getDoctype().equals("STO")){
			UserDTO user = userDAO.getUserByName(dto.getUser());
			if ("3".equals(user.getDutyType())){
				result = stgStoDownDAO.checkStoDeliveryLoc(dto, user.getId());
				if (!"Y".equals(result)){
					out.setStatus("F");
					out.setMsg("User has no authority to scan this order!");
					return out;
				}
			}
		} else if ("Y".equals(dnResult) && dto.getDoctype().equals("STODN")) {
			UserDTO user = userDAO.getUserByName(dto.getUser());
			if ("3".equals(user.getDutyType())){
				result = stgStoDownDAO.checkStoReceiveLoc(dto, user.getId());
				if (!"Y".equals(result)){
					out.setStatus("F");
					out.setMsg("User has no authority to scan this order!");
					return out;
				}
			}
		} else {
			if ("Y".equals(stoResult)) {
				errorMsg = "Please scan the order in STO DN page!";
			} else {
				errorMsg = "Please scan the order in STO page!";
			}
			out.setStatus("F");
			out.setMsg(errorMsg);
			return out;
		}
		out.setStatus("S");
		out.setMsg("Order has been download, please scan!");
		return out;
	}

	@Override
	public List<String> getGiLocationNameListBySTONO(String stoNo) {
		return stgStoDownDAO.getGiLocationNameListBySTONO(stoNo);
	}

	@Override
	public List<String> getGrLocationNameListBySTONO(String stoNo) {
		return stgStoDownDAO.getGrLocationNameListBySTONO(stoNo);
	}


}

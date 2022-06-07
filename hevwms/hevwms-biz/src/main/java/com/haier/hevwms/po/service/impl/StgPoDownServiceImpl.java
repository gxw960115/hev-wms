package com.haier.hevwms.po.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.haier.hevwms.po.dao.PoPDADAO;
import com.haier.hevwms.po.dao.StgPoDownDAO;
import com.haier.hevwms.po.service.StgPoDownService;
import com.haier.hevwms.sapinterface.DownloadPoFromSap;
import com.haier.hevwms.sapinterface.PostPoToSap;
import com.haier.hevwms.sapinterface.ReversePoToSap;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderMatListDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

public class StgPoDownServiceImpl implements StgPoDownService{
	Logger logger = Logger.getLogger(StgPoDownServiceImpl.class);
	
    private StgPoDownDAO stgPoDownDAO;
    private UserDAO userDAO;
    private PoPDADAO poPDADAO;
	String flag = "true";
	
	@Override
	public String deleteStgPoDownAll(List<Long> idList){
	    try {
            stgPoDownDAO.deleteAll(idList);
        } catch (Exception e) {
            flag = "false";
            return flag;
        }
        flag = "true";
        return flag;
	}
	
	
	public void setStgPoDownDAO(StgPoDownDAO stgPoDownDAO){
		this.stgPoDownDAO = stgPoDownDAO;
	}
	public StgPoDownDAO getStgPoDownDAO(){
		return stgPoDownDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public Pager<StgPoDownDTO> searchStgPoDowns(Pager<StgPoDownDTO> pager,
			StgPoDownDTO dto) {
		List<StgPoDownDTO> stgPoDowns = stgPoDownDAO.searchStgPoDowns(pager, dto);
        long size = stgPoDownDAO.searchStgPoDownsCount(dto);
        return Pager.cloneFromPager(pager, size, stgPoDowns);
	}

	@Override
	public String createStgPoDown(StgPoDownDTO dto) {
		try {
			flag = "true";
			stgPoDownDAO.save(dto);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String updateStgPoDown(StgPoDownDTO dto) {
		flag = "true";
	    Date date = new Date();
	    SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String da = ss.format(date);
	    try {
	        date = ss.parse(da);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    dto.setModifyDate(date);
	    stgPoDownDAO.update(dto);
	    return flag;
	}
	
	public Pager<StgPoDownDTO> searchMdMatInfos(Pager<StgPoDownDTO> pager,
	        StgPoDownDTO dto) {
        List<StgPoDownDTO> stgPoDowns = stgPoDownDAO.searchStgPoDowns(pager, dto);
        long size = stgPoDownDAO.searchStgPoDownsCount(dto);
        return Pager.cloneFromPager(pager, size, stgPoDowns);
    }

	@Override
	public List<StgPoDownDTO> getStgPoDownByParam(StgPoDownDTO dto) {
		return stgPoDownDAO.getStgPoDownsByParam(dto);
	}

	@Override
	public Long getExportAmount(StgPoDownDTO dto) {
		return stgPoDownDAO.searchStgPoDownsCount(dto);
	}

	/**
	 * 手持PO_入库检查
	 */
	@Override
	public OrderCheckOutDTO checkPo(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String errorMsg = "";
		// 获取是否是正常订单 正常订单poType ！= VREP
		String result = stgPoDownDAO.checkPoExist(dto);
		// 是正常订单 == Y  
		if ("Close".equals(result)){
			errorMsg = "Order has been closed!";
		} else if (result == null||"".equals(result)){
			errorMsg = "Order doens't exist!";
		} else if ("2".equals(result)&&"1".equals(dto.getOrdertype())){
			errorMsg = "Please scan in po return page!";
		} else if ("2".equals(result)&&"2".equals(dto.getOrdertype())&&"122".equals(dto.getReturnType())){
			errorMsg = "Please select po return!";
		} else if ("1".equals(result)&&"2".equals(dto.getOrdertype())&&"101".equals(dto.getReturnType())){
			errorMsg = "Please select po reverse if you want to reverse!";
		} else {
			// 根据用户名获取用户信息
			UserDTO user = userDAO.getUserByName(dto.getUser());
			// 判定用户类型
			if ("3".equals(user.getDutyType())){
				result = stgPoDownDAO.checkPoLoc(dto, user.getId());
				if (!"Y".equals(result)){
					errorMsg = "User has no authority to scan this order!";
				}
			}
		}
		if ("".equals(errorMsg)){
			out.setStatus("S");
			out.setMsg("Order has been download, please scan!");
		} else {
			out.setStatus("F");
			out.setMsg(errorMsg);
		}
		return out;
	}

	/* (非 Javadoc) 
	* <p>Title: checkGiftPo</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.hevwms.po.service.StgPoDownService#checkGiftPo(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO) 
	*/
	@Override
	public OrderCheckOutDTO checkGiftPo(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String errorMsg = "";
		// 获取是否是正常订单 正常订单poType ！= VREP
		String result = stgPoDownDAO.checkGiftPoExist(dto);
		// 是正常订单 == Y  
		if ("Close".equals(result)){
			errorMsg = "Order has been closed!";
		} else if (result == null||"".equals(result)){
			errorMsg = "Order doens't exist!";
		} else if ("2".equals(result)){
			errorMsg = "This order is not Gift PO!";
		} else {
			// 根据用户名获取用户信息
			UserDTO user = userDAO.getUserByName(dto.getUser());
			// 判定用户类型
			if ("3".equals(user.getDutyType())){
				result = stgPoDownDAO.checkPoLoc(dto, user.getId());
				if (!"Y".equals(result)){
					errorMsg = "User has no authority to scan this order!";
				}
			}
		}
		if ("".equals(errorMsg)){
			out.setStatus("S");
			out.setMsg("Order has been download, please scan!");
		} else {
			out.setStatus("F");
			out.setMsg(errorMsg);
		}
		return out;
	}
	
	/**
	 * 调用SAP接口进行下载
	 */
	@Override
	public String downloadPo(String poNo, String beginTime, String endTime, String userName) {
		logger.info("Download PO start with orderNo: " + poNo + ", begin: " + beginTime + ", end: " + endTime);
        String result = new DownloadPoFromSap(poNo, beginTime, endTime, userName).exchangeWithSap();
		return result;
	}


	/* (non-Javadoc)  
	 * <p>Title: postPo</p>  
	 * <p>Description: </p>  
	 * @param poNo
	 * @param userName
	 * @return  
	 * @see com.haier.hevwms.order.service.StgPoDownService#postPo(java.lang.String, java.lang.String)  
	 */
	@Override
	public String postPo(String orderNo, String orderType, String returnType, String sapFlag, String userName) {
		logger.info("Post PO start with orderNo: " + orderNo);
		String result ;
		if ("1".equals(orderType)){
			result = new PostPoToSap(orderNo, sapFlag, userName).exchangeWithSap();
		} else {
			result =  new ReversePoToSap(orderNo, sapFlag , userName, returnType).exchangeWithSap();
		}
        
		return result;
	}

	@Override
	public OrderGoodsTransOutDTO poGoodsReceive(OrderIgpInDTO inpara){
		OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
		poPDADAO.poGoodsReceive(inpara, ret);
		return ret;
	}
	
	@Override
	public OrderGoodsTransOutDTO giftPoGoodsReceive(OrderIgpInDTO inpara) {
		OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
		poPDADAO.giftPoGoodsReceive(inpara, ret);
		return ret;
	}
	
	public OrderGoodsTransOutDTO poGoodsDelivery(OrderIgpInDTO inpara){
		OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
		poPDADAO.poGoodsDelivery(inpara, ret);
		return ret;
	}
	
	public PoPDADAO getPoPDADAO() {
		return poPDADAO;
	}


	public void setPoPDADAO(PoPDADAO poPDADAO) {
		this.poPDADAO = poPDADAO;
	}


	/* (non-Javadoc)  
	 * <p>Title: getPoMaterialList</p>  
	 * <p>Description: </p>  
	 * @param orderNo
	 * @return  
	 * @see com.haier.hevwms.po.service.StgPoDownService#getPoMaterialList(java.lang.String)  
	 */
	@Override
	public List<OrderMatListDTO> getPoMaterialList(String orderNo) {
		return stgPoDownDAO.getPoMaterialList(orderNo);
	}


	/* (non-Javadoc)  
	 * <p>Title: scanPoCheck</p>  
	 * <p>Description: </p>  
	 * @param inpara
	 * @return  
	 * @see com.haier.hevwms.po.service.StgPoDownService#scanPoCheck(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO)  
	 */
	@Override
	public OrderUploadOutDTO scanPoCheck(OrderUploadInDTO inpara) {
	    logger.info("Scan Po start--order no:"+inpara.getOrno()+", barcode:"+inpara.getBarcode());
	    OrderUploadOutDTO result = new OrderUploadOutDTO();
		stgPoDownDAO.scanPoCheck(inpara, result);
		return result;
	}


}

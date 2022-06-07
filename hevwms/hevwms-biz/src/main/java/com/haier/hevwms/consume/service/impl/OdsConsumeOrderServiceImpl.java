package com.haier.hevwms.consume.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.haier.hevwms.consume.dao.OdsConsumeOrderDAO;
import com.haier.hevwms.consume.service.OdsConsumeOrderService;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeOrderServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月23日 下午2:39:27
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月23日		LJZ			v1.0.0			create
 */

public class OdsConsumeOrderServiceImpl implements OdsConsumeOrderService {
	
	Logger logger = Logger.getLogger(OdsConsumeOrderServiceImpl.class);
	
	private UserDAO userDAO;
	private OdsConsumeOrderDAO odsConsumeOrderDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public OdsConsumeOrderDAO getOdsConsumeOrderDAO() {
		return odsConsumeOrderDAO;
	}

	public void setOdsConsumeOrderDAO(OdsConsumeOrderDAO odsConsumeOrderDAO) {
		this.odsConsumeOrderDAO = odsConsumeOrderDAO;
	}

	/**
	 * 分页条件查询
	 */
	@Override
	public Pager<OdsConsumeOrderDTO> searchOdsConsumeOrderByPage(
			Pager<OdsConsumeOrderDTO> pager, OdsConsumeOrderDTO dto) {
		List<OdsConsumeOrderDTO> list = odsConsumeOrderDAO.searchOdsConsumeOrderByPage(pager, dto);
		Long size = odsConsumeOrderDAO.searchOdsConsumeOrderCount(dto);
		return Pager.cloneFromPager(pager, size, list);
	}

	/**
	 * 删除 Consume order
	 */
	@Override
	public int deleteConsumeOrder(List<Long> idList) {
		int rows = odsConsumeOrderDAO.deleteAll(idList);
		return rows;
	}

	/**
	 * 确认领用单
	 */
	@Override
	public int confirmConsumeOrder(List<Long> idList, String userName) {
		int rows = odsConsumeOrderDAO.confirmConsumeOrder(idList,userName);
		return rows;
	}
	
	/**
	 * 查询导出Excel条数
	 */
	@Override
	public Long getExportAmount(OdsConsumeOrderDTO dto) {
		return odsConsumeOrderDAO.searchOdsConsumeOrderCount(dto);
	}

	/**
	 * 条件查询
	 */
	@Override
	public List<OdsConsumeOrderDTO> getOdsConsumeOrderListByParm(
			OdsConsumeOrderDTO dto) {
		return odsConsumeOrderDAO.getOdsConsumeOrderListByParm(dto);
	}

	/* (non-Javadoc)  
	 * <p>Title: getConsumeSequence</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.haier.hevwms.consume.service.OdsConsumeOrderService#getConsumeSequence()  
	 */
	@Override
	public String getConsumeSequence() {
		Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String dateString = formatter.format(currentTime);
        String sequence="000"+odsConsumeOrderDAO.getConsumeSequence();
		return "C"+dateString+sequence.substring(sequence.length()-3);
	}

	/* (non-Javadoc)  
	 * <p>Title: saveConsumeOrder</p>  
	 * <p>Description: </p>  
	 * @param list
	 * @param dto  
	 * @see com.haier.hevwms.consume.service.OdsConsumeOrderService#saveConsumeOrder(java.util.List, com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO)  
	 */
	@Override
	public String saveConsumeOrder(List<OdsConsumeOrderDTO> list,OdsConsumeOrderDTO dto) {
		String result = "SUCCESS";
		for (OdsConsumeOrderDTO temp:list){
			try {
				OdsConsumeOrderDTO consumeOrder = new OdsConsumeOrderDTO();
				consumeOrder.setConsumeNo(dto.getConsumeNo());
				consumeOrder.setConsumeItemNo(String.format("%04d",list.indexOf(temp) + 1));
				consumeOrder.setPlant(dto.getPlant());
				consumeOrder.setLocation(dto.getLocation());
				consumeOrder.setMaterialNo(temp.getMaterialNo());
				consumeOrder.setCustomerModel(temp.getCustomerModel());
				consumeOrder.setMaterialDesp(temp.getMaterialDesp());
				consumeOrder.setRequireQty(temp.getQty());
				consumeOrder.setUnit(temp.getBasicUnit());
				consumeOrder.setCreateBy(dto.getCreateBy());
				consumeOrder.setCreateDate(dto.getCreateDate());
				consumeOrder.setFinishQty(0L);
				consumeOrder.setFinishFlag("0");
				consumeOrder.setFlag("0");
				consumeOrder.setCheckFlag("0");
				consumeOrder.setOrderClose("0");
				consumeOrder.setInOutFlag("0");
				consumeOrder.setSapFlag("0");
				odsConsumeOrderDAO.save(consumeOrder);
				
			} catch (Exception e){
				logger.info("Save consume order exception: plant:"+dto.getPlant()+", location:"+dto.getLocation()+".");
				return "FAIL";
			}
		}
		return result;
	}

	/**
	 * 手持Consume_ 订单扫描检查 
	 */
	@Override
	public OrderCheckOutDTO checkConsumeOrderByPDA(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		out.setStatus("S");
		out.setMsg("Order has been download, please scan!");
		String consumeNo = dto.getOrno();
		if (null == consumeNo || "".equals(consumeNo)) {
			out.setStatus("F");
			out.setMsg("Please input order No.!");
			return out;
		}
		// 检查订单是否存在
		String result = odsConsumeOrderDAO.checkConsumeOrderByPDA(consumeNo);
		if ("1".equals(result)) {
			UserDTO user = userDAO.getUserByName(dto.getUser());
			if ("3".equals(user.getDutyType())) {
				// 获取用户是否有扫描权限
				result = odsConsumeOrderDAO.checkConsumeOrderLoc(consumeNo,user.getId());
				if (!"Y".equals(result)){
					out.setStatus("F");
					out.setMsg("User has no authority to scan this order!");
					return out;
				}
			}
			
		}else if(result == null || "".equals(result)) {
			out.setStatus("F");
			out.setMsg("Order doens't exist!");
		} else if("0".equals(result)){
			out.setStatus("F");
			out.setMsg("Order need approve!");
		} else if ("2".equals(result)){
			out.setStatus("F");
			out.setMsg("Order approve confused!");
		}
		return out;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.consume.service.OdsConsumeOrderService#scanStatus(java.lang.String)
	 */
	@Override
	public List<OdsConsumeOrderDTO> scanStatus(String orderNo) {
		return odsConsumeOrderDAO.scanStatus(orderNo);
	}

	@Override
	public int updateCostCenter(OdsConsumeOrderDTO dto) {
		return odsConsumeOrderDAO.updateCostCenter(dto);
	}

}

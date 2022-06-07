package com.haier.hevwms.scrap.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.haier.hevwms.scrap.dao.OdsScrapOrderDAO;
import com.haier.hevwms.scrap.service.OdsScrapOrderService;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapOrderServiceImpl.java
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

public class OdsScrapOrderServiceImpl implements OdsScrapOrderService {
	
	Logger logger = Logger.getLogger(OdsScrapOrderServiceImpl.class);
	private OdsScrapOrderDAO odsScrapOrderDAO;
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public OdsScrapOrderDAO getOdsScrapOrderDAO() {
		return odsScrapOrderDAO;
	}
	public void setOdsScrapOrderDAO(OdsScrapOrderDAO odsScrapOrderDAO) {
		this.odsScrapOrderDAO = odsScrapOrderDAO;
	}

	/**
	 * 分页条件查询
	 */
	@Override
	public Pager<OdsScrapOrderDTO> searchOdsScrapOrderByPage(
			Pager<OdsScrapOrderDTO> pager, OdsScrapOrderDTO dto) {
		List<OdsScrapOrderDTO> list = odsScrapOrderDAO.searchOdsScrapOrderByPage(pager, dto);
		Long size = odsScrapOrderDAO.searchOdsScrapOrderCount(dto);
		return Pager.cloneFromPager(pager, size, list);
	}

	/**
	 * 删除 Scrap order
	 */
	@Override
	public int deleteScrapOrder(List<Long> idList) {
		int rows = odsScrapOrderDAO.deleteAll(idList);
		return rows;
	}

	/**
	 * 确认报废单
	 */
	@Override
	public int confirmScrapOrder(List<Long> idList, String userName) {
		int rows = odsScrapOrderDAO.confirmScrapOrder(idList,userName);
		return rows;
	}
	
	/**
	 * 查询导出Excel条数
	 */
	@Override
	public Long getExportAmount(OdsScrapOrderDTO dto) {
		return odsScrapOrderDAO.searchOdsScrapOrderCount(dto);
	}

	/**
	 * 条件查询
	 */
	@Override
	public List<OdsScrapOrderDTO> getOdsScrapOrderListByParm(
			OdsScrapOrderDTO dto) {
		return odsScrapOrderDAO.getOdsScrapOrderListByParm(dto);
	}

	/* (non-Javadoc)  
	 * <p>Title: getScrapSequence</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.haier.hevwms.scrap.service.OdsScrapOrderService#getScrapSequence()  
	 */
	@Override
	public String getScrapSequence() {
		Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String dateString = formatter.format(currentTime);
        String sequence="000"+odsScrapOrderDAO.getScrapSequence();
		return "S"+dateString+sequence.substring(sequence.length()-3);
	}

	/* (non-Javadoc)  
	 * <p>Title: saveScrapOrder</p>  
	 * <p>Description: </p>  
	 * @param dto  
	 * @see com.haier.hevwms.scrap.service.OdsScrapOrderService#saveScrapOrder(com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO)  
	 */
	@Override
	public String saveScrapOrder(List<OdsScrapOrderDTO> list, OdsScrapOrderDTO dto) {
		String result = "SUCCESS";
		for (OdsScrapOrderDTO temp:list){
			try {
				OdsScrapOrderDTO scrapOrder = new OdsScrapOrderDTO();
				scrapOrder.setScrapNo(dto.getScrapNo());
				scrapOrder.setScrapItemNo(String.format("%04d",list.indexOf(temp) + 1));
				scrapOrder.setPlant(dto.getPlant());
				scrapOrder.setLocation(dto.getLocation());
				scrapOrder.setMaterialNo(temp.getMaterialNo());
				scrapOrder.setCustomerModel(temp.getCustomerModel());
				scrapOrder.setMaterialDesp(temp.getMaterialDesp());
				scrapOrder.setRequireQty(temp.getQty());
				scrapOrder.setUnit(temp.getBasicUnit());
				scrapOrder.setCreateBy(dto.getCreateBy());
				scrapOrder.setCreateDate(dto.getCreateDate());
				scrapOrder.setFinishQty(0L);
				scrapOrder.setFinishFlag("0");
				scrapOrder.setFlag("0");
				scrapOrder.setCheckFlag("0");
				scrapOrder.setOrderClose("0");
				scrapOrder.setSapFlag("0");
				scrapOrder.setInOutFlag("0");
				
				odsScrapOrderDAO.save(scrapOrder);
				
			} catch (Exception e){
				logger.info("Save scrap order exception: plant:"+dto.getPlant()+", location:"+dto.getLocation()+".");
				return "FAIL";
			}
		}
		return result;
		
	}
	
	/**
	 * 手持Scrap_ 订单扫描检查 
	 */
	@Override
	public OrderCheckOutDTO checkScrapOrderByPDA(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		out.setStatus("S");
		out.setMsg("Order has been download, please scan!");
		String scrapNo = dto.getOrno();
		if (null == scrapNo || "".equals(scrapNo)) {
			out.setStatus("F");
			out.setMsg("Please input order No.!");
			return out;
		}
		// 检查订单是否存在
		String result = odsScrapOrderDAO.checkScrapOrderByPDA(scrapNo);
		
		if ("1".equals(result)) {
			UserDTO user = userDAO.getUserByName(dto.getUser());
			if ("3".equals(user.getDutyType())) {
				// 检查用户是否有该仓库扫描权限
				result = odsScrapOrderDAO.checkScrapOrderLoc(scrapNo,user.getId());
				if (!"Y".equals(result)){
					out.setStatus("F");
					out.setMsg("User has no authority to scan this order!");
				} 
			}
		} else if(result == null || "".equals(result)) {
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
	 * @see com.haier.hevwms.scrap.service.OdsScrapOrderService#scanStatus(java.lang.String)
	 */
	@Override
	public List<OdsScrapOrderDTO> scanStatus(String orderNo) {
		return odsScrapOrderDAO.scanStatus(orderNo);
	}
	
	/* (非 Javadoc) 
	* <p>Title: updateCostCenter</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.hevwms.scrap.service.OdsScrapOrderService#updateCostCenter(com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO) 
	*/
	@Override
	public int updateCostCenter(OdsScrapOrderDTO dto) {
		return odsScrapOrderDAO.updateCostCenter(dto);
	}
	
}

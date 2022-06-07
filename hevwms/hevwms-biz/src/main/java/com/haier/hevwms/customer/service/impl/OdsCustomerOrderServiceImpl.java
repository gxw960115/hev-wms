package com.haier.hevwms.customer.service.impl;

import com.haier.hevwms.customer.dao.OdsCustomerOrderDAO;
import com.haier.hevwms.customer.service.OdsCustomerOrderService;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**  
 * @Title:  OdsCustomerOrderServiceImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:17:45   
 * @version V1.0 
 */  
public class OdsCustomerOrderServiceImpl implements OdsCustomerOrderService{
	
	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsCustomerOrderServiceImpl.class);
	
	private OdsCustomerOrderDAO odsCustomerOrderDAO;
	private UserDAO userDAO;
	
	public OdsCustomerOrderDAO getOdsCustomerOrderDAO() {
		return odsCustomerOrderDAO;
	}

	public void setOdsCustomerOrderDAO(OdsCustomerOrderDAO odsCustomerOrderDAO) {
		this.odsCustomerOrderDAO = odsCustomerOrderDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#searchOdsCustomerOrders(long, long, com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO)
	 */
	@Override
	public Pager<OdsCustomerOrderDTO> searchOdsCustomerOrders(Pager<OdsCustomerOrderDTO> pager, OdsCustomerOrderDTO odsCustomerOrderDTO) {
		List<OdsCustomerOrderDTO> dtoList = odsCustomerOrderDAO.searchOdsCustomerOrders(pager, odsCustomerOrderDTO);
		long size = odsCustomerOrderDAO.searchOdsCustomerOrdersCount(odsCustomerOrderDTO);
		return Pager.cloneFromPager(pager, size, dtoList);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#searchOdsCustomerOrdersCount(com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO)
	 */
	@Override
	public Long searchOdsCustomerOrdersCount(OdsCustomerOrderDTO odsCustomerOrderDTO) {
		return odsCustomerOrderDAO.searchOdsCustomerOrdersCount(odsCustomerOrderDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#getCustomerOrderNo()
	 */
	@Override
	public String getCustomerOrderNo() {
		String seq = odsCustomerOrderDAO.selectOdsCustomerOrderNo();
		return seq;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#addCustomerOrderInfo(com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO, java.util.List)
	 */
	@Override
	public String addCustomerOrderInfo(OdsCustomerOrderDTO dto, List<OdsCustomerOrderDTO> list) {
		String flag = "success";
        int itemNo = 1;
        
    	//遍历,插入数据库中
        for(OdsCustomerOrderDTO mat : list){
        	try {
        		OdsCustomerOrderDTO cusDTO = new OdsCustomerOrderDTO(); 
        		cusDTO.setCtrOrderNo(dto.getCtrOrderNo());
        		cusDTO.setCtrItemNo(new DecimalFormat("0000").format(itemNo));
        		cusDTO.setPlant(dto.getPlant());
	        	cusDTO.setWarehouseCode(dto.getPlant());
	        	cusDTO.setWarehouseName(dto.getWarehouseName());
	        	cusDTO.setLocation(mat.getLocation());
	        	cusDTO.setMaterialNo(mat.getMaterialNo());
	        	cusDTO.setMaterialDesp(mat.getMaterialDesp());
	        	cusDTO.setCustomerModel(mat.getCustomerModel());
	        	cusDTO.setUnit(mat.getBasicUnit());
	        	cusDTO.setRequireQty(mat.getRequireQty());
	        	cusDTO.setCreateBy(dto.getCreateBy());
	        	cusDTO.setCreateDate(new Date());//移库单创建时间
	        	cusDTO.setModifyDate(new Date());
	        	cusDTO.setFinishQty(0L);
	        	cusDTO.setSapFlag("0");
	        	cusDTO.setFlag("0");//标志
	        	cusDTO.setOrderClose("0");//关闭标志
	        	cusDTO.setPresacnFlag("0");//预扫描标志
	        	cusDTO.setFinishFlag("0");//完成标志
	        	cusDTO.setPrintFlag("0");//出入库成功标志
	        	cusDTO.setCheckFlag("0");//审核标志
	        	cusDTO.setInOutFlag("0");//出入库成功标志
	        	
	        	itemNo = itemNo + 1;
	        	odsCustomerOrderDAO.save(cusDTO);//新增 移库单
        	} catch (Exception e) {
        		log.error("创建用户订单失败：customerOrderNo:"+ dto.getCtrOrderNo()+",plant:"+dto.getPlant()+",materialNo:"+dto.getMaterialNo()+"");
        		flag = "fail";
        	}
        }
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#deleteCustomerOrderByCusNo(java.lang.String)
	 */
	@Override
	public String deleteCustomerOrderByCusNo(String cusNo) {
		try {
			odsCustomerOrderDAO.deleteCustomerOrderByCusNo(cusNo);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#deleteCustomerOrderByIds(java.util.List)
	 */
	@Override
	public String deleteCustomerOrderByIds(List<Long> idList) {
		try {
			odsCustomerOrderDAO.deleteAll(idList);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerOrderService#customerApprove(java.lang.String, java.lang.String)
	 */
	@Override
	public String customerApprove(String cusNo, String modifyBy) {
		try {
			odsCustomerOrderDAO.customerApprove(cusNo,modifyBy);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#checkCustomerOrder(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO)
	 */
	@Override
	public OrderCheckOutDTO checkCustomerOrder(OrderCheckInDTO inpara) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		out.setStatus("S");
		out.setMsg("Order has been download, please scan!");
		String result = odsCustomerOrderDAO.checkCustomerOrderExist(inpara);
		if ("1".equals(result)) {
			UserDTO user = userDAO.getUserByName(inpara.getUser());
			if ("3".equals(user.getDutyType())) {
				// 检查用户是否有该仓库扫描权限
				result = odsCustomerOrderDAO.checkCustomerLoc(inpara, user.getId());
				if (!"Y".equals(result)){
					out.setStatus("F");
					out.setMsg("User has no authority to scan this order!");
				} 
			}
		} else if(StringUtils.isBlank(result)) {
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

	/* (非 Javadoc) 
	* <p>Title: updatePrintFlag</p> 
	* <p>Description: </p> 
	* @param orderNo 
	* @see com.haier.hevwms.customer.service.OdsCustomerOrderService#updatePrintFlag(java.lang.String) 
	*/
	@Override
	public void updatePrintFlag(String orderNo, String userName) {
		odsCustomerOrderDAO.updatePrintFlag(orderNo, userName);
		
	}
}

package com.haier.hevwms.sto.service.impl;


import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.sto.dao.OdsStoCustDAO;
import com.haier.hevwms.sto.service.OdsStoCustService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**  
 * @Title:  OdsStoCustServiceImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0 
 */  
public class OdsStoCustServiceImpl implements OdsStoCustService {
	
	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsStoCustServiceImpl.class);
	
	private OdsStoCustDAO odsStoCustDAO;
	private UserDAO userDAO;
	
	public OdsStoCustDAO getOdsStoCustDAO() {
		return odsStoCustDAO;
	}

	public void setOdsStoCustDAO(OdsStoCustDAO odsStoCustDAO) {
		this.odsStoCustDAO = odsStoCustDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#searchOdsStoCusts(long, long, com.haier.openplatform.wms.customer.dto.OdsStoCustDTO)
	 */
	@Override
	public Pager<OdsStoCustDTO> searchOdsStoCusts(Pager<OdsStoCustDTO> pager, OdsStoCustDTO odsStoCustDTO) {
		List<OdsStoCustDTO> dtoList = odsStoCustDAO.searchOdsStoCusts(pager, odsStoCustDTO);
		long size = odsStoCustDAO.searchOdsStoCustsCount(odsStoCustDTO);
		return Pager.cloneFromPager(pager, size, dtoList);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#searchOdsStoCustsCount(com.haier.openplatform.wms.customer.dto.OdsStoCustDTO)
	 */
	@Override
	public Long searchOdsStoCustsCount(OdsStoCustDTO odsStoCustDTO) {
		return odsStoCustDAO.searchOdsStoCustsCount(odsStoCustDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#getStoCustNo()
	 */
	@Override
	public String getStoCustNo() {
		String seq = odsStoCustDAO.selectOdsStoCustNo();
		return seq;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#addStoCustInfo(com.haier.openplatform.wms.customer.dto.OdsStoCustDTO, java.util.List)
	 */
	@Override
	public String addStoCustInfo(OdsStoCustDTO dto, List<OdsStoCustDTO> list) {
		String flag = "success";
        int itemNo = 1;
        
    	//遍历,插入数据库中
        for(OdsStoCustDTO mat : list){
        	try {
        		OdsStoCustDTO stoDTO = new OdsStoCustDTO();
        		stoDTO.setStoNo(dto.getStoNo());
        		stoDTO.setStoItemNo(new DecimalFormat("0000").format(itemNo));
        		stoDTO.setGiPlant(dto.getGiPlant());
				stoDTO.setGrPlant(dto.getGrPlant());
				stoDTO.setGiLocation(dto.getGiLocation());
				stoDTO.setGrLocation(dto.getGrLocation());
				stoDTO.setMaterialNo(mat.getMaterialNo());
				stoDTO.setMaterialDesp(mat.getMaterialDesp());
				stoDTO.setUnit(mat.getBasicUnit());
				stoDTO.setQty(mat.getQty());
				stoDTO.setGiFinishQty(0L);
				stoDTO.setGiFinishFlag("0");
				stoDTO.setGrFinishQty(0L);
				stoDTO.setGrFinishFlag("0");
				stoDTO.setRemark(dto.getRemark());
				stoDTO.setCreateBy(dto.getCreateBy());
				stoDTO.setCreateDate(new Date());
				stoDTO.setItemDelete("0");
				stoDTO.setFlag("0");
				stoDTO.setCheckFlag("0");
				stoDTO.setInFlag("0");
				stoDTO.setOutFlag("0");

	        	itemNo = itemNo + 1;
	        	odsStoCustDAO.save(stoDTO);//新增 移库单
        	} catch (Exception e) {
        		e.printStackTrace();
        		log.error("创建STO CUSTOMER订单失败：StoCustNo:"+ dto.getStoNo()+",materialNo:"+dto.getMaterialNo()+"");
        		flag = "fail";
        	}
        }
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#deleteStoCustByCusNo(java.lang.String)
	 */
	@Override
	public String deleteStoCustByNo(String stoNo) {
		try {
			odsStoCustDAO.deleteStoCustByNo(stoNo);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#deleteStoCustByIds(java.util.List)
	 */
	@Override
	public String deleteStoCustByIds(List<Long> idList) {
		try {
			odsStoCustDAO.deleteAll(idList);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsStoCustService#customerApprove(java.lang.String, java.lang.String)
	 */
	@Override
	public String stoApprove(String stoNo, String modifyBy) {
		try {
			odsStoCustDAO.stoApprove(stoNo,modifyBy);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#checkStoCust(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO)
	 */
	@Override
	public OrderCheckOutDTO checkStoCust(OrderCheckInDTO inpara) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		out.setStatus("S");
		String msg = "Success";
		String result = odsStoCustDAO.checkStoCustExist(inpara);
		if ("1".equals(result)) {
			UserDTO user = userDAO.getUserByName(inpara.getUser());
			if ("3".equals(user.getDutyType())) {
				// 检查用户是否有该仓库扫描权限
				result = odsStoCustDAO.checkStoCustLoc(inpara, user.getId());
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

	@Override
	public List<OdsStoCustDTO> scanStatus(String stoNo) {
		return odsStoCustDAO.scanStatus(stoNo);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#orderOgp(com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn)
	 */
	@Override
	public WmsOrderIgpOut orderOgp(WmsOrderIgpIn in) {
		WmsOrderIgpOut out = new WmsOrderIgpOut();
		if ("1".equals(in.getOrderType())){
			odsStoCustDAO.orderOgpIn(in, out);
		}
		if ("2".equals(in.getOrderType())){
			odsStoCustDAO.orderOgpOut(in, out);
		}
		return out;
	}

	@Override
	public void updateOgpInfo(OrderIgpInDTO inpara) {
		if ("1".equals(inpara.getOrderType())) {
			odsStoCustDAO.updateOgpInInfo(inpara);
		}
		if ("2".equals(inpara.getOrderType())) {
			odsStoCustDAO.updateOgpOutInfo(inpara);
		}
	}
}

package com.haier.hevwms.transfer.service.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.transfer.dao.OdsTransferInfoDAO;
import com.haier.hevwms.transfer.service.OdsTransferInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;

/**  
 * @Title:  OdsTransferInfoServiceImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:17:45   
 * @version V1.0 
 */  
public class OdsTransferInfoServiceImpl implements OdsTransferInfoService{

	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsTransferInfoServiceImpl.class);
	
	private OdsTransferInfoDAO odsTransferInfoDAO;
	private UserDAO userDAO;

	public OdsTransferInfoDAO getOdsTransferInfoDAO() {
		return odsTransferInfoDAO;
	}

	public void setOdsTransferInfoDAO(OdsTransferInfoDAO odsTransferInfoDAO) {
		this.odsTransferInfoDAO = odsTransferInfoDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#searchTransferInfos(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO)
	 */
	@Override
	public Pager<OdsTransferInfoDTO> searchTransferInfos(Pager<OdsTransferInfoDTO> pager,OdsTransferInfoDTO odsTransferInfoDTO) {
		List<OdsTransferInfoDTO> odsTransDTO = odsTransferInfoDAO.searchOdsTransferInfos(pager, odsTransferInfoDTO);
		long size = odsTransferInfoDAO.searchOdsTransferInfosCount(odsTransferInfoDTO);
		return Pager.cloneFromPager(pager, size, odsTransDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#getTransferOrderNo()
	 */
	@Override
	public String getTransferOrderNo() {
		String seq = odsTransferInfoDAO.selectOdsTransferInfoNo();
		return seq;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#addTransferInfo(com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO)
	 */
	@Override
	public String addTransferInfo(OdsTransferInfoDTO dto,List<OdsTransferInfoDTO> list) {
		String flag = "success";
        int itemNo = 1;
        
    	//遍历,插入数据库中
        for(OdsTransferInfoDTO mat : list){
        	try {
        		OdsTransferInfoDTO transDto = new OdsTransferInfoDTO(); 
	        	transDto.setTransNo(dto.getTransNo());
	        	transDto.setTransItemNo(new DecimalFormat("0000").format(itemNo));
	        	transDto.setQty(mat.getQty());
	        	transDto.setMaterialNo(mat.getMaterialNo());
	        	transDto.setMaterialDesp(mat.getMaterialDesp());
	        	transDto.setCustomerModel(mat.getCustomerModel());
	        	transDto.setUnit(mat.getBasicUnit());
	        	transDto.setWarehouseCode(dto.getWarehouseCode());
	        	transDto.setWarehouseName(dto.getWarehouseName());
	        	transDto.setPlant(dto.getPlant());
	        	transDto.setGrLocation(dto.getGrLocation());
	        	transDto.setGiLocation(mat.getGiLocation());
	        	transDto.setCreateBy(dto.getCreateBy());
	        	transDto.setCreateDate(new Date());//移库单创建时间
	        	transDto.setModifyDate(new Date());
	        	transDto.setBeginDate(new Date());
	        	transDto.setEndDate(new Date());
	        	transDto.setTransClose("0");
	        	transDto.setFlag("0");
	        	transDto.setGiFlag("0");
	        	transDto.setFinishFlag("0");
	        	transDto.setFinishQty(0L);
	        	transDto.setCheckFlag("0");
	        	transDto.setSapFlag("0");
	        	
	        	itemNo = itemNo + 1;
	        	odsTransferInfoDAO.save(transDto);//新增 移库单
        	} catch (Exception e) {
        		log.error("创建移库单失败：transNo:"+dto.getTransNo()+",plant:"+dto.getPlant()+",location:"+dto.getGiLocation() + ",materialNo:"+dto.getMaterialNo()+"");
        		flag = "fail";
        	}
        }
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#deleteTransferInfoByTransNo(java.lang.String)
	 */
	public String deleteTransferInfoByTransNo(String transNo) {
		try {
			odsTransferInfoDAO.deleteTransferInfoByTransNo(transNo);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#deleteTransferInfoByIds(java.lang.String)
	 */
	@Override
	public String deleteTransferInfoByIds(List<Long> idList) {
		try {
			odsTransferInfoDAO.deleteAll(idList);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#transferApprove(java.lang.String)
	 */
	public String transferApprove(String transNo,String modifyBy) {
		try {
			odsTransferInfoDAO.transferApprove(transNo,modifyBy);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#searchOdsTransferInfosCount(com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO)
	 */
	@Override
	public Long searchOdsTransferInfosCount(OdsTransferInfoDTO odsTransferInfoDTO) {
		return odsTransferInfoDAO.searchOdsTransferInfosCount(odsTransferInfoDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferInfoService#checkTransferInfo(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO)
	 */
	@Override
	public OrderCheckOutDTO checkTransferInfo(OrderCheckInDTO inpara) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String msg = "";
		String status = "F";
		UserDTO user = userDAO.getUserByName(inpara.getUser());
		String result = odsTransferInfoDAO.checkTransferOrderExist(inpara);
		if ("1".equals(result)) {
			if ("3".equals(user.getDutyType())){
				result = odsTransferInfoDAO.checkTransferLoc(inpara, user.getId());
				if (!"Y".equals(result)){
					msg = "User has no authority to scan this order!";
				}
			}
			if (StringUtils.isBlank(msg)) {
				status = "S";
			}
		}else if(result == null || "".equals(result)) {
			msg = "Order doens't exist!";
		} else if("0".equals(result)){
			msg = "Order need approve!";
		} else if ("2".equals(result)){
			msg = "Order approve confused!";
		}
		out.setStatus(status);
		out.setMsg(msg);
		return out;
	}

	@Override
	public List<OdsTransferInfoDTO> scanStatus(String orderNo) {
		return odsTransferInfoDAO.scanStatus(orderNo);
	}
	
}

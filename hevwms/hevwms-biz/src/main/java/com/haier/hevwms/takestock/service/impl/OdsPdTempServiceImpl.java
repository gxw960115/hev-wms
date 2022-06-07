package com.haier.hevwms.takestock.service.impl;

import java.util.List;

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;
import com.haier.hevwms.takestock.dao.OdsPdTempDAO;
import com.haier.hevwms.takestock.dao.OdsPdTempDtlDAO;
import com.haier.hevwms.takestock.service.OdsPdTempService;
import com.haier.hevwms.util.ToJsonUtil;

import net.sf.json.JSONObject;

public class OdsPdTempServiceImpl implements OdsPdTempService {
	
	private OdsPdTempDAO odsPdTempdao;
	
	private OdsPdTempDtlDAO odsPdTempDtlDao;
	

	/**
	 * 
	* <p>Title: addPdTempOrder</p>
	* <p>Description: </p>  增加临时盘点单
	* @param pdTempDTO
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdTempService#addPdTempOrder(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */
	@Override
	public String addPdTempOrder(OdsPdTempDTO pdTempDTO) {
		int num=odsPdTempdao.add(pdTempDTO);
		return num>0?"Success":"Failed";
	}
	
	/**
	 * 
	* <p>Title: updateOrderStatus</p>
	* <p>Description: </p> 更新状态
	* @param pdTempDTO
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdTempService#updateOrderStatus(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */
	@Override
	public String updateOrderStatus(OdsPdTempDTO pdTempDTO) {
		int num=odsPdTempdao.updateStatus(pdTempDTO);
		if ("3".equals(pdTempDTO.getStatus())) {
			odsPdTempDtlDao.deleteByorderNo(pdTempDTO.getRowId());
		}
		return num>0?"Success":"Failed";
	}
	
	/**
	 * 
	* <p>Title: searchOdsPdTemps</p>
	* <p>Description: </p> 分页查询
	* @param pdTempDTO
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdTempService#searchOdsPdTemps(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */
	@Override
	public JSONObject searchOdsPdTemps(OdsPdTempDTO pdTempDTO , Long pageSize, Long currentPage) {
		Long firstResult=pageSize*(currentPage-1);
		List<OdsPdTempDTO> list=odsPdTempdao.searchOdsPdTempDTOs(pdTempDTO, firstResult, pageSize);
		Long count=odsPdTempdao.searchOdsPdTempDTOsCount(pdTempDTO);
		return ToJsonUtil.getJsonObject(list, count.longValue());
	}
	
	/**
	 * 
	* @Title: orderCheck
	* @Description: 检查订单是否存在
	* @param @param orderNo
	* @param @return
	* @return String
	* @throws
	 */
	@Override
	public String orderCheck(String orderNo) {
		String msg="";
		OdsPdTempDTO pdTempDTO = new OdsPdTempDTO();
		pdTempDTO.setOrderNo(orderNo);
		Long count=odsPdTempdao.searchOdsPdTempDTOsCount(pdTempDTO);
		if (count.longValue() == 1) {
			List<OdsPdTempDTO> list = odsPdTempdao.searchOdsPdTempDTOs(pdTempDTO, 0L, 1L);
			pdTempDTO=list.get(0);
			String status=pdTempDTO.getStatus();
			if("0".equals(status)) {
				msg="Please Open the Order:"+orderNo+",at Stock Audit Temp.";
			}else if ("2".equals(status)) {
				msg="Order has Closed.";
			} else if ("3".equals(status)) {
				msg="Order has Been Deleted.";
			}else {
				msg= "S";
			}
		} else if (count.longValue() <1) {
			msg = "Order Not Exist";
		} else {
			msg = "Order Repeat,Please Delete Extra";
		}
		return msg;
	}

	public void setOdsPdTempdao(OdsPdTempDAO odsPdTempdao) {
		this.odsPdTempdao = odsPdTempdao;
	}

	public void setOdsPdTempDtlDao(OdsPdTempDtlDAO odsPdTempDtlDao) {
		this.odsPdTempDtlDao = odsPdTempDtlDao;
	}
	
}

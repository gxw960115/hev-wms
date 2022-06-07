package com.haier.hevwms.sto.service;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;

import java.util.List;

/**
 * @Title:  OdsStoCustService.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0 
 */  
public interface OdsStoCustService {

	/**
	* @Title: searchOdsStoCusts
	* @Description: TODO(分页查询用户订单)
	* @author zhangll
	* @param page
	* @param rows
	* @param odsStoCustDTO
	* @return Pager<OdsStoCustDTO>
	* @throws
	*/
	public Pager<OdsStoCustDTO> searchOdsStoCusts(Pager<OdsStoCustDTO> page, OdsStoCustDTO odsStoCustDTO);

	/**
	* @Title: searchOdsStoCustsCount
	* @Description: TODO(统计用户订单数量)
	* @author zhangll
	* @param odsStoCustDTO
	* @return Long
	* @throws
	*/
	public Long searchOdsStoCustsCount(OdsStoCustDTO odsStoCustDTO);

	/**
	* @Title: getStoCustNo
	* @Description: TODO(获取用户订单号)
	* @author zhangll
	* @return String
	* @throws
	*/
	public String getStoCustNo();

    /**
    * @Title: addStoCustInfo
    * @Description: TODO(添加用户订单信息)
    * @author zhangll
    * @param odsStoCustDTO
    * @param msg
    * @return String
    * @throws
    */
    public String addStoCustInfo(OdsStoCustDTO odsStoCustDTO, List<OdsStoCustDTO> msg);

	/**
	* @Title: deleteStoCustByCusNo
	* @Description: TODO(删除用户订单信息)
	* @author zhangll
	* @param cusNo
	* @return String
	* @throws
	*/
	public String deleteStoCustByNo(String cusNo);

	/**
	* @Title: deleteStoCustByIds
	* @Description: TODO(删除用户订单信息)
	* @author zhangll
	* @param idList
	* @return String
	* @throws
	*/
	public String deleteStoCustByIds(List<Long> idList);
	/**
	* @Title: customerApprove
	* @Description: TODO(审批用户订单)
	* @author zhangll
	* @param stoNo
	* @param modifyBy
	* @return String
	* @throws
	*/
	public String stoApprove(String stoNo, String modifyBy);
	
	/**  
	* @Title: checkStoCust  
	* @Description: 检查用户订单是否存在
	* @author: ZhangLL
	* @param inpara
	* @return OrderCheckOutDTO
	* @throws  
	*/
	public OrderCheckOutDTO checkStoCust(OrderCheckInDTO inpara);

	/**
	 * @Title: checkStoCust
	 * @Description: 检查用户订单是否存在
	 * @author: ZhangLL
	 * @param inpara
	 * @return OrderCheckOutDTO
	 * @throws
	 */
    public List<OdsStoCustDTO> scanStatus(String orno);

	/**
	 * @Title: orderOgp
	 * @Description: 调用OGP存储过程
	 * @author: ZhangLL
	 * @param inpara
	 * @return WmsOrderIgpIn
	 * @throws
	 */
	public WmsOrderIgpOut orderOgp(WmsOrderIgpIn in);

	/**
	 * @Title: updateOgpInfo
	 * @Description: 保存OGP填写信息
	 * @author: ZhangLL
	 * @param inpara
	 * @return OrderIgpInDTO
	 * @throws
	 */
	void updateOgpInfo(OrderIgpInDTO inpara);
}

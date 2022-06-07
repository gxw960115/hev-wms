package com.haier.openplatform.wms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Title:  OdsStoCustServiceClient.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0 
 */  
public interface OdsStoCustServiceClient {

	/**
	* @Title: searchOdsStoCusts
	* @Description: TODO(分页查询用户订单)
	* @author zhangll
	* @param page
	* @param row
	* @param odsStoCustDTO
	* @return Pager<OdsStoCustDTO>
	* @throws
	*/
	public Pager<OdsStoCustDTO> searchOdsStoCusts(long page, long row, OdsStoCustDTO odsStoCustDTO);

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
	* @Title: deleteStoCustBystoNo
	* @Description: TODO(删除用户订单信息)
	* @author zhangll
	* @param stoNo
	* @return String
	* @throws
	*/
	public String deleteStoCustByNo(String stoNo);

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
	* @Title: orderCheck  
	* @Description: 订单检测
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderCheckOutDTO
	* @throws  
	*/
	public OrderCheckOutDTO orderCheck(OrderCheckInDTO inpara, String version);

	/**
	 * @Title: orderIgp
	 * @Description: 手持出库
	 * @author: ZhangLL
	 * @param inpara
	 * @return OrderIgpOutDTO
	 * @throws
	 */
	public OrderIgpOutDTO orderOgp(OrderIgpInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;

}

package com.haier.hevwms.customer.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;

/**  
 * @Title:  OdsCustomerOrderService.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 上午11:08:30   
 * @version V1.0 
 */  
public interface OdsCustomerOrderService {
	
	/**  
	* @Title: searchOdsCustomerOrders  
	* @Description: TODO(分页查询用户订单)  
	* @author zhangll
	* @param page
	* @param rows
	* @param odsCustomerOrderDTO
	* @return Pager<OdsCustomerOrderDTO>
	* @throws  
	*/
	public Pager<OdsCustomerOrderDTO> searchOdsCustomerOrders(Pager<OdsCustomerOrderDTO> page, OdsCustomerOrderDTO odsCustomerOrderDTO);

	/**  
	* @Title: searchOdsCustomerOrdersCount  
	* @Description: TODO(统计用户订单数量)  
	* @author zhangll
	* @param odsCustomerOrderDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsCustomerOrdersCount(OdsCustomerOrderDTO odsCustomerOrderDTO);
	
	/**  
	* @Title: getCustomerOrderNo  
	* @Description: TODO(获取用户订单号)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	public String getCustomerOrderNo();
    
    /**  
    * @Title: addCustomerOrderInfo  
    * @Description: TODO(添加用户订单信息)  
    * @author zhangll
    * @param odsCustomerOrderDTO
    * @param msg
    * @return String
    * @throws  
    */
    public String addCustomerOrderInfo(OdsCustomerOrderDTO odsCustomerOrderDTO,List<OdsCustomerOrderDTO> msg); 

	/**  
	* @Title: deleteCustomerOrderByCusNo  
	* @Description: TODO(删除用户订单信息)  
	* @author zhangll
	* @param cusNo
	* @return String
	* @throws  
	*/
	public String deleteCustomerOrderByCusNo(String cusNo);
	
	/**  
	* @Title: deleteCustomerOrderByIds  
	* @Description: TODO(删除用户订单信息)  
	* @author zhangll
	* @param idList
	* @return String
	* @throws  
	*/
	public String deleteCustomerOrderByIds(List<Long> idList);	
	/**  
	* @Title: customerApprove  
	* @Description: TODO(审批用户订单)  
	* @author zhangll
	* @param cusNo
	* @param modifyBy
	* @return String
	* @throws  
	*/
	public String customerApprove(String cusNo,String modifyBy);
	
	/**  
	* @Title: checkCustomerOrder  
	* @Description: 检查用户订单是否存在
	* @author: ZhangLL
	* @param inpara
	* @return OrderCheckOutDTO
	* @throws  
	*/
	public OrderCheckOutDTO checkCustomerOrder(OrderCheckInDTO inpara);
	
	/** 
	* @Title: updatePrintFlag 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo    设定文件 
	* @author SJK
	* @date 2019年9月17日
	* @return void    返回类型 
	* @throws 
	*/
	public void updatePrintFlag(String orderNo, String userName);
}

package com.haier.openplatform.wms.customer.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;

/**  
 * @Title:  OdsCustomerOrderServiceClient.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午2:35:47   
 * @version V1.0 
 */  
public interface OdsCustomerOrderServiceClient {

	/**  
	* @Title: searchOdsCustomerOrders  
	* @Description: TODO(分页查询用户订单)  
	* @author zhangll
	* @param page
	* @param row
	* @param odsCustomerOrderDTO
	* @return Pager<OdsCustomerOrderDTO>
	* @throws  
	*/
	public Pager<OdsCustomerOrderDTO> searchOdsCustomerOrders(long page, long row, OdsCustomerOrderDTO odsCustomerOrderDTO);

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
    * @Title: printDetail 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param filePath
    * @param @param parameters
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年9月17日
    * @return byte[]    返回类型 
    * @throws 
    */
    public byte[] printDetail(String filePath, Map<String, Object> parameters) ;
}

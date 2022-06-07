package com.haier.hevwms.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;

/**  
 * @Title:  OdsCustomerOrderDAO.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 上午11:04:27   
 * @version V1.0 
 */  
public interface OdsCustomerOrderDAO extends CommonDAO<OdsCustomerOrderDTO, Long> {
	
	/**
	 * @Title: deleteAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author zhangll 
	 * @param idList void 
	 * @throws
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**  
	* @Title: deleteCustomerOrderByCusNo  
	* @Description: TODO(删除订单信息)  
	* @author zhangll
	* @param cusNo void
	* @throws  
	*/
	public void deleteCustomerOrderByCusNo(@Param("ctrOrderNo") String cusNo);
	
	/**  
	* @Title: customerApprove  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param cusNo
	* @param modifyBy void
	* @throws  
	*/
	public void customerApprove(@Param("ctrOrderNo") String cusNo,@Param("modifyBy") String modifyBy);
	
	/**
	 * @Title: selectOdsCustomerOrderNo 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author zhangll 
	 * @return String 
	 * @throws
	 */
	public String selectOdsCustomerOrderNo();

	/**  
	* @Title: searchOdsCustomerOrders  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param pager
	* @param odsCustomerOrder
	* @return List<OdsCustomerOrder>
	* @throws  
	*/
	public List<OdsCustomerOrderDTO> searchOdsCustomerOrders(@Param("pager") Pager<OdsCustomerOrderDTO> pager,
			@Param("odsCustomerOrder") OdsCustomerOrderDTO odsCustomerOrderDTO);
	
	/**  
	* @Title: searchOdsCustomerOrdersCount  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param odsCustomerOrderDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsCustomerOrdersCount(@Param("odsCustomerOrder") OdsCustomerOrderDTO odsCustomerOrderDTO);
	
	/**  
	* @Title: checkCustomerOrderExist  
	* @Description: 检查订单是否存在
	* @author: ZhangLL
	* @param inpara
	* @return String
	* @throws  
	*/
	public String checkCustomerOrderExist(@Param("inpara") OrderCheckInDTO inpara);
	
	/**  
	* @Title: checkCustomerLoc  
	* @Description: 检测用户是否有当前地点的扫描权限
	* @author: ZhangLL
	* @param inpara
	* @param userId
	* @return String
	* @throws  
	*/
	public String checkCustomerLoc(@Param("inpara") OrderCheckInDTO inpara, @Param("userId") Long userId);
	
	/**  
	* @Title: getCustomerLocations  
	* @Description: 根据订单号获取所有location
	* @author: ZhangLL
	* @param orderNo
	* @return List<String>
	* @throws  
	*/
	public List<String> getCustomerLocation(@Param("orderNo")String orderNo);
	
	/** 
	* @Title: updatePrintFlag 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo    设定文件 
	* @author SJK
	* @date 2019年9月17日
	* @return void    返回类型 
	* @throws 
	*/
	public void updatePrintFlag(@Param("orderNo")String orderNo, @Param("userName")String userName);
}
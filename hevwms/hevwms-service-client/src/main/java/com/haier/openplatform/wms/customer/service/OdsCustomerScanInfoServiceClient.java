package com.haier.openplatform.wms.customer.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**  
 * @Title:  OdsCustomerScanInfoServiceClient.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:20:06   
 * @version V1.0 
 */  
public interface OdsCustomerScanInfoServiceClient {
	
	/**  
	* @Title: searchOdsCustomerScanInfos  
	* @Description: TODO(分页查询用户订单)  
	* @author zhangll
	* @param page
	* @param rows
	* @param odsCustomerScanInfoDTO
	* @return Pager<OdsCustomerScanInfoDTO>
	* @throws  
	*/
	public Pager<OdsCustomerScanInfoDTO> searchOdsCustomerScanInfos(long page, long rows, OdsCustomerScanInfoDTO odsCustomerScanInfoDTO);

	/**  
	* @Title: searchOdsCustomerScanInfosCount  
	* @Description: TODO(统计用户订单数量)  
	* @author zhangll
	* @param odsCustomerScanInfoDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsCustomerScanInfosCount(OdsCustomerScanInfoDTO odsCustomerScanInfoDTO);
   	
	/**  
	* @Title: orderDelete  
	* @Description: 订单删除,手持
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderDeleteOutDTO
	* @throws  
	*/
	public OrderDeleteOutDTO orderDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;

	/**  
	* @Title: orderScan  
	* @Description: 手持扫码
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderUploadOutDTO
	* @throws  
	*/
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;

	/**  
	* @Title: orderIgp  
	* @Description: 手持出库
	* @author: ZhangLL
	* @param inpara
	* @return OrderIgpOutDTO
	* @throws  
	*/
	public OrderIgpOutDTO orderOgp(OrderIgpInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException ;
	/**  
	 * @Title: orderIgp  
	 * @Description: 后台手动出库
	 * @author: ZhangLL
	 * @param inpara
	 * @param version
	 * @return OrderIgpOutDTO
	 * @throws  
	 */
	public OrderIgpOutDTO orderDelivery(OrderIgpInDTO inpara) throws IllegalAccessException, InvocationTargetException ;
	/**  
	* @Title: barcodeList  
	* @Description: 查询订单已扫描信息
	* @author: ZhangLL
	* @param inpara
	* @return WmsOrderDelListOutDTO
	* @throws  
	*/
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara);

    /** 
    * @Title: ordersDelete 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param inpara
    * @param @param version
    * @param @return
    * @param @throws IllegalAccessException
    * @param @throws InvocationTargetException    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return OrderDeleteOutDTO    返回类型 
    * @throws 
    */
    public OrderDeleteOutDTO ordersDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;
    
}

package com.haier.hevwms.customer.service;

import java.util.List;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**  
 * @Title:  OdsCustomerScanInfoService.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 上午11:12:02   
 * @version V1.0 
 */  
public interface OdsCustomerScanInfoService {

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
	public Pager<OdsCustomerScanInfoDTO> searchOdsCustomerScanInfos(Pager<OdsCustomerScanInfoDTO> page, OdsCustomerScanInfoDTO odsCustomerScanInfoDTO);

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
	* @Title: getListByParams  
	* @Description: 查询手持详细列表信息
	* @author: ZhangLL
	* @param odsCustomerScanInfo
	* @return List<OdsCustomerScanInfoDTO>
	* @throws  
	*/
	public List<OdsCustomerScanInfoDTO> getListByParams(OdsCustomerScanInfoDTO odsCustomerScanInfo);

	/**  
	* @Title: scanCustomer  
	* @Description: 用户订单信息扫描
	* @author: ZhangLL
	* @param inpara
	* @return OrderUploadOutDTO
	* @throws  
	*/
	public OrderUploadOutDTO scanCustomer(OrderUploadInDTO inpara);

	/**  
	* @Title: orderDelete  
	* @Description: 删除扫描信息
	* @author: ZhangLL
	* @param in
	* @return WmsOrderDeleteOut
	* @throws  
	*/
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in);
	
	/**  
	* @Title: orderIgp  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param in
	* @return WmsOrderIgpOut
	* @throws  
	*/
	public WmsOrderIgpOut orderOgp(WmsOrderIgpIn in);
	
}

package com.haier.openplatform.wms.transfer.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;

import java.lang.reflect.InvocationTargetException;

/**  
 * @Title:  OdsTransferDtlServiceClient.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午2:55:10   
 * @version V1.0 
 */  
public interface OdsTransferDtlServiceClient {

	/**  
	* @Title: searchOdsTransferDtls  
	* @Description: TODO(查询列表信息)  
	* @author zhangll
	* @param page
	* @param rows
	* @param odsTransferDtlDTO
	* @return Pager<OdsTransferDtlDTO>
	* @throws  
	*/
	public Pager<OdsTransferDtlDTO> searchOdsTransferDtls(long page, long rows, OdsTransferDtlDTO odsTransferDtlDTO);
	
	/**  
	* @Title: searchOdsTransferDtlsCount  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param odsTransferDtlDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsTransferDtlsCount(OdsTransferDtlDTO odsTransferDtlDTO);

	/**  
	* @Title: orderDelete  
	* @Description: 订单删除
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderDeleteOutDTO
	* @throws  
	*/
	public OrderDeleteOutDTO orderDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException ;

	/**
	* @Title: orderDelete
	* @Description: 订单删除
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderDeleteOutDTO
	* @throws
	*/
	public OrderDeleteOutDTO ordersDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException ;

	/**  
	* @Title: barcodeList  
	* @Description: 订单扫描列表
	* @author: ZhangLL
	* @param inpara
	* @return WmsOrderDelListOutDTO
	* @throws  
	*/
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara);

	/**  
	* @Title: orderOgp  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @param sapFlag
	* @return OrderIgpOutDTO
	* @throws  
	*/
	public OrderIgpOutDTO orderOgp(OrderIgpInDTO inpara, String version,String sapFlag) throws IllegalAccessException, InvocationTargetException ;

	/**  
	* @Title: orderScan  
	* @Description: 订单扫描
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderUploadOutDTO
	* @throws  
	*/
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException ;

	/**  
	* @Title: orderPosting  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param inpara
	* @param sapFlag
	* @return
	* @throws IllegalAccessException
	* @throws InvocationTargetException OrderIgpOutDTO
	* @throws  
	*/
	public OrderIgpOutDTO orderPosting(OrderIgpInDTO inpara, String giLocation, String grLocation, String sapFlag) throws IllegalAccessException, InvocationTargetException ;
}

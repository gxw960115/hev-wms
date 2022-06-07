package com.haier.openplatform.wms.customer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.customer.service.OdsCustomerStockService;
import com.haier.openplatform.wms.customer.service.OdsCustomerStockServiceClient;
 
/**  
 * @Title:  OdsCustomerStockServiceClientImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:42:28   
 * @version V1.0 
 */  
public class OdsCustomerStockServiceClientImpl implements OdsCustomerStockServiceClient {

	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsCustomerStockServiceClientImpl.class);
	
	private OdsCustomerStockService odsCustomerStockService;

	public OdsCustomerStockService getOdsCustomerStockService() {
		return odsCustomerStockService;
	}

	public void setOdsCustomerStockService(OdsCustomerStockService odsCustomerStockService) {
		this.odsCustomerStockService = odsCustomerStockService;
	}
	
}

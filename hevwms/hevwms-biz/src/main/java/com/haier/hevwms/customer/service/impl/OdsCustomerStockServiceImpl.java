package com.haier.hevwms.customer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.customer.dao.OdsCustomerStockDAO;
import com.haier.hevwms.customer.service.OdsCustomerStockService;

/**  
 * @Title:  OdsCustomerStockServiceImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 上午11:12:34   
 * @version V1.0 
 */  
public class OdsCustomerStockServiceImpl implements OdsCustomerStockService {

	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsCustomerOrderServiceImpl.class);
	
	private OdsCustomerStockDAO odsCustomerStockDAO;

	public OdsCustomerStockDAO getOdsCustomerStockDAO() {
		return odsCustomerStockDAO;
	}

	public void setOdsCustomerStockDAO(OdsCustomerStockDAO odsCustomerStockDAO) {
		this.odsCustomerStockDAO = odsCustomerStockDAO;
	}
	
}

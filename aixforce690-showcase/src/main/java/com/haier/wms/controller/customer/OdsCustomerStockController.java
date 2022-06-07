package com.haier.wms.controller.customer;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.haier.openplatform.wms.customer.service.OdsCustomerStockServiceClient;
 
/**  
 * @Title:  OdsCustomerStockController.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:44:05   
 * @version V1.0 
 */  
@Controller
public class OdsCustomerStockController {

	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/
	private static Logger log = LoggerFactory.getLogger(OdsCustomerStockController.class);
	
	/**  
	* @Fields field:field:{todo}(dubbo接口)  
	*/
	@Resource
	private OdsCustomerStockServiceClient odsCustomerStockServiceClient;

}

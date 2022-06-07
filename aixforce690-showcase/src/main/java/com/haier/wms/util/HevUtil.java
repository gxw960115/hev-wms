package com.haier.wms.util;

/**  
 * @Title: HevUtil.java   
 * @Package: com.haier.wms.util   
 * @Description: 工具类
 * @author: ZhangLL
 * @date: 2018年11月20日 上午10:38:45   
 * @version: V1.0 
 */
public class HevUtil {

	/**
	* @Title: orderNoFormat
	* @Description: 前台传来的order no 拼成10位
	* @param @param orderNo
	* @param @return
	* @return String
	*/
	public static String orderNoFormat(String orderNo){
	    String orno="0000000000"+orderNo;
	    return orno.substring(orno.length()-10, orno.length());
	}
	
}



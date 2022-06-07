package com.haier.openplatform.wms.security.service;



public interface SystemConfigServiceClient {
	
	/** 
	* @Title: fifoConfig 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param fifoFlag
	* @param @param fifoPeroid
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String fifoConfig(String fifoFlag, String fifoPeroid);
}
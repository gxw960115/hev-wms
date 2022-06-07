package com.haier.openplatform.wms.po.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import com.haier.openplatform.wms.remoting.dto.OrderDirectDispatchOutDTO;
import io.terminus.pampas.client.Export;

import com.haier.openplatform.showcase.util.Paging;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsOrderInfoDtlServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月16日 下午4:09:47
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月16日		LJZ			v1.0.0			edit
 */
public interface OdsOrderInfoDtlServiceClient {
    
  	/** 
  	* @Title: searchOdsOrderDtls 
  	* @Description: TODO(这里用一句话描述这个方法的作用) 
  	* @param @param page
  	* @param @param rows
  	* @param @param odsOrderInfoDtlDTO
  	* @param @return    设定文件 
  	* @author SJK
  	* @date 2019年3月18日
  	* @return Pager<OdsOrderInfoDtlDTO>    返回类型 
  	* @throws 
  	*/
  	@Export(paramNames={"page","rows","odsOrderInfoDtlDTO"})
  	public Pager<OdsOrderInfoDtlDTO> searchOdsOrderDtls(Long page, Long rows,OdsOrderInfoDtlDTO odsOrderInfoDtlDTO);
  	
  	/** 
  	* @Title: serchOdsOrderDtlsBy 
  	* @Description: TODO(这里用一句话描述这个方法的作用) 
  	* @param @param no
  	* @param @param materialNo
  	* @param @param createDateStart
  	* @param @param createDateEnd
  	* @param @return    设定文件 
  	* @author SJK
  	* @date 2019年3月18日
  	* @return Paging<OdsOrderInfoDtlDTO>    返回类型 
  	* @throws 
  	*/
  	public Paging<OdsOrderInfoDtlDTO> serchOdsOrderDtlsBy(String no,String materialNo,
  															Date createDateStart,Date createDateEnd);
  	/** 
  	* @Title: getOdsOrderInfoDtls 
  	* @Description: TODO(这里用一句话描述这个方法的作用) 
  	* @param @param dto
  	* @param @return    设定文件 
  	* @author SJK
  	* @date 2019年3月18日
  	* @return List<OdsOrderInfoDtlDTO>    返回类型 
  	* @throws 
  	*/
  	public List<OdsOrderInfoDtlDTO> getOdsOrderInfoDtls(OdsOrderInfoDtlDTO dto);

	/** 
	* @Title: getExportAmount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsOrderInfoDtl
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long getExportAmount(OdsOrderInfoDtlDTO odsOrderInfoDtl);


	public OrderDirectDispatchOutDTO directDispatch(String stodnNo, String dnNo, String userName)
			throws IllegalAccessException, InvocationTargetException;
}

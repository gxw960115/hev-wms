package com.haier.hevwms.consume.dao;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ConsumePDADAO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月12日 上午9:53:16
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月12日		LJZ			v1.0.0			create
 */

public interface ConsumePDADAO extends CommonDAO<Object, Long> {
	
	/**
	 * @title: orderDelete
	 * @description: 手持Consume_条码删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月2日 下午1:33:01 
	 * @param in
	 * @param out
	 * @return: void
	 */
	public void orderDelete(@Param("in")OrderDeleteInDTO in,@Param("out")OrderDeleteOutDTO out);
	
	/**
	 * @title: scanConsumeCheck
	 * @description: 手持Consume_Consume扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:41 
	 * @param inpara
	 * @param result
	 * @return: void
	 */
	public void scanConsumeCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);

	/**
	 * @title: consumeOrderIgp
	 * @description: 手持Consume_过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void consumeOrderIgp(@Param("in") WmsOrderIgpIn in,@Param("out") WmsOrderIgpOut out);
	
	/**  
	* @Title: scanStatus  
	* @Description: 检测扫描状态
	* @author: ZhangLL
	* @param orno
	* @return long
	* @throws  
	*/
	public long scanStatus(@Param("orderNo") String orno);

	/**  
	* @Title: updateSapInfo  
	* @Description: 更改信息
	* @author: ZhangLL
	* @param inpara void
	* @throws  
	*/
	public void updateSapInfo(@Param("order") OrderIgpInDTO inpara);
}

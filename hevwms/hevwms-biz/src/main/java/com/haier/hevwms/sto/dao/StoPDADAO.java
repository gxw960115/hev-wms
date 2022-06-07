package com.haier.hevwms.sto.dao;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StoPDADAO.java
 * @description: Sto 手持DAO
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月31日 下午6:03:40
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月31日		LJZ			v1.0.0			create
 */

public interface StoPDADAO extends CommonDAO<Object, Long> {
	
	/**
	 * @title: orderDelete
	 * @description: 手持STO_条码删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月2日 下午1:33:01 
	 * @param in
	 * @param out
	 * @return: void
	 */
	public void orderDelete(@Param("in")OrderDeleteInDTO in,@Param("out")OrderDeleteOutDTO out);
	public void orderdnDelete(@Param("in")OrderDeleteInDTO in,@Param("out")OrderDeleteOutDTO out);

	/**
	 * 手持STODN_条码删除
	 * @param in
	 * @param out
	 */
	public void orderStodnDelete(@Param("in")OrderDeleteInDTO in,@Param("out")OrderDeleteOutDTO out);

	/**
	 * @title: scanStoCheck
	 * @description: 手持STO_STO扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:41 
	 * @param inpara
	 * @param result
	 * @return: void
	 */
	public void scanStoCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result); //scanStodnCheck

	/**
	 * 手持STODN_条码扫描
	 * stodn 出库
	 * @param inpara
	 * @param result
	 */
	public void scanStoDnOutCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);

	/**
	 * 手持STODN_条码扫描
	 * stodn 入库
	 * @param inpara
	 * @param result
	 */
	public void scanStoDnInCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);


	public void scanStodnCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
	/**
	 * @title: stoOrderIgp
	 * @description: 手持STO_过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void stoOrderIgp(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderIgpOutDTO out);
	
	/**
	 * @title: stoOrderIgp
	 * @description: 手持STO_过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void stoOrderOgp(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderIgpOutDTO out);
	public void stodnOrderIgp(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderIgpOutDTO out);
	/**
	 * @title: stoOrderIgp
	 * @description: 手持STO_过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void stoGoodsDelivery(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderGoodsTransOutDTO out);
	public void stoGoodsReceive(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderGoodsTransOutDTO out);
}

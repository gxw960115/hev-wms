package com.haier.hevwms.so.dao;

import com.haier.openplatform.wms.remoting.dto.*;
import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: SoPDADAO.java
 * @description: SO 手持DAO
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月31日 下午6:03:17
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月31日		LJZ			v1.0.0			create
 */

public interface SoPDADAO extends CommonDAO<Object, Long> {

	/**
	 * @title: orderDelete
	 * @description: 手持_条码删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月2日 下午1:33:01 
	 * @param in
	 * @param out
	 * @return: void
	 */
	public void orderDelete(@Param("in")OrderDeleteInDTO in,@Param("out")OrderDeleteOutDTO out);
	
	/**
	 * @title: orderDelete
	 * @description: 手持_条码删除
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月2日 下午1:33:01 
	 * @param in
	 * @param out
	 * @return: void
	 */
	public void giftSoOrderDelete(@Param("in")OrderDeleteInDTO in,@Param("out")OrderDeleteOutDTO out);
	
	
	/**
	 * @title: scanSoCheck
	 * @description: 手持_SO扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:41 
	 * @param inpara
	 * @param result
	 * @return: void
	 */
	public void scanSoCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
	public void scanSoOldBarcodeCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);

	/**
	 * @title: scanSoCheck
	 * @description: 手持_SO扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:41 
	 * @param inpara
	 * @param result
	 * @return: void
	 */
	public void scanGiftSoCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
	
	/**
	 * @title: soOrderIgp
	 * @description: 手持_SO过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void soOrderIgp(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderIgpOutDTO out);
	
	/**
	 * @title: soOrderIgp
	 * @description: 手持_SO过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void giftSoOrderIgp(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderIgpOutDTO out);

	public void soGoodsReceive(@Param("in")OrderIgpInDTO inpara,@Param("out") OrderGoodsTransOutDTO out);
	public void soGoodsDelivery(@Param("in")OrderIgpInDTO inpara,@Param("out")OrderGoodsTransOutDTO out);
	
	public void giftSoGoodsDelivery(@Param("in")OrderIgpInDTO inpara,@Param("out")OrderGoodsTransOutDTO out);
}

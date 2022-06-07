package com.haier.hevwms.po.dao;

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
 * @className: PoPDADAO.java
 * @description: PO手持DAO
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月31日 下午6:02:12
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月31日		LJZ			v1.0.0			create
 */

public interface PoPDADAO extends CommonDAO<Object, Long> {
	
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
	public void giftPoOrderDelete(@Param("in")OrderDeleteInDTO in,@Param("out")OrderDeleteOutDTO out);
	
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
	 * @title: scanPoCheck
	 * @description: 手持_PO扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:41 
	 * @param inpara
	 * @param result
	 * @return: void
	 */
	public void scanPoCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
	
	/**
	 * @title: scanPoCheck
	 * @description: 手持_PO扫描
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:41 
	 * @param inpara
	 * @param result
	 * @return: void
	 */
	public void scanGiftPoCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);

	/**
	 * @title: poOrderIgp
	 * @description: 手持_PO过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void poOrderIgp(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderIgpOutDTO out);
	
	/**
	 * @title: poOrderIgp
	 * @description: 手持_PO过账
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月7日 上午11:04:19 
	 * @param inpara
	 * @param out
	 * @return: WmsOrderIgpOutDTO
	 */
	public void giftPoOrderIgp(@Param("in")OrderIgpInDTO inpara, @Param("out")OrderIgpOutDTO out);
	
	public void poGoodsReceive(@Param("in")OrderIgpInDTO inpara,@Param("out")OrderGoodsTransOutDTO out);
	public void poGoodsDelivery(@Param("in")OrderIgpInDTO inpara,@Param("out")OrderGoodsTransOutDTO out);
	
	public void giftPoGoodsReceive(@Param("in")OrderIgpInDTO inpara,@Param("out")OrderGoodsTransOutDTO out);
	
}

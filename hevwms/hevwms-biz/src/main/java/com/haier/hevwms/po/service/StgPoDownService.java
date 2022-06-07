package com.haier.hevwms.po.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderMatListDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StgPoDownService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午1:49:25
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public interface StgPoDownService {

	/**
	* @Title: searchStgPoDowns
	* @Description: 返回满足搜索条件的PO订单
	* @param @param pager
	* @param @param dto
	* @param @return
	* @return Pager<StgPoDownDTO>
	*/
	public Pager<StgPoDownDTO> searchStgPoDowns(Pager<StgPoDownDTO> pager,StgPoDownDTO dto);
	
	/**
	* @Title: createStgPoDown
	* @Description: 新建一个Po订单
	* @param @param dto
	* @param @return
	* @return String
	*/
	public String createStgPoDown(StgPoDownDTO dto);
	
	/**
	* @Title: deleteStgPoDownAll
	* @Description: 批量删除Po订单
	* @param @param idList
	* @param @return
	* @return String
	*/
	public String deleteStgPoDownAll(List<Long> idList);
	
	/**
	* @Title: updateStgPoDown
	* @Description: 更新Po订单的信息
	* @param @param dto
	* @param @return
	* @return String
	*/
	public String updateStgPoDown(StgPoDownDTO dto);
	
	/**
	 * @Description:po查询导出  sunyanfei
	 * @param StgPoDownDTO
	 * @return  List<StgPoDownDTO>
	 */
	public List<StgPoDownDTO> getStgPoDownByParam(StgPoDownDTO dto);

	public Long getExportAmount(StgPoDownDTO dto);
	
	/**
	 * @title: checkPoRecieve
	 * @description: PO 手持 入库检查
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月2日 上午10:08:30 
	 * @param dto
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO checkPo(OrderCheckInDTO dto);
	
	/**
	 * @title: checkPoRecieve
	 * @description: PO 手持 入库检查
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月2日 上午10:08:30 
	 * @param dto
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO checkGiftPo(OrderCheckInDTO dto);
	
	/**  
	 * <p>Title: downloadPo</p>  
	 * <p>Description:下载PO </p>  
	 * @param poNo
	 * @param beginTime
	 * @param endTime
	 */
	public String downloadPo(String poNo, String beginTime, String endTime, String userName);
	
	/**  
	 * <p>Title: postPo</p>  
	 * <p>Description:PO过账 </p>  
	 * @param poNo
	 * @param userName
	 */
	public String postPo(String orderNo,String orderType, String returnType, String sapFlag, String userName);
	
	/**  
	 * <p>Title: getPoMaterialList</p>  
	 * <p>Description: </p>  
	 * @param orderNo
	 */
	public List<OrderMatListDTO> getPoMaterialList(String orderNo);
	
	/**  
	 * <p>Title: scanPoCheck</p>  
	 * <p>Description: </p>  
	 * @param inpara
	 */
	public OrderUploadOutDTO scanPoCheck(OrderUploadInDTO inpara);
	
	public OrderGoodsTransOutDTO poGoodsReceive(OrderIgpInDTO inpara);
	
	public OrderGoodsTransOutDTO poGoodsDelivery(OrderIgpInDTO inpara);
	
	public OrderGoodsTransOutDTO giftPoGoodsReceive(OrderIgpInDTO inpara);
}

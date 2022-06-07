package com.haier.hevwms.takestock.service;

import java.util.List;

import com.haier.hevwms.takestock.domain.OdsPdInfo;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;

public interface OdsPdInfoService {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String createOdsPdInfo(OdsPdInfo odsPdInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfo> updateOdsPdInfo(OdsPdInfo odsPdInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfo> deleteOdsPdInfo(Long odsPdInfoId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfo> deleteOdsPdInfoAll(List<Long> idList);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<OdsPdInfo> searchOdsPdInfos(Pager<OdsPdInfo> pager,
			OdsPdInfo odsPdInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public OdsPdInfo getOdsPdInfoById(Long odsPdInfoId);

	
	/**  
	* @Title: checkPdInfo  
	* @Description: 检测订单号是否存在,当前登陆人是否有权限进行操作
	* @author zhangll
	* @param dto
	* @return OrderCheckOutDTO
	* @throws  
	*/
	public OrderCheckOutDTO checkPdInfo(OrderCheckInDTO dto);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfo> getOdsPdInfos(OdsPdInfo odsPdInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String findPdNo();

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfo> saveOdsPds(OdsPdInfo odsPdInfo,List<OdsPdInfo> odsPdInfos);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfo> updateOrderStatus(OdsPdInfo odsPdInfo);

	//Excel导出时调用此查询方法
    public List<OdsPdInfo> getOdsPdInfo(OdsPdInfo odsPdInfo);
    
    //获取系统中生成的  stocktakingOrderNo
    public String selectStocktakingOrderNo();
    
    /**
     * 
    * @Title: deleteOrder
    * @Description:  (对 未进行差异处理的盘点单 进行删除操作)
    * @param @param odsPdInfo
    * @param @return
    * @return ExecuteResult<OdsPdInfo>
    * @throws
     */
    public ExecuteResult<OdsPdInfo> deleteOrder(OdsPdInfo odsPdInfo);

	public Long searchOdsPdInfosCount(OdsPdInfo odsPdInfo);

}

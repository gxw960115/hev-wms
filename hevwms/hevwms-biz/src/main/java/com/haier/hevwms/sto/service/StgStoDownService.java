package com.haier.hevwms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;

import java.util.List;

public interface StgStoDownService {

	/**
	 * @title: searchStgStoDowns
	 * @description:分页条件查询 
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:14:52 
	 * @param pager
	 * @param stgStoDown
	 * @return: Pager<StgStoDownDTO>
	 */
	public Pager<StgStoDownDTO> searchStgStoDowns(Pager<StgStoDownDTO> pager,StgStoDownDTO stgStoDown);

	/**
	 * @title: getStgStoDownById
	 * @description:根据ID查询 
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:15:23 
	 * @param stgStoDownId
	 * @return: StgStoDownDTO
	 */
	public StgStoDownDTO getStgStoDownById(Long stgStoDownId);
	
	/**
	 * @title: getStgStoDowns
	 * @description:条件查询 
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:15:46 
	 * @param stgStoDown
	 * @return: List<StgStoDownDTO>
	 */
	public List<StgStoDownDTO> getStgStoDowns(StgStoDownDTO stgStoDown);
	
	public String closeStgStoDown(String userName,String ids);

	public String openStgStoDown(String userName,String ids);
	
	/**
	 * @title: updateStoConfirm
	 * @description:更新sto审批标记 
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:16:09 
	 * @param stoNo
	 * @return: int
	 */
	public int updateStoConfirm(String stoNo);

	/**
	 * @title: getExportAmount
	 * @description:导出数量统计 
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:16:24 
	 * @param dto
	 * @return: Long
	 */
	public Long getExportAmount(StgStoDownDTO dto);

	/**
	 * @title: checkStoRecieve
	 * @description: 手持STO_入库扫描检查
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:12:58 
	 * @param dto
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO checkStoReceive(OrderCheckInDTO dto);

	/**
	 * @title: checkStoDelivery
	 * @description: 手持STO_出库扫描检查
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:13:29 
	 * @param dto
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO checkStoDelivery(OrderCheckInDTO dto);

	/**
	 * @title: downloadSto
	 * @description: 手持STO_调用SAP接口下载STO订单
	 * @author: LJZ
	 * @date: 2018年11月9日 上午10:28:41 
	 * @param orno
	 * @param begin
	 * @param end
	 * @param userName
	 * @return: String
	 */
	public InterfaceOutDTO downloadSto(String orno, String begin, String end, String userName);
	
	/**  
	 * <p>Title: postSto</p>  
	 * <p>Description:sto出库过账 </p>  
	 * @param orderNo
	 * @param sapFlag
	 * @param userName
	 * @return  
	 */
	public InterfaceOutDTO postSto(String orderNo, String stodnNo, String orderType, String sapFlag, String userName) ;
	/**  
	 * <p>Title: postSto</p>  
	 * <p>Description:sto出库过账 </p>  
	 * @param orderNo
	 * @param sapFlag
	 * @param userName
	 * @return  
	 */
	public InterfaceOutDTO postStodn(String orderNo, String sapFlag, String userName) ;
	
	public OrderGoodsTransOutDTO stoGoodsDelivery(OrderIgpInDTO inpara);
	
	public OrderGoodsTransOutDTO stoGoodsReceive(OrderIgpInDTO inpara);

	public OrderCheckOutDTO checkOrderByPDA(OrderCheckInDTO dto);

	/**
	 * 根据stoNo获取giLocation
	 * @author LJZ
	 * @param stoNo
	 * @return
	 */
	List<String> getGiLocationNameListBySTONO(String stoNo);

	/**
	 * 根据stoNo获取grLocation
	 * @author LJZ
	 * @param stoNo
	 * @return
	 */
	List<String> getGrLocationNameListBySTONO(String stoNo);
}

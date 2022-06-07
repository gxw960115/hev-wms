package com.haier.openplatform.wms.stocktaking.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;

import io.terminus.pampas.client.Export;

/**
* @ClassName: StocktakingServiceClient
* @Description: 库存盘点单 相关功能 对外暴漏的 接口
* @author linzongxiao
* @Date 2015-10-30 下午2:24:16
*/
public interface StocktakingServiceClient {

    /**
    * @Title: addStocktakingOrder
    * @Description:  增加 库存盘点单
    * @param @param odsPdInfoDTO
    * @param @return
    * @return String
    * @throws
    */
//    @Export(paramNames = {"odsPdInfoDTO"})
    public String addStocktakingOrder(OdsPdInfoDTO odsPdInfoDTO);
    
    /**
    * @Title: searchStocktakingOrder
    * @Description:  页面加载时  查询所有 库存盘点单 明细
    * @param @param page
    * @param @param rows
    * @param @param odsPdInfoDTO
    * @param @return
    * @return Pager<OdsPdInfoDTO>
    * @throws
    */
    public Pager<OdsPdInfoDTO> searchStocktakingOrder(long page,long rows,OdsPdInfoDTO odsPdInfoDTO); 
    
    /**
    * @Title: openStocktakingOrder
    * @Description:  打开 库存盘点单
    * @param @param userNo
    * @param @param status
    * @param @return
    * @return String
    * @throws
    */
    @Export(paramNames = {"odsPdInfoDTO"})
    public String updateStocktakingOrder(OdsPdInfoDTO odsPdInfoDTO);
    
    /**
     * 
    * @Title: deleteStocktakingOrder
    * @Description:  (这里用一句话描述这个类的作用)
    * @param @param odsPdInfoDTO
    * @param @return
    * @return String
    * @throws
    * add by linzx @20160223
     */
    @Export(paramNames ={"odsPdInfoDTO"})
    public String deleteStocktakingOrder(OdsPdInfoDTO odsPdInfoDTO);
    
    /** 
    * @Title: getOdsPdInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param odsPdInfoDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<OdsPdInfoDTO>    返回类型 
    * @throws 
    */
    public List<OdsPdInfoDTO> getOdsPdInfo(OdsPdInfoDTO odsPdInfoDTO);
    
    /** 
    * @Title: getStocktakingOrderNo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export
    public String getStocktakingOrderNo();
    
    /** 
    * @Title: addStocktakingOrders 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param odsPdInfoDTO
    * @param @param msg
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames={"odsPdInfoDTO","msg"})
    public String addStocktakingOrders(OdsPdInfoDTO odsPdInfoDTO,List<OdsPdInfoDTO> msg);

	/** 
	* @Title: searchOdsPdInfosCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long searchOdsPdInfosCount(OdsPdInfoDTO dto);

	/**  
	* @Title: orderCheck  
	* @Description: 盘点订单检查
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderCheckOutDTO
	* @throws  
	*/
	public OrderCheckOutDTO orderCheck(OrderCheckInDTO inpara, String version);
}

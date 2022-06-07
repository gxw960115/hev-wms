package com.haier.hevwms.so.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;

import java.util.List;

/**
 * @author SJK
 *
 */
public interface StgDnDownService {
	
	/** 
	* @Title: searchStgDnDowns 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pager
	* @param @param stgDnDown
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return Pager<StgDnDownDTO>    返回类型 
	* @throws 
	*/
	Pager<StgDnDownDTO> searchStgDnDowns(Pager<StgDnDownDTO> pager,StgDnDownDTO stgDnDown);
	
	/** 
	* @Title: searchStgDnReverse 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pager
	* @param @param stgDnDown
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return Pager<StgDnDownDTO>    返回类型 
	* @throws 
	*/
	Pager<StgDnDownDTO> searchStgDnReverse(Pager<StgDnDownDTO> pager,StgDnDownDTO stgDnDown);

	/** 
	* @Title: getStgDnDownsByParam 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param stgDnDown
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return List<StgDnDownDTO>    返回类型 
	* @throws 
	*/
	List<StgDnDownDTO> getStgDnDownsByParam(StgDnDownDTO stgDnDown);
	
	/** 
	* @Title: getExportAmount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return Long    返回类型 
	* @throws 
	*/
	Long getExportAmount(StgDnDownDTO dto);

	/** 
	* @Title: checkSo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return OrderCheckOutDTO    返回类型 
	* @throws 
	*/
	OrderCheckOutDTO checkSo(OrderCheckInDTO dto);

	/** 
	* @Title: downloadDnFromSAP 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param soNo
	* @param @param beginTime
	* @param @param endTime
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return InterfaceOutDTO    返回类型 
	* @throws 
	*/
	InterfaceOutDTO downloadDnFromSAP(String soNo, String beginTime, String endTime, String userName);

	/** 
	* @Title: postDn 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param orderType
	* @param @param sapFlag
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return InterfaceOutDTO    返回类型 
	* @throws 
	*/
	InterfaceOutDTO postDn(String orderNo, String orderType, String sapFlag, String userName);

	/** 
	* @Title: getSoMaterialList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orno
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return List<OrderMatListDTO>    返回类型 
	* @throws 
	*/
	List<OrderMatListDTO> getSoMaterialList(String orno);

    /** 
    * @Title: soGoodsReceive 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param inpara
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return OrderGoodsTransOutDTO    返回类型 
    * @throws 
    */
    OrderGoodsTransOutDTO soGoodsReceive(OrderIgpInDTO inpara);

	/** 
	* @Title: soGoodsDelivery 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param inpara
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return OrderGoodsTransOutDTO    返回类型 
	* @throws 
	*/
	OrderGoodsTransOutDTO soGoodsDelivery(OrderIgpInDTO inpara);
	
	/** 
	* @Title: giftSoGoodsDelivery 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param inpara
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return OrderGoodsTransOutDTO    返回类型 
	* @throws 
	*/
	OrderGoodsTransOutDTO giftSoGoodsDelivery(OrderIgpInDTO inpara);

	/** 
	* @Title: getLocationNameByDnNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dnNo
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return List<String>    返回类型 
	* @throws 
	*/
	List<String> getLocationNameByDnNo(String dnNo);

    /** 
    * @Title: getFifoList 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param inpara
    * @param @param location
    * @param @param materialNo
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return WmsOrderDelListOutDTO    返回类型 
    * @throws 
    */
    WmsOrderDelListOutDTO getFifoList(WmsOrderDelListInDTO inpara, String location,String materialNo);

    /** 
    * @Title: dnReverse 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param inpara
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return OrderIgpOutDTO    返回类型 
    * @throws 
    */
    public OrderIgpOutDTO dnReverse(OrderIgpInDTO inpara);


	public Pager<StgDnDownDTO> searchDirectDispatchDn(Pager<StgDnDownDTO> pager,StgDnDownDTO stgDnDown);
}

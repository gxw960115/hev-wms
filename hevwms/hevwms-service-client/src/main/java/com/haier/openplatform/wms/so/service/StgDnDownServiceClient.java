package com.haier.openplatform.wms.so.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDirectDispatchOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface StgDnDownServiceClient {

    /** 
    * @Title: searchStgDnDown 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param pager
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<StgDnDownDTO>    返回类型 
    * @throws 
    */
    Pager<StgDnDownDTO> searchStgDnDown(Pager<StgDnDownDTO> pager, StgDnDownDTO dto);
    /** 
    * @Title: searchStgDnReverse 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param pager
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<StgDnDownDTO>    返回类型 
    * @throws 
    */
    Pager<StgDnDownDTO> searchStgDnReverse(Pager<StgDnDownDTO> pager, StgDnDownDTO dto);

	/** 
	* @Title: downStgDnDown 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dnNo
	* @param @param begin
	* @param @param end
	* @param @param userName
	* @param @return
	* @param @throws Exception    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return InterfaceOutDTO    返回类型 
	* @throws 
	*/
	InterfaceOutDTO downStgDnDown(String dnNo, String begin, String end, String userName) throws Exception;
    
	/** 
	* @Title: getStgDnDownsByParam 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param stgDnDown
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<StgDnDownDTO>    返回类型 
	* @throws 
	*/
	public List<StgDnDownDTO> getStgDnDownsByParam(StgDnDownDTO stgDnDown);

	/** 
	* @Title: postDn 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param orderType
	* @param @param sapFlag
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return InterfaceOutDTO    返回类型 
	* @throws 
	*/
	public InterfaceOutDTO postDn(String orderNo, String orderType,String sapFlag, String userName);
	
	/** 
	* @Title: postDn 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param orderType
	* @param @param sapFlag
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return InterfaceOutDTO    返回类型 
	* @throws 
	*/
	public InterfaceOutDTO postGiftDn(String orderNo, String orderType,String sapFlag, String userName);

	/** 
	* @Title: getExportAmount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long getExportAmount(StgDnDownDTO dto);

   /** 
	* @Title: dnReverse 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param inpara
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return OrderIgpOutDTO    返回类型 
	* @throws 
	*/
	public OrderIgpOutDTO dnReverse(OrderIgpInDTO inpara);
	
    /** 
    * @Title: inoutWarehousePo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param orderNo
    * @param @param orderType
    * @param @param userName
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    public String inoutWarehousePo(String orderNo, String orderType, String userName);
    
    /** 
    * @Title: giftInoutWarehousePo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param orderNo
    * @param @param orderType
    * @param @param userName
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    public String giftInoutWarehousePo(String orderNo, String orderType, String userName);



	/**
	 * @param pager
	 * @param dto
	 * @return
	 */
	Pager<StgDnDownDTO> searchDirectDispatchDn(Pager<StgDnDownDTO> pager,
											   StgDnDownDTO dto);

	public OrderDirectDispatchOutDTO directDispatch(String stodnNo, String dnNo, String userName)
			throws IllegalAccessException, InvocationTargetException;
}

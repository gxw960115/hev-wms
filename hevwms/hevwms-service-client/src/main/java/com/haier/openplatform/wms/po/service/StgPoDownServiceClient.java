package com.haier.openplatform.wms.po.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;

public interface StgPoDownServiceClient {
	
	/** 
	* @Title: searchStgPoDown 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pager
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<StgPoDownDTO>    返回类型 
	* @throws 
	*/
	public Pager<StgPoDownDTO> searchStgPoDown(Pager<StgPoDownDTO> pager,StgPoDownDTO dto);
    
    /** 
    * @Title: createStgPoDown 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    public String createStgPoDown(StgPoDownDTO dto);

	/** 
	* @Title: deleteStgPoDown 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param idList
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String deleteStgPoDown(List<Long> idList);

	/** 
	* @Title: updateStgPoDown 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String updateStgPoDown(StgPoDownDTO dto);
	
	/** 
	* @Title: getStgPoDownByParam 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<StgPoDownDTO>    返回类型 
	* @throws 
	*/
	public List<StgPoDownDTO> getStgPoDownByParam(StgPoDownDTO dto);

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
	public Long getExportAmount(StgPoDownDTO dto);
	
	/** 
	* @Title: downloadPo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param poNo
	* @param @param beginTime
	* @param @param endTime
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String downloadPo(String poNo, String beginTime, String endTime, String userName);
	
	/** 
	* @Title: postPo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param orderType
	* @param @param returnType
	* @param @param sapFlag
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String postPo(String orderNo, String orderType, String returnType, String sapFlag, String userName);
	
	/** 
	* @Title: postPo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param orderType
	* @param @param returnType
	* @param @param sapFlag
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String postGiftPo(String orderNo, String orderType, String sapFlag, String userName);
	
	/** 
	* @Title: inoutWarehousePo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param orderType
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	String inoutWarehousePo(String orderNo, String orderType, String userName);
	
	/** 
	* @Title: inoutWarehousePo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param orderType
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	String giftInoutWarehousePo(String orderNo, String orderType, String userName);

}

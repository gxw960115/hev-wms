/**
* @Company ������ͨ
* @Title: StgStoDownServiceClient.java
* @Package com.haier.openplatform.wms.order.service
* @author Administrator
* @date 2015-10-31 ����1:20:23
* @version V1.0
*/
package com.haier.openplatform.wms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import io.terminus.pampas.client.Export;

import java.util.List;

public interface StgStoDownServiceClient {
	
    /** 
    * @Title: searchStgStoDown 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param pager
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return Pager<StgStoDownDTO>    返回类型 
    * @throws 
    */
    public Pager<StgStoDownDTO> searchStgStoDown(Pager<StgStoDownDTO> pager,StgStoDownDTO dto);
    
    /** 
    * @Title: createStgStoDown 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return String    返回类型 
    * @throws 
    */
    public String createStgStoDown(StgStoDownDTO dto);
    
	/** 
	* @Title: getStgStoDowns 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param stgStoDown
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return List<StgStoDownDTO>    返回类型 
	* @throws 
	*/
	public List<StgStoDownDTO> getStgStoDowns(StgStoDownDTO stgStoDown);

	/** 
	* @Title: closeStgStoDown 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userName
	* @param @param ids
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames={"userName","ids"})
	public String closeStgStoDown(String userName,String ids);
	
	/** 
	* @Title: openStgStoDown 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userName
	* @param @param ids
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames={"userName","ids"})
	public String openStgStoDown(String userName,String ids);
	
	/** 
	* @Title: confirmSto 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param stoNos
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年4月30日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames={"stoNos"})
	public String confirmSto(String stoNos);

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
	public Long getExportAmount(StgStoDownDTO dto);
	
	/** 
	* @Title: downloadSto 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param stoNo
	* @param @param beginTime
	* @param @param endTime
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return InterfaceOutDTO    返回类型 
	* @throws 
	*/
	public InterfaceOutDTO downloadSto(String stoNo, String beginTime, String endTime, String userName);
	
	/** 
	* @Title: postSto 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orderNo
	* @param @param stodnNo
	* @param @param orderType
	* @param @param sapFlag
	* @param @param userName
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return OrderIgpOutDTO    返回类型 
	* @throws 
	*/
	public OrderIgpOutDTO postSto(String orderNo, String stodnNo, String orderType, String sapFlag, String userName);

	/** 
	* @Title: getGiLocationNameListBySTONO 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param stoNo
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<String>    返回类型 
	* @throws 
	*/
	List<String> getGiLocationNameListBySTONO(String stoNo);

	/** 
	* @Title: getGrLocationNameListBySTONO 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param stoNo
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<String>    返回类型 
	* @throws 
	*/
	List<String> getGrLocationNameListBySTONO(String stoNo);
}

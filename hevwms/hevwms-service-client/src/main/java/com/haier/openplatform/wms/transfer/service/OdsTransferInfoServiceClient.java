package com.haier.openplatform.wms.transfer.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;

/**  
 * @Title:  OdsTransferInfoServiceClient.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午2:54:56   
 * @version V1.0 
 */  
public interface OdsTransferInfoServiceClient {

	/**  
	* @Title: searchOdsTransferInfos  
	* @Description: TODO(分页查询311移库信息)  
	* @author zhangll
	* @param page
	* @param rows
	* @param odsTransferInfoDTO
	* @return Pager<OdsTransferInfoDTO>
	* @throws  
	*/
	Pager<OdsTransferInfoDTO> searchOdsTransferInfos(long page, long rows, OdsTransferInfoDTO odsTransferInfoDTO);

	/**  
	* @Title: searchOdsTransferInfosCount  
	* @Description: TODO(查询数量)  
	* @author zhangll
	* @param odsTransferInfoDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsTransferInfosCount(OdsTransferInfoDTO odsTransferInfoDTO);
	
	/**  
	* @Title: getTransferOrderNo  
	* @Description: TODO(获取移库单号)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	public String getTransferOrderNo();
    
	/**  
	* @Title: addTranferInfo  
	* @Description: TODO(新增移库信息)  
	* @author zhangll
	* @param odsTransferInfoDTO
	* @param msg
	* @param userName
	* @return String
	* @throws  
	*/
    public String addTranferInfo(OdsTransferInfoDTO odsTransferInfoDTO,List<OdsTransferInfoDTO> msg); 
	
	/**  
	* @Title: deleteTransferInfoByTransNo  
	* @Description: TODO(删除移库单)  
	* @author zhangll
	* @param transNo void
	* @throws  
	*/
	public String deleteTransferInfoByTransNo(String transNo);
	
	/**  
	* @Title: transferApprove  
	* @Description: TODO(审批移库单) 
	* @author zhangll
	* @param transNo void
	* @throws  
	*/
	public String transferApprove(String transNo,String modifyBy);

	/**  
	* @Title: deleteTransferInfoByIds  
	* @Description: TODO(删除311移库单)  
	* @author zhangll
	* @param idList
	* @return String
	* @throws  
	*/
	public String deleteTransferInfoByIds(List<Long> idList);

	/**  
	* @Title: orderCheck  
	* @Description: 单号检测
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderCheckOutDTO
	* @throws  
	*/
	public OrderCheckOutDTO orderCheck(OrderCheckInDTO inpara, String version);
}

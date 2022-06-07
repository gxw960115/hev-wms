package com.haier.hevwms.transfer.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;

/**  
 * @Title:  OdsTransferInfoService.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:13:50   
 * @version V1.0 
 */  
public interface OdsTransferInfoService {

	/**  
	* @Title: searchTransInventoryInfos  
	* @Description: TODO(分页查询信息)  
	* @author zhangll
	* @param pager
	* @param odsTransferInfoDTO
	* @return Pager<OdsTransferInfoDTO>
	* @throws  
	*/
	public Pager<OdsTransferInfoDTO> searchTransferInfos(Pager<OdsTransferInfoDTO> pager,OdsTransferInfoDTO odsTransferInfoDTO);

	/**  
	* @Title: getTransferOrderNo  
	* @Description: TODO(获取移库单号)  
	* @author zhangll
	* @return String
	* @throws  
	*/
	public String getTransferOrderNo();

	/**  
	* @Title: addTransferInfo  
	* @Description: TODO(新增移库)  
	* @author zhangll
	* @param transDto
	* @param list
	* @return String
	* @throws  
	*/
	public String addTransferInfo(OdsTransferInfoDTO transDto, List<OdsTransferInfoDTO> list);

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
	* @Description: TODO(删除移库单)  
	* @author zhangll
	* @param rowIds
	* @return String
	* @throws  
	*/
	public String deleteTransferInfoByIds(List<Long> idList);

	/**  
	* @Title: searchOdsTransferInfosCount  
	* @Description: TODO(统计数量)  
	* @author zhangll
	* @param odsTransferInfoDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsTransferInfosCount(OdsTransferInfoDTO odsTransferInfoDTO);

	/**  
	* @Title: checkTransferInfo  
	* @Description: 检测订单是否存在
	* @author: ZhangLL
	* @param inpara
	* @return OrderCheckOutDTO
	* @throws  
	*/
	public OrderCheckOutDTO checkTransferInfo(OrderCheckInDTO inpara);

	/**  
	* @Title: scanStatus  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param orderNo
	* @return List<OdsTransferInfoDTO>
	* @throws  
	*/
	public List<OdsTransferInfoDTO> scanStatus(String orderNo);
}

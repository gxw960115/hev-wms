package com.haier.hevwms.transfer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;

/**
 * @Title: OdsTransferInfoDAO.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date: 2018年11月7日 下午4:19:34
 * @version V1.0
 */
public interface OdsTransferInfoDAO extends CommonDAO<OdsTransferInfoDTO, Long> {

	/**
	 * @Title: deleteAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author zhangll 
	 * @param idList void 
	 * @throws
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**  
	* @Title: deleteTransferInfoByTransNo  
	* @Description: TODO(删除移库单)  
	* @author zhangll
	* @param transNo void
	* @throws  
	*/
	public void deleteTransferInfoByTransNo(@Param("transNo") String transNo);
	
	/**  
	* @Title: transferApprove  
	* @Description: TODO(审批移库单)  
	* @author zhangll
	* @param transNo 
	* @param modifyBy 
	* @throws  
	*/
	public void transferApprove(@Param("transNo") String transNo,@Param("modifyBy") String modifyBy);
	
	/**
	 * @Title: selectOdsTransferInfoNo 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author zhangll 
	 * @return String 
	 * @throws
	 */
	public String selectOdsTransferInfoNo();

	/**  
	* @Title: searchOdsTransferInfos  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param pager
	* @param odsTransferInfo
	* @return List<OdsTransferInfo>
	* @throws  
	*/
	public List<OdsTransferInfoDTO> searchOdsTransferInfos(@Param("pager") Pager<OdsTransferInfoDTO> pager,
			@Param("odsTransferInfo") OdsTransferInfoDTO odsTransferInfoDTO);
	
	/**  
	* @Title: searchOdsTransferDtlsCount  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param odsTransferInfo
	* @return Long
	* @throws  
	*/
	public Long searchOdsTransferInfosCount(@Param("odsTransferInfo") OdsTransferInfoDTO odsTransferInfoDTO);
	
	/**  
	* @Title: searchOdsTransferInfoList  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param pager
	* @param odsTransferInfo
	* @return List<OdsTransferInfo>
	* @throws  
	*/
	public List<OdsTransferInfoDTO> searchOdsTransferInfoList(@Param("odsTransferInfo") OdsTransferInfoDTO odsTransferInfoDTO);
	
	public void updatePostResult(@Param("odsTransferInfo") OdsTransferInfoDTO odsTransferInfoDTO);

	/**  
	* @Title: checkTransferOrderExist  
	* @Description: 检测订单是否存在
	* @author: ZhangLL
	* @param inpara
	* @return String
	* @throws  
	*/
	public String checkTransferOrderExist(@Param("inpara") OrderCheckInDTO inpara);

	/**  
	* @Title: checkTransferLoc  
	* @Description: 检测地点权限
	* @author: ZhangLL
	* @param inpara
	* @param id
	* @return String
	* @throws  
	*/
	public String checkTransferLoc(@Param("inpara") OrderCheckInDTO inpara,@Param("userId")  Long id);
	
	/**  
	* @Title: scanStatus  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param orno
	* @return List<OdsTransferInfoDTO>
	* @throws  
	*/
	public List<OdsTransferInfoDTO> scanStatus(@Param("orderNo") String orno);
}
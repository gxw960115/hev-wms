package com.haier.hevwms.sto.dao;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**  
 * @Title:  OdsStoCustDAO.java
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0 
 */  
public interface OdsStoCustDAO extends CommonDAO<OdsStoCustDTO, Long> {

	/**
	 * @Title: deleteAll
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author zhangll
	 * @param idList void
	 * @throws
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**
	* @Title: deleteStoCustByNo
	* @Description: TODO(删除订单信息)
	* @author zhangll
	* @param cusNo void
	* @throws
	*/
	public void deleteStoCustByNo(@Param("stoNo") String stoNo);

	/**
	* @Title: stoApprove
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author zhangll
	* @param cusNo
	* @param modifyBy void
	* @throws
	*/
	public void stoApprove(@Param("stoNo") String cusNo, @Param("modifyBy") String modifyBy);

	/**
	 * @Title: selectOdsStoCustNo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author zhangll
	 * @return String
	 * @throws
	 */
	public String selectOdsStoCustNo();

	/**
	* @Title: searchOdsStoCusts
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author zhangll
	* @param pager
	* @param odsStoCust
	* @return List<OdsStoCust>
	* @throws
	*/
	public List<OdsStoCustDTO> searchOdsStoCusts(@Param("pager") Pager<OdsStoCustDTO> pager,
													   @Param("odsStoCust") OdsStoCustDTO odsStoCustDTO);

	/**
	* @Title: searchOdsStoCustsCount
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author zhangll
	* @param odsStoCustDTO
	* @return Long
	* @throws
	*/
	public Long searchOdsStoCustsCount(@Param("odsStoCust") OdsStoCustDTO odsStoCustDTO);

	/**
	* @Title: checkStoCustExist
	* @Description: 检查订单是否存在
	* @author: ZhangLL
	* @param inpara
	* @return String
	* @throws
	*/
	public String checkStoCustExist(@Param("inpara") OrderCheckInDTO inpara);

	/**
	* @Title: checkStoCustLoc
	* @Description: 检测用户是否有当前地点的扫描权限
	* @author: ZhangLL
	* @param inpara
	* @param userId
	* @return String
	* @throws
	*/
	public String checkStoCustLoc(@Param("inpara") OrderCheckInDTO inpara, @Param("userId") Long userId);

	/**
	 * @Title: scanStatus
	 * @Description: 检测订单状态
	 * @author: ZhangLL
	 * @param inpara
	 * @param userId
	 * @return String
	 * @throws
	 */
    List<OdsStoCustDTO> scanStatus(@Param("stoNo") String stoNo);

	/**
	 * @Title: orderOgpIn
	 * @Description: 入库OGP
	 * @author: ZhangLL
	 * @return
	 * @throws
	 */
    public void orderOgpIn(@Param("in") WmsOrderIgpIn in, @Param("out") WmsOrderIgpOut out);

	/**
	 * @Title: orderOgpOut
	 * @Description: 出库OGP
	 * @author: ZhangLL
	 * @return
	 * @throws
	 */
    public void orderOgpOut(@Param("in") WmsOrderIgpIn in, @Param("out") WmsOrderIgpOut out);

	/**
	 * @Title: updateOgpInInfo
	 * @Description: 保存OGP时填写的信息
	 * @author: ZhangLL
	 * @return
	 * @throws
	 */
	public void updateOgpInInfo(@Param("inpara") OrderIgpInDTO inpara);

	/**
	 * @Title: updateOgpOutInfo
	 * @Description: 保存OGP时填写的信息
	 * @author: ZhangLL
	 * @return
	 * @throws
	 */
	public void updateOgpOutInfo(@Param("inpara") OrderIgpInDTO inpara);
}
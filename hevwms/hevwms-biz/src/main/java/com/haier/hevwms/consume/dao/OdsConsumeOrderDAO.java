package com.haier.hevwms.consume.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;

public interface OdsConsumeOrderDAO extends CommonDAO<OdsConsumeOrderDTO, Long> {

	/**
	 * @title: searchOdsConsumeOrderByPage
	 * @description: 分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午3:07:40 
	 * @param pager
	 * @param dto
	 * @return: List<OdsConsumeOrderDTO>
	 */
	List<OdsConsumeOrderDTO> searchOdsConsumeOrderByPage(
			@Param("pager") Pager<OdsConsumeOrderDTO> pager,@Param("odsConsumeOrder") OdsConsumeOrderDTO dto);

	/**
	 * @title: searchOdsConsumeOrderCount
	 * @description: 统计
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午3:10:22 
	 * @param dto
	 * @return: Long
	 */
	Long searchOdsConsumeOrderCount(@Param("odsConsumeOrder") OdsConsumeOrderDTO dto);

	/**
	 * @title: deleteAll
	 * @description: 删除数据
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午4:40:47 
	 * @param idList
	 * @return: void
	 */
	public int deleteAll(@Param("idList") List<Long> idList);

	/**
	 * @title: confirmConsumeOrder
	 * @description: 确认领用单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 上午11:31:36 
	 * @param idList
	 * @return: int
	 */
	int confirmConsumeOrder(@Param("idList") List<Long> idList,@Param("userName") String userName);

	/**
	 * @title: getOdsConsumeOrderListByParm
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月25日 上午10:54:35 
	 * @param dto
	 * @return: List<OdsConsumeOrderDTO>
	 */
	List<OdsConsumeOrderDTO> getOdsConsumeOrderListByParm(@Param("odsConsumeOrder") OdsConsumeOrderDTO dto);

    /**
     * <p>Title: getScrapSequence</p>
     * <p>Description: </p>
     * @return
     */
    public long getConsumeSequence();

    /**
     *
     * @param rowId
     * @param plant
     * @param matDoc
     * @param docYear
     * @param sapFlag
     * @param sapMsg
     */
    public void updateSapReMsg(@Param("odsConsumeOrder") OdsConsumeOrderDTO dto);
    
	/**
	 * @title: checkConsumeOrderByPDA
	 * @description: 手持Consume_ 订单扫描检查
	 * @author: LJZ
	 * @date: 2018年11月12日 下午3:43:54 
	 * @param consumeNo
	 * @return: String
	 */
	public String checkConsumeOrderByPDA(@Param("consumeNo") String consumeNo);

	/**
	 * @title: checkConsumeOrderLoc
	 * @description: 手持Consume_ 用户权限检查
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月12日 下午4:35:42 
	 * @param consumeNo
	 * @param id
	 * @return: String
	 */
	String checkConsumeOrderLoc(@Param("consumeNo")String consumeNo, @Param("id") Long id);
	
	/**  
	* @Title: scanStatus  
	* @Description: 检测扫描状态
	* @author: ZhangLL
	* @param orno
	* @return long
	* @throws  
	*/
	public List<OdsConsumeOrderDTO> scanStatus(@Param("orderNo") String orno);
	
	/** 
	* @Title: updateCostCenter 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年7月9日
	* @return int    返回类型 
	* @throws 
	*/
	public int updateCostCenter(@Param("odsConsumeOrder") OdsConsumeOrderDTO dto);
	
}
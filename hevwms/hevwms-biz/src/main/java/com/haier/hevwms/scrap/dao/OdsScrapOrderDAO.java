package com.haier.hevwms.scrap.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;

public interface OdsScrapOrderDAO extends CommonDAO<OdsScrapOrderDTO, Long> {

	/**
	 * @title: searchOdsScrapOrderByPage
	 * @description: 分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午3:07:40 
	 * @param pager
	 * @param dto
	 * @return: List<OdsScrapOrderDTO>
	 */
	List<OdsScrapOrderDTO> searchOdsScrapOrderByPage(
			@Param("pager") Pager<OdsScrapOrderDTO> pager,@Param("odsScrapOrder") OdsScrapOrderDTO dto);

	/**
	 * @title: searchOdsScrapOrderCount
	 * @description: 统计
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午3:10:22 
	 * @param dto
	 * @return: Long
	 */
	Long searchOdsScrapOrderCount(@Param("odsScrapOrder") OdsScrapOrderDTO dto);

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
	 * @title: confirmScrapOrder
	 * @description: 确认报废单
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 上午11:31:36 
	 * @param idList
	 * @return: int
	 */
	int confirmScrapOrder(@Param("idList") List<Long> idList,@Param("userName") String userName);

	/**
	 * @title: getOdsScrapOrderListByParm
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月25日 上午10:54:35 
	 * @param dto
	 * @return: List<OdsScrapOrderDTO>
	 */
	List<OdsScrapOrderDTO> getOdsScrapOrderListByParm(@Param("odsScrapOrder") OdsScrapOrderDTO dto);

    /**
     * <p>Title: getScrapSequence</p>
     * <p>Description: </p>
     * @return
     */
    public long getScrapSequence();

    /**
     *
     * @param rowId
     * @param plant
     * @param matDoc
     * @param docYear
     * @param sapFlag
     * @param sapMsg
     */
    public void updateSapReMsg(@Param("odsScrapOrder") OdsScrapOrderDTO dto);
    

	/**
	 * @title: checkScrapOrderByPDA
	 * @description: 手持Scrap_ 检查订单
	 * @author: LJZ
	 * @date: 2018年11月13日 上午10:37:54 
	 * @param scrapNo
	 * @return: String
	 */
	public String checkScrapOrderByPDA(@Param("scrapNo")String scrapNo);

	/**
	 * @title: checkScrapOrderLoc
	 * @description: 手持Scrap_ 检查用户是否有仓库扫描权限
	 * @author: LJZ
	 * @date: 2018年11月13日 上午10:38:00 
	 * @param scrapNo
	 * @param id
	 * @return: String
	 */
	public String checkScrapOrderLoc(@Param("scrapNo")String scrapNo, @Param("id")Long id);

	/**  
	* @Title: scanStatus  
	* @Description: 检测扫描状态
	* @author: ZhangLL
	* @param orno
	* @return long
	* @throws  
	*/
	public List<OdsScrapOrderDTO> scanStatus(@Param("orderNo") String orno);
	
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
	public int updateCostCenter(@Param("odsScrapOrder") OdsScrapOrderDTO dto);
	
}
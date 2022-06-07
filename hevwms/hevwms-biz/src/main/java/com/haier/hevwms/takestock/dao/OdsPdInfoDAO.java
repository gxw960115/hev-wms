package com.haier.hevwms.takestock.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.hevwms.takestock.domain.OdsPdInfo;

public interface OdsPdInfoDAO extends CommonDAO<OdsPdInfo, Long> {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfo> searchOdsPdInfos(
			@Param("pager") Pager<OdsPdInfo> pager,
			@Param("odsPdInfo") OdsPdInfo odsPdInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Long searchOdsPdInfosCount(@Param("odsPdInfo") OdsPdInfo odsPdInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfo> getListByParams(
			@Param("odsPdInfo") OdsPdInfo odsPdInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Integer updateOrderStatus(@Param("odsPdInfo") OdsPdInfo odsPdInfo);

    public String selectStocktakingOrderNo(@Param("dateString") String dateString);
    /**
     * 创建盘点单时应该验证当前plant,location下不应该存在没删除，没结束的盘点单
     * @param odsPdInfo
     * @return
     */
    public Integer quertPdCountByParam(@Param("odsPdInfo") OdsPdInfo odsPdInfo);
    
    /**  
    * @Title: checkPdNoExist  
    * @Description: 根据订单号检测是否存在进行中的订单信息
    * @author zhangll
    * @param inpara
    * @return String
    * @throws  
    */
    public String checkPdNoExist(@Param("inpara") OrderCheckInDTO inpara);
    
    /**  
    * @Title: checkPdLoc  
    * @Description: 验证用户是否有location的权限
    * @author zhangll
    * @param inpara
    * @param userId
    * @return String
    * @throws  
    */
    public String checkPdLoc(@Param("inpara") OrderCheckInDTO inpara, @Param("userId") Long userId);
}
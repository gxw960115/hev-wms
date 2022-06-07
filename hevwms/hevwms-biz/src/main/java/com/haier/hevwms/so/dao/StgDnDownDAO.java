package com.haier.hevwms.so.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StgDnDownDAO extends CommonDAO<StgDnDownDTO,Long>{
	
	void deleteAll(@Param("idList")List<Long> idList);
	
	/**
	 * 分页查询
	 */
	List<StgDnDownDTO> searchStgDnDownListByPage(@Param("pager") Pager<StgDnDownDTO> pager, @Param("stgDnDown") StgDnDownDTO stgDnDown);
	List<StgDnDownDTO> searchStgDnReverse(@Param("pager") Pager<StgDnDownDTO> pager, @Param("stgDnDown") StgDnDownDTO stgDnDown);

	/**
	 * 统计
	 */
	Long searchStgDnDownsCount(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	
	/**
	 * 条件查询
	 */
	List<StgDnDownDTO> getStgDnDownListByParam(@Param("stgDnDown") StgDnDownDTO stgDnDown);
	
    /**
     * 预留过账功能
     */
    void updateErrorNoNotSuc(@Param("stgDnDown") StgDnDownDTO stgDnDown);

	/**
	 * 预留过账功能
	 */
    void updatePostSuccess(@Param("stgDnDown") StgDnDownDTO stgDnDown);

	/**
	 * 手持SO_ 订单入库扫描检查
	 */
	String checkSoExist(@Param("inpara") OrderCheckInDTO dto);

	/**
	 * 手持SO_ 订单入库扫描检查
	 */
	String checkSoLoc(@Param("inpara") OrderCheckInDTO dto,@Param("userId") Long id);

	/**
	 * 手持SO_ 下载后回显
	 * @param orno
	 * @return
	 */
	List<OrderMatListDTO> getSoMaterialList(@Param("orderNo") String orno);

	/**
	 * 手持SO_ 订单sublimt时，FIFO获取物料列表，包括LOCATION和PLANT
	 */
	List<OrderMatListDTO> getSoMaterialListByFIFO(@Param("orderNo") String orno);

	/**
     * 以下为接口调用方法
     */
    /**
     * @title: bankupDeletedItems
     * @description: 对删除的数据进行备份
     * @author: LJZ
     * @date: 2018年10月11日 下午2:08:28
     */
    void bankupDeletedItems(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    
    void deleteByDnItems(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    
    List<StgDnDownDTO> getExistingDnItem(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    
    void updateByDnItem(@Param("stgDnDown") StgDnDownDTO stgDnDown);
    /**
     * @title: ifScanningStart
     * @description: 判断是否已经开始进行入库扫描
     * @author: LJZ
     * @date: 2018年10月11日 上午10:29:42
     */
    Long ifScanningStart(@Param("stgDnDown")StgDnDownDTO stgDnDown);

	/**
	 * 根据dnNo获取LocationName
	 * @param dnNo
	 * @return
	 */
	List<String> getLocationNameListByDnNo(@Param("dnNo") String dnNo);
    /**
     * @title: getSoItemsNoBySoNo
     * @description: 根据SONO获取行项目编号
     * @author: LJZ
     * @date: 2018年10月11日 上午10:23:45
     * @return: List<String>
     */
    List<String> getSoItemsNoBySoNo(@Param("stgDnDown")StgDnDownDTO stgDnDown);

    List<OrderDelDetialDTO> getFifoList(@Param("location") String location,@Param("materialNo")String materialNo);

	public void dnReverse(@Param("in")OrderIgpInDTO inpara,@Param("out") OrderIgpOutDTO out);

	/**
	 * @param pager
	 * @param stgDnDown
	 * @return
	 */
	public List<StgDnDownDTO> searchDirectDispatchDn(@Param("pager") Pager<StgDnDownDTO> pager, @Param("stgDnDown") StgDnDownDTO stgDnDown);

	/**
	 * @param stgDnDown
	 * @return
	 */
	public Long searchDirectDispatchDnCount(@Param("stgDnDown") StgDnDownDTO stgDnDown);

	/**
	 * 询数据下载来源
	 * @param orderNo
	 * @return
	 */
	public String getComeFromTMS(String orderNo);
}
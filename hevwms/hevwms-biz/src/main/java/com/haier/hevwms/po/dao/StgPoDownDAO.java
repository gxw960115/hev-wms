package com.haier.hevwms.po.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderMatListDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**
 * @ClassName: StgPoDownDAO
 * @Description: Po订单的Dao层
 * 
 */
public interface StgPoDownDAO extends CommonDAO<StgPoDownDTO, Long> {

    /**
     * @Title: searchStgPoDowns
     * @Description: 返回满足搜索条件的PO订单
     * @param @param pager
     * @param @param dto
     * @param @return
     * @return Pager<StgPoDownDTO>
     * @throws
     */
    public List<StgPoDownDTO> searchStgPoDowns(@Param("pager") Pager<StgPoDownDTO> pager,@Param("stgPoDown") StgPoDownDTO stgPoDown);

    /**
     * @Title: searchStgPoDownsCount
     * @Description: 返回Po订单的总数
     * @param @param stgPoDown
     * @param @return
     * @return Long
     * @throws
     */
    public Long searchStgPoDownsCount(@Param("stgPoDown") StgPoDownDTO stgPoDown);

    /**
     * @Title: deleteAll
     * @Description: 批量删除Po订单
     * @param @param idList
     * @return void
     * @throws
     */
    public void deleteAll(@Param("idList") List<Long> idList);

   /**
    * @Title: getStgPoDownByParam
    * @Description: 根据stgPoDown查询po信息
    * @param @param stgPoDown
    * @param @return
    * @return StgPoDownDTO
    * @throws
    */
    public StgPoDownDTO getStgPoDownByParam(@Param("stgPoDown") StgPoDownDTO stgPoDown);
 
    /**
    * @Title: getAllStgByInbound
    * @Description: inbound从sap下载采购订单
    * @param @return
    * @return List<StgPoDownDTO>
    * @throws
    */
    public List<StgPoDownDTO> getAllStgByInbound();
    
    
    public List<StgPoDownDTO> getPoItemByPoNo(@Param("poNo")String poNo);

    /**
    * @Title: getStgPoDownsByParam
    * @Description: 
    * @param @param stgPoDown
    * @param @return
    * @return List<StgPoDownDTO>
    * @throws
    */
    public List<StgPoDownDTO> getStgPoDownsByParam(@Param("stgPoDown") StgPoDownDTO stgPoDown);
    
    /**
     * 
    * @Title: getToDoChartsData
    * @Description: portal页面获得todo、postsuccess柱状图数据
    * @param @return
    * @return List<StgPoDownDTO>
    * @throws
     */
    public List<StgPoDownDTO> getToDoChartsData();
    
    public String checkPoExist(@Param("inpara") OrderCheckInDTO inpara);
    
    public String checkGiftPoExist(@Param("inpara") OrderCheckInDTO inpara);
    
    public String checkPoLoc(@Param("inpara") OrderCheckInDTO inpara, @Param("userId") Long userId);
    
    public List<StgPoDownDTO> getExistingPoItem(@Param("stgPoDown") StgPoDownDTO stgPoDown);
    
    public List<String> getPoItemsByPoNo(@Param("stgPoDown") StgPoDownDTO stgPoDown);
    
    public Long ifScanningStart(@Param("stgPoDown") StgPoDownDTO stgPoDown);
    
    public void bankupDeletedItems(@Param("stgPoDown") StgPoDownDTO stgPoDown);
    
    public void deleteByPoItems(@Param("stgPoDown") StgPoDownDTO stgPoDown);
    
    public void updateByPoItem(@Param("stgPoDown") StgPoDownDTO stgPoDown);
    
    public List<OrderMatListDTO> getPoMaterialList(@Param("orderNo") String orderNo);
    
    public void scanPoCheck(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);


}
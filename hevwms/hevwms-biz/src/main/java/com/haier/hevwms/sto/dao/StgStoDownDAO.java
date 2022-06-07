package com.haier.hevwms.sto.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StgStoDownDAO extends CommonDAO<StgStoDownDTO, Long> {

    /**
     * @param pager      分页插件
     * @param stgStoDown 条件
     * @title: searchStgStoDowns
     * @description: 分页条件查询
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月9日 上午10:06:53
     * @return: List<StgStoDownDTO>
     */
    public List<StgStoDownDTO> searchStgStoDowns(@Param("pager") Pager<StgStoDownDTO> pager,
                                                 @Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     *
     * @param pager
     * @param stgStoDnDTO
     * @return
     */
    public List<StgStoDnDTO> searchStgStoDn(@Param("pager") Pager<StgStoDnDTO> pager,
                                            @Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    /**
     * @param stgStoDown
     * @title: searchStgStoDownsCount
     * @description: 条件统计
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月9日 上午10:07:29
     * @return: Long
     */
    public Long searchStgStoDownsCount(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     *
     * @param stgStoDnDTO
     * @return
     */
    public Long searchStgStoDnCount(@Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    /**
     * @param idList
     * @title: deleteAll
     * @description: 通过多个ID删除多条数据
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月9日 上午10:07:43
     * @return: String
     */
    public String deleteAll(@Param("idList") List<Long> idList);

    /**
     * @param stgStoDown
     * @title: getStgStoDownByParam
     * @description: 根据stg查询stgstodown的信息（查看是否存在重复）
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月9日 上午10:06:28
     * @return: StgStoDownDTO
     */
    public StgStoDownDTO getStgStoDownByParam(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     * @param stgStoDown
     * @title: getListByParam
     * @description: 条件查询
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月9日 上午10:08:55
     * @return: List<StgStoDownDTO>
     */
    public List<StgStoDownDTO> getListByParam(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    public String updatePrescanByStoNo(@Param("stoNo") String stoNo);

    public void updateFinishQty(@Param("stoNo") String stoNo);

    public void cleanFinishQty(@Param("stoNo") String stoNo);

    public void closeStgStoDown(@Param("idList") String[] idList);

    public void openStgStoDown(@Param("idList") String[] idList);

    /**
     * @title: searchAllForStodnDown
     * 获取stg_sto_down表中最近一天的所有订单信息
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月9日 上午10:09:29
     * @return: List<StgStoDownDTO>
     */
    public List<StgStoDownDTO> searchAllForStodnDown();

    public int getStoByStodn(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     * @param @param  id
     * @param @return
     * @return int
     * @Title: updateStoConfirm
     * @Description: 更新sto审批标记
     */
    public int updateStoConfirm(@Param("stoNo") String stoNo);

    /**
     * @param stgStoDown
     * @title: getStoItemsByStoNo
     * @description: 根据StoNo获得STOItem编号列表
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月11日 下午4:36:49
     * @return: List<String>
     */
    public List<String> getStoItemsByStoNo(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     * @param stgStoDown
     * @title: ifScanningStart
     * 查询是否已经开始扫描
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月11日 下午4:37:50
     * @return: Long
     */
    public Long ifScanningStart(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     * @param stgStoDown
     * @title: bankupDeletedItems
     * @description: 备份删除的Item
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月11日 下午4:37:58
     * @return: void
     */
    public void bankupDeletedItems(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     * @param stgStoDown
     * @title: deleteByPoItems
     * @description: 删除STO
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月11日 下午4:38:04
     * @return: void
     */
    public void deleteByStoItems(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     * @param stgStoDown
     * @title: getExistingPoItem
     * @description: 获取是否存在StoItem
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月11日 下午4:45:18
     * @return: List<StgStoDownDTO>
     */
    public List<StgStoDownDTO> getExistingStoItem(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    /**
     * @param stgStoDown
     * @title: updateByPoItem
     * @description: 更新StoItem
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年10月11日 下午4:45:24
     * @return: void
     */
    public void updateByStoItem(@Param("stgStoDown") StgStoDownDTO stgStoDown);

    public String checkStoDeliveryExist(@Param("inpara") OrderCheckInDTO inpara);

    public String checkStoReceiveExist(@Param("inpara") OrderCheckInDTO inpara);

    public String checkStoDeliveryLoc(@Param("inpara") OrderCheckInDTO inpara, @Param("userId") Long userId);

    public String checkStoReceiveLoc(@Param("inpara") OrderCheckInDTO inpara, @Param("userId") Long userId);

    /**
     * 根据stoNo获取giLocation
     *
     * @param stoNo
     * @return
     * @author LJZ
     */
    List<String> getGiLocationNameListBySTONO(@Param("stoNo") String stoNo);

    /**
     * 根据stoNo获取grLocation
     *
     * @param stoNo
     * @return
     * @author LJZ
     */
    List<String> getGrLocationNameListBySTONO(@Param("stoNo") String stoNo);

    /**
     * 下载数据源查询
     * @param orderNo
     * @return
     */
    public String getComeFromTMS(String orderNo);
}
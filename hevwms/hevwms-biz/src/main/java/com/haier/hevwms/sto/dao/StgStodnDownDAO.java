package com.haier.hevwms.sto.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGiGrDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StgStodnDownDAO extends CommonDAO<StgStodnDownDTO, Long> {

    /**
     * @param pager
     * @param stgStodnDown
     * @title: searchStgStodnDowns
     * @description:
     * @author: LJZ
     * @date: 2018年11月15日 上午10:48:12
     * @return: List<StgStodnDownDTO>
     */
    public List<StgStodnDownDTO> searchStgStodnDowns(
            @Param("pager") Pager<StgStodnDownDTO> pager,
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param stgStodnDown
     * @title: searchStgStodnDownsCount
     * @description:
     * @author: LJZ
     * @date: 2018年11月15日 上午10:48:21
     * @return: Long
     */
    public Long searchStgStodnDownsCount(@Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param stgStodnDown
     * @return
     * @title: getStgStodnDownListByParm
     * @description: 条件查询
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月15日 上午11:28:07
     * @return: List<StgStodnDownDTO>
     */
    public List<StgStodnDownDTO> getStgStodnDownListByParm(
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param stgStodnDown
     * @title: getListByParam
     * @description:
     * @author: LJZ
     * @date: 2018年11月15日 上午10:49:11
     * @return: List<StgStodnDownDTO>
     */
    public List<StgStodnDownDTO> getListByParam(
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param stoDnNo
     * @title: updateFinishQty
     * @description:
     * @author: LJZ
     * @date: 2018年11月15日 上午10:49:25
     * @return: void
     */
    public void updateFinishQty(@Param("stoDnNo") String stoDnNo);

    /**
     * @param stoDnNo
     * @title: cleanFinishQty
     * @description:
     * @author: LJZ
     * @date: 2018年11月15日 上午10:49:32
     * @return: void
     */
    public void cleanFinishQty(@Param("stoDnNo") String stoDnNo);

    /**
     * @param stoDnNo
     * @title: updatePrescanByStoNo
     * @description:
     * @date: 2018年11月15日 上午10:49:40
     * @return: void
     */
    public void updatePrescanByStoNo(@Param("stoDnNo") String stoDnNo);

    /**
     * @param stgStodnDown
     * @title: updateStoDnDown
     * @description: add by linzx @20151207 下载STODN的时候更新操作
     * @return: void
     */
    public void updateStodnDown(
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    @Override
    public void save(@Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param stgStodnDown
     * @title: getStgStodnDowns2
     * @description: ？？
     * @author: LJZ
     * @date: 2018年11月15日 上午10:50:18
     * @return: List<StgStodnDownDTO>
     */
    public List<StgStodnDownDTO> getStgStodnDowns2(
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param stoDnNo
     * @title: updateErrorNoNotSuc
     * @description: ？？
     * @author: LJZ
     * @date: 2018年11月15日 上午10:50:27
     * @return: void
     */
    public void updateErrorNoNotSuc(@Param("stoDnNo") String stoDnNo);

    /**
     * @param stoDnNo
     * @param materialNo
     * @title: getStoDnCountByParam
     * @description: Sun Yanfei 根据stodn号和物料关联sto查询是否是来自9990工厂的sto
     * @author: 未知
     * @version: v1.0.0
     * @date: 2018年11月15日 上午10:52:44
     * @return: int
     */
    public int getStoDnCountByParam(@Param("stoDnNo") String stoDnNo,
                                    @Param("materialNo") String materialNo);

    /**
     * @param stgStodnDown
     * @return
     * @title: insertToStoDnDelete
     * @description:
     * @author: 未知
     * @version: v1.0.0
     * @date: 2018年11月15日 上午10:52:31
     * @return: int
     */
    public int insertToStoDnDelete(
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param @param stodnNo
     * @param @param stodnItemNo
     * @return void
     * @throws
     * @Title: insertstodnDeleteBystodn
     * @Description: 把删除的行项目插到stodn删除表
     */
    public void insertstodnDeleteBystodn(@Param("stodnNo") String stodnNo,
                                         @Param("stodnItemNo") String stodnItemNo);

    /**
     * @param @param stodnNo
     * @param @param stodnItemNo
     * @return void
     * @throws
     * @Title: deleteByStodnAndStodnItem
     * @Description: 删除行项目
     */
    public void deleteByStodnAndStodnItem(@Param("stodnNo") String stodnNo,
                                          @Param("stodnItemNo") String stodnItemNo);

    /**
     * @param @param  stodnNo
     * @param @param  stodnItemNo
     * @param @return
     * @return String
     * @throws
     * @Title: ifStartScan
     * @Description: 检查订单是否开始扫描
     */
    public int ifStartScan(@Param("stodnNo") String stodnNo,
                           @Param("stodnItemNo") String stodnItemNo);

    /**
     * @param stgStodnDown
     * @title: getStodnItems
     * @description: 根据stodn no 获取stodn items
     * @author: 未知
     * @version: v1.0.0
     * @date: 2018年11月15日 上午10:51:59
     * @return: List<String>
     */
    public List<String> getStodnItems(
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * @param stgStodnDown
     * @title: getStodnNos
     * @description: 根据sto no 获取stodnno
     * @author: 未知
     * @version: v1.0.0
     * @date: 2018年11月15日 上午10:52:15
     * @return: List<String>
     */
    public List<String> getStodnNos(
            @Param("stgStodnDown") StgStodnDownDTO stgStodnDown);

    /**
     * 根据stodnNo查询LocationName
     *
     * @param stodnNo
     * @return
     */
    List<String> getGrLocationNameListByStodnNo(@Param("stodnNo") String stodnNo);

    /**
     * 直发派遣列表查询
     * @param pager
     * @param stgStoDnDown
     * @return
     */
    public List<StgStodnDownDTO> searchStgStoDnDownsFromFactory(@Param("pager")Pager<StgStodnDownDTO> pager, @Param("stgStoDnDown")StgStodnDownDTO stgStoDnDown);
    /**
     * 直发派遣列表数量查询
     * @param stgStoDnDown
     * @return
     */
    public Long searchStgStoDnDownsFromFactoryCount(@Param("stgStoDnDown")StgStodnDownDTO stgStoDnDown);

    /**
     * STODN 保存
     * @param stgStoDnDTO
     */
    public void saveStoDn(@Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    /**
     * 根据物料查询物料描述
     * @param materialNo
     * @return
     */
    public String getMaterialDespByMaterialNo(@Param("materialNo") String materialNo);

    /**
     * 校验stodn是否存在
     * @param stoDnNo
     * @return
     */
    public Integer checkStodn(@Param("stoDnNo") String stoDnNo);

    /**
     *
     * @param stgStoDnDTO
     * @return
     */
    public Long searchStgStoDnCount(@Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    /**
     *
     * @param pager
     * @param stgStoDnDTO
     * @return
     */
    public List<StgStoDnDTO> searchStgStoDn(@Param("pager") Pager<StgStoDnDTO> pager,
                                            @Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    /**
     *
     * @param stgStoDnDTO
     * @return
     */
    public Long searchStoDnScanCount(@Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    /**
     *
     * @param pager
     * @param stgStoDnDTO
     * @return
     */
    public List<StgStoDnDTO> searchStoDnScan(@Param("pager") Pager<StgStoDnDTO> pager,
                                            @Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);


    /**
     *
     * @param stgStoDnDTO
     * @return
     */
    public Long searchPostDetailCount(@Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    /**
     *
     * @param pager
     * @param stgStoDnDTO
     * @return
     */
    public List<StgStoDnDTO> searchPostDetail(@Param("pager") Pager<StgStoDnDTO> pager,
                                            @Param("stgStoDnDTO") StgStoDnDTO stgStoDnDTO);

    public void stoDnGoodsDelivery(@Param("in") StgStoDnDTO in, @Param("out") InterfaceOutDTO out);


    public void stoDnGoodsReceive(@Param("in") StgStoDnDTO in, @Param("out") InterfaceOutDTO out);


    public void saveStodnGiGrInfo(@Param("in") StgStoDnDTO in, @Param("out") OrderGiGrDTO out);
}

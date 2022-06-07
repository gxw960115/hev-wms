package com.haier.hevwms.inventory.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Company 青鸟软通
 * @Title:库存dao层方法
 * @Package com.haier.hevwms.inventory.dao
 * @author sunhaoyu
 * @date 2015/10/27
 * @version V1.0
 */
public interface OdsInventoryInfoDAO extends
        CommonDAO<OdsInventoryInfoDTO, Long> {

    /**
     * @Title: searchOdsInventoryInfos
     * @Description: 查询所有库存
     * @param pager
     * @param odsInventoryInfo
     * @return List<OdsInventoryInfoDTO>
     * @throws
     */
    public List<OdsInventoryInfoDTO> searchOdsInventoryInfos(@Param("pager") Pager<OdsInventoryInfoDTO> pager,@Param("odsInventoryInfo") OdsInventoryInfoDTO odsInventoryInfo);

    /**
     * @Title: searchOdsInventoryInfosCount
     * @Description: 查询总数
     * @param odsInventoryInfo
     * @return Long
     * @throws
     */
    public Long searchOdsInventoryInfosCount(@Param("odsInventoryInfo") OdsInventoryInfoDTO odsInventoryInfo);

    /**
     * @Title: deleteAll
     * @Description:删除所有信息
     * @param @param idList
     * @return void
     * @throws
     */
    public void deleteAll(@Param("idList") List<Long> idList);

    /**
     * @Title: updateBySubMat
     * @Description: 更新信息
     * @param subLoction
     * @param matCode
     * @param amt
     * @return void
     * @throws
     */
    public void updateBySubMat(@Param("subLoction") String subLoction,
            @Param("matCode") String matCode, @Param("amt") Long amt);

    /**
     * @Title: getOdsInventoryInfoByParam
     * @Description: 有条件查询
     * @param odsInventoryInfo
     * @param
     * @return List<OdsInventoryInfoDTO>
     * @throws
     */
    public List<OdsInventoryInfoDTO> getOdsInventoryInfoByParam(
            @Param("odsInventoryInfo") OdsInventoryInfoDTO odsInventoryInfo);

    /**
     * @Title: updatePdFlag
     * @Description: 更新盘点标识
     * @param @param rowId
     * @param @param createBy
     * @return void
     * @throws
     */
    public void updatePdFlag(@Param("rowId") Long rowId,
            @Param("createBy") String createBy);

    /**
     * 
     * @Title: wmsQtyDetail
     * @Description:  (这里用一句话描述这个类的作用)
     * @param @param pager
     * @param @param odsInventoryInfo
     * @param @return
     * @return List<OdsInventoryInfoDTO>
     * @throws
     */
    public List<OdsInventoryInfoDTO> wmsQtyDetail(
            @Param("pager") Pager<OdsInventoryInfoDTO> pager,
            @Param("odsInventoryInfo") OdsInventoryInfoDTO odsInventoryInfo);

    /**
     * 
     * @Title: wmsQtyDetailCount
     * @Description:  (这里用一句话描述这个类的作用)
     * @param @param odsInventoryInfo
     * @param @return
     * @return Long
     * @throws
     */
    public Long wmsQtyDetailCount(
            @Param("odsInventoryInfo") OdsInventoryInfoDTO odsInventoryInfo);

    /**
     * @Title: insertInventory
     * @Description:  库存快照查询
     * @param
     * @return void
     * @throws
     */
    public void insertInventory();

}
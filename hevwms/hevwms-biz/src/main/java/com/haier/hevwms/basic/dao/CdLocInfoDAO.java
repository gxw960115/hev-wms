package com.haier.hevwms.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;


public interface CdLocInfoDAO extends CommonDAO<CdLocInfoDTO, Long> {

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<CdLocInfoDTO> searchCdLocInfos(
            @Param("pager") Pager<CdLocInfoDTO> pager,
            @Param("cdLocInfo") CdLocInfoDTO cdLocInfo);


    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public Long searchCdLocInfosCount(@Param("cdLocInfo") CdLocInfoDTO cdLocInfo);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public void deleteAll(@Param("idList") List<Long> idList);

    public void updateFlag(@Param("idList") List<Long> idList);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public CdLocInfoDTO getCdLocInfoById(@Param("rowId") Long rowId);


    /**
     * @discription 根据id查询
     * @author fanrong bu
     * @date 2015-11-25
     */
    public CdLocInfoDTO get(@Param("rowId") Long rowId);

    public List<CdLocInfoDTO> searchCdLocInfo();

    public List<CdLocInfoDTO> getCdLocInfosByParentIdIsNull(@Param("parentId") Long parentId);

    /**
     * 方法描述：不包含空
     *
     * @param
     * @return
     */
    public List<CdLocInfoDTO> getCdLocInfosByParentIdNotnull(
            @Param("parentId") Long parentId,
            @Param("locType") String locType);

    /**
     * 方法描述：根据 id 更新 父id
     *
     * @param
     * @return
     */
    public void updateParentId(@Param("parentId") Long parentId, @Param("idList") String[] idList);

    /**
     * @discription 根据id 和更新 父id
     * @author fanrong bu
     * @date 2015-12-2
     */
    public void updateParentId22(@Param("parentId") Long parentId, @Param("idList") List<Long> idList);

    /**
     * 方法描述：根据参数返回相应数据
     *
     * @param
     * @return
     */
    public List<CdLocInfoDTO> findCdLocByCityName(@Param("cdLocInfo") CdLocInfoDTO cdLocInfo);

    /**
     * 更新location信息
     *
     * @param cdLocInfo
     */
    public void updateById(@Param("cdLocInfo") CdLocInfoDTO cdLocInfo);


    /**
     * 查询单条location信息
     *
     * @param cdLocInfo
     * @return
     */
    public CdLocInfoDTO searchCdLocation(@Param("cdLocInfo") CdLocInfoDTO cdLocInfo);

    /**
     * @discription 根据code查询是否存在 记录
     * @author fanrong bu
     * @date 2015-11-26
     */
    public CdLocInfoDTO searchCdLocByCode(@Param("cdLocInfo") CdLocInfoDTO cdLocInfo);

    /**
     * @param @param  locationCode
     * @param @return
     * @return String
     * @throws
     * @Title: ifRepairLocation
     * @Description: 验证库位是否为修理位
     */
    public List<CdLocInfoDTO> searchCdLocationTree(@Param("parentId") long parentId, @Param("locType") String locType);

    /**
     * @param cdLocInfoDTO
     * @return List<CdLocInfoDTO>
     * @throws
     * @Title: searchCdPhyLocationTree
     * @Description: 根据类型获取库位
     * @author: ZhangLL
     */
    public List<CdLocInfoDTO> searchCdLocationTreeWithType(@Param("cdLocInfo") CdLocInfoDTO cdLocInfoDTO);

    public List<CdLocInfoDTO> searchCdLocationTreeWithLocation(@Param("cdLocInfo") CdLocInfoDTO cdLocInfoDTO);

    /**
     * @param @param  locationCode
     * @param @return
     * @return String
     * @throws
     * @Title: ifRepairLocation
     * @Description: 验证库位是否为修理位
     */
    public List<CdLocInfoDTO> searchCdPhyLocationTree(@Param("parentId") long parentId);

    /**
     * @param @param  locationCode
     * @param @return
     * @return String
     * @throws
     * @Title: ifRepairLocation
     * @Description: 验证库位是否为修理位
     */
    public String ifRepairLocation(@Param("locationCode") String locationCode
            , @Param("plantCode") String plantCode);

    /**
     * @param whCode
     * @return String
     * @description: 根据仓库编号查询库位列表
     */
    List<CdLocInfoDTO> findCdLocByWarehouse(@Param("whCode") String whCode);

    List<CdLocInfoDTO> getCdLocInfoListByCode(@Param("codes") String codes);

    /**
     * 获取location,作为页面Location查询条件
     *
     * @return
     * @author LJZ
     */
    List<CdLocInfoDTO> getCdLocInfoManyColumn(@Param("cdLocInfo") CdLocInfoDTO dto);

    String getTypeByCode(@Param("locCode") String locCode);
}
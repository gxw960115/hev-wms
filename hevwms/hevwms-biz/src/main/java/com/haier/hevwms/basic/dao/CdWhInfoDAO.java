package com.haier.hevwms.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;

public interface CdWhInfoDAO extends CommonDAO<CdWhInfoDTO, Long> {

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<CdWhInfoDTO> searchCdWhInfos(@Param("pager") Pager<CdWhInfoDTO> pager, @Param("cdWhInfo") CdWhInfoDTO cdWhInfo);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public Long searchCdWhInfosCount(@Param("cdWhInfo") CdWhInfoDTO cdWhInfo);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public void deleteAll(@Param("idList") List<Long> idList);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<Long> findCdUserWh(@Param("userType") String userType, @Param("userId") Long userId);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<Long> findCdUserLoc(@Param("userType") String userType, @Param("userId") Long userId);

    /**
     * 根据条件查询warehouse
     *
     * @param cdWhInfo
     * @return
     */
    public CdWhInfoDTO searchCdWh(@Param("cdWhInfo") CdWhInfoDTO cdWhInfo);

    /**
     * @discription 根据仓库code查询是否存在 记录
     * @author fanrong bu
     * @date 2015-11-26
     */
    public CdWhInfoDTO searchCdWhByCode(@Param("cdWhInfo") CdWhInfoDTO cdWhInfo);

    /**
     * @discription 更新有效标志
     * @author fanrong bu
     * @date 2015-11-27
     */
    public void updateWhFlag(@Param("idList") List<Long> idList);

    /**
     * @discription 获得最大的rowid
     * @author fanrong bu
     * @date 2015-12-2
     */
    public Long getMaxRowId();

    /**
     * @discription 查询所有实体库位
     * @author sjk
     * @date 2017-12-4
     */
    public List<CdWhInfoDTO> getAllPhysicalWh();

    /**
     * @param userId
     * @discription 查询可用仓库
     * @author sjk
     * @date 2017-12-4
     */
    public List<CdWhInfoDTO> findAvailableWhInfos(@Param("userId") Long userId);

    /**
     * 获取物料信息
     *
     * @param userId
     * @discription 查询可用仓库
     * @author sjk
     * @date 2017-12-4
     */
    public List<CdWhInfoDTO> findAvailablePhyWhInfos(@Param("userId") Long userId);
}
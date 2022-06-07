package com.haier.hevwms.sto.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className: OdsStoGigrInfoDAO.java
 * @description:
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月15日 下午2:16:13
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年11月15日		LJZ			v1.0.0			create
 */

public interface OdsStoGigrInfoDAO extends CommonDAO<OdsStoGigrInfoDTO, Long> {

    /**
     * 就用这个文件，在Mapper里补充。spring 配odsStoGiGrInfoDAO
     * <p>Title: searchOdsPoGrInfos</p>
     * <p>Description: </p>
     *
     * @param pager
     * @param odsStoGiGrInfo
     * @return
     */
    public List<OdsStoGigrInfoDTO> searchOdsStoGiGrInfos(
            @Param("pager") Pager<OdsStoGigrInfoDTO> pager,
            @Param("odsStoGigrInfo") OdsStoGigrInfoDTO odsStoGiGrInfo);

    /**
     * <p>Title: searchOdsPoGrInfosCount</p>
     * <p>Description: </p>
     *
     * @param odsStoGiGrInfo
     * @return
     */
    public Long searchOdsStoGiGrInfosCount(
            @Param("odsStoGigrInfo") OdsStoGigrInfoDTO odsStoGiGrInfo);

    /**
     * <p>Title: searchOdsStoDnGiGrInfosCount</p>
     * <p>Description: </p>
     *
     * @param odsStodnGigrInfo
     * @return
     */
    public Long searchOdsStoDnGiGrInfosCount(
            @Param("odsStodnGigrInfo") OdsStodnGigrInfoDTO odsStodnGigrInfo);

    /**
     * <p>Title: deleteAll</p>
     * <p>Description: </p>
     *
     * @param idList
     */
    public void deleteAll(@Param("idList") List<Long> idList);

    /**
     * <p>Title: searchList</p>
     * <p>Description: </p>
     *
     * @param odsStoGiGrInfo
     * @return
     */
    public List<OdsStoGigrInfoDTO> searchList(@Param("odsStoGigrInfo") OdsStoGigrInfoDTO odsStoGiGrInfo);

    /**
     * <p>Title: searchList</p>
     * <p>Description: </p>
     *
     * @param odsStodnGigrInfo
     * @return
     */
    public List<OdsStodnGigrInfoDTO> searchStoDnList(@Param("odsStodnGigrInfo") OdsStodnGigrInfoDTO odsStodnGigrInfo);

    /**
     * <p>Title: updatePostResult</p>
     * <p>Description: </p>
     *
     * @param odsStoGiGrInfo
     * @return
     */
    public void updatePostResult(@Param("odsStoGigrInfo") OdsStoGigrInfoDTO odsStoGiGrInfo);

    /**
     * <p>Title: updatePostResult</p>
     * <p>Description: </p>
     *
     * @param odsStoGiGrInfo
     * @return
     */
    public void updateDnPostResult(@Param("odsStoGigrInfo") OdsStoGigrInfoDTO odsStoGiGrInfo);

    /**
     * 根据orderNo修改
     * @param orderNo
     * @param vnptNo
     */
    public void updateByOrderNo(@Param("stodnNo") String stodnNo, @Param("materialDesp") String materialDesp, @Param("vnptNo") String vnptNo);
}


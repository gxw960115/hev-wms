package com.haier.hevwms.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

/**
 * 物料信息的dao层方法
 *
 * @author liujiazhen
 * @Description:
 * @Version: V1.00 （版本号）
 * @Create Date: 2015-10-15下午3:41:27
 */

public interface MdMatInfoDAO extends CommonDAO<MdMatInfoDTO, Long> {

    /**
     * 查询物料信息
     *
     * @param pager
     * @param mdMatInfo
     * @return List<MdMatInfoDTO>
     * @Title: searchMdMatInfos
     */
    public List<MdMatInfoDTO> searchMdMatInfos(
            @Param("pager") Pager<MdMatInfoDTO> pager,
            @Param("mdMatInfo") MdMatInfoDTO mdMatInfo);

    /**
     * 查询数据总数
     *
     * @param mdMatInfo
     * @return Long
     * @title: searchMdMatInfosCount
     */
    public Long searchMdMatInfosCount(@Param("mdMatInfo") MdMatInfoDTO mdMatInfo);

    /**
     * 删除所有
     *
     * @param idList
     * @Name: deleteAll
     * @Description: @param idList
     * @Author: sunhaoyu
     * @Create Date: 2015-10-15下午3:41:35
     */
    public void deleteAll(@Param("idList") List<Long> idList);

    /**
     * 根据参数查询物料信息
     *
     * @param mdMatInfo
     * @return List<MdMatInfoDTO>
     * @Title: getMdMatInfoByParam
     */
    public List<MdMatInfoDTO> getMdMatInfoByParam(@Param("mdMatInfo") MdMatInfoDTO mdMatInfo);

    /**
     * 检查物料是否存在
     *
     * @param materialNo
     * @return List<MdMatInfoDTO>
     * @Title: checkMdMatExists
     * @author: ZhangLL
     */
    public long checkMdMatExists(@Param("materialNo") String materialNo);

    /**
     * 根据物料号查询
     *
     * @param materialNo
     * @return MdMatInfoDTO
     * @Title: getMdMatInfoByMaterialNo
     */
    public MdMatInfoDTO getMdMatInfoByMaterialNo(@Param("materialNo") String materialNo);

    /**
     * 根据物料号查询该物料号存在否（不含本rowId的物料）
     *
     * @param mdMatInfo
     * @return MdMatInfoDTO
     * @Title: getCountByMaterialNoExceptSelf
     */
    public Long getCountByMaterialNoExceptSelf(@Param("mdMatInfo") MdMatInfoDTO mdMatInfo);

    /**
     * 根据物料号查询该物料号存在否（不含本rowId的物料）
     *
     * @param mdMatInfo
     * @return MdMatInfoDTO
     * @Title: getCountByMaterialNoExceptSelf
     */
    public int updateWithDivisionName(@Param("mdMatInfo") MdMatInfoDTO mdMatInfo);

    /**
     * <p>Title: bankupMat</p>
     * <p>Description: </p>
     *
     * @param mdMatInfo
     */
    public void bankupMat(@Param("mdMatInfo") MdMatInfoDTO mdMatInfo);
}
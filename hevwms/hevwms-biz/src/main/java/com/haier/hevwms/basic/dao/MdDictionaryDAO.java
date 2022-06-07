package com.haier.hevwms.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.basic.domain.MdDictionary;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCarList;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;

public interface MdDictionaryDAO extends CommonDAO<MdDictionary, Long> {

    /**
     * @param pager
     * @param mdDictionary
     * @title: searchMdDictionarys
     * @description: 分页查询
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月6日 下午1:52:13
     * @return: List<MdDictionary>
     */
    public List<MdDictionary> searchMdDictionarys(
            @Param("pager") Pager<MdDictionary> pager,
            @Param("mdDictionary") MdDictionary mdDictionary);

    /**
     * @param mdDictionary
     * @title: searchMdDictionarysCount
     * @description: 分页统计
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月6日 下午1:56:10
     * @return: Long
     */
    public Long searchMdDictionarysCount(@Param("mdDictionary") MdDictionary mdDictionary);

    /**
     * @param idList
     * @title: deleteAll
     * @description: 删除
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月6日 下午1:56:36
     * @return: void
     */
    public void deleteAll(@Param("idList") List<Long> idList);

    public List<MdDictionary> findAllKind();

    public List<MdDictionary> findAll(@Param("type") String type);

    public List<MdDictionary> getDictionaryByCodeOrName(@Param("code") String code, @Param("name") String name);

    public List<MdDictionary> getIfCodeOrNameExist(@Param("code") String code,
                                                   @Param("name") String name, @Param("id") Long id);

    /**
     * @param @param  sapOrderNo
     * @param @return
     * @return List<OtcwmsOrderCarList>
     * @Title: getTransporterOfSto
     * @Description: 获取sto发货的transporter
     */
    public List<WmsOrderCarList> getTransporterOfSto(@Param("sapOrderNo") String sapOrderNo);
}
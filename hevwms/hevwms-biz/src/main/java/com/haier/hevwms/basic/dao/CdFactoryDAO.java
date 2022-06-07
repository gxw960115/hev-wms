package com.haier.hevwms.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.basic.domain.CdFactory;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;

public interface CdFactoryDAO extends CommonDAO<CdFactory, Long> {
    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<CdFactory> searchCdFactorys(@Param("pager") Pager<CdFactory> pager, @Param("cdFactory") CdFactory cdFactory);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public Long searchCdFactorysCount(@Param("cdFactory") CdFactory cdFactory);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public void deleteAll(@Param("idList") List<Long> idList);

    /**
     * 查询所有的采购组织和工厂
     *
     * @return
     */
    public List<CdFactory> getAllFactoryAndSales();

    /**
     * @param begin
     * @param end
     * @return List<CdFactory>
     * @throws
     * @Title: getAllFactoryAndSales
     * @Description: po 自动任务 分批下载
     */
    public List<CdFactory> getAllFactoryAndSales2(@Param("begin") Long begin, @Param("end") Long end);

    /**
     * Edit 查询所有的采购组织和工厂（已不是原来的查询销售组织的功能了，功能同上getAllFactoryAndSales）
     *
     * @return
     */
    public List<CdFactory> getAllSales();

    /**
     * @param @param  begin
     * @param @param  end
     * @param @return
     * @return List<CdFactory>
     * @throws
     * @Title: getAllSales4
     * @Description: TODO sto自动任务 分批下载
     */
    public List<CdFactory> getAllSales4(@Param("begin") Long begin, @Param("end") Long end);

    /**
     * 原：查询所有的销售组织
     */
    public List<CdFactory> getAllSales2();

    /**
     *
     */
    public List<CdFactory> getAllSales3(@Param("begin") Long begin, @Param("end") Long end);
}
package com.haier.hevwms.basic.service;

import java.util.List;

import com.haier.hevwms.basic.domain.CdFactory;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.PlantDTO;

/**
 * @author liujiazhen
 */

public interface CdFactoryService {
    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public ExecuteResult<CdFactory> createCdFactory(CdFactory cdFactory);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public ExecuteResult<CdFactory> updateCdFactory(CdFactory cdFactory);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public ExecuteResult<CdFactory> deleteCdFactory(Long cdFactoryId);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public ExecuteResult<CdFactory> deleteCdFactoryAll(List<Long> idList);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<CdFactory> searchCdFactorys(Pager<CdFactory> pager, CdFactory cdFactory);


    /**
     * @discription 根据条件查询工厂信息
     * @author fanrong bu
     * @date 2015-12-24
     */
    public Pager<PlantDTO> searchCdFactorysByParams(Long page, Long rows, PlantDTO plantDTO);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public CdFactory getCdFactoryById(Long cdFactoryId);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<CdFactory> getCdFactorys();

    //public List<CdFactory> getCdFactorys(Long page,Long rows,PlantDTO plantDTO);

    /**
     * 根据查询条件返回查询结果 总数
     */
    public Long searchCdFactorysCount(CdFactory cdFactory);

}

package com.haier.hevwms.basic.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.haier.hevwms.basic.dao.CdFactoryDAO;
import com.haier.hevwms.basic.domain.CdFactory;
import com.haier.hevwms.basic.service.CdFactoryService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.PlantDTO;

/**
 * @author liujiazhen
 * @lassName: CdFactoryServiceImpl
 * @description: 业务逻辑层，处理具体的 工厂信息管理相关的 功能
 * @date 2015-10-30 下午3:05:18
 */
public class CdFactoryServiceImpl implements CdFactoryService {
    private CdFactoryDAO cdFactoryDAO;

    /**
     * <p>Title: createCdFactory</p>
     * <p>Description: 新增 工厂信息</p>
     *
     * @param cdFactory
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#createCdFactory(com.haier.hevwms.basic.domain.CdFactory)
     */
    @Override
    public ExecuteResult<CdFactory> createCdFactory(CdFactory cdFactory) {
        ExecuteResult<CdFactory> executeResult = new ExecuteResult<CdFactory>();
        // 新增工厂创建日期与修改日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        cdFactory.setCreatedDate(date);
        cdFactory.setModifyDate(date);
        cdFactoryDAO.save(cdFactory);
        executeResult.setResult(cdFactory);
        return executeResult;
    }

    /**
     * <p>Title: updateCdFactory</p>
     * <p>Description: 更新   工厂信息</p>
     *
     * @param cdFactory
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#updateCdFactory(com.haier.hevwms.basic.domain.CdFactory)
     */
    @Override
    public ExecuteResult<CdFactory> updateCdFactory(CdFactory cdFactory) {
        ExecuteResult<CdFactory> executeResult = new ExecuteResult<CdFactory>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        cdFactory.setModifyDate(format.format(new Date()));
        cdFactoryDAO.update(cdFactory);
        executeResult.setResult(cdFactory);
        return executeResult;
    }

    /**
     * <p>Title: deleteCdFactory</p>
     * <p>Description: 根据工厂编码， 删除 工厂信息</p>
     *
     * @param cdFactoryId
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#deleteCdFactory(java.lang.Long)
     */
    @Override
    public ExecuteResult<CdFactory> deleteCdFactory(Long cdFactoryId) {
        ExecuteResult<CdFactory> executeResult = new ExecuteResult<CdFactory>();

        cdFactoryDAO.delete(cdFactoryId);
        return executeResult;
    }

    /**
     * <p>Title: deleteCdFactoryAll</p>
     * <p>Description: 删除全部的工厂信息</p>
     *
     * @param idList
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#deleteCdFactoryAll(java.util.List)
     */
    @Override
    public ExecuteResult<CdFactory> deleteCdFactoryAll(List<Long> idList) {
        ExecuteResult<CdFactory> executeResult = new ExecuteResult<CdFactory>();

        cdFactoryDAO.deleteAll(idList);
        return executeResult;
    }
//	public Pager<CdFactory> searchCdFactorys(Pager<CdFactory> pager, CdFactory cdFactory){
//		List<CdFactory> cdFactorys = cdFactoryDAO.searchCdFactorys(pager, cdFactory);
//		long size = cdFactoryDAO.searchCdFactorysCount(cdFactory);
//		return Pager.cloneFromPager(pager, size, cdFactorys);
//	}

    /**
     * <p>Title: searchCdFactorys</p>
     * <p>Description: 查询 工厂信息 </p>
     *
     * @param pager
     * @param cdFactory
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#searchCdFactorys(com.haier.openplatform.util.Pager, com.haier.hevwms.basic.domain.CdFactory)
     */
    @Override
    public List<CdFactory> searchCdFactorys(Pager<CdFactory> pager, CdFactory cdFactory) {
        return cdFactoryDAO.searchCdFactorys(pager, cdFactory);
    }

    /**
     * <p>Title: searchCdFactorysCount</p>
     * <p>Description: 查询 所有工厂的是数量</p>
     *
     * @param cdFactory
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#searchCdFactorysCount(com.haier.hevwms.basic.domain.CdFactory)
     */
    @Override
    public Long searchCdFactorysCount(CdFactory cdFactory) {
        return cdFactoryDAO.searchCdFactorysCount(cdFactory);
    }

    /**
     * <p>Title: getCdFactoryById</p>
     * <p>Description: 通过 工厂编码 返回工厂信息 实体对象</p>
     *
     * @param cdFactoryId
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#getCdFactoryById(java.lang.Long)
     */
    @Override
    public CdFactory getCdFactoryById(Long cdFactoryId) {
        return cdFactoryDAO.get(cdFactoryId);
    }

    /**
     * <p>Title: getCdFactorys</p>
     * <p>Description: 返回工厂信息 实体对象 集合</p>
     *
     * @return
     * @see com.haier.hevwms.basic.service.CdFactoryService#getCdFactorys()
     */
    @Override
    public List<CdFactory> getCdFactorys() {
        return cdFactoryDAO.getAll();
    }

    /**
     * @param @param cdFactoryDAO
     * @return void
     * @throws
     * @Title: setCdFactoryDAO
     * @Description: setter方法
     */
    public void setCdFactoryDAO(CdFactoryDAO cdFactoryDAO) {
        this.cdFactoryDAO = cdFactoryDAO;
    }

    /**
     * @param @return
     * @return CdFactoryDAO
     * @throws
     * @Title: getCdFactoryDAO
     * @Description: getter方法
     */
    public CdFactoryDAO getCdFactoryDAO() {
        return cdFactoryDAO;
    }

    @Override
    public Pager<PlantDTO> searchCdFactorysByParams(Long page, Long rows,
                                                    PlantDTO plantDTO) {
        Pager<CdFactory> pager = new Pager<CdFactory>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);

        CdFactory cdFactory = new CdFactory();
        try {
            //将出入的DTO转成BIZ层使用的domain实体类
            BeanUtils.copyProperties(cdFactory, plantDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Pager<PlantDTO> pagerDTO = new Pager<PlantDTO>();
        List<CdFactory> factorylist = cdFactoryDAO.searchCdFactorys(pager, cdFactory);
        long totalSize = cdFactoryDAO.searchCdFactorysCount(cdFactory);
        List<PlantDTO> plantDTOList = new ArrayList<PlantDTO>();
        for (CdFactory md : factorylist) {
            PlantDTO dto = new PlantDTO();
            try {
                BeanUtils.copyProperties(dto, md);
                plantDTOList.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(plantDTOList);
        pagerDTO.setTotalRecords(totalSize);
        // return Pager.cloneFromPager(pDTO, totalSize, mdDictionaryDTOList);
        return pagerDTO;
    }


}

package com.haier.hevwms.basic.service.impl;

import com.haier.hevwms.basic.dao.CdBinDAO;
import com.haier.hevwms.basic.domain.CdBin;
import com.haier.hevwms.basic.service.CdBinService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.bin.dto.CdBinDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CdBinServiceImpl implements CdBinService {
    /**
     * 注入DAO
     */
    private CdBinDAO cdBinDao;
    public CdBinDAO getCdBinDao() {
        return cdBinDao;
    }
    public void setCdBinDao(CdBinDAO cdBinDao) {
        this.cdBinDao = cdBinDao;
    }

    /**
     * 分页查询
     * @param page rows
     * @param rows
     * @param cdBinDTO
     * @return
     */
    @Override
    public Pager<CdBinDTO> getBins(Long page, Long rows, CdBinDTO cdBinDTO) {

        Pager<CdBin> pager = new Pager<CdBin>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);

        CdBin cdbin = new CdBin();
        try {
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(cdbin, cdBinDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Pager<CdBinDTO> pagerDTO = new Pager<CdBinDTO>();
        List<CdBin> cdBinList = cdBinDao.getBins(pager, cdbin);
        long totalSize = cdBinDao.getBinsCount(cdbin);

        List<CdBinDTO> cdBinDTOList = new ArrayList<CdBinDTO>();
        for (CdBin md : cdBinList) {
            CdBinDTO dto = new CdBinDTO();
            try {
                BeanUtils.copyProperties(dto, md);
                cdBinDTOList.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(cdBinDTOList);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
    }

    @Override
    public ExecuteResult<CdBin> updateBin(CdBinDTO cdBinDTO) {
        ExecuteResult<CdBin> executeResult = new ExecuteResult<CdBin>();
        CdBin cdBin = new CdBin();
        try {
            BeanUtils.copyProperties(cdBin, cdBinDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        cdBinDao.update(cdBin);
        executeResult.setResult(cdBin);
        return executeResult;
    }

    /**
     * 新增保存
     * @param cdBinDTO
     * @return
     */
    @Override
    public ExecuteResult<CdBin> addBin(CdBinDTO cdBinDTO) {
        ExecuteResult<CdBin> executeResult = new ExecuteResult<CdBin>();


        String[] codes = cdBinDTO.getCode().split(",");
        for (int i = 0; i < codes.length; i++) {
            CdBin cdbin = new CdBin();
            try {
                BeanUtils.copyProperties(cdbin, cdBinDTO);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            cdbin.setCode(codes[i]);
            cdBinDao.save(cdbin);
        }
        executeResult.setResult(new CdBin());
        return executeResult;
    }

    @Override
    public ExecuteResult<CdBin> deleteBins(List<String> idList) {
        ExecuteResult<CdBin> executeResult = new ExecuteResult<CdBin>();
        cdBinDao.delete(idList);
        return executeResult;
    }

    @Override
    public Pager<CdBinDTO> getBinByLocation(Long page, Long rows, String location) {
        Pager<CdBinDTO> pager = new Pager<CdBinDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        List<CdBinDTO> cdBinList = cdBinDao.getBinByLocation(pager, location);
        long totalSize = cdBinDao.getBinByLocationCount(location);

        Pager<CdBinDTO> pagerDTO = new Pager<CdBinDTO>();
        pagerDTO.setRecords(cdBinList);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
    }

    @Override
    public Pager<CdBinDTO> getBinByCode(Long page, Long rows, String location,String code) {
        Pager<CdBinDTO> pager = new Pager<CdBinDTO>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);
        List<CdBinDTO> cdBinList = cdBinDao.getBinByCode(pager, location, code);
        long totalSize = cdBinDao.getBinByCodeCount(location, code);

        Pager<CdBinDTO> pagerDTO = new Pager<CdBinDTO>();
        pagerDTO.setRecords(cdBinList);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
    }
}

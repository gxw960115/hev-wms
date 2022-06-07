package com.haier.hevwms.basic.service;

import com.haier.hevwms.basic.domain.CdBin;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.bin.dto.CdBinDTO;

import java.util.List;

public interface CdBinService {
    /**
     * 分页查询
     * @param page rows
     * @param cdBinDTO
     * @return
     */
    public Pager<CdBinDTO> getBins(Long page, Long rows, CdBinDTO cdBinDTO);

    /**
     * 修改bin
     * @param cdBinDTO
     * @return
     */
    public ExecuteResult<CdBin> updateBin(CdBinDTO cdBinDTO);

    /**
     * 新增bin
     * @param cdBinDTO
     * @return
     */
    public ExecuteResult<CdBin> addBin(CdBinDTO cdBinDTO);

    /**
     * 删除bin
     * @param idList
     * @return
     */
    public ExecuteResult<CdBin> deleteBins(List<String> idList);

    public Pager<CdBinDTO> getBinByLocation(Long page, Long rows, String location);

    /**
     * 通过code模糊查询
     * @param page
     * @param rows
     * @param location
     * @param code
     * @return
     */
    public Pager<CdBinDTO> getBinByCode(Long page, Long rows, String location, String code);
}

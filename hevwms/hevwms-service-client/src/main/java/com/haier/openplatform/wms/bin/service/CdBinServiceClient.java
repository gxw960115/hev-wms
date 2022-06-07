package com.haier.openplatform.wms.bin.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.bin.dto.CdBinDTO;
import io.terminus.pampas.client.Export;

import java.util.List;

public interface CdBinServiceClient {
    /**
     * 分页查询
     * @param page
     * @param rows
     * @param CdBinDTO
     * @return
     */
    public Pager<CdBinDTO> getBins(Long page, Long rows, CdBinDTO CdBinDTO);

    /**
     * 新增
     * @param CdBinDTO
     * @return
     */
    @Export(paramNames = {"CdBinDTO"})
    public String addBin(CdBinDTO CdBinDTO);

    /**
     * 修改
     * @param CdBinDTO
     * @return
     */
    @Export(paramNames = {"CdBinDTO"})
    public String updateBin(CdBinDTO CdBinDTO);

    /**
     * 删除
     * @param idList
     */
    @Export(paramNames = {"idList"})
    public void deleteBins(List<String> idList);

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

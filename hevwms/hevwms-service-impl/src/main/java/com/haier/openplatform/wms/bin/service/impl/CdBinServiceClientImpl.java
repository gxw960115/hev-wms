package com.haier.openplatform.wms.bin.service.impl;

import com.haier.hevwms.basic.service.CdBinService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.bin.dto.CdBinDTO;
import com.haier.openplatform.wms.bin.service.CdBinServiceClient;

import java.util.List;

public class CdBinServiceClientImpl implements CdBinServiceClient {
    private CdBinService cdBinService;

    public CdBinService getCdBinService() {
        return cdBinService;
    }

    public void setCdBinService(CdBinService cdBinService) {
        this.cdBinService = cdBinService;
    }

    @Override
    public Pager<CdBinDTO> getBins(Long page, Long rows, CdBinDTO cdBinDTO) {
        return cdBinService.getBins(page,rows,cdBinDTO);
    }

    @Override
    public String addBin(CdBinDTO cdBinDTO) {
        try {
            cdBinService.addBin(cdBinDTO);
            return  "success";
        }catch (Exception e){
            return  "save failure,msg:"+e.getMessage();
        }


    }

    @Override
    public String updateBin(CdBinDTO cdBinDTO) {
        try {
            cdBinService.updateBin(cdBinDTO);
            return  "success";
        }catch (Exception e){
            return  "modify failure,msg:"+e.getMessage();
        }
    }

    @Override
    public void deleteBins(List<String> idList) {
            cdBinService.deleteBins(idList);
    }
    @Override
    public Pager<CdBinDTO> getBinByLocation(Long page, Long rows, String location) {
        return cdBinService.getBinByLocation(page, rows, location);
    }

    @Override
    public Pager<CdBinDTO> getBinByCode(Long page, Long rows, String location, String code) {
        return cdBinService.getBinByCode(page, rows, location, code);
    }
}

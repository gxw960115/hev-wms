package com.haier.hevwms.basic.dao;

import com.haier.hevwms.basic.domain.CdBin;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.bin.dto.CdBinDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdBinDAO extends CommonDAO<CdBin, String> {
    List<CdBin> getBins(@Param("pager") Pager<CdBin> pager,@Param("cdbin")  CdBin cdbin);

    long getBinsCount(@Param("cdbin") CdBin cdbin);

    void delete(@Param("idList") List<String> idList);

    List<CdBinDTO> getBinByLocation(@Param("pager") Pager<CdBinDTO> pager, @Param("location") String location);

    long getBinByLocationCount(@Param("location") String location);

    /**
     * 模糊查询BIN
     * @param pager
     * @param location
     * @param bin
     * @return
     */
    List<CdBinDTO> getBinByCode(@Param("pager") Pager<CdBinDTO> pager, @Param("location") String location, @Param("bin") String bin);

    long getBinByCodeCount(@Param("location") String location, @Param("bin") String bin);
}

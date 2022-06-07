package com.haier.hevwms.inventory.service;

import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;

import java.util.List;

public interface OdsInventoryInfoService {

    /**
     * @Title: searchOdsInventoryInfos
     * @Description: 查询所有库存信息
     * @param @param pager
     * @param @param odsInventoryInfo
     * @param @return
     * @return Pager<OdsInventoryInfoDTO>
     * @throws
     */
    public Pager<OdsInventoryInfoDTO> searchOdsInventoryInfos(Pager<OdsInventoryInfoDTO> pager,OdsInventoryInfoDTO odsInventoryInfo);

    /**
     * @Title: searchOdsInventoryInfos
     * @Description: 查询所有库存信息
     * @param @param pager
     * @param @param odsInventoryInfo
     * @param @return
     * @return Pager<OdsInventoryInfoDTO>
     * @throws
     */
//    public Pager<OdsInventoryInfoDtl> searchOdsInventoryBinInfos(Pager<OdsInventoryInfoDtl> pager, OdsInventoryInfoDtl odsInventoryInfoDtl);
    public Pager<OdsInventoryInfoDtlDTO> searchOdsInventoryBinInfos(Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

    public List<OdsInventoryInfoDtlDTO> searchOdsInventoryBinList(Pager<OdsInventoryInfoDtlDTO> pager,OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

    public List<OdsInventoryInfoDTO> getOdsInventoryInfoByParams(OdsInventoryInfoDTO dto);

    ExecuteResult<OdsPdDiffDtl> updateProcessDiff(OdsPdDiffDtl odsPdDiffDtl,
	    String ids);

    /**
     * 
     * @Title: wmsQtyDetail
     * @Description:  (这里用一句话描述这个类的作用)
     * @param @param pager
     * @param @param odsInventoryInfo
     * @param @return
     * @return Pager<OdsInventoryInfoDTO>
     * @throws
     */
    public Pager<OdsInventoryInfoDTO> wmsQtyDetail(
	    Pager<OdsInventoryInfoDTO> pager,
	    OdsInventoryInfoDTO odsInventoryInfo);

	public Long getExportAmount(OdsInventoryInfoDTO dto);

	public Long getExportBinAmount(OdsInventoryInfoDtlDTO dto);

    public void updateStocktakingDiffStatus(String id, String processFlag);
}

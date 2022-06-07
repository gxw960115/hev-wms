package com.haier.openplatform.wms.inventory.impl;

import com.haier.hevwms.inventory.service.OdsInventoryInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.InventoryInfoServiceClient;

import java.util.List;

/**
 * @Company 青鸟软通
 * @Title:查询库存dubbo实现类
 * @Package com.haier.openplatform.wms.inventory
 * @author sunhaoyu
 * @date 2015/10/28
 * @version V1.0
 */
public class SearchOdsInventoryInfoClientImpl implements InventoryInfoServiceClient {
    private OdsInventoryInfoService odsInventoryInfoService;

    /**
     * @Description: 属性 odsInventoryInfoService 的get方法
     * @return odsInventoryInfoService
     */
    public OdsInventoryInfoService getOdsInventoryInfoService() {
        return odsInventoryInfoService;
    }

    /**
     * @Description: 属性 odsInventoryInfoService 的set方法
     * 
     */
    public void setOdsInventoryInfoService(
            OdsInventoryInfoService odsInventoryInfoService) {
        this.odsInventoryInfoService = odsInventoryInfoService;
    }

    /**
     * Title: SearchOdsInventoryInfo Description:暴露接口库存查询方法
     * 
     * @param pager
     * @param odsInventoryInfoDTO
     * @return
     */
    @Override
    public Pager<OdsInventoryInfoDTO> searchOdsInventoryInfo(
            Pager<OdsInventoryInfoDTO> pager,
            OdsInventoryInfoDTO odsInventoryInfoDTO) {
        return odsInventoryInfoService.searchOdsInventoryInfos(pager,
                odsInventoryInfoDTO);
    }
    /**
     * Title: SearchOdsInventoryInfo Description:暴露接口库存查询方法
     *
     * @param pager
     * @param odsInventoryInfoDTO
     * @return
     */
    @Override
    public Pager<OdsInventoryInfoDtlDTO> searchOdsInventoryBinInfo(Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
        Pager<OdsInventoryInfoDtlDTO> pa = odsInventoryInfoService.searchOdsInventoryBinInfos(pager,odsInventoryInfoDtlDTO);
        return pa;
    }

    /* (非 Javadoc) 
    * <p>Title: searchOdsInventoryBinList</p> 
    * <p>Description: </p> 
    * @param row
    * @param page
    * @param odsInventoryInfoDtlDTO
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.InventoryInfoServiceClient#searchOdsInventoryBinList(long, long, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
    */
    @Override
    public List<OdsInventoryInfoDtlDTO> searchOdsInventoryBinList(long row,long page,OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {

        Pager<OdsInventoryInfoDtlDTO> pager = new Pager<OdsInventoryInfoDtlDTO>();
        pager.setCurrentPage(row);
        pager.setPageSize(page);
        List<OdsInventoryInfoDtlDTO> list = odsInventoryInfoService.searchOdsInventoryBinList(pager,odsInventoryInfoDtlDTO);
        return list;
    }

    /**
     * Title: getInventoryInfoByParams
     * Description:有条件查询
     * @param dto
     * @return
     */
    @Override
    public List<OdsInventoryInfoDTO> getInventoryInfoByParams(OdsInventoryInfoDTO dto) {
        // 参数查询
        return odsInventoryInfoService.getOdsInventoryInfoByParams(dto);
    }

    /**
     * 
    * <p>Title: wmsQtyDetail</p>
    * <p>Description: </p>
    * @param pager
    * @param odsInventoryInfoDTO
    * @return
    * @see com.haier.openplatform.wms.inventory.service.InventoryInfoServiceClient#wmsQtyDetail(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO)
     */
    @Override
    public Pager<OdsInventoryInfoDTO> wmsQtyDetail(
	    Pager<OdsInventoryInfoDTO> pager,
	    OdsInventoryInfoDTO odsInventoryInfoDTO) {
	return odsInventoryInfoService.wmsQtyDetail(pager,
                odsInventoryInfoDTO);
    }

	/* (非 Javadoc) 
	* <p>Title: getExportAmount</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.InventoryInfoServiceClient#getExportAmount(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO) 
	*/
	@Override
	public Long getExportAmount(OdsInventoryInfoDTO dto) {
		return odsInventoryInfoService.getExportAmount(dto);
	}
    
	/* (非 Javadoc) 
	* <p>Title: getExportBinAmount</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.InventoryInfoServiceClient#getExportBinAmount(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public Long getExportBinAmount(OdsInventoryInfoDtlDTO dto) {
		return odsInventoryInfoService.getExportBinAmount(dto);
	}

}
